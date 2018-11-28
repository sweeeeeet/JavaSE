class PayMent{
	private static double sum=0.0;
public void menu(){

	System.out.println("******************* 买单功能 ********************");
	System.out.println("    [S] 浏览 [A] 下单 [D] 取消 [L] 支付 [Q] 退出 ");
	System.out.println("       输入:  S A D L Q 进入操作                 ");
	System.out.println("*************************************************");
	PayMent pay=new PayMent();
    Insert set=new Insert();
	Scanner scan = new Scanner(System.in);
	String input=scan.nextLine();
		if(input.equals("s")||input.equals("S")){
			//查看商品清单
			set.showGoods();
		}
		if(input.equals("a")||input.equals("A")){
			//下单功能
			set.showGoods();
			pay.shop();
		}
		if(input.equals("d")||input.equals("D")){
			//取消功能
			pay.menu();
		}
		if(input.equals("l")||input.equals("L")){
			//支付
			pay.pay();
		}
		if(input.equals("q")||input.equals("Q")){
			//退出功能
			set.menu();
		}

}

public void shop(){
	while(true){
	System.out.println("请输入要购买的商品信息（如下格式：1 ）,选择完毕请输0:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	
	if(num>0&&num<11){
		if(set.getProductName(num)!=null){
			sum+=set.getPrice(num);
			
		}
	}
	else{
	   System.out.println("您本次购物总额为"+sum);
		pay.menu();
	}
}
}

public void pay(){
		System.out.println("请付款，输入金额");
	Scanner scan = new Scanner(System.in);
	double num =scan.nextDouble();
	System.out.println("给您找零"+(num-sum)+"元");

}

}
