
package project;

package restaurant;

import java.util.ArrayList;


public class Order {
    
    private ArrayList<String> OName = new ArrayList<>();
    protected ArrayList<Integer> quantity = new ArrayList<>();
    private ArrayList<Double> Oprice = new ArrayList<>();
    
    Order() {
     }
    
    
    public Order (ArrayList<String> OName, ArrayList<Integer> quantity, ArrayList<Double> Oprice) {

        this.OName = OName;
        this.quantity = quantity;
        this.Oprice = Oprice;
    }

    
    
    
    public ArrayList<String> getOName() {
        return OName;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }
    
    public ArrayList<Double> getPrice() {
        return Oprice;
    }
    
  
}

