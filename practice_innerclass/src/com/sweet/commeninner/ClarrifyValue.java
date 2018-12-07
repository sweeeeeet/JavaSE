package com.sweet.commeninner;

/**
 * Author:sweet
 * Created:2018/12/7
 */
public class ClarrifyValue {
    private String prop="外部类的实例变量";
    private  class Inner{
        private String prop="内部类的实例变量";
        public void info(){
            String prop="局部变量";
            System.out.println("外部类的实例变量"+ClarrifyValue.this.prop);
            System.out.println("内部类的实例变量"+this.prop);
            System.out.println("内部类方法中的局部变量"+prop);
        }
    }
    public  void  test(){
        Inner in=new Inner();
        in.info();
    }

    public static void main(String[] args) {
        new ClarrifyValue().test();
    }
}
