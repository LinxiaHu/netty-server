package com.hd.netty.simplechat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
 
/**
 * 客户端 channel
 * 
 */
public class SimpleChatClientHandler extends  SimpleChannelInboundHandler<String> {
	// @Override
	// protected void channelRead0(ChannelHandlerContext ctx, String s) throws
	// Exception {
	// System.out.println(s);
	// }

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, String msg)
			throws Exception {
		System.out.println(msg);
	}
}
