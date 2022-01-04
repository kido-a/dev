package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Word {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split("");
		ArrayList<ArrayList<String>> re = new ArrayList();
		int i = 0;
		while (i < s.length) {
//			System.out.println(re);
//			System.out.println(i);
			if (s[i].equals("<")) {
				ArrayList<String> ss = new ArrayList();
				while (true) {
					if (s[i].equals(">")) {
						ss.add(s[i]);
						i++;
						break;
					} else {
						ss.add(s[i]);
					}
					i++;
				}
				re.add(ss);
			} else if (s[i].equals(" ")) {
				ArrayList<String> ss = new ArrayList();
				ss.add(s[i]);
				while (true) {
					i++;
					if (i == s.length) {
						break;
					}
					if (s[i].equals("<")) {
						break;
					} else if (s[i].equals(" ")) {
						break;
					} else {
						ss.add(s[i]);
					}
				}
				re.add(ss);
			} else {
				ArrayList<String> ss = new ArrayList();
				while (true) {
					if (i == s.length) {
						break;
					}
					if (s[i].equals("<")) {
						break;
					} else if (s[i].equals(" ")) {
						break;
					} else {
						ss.add(s[i]);
					}
					i++;
				}
				re.add(ss);
			}
		}
		for (int j = 0; j < re.size(); j++) {
			if (re.get(j).get(0).equals("<")) {
				for (int k = 0; k < re.get(j).size(); k++) {
					System.out.print(re.get(j).get(k));
				}
			} else if (re.get(j).get(0).equals(" ")) {
				System.out.print(re.get(j).get(0));
				for (int k = re.get(j).size() - 1; k > 0; k--) {
					System.out.print(re.get(j).get(k));
				}
			} else {
				for (int k = re.get(j).size() - 1; k >= 0; k--) {
					System.out.print(re.get(j).get(k));
				}
			}
		}

	}

}
