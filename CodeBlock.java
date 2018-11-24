public class CodeBlock extends A{
	public CodeBlock(){
	System.out.println("7.B类的构造方法");
	}
	{
	System.out.println("6.B类的构造块");
}
static{
	System.out.println("2.B类的静态块");
}
public static void main(String[] args){
	System.out.println("3.Start:");
	new CodeBlock();
	System.out.println("8.end");
}

}
class A{
	public A(){
	System.out.println("5.A类的构造方法");
}
{
	System.out.println("4.A类的构造块");
}
static{
	System.out.println("1.A类的静态块");
}
}
