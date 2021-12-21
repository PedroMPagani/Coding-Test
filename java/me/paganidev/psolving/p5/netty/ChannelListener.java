package me.paganidev.psolving.p5.netty;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import net.minecraft.network.protocol.game.PacketPlayInSteerVehicle;
import org.bukkit.Bukkit;

import java.util.logging.Level;

public class ChannelListener extends ChannelDuplexHandler {


    private String name;


    @Override
    public void write(ChannelHandlerContext a, Object b, ChannelPromise c) throws Exception {
        Bukkit.getLogger().log(Level.INFO,"Server sent a packet: " + b.getClass().getName() + "to player " + name);
        super.write(a, b, c);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof PacketPlayInSteerVehicle e){
            Bukkit.getLogger().log(Level.INFO,"User " + name + " sent a Steer packet to the server!");
        }
        super.channelRead(ctx, msg);
    }

    public void setName(String name) {
        this.name = name;
    }
}