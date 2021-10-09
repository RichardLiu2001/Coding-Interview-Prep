class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)

        dp = [[False for i in range(n)] for j in range(n)]

        for i in range(n):
            dp[i][i] = True

            if i < n - 1:
                if s[i] == s[i + 1]:
                    dp[i][i + 1] = True



                    


        
        [1,1]
        [0,1]