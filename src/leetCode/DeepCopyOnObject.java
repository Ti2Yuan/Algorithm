package leetCode;
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
		
		Employee copy3 = e;
		
		e.setName("Demon");
		System.out.println(e.toString());
		System.out.println("clone method of deep copy: "+copy1.toString());
		System.out.println("byte copy method of deep copy: "+copy2.toString());
		System.out.println("shallow copy method: "+copy3.toString());
	}

	private static Employee deepCopy(Employee e) {
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

	public static class Employee implements Serializable,Cloneable {
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
		protected Object clone(){
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
