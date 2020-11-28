package DesignPattern.ChainOfResponsibility;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/20:50
 * @Description :
 * @Page or WebSite��
 * @Expected result ��
 */
public class CollageApprover extends Approver {
    public CollageApprover(String name) {
        super(name);
    }
    @Override
    public void handleRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() >= 3000 && purchaseRequest.getPrice() < 5000) {
            System.out.println(" ������ id= " + purchaseRequest.getId() + " �� " + this.name + " ����");
        } else {
            System.out.println(this.name+"��Ȩ������������һ����������");
            approver.handleRequest(purchaseRequest);
        }
    }
}
