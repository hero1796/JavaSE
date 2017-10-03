/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package QuotienWithException;

/**
 *
 * @author HungVu
 */
import java.util.Scanner;

public class QuotienWithException {
	private static Scanner input;

	public static int quotient(int number1, int number2) {
		if (number2 == 0)
			throw new ArithmeticException("Divisor cannot be zero");
		return number1 / number2;
	}

	public static void main(String[] args) {
		input = new Scanner(System.in);
		// 14 // Prompt the user to enter two integers
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();

		try {
			int result = quotient(number1, number2);
			System.out.println(number1 + " / " + number2 + " is " + result);
		} catch (ArithmeticException ex) {
			System.out.println("Exception: an integer " + "cannot be divided by zero ");
		}

		System.out.println("Execution continues ...");
	}
}