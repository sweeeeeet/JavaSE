package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author:sweet
 * Created:2019/1/16
 * 数据流一旦被操作过并且执行了终结流方法就不能再操作此流
 * 若还想处理相关数据，需重新实例化Stream对象
 */
public class ForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "java", "python", "c++");
        list.forEach((s -> System.out.println(s)));
        list.forEach(System.out::println);
       // 实例化Stream对象,指定泛型的类型，方便其余方法调用函数
        Stream<String> stream=list.stream();
        // 统计出这些数据中带有Java的个数
//    long l= stream.filter((s)->s.contains("java")).count();
//       System.out.println(l);
        // 收集过滤后的数据
       List<String>list1= stream.filter("java"::contains).collect(Collectors.toList());
        list1.forEach((s)-> System.out.println(s));
        list1.forEach(System.out::println);
        //使用skip与limit方法
        System.out.println(stream.skip(0).limit(2).map(String::toUpperCase).collect(Collectors.toList()));
        }
}
