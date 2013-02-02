package com.fastquake.eecalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EECalc {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		int selection = 0; //Selection number; corresponds to numbers displayed next to choices
		boolean valid = true;
		
		System.out.println("-----Electrical Engineering Calculator-----\n");
		System.out.println("Home");
		System.out.println("==========");
		
		System.out.println("1. Series/Parallel Components\n" +
				"2. Voltage Dividers\n" +
				"3. Resonant Circuits\n" +
				"4. RC Filters\n" +
				"5. Battery Life\n" +
				"6. Ohm's Law\n" +
				"7. Wavelength/Frequency Conversion\n");
		
		do{
			valid = true;
			selection = getSelection();
			switch(selection){
				case 1:
					seriesParallelMenu();
					break;
				case 2:
					//voltage dividers
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
					//ohm's law
					break;
				case 7:	
					//freqwave
					break;
				default:
					System.out.println("Invalid selection. Please try again.\n");
					valid = false;
					break;
			}
		}while(valid==false);
	}
	
	private static int getSelection(){
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
			} catch (IOException e) {
				System.out.println("An IOException has occurred. This should /NEVER/ happen!");
				e.printStackTrace();
				System.exit(1);
			}
		}while(valid == false); //Do this until the user enters something valid
		return selection;
	}
	private static void seriesParallelMenu(){
		int selection = 0;
		
		System.out.println("Series/Parallel Components");
		System.out.println("==========");
		System.out.println("1. Resistors\n" +
				"2. Capacitors\n" +
				"3. Inductors\n");
		selection = getSelection();
	}
}
