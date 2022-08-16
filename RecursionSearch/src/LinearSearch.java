import java.util.*;

/*
 * LinearSearch class uses recursion to find a word by searching the array 
 * of words linearly or 'one by one.'
 */
public class LinearSearch extends SearchAlgorithm{ 
	
    /*
     * search() overrides the search method in SearchAlgorithm. 
     * Searches through file linearly to find a word.
     */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException{ 
        if(words.length == 0)
            throw new ItemNotFoundException("Array length of 0");
        for(int i = 0; i < words.length; i++){
            super.incrementCount();
            if(words[i].equals(wordToFind))
                return i;
        }
        throw new ItemNotFoundException("Word not found.");
    }
    
    /*
     * recSearch() here is a facade that uses the overridden function below this one to do work.
     */
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException{
        super.resetCount();
        return recSearch(0, words, wordToFind); 
    }
    
    /*
     * recSearch() here uses recursion to find the word in the array of words. 
     * Increments everytime the method is used.
     */
    private int recSearch(int index, String[] words, String wordToFind) throws ItemNotFoundException{
        super.incrementCount();
        if(words[index].equals(wordToFind))
        	return index;
        else if (words.length == index)
        	throw new ItemNotFoundException("Word not found.");
        else
        	return recSearch(index++, words, wordToFind); //recursive call with the next index
        
    }
    
}