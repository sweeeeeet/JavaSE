public class AbstrctFactory{
	public void buyComputer(Computer com){
		com.printComputer();
	}
	public void checkSystem(OperateSystem sys){
		sys.printSystem();
	}
	public static void main(String[] args){
		AbstrctFactory client=new AbstrctFactory();
		ProcductFactory computer=new MacComputerFactory();
		
		client.buyComputer(computer.getInstance());
		client.checkSystem(computer.getSystemInstance());
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

interface OperateSystem{
	void printSystem();
}
class MacComputerSystem implements OperateSystem{
	public void printSystem(){
		System.out.println("MacComputer的操作系统是mac os");
	}
}
class AsusComputerSystem implements OperateSystem{
	public void printSystem(){
		System.out.println("AsusComputer的操作系统是windows10");
	}
}
class AlienwareComputerSystem implements OperateSystem{
	public void printSystem(){
		System.out.println("AlienwareComputer的操作系统是windows vitas");
	}
}
	
interface ProcductFactory{
	Computer getInstance();
	OperateSystem getSystemInstance();
}


class MacComputerFactory implements ProcductFactory{
	public Computer getInstance(){
		return new MacComputer();
	}
	public OperateSystem getSystemInstance(){
		return new MacComputerSystem();
	}
}
class AsusComputerFactory implements ComputerFactory{
	public Computer getInstance(){
		return new AsusComputer();
	}
	public OperateSystem getSystemInstance(){
		return new AsusComputerSystem();
	}
}
class AlienwareComputerFactory implements ComputerFactory{
	public Computer getInstance(){
		return new AlienwareComputer();
	}
	public OperateSystem getSystemInstance(){
		return new AlienwareComputerSystem();
	}
}