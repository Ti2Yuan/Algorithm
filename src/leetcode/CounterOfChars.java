package leetcode;

/**
 * 统计一串字符如"aaaabbc中国1512"中英文字符、数字字符、中文字符的数量
 * 假设字符串无其他字符出现
 * @author chenti
 *
 */
public class CounterOfChars {

	public static void main(String[] args) {
		int englishCount = 0;
		int chineseCount = 0;
		int digitCount = 0;
		String str = "aaaabbc中国1512";
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
		System.out.println("英文字符有"+englishCount+"个");
		System.out.println("数字字符有"+digitCount+"个");
		System.out.println("中文字符有"+chineseCount+"个");
	}

}
