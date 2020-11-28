package DesignPattern.ChainOfResponsibility;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/20:50
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class CollageApprover extends Approver {
    public CollageApprover(String name) {
        super(name);
    }
    @Override
    public void handleRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() >= 3000 && purchaseRequest.getPrice() < 5000) {
            System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
        } else {
            System.out.println(this.name+"无权审批，交由上一级进行审批");
            approver.handleRequest(purchaseRequest);
        }
    }
}
