/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import java.io.IOException;
import java.util.Collection;
import java.util.SortedSet;

import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.Contact;
import exercise2.addressbook.model.EmailAddress;
import exercise2.addressbook.model.Entry;
import exercise2.addressbook.model.Gender;
import exercise2.addressbook.model.SizeLimitReachedException;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Mock-Up für das AddressBookModel
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
public class AddressBookModelMockUp implements AddressBookModel {
	private boolean isAddEntryCalled = false;
	private boolean isGetEntryCalled = false;
	private boolean eraseCalled = false;
	private boolean loadCalled = false;
	private boolean saveCalled = false;
	private SortedSet<Entry> entries;
	private Entry entry = new Entry();
	private Entry deleteEntry = new Entry();
	private String surName;
	private String firstName;
	
	@Override
	public boolean addEntry(Entry en){
		isAddEntryCalled = true;	
		entry = en;
		return isAddEntryCalled;
	}
	
	public Entry getEntry() {
		return entry;
	}
	
	@Override
	public Entry getEntry(String surName, String firstName) {
		isGetEntryCalled = true;
		this.surName = surName;
		this.firstName = firstName;
		
		return new Entry();
	}
	
	public boolean isGetEntryCalled() {
		return isGetEntryCalled;
	}
	
	public boolean isAddEntryCalled() {
		return isAddEntryCalled;
	}

	@Override
	public Collection<Entry> getEntries() {
		return entries;
	}

	@Override
	public boolean deleteEntry(Entry entry) {
		deleteEntry = entry;
		return true;
	}
	
	public Entry getDeleteEntry() {
		return deleteEntry;
	}

	@Override
	public void erase() {
		eraseCalled = true;
		
	}

	@Override
	public void load() throws IOException {
		loadCalled = true;
		
	}

	@Override
	public void save() throws IOException {
		saveCalled = true;
		
	}
	
	public boolean isEraseCalled() {
		return eraseCalled;
	}

	public boolean isLoadCalled() {
		return loadCalled;
	}

	public boolean isSaveCalled() {
		return saveCalled;
	}

	public String getSurName() {
		return surName;
	}

	public String getFirstName() {
		return firstName;
	}

	
	
	
}
