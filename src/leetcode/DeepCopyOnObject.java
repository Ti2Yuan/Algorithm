package leetcode;

/**
 * deep copy object by 2 methods
 * 
 * method 1: rewrite clone() of class which implements Cloneable interface.
 * 
 * method 2: by stream 
 * 
 * 1. 实现Cloneable接口并重写Object类中的clone()方法；
 * 2. 实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆
 * 
 * 基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的对象是否支持序列化，
 * 这项检查是编译器完成的，不是在运行时抛出异常，这种是方案明显优于使用Object类的clone方法克隆对象。
 * 让问题在编译的时候暴露出来总是优于把问题留到运行时。
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepCopyOnObject {

	public static void main(String[] args) {
		Employee e = new Employee("Jack", 25);

		Employee copy1 = null;
		copy1 = (Employee) e.clone();
		copy1.setAge(30);

		Employee copy2 = deepCopy(e);
		copy2.setName("stedfen");
		Employee copy3 = e;
		copy3.setAge(70);

		e.setName("Demon");
		System.out.println(e.toString());
		System.out.println("clone method of deep copy: " + copy1.toString());
		System.out.println("byte copy method of deep copy: " + copy2.toString());
		System.out.println("shallow copy method: " + copy3.toString());
	}

	/**
	 * By Stream ObjectOutputStream -----> ByteArrayOutputStream
	 * ----->ByteArrayInputStream ---->ObjectInputStream
	 * 
	 * @param e
	 * @return
	 */
	private static Employee deepCopy(Employee e) {
		// 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
		// 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
		Employee copy = null;
		try {
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(byteOut);
			out.writeObject(e);

			ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			ObjectInputStream in = new ObjectInputStream(byteIn);
			copy = (Employee) in.readObject();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		return copy;
	}

	public static class Employee implements Serializable, Cloneable {
		private String name;
		private int age;

		public Employee(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		protected Object clone() {
			Employee clone = null;
			try {
				clone = (Employee) super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return clone;
		}

		@Override
		public String toString() {
			return name + "  " + age;
		}

	}

}
