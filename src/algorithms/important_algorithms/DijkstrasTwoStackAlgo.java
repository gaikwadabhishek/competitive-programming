package algorithms.important_algorithms;

import java.util.Scanner;
import java.util.Stack;

public class DijkstrasTwoStackAlgo {

	public static void main(String[] args) {
		
		Stack<Double> value = new Stack<>();
		Stack<Character> operator = new Stack<>();
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		for(int i = 0; i < input.length(); i++) {
			char s = input.charAt(i);
			if(s == '(');
			else if(s == '+') operator.push(s);
			else if(s == '*') operator.push(s);
			else if(s == ')') {
				char op = operator.pop();
				if(op == '*') value.push(value.pop() * value.pop());
				else if(op == '+') value.push(value.pop() + value.pop());
			}
			else value.push(Double.parseDouble(String.valueOf(s)));
			
		}
		System.out.println("Answer is : "+value.pop());
		
	}
}
