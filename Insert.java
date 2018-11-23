class Insert{
private static int[] goodsNum=new int[]{1,2,3,4,5,6,7,8,9,10};
private static String[] productName=new String[10];
private static double[] productPrice=new double[10];

public double getPrice(int num){
	return productPrice[num];
}
public String getProductName(int num){
	return productName[num];
}
public void menu(){
	System.out.println("------------------- 设置功能 --------------------");
	System.out.println("    [S] 查看 [A] 上架 [D] 下架 [U] 修改 [Q] 退出 ");
	System.out.println("       输入:  S  A  D  U  Q  进入操作            ");
	System.out.println("-------------------------------------------------");
	PayMent pay=new PayMent();
    Insert set=new Insert();
	Scanner scan = new Scanner(System.in);
	String input=scan.nextLine();
		if(input.equals("s")||input.equals("S")){
			//查看商品清单
			set.showGoods();
		}
		if(input.equals("u")||input.equals("U")){
			//修改功能
			set.modification();
		}
		if(input.equals("d")||input.equals("D")){
			//下架功能
			set.remove();
		}
		if(input.equals("a")||input.equals("A")){
			//上架录入信息
			set.putaway();
		}
		if(input.equals("q")||input.equals("Q")){
			//退出功能
			set.quit();
		}
		set.menu();
}
public void showGoods(){	
		PayMent pay=new PayMent();
		Insert set=new Insert();
	System.out.println("------------------  商品清单  -------------------");
	System.out.println("        编号    产品名称                单价     ");
	for(int i=0;i<10;i++){
		if(i==9){
		if(productName[i]==null){
			productName[i]="-- [未上架]";
System.out.println("      "+goodsNum[i]+"    "+productName[i]+"                "+productPrice[i]);
		}
		else{
System.out.println("      "+goodsNum[i]+"    "+productName[i]+"                "+productPrice[i]);
		}
		}
		else{
		if(productName[i]==null){
			productName[i]="-- [未上架]";
System.out.println("       "+goodsNum[i]+"    "+productName[i]+"                "+productPrice[i]);
		}
		else{
System.out.println("       "+goodsNum[i]+"    "+productName[i]+"                "+productPrice[i]);
		}
		}
	
	}
	System.out.println("-------------------------------------------------");
}

public void putaway(){
	PayMent pay=new PayMent();
    Insert set=new Insert();
	System.out.println("请输入上架商品信息（如下格式：1 餐巾纸 1.4）:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	String name=scan.next();
	double price=scan.nextDouble();
	for(int i=0;i<10;i++){
		if(num==goodsNum[i]){
		if(productPrice[i]==0.0){			
			productName[i]=name;
			productPrice[i]=price;	
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
		PayMent pay=new PayMent();
    Insert set=new Insert();
	System.out.println("请输入修改商品信息（如下格式：1 餐巾纸 1.4）:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	String name=scan.next();
	double price=scan.nextDouble();
	for(int i=0;i<10;i++){
		
		if(num==goodsNum[i]){
			productName[i]=name;
			productPrice[i]=price;
			set.showGoods();
			}
			
		}
		
	}	
	
	public void remove(){
		PayMent pay=new PayMent();
    Insert set=new Insert();
	System.out.println("请输入修改商品信息（如下格式：1）:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	for(int i=0;i<10;i++){
		
		if(num==goodsNum[i]){
			productName[i]=null;
			productPrice[i]=0.0;
			set.showGoods();
			}
			
		}	
	}
	
	public void quit(){
		CheckStand.menu();
	}
}

