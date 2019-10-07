/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.AddressBookAccess;
import exercise2.addressbook.model.Gender;
import exercise2.addressbook.model.PhoneNumber;
import exercise2.addressbook.model.SizeLimitReachedException;
import junit.framework.Assert;


/**
 * Uebung 2 - Komponenten und Integrationstest
 * Komponententests für den Controller
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
public class AddressBookControllerTest {
	
	/*
	 *  Aufgabe 3
	 *  Führen Sie im Rahmen eines Komponententests der Klasse exercise2.addressbook.controller.AddressBookControllerImpl einen Test der Methode add(...) durch.
	 *  Schreiben Sie für die model und view Komponenten Mock-Up Klassen und verwenden Sie dies im Komponententest der AddressBookController Komponente.
	 *  Testen Sie die add() Methode auf Herz und Nieren - es sind durchaus Fehler zu finden.
	 */
	
	// Model component for the test
	AddressBookModelMockUp model;
	
	// View component for the test
	AddressBookViewMockUp view;
	
	// Controller component for the test
	AddressBookController controller;
	
	/**
	 * Set up test system
	 */
	@Before
	public void setUp() {
		// Instantiate and wire components
		this.model = new AddressBookModelMockUp();
		this.view = new AddressBookViewMockUp();
		this.controller = new AddressBookControllerImpl(model, view);
	}
	
	// TODO: Hier die Testfälle für den Komponententest hinschreiben
	
	@Test
	public void testAdd() {
		String firstName = "Hyerim";
		String lastName = "Hwang";
		String gender = "F";
		String phoneContactInformation = "1234";
		String emailContactInformation = "hh@gmail.com";
				
		try {
			controller.add(firstName, lastName, gender, 
					phoneContactInformation, emailContactInformation);
			fail("Should throw ParameterException");
		} catch (Exception e) {

		}
		
		try {
			controller.add(null, lastName, gender, 
					phoneContactInformation, emailContactInformation);
			fail("Should throw ParameterException");
		} catch (Exception e) {

		}
		
		try {
			controller.add(firstName, null, gender, 
					phoneContactInformation, emailContactInformation);
			fail("Should throw ParameterException");
		} catch (Exception e) {

		}
		
		try {
			controller.add(firstName, lastName, "A", 
					phoneContactInformation, emailContactInformation);
			fail("Should throw ParameterException");
		} catch (Exception e) {

		}
		
		try {
			controller.add(firstName, lastName, gender, 
					"aaaaa", emailContactInformation);
			fail("Should throw ParameterException");
		} catch (Exception e) {

		}
		
		try {
			controller.add(firstName, lastName, gender, 
					phoneContactInformation, "1233244");
			fail("Should throw ParameterException");
		} catch (Exception e) {

		}
		
		try {
			controller.add(firstName, lastName, "M", 
					null, emailContactInformation);
		} catch (Exception e) {

		}
		
		try {
			controller.add(firstName, lastName, "f", 
					phoneContactInformation, emailContactInformation);
		} catch (Exception e) {

		}
		
		try {
			controller.add(firstName, lastName, gender, 
					null, emailContactInformation);
		} catch (Exception e) {

		}
		
		try {
			controller.add(firstName, lastName, gender, 
					phoneContactInformation, null);
		} catch (Exception e) {

		}
		
		assertEqual(firstName, model.getFirstName());  
		assertEqual(lastName, model.getSurName());
		assertEqual(firstName, model.getEntry().getFirstName());
		assertEqual(lastName, model.getEntry().getSurName());
		assertTrue(view.isCreateCalled());
		assertTrue(view.isRefreshCalled());
		assertFalse(model.isEraseCalled());
		assertTrue(model.isAddEntryCalled());
		assertFalse(model.isGetEntryCalled()); 
		assertFalse(model.isLoadCalled());
		assertFalse(model.isSaveCalled());
		assertTrue(model.deleteEntry(null));
						
	}

	private boolean assertEqual(String firstName, String firstName2) {
		return firstName.equals(firstName2);		
	}
	

}
