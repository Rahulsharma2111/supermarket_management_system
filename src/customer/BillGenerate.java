package customer;


import database_connect_pack.DataBaseConnection;

import java.sql.*;
import java.util.Scanner;

public class BillGenerate  {
    String[] fetchItemdata=new String[5];
    public String[] fetchDataToPresent(int inputItem_Id) throws SQLException {
        DataBaseConnection dbconn=new DataBaseConnection();
        Connection con;

        {
            try {
                con = dbconn.DataBaseConn();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        PreparedStatement ps = con.prepareStatement("select * from itemsdetails where item_id= "+inputItem_Id);
        ResultSet rs = ps.executeQuery();

        String item_name = null;
        String item_type = null;
        Date expiry_date = null;
        Double rate_per_piece=null;
        int curr_quantity=0;

        while (rs.next()) {

//            int item_id = rs1.getInt("item_ID");
            item_name = rs.getString("item_name");
            item_type = rs.getString("item_type");
            expiry_date = rs.getDate("expiry_date");
            curr_quantity=rs.getInt("quantity");
            rate_per_piece=rs.getDouble("rate_per_piece");
        }
        if (curr_quantity>0){
            fetchItemdata[0]=item_name;
            fetchItemdata[1]=item_type;
            fetchItemdata[2]=String.valueOf(expiry_date);
            fetchItemdata[3]=String.valueOf(curr_quantity);
            fetchItemdata[4]=String.valueOf(rate_per_piece);

        }else {
            fetchItemdata[0] = null;
            fetchItemdata[1] = null;
            fetchItemdata[2] = null;
            fetchItemdata[3]=String.valueOf(0);
            fetchItemdata[4]=String.valueOf(0.0);
        }
        return fetchItemdata;
    }

    public static String[] custDet;
    Scanner sc = new Scanner(System.in);



    public void inputCustomerDetails() throws SQLException {
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
        // fetch item details form function to database
        String[] fetchItemData=fetchDataToPresent(item_id);
        if (fetchItemdata[0] == null || fetchItemdata[1].equals(null) || fetchItemdata[2].equals(null) || fetchItemdata[3].equals(String.valueOf(0))){
            System.out.println("Stock is not available ");
            return;
        }else {
            System.out.println(" Item name : "+fetchItemData[0]);
            System.out.println(" Item type : "+fetchItemData[1]);
            System.out.println(" Expiry date : "+fetchItemData[2]);
            System.out.println(" quantity avaible : "+fetchItemData[3]);
            System.out.println(" buyer rate not use : "+fetchItemData[4]);
        }

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

         custDet= new String[]{name, String.valueOf(mob_no), email, payment_type,
                 String.valueOf(item_id), String.valueOf(quantity), String.valueOf(rate),
                 String.valueOf(discountAmount), String.valueOf(payable_amount),
                 fetchItemData[0],fetchItemData[1],fetchItemData[2],fetchItemData[3],
                 fetchItemData[4]};

        try {
            DataBaseConnection db = new DataBaseConnection();
            db.insertCustomerPurchaseData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
