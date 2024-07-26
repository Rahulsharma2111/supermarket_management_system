package database_connect_pack;

import customer.BillGenerate;

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

    public Connection con;
    public PreparedStatement ps;

    public DataBaseConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/supermarket_database";
        String username = "root";
        String password = "rahul123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    //add user for the use this system by admin
    public boolean addUserForSystem() {
        try {
            ps = con.prepareStatement("insert into adminuserdetails values (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, 1005);
            ps.setString(2, "b123");
            ps.setString(3, "b123");
            ps.setString(4, "bbb");
            ps.setString(5, "bb123@gmail.com");
            ps.setLong(6, Long.parseLong("9780277113"));
            ps.setString(7, "jaipur raj 302037");

            LocalDateTime dateTime = LocalDateTime.now();

            ps.setTimestamp(8, java.sql.Timestamp.valueOf(dateTime));
            ps.setString(9, "User");


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
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }


    // add new item type function
    public boolean addItemtype() {

        try {
            ps = con.prepareStatement("insert into itemtypetable values (?,?,?,?)");
            ps.setInt(1, 1524);
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
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }


    // insert new in database function
    public boolean addInsertNewStock() {

        try {
            ps = con.prepareStatement("insert into newstock values (?,?,?,?,?,?,?,?)");
            ps.setInt(1, 103);
            ps.setString(2, "Cream Bell");
            ps.setString(3, "1557IC");
            ps.setInt(4, 35);
            ps.setDouble(5, 190.00);

            String customDate = "2024-11-15";
            java.sql.Date sqlDate = java.sql.Date.valueOf(customDate);
            ps.setDate(6, sqlDate);

            LocalDateTime dateTime = LocalDateTime.now();

            ps.setTimestamp(7, java.sql.Timestamp.valueOf(dateTime));
            ps.setDouble(8, 35 * 190.00);


//            item_ID int
//            item_name varchar(30)
//            item_type varchar(20) PK
//            quantity int
//            rate_per_piece decimal(10,2)
//            expiry_date date
//            date_time date
//            total_amount decimal(10,2)

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
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }


    // insert data into database for customer purchase details function
    public boolean insertCustomerPurchaseData() {
//        System.out.println(custDet[8]);
        for (int i = 0; i < custDet.length; i++) {
            System.out.println(i+" : "+ custDet[i]);
        }

        if (custDet==null){
            System.out.println("Array customer details is null");
            return false;
        }
        try {
            ps = con.prepareStatement("insert into buyersdetails values (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,102);
            ps.setString(2,custDet[0]);
            ps.setString(3, custDet[1]);
            ps.setString(4, custDet[2]);
            ps.setString(5, custDet[3]);
            LocalDateTime dateTime = LocalDateTime.now();
            ps.setTimestamp(6,java.sql.Timestamp.valueOf(dateTime));
            int itemId=Integer.parseInt(custDet[4]);
            ps.setInt(7, itemId);
            int quantity=Integer.parseInt(custDet[5]);
            ps.setInt(8,quantity );
            ps.setFloat(9, Float.parseFloat(custDet[6]));
            ps.setFloat(10, Float.parseFloat(custDet[8]));
            ps.setFloat(11, Float.parseFloat(custDet[7]));

//            String customDate="2024-11-15";
//            java.sql.Date sqlDate=java.sql.Date.valueOf(customDate);
//            ps.setDate(6,sqlDate);

//            buyer_Id int AI PK
//            buyer_name varchar(30)    name
//            mobile_no bigint      mob_no
//            email_id varchar(25)      email
//            payment_type varchar(15)      payment_type
//            date_time datetime
//            item_ID int       item_id
//            quantity int      quantity
//            rate_per_piece decimal(10,2)      rate
//            total_amount decimal(10,2)      payable_amount
//            discount int      discountAmount

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
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }


        // fetch database for available/current stock function
        public void fetchAvailableStock() {

            try {
                ps = con.prepareStatement("select * from newstock");
                ResultSet rs = ps.executeQuery();

                System.out.printf(" | %-7s | %-12s | %-10s | %-10s | %-15s | %-13s | %-13s | %-13s |%n ",
                        "Item ID", "Item Name", "Item Type", "Quantity",
                        "Rate per Piece", "Expiry Date", "Insert Date", "Total Amount");
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
                    Date insert_date = rs.getDate("date_time");
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


                    System.out.printf(" | %-7s | %-12s | %-10s | %-10s | %-15s | %-13s | %-13s | %-13s |%n ",
                            item_id, item_name, item_type, quantity, rate_per_piece, expiry_date, insert_date, total_amount);
                    System.out.println("+--------------------------------------------------------------------------------------------------------------------+");
//                    System.out.println("| " + item_id + " | " + item_name + " | " + item_type + " | " + quantity + " | " + rate_per_piece + " | " + expiry_date + " | " + insert_date + " | " + total_amount + " | ");
                }
//                System.out.println("--------------------------------------------------------------------------------------------------------");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    con.close();
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        }


//
    }

