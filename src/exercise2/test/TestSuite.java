package exercise2.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Uebung 2 - Suite Test
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

@RunWith(Suite.class)
@SuiteClasses( {
	ControllerAddressBookIntegrationTest.class,
	AddressBookControllerTest.class
})
public class TestSuite {

}
