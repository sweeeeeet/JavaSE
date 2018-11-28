public class GuassNum{
	public void play(){
		Num numbers=new Num();
		System.out.println("猜数字游戏开始，请输入一个整数：");
		java.util.Scanner scan=new java.util.Scanner(System.in);
		while(true){
		int num=scan.nextInt();
		numbers.isNum(num);
		if(num==numbers.value){
			break;
			}
		}
	}
	public static void main(String[] args){
		GuassNum gauss=new GuassNum();
		gauss.play();
	}
	
}
class Num{
	java.util.Random random=new java.util.Random();
	int value=random.nextInt(100);//[0,100)
	public int isNum(int num){
		if(num==value){
			System.out.println("猜中啦，这个数字就是"+num);	
			
		}
		if(num>value){
			System.out.println("猜大啦！");
		}
		if(num<value){
			System.out.println("猜小啦！");
		}
		return num;
	}
}
