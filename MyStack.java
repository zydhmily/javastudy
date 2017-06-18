import java.util.*;

public class MyStack{
	//定义一个存储元素的链表
    private LinkedList list = new LinkedList();
    //向栈内放入元素
	public void push(Object o){
        list.addLast(o);
	}
    //从栈中取得元素
	public Object pop(){
	    return list.removeLast();
	}
    //检查栈中最后元素
	public Object peek(){
	    return list.getLast();
	}
    //检查栈是否为空
	public boolean isEmpty(){
	    return list.isEmpty();
	}
}