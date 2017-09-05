package AVLT;

import java.util.LinkedList;

public class AVLTree<T extends Comparable<T>> {
	Node root=null;
	
	private int max(int a,int b){
		return a>b?a:b;
	}
	
	/*
     * 获取树的高度
     */
    private int height(Node node) {
        if (node!= null)
            return node.getHeight();

        return 0;
    }
	
	private Node insert(Node node,T data){
		if(node==null){
			node=new Node<T>(data);
		}
		else{
			int cmp=data.compareTo((T) node.getData());
			if(cmp<0){//小于根节点,往树的左边插入
				node.setLeft(insert(node.getLeft(),data));
				//判断是否失去平衡
				if(height(node.getLeft())-height(node.getRight())==2){
					if(data.compareTo((T) node.getLeft().getData())<0){
						node=LLRotation(node);
					}else{
						node=LRRotation(node);
					}
				}
			}else if(cmp>0){//大于根节点，往树的右边插入
				node.setRight(insert(node.getRight(),data));
				//判断是否失去平衡
				if(height(node.getRight())-height(node.getLeft())==2){
					if(data.compareTo((T) node.getRight().getData())>0){
						node=RRRotation(node);
					}else{
						node=RLRotation(node);
					}
				}
			}else{//cmp==0
				System.out.println("插入失败，不能插入相同元素！");
			}
		}
		
		node.setHeight(max(height(node.getLeft()),height(node.getRight()))+1);
		
		return node;
	}
	
	public void add(T data){
		root=insert(root,data);
	}
	
	
	/*根的左子树的左子树还有节点，导致不平衡，实现单旋转，顺时针旋转
	 * 返回值为旋转后的根节点
	 * */
	public Node LLRotation(Node node){
		Node newNode;
		newNode=node.getLeft();
		node.setLeft(newNode.getRight());
		newNode.setRight(node);
		
		node.setHeight(max(height(node.getLeft()),height(node.getRight()))+1);
		newNode.setHeight(max(height(newNode.getLeft()),node.getHeight())+1);
		
		return newNode;
		
	}
	
	/*根的右子树的右子树还有结点，导致不平衡，实现单旋转，逆时针旋转
	 * 返回值为旋转后的根节点
	 * */
	public Node RRRotation(Node node){
		Node newNode;
		newNode=node.getRight();
		node.setRight(newNode.getLeft());
		newNode.setLeft(node);
		
		node.setHeight(max(height(node.getLeft()),height(node.getRight()))+1);
		newNode.setHeight(max(height(newNode.getRight()),node.getHeight())+1);
		
		return newNode;
	}
	
	/*根的左子树的右子树还有结点，导致不平衡，实现两次旋转，先将根的左子树逆时针旋转，形成LL形态(根的左子树的左子树还有节点，导致不平衡)
	 * 再顺时针旋转，得到平衡的树
	 * 返回值为旋转后的根节点
	 * */
	public Node LRRotation(Node node){
		node.setLeft(RRRotation(node.getLeft()));
		
		return LLRotation(node);
	}
	
	/*根的右子树的左子树还有结点，导致不平衡，实现两次旋转，先将根的右子树逆时针旋转，形成RR形态(根的右子树的右子树还有节点，导致不平衡)
	 * 再逆时针旋转，得到平衡的树
	 * 返回值为旋转后的根节点
	 * */
	public Node RLRotation(Node node){
		node.setRight(LLRotation(node.getRight()));
		
		return RRRotation(node);
	}
	
	
	//获取最大值
	private Node minimum(Node node){
		if(node ==null){
			return null;
		}
		while(node.getLeft()!=null){
			node=node.getLeft();
		}
		return node;
	}
	
	public T minimum() {
        Node p = minimum(root);
        if (p != null)
            return (T) p.getData();

        return null;
    }
	
	private Node maximum(Node node){
		if(node==null){
			return null;
		}
		while(node.getRight()!=null){
			node=node.getRight();
		}
		return node;
	}
	
	public T maximum() {
        Node p = maximum(root);
        if (p != null)
            return (T) p.getData();

        return null;
    }
	
	public Node delete(Node node,Node del){
		if(node==null || del==null){
			return null;
		}
	
		int cmp=((Comparable<T>) del.getData()).compareTo((T) node.getData());
		if(cmp<0){//若删除的点在左子树
			node.setLeft(delete(node.getLeft(),del));
			/*判断删除后的树是否平衡，不平衡则进行调整
			 * 因为删除了左子树的点，所以判断右子树-左子树是否依等于2，若等于2，则右子树大了，需要调整右子树
			 * */
			if(height(node.getRight())-height(node.getLeft())==2){
				Node r=node.getRight();
				if(height(r.getLeft())>height(r.getRight())){
					node=RLRotation(node);
				}else{
					node=RRRotation(node);
				}
			}
		}
		else if(cmp>0){//若删除的点在右子树
			node.setRight(delete(node.getRight(),del));
			/*判断删除后的树是否平衡，不平衡则进行调整
			 * 因为删除了右子树的点，所以判断左子树-右子树是否依等于2，若等于2，则左子树大了，需要调整左子树
			 * */
			if(height(node.getRight())-height(node.getLeft())==2){
				Node l=node.getLeft();
				if(height(l.getRight())>height(l.getLeft())){
					node=LRRotation(node);
				}else{
					node=LLRotation(node);
				}
			}
		}
		else{
			//node=del 删除的结点的左右孩子都非空  
			if ((node.getLeft()!=null) && (node.getRight()!=null)) {
				if (height(node.getLeft()) > height(node.getRight())) {
					// 如果node的左子树比右子树高；
					// 则(01)找出node的左子树中的最大节点
					//  (02)将该最大节点的值赋值给node。
					//   (03)删除该最大节点。
					// 这类似于用"node的左子树中最大节点"做"node"的替身；
					// 采用这种方式的好处是：删除"node的左子树中最大节点"之后，AVL树仍然是平衡的。 
					Node max=maximum(node.getLeft());
					node.setData(max.getData());
					node.setLeft(delete(node.getLeft(), max));
				} else {
		               // 如果node的左子树不比右子树高(即它们相等，或右子树比左子树高1)
		               // 则(01)找出node的右子树中的最小节点
		               //   (02)将该最小节点的值赋值给node。
	                //   (03)删除该最小节点。
	                // 这类似于用"node的右子树中最小节点"做"node"的替身；
	                // 采用这种方式的好处是：删除"node的右子树中最小节点"之后，AVL树仍然是平衡的。
	            	Node min=minimum(node.getRight());
					node.setData(min.getData());
	                node.setRight(delete(node.getRight(), min));
				}
			} else {//有一个左孩子或右孩子
		           Node tmp=node;
		           node=(node.getLeft()!=null)?node.getLeft():node.getRight();
		           tmp = null;
			}
		}
		
		return node;
	}
	
	public void remove(T data) {
	    Node del; 

	    if ((del = search(root, data)) != null)
	        root = delete(root,del);
	}

	private Node search(Node node, T data) {
		if(node ==null){
			return null;
		}else {
			int cmp=data.compareTo((T) node.getData());
			if(cmp<0){
				return search(node.getLeft(), data);
			}
			else if(cmp>0){
				return search(node.getRight(), data);
			}else{
				return node;
			}
		}
	}
	
	public void inOrder(Node node){
		if(node!=null){
			inOrder(node.getLeft());
			System.out.print(node.getData()+" ");
			inOrder(node.getRight());
		}
	}
	
	public void levelOrder(Node root){
		if(root==null) return;
	
		LinkedList<Node> queue=new LinkedList<>();
		queue.offer(root);//根节点入队
		Node current=null;
		while(!queue.isEmpty()){
			current=queue.poll();//将队头元素出队
			System.out.print(current.getData()+" ");
			if(current.getLeft()!=null){
				queue.offer(current.getLeft());
			}
			if(current.getRight()!=null){
				queue.offer(current.getRight());
			}
		}
	}
	
}
