package bfs_maze_shortest_bh_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Input
/*
4 6
101111
101010
101011
111011
*/
		
//output
//15

public class Bfs {

	private static int N;
	private static int M;
	private static int question[][];
	private static boolean visited[][];
	private static int moveRow[] = {1, -1, 0, 0 };
	private static int moveCol[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		// 문제배열 초기화	
		question= new int[N+1][M+1];
		char[] questionRow;
		for(int n= 1; n <= N; n++) { 
			questionRow= br.readLine().toCharArray();
			
			for(int m= 1; m <= M; m++) {
				question[n][m]= questionRow[m-1] - '0';
			}
		}
		
		// 방문정보 배열 초기화
		visited= new boolean[N+1][M+1];
		
		// Queue 초기화
		Queue<Node> queue= new LinkedList<Node>();
		
		Node node= new Node(1, 1);
		queue.add(node);
		visited[1][1]= true;
		int cnt= 0;
		
		Node currentNode;
		
		while(!queue.isEmpty()) {
			cnt= cnt+1;
			int size = queue.size();
			
			for(int x= 0; x< size; x++) {

				currentNode= queue.poll();
				
				if(currentNode.getN() == N && currentNode.getM() == M) {
					System.out.println(cnt);
					return;
				}
				
				for(int move= 0; move <4; move++) {
					int nextRow= currentNode.getN() + moveRow[move];
					int nextCol= currentNode.getM() + moveCol[move];
					
					if(nextRow < 1 || nextCol < 1 || nextRow > N || nextCol > M) {
						continue;
					}
					
					if(question[nextRow][nextCol] == 0) {
						continue;
					}
					
					if(visited[nextRow][nextCol] == true) {
						continue;
					}
					
					queue.add(new Node(nextRow, nextCol));
					visited[nextRow][nextCol]= true;
				}
			}
		}
	}
}

class Node {
	private int N;
	private int M;
	
	public Node(int n, int m) {
		super();
		N = n;
		M = m;
	}
	
	public int getN() {
		return N;
	}

	public int getM() {
		return M;
	}
}