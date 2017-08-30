package huffmanCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Huffman<T> {
	static Node root;
	
	public  void creatHuffman(List<Node> nodes){
		while(nodes.size()>1){
			//根据结点权值排序 这里是从大到小排序
			Collections.sort(nodes);
			//取出最小值跟倒数第二小的值
			Node left=nodes.get(nodes.size()-1);
			Node right=nodes.get(nodes.size()-2);
			//将其相加得到其父节点
			Node parent=new Node(null, left.getWeight()+right.getWeight());
			
			parent.setLchild(left);
			parent.setRchild(right);
			left.setParent(parent);
			left.setCode(0);
			right.setParent(parent);
			right.setCode(1);
			//删除已找过的结点，添加其父节点，不断重复，直到list的结点只剩一个，那就是根节点
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		root=nodes.get(0);
	} 
	
	//添加赫夫曼树的结点进list
	private List findlist(Node root){
		if(root==null) return null;
	
		LinkedList<Node> queue=new LinkedList<>();
		List<Node> list=new ArrayList<>();
		
		queue.offer(root);
		Node current=null;
		
		while(!queue.isEmpty()){
			list.add(queue.peek());
			
			current=queue.poll();//将队头元素出队
			
			if(current.getLchild()!=null){
				queue.offer(current.getLchild());
			}
			if(current.getRchild()!=null){
				queue.offer(current.getRchild());
			}
		}
		return list;
	}
	
	public Map HuffmanCode(){
		//将赫夫曼树的所有结点一一导出，只要data值不为null则为叶子结点
		List<Node> list=findlist(root);
		//用map记录不同结点的前缀码
		Map<String,String> map=new HashMap<>();
		for(int i=list.size()-1;i>=0;i--){
			if(list.get(i).getData()!=null){
				String code=encode(list.get(i));
				map.put((String) list.get(i).getData(), code);
			}
		}
		return map;
	}
	
	//赫夫曼编码就是根据叶子结点往上找出其父节点，知道找到根节点为止，记录往上查找中的code值
	private String encode(Node node){
		String code="";
		String codes="";
		while(node!=this.root){
			code=code+node.getCode();
			node=node.getParent();
		}
		//由于往上查找记录code值，而赫夫曼编码是从根节点读到叶子结点，现在是从叶子结点读到根节点，因此把读code反转即为正确的赫夫曼编码
		for(int i=code.length()-1;i>=0;i--){
			codes=codes+code.charAt(i);
		}
		return codes;
	}
	
	//译码
	public void decode(String str){
		if(root==null) return;
		
		Node node=root;
		String decode="";
		
		for(int i=0;i<str.length();i++){
			//当字符为0的时候，找左子树，为1的时候找右子树
			if(str.valueOf(str.charAt(i)).equals("0")){
				node=node.getLchild();
				//当结点值不为空的时候代表已经找到叶子结点，读出该叶子结点的值，再从根节点重新找下一个值
				if(node.getData()!=null){
					decode=decode+node.getData();
					node=root;
				}
				
			}
			else{
				node=node.getRchild();
	
				if(node.getData()!=null){
					decode=decode+node.getData();
					node=root;
				}
			}
		}
		
		System.out.print("译码为：");
		System.out.println(decode);
	}
	
	
}
