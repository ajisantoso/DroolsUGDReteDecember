package com.ajitrisantoso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.ajitrisantoso.ItemSymptoms.Symptoms;
import com.lynden.gmapsfx.MainApp2;
import com.graphhopper.directions.api.examples.GeocodingMatrixDistance;
import com.ajitrisantoso.Operan;
import com.ajitrisantoso.User;
public class RunningMainClass {
	
	public String resultLat,resultLong;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variasi jika menggunakan DB
		DatabaseAccess db=new DatabaseAccess();
//	        int i=0;
//	        ResultSet rs=null;
//	        try{
//	            rs=db.getData("select * from tb_rs");
//	            while(rs.next()){
//	                System.out.println(rs.getString("nama_rs"));
//	                i++;
//	            }
//	            rs.close();
//	        }catch(Exception e){
//	        }


		try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
//        	 Object[] itemRS ={
//        		new ItemRS("RSUP Hasan Sadikin 1",1,1,1,"ADA","ADA","ONCALL",true),
//        		new ItemRS("RSUP Hasan Sadikin 2",1,1,0,"TIDAKADA","ADA","ONCALL",true),
//        		new ItemRS("RSUP Hasan Sadikin 3",1,0,1,"ADA","TIDAKADA","ONCALL",true),
//        		new ItemRS("RSUP Hasan Sadikin 4",0,1,0,"ADA","ADA","ONCALL",true),
//        		new ItemRS("RSUP Hasan Sadikin 5",0,0,1,"ADA","ADA","ADA",true)
//        	 };

        	 ItemRS rs1 = new ItemRS("RSUP Hasan Sadikin",1,1,1,1,1,"ADA","ADA","ADA","ADA","TIDAKADA","TIDAKADA","ADA",true);
        	 ItemRS rs2 = new ItemRS("RSU Pindad",0,1,0,0,0,"TIDAKADA","ADA","ONCALL","ADA","ADA","ONCALL","ADA",true);
     		 ItemRS rs3 = new ItemRS("RS Al Islam Bandung",1,0,1,1,0,"ADA","TIDAKADA","ONCALL","ADA","ADA","TIDAKADA","ADA",true);
     		 ItemRS rs4 = new ItemRS("RS Hermina Pasteur",0,1,0,0,1,"ADA","ADA","ADA","ADA","ADA","ONCALL","ADA",true);
     		 ItemRS rs5 = new ItemRS("RS Ibu dan Anak Limijati",0,0,1,0,0,"ADA","ADA","ADA","ADA","ADA","ADA","ADA",true);
     		 ItemRS rs6 = new ItemRS("RS Serba Ada",0,0,0,0,0,"ADA","ADA","ADA","ADA","ADA","ADA","ADA",true);

     		 kSession.insert(rs1);
     		 kSession.insert(rs2);
     		 kSession.insert(rs3);
     		 kSession.insert(rs4);
     		 kSession.insert(rs5);
     		 kSession.insert(rs6);

        	 //Contoh 1 Systolic
        	 ItemSymptoms item1 = new ItemSymptoms();
             item1.setTypeofSymptoms(Symptoms.SecondThirdBurn);
             String location = ("-1203,2131");
             kSession.insert(item1);
             
//             double resultLat=(-6.89702);
//             double resultLong=(107.59742);
//             String resultNamaRS=("Rumah Sakit Hasan Sadikin Bandung");
             
             double resultLat=(-6.933643);
             double resultLong=(107.623175);
             String resultNamaRS=("Rumah Sakit Muhammadiyah Bandung");

             
//             ItemSymptoms item2 = new ItemSymptoms();
//             item2.setTypeofSymptoms(Symptoms.PrematureChildbirth);
//             kSession.insert(item2);

             kSession.fireAllRules();
             
             //inisiasi User
             User user1 = new User();
//             user1.setUserLat(-6.891945);
//             user1.setUserLng(107.603991);          
//             user1.setUserPosName("Rumah Sakit Advent Bandung");
//             
             user1.setUserLat(-6.975353);
             user1.setUserLng(107.629601);          
             user1.setUserPosName("Telkom University");
                        
             
             //user1.saveUser();
             user1.updateUser(user1.getUserLat(), user1.getUserLng(),user1.getUserPosName());
             
             System.out.println(item1.getExpertRec());
           //Mencari 	RS waktu tempuh terpendek
             GeocodingMatrixDistance getMatrix = new GeocodingMatrixDistance(); 
             getMatrix.main(args);
                       
             
             MainApp2 openMap = new MainApp2();
             openMap.setLang(resultLat, resultLong);
             openMap.tesPassing="passing ini";
             Operan passOperan = new Operan();
             
             Operan resultRS = new Operan(resultNamaRS,resultLat,resultLong);
             //resultRS.saveOperan();            
             passOperan.updateOperan(resultLat,resultLong,resultNamaRS);
             //openMap.main(args,resultLat,resultLong);
             openMap.launchfromDrools(args, resultLat, resultLong);
             System.out.println("belum dipass"+openMap.getLat());
                        
             
             
             
             
            //System.out.println(item1.getExpertRec().toString());
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}

}
