public class ArrayDemo{


public static void main(String[] args){
	
	
	String langusges[] = new String[]{"汉语","德语","法语","英语"};
	for(String lang:langusges){
		
		System.out.println(lang);
	}



	
	
	
	
// int[] arr=new int[]{1,2,3};
// printArray(arr);

// int[] data=init();
// bigger(data);
// printArray(data);


int[] intData=new int[]{1,2,3,4,5};
char[] charData=new char[]{'l','f','z','t'};
java.util.Arrays.sort(intData);
java.util.Arrays.sort(charData);

for(int array:intData){
	System.out.println(array);
	
}

for(char data:charData){
	System.out.println(data);
}
//printArray(charData);
}

//重载
public static char[] printArray(char[] data){
	
	for(int i=0;i<data.length;i++){
		
		System.out.println(data[i]);
		
	}
	return data;
}
public static int[] init(){
	return new int[]{1,2,3,4};//匿名数组
	
}



public static void bigger(int[] data){
	
	for(int i=0;i<data.length;i++){
		
		data[i]=data[i]*5;
	}
}
public static int[] printArray(int[] arr){
	
	for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]);
		
	}
	return arr;
}




}