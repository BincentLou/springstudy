package sun.net.www.protocol.x;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * @version $Id: null.java, v 1.0 2020/7/26 8:49 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义X开头的文件URL协议
 * @since 1.0
 **/
public class Handler extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new XUrlConnection(u);
    }
}
