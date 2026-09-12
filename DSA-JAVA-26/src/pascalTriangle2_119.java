//Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
// 
//
//Example 1:
//
//Input: rowIndex = 3
//Output: [1,3,3,1]
//Example 2:
//
//Input: rowIndex = 0
//Output: [1]
//Example 3:
//
//Input: rowIndex = 1
//Output: [1,1

import java.util.ArrayList;

import java.util.List;
public class pascalTriangle2_119 {
	 public static List<Integer> getRow(int rowIndex) {
         List<List<Integer>> tri = new ArrayList<>();

	        for(int  i = 0 ; i < rowIndex + 1 ; i++){

	            List<Integer> l = new ArrayList<>();
	            l.add(1);
	            for(int j= 1 ; j <i ; j++){
	               l.add(tri.get(i-1).get(j-1) + tri.get(i-1).get(j));
	            }
	            if(i > 0)l.add(1);
	            tri.add(l);
	        }
            return tri.get(tri.size()-1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub


}

}
