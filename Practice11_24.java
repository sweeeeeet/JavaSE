public class Practice11_24{
	
	public static void main(String[] args){
		// Outer.Inner ine=new Outer.Inner();
		// ine.print();
		
		Outer out=new Outer();
		out.display(15);
	}
	
	
}
// class Outer{
	// private static String msg="hello world";
	
	// static class Inner{
	// public void print(){
		// System.out.println(msg);
	// }
	// }
	// public void fun(){
		// Inner in=new Inner();
		// in.print();
	// }
// }
// class Outer{
	// private int num;
	// public void display(int test){
		// class Inner{
			// private void fun(){
				// num++;
				// System.out.println(num);
				// System.out.println(test);
			// }
		// }
		// new Inner().fun();
	// }
// }
// interface MyInterface{
	// void test();
// }
// class Outer{
	// private int num;
	// public void display(int test){
		// new MyInterface(){
			// public void test(){
				
				// System.out.println("这是通过实现接口的匿名内部类");
			// }
		// }.test();
		// System.out.println(num);
		// System.out.println(test);
	// }
// }


