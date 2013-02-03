package com.fastquake.eecalc;

public class Menu {
	public static void seriesParallelMenu(){
		int selection = 0; //
		boolean valid = true;
		
		System.out.println("Series/Parallel Components");
		System.out.println("==========");
		System.out.println("1. Resistors\n" +
				"2. Capacitors\n" +
				"3. Inductors\n" +
				"0. Return to main menu\n");
		do{
			valid = true;
			selection = EECalc.getSelection();
			switch(selection){
			case 1:
				Calculator.spResistance();
				break;
			case 2:
				Calculator.spCapacitance();
				break;
			case 3:
				Calculator.spInductance();
				break;
			case 0:
				EECalc.main(null); //Go back to main method
				break;
			default:
				System.out.println("Invalid selection. Please try again.\n");
				valid = false;
				break;
			}
		}while(valid==false);
	}
	/*
	public static void voltageDividerMenu(){
		int selection = 0;
		boolean valid = true;
		
		System.out.println("Series/Parallel Components");
		System.out.println("==========");
		System.out.println("1. Resistive\n" +
				"2. Capacitive\n" +
				"0. Return to main menu\n");
		do{
			valid = true;
			selection = EECalc.getSelection();
			switch(selection){
			case 1:
				//resistive
				break;
			case 2:
				//capacitive
				break;
			case 0:
				EECalc.main(null); //Go back to main method
				break;
			default:
				System.out.println("Invalid selection. Please try again.\n");
				valid = false;
				break;
			}
		}while(valid==false);
	}
	*/
	public static void ohmsLawMenu(){
		int selection = 0;
		boolean valid = true;
		
		System.out.println("Series/Parallel Components");
		System.out.println("==========");
		System.out.println("1. Voltage\n" +
				"2. Current\n" +
				"3. Resistance\n" +
				"0. Return to main menu\n");
		do{
			valid = true;
			selection = EECalc.getSelection();
			switch(selection){
			case 1:
				//voltage
				break;
			case 2:
				//current
				break;
			case 3:
				//resistance
			case 0:
				EECalc.main(null); //Go back to main method
				break;
			default:
				System.out.println("Invalid selection. Please try again.\n");
				valid = false;
				break;
			}
		}while(valid==false);
	}
	public static void freqWaveMenu(){
		int selection = 0;
		boolean valid = true;
		
		System.out.println("Series/Parallel Components");
		System.out.println("==========");
		System.out.println("1. Frequency\n" +
				"2. Wavelength\n" +
				"0. Return to main menu");
		do{
			valid = true;
			selection = EECalc.getSelection();
			switch(selection){
			case 1:
				//frequency
				break;
			case 2:
				//wavelength
				break;
			case 0:
				EECalc.main(null); //Go back to main method
				break;
			default:
				System.out.println("Invalid selection. Please try again.\n");
				valid = false;
				break;
			}
		}while(valid==false);
	}
}
