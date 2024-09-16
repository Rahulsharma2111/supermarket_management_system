package database_connect_pack;


import java.sql.*;
import java.time.LocalDateTime;

import static customer.BillGenerate.custDet;

public class DataBaseConnection {
//   public static void DataBaseConn() throws SQLException {
//        String url="jdbc:mysql://localhost:3306/supermarket_database";
//        String username="root";
//        String password="rahul123";
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(url,username,password);
//
//            PreparedStatement ps=con.prepareStatement("insert into adminuserdetails values (?,?,?,?,?,?,?,?,?)");
//
//            ps.setInt(1,1003);
//            ps.setString(2,"dev123");
//            ps.setString(3,"dev123");
//            ps.setString(4,"dev");
//            ps.setString(5,"dev123@gmail.com");
//            ps.setLong(6, Long.parseLong("9785877233"));
//            ps.setString(7,"jaipur raj 302036");
//
//            LocalDateTime dateTime= LocalDateTime.now();
//
//            ps.setTimestamp(8,java.sql.Timestamp.valueOf(dateTime));
//            ps.setString(9,"User");
//
//
//
//            int check =ps.executeUpdate();
//            if (check >0) {
//                System.out.println("success");
//                System.out.println(dateTime);
//            }else {
//                System.out.println("fail");
//                System.out.println(dateTime);
//            }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
////        finally {
////            con.close();
////            ps.close();}
//
//    }


//    public PreparedStatement ps;

    public Connection DataBaseConn() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/supermarket_database";
        String username = "root";
        String password = "rahul123";
         Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            return con;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    //add user for the use this system by admin
    public boolean addUserForSystem() throws SQLException {

        Connection con=DataBaseConn();
        PreparedStatement ps=con.prepareStatement("insert into adminuserdetails (username, password, name, email_Id, mobile_no, address, date_time, user_type) values (?,?,?,?,?,?,?,?)");
//        PreparedStatement ps=null;
        try {

//            ps = con.prepareStatement("insert into adminuserdetails values (?,?,?,?,?,?,?,?,?)");
//            ps.setInt(1, 1005);
            ps.setString(1, "Shiv@123");
            ps.setString(2, "Shiv@123");
            ps.setString(3, "Shiv Sharma");
            ps.setString(4, "Shiv@gmail.com");
            ps.setLong(5, Long.parseLong("9780200446"));
            ps.setString(6, "jaipur raj 302026");

            LocalDateTime dateTime = LocalDateTime.now();

            ps.setTimestamp(7, java.sql.Timestamp.valueOf(dateTime));
            ps.setString(8, "User");


            int check = ps.executeUpdate();
            if (check > 0) {
                System.out.println("success ✔✔✔✔");
                System.out.println(dateTime);

                return true;
            } else {
                System.out.println("fail ❌❌❌❌");
                System.out.println(dateTime);
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
                con.close();
                ps.close();

        }
    }


    // add new item type function
    public boolean addItemtype() throws SQLException {

        Connection con=DataBaseConn();
        PreparedStatement ps=con.prepareStatement("insert into itemtypetable  values (?,?,?,?)");
        try {

            ps.setString(1, "1524BK");
            ps.setString(2, "Food");

            LocalDateTime dateTime = LocalDateTime.now();

            ps.setTimestamp(3, java.sql.Timestamp.valueOf(dateTime));
            ps.setString(4, "1005");


            int check = ps.executeUpdate();
            if (check > 0) {
                System.out.println("success ✔✔✔✔");
                System.out.println(dateTime);

                return true;
            } else {
                System.out.println("fail ❌❌❌❌");
                System.out.println(dateTime);
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
                con.close();
                ps.close();
        }
    }


    // insert new in database function
    public void addInsertNewStock( String[] purchaseDetails) throws SQLException {

        Connection con=DataBaseConn();
        PreparedStatement ps0 = con.prepareStatement("select item_ID from newstockpurchasedetalis");
        PreparedStatement ps1=con.prepareStatement("insert into newstockpurchasedetalis ( supplier_name, mobile_no, email_id, address, district, state, pincode, vehicle_no, vehicle_type, vehicle_driver_name, vehicle_driver_Id, driver_contact_no, item_ID, item_name, item_type, quantity, rate_per_piece, expiry_date, date_time, total_amount) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        PreparedStatement ps2 = con.prepareStatement("insert into itemsdetails values (?,?,?,?,?,?,?)");
//    purchaseDetails=com_name, String.valueOf(mob_no), email, com_address,district,State, String.valueOf(pincode),
//    vehicle_no, vehicle_type, vehicle_driver_name,vehicle_driver_Id, String.valueOf(driver_contact_no),
//    String.valueOf(item_id),product_name,product_type, String.valueOf(quantity), String.valueOf(rate), String.valueOf(expiry_date), String.valueOf(totalAmount);

//      supplier_id, supplier_name, mobile_no, email_id, address, district, state, pincode,     8
//       vehicle_no, vehicle_type, vehicle_driver_name, vehicle_driver_Id, driver_contact_no,   13
//       item_ID, item_name, item_type, quantity, rate_per_piece, expiry_date, date_time, total_amount
        try {

            // fetch supplier Id for database automatically

            ResultSet rs = ps0.executeQuery();
            int supplier_id=0;
            int item_ID=0;
            while (rs.next()){
//                 supplier_id = rs.getInt("supplier_id");
                item_ID = rs.getInt("item_ID");
            }



//            ps = con.prepareStatement("insert into newstockpurchasedetalis values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//            ps1.setInt(1, supplier_id+1);
            ps1.setString(1, purchaseDetails[0]);
            ps1.setLong(2,Long.parseLong(purchaseDetails[1]));
            ps1.setString(3,purchaseDetails[2]);
            ps1.setString(4,purchaseDetails[3]); // address
            ps1.setString(5,purchaseDetails[4]);
            ps1.setString(6,purchaseDetails[5]);
            ps1.setInt(7,Integer.parseInt(purchaseDetails[6])); //pincode
            ps1.setString(8,purchaseDetails[7]);
            ps1.setString(9,purchaseDetails[8]);
            ps1.setString(10,purchaseDetails[9]);
            ps1.setLong(11,Long.parseLong(purchaseDetails[10]));
            ps1.setLong(12,Long.parseLong(purchaseDetails[11])); //driver_contact_no
//            ps1.setInt(14,Integer.parseInt(purchaseDetails[12]));
            ps1.setInt(13,item_ID+1);
            ps1.setString(14,purchaseDetails[13]);
            ps1.setString(15,purchaseDetails[14]);
            ps1.setInt(16,Integer.parseInt(purchaseDetails[15]));
            ps1.setDouble(17,Double.parseDouble(purchaseDetails[16]));
            java.sql.Date sqlDate = java.sql.Date.valueOf(purchaseDetails[17]); // expiry_date
            ps1.setDate(18, sqlDate);
            LocalDateTime dateTime = LocalDateTime.now();   //date_time
            ps1.setTimestamp(19, java.sql.Timestamp.valueOf(dateTime));
            ps1.setDouble(20,Double.parseDouble(purchaseDetails[18]));

//            item_ID   int
//            item_name     varchar(30)
//            item_type     varchar(20) PK
//            quantity  int
//            rate_per_piece    decimal(10,2)
//            expiry_date   date
//            date_time     date
//            total_amount      decimal(10,2)
//            supplier_id   int
//            supplier_name     varchar(20)
//            mobile_no     bigint
//            email_id  varchar(25)
//            address   varchar(25)
//            district  varchar(20)
//            state     varchar(20)
//            pincode   mediumint
//            vehicle_no    varchar(15)
//            vehicle_type  varchar(15)
//            vehicle_driver_name   varchar(20)
//            vehicle_driver_Id     bigint
//            driver_contact_no     bigint

            // insert product details in itemsdetails table

//            PreparedStatement ps2 = con.prepareStatement("insert into itemsdetails values (?,?,?,?,?,?,?)");
//            ps2.setInt(1,Integer.parseInt(purchaseDetails[12]));          //  item_ID
            ps2.setInt(1,item_ID+1);
            ps2.setString(2,purchaseDetails[13]);                 //  item_name
            ps2.setString(3,purchaseDetails[14]);              //    item_type
            ps2.setInt(4,Integer.parseInt(purchaseDetails[15]));    //  quantity
            ps2.setDouble(5,Double.parseDouble(purchaseDetails[16]));   //   rate_per_piece
//            java.sql.Date sqlDate = java.sql.Date.valueOf(purchaseDetails[17]);    // expiry_date
            ps2.setDate(6, sqlDate);
            ps2.setDouble(7,Double.parseDouble(purchaseDetails[18]));   //  total_amount

//            item_ID   int PK
//            item_name     varchar(30)
//            item_type     varchar(15)
//            quantity  int
//            rate_per_piece    decimal(10,2)
//            expiry_date   date
//            total_amount  decimal(10,2)

            int check = ps1.executeUpdate();
            int check2= ps2.executeUpdate();
            if (check > 0) {
                System.out.println("success ✔✔✔✔");
                System.out.println(dateTime);

//                return true;
            } else {
                System.out.println("fail ❌❌❌❌");
                System.out.println(dateTime);
//                return false;
            }

            if (check2 > 0) {
                System.out.println("success ✔✔✔✔");
//                return true;
            } else {
                System.out.println("fail ❌❌❌❌");
//                return false;
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

                con.close();
                ps0.close();
                ps1.close();
                ps2.close();

        }
    }

    // fetch buyers details with product details
    public void fetchProductDetailsHistory() throws SQLException {

        Connection con=DataBaseConn();
        PreparedStatement ps=con.prepareStatement("select * from newstockpurchasedetalis");
        try {
//            ps = con.prepareStatement("select * from newstockpurchasedetalis");
            ResultSet rs = ps.executeQuery();

            System.out.printf(" | %-7s | %-12s | %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-13s | %-13s | %-13s |%n ",
                    "supplier_id", "supplier_name", "mobile_no", "email_id", "address", "district", "state", "pincode",
      "vehicle_no", "vehicle_type", "vehicle_driver_name", "vehicle_driver_Id", "driver_contact_no",
       "item_ID", "item_name", "item_type", "quantity", "rate_per_piece", "expiry_date"," date_time", "total_amount");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------+");

            while (rs.next()) {


                int supplier_id = rs.getInt("supplier_id");
                String supplier_name = rs.getString("supplier_name");
                Long mobile_no=rs.getLong("mobile_no");
                String email_id = rs.getString("email_id");
                String address = rs.getString("address");
                String district = rs.getString("district");
                String state = rs.getString("state");
                int pincode = rs.getInt("pincode");
                String vehicle_no = rs.getString("vehicle_no");
                String vehicle_type = rs.getString("vehicle_type");
                String vehicle_driver_name = rs.getString("vehicle_driver_name");
                Long vehicle_driver_Id=rs.getLong("vehicle_driver_Id");
                Long driver_contact_no=rs.getLong("driver_contact_no");
                int item_ID = rs.getInt("item_ID");
                String item_name = rs.getString("item_name");
                String item_type = rs.getString("item_type");
                int quantity = rs.getInt("quantity");
                double rate_per_piece = rs.getDouble("rate_per_piece");
                Date expiry_date = rs.getDate("expiry_date");
                Date date_time = rs.getDate("date_time");
                double total_amount = rs.getDouble("total_amount");

//                table format

                System.out.printf(" | %-7s | %-12s | %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-13s | %-13s | %-13s |%n  ",
                        supplier_id, supplier_name, mobile_no, email_id, address, district, state, pincode,
                       vehicle_no, vehicle_type, vehicle_driver_name, vehicle_driver_Id, driver_contact_no,
                       item_ID, item_name, item_type, quantity, rate_per_piece, expiry_date, date_time, total_amount);
                System.out.println("+--------------------------------------------------------------------------------------------------------------------+");
//                    System.out.println("| " + item_id + " | " + item_name + " | " + item_type + " | " + quantity + " | " + rate_per_piece + " | " + expiry_date + " | " + insert_date + " | " + total_amount + " | ");
            }
//                System.out.println("--------------------------------------------------------------------------------------------------------");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

                con.close();
                ps.close();

        }
    }



    // insert data into database for customer purchase details function
    public void insertCustomerPurchaseData() throws SQLException {

        Connection con=DataBaseConn();

        PreparedStatement ps1= con.prepareStatement("insert into selldetails (buyer_name, mobile_no, email_id, payment_type, date_time, item_ID, iteam_name, iteam_type, expiry_date, quantity, rate_per_piece, total_amount, discount) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        PreparedStatement ps2= con.prepareStatement("insert into balancesheet ( item_no, item_name, quantity, buy_price, sell_price, profit_per_piece, net_profit, date_Time) values (?,?,?,?,?,?,?,?)");
            try {

//            ps1.setInt(1,buyer_Id+1);
            ps1.setString(1,custDet[0]);
            ps1.setString(2, custDet[1]);
            ps1.setString(3, custDet[2]);
            ps1.setString(4, custDet[3]);
            LocalDateTime dateTime = LocalDateTime.now();
            ps1.setTimestamp(5,java.sql.Timestamp.valueOf(dateTime));
            int itemId=Integer.parseInt(custDet[4]);
            ps1.setInt(6, itemId);
                ps1.setString(7, custDet[9]);      //item_name
                ps1.setString(8, custDet[10]);      //item_type
                ps1.setDate(9, Date.valueOf(custDet[11]));        //expiry_date
            int quantity=Integer.parseInt(custDet[5]);
            ps1.setInt(10,quantity );
            ps1.setFloat(11, Float.parseFloat(custDet[6]));
            ps1.setFloat(12, Float.parseFloat(custDet[8]));
            ps1.setFloat(13, Float.parseFloat(custDet[7]));
                int check = ps1.executeUpdate();
//            String customDate="2024-11-15";
//            java.sql.Date sqlDate=java.sql.Date.valueOf(customDate);
//            ps.setDate(6,sqlDate);


//                ps2.setInt(1,002);             //serial_no  auto increment

                ps2.setInt(1,itemId);           // item_no   int
                ps2.setString(2, custDet[9]);       //item_name	   varchar(50)
                ps2.setInt(3, quantity);            //quantity	int
                ps2.setDouble(4,Double.parseDouble(custDet[13]));          //buy price
                ps2.setDouble(5, Double.parseDouble(custDet[6]));              //sell price
                double profit_per_piece=Double.parseDouble(custDet[6])-Double.parseDouble(custDet[13]);
                ps2.setDouble(6,profit_per_piece);       //profit_per_piece	decimal(10,2)
                ps2.setDouble(7, (profit_per_piece*quantity));       //net_profit	decimal(10,2)
                ps2.setTimestamp(8,java.sql.Timestamp.valueOf(dateTime));
                int check1= ps2.executeUpdate();

//                update table after customer purchase
                PreparedStatement ps3= con.prepareStatement("UPDATE itemsdetails SET quantity = ? WHERE item_ID = ?");
                ps3.setInt(1,Integer.parseInt(custDet[12])-quantity);
                ps3.setInt(2,itemId);
                int check2 = ps3.executeUpdate();

////                insert sells data into balance sheet table
//                PreparedStatement ps4= con.prepareStatement("UPDATE itemsdetails SET quantity = ? WHERE item_ID = ?");


            if (check > 0 && check1>0 && check2>0) {
                System.out.println("success ✔✔✔✔");
                System.out.println(dateTime);
            } else {
                System.out.println("fail ❌❌❌❌");
                System.out.println(dateTime);
            }
        } catch (SQLException e) {
//                System.out.println(e);
            throw new RuntimeException(e);
        } finally {
                ps1.close();
                con.close();
        }
    }


        // fetch database for available/current stock function
        public void fetchAvailableStock() throws SQLException {

            Connection con=DataBaseConn();
            PreparedStatement ps=con.prepareStatement("select * from itemsdetails");
            try {

//                ps = con.prepareStatement("select * from itemsdetails");
                ResultSet rs = ps.executeQuery();

                System.out.printf(" | %-7s | %-12s | %-10s | %-10s | %-15s | %-13s | %-13s |%n ",
                        "Item ID", "Item Name", "Item Type", "Quantity",
                        "Rate per Piece", "Expiry Date",  "Total Amount");
                System.out.println("+--------------------------------------------------------------------------------------------------------------------+");

//                System.out.println("--------------------------------------------------------------------------------------------------------");
//                System.out.println("| Item ID | Item name | Item type | Quantity | Rate per piece | Expiry date | Insert date| total_amount |");
                while (rs.next()) {


                    int item_id = rs.getInt("item_ID");
                    String item_name = rs.getString("item_name");
                    String item_type = rs.getString("item_type");
                    int quantity = rs.getInt("quantity");
                    double rate_per_piece = rs.getDouble("rate_per_piece");
                    Date expiry_date = rs.getDate("expiry_date");
//                    Date insert_date = rs.getDate("date_time");
                    double total_amount = rs.getDouble("total_amount");

//                System.out.println("    Item ID : "+item_id);
//                System.out.println("    Item name : "+item_name);
//                System.out.println("    Item type : "+item_type);
//                System.out.println("    Quantity : "+quantity);
//                System.out.println("    Rate per piece : "+rate_per_piece);
//                System.out.println("    Expiry date : "+expiry_date);
//                System.out.println("    Insert date : "+insert_date);
//                System.out.println("    Total Amount : "+total_amount);

//                table format


                    System.out.printf(" | %-7s | %-12s | %-10s | %-10s | %-15s | %-13s | %-13s |%n ",
                            item_id, item_name, item_type, quantity, rate_per_piece, expiry_date, total_amount);
                    System.out.println("+--------------------------------------------------------------------------------------------------------------------+");
//                    System.out.println("| " + item_id + " | " + item_name + " | " + item_type + " | " + quantity + " | " + rate_per_piece + " | " + expiry_date + " | " + insert_date + " | " + total_amount + " | ");
                }
//                System.out.println("--------------------------------------------------------------------------------------------------------");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                    con.close();
                    ps.close();
            }
        }




    // fetch database for sells history function
    public void fetchSellshistory()throws SQLException {

        Connection con=DataBaseConn();
        PreparedStatement ps=con.prepareStatement("select * from selldetails");
        try {

//            ps = con.prepareStatement("select * from selldetails");
            ResultSet rs = ps.executeQuery();

            System.out.printf(" | %-12s | %-12s | %-10s | %-20s | %-12s | %-10s | %-7s | %-8s | %-10s | %-10s | %-12s |%n",
                                "Customer ID","Name","Mobile no.","E-mail","Payment Type","Date-time","Item Id","Quantity","Rate/piece","Discount","Total amount");
            System.out.println(" +-----------------------------------------------------------------------------------------------------------------------------------------------------------+");

//            buyer_Id int AI PK
//            buyer_name varchar(30)
//            mobile_no varchar(11)
//            email_id varchar(25)
//            payment_type varchar(15)
//            date_time datetime
//            item_ID int
//            quantity int
//            rate_per_piece decimal(10,2)
//            total_amount decimal(10,2)
//            discount decimal(10,2)

            while (rs.next()) {
                int buyer_Id = rs.getInt("buyer_Id");
                String buyer_name = rs.getString("buyer_name");
                String mobile_no = rs.getString("mobile_no");
                String email_id = rs.getString("email_id");
                String payment_type = rs.getString("payment_type");
                Date date_time = rs.getDate("date_time");
                int item_ID = rs.getInt("item_ID");
                int quantity = rs.getInt("quantity");
                double rate_per_piece = rs.getDouble("rate_per_piece");
                double discount = rs.getDouble("discount");
                double total_amount = rs.getDouble("total_amount");


                System.out.printf(" | %-12s | %-12s | %-10s | %-20s | %-12s | %-10s | %-7s | %-8s | %-10s | %-10s | %-12s |%n",
                        buyer_Id, buyer_name, mobile_no, email_id, payment_type, date_time, item_ID, quantity, rate_per_piece, discount, total_amount);

                System.out.println(" +-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
                ps.close();
                con.close();


        }
    }



    }

