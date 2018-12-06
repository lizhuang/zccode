package com.example.zccode.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamUtil {
    private static XStream xStream;

    //JVM加载类时会执行这些静态的代码块，如果static代码块有多个，JVM将按照它们在类中出现的先后顺序依次执行它们，每个代码块只会被执行一次。
    static{
        xStream = new XStream(new DomDriver());
        xStream.autodetectAnnotations(true);
        /*
         * 使用xStream.alias(String name, Class Type)为任何一个自定义类创建到类到元素的别名
         * 如果不使用别名，则生成的标签名为类全名
         */
    }

    /**
     * java对象转xml
     * @param obj
     * @return
     */
    public static String beanToXml(Object obj){
        StringBuffer stringBuffer = new StringBuffer();
        //java换行
        String str = System.getProperty("line.separator");
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(str).append(xStream.toXML(obj));
        return stringBuffer.toString();
    }

    public static <T> T xmlToBean(String xml, Class<T> clazz) {
       xStream.processAnnotations(clazz);
       Object object = xStream.fromXML(xml);
       T cast = clazz.cast(object);
       return cast;
   }


}
