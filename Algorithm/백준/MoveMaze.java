package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveMaze {
	static int[][] map = new int[8][8];
//	static boolean[][] visit = new boolean[8][8];
	static int[] dy = {-1, 0, 1, 0, 0, -1, 1, -1, 1};
	static int[] dx = {0, -1, 0, 1, 0, 1, -1, -1, 1};
	static int wall =0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> q = new LinkedList();
		
		for (int i = 0; i < 8; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				if(s.charAt(j)=='.')
					map[i][j] = 0;
				else
					map[i][j] = -1;
			}
		}
		
		q.add(new int[] {7,0,0});
		
		while(true)
		{
			if(q.isEmpty())
			{
				System.out.println("0");
				break;
			}
			int x = q.peek()[0];
			int y = q.peek()[1];
			int c = q.peek()[2];

			if(x==0)
			{
				System.out.println("1");
				System.exit(0);
			}
			
			if(c!=wall)
			{
				down();
			}
			
			if(map[x][y]==-1)
			{
				q.poll();
				continue;
			}
			q.poll();
			
			for(int i=0;i<9;i++)
			{
				int ax = x + dx[i];
				int ay = y + dy[i];
				if(ax>=0 && ax<8 && ay>=0 && ay<8){
					if(map[ax][ay] != -1)
					{
						map[ax][ay] = c+1;
						q.add(new int[] {ax,ay,c+1});
						if(ax==0 && ay==7)
						{
							System.out.println("1");
							return;
						}
					}
				}
			}
			q.add(new int[] {x,y,c+1});
		}
	}
	private static void down() {
		wall++;
		for (int i = 7; i >=0 ; i--) {
			for (int j = 7; j >= 0; j--) {
				if(map[i][j]==-1 && i!=7)
				{
					map[i][j]=0;
					map[i+1][j]=-1;
				}
				else if(map[i][j]==-1 && i==7)
				{
					map[i][j]=0;
				}
			}
		}
		
	}

}
