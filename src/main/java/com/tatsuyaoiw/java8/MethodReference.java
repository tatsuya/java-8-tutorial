package com.tatsuyaoiw.java8;

import java.util.ArrayList;

/**
 * Method references help to point to methods by their names. A method reference is described using :: (double colon)
 * symbol. A method reference can be used to point the following types of methods:
 *
 * - Static methods
 * - Instance methods
 * - Constructors using new operator (TreeSet::new)
 */
public class MethodReference {
	public static void main(String args[]){
		ArrayList<String> names = new ArrayList<>();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");

		// Pass System.out::println method as a static method reference.
		names.forEach(System.out::println);
	}
}
