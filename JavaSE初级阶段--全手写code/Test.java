public class Test {


public static void main(String args[]){
	Demo d1= new Demo();
	System.out.println("[MAIN]方法"+d1);
	d1.print();
	System.out.println("===================================");
	Demo d2=new Demo();
	System.out.println("[MAIN]方法"+d2);
	d2.print();
}

}

class Demo{
	public void print(){		
		System.out.println("Demo类的[PRINT]方法"+this);
	}
	
}