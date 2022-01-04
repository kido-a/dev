package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Combination {

	static int[] arr;
	static int n,m;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		
		for(int i=0;i<m;i++)
		{
			n1 = n1.multiply(new BigInteger(n-i+""));
			n2 = n2.multiply(new BigInteger(i+1+""));
		}
//		System.out.println(n1);
//		System.out.println(n2);
		System.out.println(n1.divide(n2));
	}

}
