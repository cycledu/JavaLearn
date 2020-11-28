package ThinkingInJava.WebProgram;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @Author : jingtao
 * @Data : 2020/06/26/16:53
 * @Description :上传文件的服务端
 * 数据源：客户端上传的文件
 * 目的地：服务器的硬盘：C:\\Users\\jingtao\\Pictures\\uplload\\1.jpg
 * @Page or WebSite：
 * @Expected result ：
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1、创建服务器ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //2、使用accpet方法，获取请求的客户端的Socket对象

        /**
         * 让服务器一直处于监听状态
         * 不用关闭服务器，将以下所有代码都放在为true的while循环中
         * 使用多线程：将以下代码全部放进run方法中
         */

        Socket socket = serverSocket.accept();
        //3、获取socket中的网络字节输入流
        InputStream is = socket.getInputStream();
        //4、判断文件是否存在，不存在就创建
        File file = new File("C:\\Users\\jingtao\\Pictures\\uplload");
        if (!file.exists())
            file.mkdirs();
        /**
         * 自定义文件命名规则，防止同名文件覆盖
         */
        String filename=System.currentTimeMillis()+new Random().nextInt(46446)+"";
        //5、创建本地字节输出流
        FileOutputStream fos = new FileOutputStream(file + "\\"+filename);
        //6、使用网络字节输入流的read，读取上传的数据
        int len=0;
        byte[] bytes = new byte[1024];
        while ((len=is.read(bytes))!=-1){
            //7、使用本地字节输出流将数据写到服务器的硬盘上
            fos.write(bytes,0,len);
        }
        //8、使用socket的getOutputStream获取网络字节输出流
        //9、向客户端回送数据
        socket.getOutputStream().write("上传成功".getBytes());
        //10、关闭资源
        fos.close();
        socket.close();
        serverSocket.close();

    }
}
