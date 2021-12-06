
package project;

import java.util.Scanner;

 abstract class person {
    String name;
    int age;
    String Address;
    abstract String login();
}



class cashier extends person{
 @Override
 public String login() {
    Scanner input = new Scanner(System.in);
        String[] worker = new String[3];
        worker[0] = "admin";

        String[] pwd = new String[3];
        pwd[0] = "123";

        String uname = "", pass;
        int temp = 0;
        System.out.println("******************* Login ******************");
        System.out.println("");
        while (temp == 0) {
            int invalidname = 0;
            int invalidpass = 0;
            System.out.println("Enter Username: ");
            uname = input.next();
            System.out.println("Enter Password: ");
            pass = input.next();
            for (int i = 0; i < worker.length; i++) {
                if (uname.equalsIgnoreCase(worker[i])) {
                    if (pass.equals(pwd[i])) {
                        System.out.println("Login Succesful!");
                        System.out.println("Welcome " + worker[i]);
                        uname = worker[i];
                        temp = 1;
                        invalidname = 0;
                        System.out.println("Enter anything to continue...");
                        input.next();
                    } else {
                        invalidpass = 1;
                    }
                } else {
                    invalidname++;
                }
            }

            if (invalidname == worker.length) {
                if (invalidpass == 0) {
                    System.out.println("Wrong Username!");
                }
            }

            if (invalidpass == 1) {
                System.out.println("Password Mismatch!");
            }

        }

        return (uname);
    }
}


