package DesignPattern.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    // ά��һ��Ŀ�����
    private Object target;

    // ������������һ���������
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // ����һ�����������target����Ĵ������
    public Object getProxyInstance() {
        // 1.����һ��������
        Enhancer enhancer = new Enhancer();
        // 2.���ø���
        enhancer.setSuperclass(target.getClass());
        // 3.���ûص�����
        enhancer.setCallback(this);
        // 4.����������󣬼��������
        return enhancer.create();
    }

    //��дintecepter�����������Ŀ�����ķ���
    @Override
    public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
        System.out.println("cglib����ģʽ");
        Object returnValue = method.invoke(target, args);
        System.out.println("cglib���");
        return returnValue;
    }

}

