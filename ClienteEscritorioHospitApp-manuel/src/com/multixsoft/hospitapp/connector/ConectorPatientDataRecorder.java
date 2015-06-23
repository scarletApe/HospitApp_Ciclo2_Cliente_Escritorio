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

/**
 *
 * @author Yonathan Alexander Martínez Padilla
 */
public class ConectorPatientDataRecorder{
    
    private static final ConectorPatientDataRecorder INSTANCE = 
            new ConectorPatientDataRecorder();
    
    public static ConectorPatientDataRecorder getInstance() {
        return INSTANCE;
    }
    
    /**
     * Este metodo se encarga de obtener el reporte de una cita en específico
     * @param a corresponde a la cita de la cual se desea obtener el reporte
     * @return una variable de tipo Report que contiene la información de la cita
     */
    public Report getHistoryFromAppointment(Appointment a){
        Report respuesta = null;
        try{
            String cadena = URL_BASE + 
                    "patientdatarecorder/historyfromappointment?appointment=" 
                    + a.getIdAppointment();
            URL url = new URL(cadena);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.getURL();
            conexion.setRequestProperty("Accept", "text/plain");
            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK){
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String datos = entrada.readLine();
                JSONObject reportJson = (JSONObject) JSONValue.parse(datos);
                respuesta = new Report();
                respuesta.setIdReport(Long.parseLong(reportJson.get("idReport").toString()));
                respuesta.setDescription(reportJson.get("description").toString());
                respuesta.setMedicine(reportJson.get("medicine").toString());
                respuesta.setIndications(reportJson.get("indications").toString());
                respuesta.setPatientNss(reportJson.get("patientNss").toString());
                respuesta.setIdAppointment((Appointment)reportJson.get("idAppointment"));
                entrada.close();
            }
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return respuesta;
    }

    /**
     * Este metodo se encarga de guardar el reporte de una cita en la Base de Datos
     * envia al servidor el reporte para que posteriormente sea almacenado
     * @param r coresponde al reporte a guardar en la base de datos
     * @return una variable booleana que indica si el reporte pudo ser guardado con éxito o no
     */
    public boolean saveHistoryAppointment(Report r){
        boolean resultado = false;
        Map<String, String> reportMap = new HashMap<String, String>();
        reportMap.put("idReport", Long.toString(r.getIdReport()));
        reportMap.put("description", r.getDescription());
        reportMap.put("medicine", r.getMedicine());
        reportMap.put("indications", r.getIndications());
        reportMap.put("patientNss", r.getPatientNss());
        reportMap.put("appointment", Long.toString(r.getIdAppointment().getIdAppointment()));
        JSONObject reportJSON = new JSONObject(reportMap);
        String datosReporte = reportJSON.toJSONString();
        try{
            String cadena = URL_BASE + "patientdatarecorder/savereport?report=" 
                    + datosReporte;
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
                resultado = Boolean.parseBoolean(datos);
            }
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return resultado;
    }
    
    /**
     * Este metodo se encarga de generar el siguiente id para el reporte de una cita
     * @return una variable de tipo long que contiene el id para el siguiente reporte
     */
    public long getIdReportPlusOne(){
        long id = -1L;
        try{
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
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return id;
    }
}