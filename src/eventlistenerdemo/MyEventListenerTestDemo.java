package eventlistenerdemo;


/**
 * ������ģʽ���¼�Դ�����¼��ķ�װ���������������¼�Դ�����¼��󣬼��������յ��¼�������Իص��¼��ķ���
 *
 */
public class MyEventListenerTestDemo implements MyEventListener{

	private MyEventSource myEventSource;
	
	public MyEventListenerTestDemo() {
		myEventSource = new MyEventSource();
		myEventSource.addEventListener(this);
		System.out.println("������������");
		try {
			Thread.sleep(3000);
			myEventSource.setName("change property,trigge event one");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		myEventSource.addEventListener(this);
		System.out.println("������������2");
		try {
			Thread.sleep(3000);
			myEventSource.setName("change property,trigge event two");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		myEventSource.addEventListener(this);
		System.out.println("������������3");
		try {
			Thread.sleep(3000);
			myEventSource.setName("change property,trigge event three");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		new MyEventListenerTestDemo();
	}

	@Override
	public void eventHandler(MyEventObject myEventObject) {
		myEventObject.eventHandler();
		System.out.println("handler");
	}

}
