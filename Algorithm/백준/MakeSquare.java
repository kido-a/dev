package BaekJun;

import java.util.Scanner;

public class MakeSquare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int cnt=0;
		for(int i=1;i<=N;i++)
		{
			int count=0;
			for(int j=1;j<=i;j++)
			{
				if(i%j==0)
				{
					count++;
				}
			}
			if(count%2==0)
			{
				cnt=cnt+count/2;
			}
			else
			{
				cnt=cnt+count/2+1;
			}
//			System.out.println(i+"의약수갯수"+count);
		}
		System.out.println(cnt);
	}

}
