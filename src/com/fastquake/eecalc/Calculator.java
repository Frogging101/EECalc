package com.fastquake.eecalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
	public static void spResistance(){
		int config = -1; //1 for series, 2 for parallel
		boolean done = false; //This is set to true when the user is finished inputting values
		double[] resistances = new double[50]; //Array to store resistances
		int valueCount = 0; //Number of values in the array
		double resistance = 0; //Final calculated resistance
		
		System.out.println("Series/Parallel Resistance");
		System.out.println("==========");
		while(true){ //Loop until broken
			System.out.print("Enter 1 for series or 2 for parallel: ");
			config = EECalc.getSelection();
			if(config != 1 && config != 2){
				System.out.println("Invalid selection. Please try again."); //It can only be 1 or 2
				continue;}
			break;
			}
		System.out.println("Enter the value of the first resistor (e.g. 10k): ");
		resistances[0] = handleInput();
		for(int i=1;done==false;i++){
			System.out.println("Enter the value of another resistor, or enter 0 to end: ");
			double current = handleInput();
			if(current == 0){
				done = true; //If the user enters 0, they are done inputting values
				valueCount = i;} //Set value count to current index
			else
				resistances[i] = current; //Set current array index to inputted value
		}
		if(config == 1)
			for(int i=0;i<valueCount;i++)
				resistance += resistances[i];
		if(config == 2)
			for(int i=0;i<valueCount;i++){
				resistance += 1/resistances[i];
				resistance = 1/resistance;
			}
		System.out.println(resistance);
	}
	private static double handleInput()
	{
		/* The purpose of this function is to
		 * parse the exponent modifiers (suffixes like k, pF, nH, etc.)
		 * and return a double containing a decimal representation of the number.
		 */
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		boolean valid = true;
		boolean suffixExists = false; //If there is a suffix, this will be true
		String suffix = ""; //Unit suffix such as pF, nH, k, etc.
		String inputStr = ""; //Input string
		double inputNum = 0;
		do{
			valid = true;
			try {
				inputStr = input.readLine();
			} catch (IOException e) { //This seriously will never happen
				System.out.println("An IOException has occurred. This should /NEVER/ happen!"); //Scream
				e.printStackTrace(); //Burn
				System.exit(1); //Die
			}
			
			char c; //Character to check
			for(int i=0;i<inputStr.length();i++){
				c = inputStr.charAt(i);
				if(!Character.isDigit(c) && c != '.'){ //Checks if character is neither a number or a decimal point
					suffix = inputStr.substring(i, inputStr.length()); //Get suffix, which should 
																		//be from the current point to the end of the string
					suffixExists = true;
					inputNum = Double.parseDouble(inputStr.substring(0,i));
				}
				if(suffixExists)
					break;
			}
			if(!suffixExists)
				inputNum = Double.parseDouble(inputStr);
			if(suffix == "MF" || suffix == "MH" || suffix == "M" ||
				suffix == "mF" || suffix == "mH")
			{
				inputNum = inputNum*Math.pow(10,6);
				return inputNum;
			}
			suffix = suffix.toLowerCase(); //Converts suffix to lowercase to make the input case-insensitive
			
			if(suffix.equals("pf") || suffix.equals("ph") || suffix.equals("p"))
				inputNum = inputNum*Math.pow(10, -12);
			else if(suffix.equals("nf") || suffix.equals("nh") || suffix.equals("n"))
				inputNum = inputNum*Math.pow(10, -9);
			else if(suffix.equals("uf") || suffix.equals("uh") || suffix.equals("u"))
				inputNum = inputNum*Math.pow(10, -6);
			else if(suffix.equals("mf") || suffix.equals("mh") || suffix.equals("m"))
				inputNum = inputNum*Math.pow(10,-3);
			else if(suffix.equals("f") || suffix.equals("h") || suffix.equals(""))
				return inputNum;
			else if(suffix.equals("kf") || suffix.equals("kh") || suffix.equals("k"))
				inputNum = inputNum*Math.pow(10, 3);
			else{
				System.out.println("Invalid suffix. Please try again.");
				valid = false;}
			
		}while(valid == false);
		return inputNum;
	}
}
