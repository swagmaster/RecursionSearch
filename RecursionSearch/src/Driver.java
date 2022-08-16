

/*
 * Driver class sets a path to search and target file and determines how many
 * or i there are any instances of that target file.
 */
public class Driver {
	
	public static void main(String[] args) {
		String targetFile = "longwords.txt";
		String pathToSearch = "C:\\\\Users\\\\muhro\\\\eclipse-workspace\\\\RecursionSearch";
		FindFile find = new FindFile(60);
		
		try {
			find.directorySearch(targetFile, pathToSearch);
        } 
		catch (IllegalArgumentException e) {
			System.out.println("MAX NUMBER OF INSTANCES REACHED");
			System.out.println("There were " + find.getCount() + " target files found.");
			
			String[] path = find.getFiles();
			System.out.println("File was found at following locations: ");
			
			for (int i = 0; i < path.length; i++) {
				System.out.println(path[i] + "\n");
            }
			
			System.exit(0);
        }
		
		System.out.println("There were " + find.getCount() + " target files found.");
		String[] path = find.getFiles();
		System.out.println("File was found at following locations: ");
		
		for (int i = 0; i < path.length; i++) {
			System.out.println(path[i] + "\n");
        }
    }
}

