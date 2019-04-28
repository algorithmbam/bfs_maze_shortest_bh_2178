package bfs_maze_shortest_bh2_2178;

import java.io.FileInputStream;
import java.util.*;
 
public class Bfs2 {
 
    static int[][] question;
    static boolean[][] visited;
    static int[] nextRow = { -1, 0, 1, 0 };
    static int[] nextCol = { 0, -1, 0, 1 };
    static int N;
    static int M;
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        question = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String str = sc.nextLine();
            for (int j = 1; j <= M; j++) {
                question[i][j] = str.charAt(j-1)-'0';
                visited[i][j] = false;
            }
        }
        
        visited[1][1] = true;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(1, 1));
        
        //큐가 끝날때 까지
        while (!queue.isEmpty()) {
        	
            Node node = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                //다음 방문할 좌표 nextX, nextY
                int nextX = node.getX_row() + nextRow[i];
                int nextY = node.getY_col() + nextCol[i];
                
                //다음 좌표가 범위를 넘어갈때 건너뛰기
                if (nextX < 0 || nextY < 0 || nextX > N || nextY > M) {
                    continue;
                }
                
                //이미 방문했던 점이면 건너뛰기
                if (visited[nextX][nextY] == true || question[nextX][nextY] == 0) {
                    continue;
                }
                
                //다음에 방문할 좌표를 큐에 넣는다.
                queue.add(new Node(nextX, nextY));
                
                //배열안에 다음 방문할 곳은 현재 방문했던 점보다 1칸 더 가야하므로 +1
                question[nextX][nextY] = question[node.getX_row()][node.getY_col()] + 1;
                
                //다음 좌표는 방문했음으로 표시
                visited[nextX][nextY] = true;
                

                if( (nextX == N) && (nextY == M) ) {
                	System.out.println(question[N][M]);
                	return;
                }
            }
        }
    }
}
 
class Node {
	private int x_row;
    private int y_col;
 
    Node(int x, int y) {
        this.x_row = x;
        this.y_col = y;
    }

    public int getX_row() {
		return x_row;
	}

	public int getY_col() {
		return y_col;
	}
}