/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.service;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import nl.avans.facturatie.model.Treatment;
import nl.avans.facturatie.model.WrapperTreatmentCode;

/**
 *
 * @author Tom Maljaars
 */
public class TreatmentService {

    WrapperTreatmentCode WrapperTreatmentCode;

    public TreatmentService() throws JAXBException {
        this.setTreatmentsFromXML();
    }

    public void setTreatmentsFromXML() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WrapperTreatmentCode.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        WrapperTreatmentCode = (WrapperTreatmentCode) jaxbUnmarshaller.unmarshal(new File("src/main/resources/static/xml/behandelcodes.xml"));
    }

    public ArrayList<Treatment> getSettedTreatments() {
        return WrapperTreatmentCode.getList();
    }

    public void printAllTreatments() {
        for (Treatment t : this.getSettedTreatments()) {
            t.print();
        }
    }

    public Treatment findTreatmentById(String id) {
        Treatment treatment = new Treatment();

        for (Treatment t : this.getSettedTreatments()) {
            if (t.getTreatmentCode().equals(id)) {
                treatment = t;
            }
        }
        return treatment;
    }
}
