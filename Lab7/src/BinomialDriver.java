
public class BinomialDriver {
	public static void main(String[] args) {
		//System.out.println(binomialRecursive(100, 0));
		iterativePT(9);
	}

	public static int binomialRecursive(int n, int k) {
		int result;
		if (k == n || k == 0) {
			result = 1;
		} else {
			result = binomialRecursive(n - 1, k - 1) + binomialRecursive(n - 1, k);
		}
		return result;
	}
	
	
	public static void iterativePT(int n) {
        int[][] pascal  = new int[n+1][]; //shows n + 1 rows
        pascal[1] = new int[3]; //fix line 1 0
        pascal[1][1] = 1; //base for the second line 1 1
        for (int i = 2; i <= n; i++) { // stop at the end of entry line
        	pascal[i] = new int[i+2]; // ^
            for (int j = 1; j < pascal[i].length - 1; j++)
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]; //follows binomial form; populates
        }
        for (int i = 1; i <= n; i++) { //print all contents of the 2d array.
            for (int j = 1; j < pascal[i].length - 1; j++) {
                System.out.print(pascal[i][j] + " "); //get contents in each spot ex. 5_
            }
            System.out.println(); //next line
        }
	}
}
