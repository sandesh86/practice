import BadArgsException.BadArgsException;


public class TestMain {

	public static boolean checkArgs(String[] args) throws Exception {
        if (args.length != 2) {
            throw new BadArgsException();
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            TestMain.checkArgs(args);
        } catch (BadArgsException b) {
            System.out.println("Bad arguments");
            System.exit(-1);
        } catch (Exception e) {
            System.out.println("Unknown exception");
            System.exit(-2);
        }
        System.out.println("Success");
    }
	/*public static void main(String[] args) {
		System.out.println(doesStringHasPattern("abab"));
		boolean a = false;
		if (a = false) {
			System.out.println("1");
		}
		else {
			System.out.println("2");
		}
		
	}*/
	
	  static boolean doesStringHasPattern(String givenString) {
			boolean doesStringHasPattern=false;
	      
	      // your code goes here
	        
	        int len = givenString.length();
	        for(int n = 2; n <= len/2; n++) {
	            if(len % n == 0) {
	                boolean isPattern = true;
	                int start = 0;
	                int end = n;
	                while(end < len) {
	                    String oldStr = givenString.substring(start, end);
	                    start += n;
	                    end += n;
	                    if (end > len) {
	                        //isPattern = false;
	                        break;
	                    }
	                        
	                    String newStr = givenString.substring(start, end);
	                    if (!oldStr.equals(newStr)){
	                        isPattern = false;
	                        break;
	                    }
	                }
	                if (isPattern) {
	                    doesStringHasPattern = true;
	                    break;
	                }
	            }
	        }
	      
			return doesStringHasPattern;
	    }
}
