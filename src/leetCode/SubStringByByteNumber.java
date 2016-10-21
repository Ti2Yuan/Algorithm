package leetCode;

import java.io.UnsupportedEncodingException;

/**
 *��дһ����ȡ�ַ����ĺ���
 *input a string and a number of bytes����һ���ַ�����һ���ֽ���
 *output a subString according to the number of bytes���Ϊ���ֽڽ�ȡ���ַ���
 *guarantee that the Chinese character is not intercepted a half��֤���ֲ�����ȡ���
 *��"��ABC",4 ����ȡΪ"��AB" ..."��ABC��DEF"��6����ȡ"��ABC"��������"��ABC+�����" 
 * @author chenti
 *
 */

public class SubStringByByteNumber {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str="��a���л�abc�Ұ�����def";
//		String str="��ABC��";
		int num=trimGBK(str.getBytes("GBK"),4);
		System.out.println(str.substring(0, num));
	}

	private static int trimGBK(byte[] bytes, int n) {
		int num=0;
		boolean bChineseFirstHalf=false;
		for(int i=0;i<bytes.length;i++){
			System.out.print(bytes[i]+"  ");
		}
		System.out.println();
		for(int i=0;i<n;i++){
			if(bytes[i]<0 && !bChineseFirstHalf){
				bChineseFirstHalf=true;
			}else {
				num++;
				bChineseFirstHalf=false;
			}
		}
		return num;
	}

}
