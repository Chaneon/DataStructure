package huffmanCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * 赫夫曼编码(huffman codes)是一种非常有用的数据压缩方法，无损压缩。
 * */
public class main {

	public static void main(String[] args) {
		//输入字符串，计算字符串中每个字符的出现次数，把次数赋值给权重  aaaaaaabcccccdddeeeeeeff
		System.out.println("输入字符串：");
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		Map<String,Integer> node=new HashMap<>();
		for(int i=0;i<str.length();i++){
			String key=str.valueOf(str.charAt(i));
			if(!node.containsKey(key)){
				node.put(key, 1);
			}
			else{
				int val=node.get(key);
				node.put(key, val+1);
			}
		}	
		
		Huffman huff=new Huffman();
		List<Node> nodes=new LinkedList<>();
		
		for(String key:node.keySet()){
			nodes.add(new Node(key,node.get(key)));
		}
		
//		nodes.add(new Node("a",7));
//		nodes.add(new Node("b",1));
//		nodes.add(new Node("c",5));
//		nodes.add(new Node("d",3));
//		nodes.add(new Node("e",6));
//		nodes.add(new Node("f",2));
		
		//创建赫夫曼树
		huff.creatHuffman(nodes);
		//赫夫曼编码
		Map<String,String> map=huff.HuffmanCode();		
//		for(String key:map.keySet()){
//			System.out.println(key+"的编码:"+map.get(key));
//		}
		

		System.out.println("压缩后的数据为：");
		String codes="";
		for(int i=0;i<str.length();i++){
			if(map.containsKey(str.valueOf(str.charAt(i)))){
				codes=codes+map.get(str.valueOf(str.charAt(i)));
			}
		}
		System.out.println(codes);
		
		
		huff.decode(codes);
	}
	
}
