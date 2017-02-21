/**
 * 
 */
package com.chen.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 *
 */
public class EchoServerNIO {

	private static final int ECHO_SERVER_PORT = 6789;
	private static final int ECHO_SERVER_TIME = 5000;
	private static final int BUFFER_SIZE = 1024;
	
	private static ServerSocketChannel serverSocketChannel = null;
	private static Selector selector = null;  //多路复用选择器
	private static ByteBuffer byteBuffer = null;  //缓冲区
	
	public static void main(String[] args){
		init();
		listen();
	}
	
	private static void init(){
		try {			
			serverSocketChannel = ServerSocketChannel.open();
			byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);
			serverSocketChannel.socket().bind(new InetSocketAddress(ECHO_SERVER_PORT));
			serverSocketChannel.configureBlocking(false);
			selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	private static void listen(){
		while(true){
			try{				
				if(selector.select(ECHO_SERVER_TIME) != 0){
					Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
					while(iterator.hasNext()){
						SelectionKey key = iterator.next();
						iterator.remove(); //防止重复处理
						handleKey(key);
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	private static void handleKey(SelectionKey key){
		SocketChannel socketChannel = null;
		try {			
			if(key.isAcceptable()){
				ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
				socketChannel = serverSocketChannel.accept();
				socketChannel.configureBlocking(false);
				socketChannel.register(selector, SelectionKey.OP_READ);
			}else if (key.isReadable()) {
				socketChannel = (SocketChannel) key.channel();
				byteBuffer.clear();
				if(socketChannel.read(byteBuffer) > 0){
					byteBuffer.flip();
					CharBuffer charBuffer = CharsetHelper.decode(byteBuffer);
					String msg = charBuffer.toString();
					System.out.println("收到"+socketChannel.getRemoteAddress()+"的消息");
					socketChannel.write(CharsetHelper.encode(CharBuffer.wrap(msg)));
				}else {
					socketChannel.close();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(socketChannel != null){
				socketChannel = null;
			}
		}
	}
}
