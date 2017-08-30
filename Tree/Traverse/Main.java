package traverse;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BiTree binTree=new BiTree();
		System.out.println("请输入数据：");
		/*  例如：asd#g###j#k##
			先序遍历：asdgjk
			中序遍历：dgsajk
			后序遍历：gdskja
		*/
		binTree.built();
		System.out.print("先序遍历：");
		binTree.preOrder(binTree.root);
		System.out.println();
		System.out.print("中序遍历：");
		binTree.inOrder(binTree.root);
		System.out.println();
		System.out.print("后序遍历：");
		binTree.postOrder(binTree.root);
		System.out.println();
		
		System.out.print("非递归先序遍历：");
		binTree.preOder2(binTree.root);
		System.out.println();
		System.out.print("非递归中序遍历：");
		binTree.inOrder2(binTree.root);
		System.out.println();
		System.out.print("非递归后序遍历：");
		binTree.postOrder2(binTree.root);
		System.out.println();
		
		System.out.print("层次遍历：");
		binTree.levelOrder(binTree.root);
		System.out.println();
		
	}

}
