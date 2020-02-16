package io.github.mariazevedo88.hc.prepkit.recursion;

import java.util.Arrays;

/**
 * A 10x10 Crossword grid is provided to you, along with a set of words (or names of places) which need to be filled into the grid. 
 * Cells are marked either + or -. Cells marked with a - are to be filled with the word list.
 * 
 * The following shows an example crossword from the input crossword grid and the list of words to fit, words=[POLAND,LHASA,SPAIN,INDIA]:
 * 
 * Input 	   		Output
 * ++++++++++ 		++++++++++
 * +------+++ 		+POLAND+++
 * +++-++++++ 		+++H++++++
 * +++-++++++ 		+++A++++++
 * +++-----++ 		+++SPAIN++
 * +++-++-+++ 		+++A++N+++
 * ++++++-+++ 		++++++D+++
 * ++++++-+++ 		++++++I+++
 * ++++++-+++ 		++++++A+++
 * ++++++++++ 		++++++++++
 * POLAND;LHASA;SPAIN;INDIA
 * 
 * Function Description
 * 
 * Complete the crosswordPuzzle function in the editor below. It should return an array of strings, each representing a row of the finished 
 * puzzle.
 * 
 * crosswordPuzzle has the following parameter(s):
 * - crossword: an array of  strings of length  representing the empty grid
 * - words: a string consisting of semicolon delimited strings to fit into 
 * 
 * Input Format
 * 
 * Each of the first 10 lines represents crossword[i], each of which has 10 characters, crossword[i][j].
 * The last line contains a string consisting of semicolon delimited words[i] to fit.
 * 
 * Constraints
 * 
 * 1 <= |words| <= 10
 * crossword[i][j] E {+,-}
 * words[i][j] E ascii[A-Z]
 * 
 * Output Format
 * 
 * Position the words appropriately in the 10x10 grid, then return your array of strings for printing.
 * 
 * Sample Input 0
 * 
 * +-++++++++
 * +-++++++++
 * +-++++++++
 * +-----++++
 * +-+++-++++
 * +-+++-++++
 * +++++-++++
 * ++------++
 * +++++-++++
 * +++++-++++
 * 
 * LONDON;DELHI;ICELAND;ANKARA
 * 
 * Sample Output 0
 * 
 * +L++++++++
 * +O++++++++
 * +N++++++++
 * +DELHI++++
 * +O+++C++++
 * +N+++E++++
 * +++++L++++
 * ++ANKARA++
 * +++++N++++
 * +++++D++++
 * 
 * Sample Input 1
 * 
 * +-++++++++
 * +-++++++++
 * +-------++
 * +-++++++++
 * +-++++++++
 * +------+++
 * +-+++-++++
 * +++++-++++
 * +++++-++++
 * ++++++++++
 * 
 * AGRA;NORWAY;ENGLAND;GWALIOR
 * 
 * Sample Output 1
 * 
 * +E++++++++
 * +N++++++++
 * +GWALIOR++
 * +L++++++++
 * +A++++++++
 * +NORWAY+++
 * +D+++G++++
 * +++++R++++
 * +++++A++++
 * ++++++++++
 * 
 * Sample Input 2
 * 
 * XXXXXX-XXX
 * XX------XX
 * XXXXXX-XXX
 * XXXXXX-XXX
 * XXX------X
 * XXXXXX-X-X
 * XXXXXX-X-X
 * XXXXXXXX-X
 * XXXXXXXX-X
 * XXXXXXXX-X
 * 
 * ICELAND;MEXICO;PANAMA;ALMATY
 * 
 * Sample Output 2
 * 
 * XXXXXXIXXX
 * XXMEXICOXX
 * XXXXXXEXXX
 * XXXXXXLXXX
 * XXXPANAMAX
 * XXXXXXNXLX
 * XXXXXXDXMX
 * XXXXXXXXAX
 * XXXXXXXXTX
 * XXXXXXXXYX
 * 
 * @author Mariana Azevedo
 * @since 15/02/2020
 */
public class CrosswordPuzzle {

	private static boolean found = false;

	public static void main(String[] args) {
		
		String[] crossword1 = {"+-++++++++","+-++++++++","+-++++++++","+-----++++","+-+++-++++",
				"+-+++-++++","+++++-++++", "++------++","+++++-++++", "+++++-++++"};
		String words1 = "LONDON;DELHI;ICELAND;ANKARA";
		String[] puzzle1 = crosswordPuzzle(crossword1, words1);
		
		for(String word : puzzle1) {
			System.out.println(word);
		}
		
		System.out.println("");
		found = false;
		
		String[] crossword2 = {"+-++++++++","+-++++++++","+-------++","+-++++++++","+-++++++++",
				"+------+++","+-+++-++++","+++++-++++","+++++-++++","++++++++++"};
		String words2 = "AGRA;NORWAY;ENGLAND;GWALIOR";
		String[] puzzle2 = crosswordPuzzle(crossword2, words2);
		
		for(String word : puzzle2) {
			System.out.println(word);
		}
		
		System.out.println("");
		found = false;
		
		String[] crossword3 = {"XXXXXX-XXX","XX------XX","XXXXXX-XXX","XXXXXX-XXX","XXX------X",
				"XXXXXX-X-X","XXXXXX-X-X","XXXXXXXX-X","XXXXXXXX-X","XXXXXXXX-X"};
		String words3 = "ICELAND;MEXICO;PANAMA;ALMATY";
		String[] puzzle3 = crosswordPuzzle(crossword3, words3);
		
		for(String word : puzzle3) {
			System.out.println(word);
		}
	}
	
	// Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {

    	char[][] resultArray = new char[crossword.length][crossword[0].length()];

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length(); j++) {
                resultArray[i][j] = crossword[i].charAt(j);
            }
        }
        char[][] result = occurrence(resultArray, words.split(";"), 0);
        String[] resInString = new String[crossword.length];
        
        for(int i = 0; i< result.length; i++) {
            resInString[i] = new String(result[i]);
        }
        
        return resInString;
    }

    private static char[][] occurrence(char[][] crossword, String[] words, int i) {
    
	    if(i == words.length) {
	        found = true;
	        return crossword;
	    }

	    for (int j = 0; j < crossword.length; j++) {
	    	for (int k = 0; k < crossword[j].length; k++) {

	            if (crossword[j][k] == '+') {
	                continue;
	            }

	            // add in row j
	            boolean addToRow = canBeAddedToRow(words[i], crossword[j], k);
	
	            if (addToRow) {
	                char newCross[][] = addToRow(words[i], crossword,j, k);
	                char ifAddedToRow[][] = occurrence(newCross, words, i+1);
	                
	                if(found) {
	                    return ifAddedToRow;
	                }
	            }

	            boolean addToColumn = canBeAddedToColumn(words[i], crossword, j, k);
	
	            if (addToColumn) {
	                char newCross[][] = addToColumn(words[i], crossword,j, k);
	                
	                char ifAddedToCol[][] =  occurrence(newCross, words, i+1);
	                if(found) {
	                    return ifAddedToCol;
	                }
	            }
	    	}
	    }
	    
	    return crossword;
    }

	private static char[][] addToColumn(String string, char[][] crossword, int j, int k) {
	    char[][] newValue = deepCopy(crossword);
	    
	    for(int i = 0; i< string.length(); i++ ) {
	        newValue[j+i][k] = string.charAt(i);
	    }
	    return newValue;
	}

	private static char[][] addToRow(String string, char[][] crossword, int j, int k) {
	
	    char[][] newValue = deepCopy(crossword);
	
	    for(int i = 0; i< string.length(); i++ ) {
	        newValue[j][k + i] = string.charAt(i);
	    }
	    return newValue;
	}

	private static char[][] deepCopy(char[][] crossword) {
	    char[][] newValue = new char[crossword.length][crossword[0].length];
	    for (int i = 0; i < newValue.length; i++)
	        newValue[i] = Arrays.copyOf(crossword[i], crossword[i].length);
	    return newValue;
	}

	private static boolean canBeAddedToColumn(String string, char[][] crossword, int j, int k) {
	    int wordCounter = 0;
	    
	    for (int i = j; i < crossword.length; i++) {
	        if (wordCounter == string.length() || string.charAt(wordCounter) != crossword[i][k] && crossword[i][k] != '-') {
	            break;
	        }
	        wordCounter++;
	    }
	    
	    return (wordCounter == string.length());
	}

	private static boolean canBeAddedToRow(String string, char[] crossword, int k) {
	    int wordCounter = 0;
	    
	    for (int i = k; i < crossword.length; i++) {
	        if (wordCounter == string.length() || string.charAt(wordCounter) != crossword[i] && crossword[i] != '-') {
	            break;
	        }
	        wordCounter++;
	    }
	    
	    return (wordCounter == string.length());
	}
}
