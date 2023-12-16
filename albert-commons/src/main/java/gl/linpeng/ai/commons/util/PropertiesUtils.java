package gl.linpeng.ai.commons.util;

/**
 * 配置工具类
 */
public class PropertiesUtils {

    // 从文件加载配置，转成properties对象
    public static java.util.Properties loadProperties(String fileName) {
        java.util.Properties properties = new java.util.Properties();
        try {
            properties.load(new java.io.FileInputStream(fileName));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
