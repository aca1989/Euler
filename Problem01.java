// This class finds the sum of all the numbers under 1000
// that are multiples of three or five

public class Problem1 {

    public static void main(String args[])
    {
    	long start = System.currentTimeMillis();
		int sum = 0;

		for(int i = 0; i < 1000; i++) {
		    if(i % 3 == 0 || i % 5 == 0)
			sum += i;
		}

		System.out.println(sum);
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
    }
}