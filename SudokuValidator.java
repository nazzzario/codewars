import java.util.*;

public class SudokuValidator {
    
    public static void main(String[] args) {
        int[][] sudoku = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    sudoku[0][0]++;
    sudoku[1][1]++;
    sudoku[0][1]--;
    sudoku[1][0]--;

    sudoku[0][0]--;
    sudoku[1][1]--;
    sudoku[0][1]++;
    sudoku[1][0]++;
    
    sudoku[4][4] = 0;

    boolean res = check(sudoku);
    System.out.println(res);
    }

    public static boolean check(int[][] sudoku) {
        for(int i = 0; i < sudoku.length; i++){
            if(Arrays.stream(sudoku[i]).filter(e -> e > 0 && e < 10).distinct().count() != 9){
                return false;
            }
            List<Integer> tmp = getVertical(sudoku, i);
            if(tmp.stream().distinct().filter(e -> e > 0 && e < 10).count() != 9){
                return false;
            }
        }

        for(int i = 3; i < sudoku.length + 1; i += 3){
            for(int j = 3; j < sudoku.length + 1; j += 3){
                if(!checkSubArray(sudoku, i, j)){
                    return false;
                };
            }
        }
        return true;
    }

    private static boolean checkSubArray(int [][] sudoku, int iIndex, int jIndex){
        List<Integer> tmp = new ArrayList<>();
        for(int i = iIndex - 3; i < iIndex; i++){
            for(int j = jIndex - 3; j < jIndex; j++){
                tmp.add(sudoku[i][j]);
                System.out.print(sudoku[i][j] + " ");
            }
        }
        
        if(tmp.stream().distinct().filter(e -> e > 0 && e < 10).count() != 9){
                return false;
            }

        return true;
    }


    private static List<Integer> getVertical(int [][] sudoku, int col){
        List<Integer> tmp = new ArrayList<>();
        for(int j = 0; j < sudoku[col].length; j++){
            tmp.add(sudoku[col][j]);
        }
        return tmp;
    }
}
