package assignment03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TriangleClassifierTester {	
	Triangle test;
	
	@Test
	public void testClassify1() {		
		test = new Triangle(10.0,445.9/44.59,523.7/52.37);
		assertEquals("This is equilateral to within 10^-12",
				"The triangle is equilateral", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify2() {		
		test = new Triangle(15.0,445.9/44.59,523.7/52.37);
		assertEquals("This is isosceles to within 10^-12",
				"The triangle is isosceles", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify3() {		
		test = new Triangle(2.5,445.9/44.59,523.7/52.37);
		assertEquals("This is isosceles to within 10^-12",
				"The triangle is isosceles", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify4() {		
		test = new Triangle(445.9/44.59,15.0,523.7/52.37);
		assertEquals("This is isosceles to within 10^-12",
				"The triangle is isosceles", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify5() {		
		test = new Triangle(445.9/44.59,2.5,523.7/52.37);
		assertEquals("This is isosceles to within 10^-12",
				"The triangle is isosceles", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify6() {		
		test = new Triangle(445.9/44.59,523.7/52.37,15.0);
		assertEquals("This is isosceles to within 10^-12",
				"The triangle is isosceles", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify7() {		
		test = new Triangle(445.9/44.59,523.7/52.37,2.5);
		assertEquals("This is isosceles to within 10^-12",
				"The triangle is isosceles", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify8() {		
		test = new Triangle(445.9/44.59,6,8);
		assertEquals("This is right-angled scalene to within 10^-12",
				"The triangle is right-angled scalene", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify9() {		
		test = new Triangle(445.9/44.59,8,6);
		assertEquals("This is right-angled scalene to within 10^-12",
				"The triangle is right-angled scalene", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify10() {		
		test = new Triangle(6,445.9/44.59,8);
		assertEquals("This is right-angled scalene to within 10^-12",
				"The triangle is right-angled scalene", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify11() {		
		test = new Triangle(8,445.9/44.59,6);
		assertEquals("This is right-angled scalene to within 10^-12",
				"The triangle is right-angled scalene", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify12() {		
		test = new Triangle(8,6,445.9/44.59);
		assertEquals("This is right-angled scalene to within 10^-12",
				"The triangle is right-angled scalene", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify13() {		
		test = new Triangle(6,8,445.9/44.59);
		assertEquals("This is right-angled scalene to within 10^-12",
				"The triangle is right-angled scalene", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify14() {		
		test = new Triangle(445.9/44.59, 445.9/44.59, 10*Math.sqrt(2));
		assertEquals("This is right-angled isosceles to within 10^-12",
				"The triangle is right-angled isosceles", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify15() {		
		test = new Triangle(445.9/44.59, 10*Math.sqrt(2), 445.9/44.59);
		assertEquals("This is right-angled isosceles to within 10^-12",
				"The triangle is right-angled isosceles", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify16() {		
		test = new Triangle(10*Math.sqrt(2), 10, 445.9/44.59);
		assertEquals("This is right-angled isosceles to within 10^-12",
				"The triangle is right-angled isosceles", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify17() {		
		test = new Triangle(7, 10, 5);
		assertEquals("This is scalene and obtuse",
				"The triangle is scalene and obtuse", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify18() {		
		test = new Triangle(7, 8, 5);
		assertEquals("This is scalene and acute-angled",
				"The triangle is scalene and acute-angled", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify19() {		
		test = new Triangle(7, 8, 16);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify20() {		
		test = new Triangle(7, 16, 8);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify21() {		
		test = new Triangle(16, 8, 7);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify22() {		
		test = new Triangle(0, 8, 7);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify23() {		
		test = new Triangle(8, 0, 7);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify24() {		
		test = new Triangle(8, 7, 0);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify25() {		
		test = new Triangle(0, 0, 7);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify26() {		
		test = new Triangle(8, 0, 0);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify27() {		
		test = new Triangle(0, 7, 0);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify28() {		
		test = new Triangle(0, 0, 0);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify29() {		
		test = new Triangle(-4, 8, 7);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify30() {		
		test = new Triangle(8, -4, 7);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify31() {		
		test = new Triangle(8, 7, -4);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify32() {		
		test = new Triangle(-3, -4, 7);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify33() {		
		test = new Triangle(8, -3, -4);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}
	
	@Test
	public void testClassify34() {		
		test = new Triangle(-4, 7, -2);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify35() {		
		test = new Triangle(-1, -3, -5);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}

	@Test
	public void testClassify36() {		
		test = new Triangle(-2.5, -3, -5);
		assertEquals("Invalid Triangle",
				"This is not a valid Triangle", TriangleClassifier.classify(test));
	}
}
