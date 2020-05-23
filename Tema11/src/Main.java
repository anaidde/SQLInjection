import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        try{
            Database database = Database.getInstance();

            System.out.print("Enter last name: ");
            String lastName = scan.next();
            System.out.print("Enter first name: ");
            String firstName = scan.next();

            Protected protectedMethod = new Protected(firstName, lastName);
            Unprotected unprotectedMethod = new Unprotected(firstName, lastName);

            System.out.println("Protected Method: ");

            PreparedStatement statement = database.getStatement(protectedMethod.returnStatement());
            statement.setString(1, protectedMethod.getLastName());
            statement.setString(2, protectedMethod.getFirstName());
            ResultSet protectedRows = statement.executeQuery();

            int found = 0;
            while(protectedRows.next()) {
                System.out.println(
                        "Nume: " + protectedRows.getString(1) + " " +
                                "Prenume: " + protectedRows.getString(2)
                );
                found ++ ;
            }

            if(found == 0) {
                System.out.println("Not found!");
            }

            protectedRows.close();
            statement.close();

            System.out.print("Enter ID for Unprotected Method search: ");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.nextLine();
            int found1 = 0;
            System.out.println("Unprotected method: ");
            Statement statement1 = database.createStatement();

            ResultSet result1 = statement1.executeQuery(
                    unprotectedMethod.returnStatement(
                            id
                    )
            );

            System.out.println(unprotectedMethod.returnStatement(id));

            while(result1.next()) {
                System.out.println(
                        "Nume: " + result1.getString(1) + "  " +
                                "Prenume:" + result1.getString(2) + "  "
                );
                found1 ++;
            }

            if(found1 == 0) {
                System.out.println("Not found in Unprotected Method!");
            }

            result1.close();
            statement1.close();

            database.endConnection();

        }catch(Exception e){ System.out.println(e);}
    }
}
