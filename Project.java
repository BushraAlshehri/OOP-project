
package project;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Project {

    ArrayList<Item> fmenu = new ArrayList<>();
    ArrayList<Item> Dmenu = new ArrayList<>();
    ArrayList<Item> smenu = new ArrayList<>();
    ArrayList<Receipt> allreceipt = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int count = 101;

    public static void main(String[] args)      {

        clearScreen();
        Project rest = new Project();
        rest.start();

    }

    public void start()      {

        initData();
        person logger = new cashier();
        String staff = logger.login();
        String option = "";
        option = menu();
        while (!option.trim().equalsIgnoreCase("Q")) {

            if (option.trim().equalsIgnoreCase("1")) {
                clearScreen();
                PlaceOrder(staff);
            } else if (option.trim().equalsIgnoreCase("2")) {
                clearScreen();
                EditPrice();
            } else {
                System.out.println("Invalid Input!");
            }

            option = menu();
        }

        System.out.println("");
        System.out.println("Thanks for Using EL Khabar Management System!");
        System.out.println("");
    }

    public void PlaceOrder(String staff) {

        String choose1 = "";
        String OrderID;
        int success = 0;
        while (!choose1.trim().equalsIgnoreCase("M")) {
            System.out.println("******************* Make New Order ******************");
            System.out.println("Select from Options or Enter ‘M’ for Main Menu");
            System.out.println("1. Start Order");
            System.out.println("M. Go to main Menu");
            choose1 = input.next();

            if (choose1.trim().equalsIgnoreCase("1")) {
                clearScreen();
                OrderID = "SO" + count;
                success = ordering(OrderID, choose1, staff);
            }

            if (choose1.trim().equalsIgnoreCase("M")) {
                break;
            }

        }
    }


    public void EditPrice()      {
        String choose3 = "";
        clearScreen();
        while (!choose3.trim().equalsIgnoreCase("M")) {
            System.out.println("******************* Edit Price ******************");
            System.out.println("Select from Options or Enter ‘M’ for Main Menu");
            System.out.println("1. Food");
            System.out.println("2. Drinks");
            System.out.println("3. Side");
            System.out.println("M. Go to main Menu");
            Menu Do = new Menu(Dmenu);
            Menu fo = new Menu(fmenu);
            Menu so = new Menu(smenu);
            choose3 = input.next();
            String type = " ";
            if (choose3.trim().equalsIgnoreCase("1")) {
                type = "food";
                fo.displayItem();
                fo.editItem();

                System.out.println("Price Edited Succesfully!");
            } else if (choose3.trim().equalsIgnoreCase("2")) {
                type = "drink";
                Do.displayItem();
                Do.editItem();

                System.out.println("Price Edited Succesfully!");
            } else if (choose3.trim().equalsIgnoreCase("3")) {
                type = "side";
                so.displayItem();
                so.editItem();

                System.out.println("Price Edited Succesfully!");
            } else if (choose3.trim().equalsIgnoreCase("M")) {
                break;
            }
        }
    }



    public int ordering(String order, String type, String staff) {

        String Ti = "";
        int s = 0;
        Menu ordermenu = new Menu();
        ArrayList<Order> forder = new ArrayList<>();
        ArrayList<Order> Dorder = new ArrayList<>();
        ArrayList<Order> sorder = new ArrayList<>();
        while (!Ti.trim().equalsIgnoreCase("B")) {
            String title;
            if ("1".equals(type)) {
                title = "Start Order";
            } else {
                title = "";
            }
            System.out.println("******************* " + title + " ******************");
            ordermenu.displayMenu();
            Menu Do = new Menu(Dmenu);
            Menu fo = new Menu(fmenu);
            Menu so = new Menu(smenu);
            Ti = input.next();

            if (Ti.trim().equalsIgnoreCase("1")) {
                fo.displayItem();
                forder.addAll(fo.chooseItem());
                System.out.print("Enter Anything to continue...");
                input.next();
                clearScreen();
            } else if (Ti.trim().equalsIgnoreCase("2")) {
                Do.displayItem();
                Dorder.addAll(Do.chooseItem());
                System.out.print("Enter Anything to continue...");
                input.next();
                clearScreen();
            } else if (Ti.trim().equalsIgnoreCase("3")) {
                so.displayItem();
                sorder.addAll(so.chooseItem());
                System.out.print("Enter Anything to continue...");
                input.next();
                clearScreen();
            }
            if (Ti.trim().equalsIgnoreCase("4")) {
                int check = 1;
                if (forder.size() == 0) {
                    if (Dorder.size() == 0) {
                        if (sorder.size() == 0) {
                            check = 0;
                        }
                    }
                }

                if (check != 0) {
                    Cart dn = new Cart(forder, Dorder, sorder);
                    Receipt rc = new Receipt();
                    rc = (Receipt) (dn.displayCart(order, staff));
                    System.out.println("\n-------------------------------------------------");
                    System.out.println("Confirm Order & Pay ? (y/n)");
                    String pay = input.next();

                    if ("y".equalsIgnoreCase(pay)) {
                        allreceipt.add(rc);
                        System.out.println("Order Paid Successfully");
                    }
                } else {
                    System.out.println("You havent order anything!");
                }
                System.out.print("Enter Anything to continue...");
                input.next();
                Ti = "B";
                clearScreen();
            }
            if (Ti.trim().equalsIgnoreCase("B")) {
                break;

            }
        }

        return (s);

    }

    public static void clearScreen() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public String menu() {

        clearScreen();
        System.out.println("Select any Option you want to perform. Enter ‘Q’ to quit the program ");
        System.out.println("1. Make Order");
        System.out.println("2. Edit Price");
        System.out.println("");

        return input.next();
    }

    public void initData()      {
        System.out.println("******************* Welcome To Restaurant El khabar ******************");

        fmenu.clear();
        Dmenu.clear();
        smenu.clear();


        Item fm = new Item("1", "buratta pizza", 56.0);
        fmenu.add(fm);
        fm = new Item("2", "Pink pasta", 37.0);
        fmenu.add(fm);
        fm = new Item("3", "Spaghetti", 40.0);
        fmenu.add(fm);
        fm = new Item("4", "Rosemary salmon", 87.0);
        fmenu.add(fm);

        Item dm = new Item("1", "Cola", 5.0);
        Dmenu.add(dm);
        dm = new Item("2", "7up", 5.0);
        Dmenu.add(dm);
        dm = new Item("3", "Orange juice", 15.0);
        Dmenu.add(dm);
        dm = new Item("4", "Mojito", 25.0);
        Dmenu.add(dm);
        Item sm = new Item("1", "Dynamite shrimp", 39.0);
        smenu.add(sm);
         sm = new Item("2", "Mac & cheese balls", 45.0);
        smenu.add(sm);
         sm = new Item("3", "Tiramisu", 42.0);
        smenu.add(sm);
         sm = new Item("4", "Molten Chocolate ", 19.0);
        smenu.add(sm);
    }
}
