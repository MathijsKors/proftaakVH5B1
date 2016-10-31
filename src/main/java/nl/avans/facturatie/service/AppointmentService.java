/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import nl.avans.facturatie.model.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Tom Maljaars
 */
public class AppointmentService {

    
    
     private final Logger logger = LoggerFactory.getLogger(AppointmentService.class);;
    
    
    public AppointmentService() {
        
    }
    
    

    public Appointment findAppointmentById(String id) {
        Appointment appointment = new Appointment();

        for (Appointment p : this.getAllAppointments()) {
            if (Integer.parseInt(p.getAppointmentId()) == Integer.parseInt(id)) {
                appointment = p;
            }
        }
        return appointment;
    }

    public ArrayList<Appointment> getAllAppointments() {
                
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Appointment> appointments = null;
        try {
            ResponseEntity<ArrayList<Appointment>> appointmentResponse = restTemplate.exchange("http://fysioivh5b2.herokuapp.com/api/appointmentstopay/", HttpMethod.GET,null,new ParameterizedTypeReference<ArrayList<Appointment>>(){});
            appointments = appointmentResponse.getBody();
        } catch (ResourceAccessException e) {
            System.out.println("empty");
            // We gooien de exception door. Verderop in deze controller staat
            // een handler hiervoor. Die handelt deze exception af.
            throw e;
        } catch (RestClientException e) {
            System.out.println(" empty 2");
            // Zie hierboven; wordt afgehandeld.
            throw e;
        }

        return appointments;     
    }
    
    
    /**
     *
     * @param id
     */
    public void delete(String id) throws MalformedURLException, IOException {
        
        URL url = null;
        try {
            url = new URL("https://fysioivh5b2.herokuapp.com/payappointment/"+id);
            logger.info(url + "");
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            logger.info("connectie is open");
            httpURLConnection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("GET");
            logger.info("delete verstuurd");
            System.out.println(httpURLConnection.getResponseCode());
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {         
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                logger.info("Connectie gesloten");

            }
        }
    }
    
}