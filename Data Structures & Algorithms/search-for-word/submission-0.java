class Solution {
    private int ROWS, COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                if(backtrack(r, c, word, board, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int r, int c, String word, char[][] board, int i){
        if(i==word.length()){
            return true;
        }

        if(r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c]!=word.charAt(i) || board[r][c] == '#'){
            return false;
        }
        board[r][c] = '#';
        boolean res = backtrack(r+1, c, word, board, i+1) ||
                      backtrack(r-1, c, word, board, i+1) ||
                      backtrack(r, c+1, word, board, i+1) ||
                      backtrack(r, c-1, word, board, i+1) ;
        board[r][c] = word.charAt(i);
        return res;
    }
}
