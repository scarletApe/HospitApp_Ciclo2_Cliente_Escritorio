/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.utilities;

/**
 *
 * @author manuelmartinez
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by maritza on 3/06/15.
 */
public class Validator {
    Pattern pattern;
    Matcher matcher;

    private final String emailValidation = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String firstNameValidation = "[A-ZÁÉÍÓÚÑ][a-záéíóúñA-ZÁÉÍÓÚÑ_ ]*";
    private final String lastNameValidation = "[A-ZÁÉÍÓÚÑ][a-záéíóúñA-ZÁÉÍÓÚÑ_ ]*";//"[a-záéíóúA-zÁÉÍÓÚ]+([ '-][a-záéíóúA-ZÁÉÍÓÚ]+)*";
    private final String passwordValidation ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    private final String nssValidation ="^[0-9][\\-\\d]*(\\d+)$";

    
    private static final Validator INSTANCE = new Validator();

    public static Validator getInstance() {
        return INSTANCE;
    }
    
    public boolean isValidEmail(String email){
        pattern = Pattern.compile(emailValidation);
        matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean isValidFirstName(String firstName){
        return firstName.matches(firstNameValidation)&& firstName.length()>2 && firstName.length()<100;
    }

    public boolean isValidLastName(String lastName){
        return lastName.matches(lastNameValidation) && lastName.length()>2 && lastName.length()<100;
    }

	/* Se busca una contraseña que incluya de 6 a 20 caracteres,
	 * una letra en mayúscula y una en minúscula,
	 * y un número para asegurarse de que la contraseña sea segura*/

    public boolean isValidPassword(String password){
        return password.matches(passwordValidation);
    }

    public boolean isValidNss(String nss){

        return nss.matches(nssValidation) && splittingNumbers(nss) == 11;
    }

    private static int splittingNumbers(String nss){
        int numberDigits = 0;
        for (int i = 0; i < nss.length(); i++)
        {
            char c = nss.charAt(i);
            if (Character.isDigit(c))
            {
                numberDigits++;
            }
        }
        return numberDigits;
    }




}
