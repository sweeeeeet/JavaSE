package com.sweeeeeet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Author:sweet
 * Created:2019/1/19
 */
public class CheckStandPlus {

Scanner scanner=new Scanner(System.in);

       private SimpleGoodsCenter handleGoods=new SimpleGoodsCenter();
       private SimpleOrderCerter handlerOrder=new SimpleOrderCerter();
        private   Order order;
/*
* 进入字符界面收银台，通过键盘输入交互式，进行下一步操作
*
* */
    public void helpInfo(){
        //帮助信息
        System.out.println("================================================");
        System.out.println("欢迎来到字符界面收银台");
        System.out.println("[U]使用\t[S]设置\t[P]保存\t[A]关于\t[Q]退出");
        System.out.println("\t输入\t\tU  S  P  A  Q\t进入操作");
        System.out.println("================================================");
        handleGoods.load();
        String input=scanner.nextLine();

        if("u".equalsIgnoreCase(input)){

            order =new Order(null);
            handlerOrder.addOrder(this.order);
            usageInfo();
        }if("S".equalsIgnoreCase(input)){
            settingInfo();
        }if("P".equalsIgnoreCase(input)){
                handleGoods.store();
        }if("A".equalsIgnoreCase(input)){
            about();
        }if("Q".equalsIgnoreCase(input)){
            quit();

        }else {
            System.out.println("输入格式有误，请重新输入");
            helpInfo();
        }
    }


    public void quit(){
        //退出逻辑
        System.out.println("*************************************************");
        System.out.println("                欢迎使用，下次再见                 ");
        System.out.println("*************************************************");
        System.exit(0);
    }
    /*
    * 收银台版权信息
    * */
    public void about(){
        System.out.println("-------------------- 关于 -----------------------");
        System.out.println("        名称：简易收银台                         ");
        System.out.println("        功能：基于字符界面的收银台操作系统       ");
        System.out.println("        作者: sweeeeeet                          ");
        System.out.println("        版本: v0.3.0                             ");
        System.out.println("        意见反馈：自行消化，不接受反驳           ");
        System.out.println("-------------------------------------------------");
    }



    public void settingInfo(){
        //设置商品信息
        System.out.println("****************************************************************************");
        SimpleGoodsCenter goods=new SimpleGoodsCenter();
        System.out.println("[A]添加商品\t[D]商品下架\t[U]商品修改\t[S]查看商品\t[L]浏览订单\t[R]返回上级");
        System.out.println("\t输入\t\tA  D  U  S  L  R\t进入操作");
        System.out.println("****************************************************************************");
        setting();
    }
    public void setting(){
        //设置逻辑
        String input=scanner.nextLine();

        if("a".equalsIgnoreCase(input)){
            //添加商品
            System.out.println("请按照以下格式输入商品信息：\n商品编号 商品名称 商品价格");
            String googsInfo=scanner.nextLine();
            readGoods(googsInfo);
        }if("d".equalsIgnoreCase(input)){
            //商品下架
            System.out.println("请输入商品编号");
            System.out.println(handleGoods.listGoods());;
            input=scanner.nextLine();
            handleGoods.removeGoods(input);
        }if("l".equalsIgnoreCase(input)){
            //浏览订单
            System.out.println(handlerOrder.ordersTable());;
        }if("s".equalsIgnoreCase(input)){
            //查看商品
            System.out.println( handleGoods.listGoods());;
        }if("u".equalsIgnoreCase(input)){
            //商品修改
            System.out.println(handleGoods.listGoods());;
            System.out.println("请按照以下格式输入商品信息：\n商品编号 商品名称 商品价格");
            input=scanner.nextLine();
            handleGoods.updateGoods(readGoods(input));
        }if("r".equalsIgnoreCase(input)){
            helpInfo();
        }else {
            settingInfo();
            setting();
        }
    }

    public void usageInfo(){
        //使用信息

        System.out.println("*****************************************************************");
        System.out.println("[A]添加商品\t[D]取消商品\t[L]浏览商品\t[S]查看订单\t[R]返回上级");
        System.out.println("\t输入\t\tA  D  L  S  R\t进入操作");
        System.out.println("*****************************************************************");

        usage();
    }

    public void usage(){

        //使用逻辑
        String input=scanner.nextLine();
        if("a".equalsIgnoreCase(input)){
            //用户添加商品
            System.out.println("请输入商品编号");
            input=scanner.nextLine();
                if(handleGoods.isExitGoods(input)){
                    order.add(input,1);
                }
        }if("d".equalsIgnoreCase(input)){
            //用户取消商品
            System.out.println("请输入商品编号");
            input=scanner.nextLine();
            if(handleGoods.isExitGoods(input)){
                order.cancel(input,1);
            }

        }if("l".equalsIgnoreCase(input)){
            //用户浏览商品
            System.out.println(handleGoods.listGoods());;
        }if("s".equalsIgnoreCase(input)){
            //查看订单
            if(this.order!=null){
                System.out.println( handlerOrder.orderTable(order.getOrderId()));;
            }else{
                System.out.println("请先添加商品！！");
            }
        }if("r".equalsIgnoreCase(input)){
            //返回上级
            System.out.println("是否保存订单并退出购物?退出后订单将不能修改(yes/no)");
            input=scanner.nextLine();
            if(input.equalsIgnoreCase("yes")){
                handlerOrder.storeOrders();
                helpInfo();
            }else{
                helpInfo();
            }
        }else {
            usageInfo();
            usage();
        }
    }
    public Goods readGoods(String info){
        //读取商品
        Goods goods=null;
        if(info!=null){
           String[] strings= info.split(" ");
           if (strings.length==3){
               try{
               double price=Double.parseDouble(strings[2]);
                goods=new Goods(strings[0],strings[1],price);
               if(!handleGoods.isExitGoods(strings[0])){
               handleGoods.addGoods(goods);
               }else {
                   System.out.println("商品编号重复！");
               }
               }catch (ClassCastException e){
                   System.out.println("价格输入错误，请检查重输");
               }
           } else{
               System.out.println("输入有误请检查格式后重输");
           }
        }
        return goods;
    }

    public static void main(String[] args) {
        CheckStandPlus checkStandPlus=new CheckStandPlus();
        checkStandPlus.helpInfo();

    }
}
