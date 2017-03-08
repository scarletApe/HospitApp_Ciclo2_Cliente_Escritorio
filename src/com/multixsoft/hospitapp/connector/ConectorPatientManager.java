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
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.entities.Patient;
import org.json.simple.JSONObject;
import static com.multixsoft.hospitapp.connector.ConectorServicio.URL_BASE;

/**
 *
 * @author maritza
 */
public class ConectorPatientManager {

    private static final ConectorPatientManager INSTANCE
            = new ConectorPatientManager();

    public static ConectorPatientManager getInstance() {
        return INSTANCE;
    }

    public String saveNewPatient(Patient patient) {

        Map<String, String> mapaDatos = new HashMap<String, String>();
        mapaDatos.put("nss", patient.getNss());
        mapaDatos.put("firstName", patient.getFirstName());
        mapaDatos.put("lastName", patient.getLastName());
        mapaDatos.put("address", patient.getAddress());
        mapaDatos.put("password", patient.getPassword());
        mapaDatos.put("isActive", Boolean.toString(patient.getIsActive()));

        /*Doctor doctor = patient.getDoctorUsername();
         Map<String, String> doctorMap = new HashMap<String, String>();
         doctorMap.put("username", doctor.getUsername());
         doctorMap.put("password", doctor.getPassword());
         doctorMap.put("firstName", doctor.getFirstName());
         doctorMap.put("lastName", doctor.getLastName());
         doctorMap.put("license", doctor.getLicense());
         doctorMap.put("specialty", doctor.getSpecialty());
         JSONObject doctorJson = new JSONObject(doctorMap);
         String doctorToSchedule = doctorJson.toJSONString();
         */
        JSONObject patientJson = new JSONObject(mapaDatos);
        String datosPatient = patientJson.toString();
        System.err.println("DEBUG DATOS PATIENT : " + datosPatient);
        //String datos = datosPatient.substring(0,datosPatient.length()-1)+",\"doctorUsername\":"+doctorToSchedule+"}";
        String datos = datosPatient;
        System.err.println("DEBUG DATOS : " + datos);
        String respuesta = null;

        try {
            String cadena = URL_BASE + "patientmanager/savepatient?patient="
                    + datos;
            String strRegUrl = cadena.replaceAll(" ", "%20");

            URL url = new URL(strRegUrl);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            System.err.println("DEBUG CONEXION: " + conexion.getURL());
            conexion.getURL();
            conexion.setRequestProperty("Accept", "text/plain");

            int codigo = conexion.getResponseCode();
            System.err.println("DEBUG : " + codigo + " " + conexion.getResponseMessage());
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
     * Es para desactivar a un paciente.
     */
    public boolean setInactivePatient(Patient p) {
        boolean resultado = false;
        try {
            String urlServicio = URL_BASE
                    + "patientmanager/makepatientinactive?patient=" + p.getNss();
            URL url = new URL(urlServicio);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "text/plain");
            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();
                entrada.close();
                if (respuesta.contains("t")) {
                    resultado = true;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return resultado;
    }
}
