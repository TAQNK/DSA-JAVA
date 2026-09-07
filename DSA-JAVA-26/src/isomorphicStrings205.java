import java.util.HashMap;
// logic
//If mapping doesn't exist:
//create it
//
//Otherwise:
//verify it
//
//If verification fails:
//return false
public class isomorphicStrings205 {
	public static boolean isIsomorphic(String s, String t) {
	        // using hashMap to map char to char
	        HashMap <Character , Character> StoT = new HashMap<>();
	        HashMap <Character , Character> TtoS = new HashMap<>();
	        if(s.length() != t.length())return false;
	        	
	        for(int i = 0 ; i < s.length() ; i++) {
	        	
	        		if(!StoT.containsKey(s.charAt(i)) && !TtoS.containsKey(t.charAt(i))) {
	        			StoT.put(s.charAt(i), t.charAt(i));
	        			TtoS.put(t.charAt(i), s.charAt(i));
	        			continue;
	        		}else if(StoT.containsKey(s.charAt(i)) && !TtoS.containsKey(t.charAt(i)))return false;
	        		else if(!StoT.containsKey(s.charAt(i)) && TtoS.containsKey(t.charAt(i)))return false;
	        		else if (StoT.get(s.charAt(i)).equals(t.charAt(i)) && TtoS.get(t.charAt(i)).equals(s.charAt(i))) {
	        			continue;
	        		}
	        		return false;
	        		
	        }
	        return true;
	        
	        
	}
	 public boolean isIsomorphic1(String s, String t) {
	        // now going for much simpler approach of using two arrays for hashing 
	        int map2[] =new int[256];
	        int map1[] =new int[256];
	        for(int i = 0 ;i<s.length() ; i++){
	            char a = s.charAt(i);
	            char b = t.charAt(i);
	            if(map1[a] != map2[b])return false;
	            map1[a]=i+1;
	            map2[b]=i+1;
	        }
	        return true;
	    }       
	        
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("ab" ,"cc"));
	}

}
