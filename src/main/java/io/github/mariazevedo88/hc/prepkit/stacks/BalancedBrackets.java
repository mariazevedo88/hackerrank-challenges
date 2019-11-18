package io.github.mariazevedo88.hc.prepkit.stacks;

import java.util.Deque;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ]. 
 * 
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket 
 * (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
 * 
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced 
 * because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, 
 * (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 * 
 * By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 * 
 * - It contains no unmatched brackets.
 * - The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 * 
 * Given n strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. 
 * Otherwise, return NO.
 * 
 * Function Description
 * 
 * Complete the function isBalanced in the editor below. It must return a string: YES if the sequence is balanced or NO if it is not.
 * isBalanced has the following parameter(s):
 * 
 * - s: a string of brackets
 * 
 * Input Format
 * 
 * The first line contains a single integer , the number of strings.
 * Each of the next  lines contains a single string , a sequence of brackets.
 * 
 * Constraints
 * 
 * - 1<=n<=10³
 * - 1<= |s|<=10³, where  is the length of the sequence.
 * - All chracters in the sequences ∈ { {, }, (, ), [, ] }.
 * 
 * Output Format
 * 
 * For each string, return YES or NO.
 * 
 * Sample Input
 * 
 * 3
 * {[()]}
 * {[(])}
 * {{[[(())]]}}
 * 
 * Sample Output
 * 
 * YES
 * NO
 * YES
 * 
 * Explanation
 * 
 * 1. The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 * 2. The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
 * 3. The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 * 
 * @author Mariana Azevedo
 * @since 16/11/2019
 */
public class BalancedBrackets {
	
	private static final String YES = "YES";
	private static final String NO = "NO";
	
	private static final Logger logger = LoggerFactory.getLogger(BalancedBrackets.class);

	public static void main(String[] args) {
		logger.info(isBalanced("{[(])}")); //NO
		logger.info(isBalanced("{{[[(())]]}}")); //YES
		logger.info(isBalanced("{[()]}")); //YES
		logger.info(isBalanced("}][}}(}][))]")); //NO
	}
	
	// Complete the isBalanced function below.
    static String isBalanced(String s) {

    	Deque<Character> stack = new LinkedList<>();
    	
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
    			stack.push(s.charAt(i));
    		}else {
    			if(stack.isEmpty()) {
    				return NO;
    			}else {
    				char value = stack.pop();
    				if(compareBrackets(s, i, value)) return NO;
    			}
    		}
    	}
    	
    	if(stack.isEmpty()) {
    		return YES;
    	}
    	
    	return NO;
    }

	private static boolean compareBrackets(String s, int i, char value) {
		return ((s.charAt(i) == ')' && value != '(') || (s.charAt(i) == '}' && value != '{') ||
		   (s.charAt(i) == ']' && value != '['));
	}

}
