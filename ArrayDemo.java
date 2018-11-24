public class ArrayDemo{


public static void main(String[] args){
	
	
	String langusges[] = new String[]{"汉语","德语","法语","英语"};
	int[] data=new int[]{12,222,23,44,55,66};
	int[] data2=new int[]{1,2,3,4,5,6};
	int[] newArray=java.util.Arrays.copyOf(data2,data2.length+2);
	int[] newArray2=java.util.Arrays.copyOf(data2,3);

	printArray(newArray);
	printArray(newArray2);
	// char[] chars=new char[]{'n','i','h','a','o'};
	// System.arraycopy(data2,0,data,1,3);
	// for(int temp:data){
		// System.out.println(temp);
	// }
	// java.util.Arrays.sort(chars);
	// for(char temp:chars){
		// System.out.println(temp);
	// }

}
public static void printArray(int[] data){
	for(int temp:data){
	System.out.println(temp+"、");
	}
}
public static int[] modify(int[] data){
	for(int i=0;i<data.length;i++){
		System.out.println(data[i]*2);
	}
	return data;
}
public static void printArray(String[] data){
	for(String temp:data){
	System.out.println(temp+"、");
	}
}
}