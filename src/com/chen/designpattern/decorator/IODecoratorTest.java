package com.chen.designpattern.decorator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PushbackInputStream;
import java.io.PushbackReader;

/**
 * IO��װ����ʹ�ã�����InputStream���൱��������Component�ӿڣ�ֻ����������һ�������࣬��������װ�ε�Ŀ������ࡣ
 * FileInputstream����һ��ConcreteComponent������װ�εľ������
 * ��������JAVA��IO�ṹ�е�һ��װ��������Ϊ���޷�װ��InputStream��
 * ʣ��BufferedInputStream��DataInputstream�ȵȾ��Ǹ���װ�����ˣ�
 * JAVA��IO��Ҳ�г����װ��������Ĵ��ڣ�ֻ������û�����ֳ���������FilterInputStream�����Ǻܶ�װ�����������װ�λ��ࡣ
 * 
 * ����dataInputStream�Ǿ�������װ�κ�õ��ģ�
 * ��������dataInputStream��bufferedInputStream��˫�ع��ܣ�
 * ���⣬InputStreamReader��һ�������װ���������ṩ���ֽ������ַ�������������ʵ�����˾���װ�������ص����⣬Ҳ�е���һ��������. 
 *
 */
public class IODecoratorTest {

	public static void main(String[] args) throws IOException {
		//�ļ�·�������и���
        final String filePath = "D:/Ti/eclipse-workspace/LeetCode/src/test.txt";
        
        //InputStream�൱�ڱ�װ�εĽӿڻ��߳����࣬FileInputStream�൱��ԭʼ�Ĵ�װ�εĶ���FileInputStream�޷�װ��InputStream
        //����FileInputStream����ֻ����ʽ����һ���ļ�,������һ���ļ��ľ�������FileDescriptor�����handle����
        //���������йػ��˺����±�ǵȲ����������ڶ��н�������������ɵļ���,�������������ļ����ڻ��˻������±��
        InputStream inputStream = new FileInputStream(filePath);
        final int len = inputStream.available();//��¼һ�����ĳ���
        System.out.println("FileInputStream��֧��mark��reset��" + inputStream.markSupported());
        
        System.out.println("---------------------------------------------------------------------------------");
        
        /* ����ֱ�չʾ����װ����������BufferedInputStream,DataInputStream,PushbackInputStream,LZ������������װ�����Ĺ�����ʾ  */
        
        //����װ�γ�BufferedInputStream�����ṩ����mark��reset�Ĺ���
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);//װ�γ� BufferedInputStream
        System.out.println("BufferedInputStream֧��mark��reset��" + bufferedInputStream.markSupported());
        bufferedInputStream.mark(0);//���һ��
        char c = (char) bufferedInputStream.read();
        System.out.println("LZ�ļ��ĵ�һ���ַ���" + c);
        bufferedInputStream.reset();//����
        c = (char) bufferedInputStream.read();//�ٶ�
        System.out.println("�����Ժ��ٶ�һ���ַ�����Ȼ���ǵ�һ���ַ�:" + c);
        bufferedInputStream.reset();
        
        System.out.println("---------------------------------------------------------------------------------");
        
        //װ�γ� DataInputStream,����Ϊ����ʹ��DataInputStream,��ʹ��BufferedInputStream��mark reset���ܣ����������ٽ���һ���װ
        //ע�⣬���������ʹ��BufferedInputStream����ʹ��ԭʼ��InputStream��read�������صĽ������-1�����Ѿ���ȡ����
        //��ΪBufferedInputStream�Ѿ����ı������ݶ�ȡ��ϣ������嵽���ϣ�Ĭ�ϵĳ�ʼ��������С��8192B
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        dataInputStream.reset();//����BufferedInputStream�ṩ�Ĺ��ܣ����������������ϰ�װ�����
        System.out.println("DataInputStream���ھ���readInt��readChar,readUTF�ȹ���");
        int value = dataInputStream.readInt();//������һ��int,�����ĸ��ֽ�
        //����ת�����ַ�������ʾ���������Կ���LZ�ļ���ǰ�ĸ��ַ�
        String binary = Integer.toBinaryString(value);
        int first = binary.length() % 8;
        System.out.print("ʹ��readInt��ȡ��ǰ�ĸ��ַ���");
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                System.out.print(((char)Integer.valueOf(binary.substring(0, first), 2).intValue()));
            }else {
                System.out.print(((char)Integer.valueOf(binary.substring(( i - 1 ) * 8 + first, i * 8 + first), 2).intValue()));
            }
        }
        System.out.println();
        
        System.out.println("---------------------------------------------------------------------------------");
        
        //PushbackInputStream�޷���װBufferedInputStream֧��mark reset����Ϊ��������reset��mark����
        //��Ϊ���Ѿ�����ȡ��ĩβ���������Ǳ������´�һ���ļ��ľ������FileInputStream
        inputStream = new FileInputStream(filePath);
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream,len);//װ�γ� PushbackInputStream
        System.out.println("PushbackInputStreamװ���Ժ�֧���˻ز���unread");
        byte[] bytes = new byte[len];
        pushbackInputStream.read(bytes);//������������
        System.out.println("unread����ǰ�����ݣ�" + new String(bytes));
        pushbackInputStream.unread(bytes);//���˻�ȥ
        bytes = new byte[len];//���byte����
        pushbackInputStream.read(bytes);//�ٶ�
        System.out.println("unread���˺�����ݣ�" + new String(bytes));
        
        System.out.println("---------------------------------------------------------------------------------");
        
        /*  ����������һ��װ�κ�һ������װ��,����������װ�γ�Reader���ٽ�������װ��   */
        
        //����֮ǰ��PushbackInputStream������ȡ��ĩβ��������Ҫ�ٴ����´��ļ����
        inputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");//��װ�γ�InputStreamReader
        System.out.println("InputStreamReader��reader�Ĺ��ܣ�����ת�룺" + inputStreamReader.getEncoding());
        
        System.out.println("---------------------------------------------------------------------------------");
        
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//���ǽ�һ����reader�Ļ�����װ�γ�BufferedReader
        System.out.println("BufferedReader��readLine�ȹ��ܣ�" + bufferedReader.readLine());
        
        System.out.println("---------------------------------------------------------------------------------");
        
        LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);//���ǽ�һ����reader�Ļ�����װ�γ�LineNumberReader
        System.out.println("LineNumberReader�������кţ���ȡ�кŵȹ��ܣ��кŴ�0��ʼ��,��ǰ�кţ�" + lineNumberReader.getLineNumber());
        
        System.out.println("---------------------------------------------------------------------------------");
        
        //�˴����ڸղű�readLine����������ȡ��ĩβ,���������ٴ����´��ļ����,����Ҫ��inputstream�ٴΰ�װ��reader
        inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        PushbackReader pushbackReader = new PushbackReader(inputStreamReader,len);//���ǽ�һ����reader�Ļ�����װ�γ�PushbackReader
        System.out.println("PushbackReader��ӵ���˻ز�����reader����");
        char[] chars = new char[len];
        pushbackReader.read(chars);
        System.out.println("unread����ǰ�����ݣ�" + new String(chars));
        pushbackReader.unread(chars);//���˻�ȥ
        chars = new char[len];//���char����
        pushbackReader.read(chars);//�ٶ�
        System.out.println("unread���˺�����ݣ�" + new String(chars));
    }

}
