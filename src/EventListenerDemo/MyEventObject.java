package EventListenerDemo;

import java.util.EventObject;

/**
 * 事件类，即是事件源的封装
 * @author chenti
 *
 */
public class MyEventObject extends EventObject {
	
	private Object object;
	private String name;

	public MyEventObject(Object source,String name) {
		super(source);
		object = source;
		this.name = name;
	}
	
	public Object getSource(){
		return object;
	}
	
	/**
	 * 事件处理方法
	 */
	public void eventHandler(){
		System.out.println(object);
		System.out.println("event "+name+" handle method");
	}
	
	public String getName(){
		return name;
	}

}
