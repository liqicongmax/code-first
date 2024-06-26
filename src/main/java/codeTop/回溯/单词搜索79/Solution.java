package codeTop.回溯.单词搜索79;//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1832 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char[][] board;
    public String word;
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
        int m=board.length;
        int n=board[0].length;
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                if(dfs(new boolean[m][n],1,x,y)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(boolean[][] visited,int index, int x,int y){
        if(x<0||x>=board.length||y<0||y>=board[0].length){
            return false;
        }
        if(visited[x][y]){
            return false;
        }
        if(index==word.length()){
            return word.charAt(index-1)==board[x][y];
        }
        char c=word.charAt(index-1);
        if(c==board[x][y]){
            visited[x][y]=true;
            boolean up = dfs(visited,index+1,x-1,y);
            boolean down = dfs(visited,index+1,x+1,y);
            boolean left = dfs(visited,index+1,x,y-1);
            boolean right = dfs(visited,index+1,x,y+1);
            visited[x][y]=false;
            return up||down||left||right;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
