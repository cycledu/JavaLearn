package DesignPattern.ChainOfResponsibility;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/20:46
 * @Description :
 * @Page or WebSite���ü���ֻ����С��3000������
 * @Expected result ��
 */
public class DepartmentApprover extends Approver {
    public DepartmentApprover(String name) {
        super(name);
    }
    @Override
    public void handleRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() < 3000) {
            System.out.println(" ������ id= " + purchaseRequest.getId() + " �� " + this.name + " ����");
        } else {
            System.out.println(this.name+"��Ȩ������������һ����������");
            approver.handleRequest(purchaseRequest);
        }
    }
}
