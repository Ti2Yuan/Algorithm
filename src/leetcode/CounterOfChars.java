package leetcode;

/**
 * ͳ��һ���ַ���"aaaabbc�й�1512"��Ӣ���ַ��������ַ��������ַ�������
 * �����ַ����������ַ�����
 * @author chenti
 *
 */
public class CounterOfChars {

	public static void main(String[] args) {
		int englishCount = 0;
		int chineseCount = 0;
		int digitCount = 0;
		String str = "aaaabbc�й�1512";
		for(int i =0,len = str.length();i<len;i++){
			char c = str.charAt(i);
			if(c >='0' && c <= '9'){
				digitCount++;
			}else if((c >= 'a' && c<= 'z') || (c >= 'A' && c <= 'Z')){
				englishCount++;
			}else {
				chineseCount++;
			}
		}
		System.out.println("Ӣ���ַ���"+englishCount+"��");
		System.out.println("�����ַ���"+digitCount+"��");
		System.out.println("�����ַ���"+chineseCount+"��");
	}

}
