package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GasStation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] distance = new long[N - 1];
		long[] price = new long[N - 1];
		long result=0;
		long min;

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N - 1; i++) {
			distance[i] = Integer.parseInt(s[i]);
		}
		s = br.readLine().split(" ");
		for (int i = 0; i < N - 1; i++) {
			price[i] = Integer.parseInt(s[i]);
		}
		min = price[0];
//		System.out.println(result);
		for(int i=0;i<N-1;i++)
		{
			if(price[i]<min)
			{
				min = price[i];
			}
			result = result + min*distance[i];
//			System.out.println(result);
		}
		
		System.out.println(result);
	}

}
