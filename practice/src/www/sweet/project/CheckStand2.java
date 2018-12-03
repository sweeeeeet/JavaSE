package www.sweet.project;

/**
 * Author:sweet
 * Created:2018/11/27
 */
import java.util.Scanner;
public class CheckStand2{

    public static void main(String[] args){
        menu();
    }

    public  static void  menu(){
        System.out.println("*************** 欢迎使简易收银台 *****************");
        System.out.println("       [U] 使用 [S] 设置 [A] 关于 [Q] 退出        ");
        System.out.println("             输入:  U S A Q 进入操作              ");
        System.out.println("**************************************************");
        GoodsCenter set=new GoodsCenter();
        CheckStand2 che=new CheckStand2();
        Order pay=new Order();
        Scanner scan = new Scanner(System.in);
        String input=scan.nextLine();
        if(input.equals("u")||input.equals("U")){

            //买单功能

            pay.menu();
        }
        if(input.equals("s")||input.equals("S")){
            //设置功能

            che.setMenu();
        }
        if(input.equals("a")||input.equals("A")){
            //展示软件信息
            che.about();
            CheckStand2.menu();
        }
        if(input.equals("q")||input.equals("Q")){
            //退出功能
            che.quit();
        }

    }

    public void setMenu(){
        System.out.println("------------------- 设置功能 --------------------");
        System.out.println("    [S] 查看 [A] 上架 [D] 下架 [U] 修改 [Q] 退出 ");
        System.out.println("       输入:  S  A  D  U  Q  进入操作            ");
        System.out.println("-------------------------------------------------");
        GoodsCenter set=new GoodsCenter();
        Order pay=new Order();
        Scanner scan = new Scanner(System.in);
        String input=scan.nextLine();
        if(input.equals("s")||input.equals("S")){
            //查看商品清单
            set.showGoods();
            setMenu();
        }
        if(input.equals("u")||input.equals("U")){
            //修改功能
            set.modification();
            setMenu();
        }
        if(input.equals("d")||input.equals("D")){
            //下架功能
            set.remove();
            setMenu();
        }
        if(input.equals("a")||input.equals("A")){
            //上架录入信息
            set.putaway();
            setMenu();
        }
        if(input.equals("q")||input.equals("Q")){
            //退出功能
            set.quit();
        }

    }



    public static void about(){
        System.out.println("-------------------- 关于 -----------------------");
        System.out.println("        名称：简易收银台                         ");
        System.out.println("        功能：基于字符界面的收银台操作系统       ");
        System.out.println("        作者: sweeeeeet                          ");
        System.out.println("        版本: v0.0.1                             ");
        System.out.println("        意见反馈：自行消化，不接受反驳           ");
        System.out.println("-------------------------------------------------");

    }
    public static void quit(){
        System.out.println("-------------------- 退出 -----------------------");
        System.out.println("                欢迎使用，下次再见               ");
        System.out.println("-------------------------------------------------");
    }
}
class GoodsCenter{
    public  static Goods[] goods=new Goods[]{
            new Goods(0),
            new Goods(1),
            new Goods(2),
            new Goods(3),
            new Goods(4),
            new Goods(5),
            new Goods(6),
            new Goods(7),
            new Goods(8),
            new Goods(9)
    };

    public void showGoods(){


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
        set.showGoods();
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
        System.out.println("请输入下架商品编号（如下格式：1）:");
        Scanner scan = new Scanner(System.in);
        int num =scan.nextInt();
        for(int i=0;i<10;i++){

            if(num==goods[num-1].getNum()){
                goods[num-1].setName(null);
                goods[num-1].setPrice(0.0);
                set.showGoods();
            }

        }
    }

    public void quit(){
        CheckStand2.menu();
    }

}
class Goods{
    private  int num;
    private  String name;
    private  double price;

    public Goods(int num){
        this.num=num;
    }
    public  void setName(String name){
        this.name=name;
    }
    public  void setPrice(double price){
        this.price=price;
    }

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public  void setNum(int num){
        this.num=num;
    }

    public int getNum(){
        return num;
    }

}
class Order{
    private double sum;
    ;


    public void menu(){

        System.out.println("-------------------- 买单功能 -------------------");
        System.out.println("         [S] 浏览 [A] 下单 [L] 支付 [Q] 退出     ");
        System.out.println("            输入:  S A D L Q 进入操作            ");
        System.out.println("-------------------------------------------------");
        GoodsCenter set=new GoodsCenter();
        Order pay=new Order();
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
        GoodsCenter set=new GoodsCenter();
        while(true){
            System.out.println("请输入要购买的商品信息（如下格式：1 ）,选择完毕请输0:");
            Scanner scan = new Scanner(System.in);
            int num =scan.nextInt();

            if(num>0&&num<11){
                if(set.goods[num-1].getName()!=null||!(" -- [未上架]".equals(set.goods[num-1].getName()))){
                    sum+=set.goods[num-1].getPrice();
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

