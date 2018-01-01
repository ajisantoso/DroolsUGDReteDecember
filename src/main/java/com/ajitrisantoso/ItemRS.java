package com.ajitrisantoso;

public class ItemRS {

	public enum UGD {
		HasanSadikin,RSUPindad,SartikaAsih,AlIslam,SantoBorromeus,Advent,HerminaPasteur,SantoYusup
	}

	private String namaRS;
	private int VK;
	private int	ICU;
	private int ICCU;
	private int OR;
	private int kamarInap;
	private String DrUmum; //{ADA,ONCALL,TIDAKADA}
	private String DrSpKandungan; //{ADA,ONCALL,TIDAKADA}
	private String DrSpBedah; //{ADA,ONCALL,TIDAKADA}
	private String DrSpParu;
	private String DrSpSyaraf;
	private String DrSpUrologi;
	private String DrSpBedahTulang;
	private Boolean available;

	public ItemRS(String namaRS,int VK,int ICU,int ICCU,int OR,int kamarInap, String DrU,String DrSpK,String DrSpB,String DrSpParu,String DrSpSyaraf,String DrSpUrologi,String DrSpBedahTulang,Boolean available){
		this.namaRS = namaRS;
		this.VK = VK;
		this.ICU = ICU;
		this.ICCU = ICCU;
		this.setOR(OR);
		this.setKamarInap(kamarInap);
		this.DrUmum = DrU;
		this.DrSpKandungan = DrSpK;
		this.DrSpBedah = DrSpB;
		this.DrSpParu = DrSpParu;
		this.DrSpSyaraf = DrSpSyaraf;
		this.DrSpUrologi = DrSpUrologi;
		this.DrSpBedahTulang = DrSpBedahTulang;
		this.available = available;
	}

	public int getVK() {
		return VK;
	}
	public void setVK(int vK) {
		VK = vK;
	}
	public int getICCU() {
		return ICCU;
	}
	public void setICCU(int iCCU) {
		ICCU = iCCU;
	}
	public int getICU() {
		return ICU;
	}
	public void setICU(int iCU) {
		ICU = iCU;
	}
	public String getDrUmum() {
		return DrUmum;
	}
	public void setDrUmum(String drUmum) {
		DrUmum = drUmum;
	}

	public String getDrSpKandungan() {
		return DrSpKandungan;
	}
	public void setDrSpKandungan(String drSpKandungan) {
		DrSpKandungan = drSpKandungan;
	}
	public String getDrSpBedah() {
		return DrSpBedah;
	}
	public void setDrSpBedah(String drSpBedah) {
		DrSpBedah = drSpBedah;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getNamaRS() {
		return namaRS;
	}
	public void setNamaRS(String namaRS) {
		namaRS = namaRS;
	}

	public String getDrSpParu() {
		return DrSpParu;
	}

	public void setDrSpParu(String drSpParu) {
		DrSpParu = drSpParu;
	}

	public String getDrSpSyaraf() {
		return DrSpSyaraf;
	}

	public void setDrSpSyaraf(String drSpSyaraf) {
		DrSpSyaraf = drSpSyaraf;
	}

	public String getDrSpUrologi() {
		return DrSpUrologi;
	}

	public void setDrSpUrologi(String drSpUrologi) {
		DrSpUrologi = drSpUrologi;
	}

	public String getDrSpBedahTulang() {
		return DrSpBedahTulang;
	}

	public void setDrSpBedahTulang(String drSpBedahTulang) {
		DrSpBedahTulang = drSpBedahTulang;
	}

	public int getKamarInap() {
		return kamarInap;
	}

	public void setKamarInap(int kamarInap) {
		this.kamarInap = kamarInap;
	}

	public int getOR() {
		return OR;
	}

	public void setOR(int oR) {
		OR = oR;
	}

//	rule "Is available"
//	when
//	 $a : ItemSymptoms( Need )
//	then
//	 $a.setAvailable( false );
//	end

}
