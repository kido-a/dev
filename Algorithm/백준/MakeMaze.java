package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MakeMaze {
	static int[][] map;
	static int[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N,result = Integer.MAX_VALUE;
	static Queue<int[]> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] s= br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		q = new LinkedList();
		q.add(new int[] {0,0});
		visit[0][0]=1;
		bfs();
		System.out.println(result-1);
		
	}
	private static void bfs() {
		
		if(q.isEmpty())
		{
			return;
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(visit[i]));
//		}
//		System.out.println();
		int x = q.peek()[0];
		int y = q.peek()[1];
		q.poll();
		if(x==N-1 && y == N-1)
		{
			result = Integer.min(result, visit[x][y]);
		}
		
		for(int i=0;i<4;i++)
		{
			int ax = x +dx[i];
			int ay = y +dy[i];
			if(ax >=0 && ax<N && ay>=0 && ay<N)
			{
				if(visit[x][y] < visit[ax][ay] && map[ax][ay]==1)
				{
					visit[ax][ay] = visit[x][y];
					q.add(new int[] {ax,ay});
				}
				else if(visit[x][y] < visit[ax][ay] && map[ax][ay]==0)
				{
					visit[ax][ay] = visit[x][y]+1;
					q.add(new int[] {ax,ay});
				}
			}
		}
		bfs();
	}

}
