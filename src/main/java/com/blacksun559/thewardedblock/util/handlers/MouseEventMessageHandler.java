package com.blacksun559.thewardedblock.util.handlers;

import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.network.MouseEventMessage;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MouseEventMessageHandler implements IMessageHandler<MouseEventMessage, IMessage>
{
    @Override
    public IMessage onMessage(MouseEventMessage message, MessageContext ctx)
    {
        EntityPlayerMP serverPlayer = ctx.getServerHandler().player;

        int dWheel = message.getdWheel();

        serverPlayer.getServerWorld().addScheduledTask(() -> {
            if(serverPlayer.getHeldItem(serverPlayer.getActiveHand()).getItem() == ModItems.ITEM_DEBUG && serverPlayer.isSneaking())
            {
                System.out.println("detected");
            }
        });

        return null;
    }
}
