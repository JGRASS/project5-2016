package projekcije.serije;

import java.util.LinkedList;

public class Serija {
	
	private String imeSerije;
	private int ocenaSerije;
	private double trajanjeSerije;
	public static LinkedList<Serija> serije = new LinkedList<Serija>();
	
	public String getImeSerije() {
		return imeSerije;
	}
	public void setImeSerije(String imeSerije) {
		if(imeSerije==null || imeSerije.isEmpty())
			throw new RuntimeException("Greska!");
		this.imeSerije = imeSerije;
	}
	public int getOcenaSerije() {
		return ocenaSerije;
	}
	public void setOcenaSerije(int ocenaSerije) {
		if(ocenaSerije>5 || ocenaSerije<0)
			throw new RuntimeException("Greska!");
		this.ocenaSerije = ocenaSerije;
	}
	public double getTrajanjeSerije() {
		return trajanjeSerije;
	}
	public void setTrajanjeSerije(double trajanjeSerije) {
		if(trajanjeSerije<=0)
			throw new RuntimeException("Greska!");
		this.trajanjeSerije = trajanjeSerije;
	}
	
	public LinkedList<Serija> getSerije() {
		return serije;
	}
	public void setSerije(LinkedList<Serija> serije) {
		this.serije = serije;
	}
	@Override
	public String toString() {
		return "Serija [Ime serije= " + imeSerije + ", Ocena= " 
					+ ocenaSerije + ", Trajanj= " + trajanjeSerije
						+ "]";
	}
	
	
}