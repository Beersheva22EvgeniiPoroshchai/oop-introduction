package telran.measure;

public enum LengthUnit {
MM(1), SM(10), M(1000), KM(1_000_000), IN(25.4f);
	float value;
	LengthUnit(float value) {
	this.value = value; 
	}
	
	public Length between (Length l1, Length l2) {
		Length newL1 = l1.convert(this);
		Length newL2 = l2.convert(this);
		Length res = new Length (newL2.getAmount() - newL1.getAmount(), this);
		return res;
	
	}
	
	public float getValue() {
	return value;
		
		
	}
	
	
}
