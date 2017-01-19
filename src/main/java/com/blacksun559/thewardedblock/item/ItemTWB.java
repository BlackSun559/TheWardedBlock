package com.blacksun559.thewardedblock.item;

import com.blacksun559.thewardedblock.TheWardedBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ItemTWB extends Item
{
    // The base item from The Warded Block
    public ItemTWB(String name)
    {
        this.setUnlocalizedName(name);
        this.setCreativeTab(TheWardedBlock.thewardedblock);
        this.setMaxStackSize(1);
    }

    //Right click anywhere.
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
    {
        return super.onItemRightClick(itemStack, world, player, hand);
    }

    //Right click on block/entity.
    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        return super.onItemUse(stack, player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        super.addInformation(stack, player, tooltip, advanced);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return super.getRarity(stack);
    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return super.hasEffect(stack);
    }
}
