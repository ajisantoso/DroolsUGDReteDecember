package com.ajitrisantoso;
import java.sql.*;

public class Operan {
	private String namaOp;
	private double operanLat;
	private double operanLong;
	Operan(){
		
	}
	Operan(String n1,double c1,double c2){
		this.namaOp=n1;
		this.operanLat=c1;
		this.operanLong=c2;
	}
	
	public void setOperan(double newLat,double newLong) {
		operanLat = newLat;
		operanLong = newLong;
		};
	public double getOperanLat(){
		return operanLat;
	}
	
	public double getOperanLong(){
		return operanLong;
	}
	
	 public void updateOperan(double par1,double par2,String par3){
	        DatabaseAccess db=new DatabaseAccess();
	        String par4=Double.toString(par1);
	        String par5=Double.toString(par2);
	        //String s= "Update operan set operanLat= "+par4+", operanLong="+par5+" where nama_rs_operan="+par3+"";
	        String m= "UPDATE `operan` SET `operanLat`="+par4+",`operanLong`="+par5+",`nama_rs_operan`='"+par3+"' WHERE id_operan=2";
	        db.query(m);
	        System.out.println(m);
	    }
	 
	public void saveOperan() {
        DatabaseAccess db = new DatabaseAccess();
        String s = "INSERT INTO `operan`(`nama_rs_operan`, `operanLat`, `operanLong`) VALUES ('" + this.namaOp + "'," + this.operanLat + ",'" + this.operanLong +"')";
        db.query(s);
    }
}
