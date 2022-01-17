package CrossWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Puzzle{
	int x;
	int y;
	int quiz;
	int dis;
	public Puzzle(int x, int y, int quiz, int dis) {
		super();
		this.x = x;
		this.y = y;
		this.quiz = quiz;
		this.dis = dis;
	}
	@Override
	public String toString() {
		return "Puzzle [x=" + x + ", y=" + y + ", quiz=" + quiz + ", dis=" + dis + "]";
	}
}
public class Grid {
	static char[][] grid;
	static boolean[][] visit;
	static int gridLength,count;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<Puzzle> info;
	static ArrayList<String> words;
	public static void main(String[] args) {
		count=0;
		while(true)
		{
		info = new ArrayList();
		// 퍼즐크기 11
		int gridSize = 11;
		
		grid = new char[gridSize][gridSize];
		visit = new boolean[gridSize][gridSize];
		gridLength = gridSize;
		
		//기본 퍼즐, 전부 닫혀있음
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				grid[i][j] = '■';
			}
		}
			MakeQuiz(0);
			for(int i=0;i<11;i++)
			{
				for(int j=0;j<11;j++)
				{
					if(!visit[i][j]&& grid[i][j]!='■')
					{
						visit[i][j] = true;
						bfs(i,j);
					}
				}
			}
			if(count<3)
				break;
			else
				count=0;
			
		}
		showGrid();
//		
		for(int i=0;i<info.size();i++)
		{
			System.out.println(info.get(i).toString());
			
		}
		
	}
	private static void bfs(int nx, int ny) {
		Queue<int[]> q = new LinkedList();
		q.add(new int[] {nx,ny});
		while(true)
		{
			if(q.isEmpty())
			{
				count++;
//				System.out.println("nx ny"+nx+" "+ny);
				break;
			}
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i=0;i<4;i++)
			{
				int ax = x + dx[i];
				int ay = y + dy[i];
				if(ax>=0 && ax<11 && ay>=0 && ay<11)
				{
					if(grid[ax][ay]!='■' && !visit[ax][ay])
					{
//						System.out.println("ax ay"+ax+" "+ay);
						visit[ax][ay] = true;
						q.add(new int[] {ax,ay});
					}
				}
			}
		}
	}
	private static void MakeQuiz(int quiz) {
		//10문제 출제
		while(quiz<10)
		{
			//블럭을 뚫을 위치
			int random_x = (int)(Math.random()*11);
			int random_y = (int)(Math.random()*11);
			//방향 1.상 2.하 3.좌 4.우
			int distance = (int)(Math.random()*4+1);
			//문제 글자 수
			int quizSize = (int)(Math.random()*6+3);
			if(distance ==1 && random_x + 1 - quizSize >=0) //상
			{
				if(check(random_x,random_y,quizSize,distance))
				{
					for(int i=0;i<quizSize;i++)
					{
						if(grid[random_x-i][random_y]=='■')
						{
							grid[random_x-i][random_y] = '□';		
						}
					}
					grid[random_x][random_y] = '상';
					info.add(new Puzzle(random_x,random_y,quizSize,distance));
					quiz++;
				}
			}
			if(distance ==2 && random_x + quizSize <=11) //하
			{
				if(check(random_x,random_y,quizSize,distance))
				{
					for(int i=0;i<quizSize;i++)
					{
						if(grid[random_x+i][random_y]=='■')
						{
							grid[random_x+i][random_y] = '□';			
						}
					}
					grid[random_x][random_y] = '하';
					info.add(new Puzzle(random_x,random_y,quizSize,distance));
					quiz++;
				}
			}
			if(distance ==3 && random_y + 1 - quizSize >=0) //좌
			{
				if(check(random_x,random_y,quizSize,distance))
				{
					for(int i=0;i<quizSize;i++)
					{
						if(grid[random_x][random_y-i]=='■')
						{
							grid[random_x][random_y-i] = '□';			
						}
					}
					grid[random_x][random_y] = '좌';
					info.add(new Puzzle(random_x,random_y,quizSize,distance));
					quiz++;					
				}
			}
			if(distance ==4 && random_y + quizSize<=11) //우
			{
				if(check(random_x,random_y,quizSize,distance))
				{
					for(int i=0;i<quizSize;i++)
					{
						if(grid[random_x][random_y+i]=='■')
						{
							grid[random_x][random_y+i] = '□';		
						}
					}
					grid[random_x][random_y] = '우';
					info.add(new Puzzle(random_x,random_y,quizSize,distance));
					quiz++;					
				}
			}
		}
		
	}
	private static boolean check(int x, int y, int quiz, int d) {
		
		if(d==1) //상
		{
			if(x<10 && grid[x+1][y]!='■' )
			{
				return false;
			}
			if(x-quiz>=0 && grid[x-quiz][y] !='■')
				return false;
			for(int i=0;i<quiz;i++)
			{
				if(grid[x-i][y]=='상' || grid[x-i][y]=='하')
				{
//					System.out.println("1번이유");
					return false;
				}
				else if(y<10&&grid[x-i][y+1]=='우')
					return false;
				else if(y>0&&grid[x-i][y-1]=='좌')
					return false;
			}
			for(int i=0;i<info.size();i++)
			{
				if((info.get(i).dis==1 || info.get(i).dis==2) && Math.abs(y-info.get(i).y)==1)
				{
//					System.out.println("2번이유");
					return false;
				}
				if(info.get(i).dis==1 && info.get(i).y==y && x-quiz<= info.get(i).x+1)
				{
//					System.out.println("3번이유");
					return false;
				}
			}
		}
		else if(d==2)//하
		{
			if(x>0&&grid[x-1][y]!='■' )
			{
				return false;
			}
			if(x+quiz<11 && grid[x+quiz][y] !='■')
				return false;
			for(int i=0;i<quiz;i++)
			{
				if(grid[x+i][y]=='하' || grid[x+i][y]=='상')
				{
//					System.out.println("1번이유");
					return false;
				}
				else if(y<10&&grid[x+i][y+1]=='우')
					return false;
				else if(y>0&&grid[x+i][y-1]=='좌')
					return false;
			}
			for(int i=0;i<info.size();i++)
			{
				if((info.get(i).dis==1 || info.get(i).dis==2) &&Math.abs(y-info.get(i).y)==1)
				{
//					System.out.println("2번이유");
					return false;
				}
				if(info.get(i).dis==2 && info.get(i).y==y && x+quiz>= info.get(i).x-1)
				{
//					System.out.println("3번이유");
					return false;
				}
			}
		}
		else if(d==3)//좌
		{
			if(y<10&&grid[x][y+1]!='■')
			{
				return false;
			}
			if(y-quiz>=0 && grid[x][y-quiz] !='■')
				return false;
			for(int i=0;i<quiz;i++)
			{
				if(grid[x][y-i]=='좌' || grid[x][y-i]=='우')
				{
//					System.out.println("1번이유");
					return false;
				}
				else if(x>0&&grid[x-1][y-i]=='상')
					return false;
				else if(x<10&&grid[x+1][y-i]=='하')
					return false;
			}
			for(int i=0;i<info.size();i++)
			{
				if((info.get(i).dis==3 || info.get(i).dis==4)&&Math.abs(x-info.get(i).x)==1)
				{
//					System.out.println("2번이유");
					return false;
				}
				if(info.get(i).dis==3 && info.get(i).x==x && y-quiz<= info.get(i).y+1)
				{
//					System.out.println("3번이유");
					return false;
				}
			}
		}
		else if(d==4) //우
		{
			if(y>0 && grid[x][y-1]!='■' )
			{
				return false;
			}
			if(y+quiz<11 && grid[x][y+quiz] !='■')
				return false;
			for(int i=0;i<quiz;i++)
			{
				if(grid[x][y+i]=='우' || grid[x][y+i]=='좌')
				{
//					System.out.println("1번이유");
					return false;
				}
				else if(x>0&&grid[x-1][y+i]=='상')
					return false;
				else if(x<10&&grid[x+1][y+i]=='하')
					return false;
			}
			for(int i=0;i<info.size();i++)
			{
				if((info.get(i).dis==3 || info.get(i).dis==4)&&Math.abs(x-info.get(i).x)==1)
				{
//					System.out.println("2번이유");
					return false;
				}
				if(info.get(i).dis==4 && info.get(i).x==x && y+quiz>= info.get(i).y-1)
				{
//					System.out.println("3번이유");
					return false;
				}
			}
		}
		return true;
	}
	private static void showGrid() {
		for(int i=0;i<11;i++)
		{
			for(int j=0;j<11;j++)
			{
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
}
