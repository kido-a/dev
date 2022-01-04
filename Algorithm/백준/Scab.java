package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Scab {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++)
		{
			int aquf=0,aehd=0,asp=0,atp=0;
			int bquf=0,behd=0,bsp=0,btp=0;
			
			String[] s = br.readLine().split(" ");
			int[] A = new int[Integer.parseInt(s[0])];
			for(int j=0;j<A.length;j++)
			{
				A[j] = Integer.parseInt(s[j+1]);
				if(Integer.parseInt(s[j+1]) == 1)	atp++;
				if(Integer.parseInt(s[j+1]) == 2)	asp++;
				if(Integer.parseInt(s[j+1]) == 3)	aehd++;
				if(Integer.parseInt(s[j+1]) == 4)	aquf++;
			}
			s = br.readLine().split(" ");
			int[] B = new int[Integer.parseInt(s[0])];
			for(int j=0;j<B.length;j++)
			{
				B[j] = Integer.parseInt(s[j+1]);
				if(Integer.parseInt(s[j+1]) == 1)	btp++;
				if(Integer.parseInt(s[j+1]) == 2)	bsp++;
				if(Integer.parseInt(s[j+1]) == 3)	behd++;
				if(Integer.parseInt(s[j+1]) == 4)	bquf++;
			}
			if((aquf>bquf) || (aquf==bquf && aehd>behd) || (aquf==bquf && aehd==behd && asp>bsp) || (aquf==bquf && aehd==behd && asp==bsp && atp>btp))
			{
				System.out.println("A");
			}
			else if(aquf==bquf && aehd==behd && asp==bsp && atp == btp)
			{
				System.out.println("D");
			}
			else
				System.out.println("B");
			
		}
		

	}

}
