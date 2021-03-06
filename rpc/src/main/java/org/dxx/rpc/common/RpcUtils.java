/**
 * RpcUtils.java
 * org.dxx.rpc
 * Copyright (c) 2014, 北京微课创景教育科技有限公司版权所有.
*/

package org.dxx.rpc.common;

import org.dxx.rpc.EchoService;
import org.dxx.rpc.client.Clients;
import org.dxx.rpc.config.RpcServerConfig;
import org.dxx.rpc.config.loader.Loader;
import org.dxx.rpc.exception.RpcException;
import org.dxx.rpc.server.ServerStartup;
import org.dxx.rpc.server.Servers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工具类
 * 
 * @author   dixingxing
 * @Date	 2014-6-18
 */

public class RpcUtils {
	private static final Logger logger = LoggerFactory.getLogger(RpcUtils.class);

	private static boolean running = false;

	private static long startTime;

	/**
	 * 启动RPC
	 * <p>
	 *
	 * @return
	 */
	public static void startup() {
		if (running) {
			logger.debug("Rpc is already running!");
			return;
		}
		running = true;
		long start = System.currentTimeMillis();
		RpcServerConfig c = Loader.getRpcConfig().getRpcServerConfig();

		if (c.getApp() == null || c.getApp().trim().isEmpty()) {
			throw new RpcException("RpcConfig.xml -> \"server\" is not complete : \"app\" attribute is empty!");
		}

		Servers.init(c.getPackages());
		Clients.init();

		new ServerStartup(c.getPort()).startup();
		startTime = System.currentTimeMillis();
		logger.debug("Rpc is running! cost {} ms", System.currentTimeMillis() - start);
	}

	/**
	 * 获取接口的代理类。调用代理类的方法会相应的调用远程服务类的方法。
	 * <p>
	 *
	 * @param interfaceClass
	 * @return 
	 */
	public static <T> T get(Class<T> interfaceClass) {
		return Clients.getRpcProxy(interfaceClass);
	}

	/**
	 * 回声，用于检测客户端与服务端的通信是否正常
	 *
	 * @param interfaceClass 需要测试的接口类
	 * @param src 原始字符串
	 * @return 如果与服务端的通信正常，那么会返回原始字符串（src）。
	 */
	public static String echo(Class<?> interfaceClass, String src) {
		return ((EchoService) get(interfaceClass)).echo$$$(src);
	}

	public static long getStartTime() {
		return startTime;
	}

}
