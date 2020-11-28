package DesignPattern.ChainOfResponsibility;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/20:52
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class Client {
    public static void main(String[] args) {
        //创建需要被审批的请求，或者需要执行的事件
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 5700, 1);

        //创建各级审批的层级
        SchoolApprover school = new SchoolApprover("学校");
        CollageApprover collage = new CollageApprover("学院");
        DepartmentApprover department = new DepartmentApprover("部门");

        //设置审批的层级关系
        department.setApprover(collage);
        collage.setApprover(school);

        //开始审批流程
        department.handleRequest(purchaseRequest);
    }
}
