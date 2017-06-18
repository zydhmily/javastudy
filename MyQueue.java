import java.util.*;

public class MyQueue{
	//定义一个存储元素的链表
	private LinkedList list = new LinkedList();
    //向队列中放入元素
	public void put(Object o){
	    list.addLast(o);
	}
    //从队列取得元素
	public Object get(){
        return list.removeFirst();
	}
    //检查队列是否为空
	public boolean isEmpty(){
        return list.isEmpty();
	}
}