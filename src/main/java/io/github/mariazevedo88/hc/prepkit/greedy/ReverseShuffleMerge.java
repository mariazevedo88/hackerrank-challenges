package io.github.mariazevedo88.hc.prepkit.greedy;

/**
 * Given a string, A, we define some operations on the string as follows:
 * 
 * a. reverse(A) denotes the string obtained by reversing string A. Example: reverse("abc") = "cba"
 * b. shuffle(A) denotes any string that's a permutation of string A. Example: 
 * shuffle("god") E ['god','gdo','ogd','odg','dgo','dog']
 * c. merge(A1,A2) denotes any string that's obtained by interspersing the two strings A1 & A2, maintaining 
 * the order of characters in both. For example, A1 = "abc" & A2 = "def", one possible result of merge(A1,A2) 
 * could be "abcdef", another could be "abdecf", another could be "adbecf" and so on.
 * 
 * Given a string s such that s E merge(reverse(A),shuffle(A)) for some string A, find the lexicographically 
 * smallest A.
 * 
 * For example, s=abab. We can split it into two strings of ab. The reverse is ba and we need to find a string 
 * to shuffle in to get abab. The middle two characters match our reverse string, leaving the a and b at the 
 * ends. Our shuffle string needs to be ab. Lexicographically ab < ba, so our answer is ab.
 * 
 * Function Description
 * 
 * Complete the reverseShuffleMerge function in the editor below. It must return the lexicographically smallest 
 * string fitting the criteria.
 * 
 * reverseShuffleMerge has the following parameter(s):
 * - s: a string
 * 
 * Input Format
 * 
 * A single line containing the string s.
 * 
 * Constraints
 * 
 * - s contains only lower-case English letters, ascii[a-z]
 * - 1 <= |s| <= 10000
 * 
 * Output Format
 * 
 * Find and return the string which is the lexicographically smallest valid A.
 * 
 * Sample Input 0
 * 
 * eggegg
 * 
 * Sample Output 0
 * 
 * egg
 * 
 * Explanation 0
 * 
 * Split "eggegg" into strings of like character counts: "egg", "egg"
 * reverse("egg") = "gge"
 * shuffle("egg") can be "egg"
 * "eggegg" belongs to the merge of ("gge", "egg")
 * 
 * The merge is: gge.
 * 
 * 'egg' < 'gge'
 * 
 * Sample Input 1
 * 
 * abcdefgabcdefg
 * 
 * Sample Output 1
 * 
 * agfedcb
 * 
 * Explanation 1
 * 
 * Split the string into two strings with like characters: abcdefg and abcdefg.
 * Reverse abcdefg = gfedcba
 * Shuffle agfedcb can be bcdefga 
 * 
 * Merge to bcdefga
 * 
 * Sample Input 2
 * 
 * aeiouuoiea
 * 
 * Sample Output 2
 * 
 * aeiou
 * 
 * Explanation 2
 * 
 * Split the string into groups of like characters: aeiou
 * Reverse aeiou = uoiea
 * These merge to uoiea
 * 
 * @author Mariana Azevedo
 * @since 26/02/2020
 */
public class ReverseShuffleMerge {

	public static void main(String[] args) {
		System.out.println(reverseShuffleMerge("eggegg")); //egg
		System.out.println(reverseShuffleMerge("abcdefgabcdefg")); //agfedcb
		System.out.println(reverseShuffleMerge("aeiouuoiea")); //aeiou
	}
	
	// Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
    	
    	//Storing the count of each character (a to z) in S
    	int[] count = new int[26];
    	
        for (int i=0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder builder = new StringBuilder();
        
        //Dictionaries
        int[] usedLetters = new int[26], remainedLetters = new int[26];
        
        for (int i = 0; i < count.length; i++) {
            remainedLetters[i] = count[i];
        }
        
        for (int i=s.length()-1; i >= 0; i--) {
            
        	char charactere = s.charAt(i);
            
        	if (builder.length() == 0) {
                builder.append(charactere);
                usedLetters[charactere - 'a']++;
            }else {
                
            	if (2*usedLetters[charactere - 'a'] == count[charactere - 'a']) {
                    remainedLetters[charactere - 'a']--;
                    continue;
                }
                
                while (builder.length() > 0) {
                    char last = builder.charAt(builder.length() - 1);
                    //Updating the count of characters required for A by multiplying the remained letters by 2
                    if (charactere < last && 2*(remainedLetters[last - 'a'] + usedLetters[last - 'a']) > 
                    	count[last - 'a']){
                        usedLetters[last - 'a']--;
                        builder.deleteCharAt(builder.length() - 1);
                    }else {
                        break;
                    }
                }
                
                //Selecting each character for A by parsing S from right to left.
                builder.append(charactere);
                usedLetters[charactere - 'a']++;
            }
        	
            remainedLetters[charactere - 'a']--;
        }
        
        return builder.toString();
    }
}
