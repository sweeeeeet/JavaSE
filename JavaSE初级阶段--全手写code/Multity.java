public class Multity{
	
public static void multity( ){

for(int row=1 ;row<10;row++ ){
	for(int col=1;col<=row;col++){
		int ret=col*row;
		System.out.print(col+"*"+row+"="+ret+"\t");
		
	}
	System.out.println();
}
}

public static long jieCheng(int n){
	if(n==1){
		return 1L;
		
	}else{
		
		return n*jieCheng(n-1);
		
	}
}
	
	
	
	public static void main(String[] args){
		// long ret = jieCheng(25);	
		// System.out.println(ret);
		
		
	}
}


