import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberChecker {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		//get first user input string
		String firstNumber = scnr.nextLine();
		
		//check if first input string is an integer with stringTest method
		//terminate program if not
		if (stringTest(firstNumber)) {
			System.exit(0);
		}

		//get and store the length of the the first user-input integer
		int calFirst = firstNumber.length();
		System.out.println("Enter another " + calFirst + " digit integer:");
		//get second user input string
		String secondNumber = scnr.nextLine();
		
		//check if second input string is an integer with stringTest method
		//terminate program if not
		if (stringTest(secondNumber)) {
			System.exit(0);
		}

		//get and store the length of the the second user-input integer
		final int calSecond = secondNumber.length();
		
		//verify input integers are the same length
		//if so, send integers and their length to task method and checkIfIdentical method
		//if not print error message
		if (calFirst == calSecond) {
			List<Integer> sums = task(firstNumber, secondNumber, calSecond);
			System.out.println(checkIfIdentical(sums));
		} else {
			System.out.println("Your integers are different lengths, try again.");
			scnr.close();
		}
	}

	//check if input strings are integers, if not print error message
	public static boolean stringTest(String Number) {
		boolean Error = true;
		try {
			Integer.parseInt(Number);
			Error = false;
		} catch (NumberFormatException e) {
			System.out.println(Number + " is not an integer, try again.");
		}
		return Error;
	}

	public static List<Integer> task(String firstNumber, String secondNumber, int calSecond) {
		//split user input strings in individual numbers
		String[] table1 = firstNumber.split("");
		String[] table2 = secondNumber.split("");
		//create list to store results of task method
		List<Integer> sumList = new ArrayList<Integer>(calSecond);
		//pull out numbers from corresponding positions in input strings
		//convert them to integers
		for (int i = 0; i < calSecond; i++) {
			int j = Integer.parseInt(table1[i]);
			int k = Integer.parseInt(table2[i]);
			//add each pair of numbers and store result as int l
			//store resulting integers in list
			int l = j + k;
			sumList.add(l);
		}
		return sumList;
	}

	public static boolean checkIfIdentical(List<Integer> sumList) {
		//get size of resulting sumList (should be the same as calSecond)
		int listSize = sumList.size();
		//iterate through list, compare adjacent integers
		//if the integers are different, return false
		//if they're all the same, return true
		for (int i = 0; i < listSize - 1; i++) {
			int s1 = sumList.get(i);
			int s2 = sumList.get(i + 1);
			if (s1 != s2) {
				return false;
			}
		}
		return true;
	}
}
