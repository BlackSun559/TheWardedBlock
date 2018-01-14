package com.blacksun559.thewardedblock.util;

import com.blacksun559.thewardedblock.network.PacketPlayerMessage;
import com.blacksun559.thewardedblock.network.TWBPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlayerUtils
{
    @SideOnly(Side.CLIENT)
    public static void messageOnce(int messageID, ITextComponent message)
    {
        final GuiNewChat chat = Minecraft.getMinecraft().ingameGUI.getChatGUI();
        chat.printChatMessageWithOptionalDeletion(message, messageID);
    }

    public static void sendMessage(int messageID, String message, EntityPlayerMP playerMP)
    {
        PacketPlayerMessage playerMessage = new PacketPlayerMessage(messageID, message);
        TWBPacketHandler.sendTo(playerMP, playerMessage);
    }
}
