package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class WallBreakMove {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static boolean[][] visit2;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M];
		ArrayList<int[]> q = new ArrayList<>();
		visit = new boolean[N][M];
		visit2 = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			s = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		q.add(new int[] { 0, 0, 0,1 });
		visit[0][0] = true;
		bfs(q);
	}

	private static void bfs(ArrayList<int[]> q) {
		if (q.size() == 0) // 움직일 수 없으면 종료
		{
			System.out.println("-1");
			return;
		}

		int x = q.get(0)[0]; // x좌표
		int y = q.get(0)[1]; // y좌표
		int w = q.get(0)[2]; // 벽 지나간 유무
		int d = q.get(0)[3]; // 이동거리
		q.remove(0);

		if (x == N - 1 && y == M - 1) // 목적지 도착
		{
			System.out.println(d);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			if (ax >= 0 && ax < N && ay >= 0 && ay < M) {
				if (w == 0) { // 벽을 아직 안뚫었을 때
					if (!visit[ax][ay]) {
						if (map[ax][ay] == 1) { // 벽을 만나면
							visit[ax][ay] = true;
							q.add(new int[] { ax, ay, 1, d + 1 }); // w값을 1로 바꿈
						} else if (map[ax][ay] == 0) {	// 벽이 아니면 이동
							visit[ax][ay] = true;
							q.add(new int[] { ax, ay, w, d + 1 });
						}
					}
				} else // 벽을 한번 뚫었을 때
				{
					if (!visit[ax][ay] && !visit2[ax][ay]) {
						if (map[ax][ay] == 1) {	//벽을 만나면 종료
							continue;
						} else if (map[ax][ay] == 0) {	//벽이 아니면 이동
							visit2[ax][ay] = true;
							q.add(new int[] { ax, ay, w, d + 1 });
						}
					}
				}
			}
		}

		bfs(q);
	}
}
