package java8.MultypleThread.Charper3.Stack_50.set;


import java8.MultypleThread.Charper3.Stack_50.tools.Box;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/12:36
 * @Description :
 * @Page or WebSite：P243
 * @Expected result ：
 */
public class SetService {
    private Box box;
    public SetService(Box box) {
        this.box = box;
    }
    public void setMethod(){
        try {
            synchronized (this){
                while (box.size()==50){
                    System.out.println("⚫⚫⚫⚫⚫");
                    this.wait();
                }
            }
            Thread.sleep(300);
            box.add();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void checkBoxStatus(){
        try{
            while (true){
                synchronized (this){
                    if (box.size()<50){
                        this.notifyAll();
                    }
                }
                System.out.println("set checkboxBox="+box.size());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
