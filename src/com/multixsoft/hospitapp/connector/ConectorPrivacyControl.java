/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.connector;

import static com.multixsoft.hospitapp.connector.ConectorServicio.URL_BASE;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import multixsoft.hospitapp.utilities.AESCipher;

/**
 *
 * @author maritza
 */
public class ConectorPrivacyControl {

    private final byte[] key = "instutomexsegsoc".getBytes();

    private static final ConectorPrivacyControl INSTANCE = new ConectorPrivacyControl();

    public static ConectorPrivacyControl getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param username
     * @param password
     * @return Returns a 1 if successful as an Admin Returns a 2 if successful
     * as a Doctor -1 if it fails
     */
    public int accessAsAdminOrDoctor(String username, String password) {
        int resultado = -1;

        byte[] encrypted = encrypt(password.getBytes(), key);
        String s = bytesToString(encrypted);
        System.err.println("Debug: Contraseña Encryp="+s);
        try {
            URL url;
            HttpURLConnection conexion;
            String urlBusqueda = URL_BASE + "privacycontrol/accessasadmindoctor?"
                    + "username=" + URLEncoder.encode(username, "UTF-8")
                    + "&password=" + URLEncoder.encode(s, "UTF-8");
            url = new URL(urlBusqueda);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "text/plain");

            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();

                resultado = Integer.parseInt(respuesta);
                entrada.close();
            }
        } catch (MalformedURLException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (IOException ioe) {
            System.err.println(ioe);
            ioe.printStackTrace();
        }
        System.out.println("Resultado de Log In=" + resultado);
        return resultado;
    }

    public byte[] encrypt(byte[] text, byte[] key) {
        try {
            return AESCipher.encrypt(key, key, text);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
                BadPaddingException ex) {
            System.err.println("Error durante el encriptado");
//            Logger.getLogger(PrivacyControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public byte[] decrypt(byte[] text, byte[] key) {
        try {
            return AESCipher.decrypt(key, key, text);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
                BadPaddingException ex) {
//            Logger.getLogger(PrivacyControl.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error durante el desencriptado");
        }
        return null;
    }

    public String bytesToString(byte[] bytes) {
        String data = "";
        for (int i = 0; i < bytes.length; i++) {
            data += bytes[i] + " ";
        }
        return data;
    }

    public byte[] getKey() {
        return key;
    }
    
    
}
