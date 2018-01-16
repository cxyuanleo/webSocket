package com.config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/**
 * 功能介绍：此接口的实现类会在项目启动时自动启动
 * 启动后会扫描所有socket注解方式/接口方式的配置类-服务端程序(聊天室） return回去scanned
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
