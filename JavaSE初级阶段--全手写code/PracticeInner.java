class Outer{
private String str="hello";
//实例内部类
class Inner{
	public void print(){
		System.out.println(str);
	}
	
}
public void print(){
	new Inner().print();
}
}
 public class PracticeInner{
	 public static void main(String[] args){
		//调用Outer类中的普通方法
		new Outer().print();
	 }
 }