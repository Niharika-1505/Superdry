package com.superdry.client;

import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DesiredOperation {

	public static void main(String[] args) throws ScriptException {
		char[] operators = new char[] { '+', '-', '*' };
		combinationOfOperators(3, operators, "");
	}

	public static void combinationOfOperators(int length, char[] operators, String current) throws ScriptException {
		if (current.length() == length) {
			System.out.println(current);
			calculateSolution(current);
		} else {
			for (int i = 0; i < operators.length; i++) {
				String temp = current;
				current += operators[i];
				combinationOfOperators(length, operators, current);
				current = temp;
			}
		}
	}

	private static void calculateSolution(String operators) throws ScriptException {
		int num1, num2, num3, num4;
		Random random = new Random();
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");

		int result = 0;
		String operation = "";
		while (result != 16) {
			num1 = random.nextInt(101);
			num2 = random.nextInt(101);
			num3 = random.nextInt(101);
			num4 = random.nextInt(101);
			operation = String.valueOf(num1) + operators.charAt(0) + String.valueOf(num2) + operators.charAt(1)
					+ String.valueOf(num3) + operators.charAt(2) + String.valueOf(num4);
			result = (int) Double.parseDouble(engine.eval(operation).toString());
		}
		System.out.println(operation + "= 16");
	}
}
