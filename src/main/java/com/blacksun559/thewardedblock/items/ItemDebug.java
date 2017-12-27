package com.blacksun559.thewardedblock.items;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.capabilties.eaten.CapabilityEaten;
import com.blacksun559.thewardedblock.capabilties.eaten.IEaten;
import com.blacksun559.thewardedblock.capabilties.warded.CapabilityEntityWarded;
import com.blacksun559.thewardedblock.capabilties.warded.IWarded;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.items.Base.ItemTWB;
import com.blacksun559.thewardedblock.tileentity.TileEntityWard;
import com.blacksun559.thewardedblock.util.PlayerUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemDebug extends ItemTWB
{
    private final int MESSAGE_EATEN_RESET = TheWardedBlock.getMessageID();
    private final int MESSAGE_GET_EATEN = TheWardedBlock.getMessageID();
    private final int MESSAGE_CLEAR_WARDS = TheWardedBlock.getMessageID();
    private final int MESSAGE_GET_WARDS= TheWardedBlock.getMessageID();
    private final int MESSAGE_NO_WARDS = TheWardedBlock.getMessageID();

    public ItemDebug(String name)
    {
        super(name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            TileEntity tileEntity = world.getTileEntity(pos);

            if(tileEntity != null && tileEntity instanceof TileEntityWard)
            {
//                tileEntity;
            }
        }

        return EnumActionResult.SUCCESS;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
    {
        if(!entityLiving.getEntityWorld().isRemote && entityLiving.isSneaking())
        {
            if(entityLiving.getHeldItemMainhand().getItem() == ModItems.ITEM_DEBUG)
            {
                NBTTagCompound nbt = stack.getTagCompound();
                String key = "debug_type";

                if(nbt == null)
                {
                    nbt = new NBTTagCompound();
                }

                if(nbt.hasKey(key))
                {
                    int type = nbt.getInteger(key);
                    nbt.setInteger(key, type + 1);
                }
                else
                {
                    nbt.setInteger(key, 1);
                }

                stack.setTagCompound(nbt);
            }
        }
        return super.onEntitySwing(entityLiving, stack);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target, EnumHand hand)
    {
        if(!player.getEntityWorld().isRemote)
        {
            debugPlayerWards(player.getEntityWorld(), player, target, hand);
        }

        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if(!world.isRemote)
        {
            String key = "debug_type";
            int type = 0;

            ItemStack stack = player.getHeldItem(hand);
            NBTTagCompound nbt = stack.getTagCompound();

            if(nbt == null)
            {
                nbt = new NBTTagCompound();
            }

            if(nbt.hasKey(key))
            {
                type = nbt.getInteger(key);
            }

            switch(type)
            {
                case 0:
                    this.debugEaten(world, player);
                    break;

                case 1:
                    this.debugPlayerWards(world, player, null, hand);
                    break;

                default:
                    nbt.setInteger(key, 0);
                    this.debugEaten(world, player);
                    break;
            }

            stack.setTagCompound(nbt);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    private void debugEaten(World world, EntityPlayer player)
    {
        if(!world.isRemote)
        {
            player.curePotionEffects(new ItemStack(Items.MILK_BUCKET));

            final IEaten eaten = CapabilityEaten.getEaten(player);
            if(player.isSneaking())
            {
                PlayerUtils.messageOnce(MESSAGE_EATEN_RESET, new TextComponentTranslation("Total Eaten Reset"));
                eaten.setEaten(0);
            }
            else
            {
                PlayerUtils.messageOnce(MESSAGE_GET_EATEN, new TextComponentTranslation("Total Eaten: " + eaten.getEaten()));
            }
        }
    }

    private void debugPlayerWards(World world, EntityPlayer player, EntityLivingBase entity, EnumHand hand)
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

            if(player.isSneaking())
            {
                warded.clearWards();
                PlayerUtils.messageOnce(MESSAGE_CLEAR_WARDS, new TextComponentTranslation(target.getName() + "'s wards removed."));
            }
            else
            {
                if(warded.getWards().length > 0)
                {
                    PlayerUtils.messageOnce(MESSAGE_GET_WARDS, new TextComponentTranslation(target.getName() + "'s first ward: " + warded.getWards()[0] + " out of " + warded.getWards().length + " wards"));
                }
                else
                {
                    PlayerUtils.messageOnce(MESSAGE_NO_WARDS, new TextComponentTranslation(target.getName() + " is not warded."));
                }
            }

        }
    }
}
