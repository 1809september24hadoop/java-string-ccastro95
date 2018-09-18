package com.revature.string;

import java.util.Arrays;

import org.apache.log4j.Logger;

public class JavaStringSolution implements JavaString {

	private static final Logger LOGGER = Logger.getLogger(JavaStringSolution.class);

	@Override
	public int parseInteger(String number) throws IllegalArgumentException {

		int parseInteger = 0;

		if(number.isEmpty()) {
			throw new IllegalArgumentException("Error: There is no string argument for the operation to continue.");
		}
		for(int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if(Character.isDigit(c) == false) {
				throw new IllegalArgumentException("Error: There is a non-numerical character in the string.");
			}
		}
		parseInteger = Integer.parseInt(number);
		LOGGER.info(parseInteger);
		return parseInteger;
	}

	@Override
	public String reverse(String string) throws IllegalArgumentException {
		if(string.isEmpty()) {
			throw new IllegalArgumentException("Error: There is no string argument for the operation to continue.");
		}

		/*
		 * The following block utilizes a StringBuilder to print out the returned string,
		 * which will be the input string but in reverse.
		 */

		StringBuilder builder = new StringBuilder();
		for(int i = string.length() - 1; i >= 0; i--) {
			char c = string.charAt(i);
			builder.append(c);
		}
		LOGGER.info(builder.toString());
		return builder.toString();
	}

	@Override
	public void time(StringBuilder builder, StringBuffer buffer) throws IllegalArgumentException {
		String builderString = new String();
		String bufferString = new String();

		builderString = builder.toString();
		bufferString = buffer.toString();

		if(builderString.isEmpty() || bufferString.isEmpty()) {
			throw new IllegalArgumentException("Error: One of the arguments is empty,"
					+ " and therefore the operation cannot continue.");
		}
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100_000_000; i++) {
			builder.append('c');
		}
		long end = System.currentTimeMillis();
		long totalTime = end - start;
		LOGGER.info("Builder took: " + totalTime + "milliseconds");


		start = System.currentTimeMillis();
		for(int i = 0; i < 100_000_000; i++) {
			buffer.append('c');
		}
		end = System.currentTimeMillis();
		totalTime = end - start;
		LOGGER.info("Buffer took: " + totalTime + "milliseconds");
	}

	@Override
	public boolean itContains(String string, String contains) throws IllegalArgumentException {
		if(string.isEmpty()) {
			throw new IllegalArgumentException("Error: There is no string argument for the operation to continue.");
		}
		if(string.contains(contains)) {
			LOGGER.info("The phrase (" + contains + ") exists within (" + string + ").");
			return true;
		}
		LOGGER.info("The phrase (" + contains + ") does not exist within (" + string + ") (Case Sensitive).");
		return false;
	}

	@Override
	public String sort(String string) throws IllegalArgumentException {
		if(string.isEmpty()) {
			throw new IllegalArgumentException("Error: There is no string argument for the operation to continue.");
		}	
		char[] array = string.toCharArray();
		Arrays.sort(array); //using the wrapper of Array
		String result = new String(array);

		LOGGER.info(result);

		return result;
	}

	@Override
	public String delete(String string, char c) throws IllegalArgumentException {
		if(string.isEmpty()) {
			throw new IllegalArgumentException("Error: There is no string argument for the operation to continue.");
		}	
		String characterString = Character.toString(c);
		string = string.replace(characterString, ""); 
		//This does not "technically" delete the char, but it replaces it with an empty string.
		
		LOGGER.info(string);

		return string;
	}

	@Override
	public String upperLower(String string) throws IllegalArgumentException {
		if(string.isEmpty()) {
			throw new IllegalArgumentException("Error: There is no string argument for the operation to continue.");
		}	
		if(string.length() % 2 != 0) {
			throw new IllegalArgumentException("Error: The amount of characters in the string must be even.");
		}

		char[] array = string.toCharArray();
		for(int i = 0; i < string.length(); i++) {
			if(i < string.length()/2) {
				array[i] = Character.toUpperCase(array[i]);
			} else {
				array[i] = Character.toLowerCase(array[i]);
			}
		}

		LOGGER.info(new String(array));

		return new String(array);
	}

	public static void main(String[] args) {
		new JavaStringSolution().parseInteger("125866789");
		System.out.println();

		new JavaStringSolution().reverse("This is a test.");
		System.out.println();
		
		StringBuilder builder = new StringBuilder("Hello World");
		StringBuffer buffer = new StringBuffer("Hello World");

		new JavaStringSolution().time(builder, buffer);
		System.out.println();


		String string = "weoipaijfepwiajnvwpeqijeworl";
		String contains = "wor";
		new JavaStringSolution().itContains(string, contains);
		System.out.println();
		
		new JavaStringSolution().sort(string);
		System.out.println();

		char c = 'a';
		new JavaStringSolution().delete(string, c);
		System.out.println();

		new JavaStringSolution().upperLower(string);
	}

}
