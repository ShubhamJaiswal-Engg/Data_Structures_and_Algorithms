
// 72. Edit Distance

import java.util.*;
class EditDistance42 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int add = dp[i][j-1] + 1;
                    int remove = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(add, Math.min(remove, replace));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

// More Optimised

class EditDistance42 {
    static int func(int i,int j,String s1,String s2,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if (dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=func(i-1,j-1,s1,s2,dp);
        int insert = func(i, j - 1, s1, s2, dp);
        int delete = func(i - 1, j, s1, s2, dp);
        int replace = func(i - 1, j - 1, s1, s2, dp);
        return dp[i][j]=1+Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] r:dp) Arrays.fill(r,-1);
        return func(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
}