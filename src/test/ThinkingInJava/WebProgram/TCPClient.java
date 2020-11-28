package ThinkingInJava.WebProgram;

import java.io.*;
import java.net.Socket;

/**
 * @Author : jingtao
 * @Data : 2020/06/26/16:42
 * @Description : 文件上传案例：客户端
 * @Page or WebSite：
 * @Expected result ：
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1、创建本地字节输入流
        FileInputStream fis = new FileInputStream("C:\\Users\\jingtao\\Pictures\\Inked宫格图_LI.jpg");
        //2、创建客户端Socket对象
        Socket socket = new Socket("127.0.0.1", 8888);
        //3、使用socket的getOutputStream，获取网络字节输出流
        OutputStream ops = socket.getOutputStream();
        //4、使用本地字节输入流的read读取数据
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            //5、使用网络字节输出流的写方法写字节数据
            ops.write(bytes, 0, len);
        }
        /**
         * 解决：上传完文件，给服务器一个结束标记
         * 对于TCP套接字，任何以前写入的数据都将被发送，并且后跟TCP的正常连接终止序列
         */
        socket.shutdownOutput();
        //6、使用Socket的getInputStream获取网络字节输入流
        InputStream is = socket.getInputStream();
        //7、读取客户端获取的网络字节输入流中的数据
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //8、关闭资源
        fis.close();
        socket.close();

    }
}
