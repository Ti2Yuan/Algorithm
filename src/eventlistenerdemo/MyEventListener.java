package eventlistenerdemo;

import java.util.EventListener;

/**
 * �¼��������࣬�������¼�������ʱ����Ӧ����
 * ע�����¼�Դ��,���¼�Դ�����¼�ʱ,ȡ����Ӧ�ļ������������ڲ��Ļص�����
 *
 */
public interface MyEventListener extends EventListener {
	
	void eventHandler(MyEventObject myEventObject);

}
