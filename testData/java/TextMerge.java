package leetCode;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中 a.txt文件中的单词用回车符分隔 b.txt文件的单词用回车符或者空格分隔
 * 
 * @author chenti
 *
 */

public class TextMerge {

	public static void main(String[] args) throws Exception{

		FileManager a = new FileManager("a.txt", new char[]{'\n'});
		FileManager b = new FileManager("b.txt", new char[]{'\n',' '});
		FileWriter c = new FileWriter("c.txt");
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
	 * 根据文件长度，读取文件成字符数组，将字符数组转换为字符串，然后用分隔符split
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
