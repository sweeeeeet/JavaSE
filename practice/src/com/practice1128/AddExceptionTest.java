package com.practice1128;

/**
 * Author:sweet
 * Created:2018/11/28
 */
class AddException extends Exception {
    public AddException(String msg) {
        super(msg);
    }
}

public class AddExceptionTest {
    public static void main(String[] args){
        int a = 2;
        int b = 3;
        if (a + b == 5) {

            try {
                throw new AddException("相加之和为5");
            } catch (AddException e) {
                e.printStackTrace();
            }

        }
    }
}
