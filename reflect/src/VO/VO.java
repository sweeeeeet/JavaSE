package VO;

import java.lang.reflect.InvocationTargetException;

/**
 * Author:sweet
 * Created:2019/1/16
 */
 class EMP {
    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

}
public class VO{
    public static void main(String[] args) {
        EMPAction empAction=new EMPAction();
        empAction.setEMP("emp.name:lihua|emp.job:C");
        empAction.getEMP();
    }
}