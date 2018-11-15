public class ArryTest{

//最大值
public static int arrayMaxElement(int[] data){
	if(data==null){
		throw new IllegalArgumentException("数组不能为空");
	}
	int max=Integer.MIN_VALUE;
	for(int i=0;i<data.length;i++){
		
		if(data[i]>max){
			max=data[i];
		}
		
	}
	
	
	return max;
}

//最小值
public static int arrayMinElement(int[] data){
	if (data==null){
		throw new IllegalArgumentException("数组不能为空");
	}
	int min=Integer.MAX_VALUE;
	for(int i=0;i<data.length;i++){
		if(data[i]<min){
			min=data[i];
		}		
	}
	return min;
}

//求和
public static int arrayElementSum(int[] data){
	if (data==null){
		throw new IllegalArgumentException("数组不能为空");
	}
	int sum=0;
	for(int i=0;i<data.length;i++){
		
		sum+=data[i];
		
	}
	
	return sum;
}

//字符串拼接
public static int[]  arrayJoin(int[] a, int[] b){
	if (b==null||a==null){
		throw new IllegalArgumentException("数组不能为空");
	}
	int[] arr=new int[a.length+b.length];
	for(int i=0;i<a.length;i++){
		arr[i]=a[i];	
	}
	for(int i=a.length;i<arr.length;i++){
		
		arr[i]=b[i-a.length];
		
	}
	
	//print(arr);
	return arr;
	
}

//字符串截取[strat,end)[3,5)
public static int[] arraySub(int[] a,int start,int end){
	if (a==null){
		throw new IllegalArgumentException("数组不能为空");
	}
	if(start<0||end<0){
		throw new IllegalArgumentException("起始位置与终止位置必须大于等于0");
	}
	if(start>end){
		throw new IllegalArgumentException("字符串截取的起始位置要小于终止位置！");
	}
	
	int[] arr=new int[end-start];
	for(int i=0;i<(end-start);i++){
		
		arr[i]=a[start+i-1];
		
	}
	
	//print(arr);
	return arr;
}


//打印数组
public static void print(int[] data){
	if (data==null){
		throw new IllegalArgumentException("数组不能为空");
	}
	
	for(int i=0;i<data.length;i++){		
		System.out.print(data[i]+"、");	
	}
	
	System.out.println();
}
public static void main(String[] args){
int[] arrayData=new int[]{12,12,23,1,4,6,78};
int[] arrayData2=new int[]{2,3};
System.out.print("数组1为：");
print(arrayData);
System.out.print("数组2为：");
print(arrayData2);

 System.out.println("数组一最大值："+arrayMaxElement(arrayData));
System.out.println("数组一最小值："+arrayMinElement(arrayData));
System.out.println("数组一求和结果："+arrayElementSum(arrayData));
System.out.println("数组拼接：");
print(arrayJoin(arrayData,arrayData2));
System.out.println("数组一数组截取：[2,6)");
print(arraySub(arrayData,2,6));


}

}