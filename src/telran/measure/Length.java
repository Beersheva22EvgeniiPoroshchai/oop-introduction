package telran.measure;

public class Length implements Comparable<Length>{
	private float amount;
	private LengthUnit lengthUnit;
	public Length(float amount, LengthUnit lengthUnit) {
		super();
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}
	@Override
	public int compareTo(Length o) {
		float newAmount = o.convert(lengthUnit).amount;
		int res = Float.compare(amount, newAmount);
		return res;
	}
	
	
	public boolean equals (Object obj) {
		boolean res = false;
		if (compareTo((Length)obj) == 0) {
			res = true;
		}
		return res;
	}
	
	
	public Length convert (LengthUnit unit) {
		Length res = new Length (amount * lengthUnit.getValue() / unit.getValue(), unit);
		return res;
	}
	
	
	public String toString() {
		String valStr = Float.toString(amount);
		String unStr = lengthUnit.toString();
		String res = valStr + unStr;
		return res;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public LengthUnit getUnit() {
		return lengthUnit; 
	}
	

}
