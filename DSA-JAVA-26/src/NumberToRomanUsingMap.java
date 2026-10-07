import java.util.HashMap;
import java.util.Map;

public class NumberToRomanUsingMap {

	public static void romanizer(int num) {
		
		String res= "";
		
		Map<Integer , String> rMap = new HashMap<Integer , String>();
		rMap.put(1,"I");
		rMap.put(4,"IV");
		rMap.put(5,"V");
		rMap.put(9,"IX");
		rMap.put(10,"X");
		rMap.put(40,"XL");
		rMap.put(50,"L");
		rMap.put(90,"XC");
		rMap.put(100,"C");
		rMap.put(400,"CD");
		rMap.put(500,"D");
		rMap.put(900,"XM");
		rMap.put(1000,"M");
		
		int[] a = {1000 ,900, 500,400,100,90,50,40,10,9,5,4,1};
		
		for(int n : a) {
			while(num >= n) {
				res += rMap.get(n);
				num -= n;
			}
		}
		System.out.println(res);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		romanizer(1226
				);

	}

}
