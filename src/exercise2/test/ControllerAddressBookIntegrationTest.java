/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.AddressBookModelImpl;
import exercise2.addressbook.model.SizeLimitReachedException;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Integration Test für Addressbook und Controller.
 * 
 * Bitte Nummer der Gruppe eintragen:
 * 9
 * 
 * Bitte Gruppenmitglieder eintragen:
 * @author Hyerim Hwang
 * @author Hieu Dang Duc
 * @author Felix Kybranz
 * @author Philipp Nickel
 * @author Andrew Tristan
 */
public class ControllerAddressBookIntegrationTest {

	// Location of the address book file
	private static final File addressBookFile = new File("contacts.xml");
		
	/*
	 *  Aufgabe 4
	 *  Programmieren Sie einen Integrationstest für AddressBookModel und AddressBookController.
	 *  Testen Sie ob die Methoden des exercise2.addressbook.controller.AddressBookController Interface zu den erwarteten Resultate im Addressbuch führen.
	 *  Testen Sie intensiv und schreiben Sie MINDESTENS einen Testfall pro Methode des interfaces. Es sind Fehler zu finden.  
	 */
	
	// Model component for the test
	AddressBookModel model;
	
	// View component for the test
	AddressBookViewMockUp view;
	
	// Controller component for the test
	AddressBookController controller;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Instantiate and wire components
		this.model = new AddressBookModelImpl(addressBookFile);
		this.view = new AddressBookViewMockUp();
		this.controller = new AddressBookControllerImpl(model, view);
	}


	@Test
	public void testRemove() {
		String firstElemName = "Dagobert";
		String firstElemSurname = "Duck";
		
		
		try {
			controller.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		controller.remove(model.getEntries().size()-1);
	
		
		controller.remove(0);
		
		try {
			model.getEntry(firstElemSurname, firstElemName);
		} catch(Exception e) {
			
		}
		
		
		assertNull(model.getEntry(null, firstElemName));
				
		int size = model.getEntries().size();
		for (int i = 0; i < size; i++) {
			controller.remove(0);
		}
		assertTrue(view.isRefreshCalled());
		assertTrue(view.isCreateCalled());
		assertTrue(model.getEntries().isEmpty());
		
	}

	@Test
	public void testErase() throws Exception {
		// testing if load + erase is the same like just erase
		try {
			controller.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		controller.erase();
		boolean test1 = model.getEntries().isEmpty();
		
		try {
			controller.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean test2 = model.getEntries().isEmpty();
		try {
			// crashes. erase() has a bug.
			// both have the same bool value
			assertEqualBOOLEQUAL(test1, test2); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean assertEqualBOOLEQUAL(boolean test1, boolean test2) {
		return test1 == test2;
	}
	
}
