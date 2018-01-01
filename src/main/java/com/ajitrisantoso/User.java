package com.ajitrisantoso;

import java.sql.ResultSet;

import com.lynden.gmapsfx.DatabaseAccess;

public class User {
	private double userLat;
	private double userLng;
	private String userPosName;
	
	public User(){
	}
	
	public double getUserLat() {
		return userLat;
	}
	public void setUserLat(double userLat) {
		this.userLat = userLat;
	}
	public double getUserLng() {
		return userLng;
	}
	public void setUserLng(double userLng) {
		this.userLng = userLng;
	}
	
	public void saveUser() {
        DatabaseAccess db = new DatabaseAccess();
        String s = "INSERT INTO `user`(`lat_user`, `lng_user`) VALUES ('"+this.userLat + "','" + this.userLng +"')";
        db.query(s);
        System.out.println(s);
    }
	
	public void updateUser(double par1,double par2,String par6){
        DatabaseAccess db=new DatabaseAccess();
        String par4=Double.toString(par1);
        String par5=Double.toString(par2);
        //String s= "Update operan set operanLat= "+par4+", operanLong="+par5+" where nama_rs_operan="+par3+"";
        String q= "UPDATE `user` SET `lat_user`="+par4+",`lng_user`="+par5+",`user_pos`='"+par6+"' WHERE `id_user`=1";
        db.query(q);
        
        System.out.println(q);
    }
	
	public String getUserLatDb(){
        String dbLat="";
        DatabaseAccess db=new DatabaseAccess();
        ResultSet rs;
        String s="select * from user where id_user=1;";
        rs=db.getData(s);
        try{
            while(rs.next()){
                dbLat=(rs.getString("lat_user"));
            }
        }catch(Exception e)   {javax.swing.JOptionPane.showMessageDialog(null, "Error"+e.getMessage());}
        return dbLat;       
    }
	public String getUserLongDb(){
        String dbLong="";
        DatabaseAccess db=new DatabaseAccess();
        ResultSet rs;
        String s="select * from user where id_user=1;";
        rs=db.getData(s);
        try{
            while(rs.next()){
                dbLong=(rs.getString("long_user"));
            }
        }catch(Exception e)   {javax.swing.JOptionPane.showMessageDialog(null, "Error"+e.getMessage());}
        return dbLong;       
    }	
	public String getOperanNama(String id){
        String namaRS="";
        DatabaseAccess db=new DatabaseAccess();
        ResultSet rs;
        String s="select * from operan where id_operan= '"+id+"';";
        rs=db.getData(s);
        try{
            while(rs.next()){
                namaRS=(rs.getString("nama_rs_operan"));
            }
        }catch(Exception e)   {javax.swing.JOptionPane.showMessageDialog(null, "Error"+e.getMessage());}
        return namaRS;       
    }

	public String getUserPosName() {
		return userPosName;
	}

	public void setUserPosName(String userPosName) {
		this.userPosName = userPosName;
	}
}
