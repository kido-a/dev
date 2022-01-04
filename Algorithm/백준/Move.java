package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Move {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int[][] arr;
	static int N,L,R,sum;
	static ArrayList<int[]> list;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		L = Integer.parseInt(s[1]);
		R = Integer.parseInt(s[2]);
		arr = new int[N][N];
		list = new ArrayList<int[]>();
		visit = new boolean[N][N];
		
		for(int i=0;i<N;i++)
		{
			s = br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		for(int i=0;i<N;i++)
		{
			System.out.println(Arrays.toString(arr[i]));
		}
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = 0; j < arr.length; j++) 
			{
				if(!visit[i][j])
				{
					list.add(new int[] {i,j});
					dfs(i,j);
				}
			}	
		}
	}
	private static void dfs(int x, int y) 
	{
		int ax=0,ay=0;
		for(int i=0;i<4;i++)
		{
			ax = x + dx[i];
			ay = y + dy[i];
			if(ax>=0 && ax<N && ay>=0 && ay<N)
			{
				if(Math.abs(arr[x][y] - arr[ax][ay])>= L && Math.abs(arr[x][y] - arr[ax][ay]) <= R)
				{
					
				}
			}
		}
	}

}
