package com.multixsoft.hospitapp.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.multixsoft.hospitapp.entities.Appointment;
import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.entities.Patient;
import com.multixsoft.hospitapp.entities.Schedule;
import com.multixsoft.hospitapp.utilities.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import static com.multixsoft.hospitapp.connector.ConectorServicio.URL_BASE;

/**
 *
 * @author maritza
 */
public class ConectorScheduleManager {

    private static final ConectorScheduleManager INSTANCE = new ConectorScheduleManager();

    private URL url;
    private HttpURLConnection conexion;

    public static ConectorScheduleManager getInstance() {
        return INSTANCE;
    }

    public long scheduleAppointment(Appointment appointment) {
        /**
         * boolean result = false; try { Map<String, String> appointmentMap =
         * new HashMap<String, String>(); appointmentMap.put("idAppointment",
         * appointment.getIdAppointment().toString());
         * appointmentMap.put("time", appointment.getTime());
         *
         * if(appointment.getIsFinished() != null){
         * appointmentMap.put("isFinished",
         * appointment.getIsFinished().toString()); }
         * if(appointment.getIscanceled() != null){
         * appointmentMap.put("iscanceled",
         * appointment.getIscanceled().toString()); } String cadenaFinal="";
         * JSONObject appointmentJson = new JSONObject(appointmentMap); String
         * appointmentToSchedule = appointmentJson.toJSONString();
         *
         * Doctor doctor = appointment.getDoctorUsername(); Map<String, String>
         * doctorMap = new HashMap<String, String>(); doctorMap.put("username",
         * doctor.getUsername()); doctorMap.put("password",
         * doctor.getPassword()); doctorMap.put("firstName",
         * doctor.getFirstName()); doctorMap.put("lastName",
         * doctor.getLastName()); doctorMap.put("license", doctor.getLicense());
         * doctorMap.put("specialty", doctor.getSpecialty());
         *
         * if(doctor.getSpecialty() != null){ doctorMap.put("specialty",
         * doctor.getSpecialty()); }
         *
         * JSONObject doctorJson = new JSONObject(doctorMap); String
         * doctorToSchedule = doctorJson.toJSONString();
         *
         * cadenaFinal = appointmentToSchedule.substring(0,
         * cadenaFinal.length()-1)+",\"doctorUsername\":"+doctorToSchedule;
         *
         * Patient patient = appointment.getPatientNss(); Map<String, String>
         * patientMap = new HashMap<String, String>(); patientMap.put("nss",
         * patient.getNss()); patientMap.put("password", patient.getPassword());
         * patientMap.put("firstName", patient.getFirstName());
         * patientMap.put("lastName", patient.getLastName());
         * patientMap.put("address", patient.getAddress());
         * patientMap.put("isActive", patient.getIsActive()+"");
         *
         * JSONObject patientJson = new JSONObject(patientMap); String
         * patientToSchedule = patientJson.toJSONString();
         *
         * cadenaFinal += ",\"patientNss\":"+patientToSchedule.substring(0,
         * patientToSchedule.length()-1)+",";
         *
         * if(patient.getDoctorUsername() != null){ Doctor patientDoctor =
         * patient.getDoctorUsername(); Map<String, String> patientDoctorMap =
         * new HashMap<String, String>(); patientDoctorMap.put("username",
         * patientDoctor.getUsername()); patientDoctorMap.put("password",
         * patientDoctor.getPassword()); patientDoctorMap.put("firstName",
         * patientDoctor.getFirstName()); patientDoctorMap.put("lastName",
         * patientDoctor.getLastName()); patientDoctorMap.put("license",
         * patientDoctor.getLicense()); if(doctor.getSpecialty() != null){
         * patientDoctorMap.put("specialty", patientDoctor.getSpecialty()); }
         *
         *
         * JSONObject patientDoctorJson = new JSONObject(patientDoctorMap);
         * String patientDoctorToSchedule = patientDoctorJson.toJSONString();
         * cadenaFinal += patientDoctorToSchedule+"}"; }
         *
         * String urlBusqueda = URL_BASE +
         * "schedulemanager/scheduleappointment?" + "Appointment=" +
         * appointmentToSchedule.substring(0, appointmentToSchedule.length()-1)
         * +","+patientToSchedule.substring(0, patientToSchedule.length()-1)
         * +","+"}"; url = new URL(urlBusqueda); System.err.println(url);
         * conexion = (HttpURLConnection) url.openConnection();
         * conexion.setRequestProperty("Accept", "text/plain");
         *
         * int codigo = conexion.getResponseCode();
         *
         * System.err.println(codigo == HttpURLConnection.HTTP_OK); if (codigo
         * == HttpURLConnection.HTTP_OK) { InputStream is =
         * conexion.getInputStream(); BufferedReader entrada = new
         * BufferedReader(new InputStreamReader(is)); String respuesta =
         * entrada.readLine(); System.err.println("RES "+entrada); result =
         * Boolean.parseBoolean(respuesta);
         *
         * entrada.close(); } } catch (MalformedURLException e) {
         * System.err.println(e); e.printStackTrace(); } catch (IOException ioe)
         * { System.err.println(ioe); ioe.printStackTrace(); } return 1L;
        *
         */
        return -1L;
    }

    public boolean cancelAppointment(Appointment appointment) {
        boolean result = false;
        try {
            String urlBusqueda = URL_BASE + "schedulemanager/cancelappointment?"
                    + "idAppointment=" + appointment.getIdAppointment().toString();
            url = new URL(urlBusqueda);
            System.err.println(url);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "text/plain");

            int codigo = conexion.getResponseCode();

            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();
                result = Boolean.parseBoolean(respuesta);

                entrada.close();
            }

        } catch (MalformedURLException e) {
            System.err.println(e);
            e.printStackTrace();

        } catch (IOException ioe) {
            System.err.println(ioe);
            ioe.printStackTrace();
        }

        return result;
    }

    public Schedule getAvailableSchedule(Doctor doctor, boolean original) {
        Schedule horario = null;
        try {
            String urlBusqueda = URL_BASE + "schedulemanager/availableschedule?"
                    + "username=" + URLEncoder.encode(doctor.getUsername() + "", "UTF-8")
                    + "&original=" + original;
            url = new URL(urlBusqueda);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "application/json");

            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();

                JSONObject scheduleJson = (JSONObject) JSONValue.parse(respuesta);

                System.err.println(scheduleJson.toJSONString());

                Schedule schedule = new Schedule();

                schedule.setIdSchedule(Long.parseLong(scheduleJson.get("idSchedule")
                        .toString()));
                Doctor doctorSchedule = doctorFromJson((JSONObject) scheduleJson
                        .get("doctorUsername"));
                schedule.setDoctorUsername(doctorSchedule);
                schedule.setMonday(scheduleJson.get("monday").toString());
                schedule.setTuesday(scheduleJson.get("tuesday").toString());
                schedule.setWednesday(scheduleJson.get("wednesday").toString());
                schedule.setThursday(scheduleJson.get("thursday").toString());
                schedule.setFriday(scheduleJson.get("friday").toString());

                horario = schedule;

                entrada.close();
            }
        } catch (MalformedURLException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (IOException ioe) {
            System.err.println(ioe);
            ioe.printStackTrace();
        }
        return horario;
    }

    public boolean setAppointmentFinish(Appointment appointment) {
        boolean result = false;
        try {
            String urlBusqueda = URL_BASE
                    + "schedulemanager/finishappointment?"
                    + "idAppointment="
                    + (appointment.getIdAppointment().toString());
            System.out.println(urlBusqueda);
            url = new URL(urlBusqueda);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "text/plain");

            int codigo = conexion.getResponseCode();
            System.err.println("CODIGO " + codigo);
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();
                result = Boolean.parseBoolean(respuesta);
                entrada.close();
            }

        } catch (MalformedURLException e) {
            System.err.println(e);
            e.printStackTrace();

        } catch (IOException ioe) {
            System.err.println(ioe);
            ioe.printStackTrace();
        }

        return result;
    }

    public List<Appointment> getAllAppointmentsFor(Doctor doctor, Date date) {
        List<Appointment> citas = new ArrayList<Appointment>();
        try {

            String urlBusqueda = URL_BASE + "schedulemanager/appointmentsfor?"
                    + "username=" + URLEncoder.encode(doctor.getUsername(), "UTF-8")
                    + "&date=" + obtainFormatedDate(date);
            System.err.println(urlBusqueda);

            url = new URL(urlBusqueda);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "application/json");

            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();

                Object objectAppointment = JSONValue.parse(respuesta);
                JSONArray appointmentList = (JSONArray) objectAppointment;
                for (Object elem : appointmentList) {
                    JSONObject appointmentJson = (JSONObject) elem;
                    Appointment appointment = new Appointment();

                    appointment.setDate(date);
                    appointment.setDoctorUsername(doctorFromJson((JSONObject) appointmentJson
                            .get("doctorUsername")));

                    appointment.setIdAppointment(Long.parseLong(appointmentJson.get(
                            "idAppointment").toString()));

                    appointment.setIscanceled((Boolean)appointmentJson.get(
                            "iscanceled"));

                    appointment.setIsFinished((Boolean)appointmentJson.get(
                            "isFinished"));

                    appointment.setPatientNss((patientFromJson((JSONObject) appointmentJson
                            .get("patientNss"))));

                    appointment.setTime(appointmentJson.get("time").toString());

                    citas.add(appointment);
                }
                
                entrada.close();
            }
        } catch (MalformedURLException e) {
            System.err.println(e);
            e.printStackTrace();

        } catch (IOException ioe) {
            System.err.println(ioe);
            ioe.printStackTrace();
        }
        return citas;
    }

    public List<Appointment> getAllAppointmentsFor(Doctor doctor) {
        List<Appointment> citas = new ArrayList<Appointment>();
        try {

            String urlBusqueda = URL_BASE + "schedulemanager/appointmentsdoctor?"
                    + "username=" + URLEncoder.encode(doctor.getUsername(), "UTF-8");
            System.err.println(urlBusqueda);

            url = new URL(urlBusqueda);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "application/json");

            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();

                Object objectAppointment = JSONValue.parse(respuesta);
                JSONArray appointmentList = (JSONArray) objectAppointment;
                for (Object elem : appointmentList) {
                    JSONObject appointmentJson = (JSONObject) elem;
                    Appointment appointment = new Appointment();

//                    appointment.setDate(date);
                    appointment.setDoctorUsername(doctorFromJson((JSONObject) appointmentJson
                            .get("doctorUsername")));

                    appointment.setIdAppointment(Long.parseLong(appointmentJson.get(
                            "idAppointment").toString()));

                    appointment.setIscanceled(Boolean.getBoolean(appointmentJson.get(
                            "iscanceled").toString()));

                    appointment.setIsFinished(Boolean.getBoolean(appointmentJson.get(
                            "isFinished").toString()));

                    appointment.setPatientNss((patientFromJson((JSONObject) appointmentJson
                            .get("patientNss"))));

                    appointment.setTime(appointmentJson.get("time").toString());

                    if (appointmentJson.get("date") != null) {
                        try {
                            String dateForApp = appointmentJson.get("date").toString().substring(0, 10);
                            String[] dateArray = dateForApp.split("-");
                            int year = Integer.parseInt(dateArray[0]);
                            int month = Integer.parseInt(dateArray[1]);
                            int day = Integer.parseInt(dateArray[2]);
                            appointment.setDate(new Date(day, month, year));
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    citas.add(appointment);
                }
                entrada.close();
            }
        } catch (MalformedURLException e) {
            System.err.println(e);
            e.printStackTrace();

        } catch (IOException ioe) {
            System.err.println(ioe);
            ioe.printStackTrace();
        }
        return citas;
    }

//    public Appointment getNextAppointment(Patient p) {
//        Appointment cita = null;
//        try {
//            String urlBusqueda = URL_BASE + "schedulemanager/nextappointment?"
//                    + "nss=" + URLEncoder.encode(p.getNss() + "", "UTF-8");
//            url = new URL(urlBusqueda);
//            conexion = (HttpURLConnection) url.openConnection();
//            conexion.setRequestProperty("Accept", "application/json");
//
//            int codigo = conexion.getResponseCode();
//            if (codigo == HttpURLConnection.HTTP_OK) {
//                InputStream is = conexion.getInputStream();
//                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
//                String respuesta = entrada.readLine();
//
//                JSONObject appointmentJson = (JSONObject) JSONValue.parse(respuesta);
//                Appointment appointment = new Appointment();
//                
//                appointment.setDate((Date) appointmentJson.get("date"));
//		appointment.setDoctorUsername(doctorFromJson((JSONObject) appointmentJson
//						.get("doctorUsername")));
//                
//		appointment.setIdAppointment(Long.parseLong(appointmentJson.get(
//				"idAppointment").toString()));
//                
//		appointment.setIscanceled(Boolean.getBoolean(appointmentJson.get(
//				"iscanceled").toString()));
//                
//		appointment.setIsFinished(Boolean.getBoolean(appointmentJson.get(
//				"isFinished").toString()));
//                
//		appointment.setPatientNss(patientFromJson((JSONObject) appointmentJson
//				.get("patientNss")));
//
//                cita = appointment;
//
//                entrada.close();
//            }
//        } catch (MalformedURLException e) {
//            System.err.println(e);
//            e.printStackTrace();
//            
//        } catch (IOException ioe) {
//            System.err.println(ioe);
//            ioe.printStackTrace();
//        }
//        return cita;
//    }
    public List<Appointment> getNextAppointment(Patient p) {
        List<Appointment> citas = new ArrayList<Appointment>();
        try {

            String urlBusqueda = URL_BASE + "schedulemanager/nextappointment?"
                    + "nss=" + URLEncoder.encode(p.getNss(), "UTF-8");

            System.err.println(urlBusqueda);

            url = new URL(urlBusqueda);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Accept", "application/json");
            int codigo = conexion.getResponseCode();
            if (codigo == HttpURLConnection.HTTP_OK) {
                InputStream is = conexion.getInputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
                String respuesta = entrada.readLine();
                Object objectAppointment = JSONValue.parse(respuesta);
                JSONArray appointmentList = (JSONArray) objectAppointment;
                for (Object elem : appointmentList) {
                    JSONObject appointmentJson = (JSONObject) elem;
                    Appointment appointment = new Appointment();

                    if (appointmentJson.get("date") != null) {
                        try {
                            String dateForApp = appointmentJson.get("date").toString().substring(0, 10);
                            String[] dateArray = dateForApp.split("-");
                            int year = Integer.parseInt(dateArray[0]);
                            int month = Integer.parseInt(dateArray[1]);
                            int day = Integer.parseInt(dateArray[2]);
                            appointment.setDate(new Date(day, month, year));
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    appointment.setDoctorUsername(doctorFromJson((JSONObject) appointmentJson
                            .get("doctorUsername")));

                    appointment.setIdAppointment(Long.parseLong(appointmentJson.get(
                            "idAppointment").toString()));

                    appointment.setIscanceled(Boolean.getBoolean(appointmentJson.get(
                            "iscanceled").toString()));

                    appointment.setIsFinished(Boolean.getBoolean(appointmentJson.get(
                            "isFinshed").toString()));

                    appointment.setPatientNss((patientFromJson((JSONObject) appointmentJson
                            .get("patientNss"))));

                    appointment.setTime(appointmentJson.get("time").toString());
                    citas.add(appointment);
                }
                entrada.close();
            }
        } catch (MalformedURLException e) {
            System.err.println(e);
            e.printStackTrace();

        } catch (IOException ioe) {
            System.err.println(ioe);
            ioe.printStackTrace();
        }
        return citas;
    }

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

    private Patient patientFromJson(JSONObject patientJson) {
        Patient patient = new Patient();
        if (patientJson != null) {
            patient.setNss(patientJson.get("nss").toString());
            patient.setFirstName(patientJson.get("firstName").toString());
            patient.setLastName(patientJson.get("lastName").toString());
            patient.setAddress(patientJson.get("address").toString());
            patient.setIsActive(Boolean.valueOf(patientJson.get("isActive")
                    .toString()));

            if (patientJson.get("doctorUsername") != null) {
                JSONObject doctorJson = (JSONObject) patientJson.get("doctorUsername");
                Doctor patientDoctor = doctorFromJson(doctorJson);
                patient.setDoctorUsername(patientDoctor);
            }
        }
        return patient;
    }

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
