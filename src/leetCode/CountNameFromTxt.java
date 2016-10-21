package leetCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * ���������µ��ı��ļ��ж�ȡ�����е�����������ӡ���ظ����������ظ������������ظ���������
 * 1��������28
 * 2�����ģ�35
 * 3��������28
 * 4�����壬35
 * 5��������28
 * 6�����ģ�35
 * 7��������28
 * 8�����ߣ�35
 * @author chenti
 *
 */

public class CountNameFromTxt {

	public static void main(String[] args) throws IOException {
		File nameFile = new File("F:/java/eclipse-workspace/LeetCode/testData/name.txt");
		FileInputStream fileInputStream = new FileInputStream(nameFile);
		
//		InputStream inputStream = CountNameFromTxt.class.getResourceAsStream("leetCode/name.txt");
		System.out.println(fileInputStream == null?"null":"not null");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		Map<String,Integer> results = new HashMap<>(); 
		String line = null;
		while((line = bufferedReader.readLine()) != null){
			handleLine(line,results);
		}
		sortResults(results);
	}

	static class User{
		public String name;
		public Integer value;
		public User(String name,Integer value) {
			this.name = name;
			this.value = value;
		}
		
		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}
	}
	
	private static void sortResults(Map<String, Integer> results) {
		
		/**
		 * ���compare���ؽ��0������Ϊ����������ȣ��µĶ��󲻻����ӵ�������ȥ
		 */
		TreeSet sortedResults = new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				User use1 = (User) o1;
				User use2 = (User) o2;
				if(use1.value < use2.value){
					return -1;
				}else if (use1.value > use2.value) {
					return 1;
				}else {
					return use1.name.compareTo(use2.name);
				}
			}
		});
		Iterator iterator = results.keySet().iterator();
		while (iterator.hasNext()) {
			String name = (String) iterator.next();
			Integer value = results.get(name);
			if(value >= 1){
				sortedResults.add(new User(name, value));
			}
		}
		printResults(sortedResults);
	}

	private static void printResults(TreeSet sortedResults) {
		Iterator<User> iterator = sortedResults.iterator();
		while(iterator.hasNext()){
			User user = iterator.next();
			System.out.println(user.name+":"+user.value);
		}
	}

	private static void handleLine(String line, Map<String, Integer> results) {
		if((line = line.trim()).length()>0){
			String[] temp = line.split(",");
			if(temp.length == 3){
				String name = temp[1];
				Integer value = results.get(name);
				if(value == null){
					value = 0;
				}
				results.put(name, value+1);
			}
		}
	}

}
