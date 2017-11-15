import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Reads the students stored in the school.sqlite3 database
 */
public class Connect {
    public ArrayList readRestaurants() {
        ArrayList arrayRestaurants = new ArrayList();
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");


            Statement stmt = con.createStatement();


            ResultSet rs = stmt.executeQuery("SELECT name, address, website, telephone, type FROM students");
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String website = rs.getString("website");
                String telephone = rs.getString("telephone");
                String type = rs.getString("type");

                Restaurants std = new Restaurants();
                std.setName(name);
                std.setAddress(address);
                std.setWebsite(website);
                std.setTelephone(telephone);
                std.setType(type);



                arrayRestaurants.add(std);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arrayRestaurants;
    }
}
