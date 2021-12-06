
package project;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
 

public class Receipt {

    String orderId;
    String staff;
    String orderTime;
    String orderDate;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> qty = new ArrayList<>();
    ArrayList<Double> price = new ArrayList<>();
    Double Total;
    Scanner input = new Scanner(System.in);

    public Receipt() {

    }
    
    public Receipt(String Oid, String staff, String orderTime, String orderDate, ArrayList<String> name, ArrayList<Integer> qty, ArrayList<Double> price, Double Total) {

        this.orderId = Oid;
        this.staff = staff;
        this.orderTime = orderTime;
        this.orderDate = orderDate;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.Total = Total;

    }

    

    public String getOrderId() {
        return orderId;
    }

    public String getStaff() {
        return staff;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getOrderDate() {
        return orderDate;
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

    public Double getTotal() {
        return Total;
    }

    
    public void Order() {

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(" ");
        System.out.println("Order ID: " + orderId + "                         " + orderTime);
        System.out.println("Staff Name: " + staff + "                    " + orderDate);
        int count = 1;
        System.out.printf("%2s %20s %5s %10s", "No", "NAME", "QTY", "PRICE");//****
        System.out.println();
        for (int i = 0; i < name.size(); i++) {
            System.out.println("-------------------------------------------------");
            System.out.format("%2d %20s %5s %10s", count, (name.get(i)), (qty.get(i)), df.format((price.get(i)) * (qty.get(i))));//****
            System.out.println();
            count++;
        }
        System.out.println("\n-------------------------------------------------");
        System.out.println("\nTOTAL                       " + df.format(Total));
        System.out.println("\n-------------------------------------------------");
        System.out.println("Order Status: Delivered");
        System.out.println(" ");

    }

}

