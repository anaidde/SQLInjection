public class Unprotected {
    private String firstName;
    private String lastName;

    public Unprotected(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String returnStatement(String id) {

        return "SELECT NUME, PRENUME from studenti where id = " + id;
    }
}