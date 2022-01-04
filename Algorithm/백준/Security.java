package BaekJun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Security {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<int[]> list = new ArrayList<int[]>();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int[][] map = new int[Y + 1][X + 1];
		int N = sc.nextInt();
		int x, y;
		int result = 0;

		for (int i = 0; i < N; i++) {
			int d = sc.nextInt();
			if (d == 1) {
				int a = sc.nextInt();
				list.add(new int[] { d,0,a });
				map[0][a] = i + 1;
			} else if (d == 2) {

				int a = sc.nextInt();
				list.add(new int[] { d,Y ,a });
				map[Y][a] = i + 1;
			} else if (d == 3) {
				int a = sc.nextInt();
				list.add(new int[] { d, a,0 });
				map[a][0] = i + 1;
			} else if (d == 4) {
				int a = sc.nextInt();
				list.add(new int[] { d, a ,X});
				map[0][X] = i + 1;
			}
		}
		x = sc.nextInt();
		y = sc.nextInt();
		if (x == 1) {	//0,y
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i)[0] == 2)
				{
					int cnt1 =y+list.get(i)[2];
					int cnt2 = (X-y) + (X-list.get(i)[2]);
					if(cnt1>cnt2)	result+=cnt2+Y;
					else	result+=cnt1+Y;
				}
				else
				{
					result = result + list.get(i)[1]+Math.abs(y-list.get(i)[2]);
				}
			}
		}
		else if(x==2)
		{
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i)[0] == 1)
				{
					int cnt1 =y+list.get(i)[2];
					int cnt2 = (X-y) + (X-list.get(i)[2]);
					if(cnt1>cnt2)	result+=cnt2+Y;
					else	result+=cnt1+Y;
				}
				else
				{
					result = result + Math.abs(Y-list.get(i)[1])+Math.abs(y-list.get(i)[2]);
				}
			}
		}
		else if(x==3)
		{
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i)[0] == 4)
				{
					int cnt1 =y+list.get(i)[1];
					int cnt2 = (Y-y) + (Y-list.get(i)[1]);
					if(cnt1>cnt2)	result+=cnt2+X;
					else	result+=cnt1+X;
				}
				else
				{
					result = result + Math.abs(y-list.get(i)[1])+list.get(i)[2];
				}
			}
		}
		else if(x==4)
		{
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i)[0] == 3)
				{
					int cnt1 =y+list.get(i)[1];
					int cnt2 = (Y-y) + (Y-list.get(i)[1]);
					if(cnt1>cnt2)	result+=cnt2+X;
					else	result+=cnt1+X;
				}
				else
				{
					result = result + Math.abs(y-list.get(i)[1])+Math.abs(X-list.get(i)[2]);
				}
			}
		}
		
		System.out.println(result);

	}

}
