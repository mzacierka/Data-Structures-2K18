import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Driver {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static int counter = 0;
	private static int calls;
	public static void main(String[] args) {
		try {
//			System.out.print("Enter a number for factorial: ");
//			BigInteger n = BigInteger.valueOf(Long.parseLong(stdin.readLine()));
//			System.out.print(n + "\n");
//			System.out.println(rFactorial3(n));
			
			int n = Integer.parseInt(stdin.readLine().trim());
			solve(n,"start","temp","destination");
			System.out.println("Number of total method calls: " + calls);
			System.out.println("Number of total moves: " + counter);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static int rFactorial1(int n) { //breaks at 13 input = 1932053504 answer = 6227020800
		int result;
		if(n == 1 || n == 0) {
			result = 1;
		} else {
			result = n * rFactorial1(n-1);
		}
		return result;
	}
	
	private static long rFactorial2(int n) { //21
		long result;
		if(n == 1 || n == 0) {
			result = 1;
		} else {
			result = n * rFactorial2(n-1);
		}
		return result;
	}
	
	public static BigInteger rFactorial3(BigInteger n) { //885
		BigInteger result;
		if(n == BigInteger.ONE || n == BigInteger.ZERO) {
			result = new BigInteger("1");
		} else {
			result = n.multiply(rFactorial3(n.subtract(BigInteger.ONE)));
		}
		return result;
	}
	
	public static BigInteger rFactorial4(BigInteger n) { //Out of Memory
		Object[] array = new Object[800000000];
		BigInteger result;
		if(n == BigInteger.ONE || n == BigInteger.ZERO) {
			result = new BigInteger("1");
		} else {
			result = n.multiply(rFactorial3(n.subtract(BigInteger.ONE)));
		}
		return result;
	}
	
	public static void solve(int n, String i, String d, String t) { //recursive solve w/counter:calls:moves
		counter++;
		if(n>0) {
			solve(n-1,i,t,d);
			System.out.println("Move disk " + n + " from " + i + " to " + d);
			solve(n-1,t,d,i);
			calls++;
		}
	}
}
