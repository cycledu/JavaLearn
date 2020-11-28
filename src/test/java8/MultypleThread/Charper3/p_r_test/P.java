package java8.MultypleThread.Charper3.p_r_test;

/**
 * @Author : jingtao
 * @Data : 2020/05/02/21:03
 * @Description :
 * @Page or WebSite：P224
 * @Expected result ：
 */
public class P {
    private String lock;
    public P(String lock){
        this.lock=lock;
    }
    public void setValue(){
        try{
            synchronized (lock){
                if (!ValueObject.value.equals(""))
                    lock.wait();
                String value=System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("set的值时"+value);
                ValueObject.value=value;
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
