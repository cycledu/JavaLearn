package java8.MultypleThread.Charper3.TwoThreadTransData.extthread;


import java8.MultypleThread.Charper3.TwoThreadTransData.mylist.MyList;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/22:32
 * @Description :
 * @Page or WebSite：P189
 * @Expected result ：
 */
public class ThreadB extends Thread{
    private MyList list;
    public ThreadB(MyList list){
        super();
        this.list=list;
    }
    @Override
    public void run() {
        try{
            while (true){
                Thread.sleep(2000);
                if (list.size()==5){
                    System.out.println("==5了，线程B要退出了");
                    System.out.println("exit");
                    throw new InterruptedException();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
