public class ArryTest{

//最大值
public static int arrayMaxElement(int[] data){
	int max=0;
	for(int i=0;i<data.length-1;i++){
		
		if(data[i]>data[i+1]){
			max=data[i];
		}else{
			max=data[i+1];
		}
		
	}
	
	
	return max;
}

//最小值
public static int arrayMinElement(int[] data){
	int min=0;
	for(int i=0;i<data.length-1;i++){
		if(data[i]<data[i+1]){
			min=data[i];
		}
		else{
			min=data[i+1];
		}
		
	}
	return min;
}

//求和
public static int arrayElementSum(int[] data){
	int sum=0;
	for(int i=0;i<data.length;i++){
		
		sum+=data[i];
		
	}
	
	return sum;
}

//字符串拼接
public static int[]  arrayJoin(int[] a, int[] b){
	int[] arr=new int[a.length+b.length];
	for(int i=0;i<a.length;i++){
		arr[i]=a[i];	
	}
	for(int i=a.length;i<arr.length;i++){
		
		arr[i]=b[i-a.length];
		
	}
	
	return arr;
}

//字符串截取[strat,end)[3,5)
public static int[] arraySub(int[] a,int start,int end){
	int[] arr=new int[end-start];
	for(int i=0;i<(end-start);i++){
		
		arr[i]=a[start+i];
		
	}
	
	return arr;
}


//打印数组
public static void print(int[] data){
	for(int i=0;i<data.length;i++){
		
		System.out.print(data[i]+"、");
		
		
		
	}
	
	System.out.println();
}
public static void main(String[] args){
int[] arrayData=new int[]{12,12,23,1,4,6,78};
int[] arrayData2=new int[]{2,3};

print(arrayData);
print(arrayData2);

 System.out.println("最大值："+arrayMaxElement(arrayData));
System.out.println("最小值："+arrayMinElement(arrayData));
System.out.println("求和结果："+arrayElementSum(arrayData));
System.out.println("数组拼接："+arrayJoin(arrayData,arrayData2));
System.out.println("数组截取："+arraySub(arrayData,2,6));


}

}