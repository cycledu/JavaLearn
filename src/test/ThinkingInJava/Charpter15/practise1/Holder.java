package ThinkingInJava.Charpter15.practise1;

/**
 * @Author : jingtao
 * @Data : 2020/05/13/21:46
 * @Description :
 * @Page or WebSite：P354/练习2
 * @Expected result ：
 */
class One {
}
class Two {
}
class Three {
}
class subOne{}
public class Holder<T, H, W> {
    public T one;
    public H two;
    public W three;
    public Holder(T one, H two, W three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }
    public T getOne() {
        return one;
    }
    public void setOne(T one) {
        this.one = one;
    }
    public H getTwo() {
        return two;
    }
    public void setTwo(H two) {
        this.two = two;
    }
    public W getThree() {
        return three;
    }
    public void setThree(W three) {
        this.three = three;
    }
    public static void main(String[] args) {
        Holder<One, Two, Three> subOneTwoThreeHolder = new Holder<>(new One(), new Two(), new Three());
        Holder<Three, subOne, subOne> threesubOnesubOneHolder = new Holder<>(new Three(), new subOne(), new subOne());

    }
}
