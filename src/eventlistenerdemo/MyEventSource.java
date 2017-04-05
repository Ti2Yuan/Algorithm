package eventlistenerdemo;

import java.util.Enumeration;
import java.util.Vector;

/**
 * �¼�Դ�࣬����һ���¼��������б��¼������ĵط�
 *
 */
public class MyEventSource {

	private Vector listenerRepository = new Vector();
	private MyEventListener myEventListener;
    private String name = "";
	
	//��Ӽ�����
	public void addEventListener(MyEventListener myEventListener){
		listenerRepository.addElement(myEventListener);
	}
	
	//ɾ��������
	public void removeEventListener(MyEventListener myEventListener){
		listenerRepository.remove(myEventListener);
	}
	
	//���������
	public void notifyEventListener(MyEventObject myEventObject){
		Enumeration enumeration = listenerRepository.elements();
		while(enumeration.hasMoreElements()){
			myEventListener = (MyEventListener) enumeration.nextElement();
			myEventListener.eventHandler(myEventObject);
		}
	}
	
	//��������
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
