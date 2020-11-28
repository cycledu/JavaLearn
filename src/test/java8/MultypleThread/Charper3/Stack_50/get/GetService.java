package java8.MultypleThread.Charper3.Stack_50.get;


import java8.MultypleThread.Charper3.Stack_50.tools.Box;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/12:44
 * @Description :
 * @Page or WebSite：P245
 * @Expected result ：
 */
public class GetService {
    private Box box;
    public GetService(Box box) {
        this.box = box;
    }
    public void getMethod(){
        try {
            synchronized (this){
                while (box.size()==0){
                    System.out.println("⚪⚪⚪⚪⚪");
                    this.wait();
                }
                box.popFirst();
            }
            Thread.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void checkBoxStatus(){
        try {
            while (true){
                synchronized (this){
                    if (box.size()>0){
                        this.notifyAll();
                    }
                }
                System.out.println("get checkboxBox="+box.size());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
