package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Postfix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack();
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(')
			{
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i)==')')
			{
				while(!stack.isEmpty() && stack.peek()!='(')
				{
					result.append(stack.pop());
				}
				stack.pop();
			}
			else if(s.charAt(i) == '*' || s.charAt(i)=='/')
			{
				while(!stack.isEmpty() && (stack.peek()!='*' || stack.peek()!='/'))
				{
					if(stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-')
					{
						break;
					}
					result.append(stack.pop());
				}
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) =='+' || s.charAt(i)=='-')
			{
				while(!stack.isEmpty() && (stack.peek()!='*' || stack.peek()!='/'))
				{
					if(stack.peek() == '(')
					{
						break;
					}
					result.append(stack.pop());
				}
				stack.push(s.charAt(i));				
			}
			else
			{
				result.append(s.charAt(i));
			}
//			System.out.println(s.charAt(i));
//			System.out.println(result);
//			System.out.println(stack.toString());
		}
		while(!stack.isEmpty())
		{
			result.append(stack.pop());
		}
		System.out.println(result);

	}

}
