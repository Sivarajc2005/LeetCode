class Solution {
    public boolean isValidSudoku(char[][] arr) {
        
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(arr[i][j] != '.'){
                    if(!che(arr , i , j , arr[i][j])){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static boolean che(char[][] board , int r , int c , int val){
        
        for(int i = 0 ; i < 9 ; i++){
            if(i != c){
                if(val == board[r][i]){
                   
                    return false;
                }
            }
            if( i != r){
                if(val == board[i][c]){
                    
                    return false;
                }
            }
            int x = ((r / 3) * 3) + ( i / 3 );
            int y = ((c / 3) * 3) + ( i % 3 );

            if( x != r || y != c){
                if(board[x][y] == board[r][c]){
                
                    return false;
                }
            }
        }

        return true;
    }
}