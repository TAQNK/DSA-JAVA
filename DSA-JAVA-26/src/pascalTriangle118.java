import java.util.ArrayList;
import java.util.List;
//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
// 
//
//Example 1:
//
//Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//Example 2:
//
//Input: numRows = 1
//Output: [[1]]
public class pascalTriangle118 {
	 public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> tri = new ArrayList<>();

	        for(int  i = 0 ; i < numRows ; i++){

	            List<Integer> l = new ArrayList<>();
	            l.add(1);
	            for(int j= 1 ; j <i ; j++){
	               l.add(tri.get(i-1).get(j-1) + tri.get(i-1).get(j));
	            }
	            if(i > 0)l.add(1);
	            tri.add(l);
	        }
	        return tri;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
