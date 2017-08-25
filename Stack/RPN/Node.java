package RPN;

public class Node {
	private Character  data;
	private Node next;
	
	public Node(Character data){
		this.data=data;
		//this.next=next;
	}
	
	public Character getData() {
		return data;
	}
	public void setData(Character data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
