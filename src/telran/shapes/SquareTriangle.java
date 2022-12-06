package telran.shapes;

public class SquareTriangle extends Square {

	private boolean isLeftDiagonal;


	public SquareTriangle(int size, boolean isLeftDiagonal) {
		super(size);
		
	
	this.isLeftDiagonal = isLeftDiagonal;
	
	
	}
	
	public String[] presentation (int offset) {
		int size = super.getWidth();
		String[] res = leftTriangle(offset);
		res[size-1] = line(offset);
		return res;
	}
	
	
	public String line(int offset) {
		int size = super.getWidth();
		return " ".repeat(offset) + SYMBOL.repeat(size);

	}

	public String[] leftTriangle(int offset) {
		int size = super.getWidth();
		String[] res = new String[size];
		if (isLeftDiagonal) {
			res[0] = " ".repeat(offset + size - 1) + SYMBOL;
			for (int i = 1; i < res.length; i++) {
			res[i] = " ".repeat(offset + size - i - 1) + SYMBOL + " ".repeat(i-1) + SYMBOL;
				}
		
			
			
		} else {
			
			res[0] = " ".repeat(offset) + SYMBOL;
			for (int i = 1; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(i-1) + SYMBOL;
				}
		
		} 
		return res;
		
	}
}
	

	
	
	
	

	






	
		
	