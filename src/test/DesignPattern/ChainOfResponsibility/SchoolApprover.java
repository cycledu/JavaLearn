package DesignPattern.ChainOfResponsibility;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/20:51
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class SchoolApprover extends Approver {
    public SchoolApprover(String name) {
        super(name);
    }
    @Override
    public void handleRequest(PurchaseRequest purchaseRequest) {
        System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
    }
}
