package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class YouthShark {
	static int shark_x=0,shark_y=0,shark_d;
	static boolean[] fish;
	static int[][] map;
	static int[][] dir;
	static boolean[][] visit;
	static int[] dx = {0,-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,0,-1,-1,-1,0,1,1,1};
	static int result=0,eatSum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[4][4];
		dir = new int[4][4];
		fish = new boolean[17];
		visit = new boolean[4][4];
		
		for(int i=0;i<4;i++)
		{
			String[] s = br.readLine().split(" ");
			for(int j=0;j<8;j++)
			{
				if(j%2==0)
				{
					map[i][j/2] = Integer.parseInt(s[j]);
				}
				else
					dir[i][j/2] = Integer.parseInt(s[j]);
			}
		}
		fish[map[0][0]] = true;
		eatSum = eatSum + map[0][0];
		map[0][0] = -1;
		shark_d = dir[0][0];

		fishMove();
		eatFish();
		
	}
	private static void eatFish() {
		int ax = shark_x + dx[shark_d];
		int ay = shark_y + dy[shark_d];
		map[shark_x][shark_y] = 0;
		if(ax>=0 && ax<4 && ay>=0 && ay<4)
		{
			if(!visit[ax][ay] && map[ax][ay]!=0)
			{
				visit[ax][ay] = true;
				int fishSize = map[ax][ay];
				eatSum = eatSum + fishSize;
				shark_d = dir[ax][ay];
				map[ax][ay] = -1;
				fish[map[ax][ay]] = true;
				fishMove();
				eatFish();
			}
		}
		
	}
	private static void fishMove() {
		for(int i=1;i<17;i++)
		{
			if(fish[i])
				continue;
			Loop1 :
			for(int j=0;j<4;j++)
			{
				Loop2 :
				for(int k=0;k<4;k++)
				{
					if(map[j][k]==i)
					{
//						System.out.println(map[j][k]+"번 물고기 좌표 "+j+" "+k);
						int aj = j+dx[dir[j][k]];
						int ak = k+dy[dir[j][k]];
						
						if(check(aj,ak))
						{
							int temp = map[aj][ak];
							int temp_d = dir[aj][ak];
							map[aj][ak] = map[j][k];
							dir[aj][ak] = dir[j][k];
							map[j][k] = temp;
							dir[j][k] = temp_d;
							break Loop1;
						}
						else
						{
							int[] a_value = rotation(j,k);
							aj = a_value[0];
							ak = a_value[1];
							int temp = map[aj][ak];
							int temp_d = dir[aj][ak];
							map[aj][ak] = map[j][k];
							dir[aj][ak] = dir[j][k];
							map[j][k] = temp;
							dir[j][k] = temp_d;
							break Loop1;
						}
						
					}
				}
			}
//			for(int j=0;j<4;j++)
//			{
//				System.out.println(Arrays.toString(map[j]));
//			}
//			System.out.println("---");
//			for(int j=0;j<4;j++)
//			{
//				System.out.println(Arrays.toString(dir[j]));
//			}
//			System.out.println("====");
		}
		
	}
	private static int[] rotation(int aj, int ak) {
		int x = aj;
		int y = ak;
		int d = +dir[x][y];
//		System.out.println("현재 방향:"+d);
		while(true)
		{
//			System.out.println("45도 반시계회전");
			if(d+1>8)
			{
				d = d+1-8;
			}
			else
			{
				d++;		
			}
//			System.out.println("회전된 방향:"+d);
			x = aj + dx[d];
			y = ak + dy[d];
//			System.out.println("체크로 들어가기전"+x+" "+y);
			if(check(x,y))
				return new int[] {x,y};
		}
	}
	private static boolean check(int aj, int ak) {
		if(aj>=0 && aj<4 && ak>=0 && ak<4)
		{
			if(map[aj][ak]!=-1)
			{
				return true;				
			}
		}
		
		return false;
	}

}
