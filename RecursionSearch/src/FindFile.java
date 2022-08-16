import java.io.File;
import java.util.Arrays;

/*
 * FindFile classes searches for a target file by going through
 * directories and files of the path location.
 */
public class FindFile {
	
    private int maxFiles;
    private int count; 
    private String[] locations;
 
    /*
     * FindFile constructor sets the maxfiles and makes
     * a new array of String with length locations.
     */
    public FindFile(int maxFiles)
    {
	   this.maxFiles = maxFiles;
	   this.locations = new String[maxFiles];
    }

    /*
     * directorySearch() determines if a file is a directory or not.
     * If so, use the find function below to 'find' the file you are looking for.
     */
    public void directorySearch(String target, String dirName) {
    	
    	File f = new File(dirName);
    	
    	if (f.isDirectory()) {
		   find(target, dirName);
    	} else {
    		throw new IllegalArgumentException();
    	}
    }
    
    
	private void find(String target, String dirName) {
		
		File f = new File(dirName);
    	
    	if (f.isDirectory()) {
    		String[] fileList = f.list();
    		
    		for(int i = 0; i < fileList.length; i++) {
		       find(target, dirName + "/" + fileList[i]); //recursive call 
		       
    		}
    	} else if (target.equals(dirName.substring(((dirName.length()-1) - (target.length() - 1)), (dirName.length()))))
    		
		if (count < maxFiles) {
			locations[count++] = dirName;
            
		} else {
           throw new IllegalArgumentException("MAX_NUMBER_OF_FILES_TO_FIND");     
		}
    }
	
    public int getCount() {
    	return this.count;
    }

    public String[] getFiles() {
	   String[] retVal = Arrays.copyOf(locations, count);
	   return retVal;
    }
}