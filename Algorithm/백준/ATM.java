package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		int sum=0;
		int time=0;
		for(int i=0;i<arr.length;i++)
		{
			time = time +arr[i];
			sum = sum+time;
		}
		
//		permutation(arr,new int[N],0,new boolean[N]);
		System.out.println(sum);
	}

//	private static void permutation(int[] arr, int[] sel, int k, boolean[] visit) {
//		System.out.println(Arrays.toString(sel));
//		int sum=0;
//		int time=0;
//		if(k==sel.length)
//		{
//			for(int i=0;i<sel.length;i++)
//			{
//				time = time +sel[i];
//				sum = sum+time;
//			}
//			if(result>sum)
//			{
//				result = sum;
//			}
//			return;
//		}
//		for(int i=0;i<arr.length;i++)
//		{
//			if(!visit[i])
//			{
//				sel[k] = arr[i];
//				visit[i] = true;
//				permutation(arr,sel,k+1,visit);
//				visit[i] = false;
//			}
//		}
//		
//	}

}
