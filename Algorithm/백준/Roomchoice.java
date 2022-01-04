package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Roomchoice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s= br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int[][] st = new int[6][2]; 
		int result=0;
		
		for(int i=0;i<N;i++)
		{
			s= br.readLine().split(" ");
			int gender = Integer.parseInt(s[0]);	//여자0 남자1
			int cls =  Integer.parseInt(s[1]);
			
			st[cls-1][gender]++;
		}
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(st[i][j]!=0)
				{
					result++;
				}
				if(st[i][j]>K)
				{
					while(st[i][j]>K)
					{
						st[i][j]=st[i][j]-K;
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}

}
