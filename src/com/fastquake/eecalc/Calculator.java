package com.fastquake.eecalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
	public static double spResistance(){
		int config = -1; //1 for series, 2 for parallel
		double[] resistances = new double[50]; //Array to store resistances
		
		System.out.println("Series/Parallel Resistance");
		System.out.println("==========");
		System.out.print("Enter 1 for series or 2 for parallel: ");
		config = EECalc.getSelection();
		System.out.println("Enter the value of the first resistor (e.g. 10k): ");
		
		return 0;
	}
	
	private static double handleInput()
	{
		/* The purpose of this function is to
		 * parse the exponent modifiers (suffixes like k, pF, nH, etc.)
		 * and return a double containing a decimal representation of the number.
		 */
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String suffix = ""; //Unit suffix such as pF, nH, k, etc.
		String inputStr = ""; //Input string
		double inputNum = 0;
		
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
				suffix = inputStr.substring(i+1, inputStr.length()); //Get suffix, which should 
																	//be from the current point to the end of the string
				inputNum = Double.parseDouble(inputStr.substring(0,i));
			}
		}
		if(suffix == "MF" || suffix == "MH" || suffix == "M" ||
			suffix == "mF" || suffix == "mH")
		{
			inputNum = inputNum*Math.pow(10,6);
			return inputNum;
		}
		suffix = suffix.toLowerCase(); //Converts suffix to lowercase to make the input case-insensitive
		
		if(suffix == "pf" || suffix == "ph" || suffix == "p")
			inputNum = inputNum*Math.pow(10, -12);
		else if(suffix == "nf" || suffix == "nh" || suffix == "n")
			inputNum = inputNum*Math.pow(10, -9);
		else if(suffix == "uf" || suffix == "uh" || suffix == "u")
			inputNum = inputNum*Math.pow(10, -6);
		else if(suffix == "mf" || suffix == "mh" || suffix == "m")
			inputNum = inputNum*Math.pow(10,-3);
		else if(suffix == "f" || suffix == "h" || suffix == "")
			return inputNum;
		else if(suffix == "kf" || suffix == "kh" || suffix == "k")
			inputNum = inputNum*Math.pow(10, 3);
		return inputNum;
	}
}
