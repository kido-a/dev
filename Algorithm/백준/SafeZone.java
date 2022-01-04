package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SafeZone {
	static int[][] map;
	static int N;
	static int rain=0, safe=0;;
	static boolean[][] visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int result=0;
		
		for(int i=0;i<N;i++)
		{
			String[] s =br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j] = Integer.parseInt(s[j]);
				rain = Math.max(rain,Integer.parseInt(s[j]));
			}
		}
//		for(int i=0;i<N;i++)
//		{
//			System.out.println(Arrays.toString(map[i]));
//		}
		for (int r = 0; r <= rain-1; r++) {
			visit = new boolean[N][N];
			int count=0;
			safe=0;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(map[i][j]>r && !visit[i][j])
					{
						visit[i][j] = true;
						count++;
						safe++;
						dfs(i,j,r);
					}
				}
			}
//			System.out.println("높이 = "+r);
//			System.out.println("영역 갯수= "+count);
//			System.out.println("영역 넓이= "+safe);
			result = Math.max(result, count);
			
		}
		System.out.println(result);
		
	}
	private static void dfs(int x, int y ,int r) {
		
		int ax=0,ay=0;
		for(int i=0;i<4;i++)
		{
			ax = x +dx[i];
			ay = y+dy[i];
			if(ax>=0 && ax<N && ay>=0 && ay<N)
			{
				if(map[ax][ay]>r && !visit[ax][ay])
				{
					visit[ax][ay] = true;
					safe++;
					dfs(ax,ay,r);
				}
			}
		}
	}

}
