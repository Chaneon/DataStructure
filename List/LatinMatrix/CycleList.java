package LatinMatrix;

public class CycleList {
	private Node head;
	private Node current;
	
	public CycleList(){
		head=new Node();
		current=head;
		head.next=head;
	}
	
	public boolean isEmpty(){
		return (head.data==0 && head.next==head);
	}
	
	public void add(int data){
		if(isEmpty()){
			head.data=data;
		}else{
			Node newNode=new Node(data);
			newNode.next=current.next;
			current.next=newNode;
			current=newNode;	
		}
	}
	
	public void LatinMetrix(){
		if(!isEmpty()){
			boolean flag=true;
			Node temp=head;
			while(flag){
				current=temp;
				while(current.next!=temp){
					System.out.print(current.data+", ");
					current=current.next;
				}
				System.out.println(current.data);
				temp=temp.next;
				if(temp==head){
					flag=false;
				}
			}
		}	
	}
	
}
