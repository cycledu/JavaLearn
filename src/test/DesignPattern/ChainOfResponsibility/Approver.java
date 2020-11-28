package DesignPattern.ChainOfResponsibility;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/20:42
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public abstract class Approver {

    Approver approver;//下个处理者
    String name;//处理者的名称
    public Approver(String name) {
        this.name = name;
    }
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void handleRequest(PurchaseRequest purchaseRequest);
}
