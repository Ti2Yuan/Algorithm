package leetcode;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 把当前java目录下的所有.java文件复制到jad目录下，并将原来文件的扩展名从.java改成.jad
 * 
 * @author chenti
 *
 */
public class FilesCopy {

	public static void main(String[] args) throws Exception {
		File srcDir = new File("testData/java");
		if (!srcDir.exists() && srcDir.isDirectory()) {
			throw new Exception("directory is not exist!");
		}

		File[] files = srcDir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		System.out.println(files.length);
		/** this FileFilter can be used too */
		// new FileFilter() {
		//
		// @Override
		// public boolean accept(File pathname) {
		// return pathname.getName().endsWith(".java");
		// }
		// };

		File destDir = new File("testData/jad");
		if (!destDir.exists()) {
			destDir.mkdir();
		}

		for (File file : files) {
			FileInputStream fis = new FileInputStream(file);
			String fileName = file.getName().replaceAll("\\.java$", ".jad");
			FileOutputStream fos = new FileOutputStream(new File(destDir, fileName));

			copy(fis, fos);

			fis.close();
			fos.close();
		}
	}

	// method 1 using java io
	private static void copy(FileInputStream fis, FileOutputStream fos) throws Exception {
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = fis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
	}

	// method 2 using java nio
	//运用java 7新特性TWR（try-with-resource）不用手动关闭资源，自动关闭
	public static void fileCopyNIO(String source, String target) throws IOException {
		try (FileInputStream in = new FileInputStream(source)) {
			try (FileOutputStream out = new FileOutputStream(target)) {
				FileChannel inChannel = in.getChannel();
				FileChannel outChannel = out.getChannel();
				ByteBuffer buffer = ByteBuffer.allocate(4096);
				while (inChannel.read(buffer) != -1) {
					buffer.flip();
					outChannel.write(buffer);
					buffer.clear();
				}
			}
		}
	}
}
