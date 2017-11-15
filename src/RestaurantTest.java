import java.util.ArrayList;
import java.util.Iterator;

// Mostra els restaurants i les seves dades
public class RestaurantTest {
    public static void main(String[] args) {
        Connect Connect = new Connect();

        ArrayList arrayRestaurants = Connect.readRestaurants();
        Iterator itr = arrayRestaurants.iterator();
        System.out.println("<table>");
        System.out.println("<tr><th>Name</th><th>Address</th><th>Website</th></tr><th>Telephone</th></tr><th>Type</th></tr>");
        while (itr.hasNext()) {
            Restaurants std = (Restaurants) itr.next();
            System.out.println("<tr><td>"+std.getName()+"</td><td>"+std.getAddress()+"</td><td>"+std.getWebsite()+"</td></tr>"+std.getTelephone()+"</td></tr>"+std.getType()+"</td></tr>");


        }
        System.out.println("</table>");
    }
}
