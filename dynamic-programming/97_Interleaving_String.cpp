class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        
        int M, N;
        M = s1.length();
        N = s2.length();
        
        if (s3.length() != M + N)
            return false;
    
        bool T[M+1][N+1];

        T[0][0] = true;

        for (int j = 1; j <= N; ++j)
            T[0][j] = T[0][j-1] && s2[j-1] == s3[j-1];

        for (int i = 1; i <= M; ++i)
            T[i][0] = T[i-1][0] && s1[i-1] == s3[i-1];
        
        for (int i = 1; i <= M; ++i)
            for (int j = 1; j <= N; ++j)
                T[i][j] = (T[i-1][j] && s1[i-1] == s3[i+j-1] ) || (T[i][j-1] && s2[j-1] == s3[i+j-1] );
        
        return T[M][N];
    
    }
};