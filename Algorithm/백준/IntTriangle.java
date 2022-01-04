package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntTriangle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n+1][n+1];
		int[][] sum = new int[n+1][n+1];
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<s.length;j++)
			{
				tri[i][j] = Integer.parseInt(s[j]);
				if(i==0)
				{
					sum[0][0] = tri[0][0];
				}
				else if(i==1)
				{
					sum[1][0] = tri[1][0]+ tri[0][0];
					sum[1][1] = tri[1][1]+ tri[0][0];
				}
				else if(j==0)
				{
					sum[i][j] = sum[i-1][j]+tri[i][j];
				}
				else if(j==s.length-1)
				{
					sum[i][j] = tri[i][j]+sum[i-1][j-1];
				}
				else
				{
					sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j])+tri[i][j];
				}
			}
			
		}
		Arrays.sort(sum[n-1]);
		System.out.println(sum[n-1][n]);

	}

}
