package projekcije.filmovi.zanr;

public class Zanr {
	private String imeZanra;

	public String getImeZanra() {
		return imeZanra;
	}

	public void setImeZanra(String imeZanra) {
		if(imeZanra.isEmpty() || imeZanra==null)
			throw new RuntimeException("Greska!");
		this.imeZanra = imeZanra;
	}
	
}
