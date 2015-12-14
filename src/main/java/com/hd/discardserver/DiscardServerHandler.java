package com.hd.discardserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelHandlerAdapter implements
		ChannelHandler {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		((ByteBuf)msg).release();
		try {
			ByteBuf in = (ByteBuf)msg;
			while(in.isReadable()) {
				System.out.println((char)in.readByte());
				System.out.flush();
			}
		} finally {
			//必须显示地调用
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
