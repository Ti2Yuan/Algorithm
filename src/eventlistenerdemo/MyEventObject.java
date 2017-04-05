package eventlistenerdemo;

import java.util.EventObject;

/**
 * �¼��࣬�����¼�Դ�ķ�װ
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
	 * �¼�������
	 */
	public void eventHandler(){
		System.out.println(object);
		System.out.println("event "+name+" handle method");
	}
	
	public String getName(){
		return name;
	}

}
