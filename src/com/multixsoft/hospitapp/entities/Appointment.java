/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.entities;

import java.util.Collection;
import com.multixsoft.hospitapp.utilities.Date;

/**
 *
 * @author maritza
 */
public class Appointment {

    private Long idAppointment;
    private Date date;
    private Boolean isFinished;
    private Boolean iscanceled;
    private String time;
    private Collection<Report> reportCollection;
    private Doctor doctorUsername;
    private Patient patientNss;

    public Appointment() {
    }

    public Appointment(Long idAppointment) {
        this.idAppointment = idAppointment;
    }

    public Long getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Long idAppointment) {
        this.idAppointment = idAppointment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    public Boolean getIscanceled() {
        return iscanceled;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIscanceled(Boolean iscanceled) {
        this.iscanceled = iscanceled;
    }

    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    public Doctor getDoctorUsername() {
        return doctorUsername;
    }

    public void setDoctorUsername(Doctor doctorUsername) {
        this.doctorUsername = doctorUsername;
    }

    public Patient getPatientNss() {
        return patientNss;
    }

    public void setPatientNss(Patient patientNss) {
        this.patientNss = patientNss;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAppointment != null ? idAppointment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.idAppointment == null && other.idAppointment != null) || (this.idAppointment != null && !this.idAppointment.equals(other.idAppointment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        StringBuilder s = new StringBuilder();
//        s.append("Paciente: ").append(patientNss).append("  Hora de la cita: ").append(time).append(":" + "00 ");
//        if (!iscanceled) {
//            s.append((isFinished) ? "Cita Concuida" : "Cita Activa");
//        }
//        s.append((iscanceled) ? " La cita fue cancelada" : "");
//        return s.toString();
        String active = iscanceled?"Su cita se encuentra vigente":"Su cita ha sido cancelada";
        return "Folio:" + idAppointment + "\nFecha:" + date + "\nHora:" + time + "\n" + active;
    }

}
