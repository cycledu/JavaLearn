package DesignPattern.ChainOfResponsibility;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/20:42
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
//请求类
public class PurchaseRequest {

    private int type = 0; //请求类型
    private float price = 0.0f; //请求金额
    private int id = 0;
    public PurchaseRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }
    //构造器
    public PurchaseRequest() {
        this.type = type;
        this.price = price;
        this.id = id;
    }
    public int getType() {
        return type;
    }
    public float getPrice() {
        return price;
    }
    public int getId() {
        return id;
    }
}
