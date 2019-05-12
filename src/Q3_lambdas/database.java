
package Q3_lambdas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class database {
    public static void connection(){
        Object[] arrays_Invoice={
            new Invoice(83,"Electric sander",7,57.98),
            new Invoice(24,"Power saw",18,99.99),
            new Invoice(7 ,"Sledge hammer",11,21.50),
            new Invoice(77,"Hammer",76,11.99),
            new Invoice(39,"Lawm nower",3,79.50),
            new Invoice(68,"Screwdriver",106,6.99),
            new Invoice(56,"Jig saw",21,11.00),
            new Invoice(3 ,"Wrench",34,7.50)
        };
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/Invoices", "root", "");
               Statement statement = connection.createStatement();
                
               //*******insert******
              PreparedStatement ps = connection.prepareStatement
                ("INSERT into invoice(fname,mname,lname) VALUES(?,?,?,?)");
                for (Object obj : arrays_Invoice) {
                Invoice invoice = (Invoice) obj;
                ps.setInt(1, invoice.getPartNumber());
                ps.setString(2, invoice.getPartDescription());
                ps.setInt(3, invoice.getQuantity());
                ps.setDouble(4, invoice.getPrice());
                ps.addBatch();
            }

            //********select********
            ResultSet resultSet = statement.executeQuery("SELECT * from invoice");
            List<Invoice> invoices = new ArrayList<>();
            while (resultSet.next()) {
                Invoice invoice = new Invoice(
                        resultSet.getInt("Part_Number"),
                        resultSet.getString("Part_Description"),
                        resultSet.getInt("Quantity"),
                        resultSet.getDouble("Price")
                );
                invoices.add(invoice);
            }

            //a (sort by PartDescription)
            invoices.stream()
                    .sorted(Comparator.comparing(i -> i.getPartDescription()))
                    .forEach(s -> System.out.println(s));

            //b (sort by Price)
            invoices.stream()
                    .sorted(Comparator.comparing(i -> i.getPrice()))
                    .forEach(s -> System.out.println(s));

            //c
            invoices.stream()
                    .sorted(Comparator.comparing(i -> i.getQuantity()))
                    .map(i -> i.getPartDescription() + " " + i.getQuantity())
                    .forEach(s -> System.out.println(s));

            //d
            invoices.stream()
                    .sorted(Comparator.comparing(i -> i.getQuantity() * i.getPrice()))
                    .map(i -> i.getPartDescription() + " " + (i.getPrice() * i.getQuantity()))
                    .forEach(s -> System.out.println(s));

            //e
            invoices.stream()
                    .sorted(Comparator.comparing(i -> i.getQuantity() * i.getPrice()))
                    .filter(i-> (i.getQuantity() * i.getPrice()) >=200 && (i.getQuantity() * i.getPrice()) <=500 )
                    .map(i -> i.getPartDescription() + " " + (i.getPrice() * i.getQuantity()))
                    .forEach(s -> System.out.println(s));

            
            
            
            
            
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        connection();
    }
}
