public class SwitchNum{
public static void main(String[] args){
int left = 10;
int right =8;
System.out.println("输出交换前手中的两张纸牌");
System.out.println("左手的纸牌"+left+"\t右手中的纸牌"+right);
// left=(left+right);//18
// right=(left-right);//10
// left=(left-right);
// left=left^right;
// right=left^right;
// left=left^right;
int temp;
temp=left;
left=right;
right=temp;
System.out.println("交换后手中的两张纸牌");
System.out.println("左手的纸牌"+left+"\t右手中的纸牌"+right);

}

}