import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

// Classe per connectar a una base de dades i array dels restaturants
public class Connect {
    public ArrayList readRestaurants() {
        ArrayList arrayRestaurants = new ArrayList();
        try {
            // Per fer la connexió a la base de dades
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");


            Statement stmt = con.createStatement();

            // Sentència SQL per treure la informació guardada a la base de dades
            ResultSet rs = stmt.executeQuery("SELECT RES_NOM, RES_ADRECA, RES_WEB, RES_TELEFON, TRS_DESCRIPCIO FROM  RESTAURANTS , TRESTAURANTS WHERE TRS_CODI = RES_TRS_CODI");
            while (rs.next()) {
                String name = rs.getString("RES_NOM");
                String address = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");

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
