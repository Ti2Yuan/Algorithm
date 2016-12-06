package leetcode;

/**
 * 在java程序中，可以调用String类的intern()方法来拘留一个字符串。
 * 所有字面上表达的字符串都在解析CONSTANT_String_info入口的过程中被拘留了。
 * 如果具有相同序列的Unicode字符串已经被拘留过，intern()方法返回一个指向相符的已经被拘留的字符串对象的引用。
 * 如果没有被拘留，那这个对象本身就会被拘留，返回指向同一个字符串对象的引用。
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
