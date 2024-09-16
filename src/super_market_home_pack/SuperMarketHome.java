package super_market_home_pack;

import customer.BillGenerate;
import database_connect_pack.DataBaseConnection;
import profit_loss_balanceSheet.ProfitLossSheet;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

class InsertItemDetailsOrPurchaseDetails{
    String[] purchaseDetails=new String[20];
     Scanner sc = new Scanner(System.in);
     public void inputItemDetails() throws SQLException {
         System.out.println();
         System.out.println("Enter product item details");
         System.out.println();


//         supplier_id, supplier_name, mobile_no, email_id, address, district, state, pincode, vehicle_no, vehicle_type, vehicle_driver_name, vehicle_driver_Id, driver_contact_no

         // supplier details with vehicle driver
         System.out.print(" Company name : ");
         String com_name=sc.nextLine();
         System.out.print(" Company Mobile Number : ");
         Long mob_no=sc.nextLong();
         sc.nextLine();
         System.out.print(" Company Email id : ");
         String email= sc.nextLine();
         System.out.print(" Company Address : ");
         String com_address=sc.nextLine();
         System.out.print(" District : ");
         String district= sc.nextLine();
         System.out.print(" State : ");
         String State= sc.nextLine();
         System.out.print(" Pincode : ");
         int pincode= sc.nextInt();
         sc.nextLine();
         System.out.print(" Vehicle number : ");
         String vehicle_no= sc.nextLine();
         System.out.print(" Vehicle Type : ");
         String vehicle_type= sc.nextLine();
         System.out.print(" Vehicle driver name : ");
         String vehicle_driver_name= sc.nextLine();
         System.out.print(" Vehicle driver Aadhar number Id : ");
         String vehicle_driver_Id= sc.nextLine();
         System.out.print(" Vehicle driver Mobile number : ");
         long driver_contact_no= sc.nextLong();

         //   item_ID, item_name, item_type, quantity, rate_per_piece, expiry_date, date_time, total_amount,

//         product/item details below
         System.out.print(" Item id : ");
         int item_id= sc.nextInt();
         sc.nextLine();
         System.out.print(" Product name : ");
         String product_name= sc.nextLine();
         System.out.print(" Product Catragery/Type : ");
         String product_type= sc.nextLine();
         System.out.print(" Quantity : ");
         int quantity= sc.nextInt();
         sc.nextLine();
         System.out.print(" Rate/piece : ");
         float rate= sc.nextFloat();
         sc.nextLine();
         System.out.print(" Product Expiry Date(YYYY-MM-DD) : ");
         String expiry_date=sc.nextLine();

         // system date/time automatic insert
         float totalAmount=rate*quantity;
         System.out.println(" Total amount : "+totalAmount);


         System.out.println();
         System.out.println();
         System.out.println("-------Thanks for visit and shoping for R-Super Market-------");

         purchaseDetails= new String[]{com_name, String.valueOf(mob_no), email, com_address,district,State, String.valueOf(pincode),vehicle_no, vehicle_type, vehicle_driver_name,vehicle_driver_Id, String.valueOf(driver_contact_no), String.valueOf(item_id),product_name,product_type, String.valueOf(quantity), String.valueOf(rate), String.valueOf(expiry_date), String.valueOf(totalAmount)};

//         for (int i = 0; i < purchaseDetails.length; i++) {
//             System.out.println(i +" "+purchaseDetails[i]);
//         }

             DataBaseConnection db = new DataBaseConnection();
             db.addInsertNewStock(purchaseDetails);

     }
}
public class SuperMarketHome {
    static void superMartOptions() throws SQLException {
        int option=0;
        do {
            System.out.println(" 1. for 'Generate bills for Customers' ");
            System.out.println(" 2. for 'Veiw current stock' ");
            System.out.println(" 3. for 'Sells history' ");
            System.out.println(" 4. for 'Insert/add new stock' ");
            System.out.println(" 5. for 'Buyers history' ");
            System.out.println(" 6. for 'Set stock alert' ");
            System.out.println(" 7. for 'Profit/loss balance sheet' ");
            System.out.println(" 8. for 'Insert/add new item details' ");
            System.out.println(" 9. for  'veiw Customer data by ID' ");
            System.out.println(" 10. for 'Admin' ");
            System.out.println(" 11. for 'Exit ' ");
            System.out.println();
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter given option in menu: ");
            option=sc.nextInt();

            DataBaseConnection db = new DataBaseConnection();

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
                    db.fetchSellshistory();
                    System.out.println();
                    System.out.println("Fetch successfully");

                    System.out.println();
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Insert/add new stock");

                    InsertItemDetailsOrPurchaseDetails ins=new InsertItemDetailsOrPurchaseDetails();
                    ins.inputItemDetails();

//                    boolean success_fail_InsertStock= db.addInsertNewStock();
//                    System.out.println(success_fail_InsertStock);
                    System.out.println();
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Stock Purchase history");
                    db.fetchProductDetailsHistory();
                    System.out.println();
                    System.out.println("Fetch successfully");
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
                    ProfitLossSheet pls=new ProfitLossSheet();
                    pls.balanceSheet();
                    System.out.println();
                    break;

                case 8:
                    System.out.println();
                    System.out.println("wait1");
                    System.out.println("--------------");
                    System.out.println();
                    break;

                case 9:
                    System.out.println();
                    System.out.println("wait1");


                    boolean success_fail_ItemType= db.addItemtype();
                    System.out.println(success_fail_ItemType);
                    System.out.println();
                    break;


                case 10:
                    System.out.println();
                    System.out.println("Admin");
                    System.out.println("add user by admin");

                    boolean success_fail_user= db.addUserForSystem();
                    System.out.println(success_fail_user);
                    System.out.println();
                    break;

                case  11:
                    System.out.println("Your are log out of the software");
                    break;
                default:
                    System.out.println();
                    System.out.println("Please enter valid option in given menu");
                    System.out.println();
                    break;
            }

        }
        while (option!=11);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println();
        System.out.println("Well-Come to R-Super Market, Jaipur");
        System.out.println();

        // funtion for super Mart option
        superMartOptions();
    }
}
