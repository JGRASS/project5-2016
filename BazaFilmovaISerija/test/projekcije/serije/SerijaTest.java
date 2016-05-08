package projekcije.serije;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SerijaTest {
	Serija s;
	@Before
	public void setUp() throws Exception {
		s = new Serija();
	}

	@After
	public void tearDown() throws Exception {
		s=null;
	}

	@Test
	public void testSetIme() {
		String naziv = "Ocajne domacice";
		s.setImeSerije(naziv);
		assertEquals(naziv, s.getImeSerije());
	}
	@Test
	public void testSetOcena(){
		int ocena = 5;
		s.setOcenaSerije(ocena);
		assertEquals(ocena, s.getOcenaSerije());
	}
	@Test
	public void testGetIme(){
		s.setImeSerije("Ocajne domacice");
		String ime = s.getImeSerije();
		assertEquals(ime, "Ocajne domacice");
	} 
	@Test
	public void testGetOcena(){
		s.setOcena(5);
		int ocena = s.getOcena();
		assertEquals(ocena, 5);
	}

}

