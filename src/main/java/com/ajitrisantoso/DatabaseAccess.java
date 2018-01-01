package com.ajitrisantoso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.*;
import java.sql.*;

public class DatabaseAccess {
	 private static final String dbuser = "root";
	    private static final String dbpasswd = "";
	    private Statement stmt = null;
	    static Connection con = null;
	    private ResultSet rs = null;

	    public DatabaseAccess() {
	        try {
	            Class.forName("org.gjt.mm.mysql.Driver");
	        } catch (ClassNotFoundException e) {
	            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "JDBC Error", JOptionPane.WARNING_MESSAGE);
	        }
	        try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost/sistempakarugd", dbuser, dbpasswd);
	            stmt = con.createStatement();
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Connection Error", JOptionPane.WARNING_MESSAGE);
	        }
	    }

	    public static void bukaKoneksi() {
	        try {
	        con = DriverManager.getConnection("jdbc:mysql://localhost/donorDarah", dbuser, dbpasswd);
	        }
	        catch (SQLException ex) {
	           }
	         }

	    public ResultSet getData(String SQLString) {
	        try {
	            rs = stmt.executeQuery(SQLString);
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
	        }
	        return rs;
	    }

	    public void query(String SQLString) {
	        try {
	            stmt.executeUpdate(SQLString);
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "error:" + e.getMessage());
	        }
	    }

}
