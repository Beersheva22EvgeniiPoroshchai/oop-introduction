package telran.memory;

public class MemoryOperations {

	public static int getMaxAvaliableMemory() {
	int res = Integer.MAX_VALUE;
	boolean running = true;
	byte ar [] = null;
	int left = 0;
	int right = Integer.MAX_VALUE-1;
	int middle = right/2;
	
		while (running) {
		try {
			ar = null;
			ar = new byte[middle];
			
			try {
				ar = null;
				ar = new byte[middle +1];
				left = middle;
				} catch (Throwable e) {
					running = false;
				}
			
			if ((left+right)/2 < 0) {
				middle = (left + right)/2;
			
			} else {
				middle = (left + right) /2;
			} 
		}
		catch (Throwable e) {
		right = middle;
		middle = (left + right) /2;
		}
		}
		return middle;
	}
		
		
			
			
			
			
	}
		
	
			
