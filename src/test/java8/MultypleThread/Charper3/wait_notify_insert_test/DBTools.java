package java8.MultypleThread.Charper3.wait_notify_insert_test;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/13:46
 * @Description :
 * @Page or WebSite：P256
 * @Expected result ：
 */
public class DBTools {
    volatile private boolean prevIsA=false;
    synchronized public void buckupA(){
        try {
            while (prevIsA==true){
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("★★★★★");
            }
            prevIsA=true;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    synchronized public void buckupB(){
        try{
            while (prevIsA=false){
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("☆☆☆☆☆");
            }
            prevIsA=false;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
