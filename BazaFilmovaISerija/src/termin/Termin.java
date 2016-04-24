package termin;
import java.util.GregorianCalendar;
public class Termin {
	
	private GregorianCalendar termin;

	public GregorianCalendar getTermin(){
		return termin;
	}
	public void setTermin(GregorianCalendar termin){
		if(termin==null)
			throw new RuntimeException("Greska!");
		this.termin = termin;
	}
	@Override
	public String toString() {
		return "Termin [termin=" + termin + "]";
	}
	
	
}
