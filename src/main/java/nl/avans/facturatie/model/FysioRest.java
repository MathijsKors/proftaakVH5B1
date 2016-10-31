package nl.avans.facturatie.model;

/**
 *
 * @author Gebruiker
 */
public class FysioRest {

    private String dateObject;
    private String status;
    private String physiotherapistName;
    private String date;
    private String patientId;
    private String patientName;
    private String treatmentName;
    private String appointmentId;
    private String treatmentCode;
    private String treatmentTime;

    /**
     *
     */
    public FysioRest() {
    }

    /**
     *
     * @param dateObject
     * @param status
     * @param physiotherapistName
     * @param date
     * @param patientId
     * @param patientName
     * @param treatmentName
     * @param appointmentId
     * @param treatmentCode
     * @param treatmentTime
     */
    public FysioRest(String dateObject, String status, String physiotherapistName, String date, String patientId, String patientName, String treatmentName, String appointmentId, String treatmentCode, String treatmentTime) {
        this.dateObject = dateObject;
        this.status = status;
        this.physiotherapistName = physiotherapistName;
        this.date = date;
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentName = treatmentName;
        this.appointmentId = appointmentId;
        this.treatmentCode = treatmentCode;
        this.treatmentTime = treatmentTime;
    }

    /**
     *
     * @return
     */
    public String getDateObject() {
        return dateObject;
    }

    /**
     *
     * @param dateObject
     */
    public void setDateObject(String dateObject) {
        this.dateObject = dateObject;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getPhysiotherapist() {
        return physiotherapistName;
    }

    /**
     *
     * @param physiotherapistName
     */
    public void setPhysiotherapist(String physiotherapistName) {
        this.physiotherapistName = physiotherapistName;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     *
     * @param patientId
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     *
     * @return
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     *
     * @param patientName
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     *
     * @return
     */
    public String getTreatmentName() {
        return treatmentName;
    }

    /**
     *
     * @param treatmentName
     */
    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    /**
     *
     * @return
     */
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     *
     * @param appointmentId
     */
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     *
     * @return
     */
    public String getTreatmentCode() {
        return treatmentCode;
    }

    /**
     *
     * @param treatmentCode
     */
    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCode = treatmentCode;
    }

    /**
     *
     * @return
     */
    public String getTreatmentTime() {
        return treatmentTime;
    }

    /**
     *
     * @param treatmentTime
     */
    public void setTreatmentTime(String treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    @Override
    public String toString() {
        return "ClassFysioRest [dateObject = " + dateObject + ", status = " + status
                + ", physiotherapistName = " + physiotherapistName + ", date = " + date
                + ", patientId = " + patientId + ", patientName = " + patientName + ", treatmentName = " + treatmentName + ", appointmentId = "
                + appointmentId + ", treatmentCode = " + treatmentCode + ", treatmentTime = " + treatmentTime + "]";
    }
}
