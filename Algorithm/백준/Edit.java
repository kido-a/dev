package BaekJun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Edit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		LinkedList<Character> arr = new LinkedList();
		
		
		for(int i=0;i<s.length();i++)
		{
			arr.add(s.charAt(i));
		}
		int M = Integer.parseInt(br.readLine());	//명령어 개수
		
		ListIterator it = arr.listIterator();	//iterator 선언
		
		while(it.hasNext())	//초기 커서 위치
		{
			it.next();
		}
		for(int i=0; i<M;i++)
		{
			String[] edt = br.readLine().split(" ");
			
			if(edt[0].equals("P"))
			{
				it.add(edt[1]);
			}
			else if(edt[0].equals("L"))
			{
				if(it.hasPrevious())
				{
					it.previous();
				}
			}
			else if(edt[0].equals("D"))
			{
				if(it.hasNext())
				{
					it.next();
				}
			}
			else if(edt[0].equals("B"))
			{
				if(it.hasPrevious())
				{
				it.previous();
				it.remove();
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(it.hasPrevious())
		{
			it.previous();
		}
		while(it.hasNext())
		{
			bw.write(it.next()+"");
		}
		bw.close();
	}

}
