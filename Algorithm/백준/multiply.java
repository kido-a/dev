package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class multiply {
	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		long A = Long.parseLong(s[0]);
		long B = Long.parseLong(s[1]);
		C = Long.parseLong(s[2]);
		
		System.out.println(pow(A,B));

	}

	private static long pow(long a, long b) {
		if(b==1)
			return a %C;
		
		long temp = pow(a,b/2);
		
		if(b%2==1)
		{
			return (temp * temp %C) * a%C;
		}
		
		return temp * temp % C;
	}

}
