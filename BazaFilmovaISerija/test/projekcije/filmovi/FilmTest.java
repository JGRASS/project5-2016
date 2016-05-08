package projekcije.filmovi;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilmTest {
	Film f;
	@Before
	public void setUp() throws Exception {
		f = new Film();
	}

	@After
	public void tearDown() throws Exception {
		f = null;
	}
	@Test
	public void testGetIme() {
		f.setIme("Hari Poter");
		assertEquals("Hari Poter", f.getIme());
	}

	@Test
	public void testSetIme() {
		String ime = "Hari Poter";
		f.setIme(ime);
		assertEquals(ime, f.getIme());
	}

	@Test
	public void testGetOcena() {
		f.setOcena(5);
		assertEquals(5, f.getOcena());
	}

	@Test
	public void testSetOcena() {
		int ocena = 4;
		f.setOcena(4);
		assertEquals(ocena, f.getOcena());
	}

	@Test
	public void testGetZanr() {
		f.setZanr("science-fiction");
		String zanr = f.getZanr();
		assertEquals(zanr, "science-fiction");
	}

	@Test
	public void testSetZanr() {
		String zanr = "Hari Poter";
		f.setZanr(zanr);
		assertEquals(zanr, f.getZanr());
	}

}
