import java.util.HashMap;
import java.util.Map;

public class OcurrenceIndexStringUsingMap {
	public static void OccurrneceIndex(String s) {
		Map<Character , String> m = new HashMap<Character , String>();
		for(int i = 0 ; i < s.length() ; i++) {
			if(m.containsKey(s.charAt(i))) {
				String v = m.get(s.charAt(i));
				m.put(s.charAt(i), v +" , "+i);
			}else {
				m.put(s.charAt(i) ,""+i);
			}
		}
		System.out.println(m);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="banana";
		OccurrneceIndex(s);

	}

}
