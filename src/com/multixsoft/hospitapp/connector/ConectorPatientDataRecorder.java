/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import static com.multixsoft.hospitapp.connector.ConectorServicio.URL_BASE;
import com.multixsoft.hospitapp.entities.Appointment;
import com.multixsoft.hospitapp.entities.Report;
import org.json.simple.JSONValue;
import com.google.gson.*;
import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.entities.Patient;
import com.multixsoft.hospitapp.utilities.Date;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 *
 * @author Yonathan Alexander Martínez Padilla
 */
public class ConectorPatientDataRecorder {

    private static final ConectorPatientDataRecorder INSTANCE
            = new ConectorPatientDataRecorder();

    public static ConectorPatientDataRecorder getInstance() {
        return INSTANCE;
    }

    /**
     * Este metodo se encarga de obtener el reporte de una cita en específico
     *
     * @param a corresponde a la cita de la cual se desea obtener el reporte
     * @return una variable de tipo Report que contiene la información de la
     * cita
     */
    public Report getHistoryFromAppointment(Appointment a) {
        Report respuesta = null;
        try {
            String cadena = URL_BASE
                    + "patientdatarecorder/historyfromappointment?appointment="
                    + a.getIdAppointment();
            URL url = new URL(cadena);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.getURL();
            conexion.setRequestProperty("Accept", "text/plain");
            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String datos = entrada.readLine();
                JSONObject reportJson = (JSONObject) JSONValue.parse(datos);
                respuesta = new Report();
                respuesta.setIdReport(Long.parseLong(reportJson.get("idReport").toString()));
                respuesta.setDescription(reportJson.get("description").toString());
                respuesta.setMedicine(reportJson.get("medicine").toString());
                respuesta.setIndications(reportJson.get("indications").toString());
                respuesta.setPatientNss(new Gson().fromJson(reportJson.get("patientNss").toString(), Patient.class));
                respuesta.setIdAppointment((Appointment) reportJson.get("idAppointment"));
                entrada.close();
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

//    /**
//     * Este metodo se encarga de guardar el reporte de una cita en la Base de Datos
//     * envia al servidor el reporte para que posteriormente sea almacenado
//     * @param r coresponde al reporte a guardar en la base de datos
//     * @return una variable booleana que indica si el reporte pudo ser guardado con éxito o no
//     */
//    public boolean saveHistoryAppointment(Report r){
//        boolean resultado = false;
//        Map<String, String> reportMap = new HashMap<String, String>();
//        reportMap.put("idReport", Long.toString(r.getIdReport()));
//        reportMap.put("description", r.getDescription());
//        reportMap.put("medicine", r.getMedicine());
//        reportMap.put("indications", r.getIndications());
//        reportMap.put("patientNss", new Gson().toJson(r.getPatientNss()));
//        reportMap.put("appointment", new Gson().toJson(r.getIdAppointment()));
//        JSONObject reportJSON = new JSONObject(reportMap);
//        String datosReporte = reportJSON.toJSONString();
//        
//        datosReporte = datosReporte.replace("\\", "");
//        datosReporte = datosReporte.replace("\"{", "{");
//        datosReporte = datosReporte.replace("}\"", "}");
//         datosReporte = datosReporte.replace(" ","%20");
//        
//        System.out.println("Debug: datosReporte="+datosReporte);
//        try{
//            String cadena = URL_BASE + "patientdatarecorder/savereport?report=" 
//                    + datosReporte;
//            URL url = new URL(cadena);
//            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
//            conexion.getURL();
//            conexion.setRequestProperty("Accept", "text/plain");
//            int codigo = conexion.getResponseCode();
//            if (codigo == HttpURLConnection.HTTP_OK) {
//                InputStream is = conexion.getInputStream();
//                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
//                String datos = entrada.readLine();
//                entrada.close();
//                resultado = Boolean.parseBoolean(datos);
//            }
//        }catch(MalformedURLException ex){
//            ex.printStackTrace();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        return resultado;
//    }
    /**
     * Este metodo se encarga de guardar el reporte de una cita en la Base de
     * Datos envia al servidor el reporte para que posteriormente sea almacenado
     *
     * @param r coresponde al reporte a guardar en la base de datos
     * @return una variable booleana que indica si el reporte pudo ser guardado
     * con Èxito o no
     */
    public boolean saveHistoryAppointment(Report r) {
        boolean resultado = false;
        //
        Appointment appointment = r.getIdAppointment();

        Map<String, String> appointmentMap = new HashMap<String, String>();
        appointmentMap.put("idAppointment", appointment.getIdAppointment().toString());
        appointmentMap.put("time", appointment.getTime());
        Date date = appointment.getDate();
        int day = date.getDia();
        String dia=day+"";
        if(day<10){
            dia="0"+day;
        }
        int mes = date.getMes();
        String mesS=mes+"";
        if(mes<10){
            mesS="0"+mes;
        }

        int year = date.getYear();

        appointmentMap.put("date", year+"-"+mesS+"-"+dia+"T00:00:00-05:00");

        if(appointment.getIsFinished() != null){
            appointmentMap.put("isFinished", appointment.getIsFinished().toString());
        }
        if(appointment.getIscanceled() != null){
            appointmentMap.put("iscanceled", appointment.getIscanceled().toString());
        }

        Doctor doctorAppointment = appointment.getDoctorUsername();
        Map<String, String> doctorMap = new HashMap<String, String>();
        doctorMap.put("username", doctorAppointment.getUsername());
        doctorMap.put("password", doctorAppointment.getPassword());
        doctorMap.put("firstName", doctorAppointment.getFirstName());
        doctorMap.put("lastName", doctorAppointment.getLastName());
        doctorMap.put("license", doctorAppointment.getLicense());


        if(doctorAppointment.getSpecialty() != null){
            doctorMap.put("specialty", doctorAppointment.getSpecialty());
        }

        String docJSON = new JSONObject(doctorMap).toJSONString();
        appointmentMap.put("doctorUsername",docJSON);

        JSONObject appointmentJsonFirst = new JSONObject(appointmentMap);

        String appointmentToScheduleFirst = appointmentJsonFirst.toJSONString();
        appointmentToScheduleFirst = appointmentToScheduleFirst.replace("\\", "");
        appointmentToScheduleFirst= appointmentToScheduleFirst.replace("\"{", "{");
        appointmentToScheduleFirst = appointmentToScheduleFirst.replace("}\"", "}");
//        System.err.println(appointmentToScheduleFirst);



        Patient patient = appointment.getPatientNss();
        Map<String, String> patientMap = new HashMap<String, String>();
        patientMap.put("nss", patient.getNss());
        patientMap.put("password", patient.getPassword());
        patientMap.put("firstName", patient.getFirstName());
        patientMap.put("lastName", patient.getLastName());
        patientMap.put("address", patient.getAddress());
        patientMap.put("isActive", patient.getIsActive()+"");


        if(patient.getDoctorUsername() != null){
            Doctor patientDoctor = patient.getDoctorUsername();
            Map<String, String> patientDoctorMap = new HashMap<String, String>();
            patientDoctorMap.put("username", patientDoctor.getUsername());
            patientDoctorMap.put("password", patientDoctor.getPassword());
            patientDoctorMap.put("firstName", patientDoctor.getFirstName());
            patientDoctorMap.put("lastName", patientDoctor.getLastName());
            patientDoctorMap.put("license", patientDoctor.getLicense());
            if(doctorAppointment.getSpecialty() != null){
                patientDoctorMap.put("specialty", patientDoctor.getSpecialty());
            }


            String docPatientJSON = new JSONObject(patientDoctorMap).toJSONString();
            patientMap.put("doctorUsername", docPatientJSON);
        }

        JSONObject patientJson = new JSONObject(patientMap);
        String patientToSchedule = patientJson.toJSONString();

        appointmentMap.put("patientNss", patientToSchedule);

        JSONObject appointmentJson = new JSONObject(appointmentMap);
        
        Map<String, String> mapaReporte = new HashMap<>();
        mapaReporte.put("idReport", r.getIdReport()+"");
        mapaReporte.put("description", r.getDescription());
        mapaReporte.put("medicine", r.getMedicine());
        mapaReporte.put("indications", r.getIndications());
        
        mapaReporte.put("idAppointment", appointmentJson.toJSONString());
        mapaReporte.put("patientNss", patientJson.toJSONString());

//        String appointmentToSchedule = appointmentJson.toJSONString();
//        System.out.println("Cita en savehistory=" + cita.getDate().toString());
//
//        Gson gson = new Gson();
////            //Hacemos nulo el date en el appointment para generar el JSON
////        r.getIdAppointment().setDate(null);
//        //Generamos el JSON del appointment
//        String datosAppointment = gson.toJson(cita);
//        //Generamos un objeto JSON para aÒadir el Date
//        JSONObject appointment = (JSONObject) JSONValue.parse(datosAppointment);
//        //AÒadimos la fecha adecuada al appointment
//        Date fe = cita.getDate();
//        if (fe != null) {
//            appointment.put("date", fe.toFormattedString("YMD"));
//        } else {
//            System.out.println("Date is null!!!");
//        }
//        //Volvemos a generar el string del JSON
//        datosAppointment = appointment.toJSONString();
////            //Hacemos el appointment del reporte nulo
////        r.setIdAppointment(null);
//        //Generamos el JSON del reporte sin Appointment
//        String datosReporte = gson.toJson(r);
//        //Generamos un objeto JSON para agregar el Appointment que generamos en tmp
//        JSONObject objetoReport = (JSONObject) JSONValue.parse(datosReporte);
//        //Agregamos el JSON del appointment con la fecha precisa del Appointment
//        objetoReport.put("idAppointment", datosAppointment);
//        //Eliminamos los espacios en blanco de la cadena JSON del reporte
////        datosReporte = datosReporte.replace(" ", "%20");
//        Patient patient = cita.getPatientNss();
//        Map<String, String> mapaDatos = new HashMap<String, String>();
//        mapaDatos.put("nss", patient.getNss());
//        mapaDatos.put("firstName", patient.getFirstName());
//        mapaDatos.put("lastName", patient.getLastName());
//        mapaDatos.put("address", patient.getAddress());
//        mapaDatos.put("password", patient.getPassword());
//        mapaDatos.put("isActive", Boolean.toString(patient.getIsActive()));
//
//        Doctor doctor = patient.getDoctorUsername();
//        Map<String, String> doctorMap = new HashMap<String, String>();
//        doctorMap.put("username", doctor.getUsername());
//        doctorMap.put("password", doctor.getPassword());
//        doctorMap.put("firstName", doctor.getFirstName());
//        doctorMap.put("lastName", doctor.getLastName());
//        doctorMap.put("license", doctor.getLicense());
//        doctorMap.put("specialty", doctor.getSpecialty());
//        JSONObject doctorJson = new JSONObject(doctorMap);
//        String sdj = doctorJson.toJSONString();
//        
//        mapaDatos.put("doctorUsername", sdj);
//        
//        JSONObject patientJson = new JSONObject(mapaDatos);
//        objetoReport.put("patientNss", patientJson.toJSONString());
//
//        datosReporte = objetoReport.toJSONString();
//        //Eliminamos todas las diagonales de la cadena JSON del rewporte
//        datosReporte = datosReporte.replace("\\", "");
//        datosReporte = datosReporte.replace("\"{", "{");
//        datosReporte = datosReporte.replace("}\"", "}");

        String datosReporte = new JSONObject(mapaReporte).toJSONString();
        
        datosReporte = datosReporte.replace("\\", "");
        datosReporte= datosReporte.replace("\"{", "{");
        datosReporte = datosReporte.replace("}\"", "}");
        
        byte[] porEnviar = datosReporte.getBytes();
        System.out.println("Hay va********************************************");
        System.err.println(datosReporte);
        //
        try {
            String cadena = URL_BASE + "report";        
//            System.out.println("Url de save report=" + cadena);
            URL url = new URL(cadena);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
//            conexion.getURL();
//            conexion = (HttpURLConnection) url.openConnection();
            conexion.setDoOutput(true);

            conexion.setRequestMethod("POST");

            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setRequestProperty("Content-Length", Integer.toString(porEnviar.length));
            OutputStream os = conexion.getOutputStream();
            os.write(porEnviar);

            int codigo = conexion.getResponseCode();
            System.err.println("save repo response code=" + codigo);

            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String datos = entrada.readLine();
                entrada.close();
                resultado = Boolean.parseBoolean(datos);
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    /**
     * Este metodo se encarga de generar el siguiente id para el reporte de una
     * cita
     *
     * @return una variable de tipo long que contiene el id para el siguiente
     * reporte
     */
    public long getIdReportPlusOne() {
        long id = -1L;
        try {
            String cadena = URL_BASE + "patientdatarecorder/idreportplusone";
            URL url = new URL(cadena);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.getURL();
            conexion.setRequestProperty("Accept", "text/plain");
            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String datos = entrada.readLine();
                entrada.close();
                id = Long.parseLong(datos);
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }
}
