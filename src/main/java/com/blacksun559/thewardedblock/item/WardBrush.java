package com.blacksun559.thewardedblock.item;

import com.blacksun559.thewardedblock.reference.Names;
import com.blacksun559.thewardedblock.util.ItemHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
public class WardBrush extends ItemTWB
{
    public WardBrush()
    {
        super();
        this.setUnlocalizedName(Names.Items.WARD_BRUSH);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        if(!world.isRemote)
        {
            if(!ItemHelper.hasOwnerUUID(itemStack))
            {
                ItemHelper.setOwner(itemStack, entityPlayer);
            }
        }

        return itemStack;
    }
}
