/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.service;

import java.util.ArrayList;
import nl.avans.facturatie.model.Appointment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Chiel
 */
public class AppointmentService {

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
        //return patients1;

        //API configuratie voor klanten op te halen vanuit facturatie api,
        // LET OP IN THYMLEAF ZULLEN BEPAALDE WAARDES OOK AANGEPAST MOETEN WORDEN
        
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
}