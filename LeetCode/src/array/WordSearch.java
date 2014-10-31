package array;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word="ABFSA";
		System.out.println(exist(board,word));
		
		char[][] board1={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
		String word1="AAB";
		System.out.println(exist(board1,word1));
	}
	public static boolean exist(char[][] board, String word) {
        boolean[][] visited=new boolean[board.length][board[0].length];
        boolean ret=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                ret=find(board,word,0,i,j,visited);
                if(ret)
                    return ret;
            }
        }
        return ret;
    }
    public static boolean find(char[][] board, String word, int index, int row, int col, boolean[][] visited){
        if(index==word.length()){
            return true;
        }
        if(row<0||row>=board.length||col<0||col>=board[0].length){
            return false;
        }
        if(visited[row][col]){
            return false;
        }
        if(board[row][col]!=word.charAt(index))
        	return false;
        visited[row][col]=true;
        boolean res=find(board, word, index+1, row+1, col, visited)||find(board, word, index+1,row-1,col,visited)||find(board, word, index+1, row,col+1,visited)||find(board, word, index+1, row, col-1,visited);
        visited[row][col]=false;
        return res;
    }

}
