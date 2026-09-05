
public class reverseTheWords151 {
	 public static String reverseWords(String s) {
		  StringBuilder res = new StringBuilder("");
	        String [] strArr = s.split(" ");
	        for(int i = strArr.length -1 ; i >= 0 ; i--){
	            if(strArr[i].equals(""))continue;
	            res.append(strArr[i]);
	            if(i-1 >= 0)res.append(" ");
	        }
	        return res.toString();
	    }
	 // this version is more optimized look at the tariling or leading zeroes so you will not have empty strings at first or last 
	 // and string builder to avoid extra storage as strings are immutable and they create new strings every sinsgle time in scp(string constant pool)
	 public static String reverseWords1(String s) {
         StringBuilder res = new StringBuilder("");
         s= s.trim();
        String [] strArr = s.split("\\s+");
        for(int i = strArr.length -1 ; i >= 0 ; i--){
            if(strArr[i].equals(""))continue;
            res.append(strArr[i]);
            if(i-1 >= 0)res.append(" ");
        }
        return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(reverseWords("hey i am  java"));
		String s = "  hello world  ";
		String[] res = s.split(" ");
		System.out.println(res.length);
		for(String r : res) {
			System.out.print(r);
		}
		
	}

}
