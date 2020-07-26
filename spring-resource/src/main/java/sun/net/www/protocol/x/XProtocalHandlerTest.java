package sun.net.www.protocol.x;


import org.apache.commons.io.IOUtils;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.nio.charset.Charset;

/**
 * @version $Id: null.java, v 1.0 2020/7/26 8:59 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:简易的实现自定义 文件协议
 * 1：新建协议处理器。路径遵循规定 必须sun.net.www.protocal.x.Handler
 * 2: 创建x协议的 URLConnection
 * 3: 使用测试用例获取 inputStream 输出
 * @see URLStreamHandler
 * @see Handler
 * @see XUrlConnection
 * @since 1.0
 **/
public class XProtocalHandlerTest {

    static String protocalPrefix = "x://";

    static String filePath = "/META-INF/config.properties";

    public static void main(String[] args) throws IOException {
        URL url = new URL(protocalPrefix+filePath);
        URLConnection urlConnection =  url.openConnection();
        Reader reader = new InputStreamReader(urlConnection.getInputStream());
        System.out.println(StreamUtils.copyToString(urlConnection.getInputStream(), Charset.forName("UTF-8")));
        IOUtils.toString(reader);
    }
}
