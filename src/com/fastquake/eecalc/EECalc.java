package com.fastquake.eecalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EECalc {
	static boolean started = false;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		int selection = 0; //Selection number; corresponds to numbers displayed next to choices
		boolean valid = true;
		
		if(started == false)
			System.out.println("-----Electrical Engineering Calculator-----\n");
		started = true;
		System.out.println("Home");
		System.out.println("==========");
		
		System.out.println("1. Series/Parallel Components\n" +
				"2. Voltage Dividers\n" +
				"3. Resonant Circuits\n" +
				"4. RC Filters\n" +
				"5. Battery Life\n" +
				"6. Ohm's Law\n" +
				"7. Wavelength/Frequency Conversion\n" +
				"0. Exit program\n");
		
		do{
			valid = true;
			selection = getSelection();
			switch(selection){
			case 1:
				Menu.seriesParallelMenu();
				break;
			case 2:
				Calculator.voltageDivider();
				break;
			case 3:
				//resonant circuits
				break;
			case 4:
				//rc filters
				break;
			case 5:
				//battery life
				break;
			case 6:
				Menu.ohmsLawMenu();
				break;
			case 7:	
				Menu.freqWaveMenu();
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Invalid selection. Please try again.\n");
				valid = false;
				break;
			}
		}while(valid==false);
	}
	
	public static int getSelection(){
		int selection = 0;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		boolean valid = true;
		do{
			valid = true;
			System.out.print("Enter a selection: ");
			try{
			selection = Integer.parseInt(input.readLine());}
			catch(NumberFormatException e){
				System.out.println("Invalid input. Please try again\n");
				valid = false;
			} catch (IOException e) { //This seriously will never happen
				System.out.println("An IOException has occurred. This should /NEVER/ happen!"); //Scream
				e.printStackTrace(); //Burn
				System.exit(1); //Die
			}
		}while(valid == false); //Do this until the user enters something valid
		System.out.println();
		return selection;
	}
}
