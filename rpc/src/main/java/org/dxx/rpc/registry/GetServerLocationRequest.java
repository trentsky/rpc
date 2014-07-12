package org.dxx.rpc.registry;

import org.dxx.rpc.AbstractRequest;

/**
 * 根据接口名获取服务端的地址，以及此服务端提供的其它服务（接口）。
 * 若客户端恰好调用服务端提供的其它接口，那么就不必再重新创建连接了。
 * 
 * @author   dixingxing
 * @Date	 2014年7月11日
 * @see GetServerLocationResponse
 */
@SuppressWarnings("serial")
public class GetServerLocationRequest extends AbstractRequest {
	private String interfaceClass;

	public String getInterfaceClass() {
		return interfaceClass;
	}

	public void setInterfaceClass(String interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LocateRpcServerRequest [interfaceClass=" + interfaceClass + "]";
	}

}