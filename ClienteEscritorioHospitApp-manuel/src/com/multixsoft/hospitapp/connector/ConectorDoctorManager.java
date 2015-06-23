
package com.multixsoft.hospitapp.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.entities.Schedule;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import static com.multixsoft.hospitapp.connector.ConectorServicio.URL_BASE;
import com.multixsoft.hospitapp.entities.Appointment;
import com.multixsoft.hospitapp.entities.Patient;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

/**
 *
 * @author maritza
 */
public class ConectorDoctorManager {
    
    private static final ConectorDoctorManager INSTANCE = 
            new ConectorDoctorManager();
    
    public static ConectorDoctorManager getInstance() {
        return INSTANCE;
    }
    
    public String saveNewDoctor(Doctor doctor) {
        Map<String, String> mapaDatos = new HashMap<String, String>();
        
        /* Se ha cambiado el nombre de los atributos desde la notación
        existente en la base de datos a la de las entidades actuales
        Ej: de first_name --> firstName */
        mapaDatos.put("username", doctor.getUsername());
        mapaDatos.put("firstName", doctor.getFirstName());
        mapaDatos.put("lastName", doctor.getLastName());
        mapaDatos.put("license", doctor.getLicense());
        mapaDatos.put("specialty", doctor.getSpecialty());
        mapaDatos.put("password", doctor.getPassword());
        
        JSONObject objectFromMap = new JSONObject(mapaDatos);
        String datos = objectFromMap.toString();
        
        String respuesta = null;

        /* Se elimino la cadena URLEncoder(datos) y reemplazo sólo por datos 
        ya que regresaba una cadena irreconocible para los servicios */
        try {
            String cadena = URL_BASE + "doctormanager/savenewdoctor?doctor="
                    + datos;
            
            URL url = new URL(cadena);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "text/plain");

            int codigo = conexion.getResponseCode();
            System.err.println("DEBUG : "+codigo);
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                respuesta = entrada.readLine();
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException e) { 
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public String setSchedule(Schedule schedule) {
        Map<String, String> mapaDatos = new HashMap<String, String>();
        
        Doctor doctor = schedule.getDoctorUsername();
        
        /* Dado que originalmente la entidad Schedule de manuel consideraba
        al username del Doctor como un String, fue necesario cambiarlo
        para agregar la representación del doctor a la ruta del servicio
        por lo que a continuación se obtienen sus atributos con el proposito
        de formar su representación JSON*/
        Map<String, String> doctorMap = new HashMap<String, String>();
        doctorMap.put("username", doctor.getUsername());
        doctorMap.put("password", doctor.getPassword());
        doctorMap.put("firstName", doctor.getFirstName());
        doctorMap.put("lastName", doctor.getLastName());
        doctorMap.put("license", doctor.getLicense());
        doctorMap.put("specialty", doctor.getSpecialty());
        
        mapaDatos.put("idSchedule", Long.toString(schedule.getIdSchedule()));
        
        JSONObject doctorJson = new JSONObject(doctorMap);
        String doctorToSchedule = doctorJson.toJSONString();
        
        mapaDatos.put("monday", schedule.getMonday());
        mapaDatos.put("tuesday", schedule.getTuesday());
        mapaDatos.put("wednesday", schedule.getWednesday());
        mapaDatos.put("thursday", schedule.getThursday());
        mapaDatos.put("friday", schedule.getFriday());

        JSONObject scheduleJson = new JSONObject(mapaDatos);
        String datosSchedule = scheduleJson.toString();
        
       /* Problema al tratar de añadir la representación JSON de un doctor
        si se añade directamente al mapaDatos el string doctorToSchedule
        obtenemos una cadena no válida para los servicios, por lo que 
        a continuación se obtiene los datos del Schedule sin incluir la
        llave de cierre y se concatenan los datos del doctor añadiendo la
        llave de cierre para completar la cadena*/
        String datos = datosSchedule.substring(0,datosSchedule.length()-1)+",\"doctorUsername\":"+doctorToSchedule+"}";
        String respuesta = null;

        try {
            /* Se elimino la cadena URLEncoder(datos) y reemplazo sólo por datos 
        ya que regresaba una cadena irreconocible para los servicios */
            String cadena = URL_BASE + "doctormanager/setschedule?schedule="
                    + datos;
            String strRegUrl = cadena.replaceAll(" ", "%20");
            URL url = new URL(strRegUrl);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "text/plain");

            int codigo = conexion.getResponseCode();
            System.out.println("Codigo Recibido="+codigo);
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                respuesta = entrada.readLine();
            }

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    
    /**
     * Este metodo se encarga de inhabilitar a un doctor en el hospital, no lo
     * elimina de la base de datos ya que implica eliminar antes todas sus relaciones
     * y eso afectaria al momento de tratar de generar el historial. Primero cancela 
     * todas las citas pendientes para el y despúes vuelve nulo el campo de doctor
     * de todos los pacientes, además vuelve nulo el horario asignado y al final
     * inhabilita al doctor.
     * @param d corresponde al doctor a inhabilitar
     * @return una variable booleana que indica si gue posible o no inhabilitar al
     * doctor en el sistema
     */
    public boolean deleteDoctor(Doctor d){
        ConectorScheduleManager csm = ConectorScheduleManager.getInstance();
        List listAppointments = csm.getAllAppointmentsFor(d);
        List listPatients = getPatientsFor(d);
        //cancelar todas las citas pendientes del doctor
        if(listAppointments != null){
            for (Object a : listAppointments) {
                Appointment tmp = (Appointment) a;
                csm.cancelAppointment(tmp);
            }
        }
        //Volver nula la variable de doctor en todos los pacientes de ese doctor
        if(listPatients != null){
                for (Object p : listPatients) {
                    Patient tmp = (Patient) p;
                    tmp.setDoctorUsername(null);
                }
        }
        //Eliminar el horario del doctor
            //Obtener Schedule a partir del username de un doctor
        Schedule scheduleDoc = csm.getAvailableSchedule(d, true);
            //Eliminar ese schedule
        if(deleteScheduleOfDoctor(scheduleDoc)){
            //Modificar la variable de isActive del doctor
            if(setInactiveDoctor(d)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Este metodo obtiene todos los pacientes de la base de datos que correspondan 
     * a un doctor en particular
     * @param d corresponde al medico del que se desean obtener los pacientes
     * @return una lista que contiene todos los pacientes del medico en específico
     */
    private List<Patient> getPatientsFor(Doctor d){
        ConectorScheduleManager csm = ConectorScheduleManager.getInstance();
        List<Patient> patients = null;
        try{
        String urlBusqueda = URL_BASE + "doctormanager/patientsfor?"+
                URLEncoder.encode(d.getUsername(),"UTF-8");
        URL url = new URL(urlBusqueda);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "text/plain");
            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();
                Object objectPatients = JSONValue.parse(respuesta);
                JSONArray patientsList = (JSONArray) objectPatients;
                patients = new ArrayList<Patient>();
                for (Object elem : patientsList) {
                    JSONObject patientJson = (JSONObject) elem;
                    Patient patient = new Patient();
                    patient.setNss((String)patientJson.get("nss"));
                    patient.setPassword((String)patientJson.get("password"));
                    patient.setFirstName((String)patientJson.get("firstName"));
                    patient.setAddress((String)patientJson.get("address"));
                    patient.setIsActive((Boolean)patientJson.get("isActive"));
                    patient.setDoctorUsername(doctorFromJson((JSONObject)patientJson.get("doctorUsername")));
                    patients.add(patient);
                }
                entrada.close();
            }
        }catch(UnsupportedEncodingException uee){
                uee.printStackTrace();
        }catch(MalformedURLException murle){
            murle.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return patients;
    }
    
    /**
     * Este metodo obtiene una variable de tipo Doctor desde un objeto JSON
     * @param doctorJson corresponde a la variable JSON que contiene al Doctor
     * @return una variable de tipo Doctor con la información de un Doctor
     */
    private Doctor doctorFromJson(JSONObject doctorJson) {
        Doctor doctor = new Doctor();
        if (doctorJson != null) {
            doctor.setUsername(doctorJson.get("username").toString());
            doctor.setFirstName(doctorJson.get("firstName").toString());
            doctor.setLastName(doctorJson.get("lastName").toString());
            doctor.setPassword(doctorJson.get("password").toString());
            doctor.setLicense(doctorJson.get("license").toString());

            if (doctorJson.get("specialty") != null) {
                doctor.setSpecialty(doctorJson.get("specialty").toString());
            }
        }
        return doctor;
    }
    
    
    /**
     * Este metodo permite eliminar la relacion de un horario con un doctor
     * @param schedule crresponde al horario que se eliminará
     * @return una variable booleana que indica si el horario se puedo eliminar o no
     */
    private boolean deleteScheduleOfDoctor(Schedule schedule){
        boolean resultado = false;
        try{
            String urlServicio = URL_BASE + 
                    "doctormanager/removescheduleofdoctor?schedule="+schedule.getIdSchedule();
            URL url = new URL(urlServicio);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "text/plain");
            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();
                entrada.close();
                if(respuesta.contains("t")){
                    resultado = true;
                }
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return resultado;
    }
    
    /**
     * Este metodo se encarga de hacer que un doctor esté inactivo en el hospital
     * @param d representa al doctor que se volverá inactivo
     * @return  una variable booleana que indica si se pudo realizar la acción o no
     */
    private boolean setInactiveDoctor(Doctor d){
        boolean resultado = false;
        try{
            String urlServicio = URL_BASE + 
                    "doctormanager/makedoctorinactive?doctor" + d.getUsername();
            URL url = new URL(urlServicio);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "text/plain");
            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();
                entrada.close();
                if(respuesta.contains("t")){
                    resultado = true;
                }
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return resultado;
    }
}
