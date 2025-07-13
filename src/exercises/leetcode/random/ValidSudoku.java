package exercises.leetcode.random;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {


    }

    public boolean isValidSudokuModified(char[][] board){


        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // initialize all 27 sets
        for (int x = 0; x<9; x++){
            rows[x] = new HashSet<>();
            columns[x] = new HashSet<>();
            boxes[x] = new HashSet<>();

        }

        for (int r = 0; r<9; r++){
            for (int c = 0; c<9; c++){
                char val = board[r][c];

                if (val == '.') continue;

                if (!rows[r].add(val)){
                    return false;
                }

                if (!columns[c].add(val)){
                    return false;
                }

                int boxNumber = (r/3) *3 + c/3;
                if (!boxes[boxNumber].add(val)){
                    return false;
                }
            }

        }




        return true;
    }

    public boolean isValidSudoku(char[][] board) {


        SubBoxTracker subBoxTracker = new SubBoxTracker();
        VerticalTracker verticalTracker = new VerticalTracker();

        for (int x = 0; x<board.length; x++){

            char[] horizontal = board[x];

            HashSet<Character> horizontalChart = new HashSet<>();

            for (int c = 0; c<horizontal.length; c++){

                char symbol = horizontal[c];
                if (symbol == '.'){
                    subBoxTracker.feedEmpty();

                }

                else {

                    if (!horizontalChart.add(symbol)
                            || !subBoxTracker.feed(symbol)
                            || !verticalTracker.feed(c, symbol)) {
                        return false;
                    }




                }
            }
        }


        return true;
    }
}


class SubBoxTracker {

    HashSet<Character> first = new HashSet<>();
    HashSet<Character> second = new HashSet<>();
    HashSet<Character> third = new HashSet<>();

    int smallCounter; // обновляется при достижении 9
    int largeCounter;
    // при достижении 27 обновляем сеты

    void limitCheck(){
        if (largeCounter == 27){
            resetAll();
        }

        if (smallCounter == 9 ){
            smallCounter = 0;
        }
    }

    void feedEmpty(){
        limitCheck();
        update();
    }


    boolean feed (char s){



        limitCheck();

        if (s=='.'){
            update();
            return true;
        }

        if(smallCounter>=0 && smallCounter<=2){
            update();
            return first.add(s);
        }

        else if (smallCounter>=3 && smallCounter<=5){
            update();
            return second.add(s);
        }

        else {
            update();
            return third.add(s);
        }


    }

    void resetAll(){
        smallCounter = 0;
        largeCounter = 0;
        first.clear();
        second.clear();
        third.clear();
    }

    void update(){
        smallCounter++;
        largeCounter++;
    }
}


class VerticalTracker {

    HashMap<Integer, HashSet<Character>> chart = new HashMap<>();

    boolean feed(int pos, char s){
        // позиция из массива соответствует номеру столбика
        if(!chart.containsKey(pos)){
            HashSet<Character> set = new HashSet<>();
            set.add(s);
            chart.put(pos, set);
            return true;
        }

        else {


            HashSet<Character> set = chart.get(pos);
            return set.add(s);
        }

    }

}