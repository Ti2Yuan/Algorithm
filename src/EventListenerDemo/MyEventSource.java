package EventListenerDemo;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 事件源类，包含一个事件监听器列表，事件触发的地方
 * @author chenti
 *
 */
public class MyEventSource {

	private Vector listenerRepository = new Vector();
	private MyEventListener myEventListener;
    private String name = "";
	
	//添加监听器
	public void addEventListener(MyEventListener myEventListener){
		listenerRepository.addElement(myEventListener);
	}
	
	//删除监听器
	public void removeEventListener(MyEventListener myEventListener){
		listenerRepository.remove(myEventListener);
	}
	
	//激活监听器
	public void notifyEventListener(MyEventObject myEventObject){
		Enumeration enumeration = listenerRepository.elements();
		while(enumeration.hasMoreElements()){
			myEventListener = (MyEventListener) enumeration.nextElement();
			myEventListener.eventHandler(myEventObject);
		}
	}
	
	//设置属性
	public void setName (String str){
		boolean isChanged = false;
		
		if(str == null && name != null){
			isChanged = true;
		}else if(str != null && name == null){
			isChanged = true;
		}else if(!name.equals(str)){
			isChanged = true;
		}
		
		this.name = str;
		if(isChanged)
			notifyEventListener(new MyEventObject(this, name));
	}
}
