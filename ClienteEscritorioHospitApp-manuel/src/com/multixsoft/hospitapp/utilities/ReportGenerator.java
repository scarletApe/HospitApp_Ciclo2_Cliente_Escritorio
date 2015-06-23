/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.multixsoft.hospitapp.utilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.multixsoft.hospitapp.entities.Report;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Calendar;

/**
 *
 * @author Yonathan Alexander Martínez Padilla
 */
public class ReportGenerator {
    private String pathPDF = "";
    private Document reporte;
    private DateFormat formatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
    
    /**
     * Constructor de la clase ReportGenerator
     * @param path representa la ruta donde se guardara el reporte generado
     */
    public ReportGenerator(String path){
        pathPDF = path;
    }
    
    /**
     * Metodo que crea el reporte, lo inicializa y manda llamar a un metodo que lo llene de información
     * @param r representa al reporte que será generado
     * @return una variable booleana que indica si el reporte se pudo crear con éxito o no
     */
    public boolean createReport(Report r){
        boolean resultado = false;
        try {
            reporte = new Document();
            PdfWriter.getInstance(reporte, new FileOutputStream(pathPDF));
            resultado = addInformation(r.getIdAppointment().getPatientNss().getFirstName()
                    , r.getIdAppointment().getPatientNss().getLastName()
                    , r.getIdAppointment().getDoctorUsername().getFirstName()
                    , r.getIdAppointment().getDate(), r.getDescription(), r.getMedicine()
                    , r.getIndications());
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (DocumentException de) {
            de.printStackTrace();
        }
        return resultado;
    }
    
    /**
     * Este metodo añade la información al reporte que se generará
     * @param firstName contiene el nombre del paciente de la cita del reporte
     * @param lastName contiene el apellido del paciente de la cita del reporte
     * @param username contiene el nombre del doctor de la cita del reporte
     * @param date contiene la fecha de la cita del reporte
     * @param description contiene la descripción de la cita del reporte
     * @param medicine contiene los medicamentos de la cita del reporte
     * @param indications contiene las indicaciones de la cita del reporte
     * @return 
     */
    private boolean addInformation(String firstName, String lastName, String username, 
            Date date, String description, String medicine, String indications) {
        boolean resultado = false;
        Paragraph parrafo;
        try{
            reporte.open();
            parrafo = new Paragraph("REPORTE DE CITA");
            parrafo.setAlignment(parrafo.ALIGN_CENTER);
            reporte.add(parrafo);
            reporte.addProducer();
            parrafo = new Paragraph(" ");
            reporte.add(parrafo);
            parrafo = new Paragraph("Fecha de consulta: " + obtainFormatedDate(date));
            parrafo.setAlignment(parrafo.ALIGN_LEFT);
            reporte.add(parrafo);
            parrafo = new Paragraph(" ");
            reporte.add(parrafo);
            parrafo = new Paragraph("Doctor: " + username);
            parrafo.setAlignment(parrafo.ALIGN_LEFT);
            reporte.add(parrafo);
            parrafo = new Paragraph(" ");
            reporte.add(parrafo);
            parrafo = new Paragraph("Paciente: " + firstName + " " + lastName);
            parrafo.setAlignment(parrafo.ALIGN_LEFT);
            reporte.add(parrafo);
            parrafo = new Paragraph(" ");
            reporte.add(parrafo);
            parrafo = new Paragraph("Descripción: " + description);
            parrafo.setAlignment(parrafo.ALIGN_LEFT);
            reporte.add(parrafo);
            parrafo = new Paragraph(" ");
            reporte.add(parrafo);
            parrafo = new Paragraph("Medicina: " + medicine);
            parrafo.setAlignment(parrafo.ALIGN_LEFT);
            reporte.add(parrafo);
            parrafo = new Paragraph(" ");
            reporte.add(parrafo);
            parrafo = new Paragraph("Indicaciones: " + indications);
            reporte.add(parrafo);
            parrafo = new Paragraph(" ");
            reporte.add(parrafo);
            parrafo = new Paragraph("Generado por HospitApp el " + 
                    formatter.format(Calendar.getInstance().getTime()) + " a las "
                    + formatter.format(Calendar.getInstance().getTime().getHours()
                    + ":" + formatter.format(Calendar.getInstance().getTime().getMinutes())));
            reporte.close();
            resultado = true;
        }catch(DocumentException de){
            de.printStackTrace();
        }
        return resultado;
    }
    
    /**
     * Esté metodo formatea una variable de tipo Date a un String descrito en el SDS
     * @param date contiene la fecha a formatear
     * @return un String con la fecha ya formateada
     */
    private String obtainFormatedDate(Date date) {
        String day = "";
        String month = "";
        if (date.getDia() <= 9) {
            day = "0" + date.getDia();
        } else {
            day = date.getDia() + "";
        }
        if (date.getMes() <= 9) {
            month = "0" + date.getMes();
        } else {
            month = date.getMes() + "";
        }
        return day + "/" + month + "/" + date.getYear();
    }
}
