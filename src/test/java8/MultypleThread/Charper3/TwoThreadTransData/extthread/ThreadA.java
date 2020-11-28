package java8.MultypleThread.Charper3.TwoThreadTransData.extthread;


import java8.MultypleThread.Charper3.TwoThreadTransData.mylist.MyList;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/22:32
 * @Description :
 * @Page or WebSite：P189
 * @Expected result ：
 */
public class ThreadA extends Thread{
    private MyList list;
    public ThreadA(MyList list){
        super();
        this.list=list;
    }
    @Override
    public void run() {
        try{
            for (int i = 0; i < 10; i++) {
                list.add();
                System.out.println("添加了"+(i+1)+"个元素");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
