package EventListenerDemo;

import java.util.EventListener;

/**
 * 事件监听器类，包含了事件被触发时的响应函数
 * 注册在事件源上,当事件源触发事件时,取得相应的监听器调用其内部的回调方法
 * @author chenti
 *
 */
public interface MyEventListener extends EventListener {
	
	void eventHandler(MyEventObject myEventObject);

}
