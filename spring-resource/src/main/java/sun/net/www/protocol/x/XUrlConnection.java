package sun.net.www.protocol.x;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @version $Id: null.java, v 1.0 2020/7/26 8:54 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:简单的实现 URLConnection
 *
 * @see URLConnection
 * @see ClassPathResource
 * @since 1.0
 **/
public class XUrlConnection extends URLConnection {

    private URL url;

    private ClassPathResource classPathResource;

    public XUrlConnection(URL url) {
        super(url);
        this.url = url;
        classPathResource = new ClassPathResource(url.getPath());
    }

    @Override
    public void connect() throws IOException {
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return classPathResource.getInputStream();
    }
}
