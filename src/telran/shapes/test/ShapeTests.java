package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.shapes.*;


class ShapeTests {

	@Test
	@Disabled
	void rectangleTest() {
		Rectangle rectangle = new Rectangle(10, 15);
		assertEquals(10, rectangle.getWidth());
		assertEquals(15, rectangle.getHeight());
		displayString(rectangle.presentation(10));
		Rectangle.setSymbol("*");
		displayString(rectangle.presentation(15));
		
	}

	
	
	
	
	
	@Test
	@Disabled
	void squareTest() {
		Square square = new Square(15);
		displayString(square.presentation(5));
		square.setSymbol("&");
		displayString(square.presentation(5));
		
	}

	
//	@Test
//	void squareTriangleTest() {
//		SquareTriangle squaretr = new SquareTriangle (25, true);
//		displayString(squaretr.presentation(20));
//		SquareLeftTriangle squareleft = new SquareLeftTriangle(10, true);
//		
		
		@Test
		void squareLeftTriangleTest() {
			SquareLeftTriangle squareleft = new SquareLeftTriangle(10);
			displayString(squareleft.presentation(15));
			SqureRightTriangle squareright = new SqureRightTriangle(13);
			displayString(squareright.presentation(12));
	
	}
	
	private void displayString(String strings[]) {
		for(String str: strings) {
			System.out.println(str);
		}
	}
}

