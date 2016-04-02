package com.tatsuyaoiw;

/**
 * Lambda expressions are introduced in Java 8. Lambda expression facilitates functional programming, and simplifies the
 * development a lot. A lambda expression is characterized by the following syntax:
 *
 *     parameter -> expression body
 *
 * Following are the important characteristics of a lambda expression:
 *
 * - Optional type declaration: No need to declare the type of a parameter. The compiler can inference the same from
 *   the value of the parameter.
 * - Optional parenthesis around parameter: No need to declare a single parameter in parenthesis. For multiple
 *   parameters, parentheses are required.
 * - Optional curly braces: No need to use curly braces in expression body if the body contains a single statement.
 * - Optional return keyword: The compiler automatically returns the value if the body has a single expression to return
 *   the value. Curly braces are required to indicate that expression returns a value.
 */
public class LambdaTester {
	final static String salutation = "Hello! ";

	public static void main(String args[]){
		LambdaTester tester = new LambdaTester();

		// With type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// With out type declaration
		MathOperation subtraction = (a, b) -> a - b;

		// With return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> { return a * b; };

		// Without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		// With parenthesis
		GreetingService greetService1 = (message) ->
				System.out.println("Hello " + message);

		// Without parenthesis
		GreetingService greetService2 = message ->
				System.out.println("Hello " + message);

		// Using lambda expression, you can refer to final variable or effectively final variable (which is assigned
		// only once). Lambda expression throws a compilation error, if a variable is assigned a value the second time.
		GreetingService greetService3 = message ->
				System.out.println(salutation + message);

		greetService1.sayMessage("Mahesh");
		greetService2.sayMessage("Mahesh");
		greetService3.sayMessage("Mahesh");
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation){
		return mathOperation.operation(a, b);
	}
}
