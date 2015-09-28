package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundRegion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//"XOXOXO","OXOXOX","XOXOXO","OXOXOX"
//		char[][] board={{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		char[][] board={{'O','O'},{'O','O'}};
		SurroundRegion sr=new SurroundRegion();
		sr.solve2(board);
		System.out.println();
	}

	 public void solve(char[][] board) {
			// special cases
			if (board == null)
				return;
			int n = board.length;//[]
			if (n <=1)
				return;
			int m = board[0].length;
		    if (m <=1)
				return;
			Queue<Integer> q = new LinkedList<Integer>();
			int j = 0;
			// first line
			while (j < m) {
				if (board[0][j] == 'O') {
					q.add(0 * n + j);
				}
				if (board[n - 1][j] == 'O') {
					q.add(m * (n-1) + j);
				}
				j++;
			}
			// first column and last column
			int i= 1;
			while (i < n-1) {
				if (board[i][0] == 'O') {
					q.add(i * m + 0);
				}
				if (board[i][m - 1] == 'O') {
					q.add(i * m + m - 1);
				}
				i++;
			}
			while (!q.isEmpty()) {
				int index = (int) q.poll();
				int row = index / m;
				int col = index % m;
//				fillQueue(board, row, col, m, n, q);
				board[row][col] = 'V';
				fillQueue(board, row - 1, col, m, n, q);
				fillQueue(board, row + 1, col, m, n, q);
				fillQueue(board, row, col + 1, m, n, q);
				fillQueue(board, row, col - 1, m, n, q);
			}
			// except O, they are V and X
			// let V to be O and O to be X
			j = 0;
			i=0;
			for (i = 0; i < n ; i++) {
			    for(j=0;j < m;j++){
				if (board[i][j] == 'V') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			    }
			}

		}

		public void fillQueue(char[][] board, int i, int j, int m, int n,
				Queue<Integer> q) {
			if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O')
				return;
			q.add(i * m + j);
			board[i][j] = 'V';
		}
		
		public void solve2(char[][] board) {
			// special cases 
			if (board == null || board.length == 0 || board.length == 1 || board[0].length == 1)
				return;
			//n*m matrix
			int n = board.length;
			int m = board[0].length;
			for(int row = 0; row<n;row++){
			    for(int col = 0; col<m; col++){
			        if(col==0||col==m-1||row==0||row==n-1){
			            Queue<Integer> q = new LinkedList<Integer>();
			            if(board[row][col] == 'O'){
			                q.add(row*m+col);
			                while(!q.isEmpty()){
			                    int number = q.poll();
			                    int x = number/m;
			                    int y = number%m;
			                    board[x][y] = '1';
			                    if(x-1>=0 && board[x-1][y] == 'O'){
			                        q.add(number-m);
			                    }
			                    if(x+1<n && board[x+1][y] == 'O'){
			                        q.add(number+m);
			                    }
			                    if(y-1>=0 && board[x][y-1] == 'O'){
			                        q.add(number - 1);
			                    }
			                    if(y+1<m && board[x][y+1] == 'O'){
			                        q.add(number + 1);
			                    }
			                }
			            }
			        }
			    }
			}
			for(int row = 0; row<n;row++){
			    for(int col = 0; col<m; col++){
			        if(board[row][col] == 'O'){
			            board[row][col] = 'X';
			        }else if(board[row][col] == '1'){
			            board[row][col] = 'O';
			        }
			    }
			}
		}

}
