package telran.shapes;

public class Canvas extends Shape {
	
	private Shape[] shapes;
	private int margin = 5;
	private String direction = "row";
	
	
	public Canvas(int width, int height, Shape[] shapes) {
		super(width, height);
		this.shapes = shapes;
	}

	@Override
	public String[] presentation(int offset) {
		int height = this.getHeight();

		String[] showShapes = new String[height];

			if (direction.equals("row")) {
			
			Shape firstShape = shapes[0];
			firstShape.setHeight(height);
			String[] firstShapeArr = firstShape.presentation(offset);
			for (int i = 0; i < showShapes.length; i++) {
					showShapes[i] = firstShapeArr[i];
				}
			for (int i = 1; i < shapes.length; i++) {
				Shape shape = shapes[i];
				shape.setHeight(height);
				String[] shapeArr = shape.presentation(margin);
				
				for (int j = 0; j < shapeArr.length; j++) {					
					showShapes[j] += shapeArr [j];
				}
 						
			}
				}  
					
			return showShapes;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}



