import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// 解析 LinkedList 类内的信息
public class GetArrayListDetails {

    public static void main(String[] args) throws ClassNotFoundException {
        // 0. 获取 类 类型  ===  获取一个具体的类《LinkedList》
//        Class<LinkedList> x = LinkedList.class;
//        LinkedList list = null;
//        Class<? extends LinkedList> x = list.getClass();
        Class<?> clazz = Class.forName("java.util.ArrayList");

        // 1. 解析类 === 获取类的信息
        // 取包名
        Package pkg = clazz.getPackage();
        String pkgName = pkg.getName();
        System.out.println(pkgName);
        // 获取访问修饰符
        int mod = clazz.getModifiers();
        String modStr = Modifier.toString(mod);
        if (Modifier.isInterface(mod))
            System.out.println(modStr); // 输出 public interface
        else
            System.out.println(modStr + " class ");
        // 获取类名
        String className = clazz.getSimpleName();
        System.out.println(className);
        // 获取父类
        Class<?> supClz = clazz.getSuperclass();
        if (supClz != null)
            System.out.println(" extends " + supClz.toGenericString());
        // 获取接口(s)
        Class<?>[] ifs = clazz.getInterfaces();
        if (ifs != null && ifs.length != 0){
            System.out.println(" implements ");
            for (Class<?> ifName : ifs)
                System.out.println(" " + ifName.toGenericString() + " ");
        }
        // 获取属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            //field.getModifiers()
            //Class<?> fieldType = field.getType();
            //String fieldName = field.getName();
        }
        // 获取方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            //method.getModifiers()
            //Class<?> returnType = method.getReturnType();
            //String methodName = method.getName();
            //Class<?>[] pts = method.getParameterTypes();
            //Class<?>[] ets = method.getExceptionTypes();
        }
        // 获取构造方法
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            // 类似 方法
        }
        Class<?> outClz = clazz.getDeclaringClass();
        Class<?>[] innerClz = clazz.getDeclaredClasses();
    }
}
