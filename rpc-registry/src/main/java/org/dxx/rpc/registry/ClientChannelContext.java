/**
 * ChannelContext.java
 * org.dxx.rpc.registry
 * Copyright (c) 2014, 北京微课创景教育科技有限公司版权所有.
*/

package org.dxx.rpc.registry;

import io.netty.channel.Channel;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * 
 * @author   dixingxing
 * @Date	 2014年7月15日
 */

public class ClientChannelContext {
	private static List<Channel> channels = new CopyOnWriteArrayList<Channel>();

	public static List<Channel> allChannels() {
		return channels;
	}

	public static boolean remove(Channel c) {
		return channels.remove(c);
	}

	public static void add(Channel c) {
		channels.add(c);
	}
}