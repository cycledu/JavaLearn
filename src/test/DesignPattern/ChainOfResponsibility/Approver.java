package DesignPattern.ChainOfResponsibility;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/20:42
 * @Description :
 * @Page or WebSite��
 * @Expected result ��
 */
public abstract class Approver {

    Approver approver;//�¸�������
    String name;//�����ߵ�����
    public Approver(String name) {
        this.name = name;
    }
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void handleRequest(PurchaseRequest purchaseRequest);
}
