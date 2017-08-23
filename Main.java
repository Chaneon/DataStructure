package mid;
/*一个单链表，在未知长度的情况下获取其中间值
 * 思路：两个查找指针 fast和mid，fast的速度是mid的两倍，当fast比哪里玩列表时，mid所在的位置正是链表的中间位置
 * 缩短的时间，提高效率，时间复杂度为O(n/2)
 * 
 * */
public class main {

	public static void main(String[] args) {
		LinkList list=new LinkList();
		
		for(int i=0;i<10;i++){
			list.add(i*2);
		}
		list.print();
		
		System.out.println("中间元素值："+list.searchMid().data);
	}

}

    © 2017 GitHub, Inc.
    Terms
    Privac
