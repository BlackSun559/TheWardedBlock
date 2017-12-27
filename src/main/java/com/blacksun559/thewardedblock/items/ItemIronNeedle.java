package com.blacksun559.thewardedblock.items;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.capabilties.warded.CapabilityEntityWarded;
import com.blacksun559.thewardedblock.capabilties.warded.IWarded;
import com.blacksun559.thewardedblock.items.Base.ItemTWB;
import com.blacksun559.thewardedblock.util.PlayerUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemIronNeedle extends ItemTWB
{
    private final int MESSAGE_WARD = TheWardedBlock.getMessageID();

    public ItemIronNeedle(String name)
    {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        wardEntity(world, player, null);

        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target, EnumHand hand)
    {
        if(!player.getEntityWorld().isRemote)
        {
            wardEntity(player.getEntityWorld(), player, target);
        }

        return true;
    }

    private void wardEntity(World world, EntityPlayer player, EntityLivingBase entity)
    {
        if(!world.isRemote)
        {
            EntityLivingBase target;
            final IWarded warded;

            if(entity == null)
            {
                target = player;
                warded = CapabilityEntityWarded.getWards(player);
            }
            else
            {
                target = entity;
                warded = CapabilityEntityWarded.getWards(entity);
            }

            PlayerUtils.messageOnce(MESSAGE_WARD, new TextComponentTranslation(target.getName() + " has been warded."));
            warded.addWard(1);
        }
    }
}
