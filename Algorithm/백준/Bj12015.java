package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Bj12015 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int result=0;
		
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i] = Integer.parseInt(s[i]);
		}
//		System.out.println(Arrays.toString(arr));
		for(int i=0;i<N;i++)
		{
			int cnt =0;
			int val = arr[i];
			for(int j=i;j<N;j++)
			{
				if(val>=arr[j] && cnt==0)
				{
					continue;
				}
				if(val < arr[j])
				{
					cnt++;
					val = arr[j];
				}
			}
			result = Math.max(cnt, result);
		}
		System.out.println(result+1);
	}

}
