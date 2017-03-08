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
import java.net.URLEncoder;
import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.entities.Patient;
import static com.multixsoft.hospitapp.connector.ConectorServicio.URL_BASE;

/**
 *
 * @author maritza
 */
public class ConectorPatientMapper {
      
    private static final ConectorPatientMapper INSTANCE = new ConectorPatientMapper();
    
     public static ConectorPatientMapper getInstance() {
        return INSTANCE;
    }
     
     public boolean mapPatient(Patient patient, Doctor doctor) {
        boolean resultado = false;
        try {
            String cadena = URL_BASE + "patientmapper/mappatient?"
                    + "nss=" + URLEncoder.encode(patient.getNss(), "UTF-8")
                    + "&username=" + URLEncoder.encode(doctor.getUsername(), "UTF-8");

            URL url = new URL(cadena);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "text/plain");

            int codigo = conexion.getResponseCode();
           
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();
                
                resultado = Boolean.parseBoolean(respuesta);

            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
