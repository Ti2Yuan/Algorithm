package leetCode;

/**
 * ��java�����У����Ե���String���intern()����������һ���ַ�����
 * ���������ϱ����ַ������ڽ���CONSTANT_String_info��ڵĹ����б������ˡ�
 * ���������ͬ���е�Unicode�ַ����Ѿ�����������intern()��������һ��ָ��������Ѿ����������ַ�����������á�
 * ���û�б������������������ͻᱻ����������ָ��ͬһ���ַ�����������á�
 * @author chenti
 *
 */
public class FunctionOfIntern {

	
	public static void main(String[] args) {
         String argZero = args[0];
         
         String literalString = "Hi!";
         
         System.out.println("before interning argZero:");
         
         if(argZero == literalString){
        	 System.out.println("they are the same string boject.");
         }else
         {
        	 System.out.println("they are not the same string boject.");
         }
         
         argZero = argZero.intern();
         System.out.println("after interning argZero:");
         if(argZero == literalString){
        	 System.out.println("they are the same string boject.");
         }else
         {
        	 System.out.println("they are not the same string boject.");
         }
	}

}
