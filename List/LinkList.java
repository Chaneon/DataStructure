package mid;

public class LinkList {
	Node head;
	Node current;
	
	public void add(int data){
		if(head==null){
			head=new Node(data);
			current=head;
		}else{
			current.next=new Node(data);
			current=current.next;
		}	
	}
	
	public Node searchMid(){
		Node mid=head;
		Node fast=head;
		while(fast!=null && fast.next !=null){
			fast=fast.next.next;
			mid=mid.next;
		}
		
		return mid;
	}
	
	
	public void print(){
		System.out.print("链表元素为：");
		if(head!=null){
			current=head;
			while(current.next!=null){
				System.out.print(current.data+"， ");
				current=current.next;
			}
			System.out.println(current.data);
		}
	}
}
