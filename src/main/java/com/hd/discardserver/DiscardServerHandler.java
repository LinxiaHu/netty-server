package com.hd.discardserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class DiscardServerHandler extends ChannelHandlerAdapter implements
		ChannelHandler {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		((ByteBuf)msg).release();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
