package traverse;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BiTree {
	 Node root=null;
	 
	 public void built() throws IOException{
		root=createTree(root);
	 }
	//按先序顺序创建二叉树
	public Node createTree(Node node) throws IOException{
		char ch=(char) System.in.read();
		if(ch=='#') return null;
		else{
			node=new Node(ch);
			node.setLchild(createTree(node.getLchild()));
			node.setRchild(createTree(node.getRchild()));
		}
		return node;
	}
	
	//先序遍历
	public void preOrder(Node node){
		if(node!=null){
			System.out.print(node.getData());
			preOrder(node.getLchild());
			preOrder(node.getRchild());
		}
	}
	
	//中序遍历
	public void inOrder(Node node){
		if(node!=null){
			inOrder(node.getLchild());
			System.out.print(node.getData());
			inOrder(node.getRchild());
		}
	}
	
	//后序遍历
	public void postOrder(Node node){
		if(node!=null){
			postOrder(node.getLchild());
			postOrder(node.getRchild());
			System.out.print(node.getData());
		}
	}
	
	//层次遍历
	//每次出队前把每个节点的左右孩子入队，这样下次出队的时候就是上一个出队元素的左右孩子
	public void levelOrder(Node root){
		if(root==null) return;
	
		LinkedList<Node> queue=new LinkedList<>();
		queue.offer(root);//根节点入队
		Node current=null;
		while(!queue.isEmpty()){
			current=queue.poll();//将队头元素出队
			System.out.print(current.getData());
			if(current.getLchild()!=null){
				queue.offer(current.getLchild());
			}
			if(current.getRchild()!=null){
				queue.offer(current.getRchild());
			}
		}
	}
	
	//非递归先序遍历
	public void preOder2(Node node){
		Stack<Node> stack=new Stack<Node>();
		//第一种
//		while(node!=null || !stack.isEmpty()){
//			while(node!=null){
//				System.out.print(node.getData());
//				stack.push(node);
//				node=node.getLchild();
//			}
//			node=stack.pop();
//			node=node.getRchild();
//		}
		//第二种
		if(node!=null){
			stack.push(node);
			while(!stack.isEmpty()){
				node=stack.pop();
				System.out.print(node.getData());
				if(node.getRchild()!=null){
					stack.push(node.getRchild());
				}
				if(node.getLchild()!=null){
					stack.push(node.getLchild());
				}
			}
		}	
	}
	
	
	//非递归中序遍历
	public void inOrder2(Node node){
		Stack<Node> stack=new Stack<Node>();
		
		while(node!=null || !stack.isEmpty()){
			while(node!=null){
				stack.push(node);
				node=node.getLchild();
			}
			node=stack.pop();
			System.out.print(node.getData());
			node=node.getRchild();
		}
	}
	
	//非递归后序遍历
	public void postOrder2(Node node){
		Node q = node;    
        Stack<Node> stack = new Stack<Node>();    
        while (node != null) {    
            // 左子树入栈    
            for (; node.getLchild() != null; node = node.getLchild())    
                stack.push(node);    
            // 当前节点无右子或右子已经输出    
            while (node != null && (node.getRchild() == null || node.getRchild() == q)) {    
                System.out.print(node.getData());  
                q =node;// 记录上一个已输出节点    
                if (stack.empty())    
                    return;    
                node = stack.pop();    
            }    
            // 处理右子    
            stack.push(node);    
            node = node.getRchild();    
        }    
	}
}

