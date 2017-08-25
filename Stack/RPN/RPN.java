package RPN;

public class RPN {
	private LinkedStack lstack;
	private String output=""; 
	
	public RPN(){
		lstack=new LinkedStack();
	}
	
	//都到右括号的时候，若栈中此时的栈顶元素为‘(’，代表括号中没有运算符，否则将括号里的符号通过循环按顺序出栈，打印
	private  void matchBracket(char ch){
		while(!lstack.isEmpty()){
			char chax=lstack.getTop().getData();
			lstack.pop();
			if(chax=='(') break;
			else
				output=output+chax;
		}
	}
	
	//获取操作数
	private void getOperation(char op,int pre){
		while(!lstack.isEmpty()){
			char opTop=lstack.getTop().getData();
			if(opTop=='('){
				break;
			}else{
				int pre2;
				if(opTop=='+' || opTop=='-'){
					pre2=1;
				}else{
					pre2=2;
				}
				if(pre2<pre){
					break;
				}else{
					output=output+opTop;
					lstack.pop();
				}
			}
		} 
		lstack.push(op);
	}
	
	
	public String ReversePolish(String input){
		for(int i=0;i<input.length();i++){
			char ch=input.charAt(i);
			switch(ch){
			case '+':
			case '-':
				getOperation(ch,1);
				break;
			case '*':
			case '/':
				getOperation(ch,2);
				break;
			case '(':
				lstack.push(ch);
				break;
			case ')':	
				matchBracket(ch);
				break;
			default:
				output=output+ch;
				break;
			}
		}
		while(!lstack.isEmpty()){
			//if(lstack.getTop().getData()!='(')
				output=output+lstack.getTop().getData();
			lstack.pop();
		}
		return output;
	}
}
