public class IfElseIfElse {
	public static void main(String[] args) {
		boolean lie = false;
		if (lie) {
			System.out.println("not passed");
		} else if (lie && false) {
			System.out.println("not passed");
		} else {
			System.out.println("passed");
		}
	}	
}
