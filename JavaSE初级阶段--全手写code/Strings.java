//String类扩展功能实现
public class Strings{
public static void main(String[] args){
	   // System.out.println(repeat('a',0));
	   // System.out.println(repeat('a',-4));
	   // System.out.println(repeat('a',6));
	  // System.out.println( fillBefore("java is best",'!',20));
	  // System.out.println( fillBefore("sd",'!',3));
	//System.out.println(removeAll("aa-bb-cc-dd", "-"));
	System.out.println(reverse("abcd"));
}
    
     /**
     * 重复某个字符
     * 
     * 例如： 
     * 'a' 5   => "aaaaa"  
     * 'a' -1  => ""
     * 
     * @param c     被重复的字符
     * @param count 重复的数目，如果小于等于0则返回""
     * @return 重复字符字符串
     */
    public static String repeat(char c, int count) {
	
	   if(count>0){
   char[] chars=new char[count];
		   for(int i=0;i<count;i++){
		  chars[i]=c;
		   }
		   return new String(chars);
	   }
	   else{
		   return "";
	   }
	  
       
	
	
	}
    
    
    
     /**
     * 将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串
     * 字符填充于字符串前
     *
     * 例如： 
     * "abc" 'A' 5  => "AAabc"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillBefore(String str, char filledChar, int len) {
      if(str!=null){
	int strlength=str.length();
		if(strlength<len){		 
		char[] chars=new char[len-strlength];
		for(int i=0;i<len-strlength;i++){
			 chars[i]=filledChar;
		 }
		 return new String(chars)+str;
		}
		else{
		 return str;
		}
	 }
	 else{
		 if(len!=0){			 
		 char[] chars=new char[len];
		 for(int i=0;i<len;i++){
			 chars[i]=filledChar;
		 }
		 return new String(chars);
		 }
		 return "";
	 }
     
    }
    
    /**
     * 将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串<br>
     * 字符填充于字符串后
     * 例如： 
     * "abc" 'A' 5  => "abcAA"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillAfter(String str, char filledChar, int len) {
     if(str!=null){
	int strlength=str.length();
		if(strlength<len){		 
		char[] chars=new char[len-strlength];
		for(int i=0;i<len-strlength;i++){
			 chars[i]=filledChar;
		 }
		 return str+new String(chars);
		}
		else{
		 return str;
		}
	 }
	 else{
		 if(len!=0){			 
		 char[] chars=new char[len];
		 for(int i=0;i<len;i++){
			 chars[i]=filledChar;
		 }
		 return new String(chars);
		 }
		 return "";
	 }
        
    }

    /**
     * 移除字符串中所有给定字符串
     * 例：removeAll("aa-bb-cc-dd", "-") => aabbccdd
     *
     * @param str         字符串
     * @param strToRemove 被移除的字符串
     * @return 移除后的字符串
     */
    public static String removeAll(CharSequence str, CharSequence strToRemove) {
    if(str!=null&&strToRemove!=null){
		String sstr=str.toString();
		String sstrToRemove=strToRemove.toString();
		String[] sbStrs=sstr.split(sstrToRemove);
		String strings="";
		for(int i=0;i<sbStrs.length;i++){
			strings+=sbStrs[i];
		}
		return strings;
	}
	return "";
    }
    
    /**
     * 反转字符串
     * 例如：abcd => dcba
     *
     * @param str 被反转的字符串
     * @return 反转后的字符串
     */
    public static String reverse(String str) {
		if(str!=null){		
	char[] chars=str.toCharArray();
	for(int i=0;i<chars.length/2;i++){
		char temp=chars[i];
		chars[i]=chars[chars.length-1-i];
		chars[chars.length-1-i]=temp;
	}
	String str1=new String(chars);
	return str1;
		}
		return "";
    }

}