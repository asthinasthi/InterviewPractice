
public class SumOfDigits {

	public static void main(String[] args) {
		String num = "1234";
		int Total = Integer.parseInt(num) - 9*(( Integer.parseInt(num) - 1)/9);
		System.out.println(Total);
	}
}
