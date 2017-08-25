package RPN;
//逆波兰表达式 即后缀表达式     中缀表达式转化为后缀表达式
public class Main {

	public static void main(String[] args) {
		RPN rpn=new RPN();
		String r=rpn.ReversePolish("A*(B+C)-D/(E+F)");
		System.out.println(r);
	}

}
