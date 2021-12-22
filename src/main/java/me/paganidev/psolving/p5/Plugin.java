package me.paganidev.psolving.p5;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import me.paganidev.psolving.p5.handlers.JoinHandler;
import me.paganidev.psolving.p5.netty.ChannelListener;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new JoinHandler(this),this);
        injectOnlineUsers();
    }

    public void injectOnlineUsers(){
        for (Player player : Bukkit.getOnlinePlayers()) {
            Channel channel = ((CraftPlayer)player).getHandle().b.a.k;
            ChannelPipeline pipeline = channel.pipeline();
            if (pipeline.get("PacketListener") != null) return;// already listening ??
            ChannelListener channelListener;
            pipeline.addAfter("encoder", "PacketListener", channelListener = new ChannelListener());
            channelListener.setName(player.getName());
        }
    }

}