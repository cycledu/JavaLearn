package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/10/11:29
 * @Description :
 * @Page or WebSite：P212/练习26
 * @Expected result ：
 */

public class Test26 {
    class Outer {
        class Inner {
            private int i;
            public Inner(int i) {
                this.i = i;
            }
        }
    }
    class Other {
        public Other() {
        }
        class OtherInner extends Outer.Inner {

            public OtherInner(Outer outer, int i) {
                outer.super(i);
            }
        }
    }
}
