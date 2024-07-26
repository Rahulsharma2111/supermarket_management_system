package customer;


import database_connect_pack.DataBaseConnection;

import java.sql.SQLException;
import java.util.Scanner;

public class BillGenerate {

    public static String[] custDet;
    Scanner sc = new Scanner(System.in);
    public void inputCustomerDetails(){
        System.out.println();
        System.out.println("Well Come Bill Generate Panel");
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println("only customer details fill below");
        System.out.println();
        System.out.println();

        System.out.print(" Customer name : ");
        String name=sc.nextLine();
        System.out.print(" Mobile No. : ");
        Long mob_no=sc.nextLong();
        sc.nextLine();
        System.out.print(" Email id : ");
        String email= sc.nextLine();
        System.out.print(" Payment Type");
        System.out.print(" Cash/UPI/NetBanking/Debit/Credit cards : ");
        String payment_type=sc.nextLine();
        //date will be automatic
        System.out.print(" Item id : ");
        int item_id= sc.nextInt();
        System.out.print(" Quantity : ");
        int quantity= sc.nextInt();
        System.out.print(" Rate/piece : ");
        float rate= sc.nextFloat();

        float totalAmount=rate*quantity;
        System.out.println(" Total amount : "+totalAmount);

        System.out.println(" Discount (0/--%) : ");
            float discount=sc.nextFloat();

            float discountAmount=(totalAmount/100)*discount;
        System.out.println(" Discount : " +discountAmount);

        float payable_amount=totalAmount-discountAmount;
        System.out.println(" Payable amount : "+ payable_amount);

        System.out.println();
        System.out.println();
        System.out.println("-------Thanks for visit and shoping for R-Super Market-------");

         custDet= new String[]{name, String.valueOf(mob_no), email, payment_type, String.valueOf(item_id), String.valueOf(quantity), String.valueOf(rate), String.valueOf(discountAmount), String.valueOf(payable_amount)};

        try {
            DataBaseConnection db = new DataBaseConnection();
            db.insertCustomerPurchaseData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
