package main.java.github.codingbondam.p6e.misc;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return output;
        }

        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        output.add(first);

        for(int row = 1; row < numRows; row++) {
            List<Integer> prev = output.get(row - 1);
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(prev.get(0));
            for(int item = 1; item < row; item++) {
                curr.add(prev.get(item -1) + prev.get(item));
            }
            curr.add(prev.get(row - 1));
            output.add(curr);
        }

        return output;

    }

}
