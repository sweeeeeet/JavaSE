public class SimpleFactoryPattern{
	
	public void buy(Computer com){
		com.printComputer();
	}

	public static void main(String[] args){
		/*
		System.out.println("请输入你想要的笔记本品牌:mac/ASUS/Alienware");
		java.util.Scanner scan=new java.util.Scanner(System.in);
		String type=scan.nextLine();
		Client client=new Client();
		ComputerFactory computer=new ComputerFactory();
		client.buy(computer.getInstance(type));
		//client.buy(ComputerFactory.getInstance(type));
		*/
		SimpleFactoryPattern client=new SimpleFactoryPattern();
		ComputerFactory computer=new ComputerFactory();
		String type=args[0];		
		if(args.length==0){
			System.out.println("需传入参数,输入你需要的电脑型号:mac/ASUS/Alienware");
		}
		else {
				
			client.buy(ComputerFactory.getInstance(type));
		}
		
	}
}
interface Computer{
	void printComputer();
}
class MacComputer implements Computer{
	public void printComputer(){
		System.out.println("这是一台mac电脑");
	}
}
class AsusComputer implements Computer{
	public void printComputer(){
		System.out.println("这是一台华硕ASUS电脑");
	}
}
class AlienwareComputer implements Computer{
	public void printComputer(){
		System.out.println("这是一台华硕Alienware电脑");
	}
}

class ComputerFactory{
	public static Computer getInstance(String type){
		Computer computer=null;
		switch (type){
			case "mac":
			computer=new MacComputer();
			break;
			case "ASUS":
			computer=new AsusComputer();
			break;
			case "Alienware":
			computer=new AlienwareComputer();
			break;
			default:
			System.out.println("暂时没有此类笔记本工厂");
		}
		return computer;
	}
}