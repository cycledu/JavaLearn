package DesignPattern.template;

public class Client {
    public static void main(String[] args) {
        System.out.println("-----------�����춹����--------------");
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();
        System.out.println("------------������������-------------");
        SoyaMilk peanutSoyMilk = new PeanutSoyMilk();
        peanutSoyMilk.make();
    }
}
