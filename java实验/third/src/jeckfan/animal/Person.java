package jeckfan.animal;

import javax.swing.JOptionPane;

public class Person {

	private String name;
	private Person righter;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, Person righter) {
		this.name = name;
		this.righter = righter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getRighter() {
		return righter;
	}

	public void setRighter(Person righter) {
		this.righter = righter;
	}

}
