package in.org.rebit.visitortracker.entity;

public class Visitor {
    static private int count;
    private int id;
    private String firstName;
    private String lastName;
    private String visitee;
    private String emailID;
    private long contactNumber;
    private String purpose;

    public Visitor(String firstName, String lastName, String visitee, String emailID, long contactNumber, String purpose) {
        count++;
        this.id = count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.visitee = visitee;
        this.emailID = emailID;
        this.contactNumber = contactNumber;
        this.purpose = purpose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVisitee() {
        return visitee;
    }

    public void setVisitee(String visitee) {
        this.visitee = visitee;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
