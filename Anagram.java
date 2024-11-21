/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1=preProcess(str1);
		str2=preProcess(str2);
		
		if(str1.length()!=str2.length())
			return false;
		for(int i=0;i<str1.length();i++){int c=0;
			for(int j=0;j<str2.length();j++){
				if(str1.charAt(i)==str2.charAt(j))
				{c++;break;}
			}
			if(c==0){
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str=str.replaceAll("[^a-zA-Z\\s]", "");
		str=str.toLowerCase();
		int c=0;
		
		while (c < str.length() && str.charAt(c) != ' ') {
			c++;
		}
		String str1="",str2=""; 
		// Extract the first part, including the first space if found
		if(c<str.length())
			 str1 = str.substring(0, c + 1) ; 
		else
			str1=str;
		if(c+1<str.length())
		   str2 = str.substring(c + 1) ;
		else
			str2="";
		str2=str2.replaceAll("[^a-zA-Z]", "");
		
		return str1+str2;
	
		
		
	}
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int c=1;
		String str1=str;
		String str2="";
		while(c<str.length()){
			if(str1.isEmpty())
			break;
			
			int l=(int)(Math.random() * (str.length()-c)) ;
			str2=str2+str1.charAt(l);
			 str1=str1.replace(String.valueOf(str2.charAt((str2.length()-1))), "");
			 
			c++;
			
			
		}for (int i=0;i<str.length();i++){
			for(int j=0;j<str.length();j++){
				if(str.charAt(j)==str.charAt(i)&&j!=i){
					return str2+str.charAt(j);
				}
			}
		}
		return str2+str1;
	}
}
