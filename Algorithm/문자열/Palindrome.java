package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String[] S_Array = S.split("");
		StringBuffer sb = new StringBuffer();
		
		sb.append(S);
		
		int index = 0;
		int S_len = S.length();
		while(true)
		{
			if(check(sb))
			{
//				System.out.println(sb);
				System.out.println(sb.length());
				break;
			}
			else
			{
				sb.insert(S_len, S_Array[index]);
				index++;
			}
		}
	}

	private static boolean check(StringBuffer sb) {
		for (int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) != sb.charAt(sb.length()-i-1))
				return false;
		}
		return true;
	}

}
