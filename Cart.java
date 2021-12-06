

package project;

package restaurant;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cart {

    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<Integer> qty = new ArrayList<>();
    private ArrayList<Double> price = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public Cart(ArrayList<Order> fcart, ArrayList<Order> Dcart, ArrayList<Order> scart) {

        ArrayList<String> iname = new ArrayList<>();
        ArrayList<Integer> iqty = new ArrayList<>();
        ArrayList<Double> iprice = new ArrayList<>();

        for (int i = 0; i < fcart.size(); i++) { 
            iname.addAll(fcart.get(i).getOName());
            iqty.addAll(fcart.get(i).getQuantity());
            iprice.addAll(fcart.get(i).getPrice());
        }

        for (int i = 0; i < Dcart.size(); i++) {
            iname.addAll(Dcart.get(i).getOName());
            iqty.addAll(Dcart.get(i).getQuantity());
            iprice.addAll(Dcart.get(i).getPrice());
        }

        for (int i = 0; i < scart.size(); i++) {
            iname.addAll(scart.get(i).getOName());
            iqty.addAll(scart.get(i).getQuantity());
            iprice.addAll(scart.get(i).getPrice());
        }

        this.name = iname;
        this.qty = iqty;
        this.price = iprice;

    }

    public Cart() {

    }

    public ArrayList<String> getName() {
        return name;
    }

    public ArrayList<Integer> getQuantity() {
        return qty;
    }

    public ArrayList<Double> getPrice() {
        return price;
    }

    double getTotal() {

        double subtotal = 0.0;
        for (int i = 0; i < name.size(); i++) {
            double amt;
            amt = price.get(i) * qty.get(i);
            subtotal = subtotal + amt;
        }

        return (subtotal);
    }

    public String getTime() { 

        String jam;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date datey = new Date();
        jam = formatter.format(datey);

        return (jam);
    }

    public String getDate() { 

        String hari;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        hari = formatter.format(today);

        return (hari);
    }

    public Object displayCart(String id, String staff) { 

        DecimalFormat df = new DecimalFormat("#.##"); 
        String orderTime = getTime(); 
        String orderDate = getDate(); 
        System.out.println("Order ID: " + id + "                         " + orderTime);
        System.out.println("Staff Name: " + staff + "                    " + orderDate);
        int count = 1;
        System.out.printf("%2s %20s %5s %10s", "No", "NAME", "QTY", "PRICE"); 
        System.out.println();
        for (int i = 0; i < name.size(); i++) { 
            System.out.println("-------------------------------------------------");
            System.out.format("%2d %20s %5s %10s", count, name.get(i), qty.get(i), df.format((price.get(i) * qty.get(i))));
            System.out.println();
            count++;
        }
        double stotal = getTotal(); 
        double taxtotal = (stotal * 0.15); 
        double ftotal = stotal + taxtotal; 
        System.out.println("\n-------------------------------------------------");
        System.out.println("\nBefore Tax TOTAL                       " + df.format(stotal));
        System.out.println("TAX(%15)                   " + df.format(taxtotal));
        System.out.println("Total                          " + df.format(ftotal));
        Receipt dummy = new Receipt(id, staff, orderTime, orderDate, name, qty, price, ftotal); 

        return (dummy);

    }
}
