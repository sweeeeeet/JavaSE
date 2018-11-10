public class ClassExam{
 
 public static void main(String[] args){
	ClassExam a=new ClassExam();
	// int a=3;
	// int b=4;
	// System.out.println(a);
	// System.out.println(b);
	// a=a^b;
	// b=a^b;
	// a=a^b;
	// System.out.println(a);
	// System.out.println(b);
	// System.out.println(a);
	// System.out.println(b);
	 // a=a+b;
	 // b=a-b;
	 // a=a-b;
	 
	 // System.out.println(a);
	// System.out.println(b);
	
	ClassExam.Switch(3,4);
}

public static void Switch(int a,int b){
	System.out.println(a);
	System.out.println(b);
	int temp;
	temp=a;
	a=b;
	b=temp;
	System.out.println(a);
	System.out.println(b);
}

}