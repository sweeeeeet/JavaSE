public class FinalTest{
	final float PI=3.14f;
	
	final int[] arrInt={1,2,3};
	final int num;//定义final常量，在构造方法中初始化
	final String str;//定义final常量，在构造块中初始化
	{
		str="final修饰的常量要在声明时或构造方法或构造块中初始化";
		
	}
	public FinalTest(){
		num=10;
	}
	public static void main(String[] args){
		FinalTest fin=new FinalTest();
		System.out.println("final float PI"+fin.PI);
		System.out.println("final int num"+fin.num);
		System.out.println("final String str"+fin.str);
	}
}