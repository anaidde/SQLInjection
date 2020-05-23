public class Protected {
    private String firstName;
    private String lastName;

    public Protected(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String returnStatement() {
        return "SELECT nume, prenume from studenti where nume = ? and prenume = ?";
    }
}
