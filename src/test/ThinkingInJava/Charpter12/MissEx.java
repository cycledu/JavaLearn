package ThinkingInJava.Charpter12;

/**
 * @Author : jingtao
 * @Data : 2020/04/01/23:50
 * @Description :异常丢失
 * @Page or WebSite：268
 * @Expected result ：
 */
public class MissEx {
    void f() throws exA {
        throw new exA();
    }

    void g() throws exB {
        throw new exB();
    }

    public static void main(String[] args) {
        try {
            MissEx missEx = new MissEx();
            try{
                missEx.f();
            }finally {
                missEx.g();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

class exA extends Exception {
    @Override
    public String toString() {
        return "A is very important exception";
    }
}

class exB extends Exception {
    @Override
    public String toString() {
        return "B is normal Exception";
    }
}

