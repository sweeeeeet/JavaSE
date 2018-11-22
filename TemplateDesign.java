public class TemplateDesign{
	public static void main(String[] args){
	
	System.out.println("柠檬茶一杯");
	Tea tea=new Tea();
	tea.makeDrink();
	System.out.println("*********************");
	System.out.println("芒果汁一杯");
	Juice juice=new Juice();
	juice.makeDrink();
	System.out.println("*********************");
	System.out.println("芒果汁一杯");
	Juice juice2=new Juice();
	juice2.makeDrink();
	}
}
abstract class Drink{
	
	public final void  makeDrink(){
		this.boilWater();
		this.putWater();
		this.addMajor();
		if(isAddMinor()){
		this.addMinor();
		}
		this.finsh();
	}
	
	public final void boilWater(){
		System.out.println("1.把水烧开");
	}
	public final void putWater(){
		System.out.println("2.把水倒进杯子");
	}
	abstract public void addMajor();
	abstract public void addMinor();
	
	public boolean isAddMinor(){
		return true;
	}
	public void finsh(){
		System.out.println("饮品完成");
	}
}
class Tea extends Drink{
	public void addMajor(){
		System.out.println("3.把茶倒进水中");
	}
	public void addMinor(){
		System.out.println("4.添加柠檬片");
	}
}
class Juice extends Drink{
	
	public void addMajor(){
		System.out.println("3.把浓缩芒果粉倒进水中");
	}
	public boolean isAddMinor(){
		System.out.println("是否加糖和牛奶:y/n");
		java.util.Scanner scan=new java.util.Scanner(System.in);
		String input=scan.nextLine();
		if(input.equals("y")){
			return true;
		}
		else if(input.equals("n")){
			return false;
		}
		else{
			System.out.println("任意键入符号，默认添加");
			return true;
		}
	}
	public void addMinor(){
		System.out.println("4.加糖和牛奶");
	}
}