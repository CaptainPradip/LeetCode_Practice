class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && DFS(0, board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DFS(int index, char[][] board, int i, int j, String word) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#'
                || word.charAt(index) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        if (DFS(index + 1, board, i + 1, j, word) || DFS(index + 1, board, i - 1, j , word)
                || DFS(index + 1, board, i, j + 1, word)
                || DFS(index + 1, board, i, j - 1, word)) {
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}