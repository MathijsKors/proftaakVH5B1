/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom Maljaars
 */

@XmlRootElement(name = "behandelcodes")
public class WrapperTreatmentCode {

    /**
     *
     */
    @XmlElement(name = "behandeling")
    public ArrayList<Treatment> behandelingen;

    /**
     *
     * @return
     */
    public ArrayList getList() {
        return behandelingen;
    }

}
