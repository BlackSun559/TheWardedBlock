package com.blacksun559.thewardedblock.item;

import com.blacksun559.thewardedblock.reference.Names;
import com.blacksun559.thewardedblock.util.ItemHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import scala.Console;

public class ItemWardBrush extends ItemTWB
{
    public ItemWardBrush()
    {
        super();
        this.setUnlocalizedName(Names.Items.WARD_BRUSH);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {

        // Checks for a owner of the item and assigns it if it doesn't have one.
        if (!world.isRemote) {
            if (!ItemHelper.hasOwnerUUID(itemStack)) {
                ItemHelper.setOwner(itemStack, entityPlayer);
            }
        }

        // Returns the itemStack that was right clicked
        return itemStack;
    }
}


