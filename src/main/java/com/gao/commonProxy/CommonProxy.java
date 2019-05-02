package com.gao.commonProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommonProxy {

    public static Object newProxyInstance(Class intfce, InvocationHandler h) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String rt = "\r\t";
        String methodStr = "";
        for (Method method : intfce.getMethods ()) {
//            引入包名
            methodStr += "@Override" + rt + " public void" + method.getName () + "(){" + rt
//
                    + "try{" + rt
//
                    + "Method md=" + intfce.getName () + ".class.getMethod(\"" + method.getName () + "\");" + rt
//
                    + "h.invoke(this,md);" + rt
//
                    + "}catch(Exception e){" + rt
//
                    + "   e.printStackTrace ();\n" + rt
//
                    + "}" + " }";
//            导入类名依赖
        }

        String str = "package com.gao.commonProxy;\n" + rt
                //
                + "\n" + "import java.lang.reflect.Method;\n" + rt
                //
                + "\n" + " import com.gao.commonProxy.InvocationHandler;\n" + rt
                //
                + "\n" + "public class $Proxy0 implements " + intfce.getName () + " {\n" + rt
//
                + "    private InvocationHandler h;\n" + "\n" + rt
                //
                + "    public  $Proxy0(InvocationHandler h) {\n" + rt +
                //
                "        this.h = h;\n" + rt
                //
                + "    }\n" + "\n" + rt
//
                + methodStr + rt
                //
                + "}\n";


        ClassLoader cl = ClassLoader.getSystemClassLoader ();
        Class<?> aClass = cl.loadClass ("");
        Constructor<?> constructor = aClass.getConstructor (InvocationHandler.class);

        return constructor.newInstance (h);
    }
}
