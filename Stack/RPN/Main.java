package RPN;

public class Main {

	public static void main(String[] args) {
		RPN rpn=new RPN();
		String r=rpn.ReversePolish("A*(B+C)-D/(E+F)");
		System.out.println(r);
	}

}
