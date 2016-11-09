package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class seMig {

    DB j = new DB();

    public static void main(String[] args) {
        seMig m = new seMig();
        m.getDataFromSql();

        DatabaseFacade dbf = new DatabaseFacade();

        // System.out.println(dbf.loadZip(0).getCity());
    }

    // Eksempel på at hente data, og endelig afslutte forbindelsen.
    public void getDataFromSql() {
        ResultSet rs = null;
        Statement stmt = null;
        try {
            //STEP 1: Execute a query
            System.out.println("Creating statement...");
            stmt = j.getConnection().createStatement();
            String sql;
            sql = "SELECT * FROM Zipcode";
            rs = stmt.executeQuery(sql);
            //STEP 2: Save ResultSet
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("addressId");
                //Display values
                System.out.print("ID: " + id);
            }
        } catch (SQLException ex) {
            /*Ignored*/

        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                /* ignored */ }
            try {
                stmt.close();
            } catch (SQLException e) {
                /* ignored */ }
            try {
                j.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }

}
