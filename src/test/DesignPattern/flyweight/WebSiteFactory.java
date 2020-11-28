package DesignPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class WebSiteFactory {
	// ���ϣ��䵱�ص�����
	private Map<String, ConcreteWebSite> pool = new HashMap<String, ConcreteWebSite>();

	// ������վ�����ͣ�����һ����վ�����û�оʹ���һ����վ�������뵽���У�������
	public WebSite getWebSiteCategory(String type) {
		if (!pool.containsKey(type)) {
			pool.put(type, new ConcreteWebSite(type));
		}
		return (WebSite) pool.get(type);
	}

	// ��ȡ��վ����������������ж��ٸ���վ���ͣ�
	public int getWebSiteCount() {
		return pool.size();
	}
}
