package com.config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/**
 * ���ܽ��ܣ��˽ӿڵ�ʵ���������Ŀ����ʱ�Զ�����
 * �������ɨ������socketע�ⷽʽ/�ӿڷ�ʽ��������-����˳���(�����ң� return��ȥscanned
 * @author Leo
 *
 */
public class CharConfig implements ServerApplicationConfig {

	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
		System.out.println("111111111"+scanned.size());
		return scanned;
	}

	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		return null;
	}

}
