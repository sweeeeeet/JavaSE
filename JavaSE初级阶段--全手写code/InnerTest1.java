

// public class InnerTest1{
	// public static void main(String[] args){
		// Outer out=new Outer();
		// out.test();
	// }
// }


class Outer{
	private String str="Outer中的字符串";
	//-------------------------------------------
	class Inner{
		private String inner="Inner中的字符串";
		public void fun(){
			System.out.println(str);
		}
	}
	//-----------------------------------------
	public  static void test(){
		Outer.Inner in=new Outer().new Inner();
		in.fun();
	}
}
public class InnerTest1{
	public static void main(String[] args){
		Outer out=new  Outer();
		out.test();
	}
}


class A{
	private String msg="test";
	public String getMsg(){
		return msg;
	}
}
class B{
	private int age=18;
	public int getAge(){
		return age;
	}
}
class C{
	//------------
	class InnerA extends A{
		public String name(){
			return super.getMsg();
		}
	}
	//---------
	class InnerB extends B{
		public int age(){
			return super.getAge();
		}
	}
	//---------
	public String name(){
		return new InnerA().name();
	}
	public int  age(){
		return new InnerB().age();
	}
}
// public class InnerTest1{
	// public static void main(String[] args){
		// C c=new C();
		// System.out.println(c.name());
		// System.out.println(c.age());
		
	// }
// }