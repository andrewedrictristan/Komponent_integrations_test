/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.model.AddressBookAccess;
import exercise2.addressbook.view.AddressBookView;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Mock-Up für den AddressBookView
 * 
 * Bitte Nummer der Gruppe eintragen:
 * 0
 * 
 * Bitte Gruppenmitglieder eintragen:
 * @author ...
 * @author ...
 * @author ...
 * @author ...
 */
public class AddressBookViewMockUp implements AddressBookView {
	private boolean isCreateCalled = false;
	private boolean isRefreshCalled = false;
	private AddressBookAccess adrBookAcc;
	private AddressBookController adrBookCont;
	
	@Override
	public void create(AddressBookAccess model, AddressBookController controller) {
		isCreateCalled = true;
		adrBookAcc = model;
		adrBookCont = controller;
		
	}

	@Override
	public void refresh() {
		isRefreshCalled = true;
		
	}
	
	public AddressBookAccess getModel () {
		return adrBookAcc;
	}
	
	public AddressBookController getController() {
		return adrBookCont;
	}

	public boolean isCreateCalled() { 
		return isCreateCalled;
	}
	
	public boolean isRefreshCalled() {
		return isRefreshCalled;
	}
	
}
