package EventListenerDemo;


/**
 * 监听器模式：事件源经过事件的封装传给监听器，当事件源触发事件后，监听器接收到事件对象可以回调事件的方法
 * @author chenti
 *
 */
public class MyEventListenerTestDemo implements MyEventListener{

	private MyEventSource myEventSource;
	
	public MyEventListenerTestDemo() {
		myEventSource = new MyEventSource();
		myEventSource.addEventListener(this);
		System.out.println("监听器添加完毕");
		try {
			Thread.sleep(3000);
			myEventSource.setName("change property,trigge event one");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		myEventSource.addEventListener(this);
		System.out.println("监听器添加完毕2");
		try {
			Thread.sleep(3000);
			myEventSource.setName("change property,trigge event two");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		myEventSource.addEventListener(this);
		System.out.println("监听器添加完毕3");
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
