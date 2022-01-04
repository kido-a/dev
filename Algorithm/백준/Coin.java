package BaekJun;

import java.util.Arrays;
import java.util.Scanner;

public class Coin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];
		int count=0;
		for(int i=0;i<N;i++)
		{
			int val = sc.nextInt();
			coin[i] = val;
		}
		
		while(K!=0)
		{
			for(int i=N-1;i>=0;i--)
			{
				if(coin[i]<=K)
				{
					K = K-coin[i];
					count++;
					break;
				}
			}
		}
		System.out.println(count);

	}

}
