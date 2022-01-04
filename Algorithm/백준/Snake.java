package BaekJun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Snake {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=0,y=0,d=4;
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		ArrayList<int[]> tail = new ArrayList();
		map[x][y]=1;
		
		int apple = sc.nextInt();	//사과 위치
		for(int i=0;i<apple;i++)
		{
			int ax = sc.nextInt();
			int ay = sc.nextInt();
			map[ax-1][ay-1] = 9;
		}
		int dis = sc.nextInt();
		String[][] oper = new String[dis][2];	//명령어 저장
		for (int i = 0; i < dis; i++) {
			oper[i][0] = sc.next();
			oper[i][1] = sc.next();
		}
		int time=0;

		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		while(true)
		{
			time++;
			if(d == 1)	// 상
			{
				int rx = x;	//이전 위치 저장
				int ry = y;
				map[x][y] = 0;
				x = x-1;	//좌표이동
				if(x<0 || x>=N)	break;	//벽
				if(map[x][y] == 2)	break;	//꼬리
				if(map[x][y] == 9)	//사과를 만날 때
				{
					tail.add(new int[] {x+1,y});	// 꼬리생성
					map[x][y] = 1;
					map[x+1][y]=2;
				}
				else	//사과가 없을 때
				{
					map[x][y] = 1;
					if (tail.size() > 0) {		//꼬리가 있으면
						for (int i = 0; i < tail.size() - 1; i++) {	// 일단 꼬리 0으로
							map[tail.get(i)[0]][tail.get(i)[1]] = 0;
							tail.set(i, new int[] { tail.get(i + 1)[0], tail.get(i + 1)[1] });	//꼬리 위치 조정
						}
						map[tail.get(tail.size() - 1)[0]][tail.get(tail.size() - 1)[1]] = 0;	//첫번째 꼬리 위치 조정
						tail.set(tail.size() - 1, new int[] { rx, ry });	//첫번째 꼬리는 머리의 이전좌표
						for (int i = 0; i < tail.size(); i++) {
							map[tail.get(i)[0]][tail.get(i)[1]] = 2;
						}
					}
				}
			}
			else if(d == 2)	//하
			{
				int rx = x;
				int ry = y;
				map[x][y] = 0;
				x = x+1;
				if(x<0 || x>=N)	break;
				if(map[x][y] == 2)	break;
				if(map[x][y] == 9)
				{
					tail.add(new int[] {x-1,y});
					map[x][y] = 1;
					map[x-1][y]=2;
				}
				else
				{
					map[x][y] = 1;
					if (tail.size() > 0) {
						for (int i = 0; i < tail.size() - 1; i++) {
							map[tail.get(i)[0]][tail.get(i)[1]] = 0;
							tail.set(i, new int[] { tail.get(i + 1)[0], tail.get(i + 1)[1] });
						}
						map[tail.get(tail.size() - 1)[0]][tail.get(tail.size() - 1)[1]] = 0;
						tail.set(tail.size() - 1, new int[] { rx, ry });
						for (int i = 0; i < tail.size(); i++) {
							map[tail.get(i)[0]][tail.get(i)[1]] = 2;
						}
					}
				}
			}
			else if(d == 3)	//좌
			{
				int rx = x;
				int ry = y;
				map[x][y] = 0;
				y = y-1;
				if(y<0 || y>=N)	break;
				if(map[x][y] == 2)	break;
				if(map[x][y] == 9)
				{
					tail.add(new int[] {x,y+1});
					map[x][y] = 1;
					map[x][y+1]=2;
				}
				else
				{
					map[x][y] = 1;
					if (tail.size() > 0) {
						for (int i = 0; i < tail.size() - 1; i++) {
							map[tail.get(i)[0]][tail.get(i)[1]] = 0;
							tail.set(i, new int[] { tail.get(i + 1)[0], tail.get(i + 1)[1] });
						}
						map[tail.get(tail.size() - 1)[0]][tail.get(tail.size() - 1)[1]] = 0;
						tail.set(tail.size() - 1, new int[] { rx, ry });
						for (int i = 0; i < tail.size(); i++) {
							map[tail.get(i)[0]][tail.get(i)[1]] = 2;
						}
					}
				}
			}
			else if(d == 4)	//우
			{
				int rx= x;
				int ry= y;
				map[x][y] = 0;
				y = y+1;
				if(y<0 || y>=N)	break;
				if(map[x][y] == 2)	break;
				if(map[x][y] == 9)
				{
					tail.add(new int[] {x,y-1});
					map[x][y] = 1;
					map[x][y-1]=2;
				}
				else
				{
					map[x][y] = 1;
					if (tail.size() > 0) {
						for (int i = 0; i < tail.size() - 1; i++) {
							map[tail.get(i)[0]][tail.get(i)[1]] = 0;
							tail.set(i, new int[] { tail.get(i + 1)[0], tail.get(i + 1)[1] });
						}
						map[tail.get(tail.size() - 1)[0]][tail.get(tail.size() - 1)[1]] = 0;
						tail.set(tail.size() - 1, new int[] { rx, ry });
						for (int i = 0; i < tail.size(); i++) {
							map[tail.get(i)[0]][tail.get(i)[1]] = 2;
						}
					}
				}
			}
			int idx=0;
			if (idx < dis) {	
				if (time == Integer.parseInt(oper[idx][0])) { //방향배열에 현재 시간이 있으면
//					System.out.println("바뀜");
					if (oper[idx][1].equals("D")) {	//방향전환  D
						if (d == 1)
							d = 4;
						else if (d == 2)
							d = 3;
						else if (d == 3)
							d = 1;
						else if (d == 4)
							d = 2;
					} else {	// L
						if (d == 1)
							d = 3;
						else if (d == 2)
							d = 4;
						else if (d == 3)
							d = 2;
						else if (d == 4)
							d = 1;
					}
					idx++;
				}
			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			for (int i = 0; i < tail.size(); i++) {
//				System.out.print(Arrays.toString(tail.get(i))+" ");
//			}
//			System.out.println("-----------------------"+time);
		}
		System.out.println(time);
	}
}
