import java.util.Scanner;
public class TestSubject{
private int[] goodsNum=new int[]{1,2,3,4,5,6,7,8,9,10};
private String[] productName=new String[10];
private double[] productPrice=new double[10];
public void input(){
	System.out.println("请输入上架商品信息（如下格式：1 餐巾纸 1.4）:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	String name=scan.next();
	double price=scan.nextDouble();
	productName[1]=name;
	productPrice[1]=price;		
		}
	public void print(){
			System.out.println(productName[1]+productPrice[1]);

	}	
	public static void main(String[] args){
		TestSubject t=new TestSubject();
		t.input();
		t.print();
	}
}