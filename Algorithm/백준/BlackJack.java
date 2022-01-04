package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BlackJack {
	static int min= 4000000;
	static int result= 0;
	static int M;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		int[] arr = new int[N];
		s = br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i] = Integer.parseInt(s[i]);
		}
		combination(arr,0,0,new int[3]);
		System.out.println(result);
	}

	private static void combination(int[] arr, int k, int idx, int[] sel) {
		if(k == sel.length)
		{
			int sum=0;
//			System.out.println(Arrays.toString(sel));
			for(int i=0;i<sel.length;i++)
			{
				sum = sum+sel[i];
			}
			if(Math.abs(M-sum)<min && sum<=M)
			{
				min =Math.abs(M-sum);
				result = sum;
//				System.out.println("min"+min);
//				System.out.println("result"+result);
			}
			return;
		}
		
		for(int i=idx;i<arr.length;i++)
		{
			sel[k] = arr[i];
			combination(arr,k+1,i+1,sel);
		}
		
	}

}
