package CrossWord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	static String wordSet9[] = { "agreement", "amusement", "apparatus", "attention", "authority", "behaviour",
			"committee", "condition", "digestion", "direction", "discovery", "education", "existence", "expansion",
			"insurance", "invention", "knowledge", "operation", "secretary", "selection", "statement", "structure",
			"substance", "transport" };
	static String wordSet8[] = { "addition", "approval", "argument", "building", "business", "daughter",
			"decision", "distance", "division", "exchange", "increase", "industry", "interest", "language", "learning",
			"mountain", "ornament", "pleasure", "position", "property", "question", "reaction", "relation", "religion",
			"surprise", "teaching", "tendency" };
	static String wordSet7[] = { "account", "against", "attempt", "balance", "because", "between", "brother",
			"chamber", "chinese", "college", "comfort", "company", "conquer", "control", "country", "current",
			"disease", "disgust", "driving", "english", "epigram", "epistle", "example", "feeling", "fiction",
			"forward", "harbour", "harmony", "hearing", "history", "impulse", "journey", "leather", "machine",
			"manager", "measure", "meeting", "monitor", "morning", "opinion", "payment", "process", "produce",
			"protest", "purpose", "quality", "reading", "request", "respect", "science", "servant", "society",
			"spanish", "speaker", "stretch", "support", "thought", "through", "thunder", "trouble", "weather",
			"writing" };
	static String wordSet6[] = { "across", "almost", "amount", "animal", "answer", "arabic", "attack", "before",
			"belief", "breath", "butter", "button", "canvas", "chance", "chance", "change", "change", "colour",
			"copper", "cotton", "credit", "damage", "danger", "degree", "design", "desire", "detail", "divide",
			"effect", "enigma", "enough", "expert", "family", "father", "flight", "flower", "flower", "french",
			"friend", "greedy", "growth", "hearer", "humour", "insect", "jargon", "korean", "letter", "liquid",
			"little", "lotion", "market", "memory", "middle", "minute", "mother", "mother", "motion", "nation",
			"number", "person", "please", "poetry", "poison", "polish", "porter", "powder", "profit", "reason",
			"record", "regret", "reward", "rhythm", "silver", "sister", "sneeze", "stitch", "summer", "system",
			"theory", "though", "vessel", "violet", "weight", "winter", "zombie" };
	static String wordSet5[] = { "about", "adios", "after", "again", "alone", "among", "angle", "apple", "birth",
			"blood", "brass", "bread", "brute", "burst", "cause", "chalk", "check", "chide", "cloth", "cough", "cover",
			"crack", "crime", "crush", "curve", "death", "doubt", "drink", "earth", "error", "event", "every", "field",
			"fight", "flame", "flute", "force", "force", "front", "fruit", "glass", "grain", "grape", "grass", "group",
			"guide", "hello", "jelly", "judge", "latin", "laugh", "level", "light", "limit", "linen", "mango", "metal",
			"money", "month", "music", "night", "noise", "noise", "north", "offer", "order", "other", "owner", "paint",
			"palsy", "paper", "paste", "peace", "phone", "place", "plant", "point", "power", "price", "print", "prose",
			"quite", "range", "river", "scale", "sense", "shade", "shake", "shame", "shock", "slang", "sleep", "slope",
			"smash", "smell", "smile", "smoke", "sound", "south", "space", "stage", "start", "steam", "steel", "still",
			"stone", "story", "sugar", "taste", "there", "thing", "touch", "trade", "trick", "twist", "under", "value",
			"verse", "viola", "voice", "waste", "water", "where", "while", "woman", "wound", "zebra" };
	static String wordSet4[] = { "bike", "book", "caff", "cash", "come", "cool", "copy", "cork", "debt", "deck",
			"desk", "doll", "down", "dull", "dust", "east", "edge", "even", "ever", "fact", "fall", "fear", "fire",
			"fold", "food", "fork", "form", "free", "from", "geek", "give", "gold", "good", "gout", "grip", "hate", "have",
			"heat", "help", "here", "hole", "hope", "hour", "idea", "iron", "jean", "join", "jump", "keep", "kick",
			"kiss", "land", "land", "lead", "lift", "line", "list", "look", "loss", "love", "make", "mark", "mass",
			"meal", "meat", "milk", "mind", "mine", "mist", "move", "much", "name", "near", "need", "news", "nice",
			"note", "only", "over", "page", "pain", "part", "play", "pull", "pull", "push", "push", "rain", "rate",
			"rest", "rice", "ride", "road", "roll", "room", "rule", "safe", "salt", "sand", "seat", "seem", "self",
			"send", "shoe", "side", "sign", "silk", "sine", "size", "slip", "snow", "soap", "some", "song", "sort",
			"soup", "step", "stop", "such", "swag", "swim", "take", "talk", "test", "than", "that", "then", "this",
			"till", "time", "tree", "tune", "turn", "unit", "very", "view", "walk", "wash", "wave", "week", "well",
			"west", "when", "will", "wind", "wine", "with", "wood", "wool", "word", "work", "year", "zone" };
	static String wordSet3[] = { "act", "air", "all", "and", "any", "arm", "art", "bad", "bag", "bit", "but",
			"can", "cap", "cat", "cry", "cup", "day", "dog", "ear", "end", "eye", "far", "fit", "for", "get", "git", "gum",
			"hop", "hot", "how", "ice", "ink", "joy", "key", "kin", "law", "leg", "let", "lip", "man", "may", "mug",
			"not", "now", "nut", "off", "oil", "old", "one", "out", "put", "ray", "rub", "run", "saw", "say", "sea",
			"sea", "see", "sex", "sit", "sky", "son", "sum", "tan", "tap", "tax", "tea", "ten", "the", "tin", "toe",
			"top", "use", "war", "wax", "way", "who", "why", "yes", "you" };
	
	static ArrayList<String>[] wordlist;
	static ArrayList<String> wordinfo;
	
	public static void main(String[] args) {
		
		info = new ArrayList();
		// 퍼즐크기 11
		int gridSize = 11;

		grid = new char[gridSize][gridSize];
		visit = new boolean[gridSize][gridSize];
		gridLength = gridSize;

		// 기본 퍼즐, 전부 닫혀있음
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				grid[i][j] = '■';
			}
		}
		long beforeTime = System.currentTimeMillis();
		MakeQuiz(0);
		while(!fullBlock())
		{
			MakeQuiz(0);
			makeWordList();
			insertWord();
		}
		showGrid();
		for(int i=0;i<info.size();i++)
		{
			System.out.println(info.get(i).toString());
		}
		System.out.println(wordinfo.toString());
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
	}
	
	private static boolean fullBlock() {
		for(int i=0;i<11;i++)
		{
			for(int j=0;j<11;j++)
			{
				if(grid[i][j]=='우' || grid[i][j]=='좌' || grid[i][j]=='□')
					return false;
			}
		}
		return true;
	}
	private static void insertWord() {
		wordinfo = new ArrayList();
		
		for(int i=0;i<info.size();i++)
		{
//			System.out.println(info.get(i).toString());
			int quiz = info.get(i).quiz;
			int x = info.get(i).x;
			int y = info.get(i).y;
			int d = info.get(i).dis;
			
			for(int k=0;k<wordlist[quiz].size();k++)
			{
				String word = wordlist[quiz].get(k);
				boolean flag=true; // 칸이 다른 단어로 차있는지 확인

				if(d==2)
				{
					for(int j=0;j<word.length();j++)
					{
						if(grid[x+j][y] !='□'&& grid[x+j][y] !='우'&& grid[x+j][y] !='하' && grid[x+j][y] != word.charAt(j))
						{
							flag = false;
							break;
						}
					}
					if(flag)
					{
						for(int j=0;j<word.length();j++)
							grid[x+j][y] = word.charAt(j);
						wordlist[quiz].remove(word);
						wordinfo.add(word);
						break;
					}		
				}
				else if(d==4)
				{
					for(int j=0;j<word.length();j++)
					{
						if(grid[x][y+j] !='□'&& grid[x][y+j] !='우'&& grid[x][y+j] !='하' && grid[x][y+j] != word.charAt(j))
						{
							flag = false;
							break;
						}
					}
					if(flag)
					{
						for(int j=0;j<word.length();j++)
							grid[x][y+j] = word.charAt(j);
						wordlist[quiz].remove(word);
						wordinfo.add(word);
						break;
					}	
				}
				
			}
		}
		
	}
	private static void makeWordList() {
		wordlist = new ArrayList[10];
		for(int i=0;i<10;i++)
		{
			wordlist[i] = new ArrayList();
		}
		
		
		for(int i=0;i<wordSet3.length;i++)
			wordlist[3].add(wordSet3[i]);
		Collections.shuffle(wordlist[3]);
		for(int i=0;i<wordSet4.length;i++)
			wordlist[4].add(wordSet4[i]);
		Collections.shuffle(wordlist[4]);
		for(int i=0;i<wordSet5.length;i++)
			wordlist[5].add(wordSet5[i]);
		Collections.shuffle(wordlist[5]);
		for(int i=0;i<wordSet6.length;i++)
			wordlist[6].add(wordSet6[i]);
		Collections.shuffle(wordlist[6]);
		for(int i=0;i<wordSet7.length;i++)
			wordlist[7].add(wordSet7[i]);
		Collections.shuffle(wordlist[7]);
		for(int i=0;i<wordSet8.length;i++)
			wordlist[8].add(wordSet8[i]);
		Collections.shuffle(wordlist[8]);
		for(int i=0;i<wordSet9.length;i++)
			wordlist[9].add(wordSet9[i]);
		Collections.shuffle(wordlist[9]);
		
		
	}
	private static void bfs(int nx, int ny) {
		Queue<int[]> q = new LinkedList();
		q.add(new int[] {nx,ny});
		while(true)
		{
			if(q.isEmpty())
			{
				count++;
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
						visit[ax][ay] = true;
						q.add(new int[] {ax,ay});
					}
				}
			}
		}
	}
	private static void MakeQuiz(int quiz) {
		count=0;
		while(true)
		{
			info = new ArrayList();
			// 퍼즐크기 11
			int gridSize = 11;

			grid = new char[gridSize][gridSize];
			visit = new boolean[gridSize][gridSize];
			gridLength = gridSize;

			// 기본 퍼즐, 전부 닫혀있음
			for (int i = 0; i < gridSize; i++) {
				for (int j = 0; j < gridSize; j++) {
					grid[i][j] = '■';
				}
			}
			//10문제 출제
			while(quiz<10)
			{
				//블럭을 뚫을 위치
				int random_x = (int)(Math.random()*11);
				int random_y = (int)(Math.random()*11);
				//방향 2.하, 4.우
				int temp = (int)(Math.random()*2);
				int distance=0;
				
				if(temp == 0)
					distance=2;
				else
					distance=4;
				//문제 글자 수
				int quizSize = (int)(Math.random()*6+3);
				
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
			for(int i=0;i<11;i++)
			{
				for(int j=0;j<11;j++)
				{
					if(count>1)
						break;
					if(!visit[i][j]&& grid[i][j]!='■')
					{
						visit[i][j] = true;
						bfs(i,j);
					}
				}
				if(count>1)
					break;
			}
			if(count<2)
				break;
			else
			{
				count=0;
				quiz=0;
			}
		}
		
	}
	private static boolean check(int x, int y, int quiz, int d) {
//		System.out.println("x y quiz d "+x+" "+y+" "+quiz+" "+d);
//		for(int i=0;i<info.size();i++)
//		{
//			System.out.println(info.get(i).toString());
//		}
		if(d==2)//하
		{
			if(x>0&&grid[x-1][y]!='■' )
				return false;
			if(x+quiz<11 && grid[x+quiz][y] !='■')
				return false;
			for(int i=0;i<quiz;i++)
			{
				if(y<10&&grid[x+i][y+1]=='우')
					return false;
				else if(y>0&&grid[x+i][y-1]=='좌')
					return false;
				
			}
			for(int i=0;i<info.size();i++)
			{
				if(info.get(i).dis==2 &&Math.abs(y-info.get(i).y)==1 && ((x>= info.get(i).x && x<= info.get(i).x + info.get(i).quiz) || (info.get(i).x>= x && info.get(i).x<=x+quiz)))
					return false;
				if(info.get(i).dis==2 && info.get(i).y==y &&((x>= info.get(i).x && x<= info.get(i).x + info.get(i).quiz) || (info.get(i).x>= x && info.get(i).x<=x+quiz)))
					return false;
				if(info.get(i).dis==4 && (info.get(i).y + info.get(i).quiz == y || info.get(i).y-1 == y)&&(info.get(i).x >=x && info.get(i).x <= x+quiz-1))
					return false;
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
				if(x>0&&grid[x-1][y+i]=='상')
					return false;
				else if(x<10&&grid[x+1][y+i]=='하')
					return false;
			}
			for(int i=0;i<info.size();i++)
			{
				if(info.get(i).dis==4&&Math.abs(x-info.get(i).x)==1 && ((y>= info.get(i).y && y<= info.get(i).y + info.get(i).quiz) || (info.get(i).y >= y && info.get(i).y<= y+quiz)))
					return false;
				if(info.get(i).dis==4 && info.get(i).x==x && ((y>= info.get(i).y && y<= info.get(i).y + info.get(i).quiz) || (info.get(i).y >= y && info.get(i).y<= y+quiz)))
					return false;
				if(info.get(i).dis==2 && (info.get(i).x + info.get(i).quiz == x || info.get(i).x-1 == x) &&(info.get(i).y >=y && info.get(i).y <= y+quiz-1))
					return false;
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
