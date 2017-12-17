package com.blacksun559.thewardedblock.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemWardBrush extends ItemTWB
{
    public ItemWardBrush(String name)
    {
        super(name);
        this.setMaxDamage(250);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if(!world.isRemote)
        {
            ItemStack stack = player.getHeldItem(hand);
            NBTTagCompound nbt = stack.getTagCompound();
            String key = "wardTWB";
            if(nbt == null)
            {
                nbt = new NBTTagCompound();
            }

            if(nbt.hasKey(key))
            {
                int ward = nbt.getInteger(key);

                if(player.isSneaking())
                {
                    if(ward < 15)
                    {
                        nbt.setInteger(key, ward + 1);
                    }
                    else
                    {
                        nbt.setInteger(key, 0);
                    }
                }

                player.sendMessage(new TextComponentString("Ward: " + nbt.getInteger(key)));
            }
            else if(!nbt.hasKey(key))
            {
                nbt.setInteger(key, 0);
                player.sendMessage(new TextComponentString("Ward: 0"));
            }

            stack.setTagCompound(nbt);
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}
