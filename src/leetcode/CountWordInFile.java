/**
 * 
 */
package leetcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 写一个方法，输入一个文件名和一个字符串，统计这个字符串在这个文件中出现的次数。
 */
public class CountWordInFile {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 统计给定文件中给定字符串的出现次数
	 * TODO
	 * @param fileName
	 * @param word
	 * @return
	 * int
	 */
	public static int countWordInFile(String fileName, String word){
		int counter = 0;
		try(FileReader fr = new FileReader(fileName)){
			try(BufferedReader br = new BufferedReader(fr)){
				String line = null;
				while((line = br.readLine()) != null){
					int index = -1;
					while(line.length() >= word.length() && (index = line.indexOf(word)) >= 0){
						counter++;
						line = line.substring(index+word.length());
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return counter;
	}
	
	/**
	 * 只要求列出当前文件夹下的文件
	 *
	 * TODO
	 * @param dir
	 * void
	 */
	public static void fileListOfDirectory(String dir){
		File[] files = new File(dir).listFiles();
		for (File file : files) {
			if(file.isFile()){
				System.out.println(file.getName());
			}
		}
	}
	
	/**
	 * 如果需要对文件夹继续展开
	 * TODO
	 * @param f
	 * @param level
	 * void
	 */
	public static void walkDirectory(File f,int level){
		if(f.isDirectory()){
			for(File temp:f.listFiles()){
				walkDirectory(temp, level+1);
			}
		}else {
			for(int i = 0;i<level-1;i++){
				System.out.println("\t");
			}
		    System.out.println(f.getName());
		}
	}
	
	/**
	 * 利用Java 7的NIO中的API来做同样的事情
	 * TODO
	 * @param path
	 * void
	 * @throws IOException 
	 */
	public static void fileListOfDir(String path) throws IOException{
		Path initPath = Paths.get(path);
		Files.walkFileTree(initPath, new SimpleFileVisitor<Path>(){

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file.getFileName().toString());
				return FileVisitResult.CONTINUE;
			}
			
		});
	}

}
