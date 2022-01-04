package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SangBumBuilding {
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static char[][][] building;
	static boolean[][][] visit;
	static Queue<int[]> q;
	static int X, Y, Z, S_x, S_y, S_z, E_x, E_y, E_z, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] S = br.readLine().split(" ");
			Z = Integer.parseInt(S[0]);
			X = Integer.parseInt(S[1]);
			Y = Integer.parseInt(S[2]);
			result = -1;

			q = new LinkedList();
			visit = new boolean[Z][X][Y];

			if (Z == 0 && X == 0 && Y == 0)
				break;

			building = new char[Z][X][Y];

			for (int i = 0; i < Z; i++) {
				for (int j = 0; j < X; j++) {
					String s = br.readLine();
					for (int k = 0; k < Y; k++) {
						building[i][j][k] = s.charAt(k);
						if (s.charAt(k) == 'S') {
							S_z = i;
							S_x = j;
							S_y = k;
							q.add(new int[] { i, j, k, 0 });
						} else if (s.charAt(k) == 'E') {
							E_z = i;
							E_x = j;
							E_y = k;
//							System.out.println("끝 좌표"+E_x+" "+E_y+" "+E_z);
						}
					}
				}
				br.readLine();
			}

			bfs();
			if (result != -1)
				System.out.println("Escaped in " + result + " minute(s).");
			else
				System.out.println("Trapped!");
		}
//		showBuilding();
	}

	private static void bfs() {

		if (q.isEmpty())
			return;

		int x = q.peek()[1];
		int y = q.peek()[2];
		int z = q.peek()[0];
		int t = q.peek()[3];
		q.poll();
//		System.out.println(x+" "+y+" "+z+" "+t);
//		System.out.println("끝 좌표"+E_x+" "+E_y+" "+E_z);

		if (x == E_x && y == E_y && z == E_z) {
			result = t;
			return;
		}

		for (int i = 0; i < 6; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			int az = z + dz[i];
			if (ax >= 0 && ax < X && ay >= 0 && ay < Y && az >= 0 && az < Z) {
				if (building[az][ax][ay] != '#' && !visit[az][ax][ay]) {
					visit[az][ax][ay] = true;
					q.add(new int[] { az, ax, ay, t + 1 });
				}
			}
		}
		bfs();

	}

	private static void showBuilding() {
		for (int i = 0; i < Z; i++) {
			for (int j = 0; j < X; j++) {
				for (int k = 0; k < Y; k++) {
					System.out.print(building[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

	}

}
