package AVLT;

/*AVL是严格的平衡树，因此在增加或者删除节点的时候，根据不同情况，旋转的次数比红黑树要多；
    红黑树是用非严格的平衡来换取增删节点时候旋转次数的降低开销；
    所以简单说，如果你的应用中，搜索的次数远远大于插入和删除，那么选择AVL树，
    如果搜索，插入删除次数几乎差不多，应选择红黑树。即，有时仅为了排序（建立-遍历-删除），不查找或查找次数很少，R-B树合算一些
 * 
 * */
public class Main {

	public static void main(String[] args) {
		AVLTree<Integer> avlTree=new AVLTree<>();
		Integer[] datas={34,20,50,11,6,55,44,78};
		
		for(int i=0;i<datas.length;i++){
			avlTree.add(datas[i]);
		}
		avlTree.inOrder(avlTree.root);
		System.out.println();
		
		avlTree.remove(11);
		avlTree.inOrder(avlTree.root);
		System.out.println();
	}

}
