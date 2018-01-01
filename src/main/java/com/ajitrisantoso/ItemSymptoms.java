package com.ajitrisantoso;

public class ItemSymptoms {

	//total ada 31 symptom
	public enum Symptoms {
		 Systolic,Temperature,HeartbeatStopped,DifficultyBreathing,ChestPain,InternalBleedingBrain,
	     InternalBleedingAbdomenal,SuddenComa,InhaledMaterial,TraumaAndBleeding,CarAccidentOpen,BoneFracturePelvic,SkullFracture,InternalOrgan,
	     HeadParalysis,InternalOrganEviscerated,SecondThirdBurn,TrachelTrauma,SnakePoison,GunShot,Rape,PrematureChildbirth
	   }

	private Symptoms typeofSymptoms;
	private String expertRec;


	public Symptoms getTypeofSymptoms() {
		return typeofSymptoms;
	}
	public void setTypeofSymptoms(Symptoms typeofSymptoms) {
		this.typeofSymptoms = typeofSymptoms;
	}
	public String getExpertRec() {
		return expertRec;
	}
	public void setExpertRec(String expertRec) {
		this.expertRec = expertRec;
	}


}
