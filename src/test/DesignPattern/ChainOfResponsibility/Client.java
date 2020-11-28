package DesignPattern.ChainOfResponsibility;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/20:52
 * @Description :
 * @Page or WebSite��
 * @Expected result ��
 */
public class Client {
    public static void main(String[] args) {
        //������Ҫ�����������󣬻�����Ҫִ�е��¼�
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 5700, 1);

        //�������������Ĳ㼶
        SchoolApprover school = new SchoolApprover("ѧУ");
        CollageApprover collage = new CollageApprover("ѧԺ");
        DepartmentApprover department = new DepartmentApprover("����");

        //���������Ĳ㼶��ϵ
        department.setApprover(collage);
        collage.setApprover(school);

        //��ʼ��������
        department.handleRequest(purchaseRequest);
    }
}
