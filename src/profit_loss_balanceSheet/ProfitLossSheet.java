package profit_loss_balanceSheet;

import database_connect_pack.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfitLossSheet {

  public void balanceSheet() throws SQLException{

      DataBaseConnection db = new DataBaseConnection();
      Connection con= db.DataBaseConn();
          PreparedStatement ps1=con.prepareStatement("select * from selldetails where item_ID=?");
            ps1.setInt(1,105);
          PreparedStatement ps2=con.prepareStatement("select * from itemsdetails where item_ID=?");
            ps2.setInt(1,105);
          try {
              ResultSet rs = ps1.executeQuery();
              int item_ID=0 ;
              int quantity=0 ;
              double rate_per_piece=0;
              while (rs.next()) {
                  item_ID = rs.getInt("item_ID");
                  quantity = rs.getInt("quantity");
                  rate_per_piece = rs.getDouble("rate_per_piece");

                  System.out.println(item_ID + " " + quantity + " " + rate_per_piece);
              }
              ResultSet rs1 = ps2.executeQuery();
              int item_id_itemDetails=0 ;
              int quantity_itemDetails=0 ;
              double rate_per_piece_itemDetails=0;
              while (rs1.next()){

                  item_id_itemDetails = rs1.getInt("item_ID");
                  quantity_itemDetails = rs1.getInt("quantity");
                  rate_per_piece_itemDetails = rs1.getDouble("rate_per_piece");

                  System.out.println(item_id_itemDetails+" "+quantity_itemDetails+" "+rate_per_piece_itemDetails);
              }
              if (item_ID==item_id_itemDetails){
                  System.out.println(item_ID+" "+item_id_itemDetails);
                  System.out.println("profit");
                  System.out.println(rate_per_piece-rate_per_piece_itemDetails);
              }else {
                  System.out.println("We not have achieve");
              }

          }catch (SQLException e) {
              throw new RuntimeException(e);
          }finally {
              ps1.close();
              ps2.close();
              con.close();
          }
      }


  public void fetchLossProfitData(){

  }

}
