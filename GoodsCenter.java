class GoodsCenter{

	public void showGoods(){	
	Order pay=new Order();
	GoodsCenter set=new GoodsCenter();
	static Goods[] goods=new Goods[10];
	System.out.println("------------------  商品清单  -------------------");
	System.out.println("        编号    产品名称                单价     ");
	for(int i=0;i<10;i++){
		goods[i].setNum(i+1);
		if(i==9){
		if(goods[i].getName()==null){
			goods[i].setName("-- [未上架]");
System.out.println("      "+goods[i].getNum()+"    "+goods[i].getName()+"                "+goods[i].getPrice());
		}
		else{
System.out.println("      "+goods[i].getNum()+"    "+goods[i].getName()+"                "+goods[i].getPrice());
		}
		}
		else{
		if(goods[i].getName()==null){
			goods[i].setName("-- [未上架]");
System.out.println("       "+goods[i].getNum()+"    "+goods[i].getName()+"                "+goods[i].getPrice());
		}
		else{
System.out.println("       "+goods[i].getNum()+"    "+goods[i].getName()+"                "+goods[i].getPrice());
		}
		}
	
	}
	System.out.println("-------------------------------------------------");
}


	
	public void putaway(){
	Order pay=new Order();
	GoodsCenter set=new GoodsCenter();
	static Goods[] goods=new Goods[10];
	System.out.println("请输入上架商品信息（如下格式：1 餐巾纸 1.4）:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	String name=scan.next();
	double price=scan.nextDouble();
	for(int i=0;i<10;i++){
		if(num==goods[i].getNum()){
		if(goods[i].getPrice()==0.0){			
			goods[i].setName(name);
			goods[i].setPrice(price);	
			break;			
		    
			}
			else{
			System.out.println("此编号已有货物录入，请为当前货物编录新编号");
			set.putaway();
		}
		}
		
	}
	set.showGoods();
	}

	public void modification(){
	Order pay=new Order();
	GoodsCenter set=new GoodsCenter();
	static Goods[] goods=new Goods[10];
	System.out.println("请输入修改商品信息（如下格式：1 餐巾纸 1.4）:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	String name=scan.next();
	double price=scan.nextDouble();
	for(int i=0;i<10;i++){
		
		if(num==goods[i].getNum()){
			goods[i].setName(name);
			goods[i].setPrice(price);
			set.showGoods();
			}
			
		}
		
	}	
	
	public void remove(){
		Order pay=new Order();
	GoodsCenter set=new GoodsCenter();
	static Goods[] goods=new Goods[10];
	System.out.println("请输入下架商品编号（如下格式：1）:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	for(int i=0;i<10;i++){
		
		if(num==goods.getNum()){
			goods.setName(null);
			goods.setPrice(0.0);
			set.showGoods();
			}
			
		}	
	}
	
	public void quit(){
		CheckStand2.menu();
	}
	
}