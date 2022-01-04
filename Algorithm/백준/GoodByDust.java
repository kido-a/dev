package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoodByDust {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int R;
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		int T = Integer.parseInt(s[2]);
		
		int[][] room = new int[R][C];
		int[][] room_copy = new int[R][C];
		
		int clean_x;
		int clean_y;
		
		for(int i=0; i<R;i++)
		{
			s = br.readLine().split(" ");
			for(int j=0;j<C;j++)
			{
				room[i][j] = Integer.parseInt(s[j]);
			}
		}
		for(int t = 0; t<T; t++) //t초
		{
			for(int i=0; i<R;i++) //미세먼지 확산
			{
				for(int j=0;j<C;j++)
				{
					if(room[i][j] > 0) //미세먼지면
					{
						int cnt =0;
						for(int k=0;k<4;k++) // 상하좌우 검사
						{
							int x = i;
							int y = j;
							x = x + dx[k];
							y = y + dy[k];
							if(x>=0 && x<R && y>=0 && y<C)
							{	
								if(room[x][y] != -1) //걸리는게 없으면
								{
									room_copy[x][y] = room_copy[x][y] + room[i][j]/5; //카피배열에 확산 양 넣기
									cnt++;	//횟수 증가
								}
							}
						}
						room_copy[i][j] = room_copy[i][j] + (room[i][j] - room[i][j]/5 *cnt); //남은 양 카피배열에 넣기   
					}
				}
			}
			copy_array(room,room_copy,-1, -1); //본배열에 카피배열 복사, 카피배열 초기화
			room_copy = new int[R][C];
			
			//공기청정기 가동
			int check =0; // 위꺼인지 아래꺼인지
			for(int i=0; i<R;i++) //공기청정기 발견
			{
				if(room[i][0] == -1 && check==0)
				{
					for(int j=1;j<C-1;j++)
					{
						room_copy[i][j+1] = room[i][j];
					}
					for(int j=i;j>0;j--)
					{
						room_copy[j-1][C-1] = room[j][C-1];
					}
					for(int j=C-1;j>0;j--)
					{
						room_copy[0][j-1] = room[0][j];
					}
					for(int j=0;j<i;j++)
					{
						if(room[j+1][0] != -1)
						{
							room_copy[j+1][0] = room[j][0];
						}
					}
					copy_array(room,room_copy,i,check);
					room_copy = new int[R][C];
					check++;
				}
				else if(room[i][0]== -1 && check != 0)
				{
					for(int j=1;j<C-1;j++)
					{
						room_copy[i][j+1] = room[i][j];
					}
					for(int j=i;j<R-1;j++)
					{
						room_copy[j+1][C-1] = room[j][C-1];
					}
					for(int j=C-1;j>0;j--)
					{
						room_copy[R-1][j-1] = room[R-1][j];
					}
					for(int j=R-1;j>i;j--)
					{
						if(room[j-1][0] != -1)
						{							
							room_copy[j-1][0] = room[j][0];
						}
					}
					copy_array(room,room_copy,i,check);
					room_copy = new int[R][C];
					check=0;
				}
			}
			
		}
		int sum=0; // 답
//		for(int i=0; i<R;i++)
//		{
//			System.out.println(Arrays.toString(room[i]));
//		}
		for(int i=0; i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				sum = sum + room[i][j];
			}
		}
		System.out.println(sum+2);
	}

	private static void copy_array(int[][] room, int[][] room_copy,int d, int check) {
		if(d ==-1 && check == -1) //전체복사
		{			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(room[i][j] != -1)
					{
						
						room[i][j] = room_copy[i][j];
					}
				}
			}
		}
		else if(d != -1 && check ==0) //윗청정기
		{
			for(int i=1;i<C;i++)
			{
				room[d][i] = room_copy[d][i];
			}
			for(int i=d;i>=0;i--)
			{
				room[i][C-1] = room_copy[i][C-1];
			}
			for(int i=C-1;i>=0;i--)
			{
				room[0][i] = room_copy[0][i];
			}
			for(int i=0;i<d;i++)
			{
				room[i][0] = room_copy[i][0];
			}
		}
		else if(check != 0 && d != -1) // 아래청정기
		{
			for(int i=1;i<C;i++)
			{
				room[d][i] = room_copy[d][i];
			}
			for(int i=d;i<R;i++)
			{
				room[i][C-1] = room_copy[i][C-1];
			}
			for(int i=C-1;i>=0;i--)
			{
				room[R-1][i] = room_copy[R-1][i];
			}
			for(int i=R-1;i>d;i--)
			{
				room[i][0] = room_copy[i][0];
			}
		}
		
	}

}
