package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AddBracket {
	static ArrayList<String> list;
	static int[] op;
	static int result=Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList();
		op = new int[N / 2];
		int idx = 0;

		String s[] = br.readLine().split("");
		for (int i = 0; i < s.length; i++) {
			list.add(s[i]);
			if (i % 2 != 0) {
				op[idx] = i;
				idx++;
			}
		}
//		System.out.println(list);
//		System.out.println(Arrays.toString(op));
		powerSet(0, new boolean[op.length]);
		System.out.println(result);

	}

	private static int cul(ArrayList<String> list) {
		int res =Integer.parseInt(list.get(0));
		for(int i=1;i<list.size();i++)
		{
			if(list.get(i).equals("+"))
			{
				res = res+ Integer.parseInt(list.get(i+1));
			}
			else if(list.get(i).equals("*"))
			{
				res = res * Integer.parseInt(list.get(i+1));
			}
			else if(list.get(i).equals("-"))
			{
				res = res - Integer.parseInt(list.get(i+1));
			}
		}
		return	res;
		
	}

	private static void powerSet(int k, boolean[] visit) {
		if (k == visit.length) {
//			System.out.println(Arrays.toString(visit));
			ArrayList<String> clist = new ArrayList();

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals("+")) {
					int idx = 0;
					for (int j = 0; j < op.length; j++) {
						if (op[j] == i) {
							idx = j;
							break;
						}
					}
					if (visit[idx]) {
						int a = Integer.parseInt(clist.get(clist.size() - 1));
						clist.remove(clist.size() - 1);
						int b = Integer.parseInt(list.get(i + 1));
						clist.add(Integer.toString(a + b));
						i++;
					} else {
						clist.add(list.get(i));
					}
				} else if (list.get(i).equals("*")) {
					int idx = 0;
					for (int j = 0; j < op.length; j++) {
						if (op[j] == i) {
							idx = j;
							break;
						}
					}
					if (visit[idx]) {
						int a = Integer.parseInt(clist.get(clist.size() - 1));
						clist.remove(clist.size() - 1);
						int b = Integer.parseInt(list.get(i + 1));
						clist.add(Integer.toString(a * b));
						i++;
					} else {
						clist.add(list.get(i));
					}
				} else if (list.get(i).equals("-")) {
					int idx = 0;
					for (int j = 0; j < op.length; j++) {
						if (op[j] == i) {
							idx = j;
							break;
						}
					}
					if (visit[idx]) {
						int a = Integer.parseInt(clist.get(clist.size() - 1));
						clist.remove(clist.size() - 1);
						int b = Integer.parseInt(list.get(i + 1));
						clist.add(Integer.toString(a - b));
						i++;
					} else {
						clist.add(list.get(i));
					}
				} else {
					clist.add(list.get(i));
				}

			}
			int re = cul(clist);
			result = Math.max(re, result);
//			System.out.println(clist);
			return;
		}
		visit[k] = true;
		if (k > 0 && visit[k - 1]) {
			visit[k] = false;
			powerSet(k + 1, visit);
		} else {
			powerSet(k + 1, visit);
			visit[k] = false;
			powerSet(k + 1, visit);
		}

	}


}
