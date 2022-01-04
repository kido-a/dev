package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PipeMove1 {
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };
	static int[][] arr;
	static int N, cnt;
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		cnt = 0;

		for (int i = 0; i < N; i++) {
			String s[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		arr[0][0] = 1;
		arr[0][1] = 1;
		dfs(0, 1, 0);
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int d) {
//		System.out.println(x+","+y);
		if (x == N - 1 && y == N - 1) {
			cnt++;
			return;
		}
		int ax = 0, ay = 0;
		if(d==0)
		{
			for (int i = 0; i < 2; i++) {
				if (i == 1) {
					ax = x + dx[i];
					ay = y + dy[i];
					if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
						if (arr[ax][ay] == 0 && arr[ax - 1][ay] == 0 && arr[ax][ay - 1] == 0 && !visit[ax][ay]) {
							visit[ax][ay] = true;
							dfs(ax, ay, i);
							visit[ax][ay] = false;
						}
					}
				} else {
					ax = x + dx[i];
					ay = y + dy[i];
					if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
						if (arr[ax][ay] == 0 && !visit[ax][ay]) {
							visit[ax][ay] = true;
							dfs(ax, ay, i);
							visit[ax][ay] = false;
						}
					}
				}
			}
		}
		else if(d==1)
		{
			for (int i = 0; i < 3; i++) {
				if (i == 1) {
					ax = x + dx[i];
					ay = y + dy[i];
					if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
						if (arr[ax][ay] == 0 && arr[ax - 1][ay] == 0 && arr[ax][ay - 1] == 0 && !visit[ax][ay]) {
							visit[ax][ay] = true;
							dfs(ax, ay, i);
							visit[ax][ay] = false;
						}
					}
				} else {
					ax = x + dx[i];
					ay = y + dy[i];
					if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
						if (arr[ax][ay] == 0 && !visit[ax][ay]) {
							visit[ax][ay] = true;
							dfs(ax, ay, i);
							visit[ax][ay] = false;
						}
					}
				}
			}
		}
		else if(d==2)
		{
			for (int i = 1; i < 3; i++) {
				if (i == 1) {
					ax = x + dx[i];
					ay = y + dy[i];
					if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
						if (arr[ax][ay] == 0 && arr[ax - 1][ay] == 0 && arr[ax][ay - 1] == 0 && !visit[ax][ay]) {
							visit[ax][ay] = true;
							dfs(ax, ay, i);
							visit[ax][ay] = false;
						}
					}
				} else {
					ax = x + dx[i];
					ay = y + dy[i];
					if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
						if (arr[ax][ay] == 0 && !visit[ax][ay]) {
							visit[ax][ay] = true;
							dfs(ax, ay, i);
							visit[ax][ay] = false;
						}
					}
				}
			}
		}
	}

}
