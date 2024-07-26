package super_market_home_pack;

import customer.BillGenerate;
import database_connect_pack.DataBaseConnection;

import java.sql.SQLException;
import java.util.Scanner;

public class SuperMarketHome {
    static void superMartOptions(){
        int option=0;
        do {
            System.out.println(" 1. for 'Generate bills for Customers' ");
            System.out.println(" 2. for 'Veiw current stock' ");
            System.out.println(" 3. for 'Sells history' ");
            System.out.println(" 4. for 'Buyers history' ");
            System.out.println(" 5. for 'Insert/add new stock' ");
            System.out.println(" 6. for 'Set stock alert' ");
            System.out.println(" 7. for 'Profit/loss balance sheet' ");
            System.out.println(" 8. for 'Insert/add new item details' ");
            System.out.println(" 9. for 'wait1' ");
            System.out.println(" 10. for 'wait2' ");
            System.out.println(" 11. for 'wait3' ");
            System.out.println(" 12. for 'Admin' ");
            System.out.println(" 13. for 'Exit ' ");
            System.out.println();
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter given option in menu: ");
            option=sc.nextInt();

            DataBaseConnection db= null;
            try {
                db = new DataBaseConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            switch (option){

                case 1:
                    System.out.println();
                    System.out.println("Generate bills for Customers");
                    BillGenerate bill=new BillGenerate();
                    bill.inputCustomerDetails();
                    System.out.println();

                    break;

                case 2:
                    System.out.println();
                    System.out.println("Veiw current stock");
                     db.fetchAvailableStock();
                    System.out.println();
                    System.out.println("Fetch successfully");
                    System.out.println();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("Sells history");
                    System.out.println();
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Buyers history");
                    System.out.println();
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Insert/add new stock");

                    boolean success_fail_InsertStock= db.addInsertNewStock();
                    System.out.println(success_fail_InsertStock);
                    System.out.println();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Set stock alert");
                    System.out.println();
                    break;

                case 7:
                    System.out.println();
                    System.out.println("Profit/loss balance sheet");
                    System.out.println();
                    break;

                case 8:
                    System.out.println();
                    System.out.println("Insert/add new item details");
                    System.out.println();
                    break;

                case 9:
                    System.out.println();
                    System.out.println("wait1");
                    System.out.println("Add new Item type");

                    boolean success_fail_ItemType= db.addItemtype();
                    System.out.println(success_fail_ItemType);
                    System.out.println();
                    break;

                case 10:
                    System.out.println();
                    System.out.println("wait2");
                    System.out.println();
                    break;

                case 11:
                    System.out.println();
                    System.out.println("wait3");
                    System.out.println();
                    break;

                case 12:
                    System.out.println();
                    System.out.println("Admin");
                    System.out.println("add user by admin");

                    boolean success_fail_user= db.addUserForSystem();
                    System.out.println(success_fail_user);
                    System.out.println();
                    break;

                default:
                    System.out.println();
                    System.out.println("Please enter valid option in given menu");
                    System.out.println();
                    break;
            }

        }
        while (option!=13);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Well-Come to R-Super Market, Jaipur");
        System.out.println();

        // funtion for super Mart option
        superMartOptions();
    }
}
