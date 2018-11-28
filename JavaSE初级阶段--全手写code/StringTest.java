public class StringTest{
	public static void code1(){
	char[] data=new char[]{'h','e','l','l','o'};
	String str=new String(data);
	System.out.println(str);
	}
	public void code2(){
		char c="hello".charAt(1);
	System.out.println(c);
	}
	public void code3(){
		char[] chars="hello".toCharArray();
	System.out.println(chars);
	System.out.println(chars.length);
	System.out.println("nihao".length());
	}
	
	//判断字符串是否由数字组成
	public static boolean isNum(String str){
		char[] data=str.toCharArray();
		for(int i=0;i<10;i++){
			if(data[i]>'0'&&data[i]<'9'){
				return true;
			}
			else{
				return false;
			}
		}
		return true;
	}
	public void code4(){
		byte[] by=new byte[]{1,2,3};
		String str=new String(by);
		System.out.println(str);
	}
	public void code5(){
	String str="hello";
	byte[] by=str.getBytes();
	for(int i=0;i<by.length;i++){
		System.out.println(by[i]);
	}	
	}
	public void code6(){
		String str1="hello";
		String str2="Hello";
		System.out.println(str1.equalsIgnoreCase(str2));
	}
	public void code7(){
	String str1="hello";
	String str2="Hello";
	System.out.println(str1.compareTo(str2));	
	}
	public void code8(){
	String str1="hello";
	String str2="Hello";
	System.out.println(str1.contains(str2));	
	}
	public void code9(){
	String str="hello java language";
	String[] result=str.split(" ");
	String[] result1=str.split(" ",2);
	for(int i=0;i<result.length;i++){
		System.out.println(result[i]);
	}
	for(int i=0;i<result1.length;i++){
		System.out.println(result1[i]);
	}

	}
	public void code10(){
	//System.out.println(str.indexOf("ll"));
	// System.out.println(str.indexOf("nihao"));
	// System.out.println("nihao".startsWith("h",2));	//true
	}
	public void code11(){
		String str="张三：23|李四：23|王五：78";
		String[] res=str.split("\\|");
		for(int i=0;i<res.length;i++){
			System.out.println(res[i].split(":"));
		}
	}
	public void code12(){
		String str="helloworld";
	System.out.println(str.substring(5));
	System.out.println(str.substring(5,9));
	}
public void code13(){
	String str=" hello bite ！";
	System.out.println(str.trim());
	str=str+"你好3487&&*&MD";
	System.out.println(str.toUpperCase());
	System.out.println(str.toLowerCase());
	System.out.println(str.length());
}
public void code14(){
	System.out.println("sssd".isEmpty());
	System.out.println("".isEmpty());
	System.out.println(new String().isEmpty());
}
public static String firstUpperCase(String str){
	if(str==null||"".equals(str)){
		
		return str;
	}else{
		if(str.length()==1){
			return str.toUpperCase();
		}
		str=(str.substring(0,1)).toUpperCase()+str.substring(1);
		return str;
	}
}
public void code15(){
	StringBuffer bs=new StringBuffer("java");	
	bs.append(" is").append(" best");
	System.out.println(bs);
	System.out.println(bs.delete(6,8));
	
	String str=bs.toString()+"!!!";
	System.out.println(str);
}
public static void main(String[] args){
	// System.out.println(isNum("1231"));
	// System.out.println(isNum("sf55"));
	//System.out.println("skfdk".endsWith("k"));	
	// System.out.println("java is best".replaceAll(" ","-"));	
	// System.out.println("java is best".replaceFirst(" ","-"));	
	// System.out.println(firstUpperCase(""));
	// System.out.println(firstUpperCase("sdass"));
	// System.out.println(firstUpperCase(new String()));
	// System.out.println(firstUpperCase("d"));
	StringBuffer bs=new StringBuffer("java");	
	System.out.println(bs.insert(0,new StringBuffer( "hi ")));
	System.out.println(bs.insert(0,"hello "));
}
}