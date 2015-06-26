/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.multixsoft.hospitapp.connector.ConectorPatientManager;
import com.multixsoft.hospitapp.entities.Patient;

/**
 *
 * @author manuelmartinez
 */
public class TestDarDeBajaPaciente {

    public static void main(String[] args) {
        Patient p = new Patient();
        p.setNss("89378473849");
        p.setFirstName("Sebastian");
        p.setLastName("Lora");
        p.setAddress("klamath135@yahoo.com");
        p.setPassword("Password1");
        p.setIsActive(true);
//
//        System.out.println("El Paciente=" + p.toString());
//
        ConectorPatientManager pm = ConectorPatientManager.getInstance();
//        String saveNewPatient = pm.saveNewPatient(p);
//        if (saveNewPatient != null && !saveNewPatient.isEmpty()) {
//            System.out.println("Se creo el paciente");
//        } else {
//            System.out.println("No se creo el paciente");
//            return;
//        }

        boolean setInactivePatient = pm.setInactivePatient(p);

        if (setInactivePatient) {
            System.out.println("El paciente se puso a inactivo");
        } else {
            System.out.println("El paciente no se pudo inactivar.");
        }
    }
}
