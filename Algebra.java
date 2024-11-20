// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	
		public static void main(String args[]) {
			// Tests some of the operations
			System.out.println(plus(2,3));   // 2 + 3
			System.out.println(minus(7,2));  // 7 - 2
			System.out.println(minus(2,7));  // 2 - 7
			System.out.println(times(3,4));  // 3 * 4
			System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
			System.out.println(pow(5,3));      // 5^3
			System.out.println(pow(3,5));      // 3^5
			System.out.println(div(12,3));   // 12 / 3    
			System.out.println(div(5,5));    // 5 / 5  
			System.out.println(div(25,7));   // 25 / 7
			System.out.println(mod(25,7));   // 25 % 7
			System.out.println(mod(120,6));  // 120 % 6    
			System.out.println(sqrt(36));
			System.out.println(sqrt(263169));
			System.out.println(sqrt(76123));
		}  
	
		// Returns x1 + x2
		public static int plus(int x1, int x2) {
				int y = x2;
				int x=x1;
			
			while(y>0){
				y--;
				x++;
			}return x;}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int c=0;int x=x1;
		while (c<x2) {
			x--;
			c++;
			
		}return x;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int x=0;
		
		int c=0;
		while(c<x2)
		{x=plus(x,x1);
			c++;
		}return x;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int c=1;int x1=1;
		while (c<=n) {x1=times(x1,x);
			c++;
		}return x1;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int x=x1;int y=x2;
		int c=0;
		while(minus(x, y)>=0){x=minus(x, y);
			c++;
		}return c;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int x=div(x1,x2)*x2;
		int y= minus(x1, x);
		return y;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int c=0;
		int x1=0;
		while(c<=x){
			if(pow(c, 2)==x)
				return c;
			else
				if(pow(c,2)>x)
					return c-1;
			c++;
		}return 0;
	}	  	  
}