import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            StringBuffer sb=new StringBuffer();
            double num=sc.nextDouble();
            String str=String.valueOf(num);

            String zheng=str.split("\\.")[0];
            String ling=str.split("\\.")[1];

            String[] num_bw={"","壹","贰","叁","肆"
                    ,"伍","陆","柒","捌","玖"};
            String[] unit={"亿","仟万","佰万","拾万","万","仟","佰","拾","零"};
            boolean handle=true;
            if(ling.equals("00")){
                handle=false;
                sb.append("整元");
            }else if(!(ling.equals("00"))&&!(zheng.equals("0"))){
                sb.append("元");
            }

            String[] each_z=zheng.split("");
            String[] each_l=ling.split("");
            for(int i=each_z.length-1;i>=0;i--){


                //each_z[i]从数字的低位开始计算
                //若遇上零，需要向数字的高位探寻有几个零
                boolean isTail=false;
                if(i==each_z.length-1){
                    isTail=true;
                }
                if(each_z[i].equals("0")){
                    if(each_z.length==1){
                        break;
                    }

                    int t=i;
                    for(int j=t;j>=0;j--){
                        if(each_z[j].equals("0")){
                            i=j;
                        }
                    }
                    if(isTail){
                    }else{
                        sb.append("零");
                    }
                }
                if(each_z[i].equals("1")){
                    sb.append(unit[i]);
                    sb.append(num_bw[1]);
                }
                if(each_z[i].equals("2")){
                    sb.append(unit[i]);
                    sb.append(num_bw[2]);
                }
                if(each_z[i].equals("3")){
                    sb.append(unit[i]);
                    sb.append(num_bw[3]);
                }
                if(each_z[i].equals("4")){
                    sb.append(unit[i]);
                    sb.append(num_bw[4]);
                }
                if(each_z[i].equals("5")){
                    sb.append(unit[i]);
                    sb.append(num_bw[5]);
                }
                if(each_z[i].equals("6")){
                    sb.append(unit[i]);
                    sb.append(num_bw[6]);
                }
                if(each_z[i].equals("7")){
                    sb.append(unit[i]);
                    sb.append(num_bw[7]);
                }
                if(each_z[i].equals("8")){
                    sb.append(unit[i]);
                    sb.append(num_bw[8]);
                }
                if(each_z[i].equals("9")){
                    sb.append(unit[i]);
                    sb.append(num_bw[9]);
                }
            }
            if(handle){
                if(each_l.length==2){
                    if(!(each_l[1].equals("0"))){
                        sb.append("分");
                        int num_n=Integer.parseInt(each_l[1]);
                        sb.append(num_bw[num_n]);
                    }
                    if(!(each_l[0].equals("0"))){
                        sb.append("角");
                        int num_n=Integer.parseInt(each_l[0]);
                        sb.append(num_bw[num_n]);
                    }else{
                        sb.append("零");
                    }
                }

                if(each_l.length==1){

                    if(!(each_l[0].equals("0"))){
                        sb.append("角");
                        int num_n=Integer.parseInt(each_l[0]);
                        sb.append(num_bw[num_n]);
                    }else{
                        sb.append("零");
                    }
                }



            }
            System.out.println("人民币"+sb.reverse().toString());
        }


    }


}

