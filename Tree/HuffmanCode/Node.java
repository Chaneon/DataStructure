package huffmanCode;

public class Node<T> implements Comparable<Node>{
	private T data;
	private int weight;
	private Node lchild;
	private Node rchild;
	private int code;
	private Node parent;
	
	
	public Node(T data,int weight) {
		this.data = data;
		this.weight=weight;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	@Override
	public int compareTo(Node o) {
		if(o.getWeight()>this.getWeight()){
			return 1;
		}
		if(o.getWeight()<this.getWeight()){
			return -1;
		}
		return 0;
	}
	
}
