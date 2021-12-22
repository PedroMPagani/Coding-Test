package me.paganidev.psolving.p5.handlers;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import me.paganidev.psolving.p5.Plugin;
import me.paganidev.psolving.p5.netty.ChannelListener;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinHandler implements Listener {

    private Plugin plugin;
    public JoinHandler(Plugin instance){
        this.plugin = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Channel channel = ((CraftPlayer)player).getHandle().b.a.k;
        ChannelPipeline pipeline = channel.pipeline();
        if (pipeline.get("PacketListener") != null) return;// already listening ??
        ChannelListener channelListener;
        pipeline.addAfter("encoder", "PacketListener", channelListener = new ChannelListener());
        channelListener.setName(player.getName());
    }

}