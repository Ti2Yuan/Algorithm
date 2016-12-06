package leetcode;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * ��a.txt�ļ��еĵ�����b.txt�ļ��еĵ��ʽ���ϲ���c.txt�ļ���
 *  a.txt�ļ��еĵ����ûس����ָ�
 *   b.txt�ļ��ĵ����ûس������߿ո�ָ�
 * @author chenti
 *
 */

public class TextMerge {

	public static void main(String[] args) throws Exception{

		FileManager a = new FileManager("testData/a.txt", new char[]{'\n'});
		FileManager b = new FileManager("testData/b.txt", new char[]{'\n',' '});
		FileWriter c = new FileWriter("testData/c.txt");
		String aWord = null;
		String bWord = null;
		while((aWord = a.nextWord()) != null){
			c.write(aWord+"\n");
			System.out.println(aWord);
			bWord = b.nextWord();
			c.write(bWord+"\n");
			System.out.println(bWord);
		}
		while((bWord = b.nextWord()) != null){
			c.write(bWord+"\n");
			System.out.println(bWord);
		}
		c.close();
	}

	/**
	 * �����ļ����ȣ���ȡ�ļ����ַ����飬���ַ�����ת��Ϊ�ַ�����Ȼ���÷ָ���split
	 * @author chenti
	 *
	 */
	
	static class FileManager {
		String[] words = null;
		int pos = 0;

		public FileManager(String fileName, char[] seperators) throws Exception {
			File f = new File(fileName);
			FileReader reader = new FileReader(f);
			System.out.println("f.length is "+f.length());
			char[] buf = new char[(int) f.length()];
			int len = reader.read(buf);
			System.out.println("reader.read() length is "+len);
			String results = new String(buf, 0, len);
			System.out.println(results);
			String regex = null;
			if (seperators.length > 1) {
				regex = "" + seperators[0] + "|" + seperators[1];
			} else {
				regex = "" + seperators[0];
			}
			System.out.println(regex);
			words = results.split(regex);
			System.out.println("Words: ");
			for(String word:words){
				System.out.print(word+" ");
			}
			System.out.println();
		}
		
		public String nextWord(){
			if(pos == words.length){
				return null;
			}
			return words[pos++];
		}
	}
}
