// Program: Terning BugFixes
// Version: 2.00
// Date created: 2014-06-10
// Last modified: 2016-09-24
// Author: B Christensen 
// Modified by: Agner Fog and Peter El-Habr

// Description:
// This program simulates roll of a die
// It has three errors:
// 1. The program asks the user how many times he wants the dice to roll.
//    If he doesn´t enter a valid number the program will crash. -> Fixed
// 2. The program rolls the dice one time less than asked -> Fixed
// 3. The dice is not symetric. It will roll too few ones and six'es -> Fixed


package terning;

import java.util.Scanner;

public class UseDice {

	public static void main(String[] args) {
		Dice cup = new Dice();   // Make an instance of Dice
		while(true){
			try{
				Scanner keyboard=new Scanner(System.in);   // Make an instance of keyboard Scanner
				System.out.println("Welcome to the diceroll program");
				System.out.println("How many times do you want to roll the dice?");

				int n = keyboard.nextInt();  // Read integer
				if (n>0){
					cup.rollMultiple(n);         // Roll the dice n times
					keyboard.close();            // Close the scanner
					break;
				}else System.out.println("The number must be >0");
			}catch(Exception error){
				System.out.println("Error: "+error);
				System.out.println("The number must be a int");
			}
		}
	}
}
