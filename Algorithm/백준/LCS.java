package BaekJun;

import java.util.*;

public class LCS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		String M = sc.next();
		ArrayList<Character> arr1 = new ArrayList();
		ArrayList<Character> carr1 = new ArrayList();
		ArrayList<Character> arr2 = new ArrayList();
		ArrayList<Character> carr2 = new ArrayList();
		ArrayList<Character> result = new ArrayList();
		
		for(int i=0;i<N.length();i++)
		{
			arr1.add(N.charAt(i));
		}
		for(int i=0;i<M.length();i++)
		{
			arr2.add(M.charAt(i));
		}
		
		int idx=0;
		while(true)
		{
			carr1.addAll(arr1);
			carr2.addAll(arr2);
			if(carr1.get(0) == carr2.get(0))
			{
				result.add(carr1.remove(0));
				carr2.remove(0);
			}
			else
			{
				carr2.remove(0);
			}
		}

	}

}
