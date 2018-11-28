public class FactoryMethod{
	public void buy(Computer com){
		com.printComputer();
	}
	
	public static void main(String[] args){
		ComputerFactory computer=new MacComputerFactory();
		FactoryMethod client =new FactoryMethod();
		client.buy(computer.getInstance());
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

interface ComputerFactory{
	Computer getInstance();
}

class MacComputerFactory implements ComputerFactory{
	public Computer getInstance(){
		return new MacComputer();
	}
}
class AsusComputerFactory implements ComputerFactory{
	public Computer getInstance(){
		return new AsusComputer();
	}
}
class AlienwareComputerFactory implements ComputerFactory{
	public Computer getInstance(){
		return new AlienwareComputer();
	}
}
	