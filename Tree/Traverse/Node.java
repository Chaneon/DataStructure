package traverse;

public class Node<T> {
	private T data;
	private Node lchild;
	private Node rchild;
	
	public Node(T data) {
		this.data = data;
		lchild=null;
		rchild=null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node getLchild() {
		return lchild;
	}

	public void setLchild(Node lchild) {
		this.lchild = lchild;
	}

	public Node getRchild() {
		return rchild;
	}

	public void setRchild(Node rchild) {
		this.rchild = rchild;
	}
	
}
