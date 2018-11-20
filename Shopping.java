// 模版设计模式：在线购物流程 (天猫，京东)
// 浏览商品 -> 选择商品 -> 客服服务 -> 快递服务 -> 结算 -> 付款 -> 查看订单
// 4.字符界面的收银台


public class Shopping{
	public static void main(String[] args){
		ShopOnline tmall=new Tmall();
		tmall.shopOnline();
		System.out.println("******************************");
		System.out.println("******************************");
		ShopOnline jingdong=new JingDong();
		jingdong.shopOnline();
	}
}

abstract class ShopOnline{
	java.util.Scanner scan=new java.util.Scanner(System.in);
	
	
	public final void chooseGoods(){
		System.out.println("将选好的商品放入购物车");
		System.out.println();
	}

	public void calculator(){
		java.util.Random random=new java.util.Random();
		System.out.println("结算商品：共"+(random.nextInt(1000))+"元");
		System.out.println();
	}
	public void pay(){
		System.out.println("请选择支付方式：1.支付宝2.微信3.银行卡");
		System.out.println();
		int num=scan.nextInt();
		System.out.println("支付成功");
		System.out.println();
	}
	public void checkOrder(){
		
		System.out.println("支付成功，准备配送中");	
		System.out.println();		
	
	}
	
	public boolean isService(){
	System.out.println("是否咨询客服？y/n");
		String input=scan.nextLine();
		if(input.equals("y")){
			return true;
		}
		if(input.equals("n")){
			return false;
		}else{
			 return false;
		}
		
	}
	public abstract void scanGoods();
	public abstract void service();
	public abstract void post();
	
	public final void shopOnline(){
		
	this.scanGoods();
    this.chooseGoods();
	
	if(isService()){
	this.service();
	}
	
	this.post();	
	this.calculator();	
	this.pay();	
	
	
	this.checkOrder();	
	
	
	}
}



class JingDong extends ShopOnline{
	java.util.Scanner scan=new java.util.Scanner(System.in);
	public void scanGoods(){
		System.out.println("在京东浏览商品");	
		System.out.println();
	}
	public void service(){
		while (true){
		System.out.println("你好，京东客服为你服务，请输入你的问题哦~");	
		System.out.println("1.东西包邮吗？");
		System.out.println("2.质量怎么样呢？");
		System.out.println("3.可以再少点吗？");
		System.out.println("结束咨询请输q");
			
			String question=scan.nextLine();
			if(question.equals("q")){
				break;
			}
			else if(question.equals("1")){
				System.out.println("亲亲，满89包邮哦");
				System.out.println();
			}
			else if(question.equals("2")){
				System.out.println("京东平台，质量绝对保证的哦");
				System.out.println();
			}
			else if(question.equals("3")){
				System.out.println("亲亲不议价哦");
				System.out.println();
			}
			else{
		System.out.println("京东智能客服正在升级，这个问题我再想想哦~，结束咨询请输q");	
		System.out.println();
			}
		}
	
	}
	public void post(){
		System.out.println("请选择快递服务：1.京东配送 2.韵达 3.EMS 4.随机");
		int choose=scan.nextInt();
		switch (choose){
			case 1:
			System.out.println("快递选择京东为您配送");
			System.out.println();
			break;
			case 2:
			System.out.println("快递选择韵达快递为您配送");
			System.out.println();
			break;
			case 3:
			System.out.println("快递选择EMS为你配送");
			System.out.println();
			break;
			case 4:
			System.out.println("快递选择：随机");
			System.out.println();
			break;
			default:
			System.out.println("快递选择：京东配送");
			System.out.println();
		}
	}
	
	
}
class Tmall extends ShopOnline{
	java.util.Scanner scan=new java.util.Scanner(System.in);
	public void scanGoods(){
		System.out.println("在天猫浏览商品");
		System.out.println();		
	}
	public void service(){
		while (true){
		System.out.println("你好，天猫客服为你服务，请输入你的问题哦~");	
		System.out.println("1.东西包邮吗？");
		System.out.println("2.质量怎么样呢？");
		System.out.println("3.可以再少点吗？");
		System.out.println("结束咨询请输q");
			
			String question=scan.nextLine();
			if(question.equals("q")){
				break;
			}
			else if(question.equals("1")){
				System.out.println("亲亲，全场包邮哦");
				System.out.println();
			}
			else if(question.equals("2")){
				System.out.println("天猫平台，质量绝对保证的哦");
				System.out.println();
			}
			else if(question.equals("3")){
				System.out.println("亲亲那就给你再少10元哦");
				System.out.println();
			}
			else{
		System.out.println("天猫智能客服正在升级，这个问题我再想想哦~，结束咨询请输q");	
		System.out.println();
			}
		}
	
	}
	public void post(){
		System.out.println("请选择快递服务：1.圆通 2.韵达 3.EMS 4.随机");
		int  choose=scan.nextInt();
		switch (choose){
			case 1:
			System.out.println("快递选择：圆通快递");
			System.out.println();
			break;
			case 2:
			System.out.println("快递选择：韵达快递");
			System.out.println();
			break;
			case 3:
			System.out.println("快递选择：EMS");
			System.out.println();
			break;
			case 4:
			System.out.println("快递选择：随机");
			System.out.println();
			break;
			default:
			System.out.println("快递选择：圆通配送");
			System.out.println();
		}
	}
  
	public boolean isService(){
	
		return true;
	}
		
	
	
}
	