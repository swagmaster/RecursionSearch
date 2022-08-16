
/*
 * BinarySearch class uses binarysearch method to find a word in the array of words.
 * One fucntion use recursion to binary search the array. Another function uses regular binary search method.
 */
public class BinarySearch extends SearchAlgorithm {
	
	/*
	 * search() method overrides the parent search method and uses the 
	 * binary search method by creating a low, high, and mid index to determine
	 * where a word is in the array of words.
	 */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException{ 
        super.resetCount();
        
        int lowIndex = 0, highIndex = words.length - 1, midIndex;
        
        while(lowIndex <= highIndex){
            super.incrementCount();
            midIndex = (lowIndex + highIndex) / 2;
            if(words[midIndex].equals(wordToFind))
                return midIndex;
            if(wordToFind.compareTo(words[midIndex]) < 0) //If negative, remove right side of array.
                highIndex = midIndex - 1; // adjusting index of search
            if(wordToFind.compareTo(words[midIndex]) > 0) //If positive, remove left side of array.
                lowIndex = midIndex + 1; //adjusting index of search
        }
        throw new ItemNotFoundException("Word not found.");
    }

    /*
     * recSearch() here is a facade and makes the private recSearch() method below
     * do the work.
     */
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException{
        return recSearch(words, 0, words.length - 1, wordToFind);
    }

    /*
     * recSearch() method uses recursion in it's binary search to find the word in the 
     * array of words.
     */
    private int recSearch(String[] words, int lowIndex, int highIndex, String wordToFind) throws ItemNotFoundException{
        int midIndex = (lowIndex + highIndex) / 2;
        if(lowIndex <= highIndex){
            super.incrementCount();
            if(words[midIndex].equals(wordToFind))
                return midIndex;
            
            //determines if word is on lowerhalf or upperhalf of the array
            if(wordToFind.compareTo(words[midIndex]) < 0) //If negative, remove right side of array.
                return recSearch(words, lowIndex, midIndex - 1, wordToFind); // recursive call with the low to mid index
            if(wordToFind.compareTo(words[midIndex]) > 0) //If positive, remove left side of array.
                return recSearch(words, midIndex + 1, highIndex, wordToFind); // recursive call with the mid to high index
        } else {
        throw new ItemNotFoundException("Word not found.");
        }
    return -1;
    }
}