package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class cheeze {
	static int N,M,air=2,preair=0;
	static int[][] map,countMap;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> q = new ArrayList();
		
		String s[] = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M];

		int cheezeCount=0;
		int time=0;
		
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j]==1)
				{
					cheezeCount++;
				}
			}
		}
		
		
		while(true)
		{
			q.add(new int[] {0,0});
			visit = new boolean[N][M];
			countMap = new int[N][M];
			visit[0][0]= true;
			if(cheezeCount <=0)
			{
				System.out.println(time);
				break;
			}
			while(!q.isEmpty())
			{
				int x = q.get(0)[0];
				int y = q.get(0)[1];
				q.remove(0);
				for(int i=0;i<4;i++)
				{
					int ax = x + dx[i];
					int ay = y + dy[i];
					if(ax>=0 && ax<N && ay>=0 && ay<M)
					{
						if((map[ax][ay] == preair || map[ax][ay]==0) && !visit[ax][ay])
						{
							visit[ax][ay] = true;
							map[ax][ay] =air;
							q.add(new int[] {ax,ay});
						}
						else if(map[ax][ay]==1 && countMap[ax][ay]==0)
						{
							countMap[ax][ay]++;
						}
						else if(map[ax][ay]==1 && countMap[ax][ay]==1)
						{
							map[ax][ay] =air;
							cheezeCount--;
						}
					}
				}
			}
			
			preair = air;
			air++;
			time++;
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("----------------------");
			
		}
		
		

	}

}
