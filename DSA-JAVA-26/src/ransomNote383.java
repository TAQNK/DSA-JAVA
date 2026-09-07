//
//publGiven two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
//
// 
//
//Example 1:
//
//Input: ransomNote = "a", magazine = "b"
//Output: false
//Example 2:
//
//Input: ransomNote = "aa", magazine = "ab"
//Output: false
//Example 3:
//
//Input: ransomNote = "aa", magazine = "aab"
//Output: trueic 
class ransomNote383 {
	public static  boolean canConstruct(String ransomNote, String magazine) {
        char[] ch1 = ransomNote.toCharArray();
        char[] ch2 = magazine.toCharArray();
        String res = "";
        for(int i = 0 ; i < ch1.length ; i++){
            for(int j = 0 ; j < ch2.length ; j++){
                if(ch1[i] == ch2[j]){
                    ch2[j] = '\u0000';
                    res += ch1[i]+"";
                    break;
                }
            }
        }
        return ch1.length == res.length();
    }	
	public static boolean canConstruct1(String ransomNote , String magazine) {
		// using frequency array
		int[] letters = new int[26];
		for(char c : magazine.toCharArray()) {
			letters[c - 'a'] ++;
		}
		for(char c : ransomNote.toCharArray()) {
			letters[c - 'a'] --;
		}
		for(int i : letters) {
			if(i < 0)return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
