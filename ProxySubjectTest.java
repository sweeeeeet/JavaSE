public class ProxySubjectTest{
	public static void main(String[] args){
		
		Subject subject=SubjectFactory.getInstance();
		subject.buyComputer();
	}

}
interface Subject{
	void buyComputer();
}

class RealSubject implements Subject{
	public void buyComputer(){
		System.out.println("买电脑");
	}
}
class ProxySubject implements Subject{
	private Subject sub;
	public ProxySubject(Subject sub){
		this.sub=sub;
	}
	public void produce(){
		System.out.println("生产电脑");
	}
	public void afterBuy(){
		System.out.println("售后");
	}
	public void buyComputer(){
		this.produce();
		this.sub.buyComputer();
		this.afterBuy();
		
	}
}
class SubjectFactory{
	
	public static Subject getInstance(){
		return new ProxySubject(new RealSubject());
	}
}