package com.blacksun559.thewardedblock.items;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.reference.Reference;
import com.blacksun559.thewardedblock.util.interfaces.IModel;
import net.minecraft.client.util.ITooltipFlag;
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

public class ItemTWB extends Item implements IModel
{
    // The base items from The Warded Block
    public ItemTWB(String name)
    {
        setItemName(this, name);
        this.setCreativeTab(TheWardedBlock.thewardedblock);
        this.setMaxStackSize(1);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        TheWardedBlock.proxy.registerItemRender(this, 0, "inventory");
    }

    public static void setItemName(Item item, String itemName)
    {
        item.setRegistryName(Reference.MOD_ID, itemName);
        item.setUnlocalizedName(item.getRegistryName().toString());
    }

    //Right click anywhere.
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
    {
        return super.onItemRightClick(world, player, hand);
    }

    //Right click on blocks/entity.
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
    {
        super.addInformation(stack, world, tooltip, flag);
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
