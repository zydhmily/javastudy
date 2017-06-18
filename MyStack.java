import java.util.*;

public class MyStack{
    private LinkedList list = new LinkedList();

	public void push(Object o){
        list.addLast(o);
	}

	public Object pop(){
	    return list.removeLast();
	}

	public Object peek(){
	    return list.getLast();
	}

	public boolean isEmpty(){
	    return list.isEmpty();
	}
}