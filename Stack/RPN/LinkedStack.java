package RPN;

public class LinkedStack {
	public Node top;
	private int count;//记录栈的大小
	
	public LinkedStack(){
		top=null;
	}
	
	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}

	public boolean isEmpty(){
		return (top==null);
	}
	
	public void push(Character element){
		if(isEmpty()){
			top=new Node(element);
			
		}else{
			Node newNode=new Node(element);
			newNode.setNext(top);
			top=newNode;
			count++;
		}
	}
	
	public void pop(){
		if(top!=null ){
			//System.out.print(top.getData());
			top=top.getNext();
			count--;
		}
	}
	
	
	public void print(){
		Node temp=top;
		while(temp!=null ){
			System.out.print(temp.getData());
			temp=temp.getNext();
		}
		System.out.println();
	}
}
