
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestBook {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        User user = new User();
//        User user = new User("zhangsan");

        // 0. 获取 User 的 类 类型 的实例
        Class<?> clazz = Class.forName("Book.Book");
        Constructor c1 = clazz.getConstructor(int.class);
        Constructor c2 = clazz.getConstructor(int.class,String.class);
        Constructor c3 = clazz.getConstructor(int.class,String.class,double.class);
        // 1. 完成了 对 User 类的解析

        // 2. 操作类
        // 2-1 实例化
        // 2-1.0 调用构造方法：调用缺省无参的构造方法
        Object book = clazz.newInstance();
        Object book1 = c1.newInstance(10);
        Object book2 = c2.newInstance(11,"啊啊啊");
        Object book3 = c3.newInstance(12,"啊啊啊啊阿",99.99);
        System.out.println(book);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
//        // 2-1.1 调用指定的构造方法：
//        // 2-1.1-1 找到指定的构造方法
//        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);     // 找参数类型为 String 的构造方法
//        // 2-1.1-2 调用找的指定的构造方法
//        Object user2 = constructor.newInstance("zhangsan");
//        System.out.println(user2);


        // 2-2.1 获取指定的属性
        Field idField = clazz.getDeclaredField("id");
        Field nameField = clazz.getDeclaredField("name");
        Field priceField = clazz.getDeclaredField("price");
        Field authorField = clazz.getDeclaredField("author");
        // 2-2.2 写属性
        idField.setAccessible(true);
        nameField.setAccessible(true);
        priceField.setAccessible(true);
        authorField.setAccessible(true);
        idField.set(book,1);
        nameField.set(book, "啊啊");
        priceField.set(book,1000.01);
        authorField.set(book,"李铁锤");
        // 2-2.3 读属性
        Object bookID = idField.get(book);
        Object bookName = nameField.get(book);
        Object bookPrice = priceField.get(book);
        Object bookAuthor = authorField.get(book);
        System.out.println(book);
        // 2-3 方法的调用
        // 2-3.1 获取指定的方法
        // 获取 setName ： 方法名字、方法的参数类型
        Method setIDMethod = clazz.getMethod("setId", int.class);
        Method setNameMethod = clazz.getMethod("setName", String.class);
        Method setPriceMethod = clazz.getMethod("setPrice", double.class);
        Method setAuthorMethod = clazz.getMethod("setAuthor", String.class);
        // 获取 getNameLength ： 方法名字，无参数
        Method getNameLengthMethod = clazz.getDeclaredMethod("getNameLength");  // 私有方法
        // 2-3.2 调用指定的方法
        // 调用 setName 方法：方法、那个对象调用该方法、该方法所接受的参数值
        setIDMethod.invoke(book,2);
        setNameMethod.invoke(book, "啊啊啊");
        setPriceMethod.invoke(book,1234.56);
        setAuthorMethod.invoke(book,"王钢蛋");
        System.out.println(book);
        // getNameLength 方法，私有，必须设置可访问行
        getNameLengthMethod.setAccessible(true);
        // 调用 getNameLength 方法：方法、那个对象调用该方法
        System.out.println("nameLength="+getNameLengthMethod.invoke(book));



    }
}
