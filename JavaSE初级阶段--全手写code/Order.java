class Order{
	private double sum;
	public void menu(){

	System.out.println("-------------------- 买单功能 -------------------");
	System.out.println("         [S] 浏览 [A] 下单 [L] 支付 [Q] 退出     ");
	System.out.println("            输入:  S A D L Q 进入操作            ");
	System.out.println("-------------------------------------------------");
	Order pay=new Order();
	GoodsCenter set=new GoodsCenter();
	
	Scanner scan = new Scanner(System.in);
	String input=scan.nextLine();
		if(input.equals("s")||input.equals("S")){
			//查看商品清单
			set.showGoods();
			pay.menu();
		}
		if(input.equals("a")||input.equals("A")){
			//下单功能			
			pay.shop();
			pay.menu();
		}
		if(input.equals("l")||input.equals("L")){
			//支付
			pay.pay();
			pay.menu();
		}
		if(input.equals("q")||input.equals("Q")){
			//退出功能
			CheckStand2.menu();
		}

}

	public void shop(){
	Order pay=new Order();
	GoodsCenter set=new GoodsCenter();
	static Goods[] goods=new Goods[10];
	while(true){
	System.out.println("请输入要购买的商品信息（如下格式：1 ）,选择完毕请输0:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	
	if(num>0&&num<11){
		if(goods[num-1].getName()!=null||!(" -- [未上架]".equals(goods[num-1].getName()))){
			sum+=goods[num-1].getPrice();
	   System.out.println("您本次购物总额为"+sum);
		}else{
	   System.out.println("此货架暂无商品");
	   break;
		}
	}
	else{
		break;
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