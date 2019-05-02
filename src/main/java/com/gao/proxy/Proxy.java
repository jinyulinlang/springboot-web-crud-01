package com.gao.proxy;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class Proxy {
    public static Object newProxyInstance(Class infce) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
// 获取接口中的方法！
        String methodStr = "";
        for (Method method : infce.getMethods ()) {
            methodStr += "    @Override\n" + "\r"  //
                    + "    public void " + method.getName () + "() {\n" + "\r"  //
                    + "        long startTime = System.currentTimeMillis ();\n" + "\r"  //
                    + "        System.out.println (\"汽车开始行行驶\");\n"  //
                    + "        moveAble." + method.getName () + " ();\n"  //
                    + "        long endTime = System.currentTimeMillis ();\n" + "        " + "\r"  //
                    + "System.out.println (\"汽车结束行驶-----，汽车行驶时间:\" + (endTime - startTime) + \"毫秒！\");\n" + "\n"  //
                    + "    }\n" + "\r";  //

        }
//        1声明一段源码
        String sourceString = "package com.gao.proxy;\n" + "\n" + "\r" + "public class $Proxy0 implements " + infce.getName () + " {\n" + "\r"  //
                + "    private " + infce.getName () + " moveAble;\n" + "\n" + "\r"     //
                + "    public $Proxy0 (" + infce.getName () + " moveAble) {\n" + "\r"  //
                + "        this.moveAble = moveAble;\n" + "\r"  //
                //
                + "    }\n" + methodStr + "}\n";   //

//定义文件的路径
        String fileName = System.getProperty ("user.dir") + "/target/classes/com/gao/proxy/$Proxy0.java";
        File file = new File (fileName);
        FileUtils.writeStringToFile (file, sourceString);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler ();
        StandardJavaFileManager standardFileManager = compiler.getStandardFileManager (null, null, Charset.defaultCharset ());

        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects (fileName);
        JavaCompiler.CompilationTask task = compiler.getTask (null, standardFileManager, null, null, null, javaFileObjects);
        task.call ();
        standardFileManager.close ();

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader ();
        Class<?> aClass = systemClassLoader.loadClass ("com.gao.proxy.$Proxy0");
        Constructor<?> constructor = aClass.getConstructor (infce);


        System.out.println ("生成完毕");
        return constructor.newInstance (new Car ());

    }

    public static void main(String[] args) {
        System.out.println (System.getProperty ("user.dir"));
    }
}
