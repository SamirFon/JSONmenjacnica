package rs.ac.bg.fon.ai.JSONMenjacnica;

import java.util.GregorianCalendar;

public class Transakcija {
	
	private String izvornaValuta ;
	private String krajnjaValuta; 
	
	private double početniIznos;
	private double konvertovaniIznos;
	
	private GregorianCalendar datumTransakcije;

	
	public String getIzvornaValuta() {
		return izvornaValuta;
	}

	
	public void setIzvornaValuta(String izvornaValuta) {
		this.izvornaValuta = izvornaValuta;
	}

	
	public String getKrajnjaValuta() {
		return krajnjaValuta;
	}

	
	public void setKrajnjaValuta(String krajnjaValuta) {
		this.krajnjaValuta = krajnjaValuta;
	}

	
	public double getPočetniIznos() {
		return početniIznos;
	}

	
	public void setPočetniIznos(double početniIznos) {
		this.početniIznos = početniIznos;
	}

	
	public double getKonvertovaniIznos() {
		return konvertovaniIznos;
	}

	
	public void setKonvertovaniIznos(double konvertovaniIznos) {
		this.konvertovaniIznos = konvertovaniIznos;
	}

	
	public GregorianCalendar getDatumTransakcije() {
		return datumTransakcije;
	}

	
	public void setDatumTransakcije(GregorianCalendar datumTransakcije) {
		this.datumTransakcije = datumTransakcije;
	}


	@Override
	public String toString() {
		return "Transakcija [izvornaValuta=" + izvornaValuta + ", krajnjaValuta=" + krajnjaValuta + ", početniIznos="
				+ početniIznos + ", konvertovaniIznos=" + konvertovaniIznos + ", datumTransakcije=" + datumTransakcije
				+ "]";
	}
	
	
	

}
