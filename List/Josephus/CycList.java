package Josephus;

public class CycList {
	Node head;
	Node current;
	
	public CycList(){
		head=new Node();
		current=head;
		head.next=head;
	}
	
	
	public void add(int data){
		Node newNode=new Node(data);
		if(head.next==head){
			head.next=newNode;
			newNode.next=head;
			
		}else{
			while(current.next!=head){
				current=current.next;
			}
			newNode.next=current.next;
			current.next=newNode;
			current=newNode;	
		}
	}
	
	
	public void Josephu(int totalnum,int countnum){
		Node temp=head;
		Node temp2;
		while(totalnum>1){
			//-1是为了得到数到3的那个人的前一个人，方便与后面的结点连接
			for(int i=1;i<countnum-1;i++){
				temp=temp.next;
			}
			//输出值+1是因为此链表从0开始，也就是说头节点值为0，其实是数1
			System.out.print(temp.next.data+1+"-->");
			temp2=temp.next.next;
			temp.next=temp2;
			temp=temp2;
			totalnum--;
		}
		//输出最后一个值
		System.out.println(temp.data+1);
	}
	
	
	public void print(){
		System.out.print("链表元素为：");
		if(head.next!=head){
			current=head.next;
			while(current.next!=head){
				System.out.print(current.data+", ");
				current=current.next;
			}
			System.out.print(current.data);
		}
	}
}
