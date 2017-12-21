package com.blacksun559.thewardedblock.items.Base;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.reference.Reference;
import com.blacksun559.thewardedblock.util.interfaces.IModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

public class ItemFoodTWB extends ItemFood implements IModel
{
    private PotionEffect[] effects;

    public ItemFoodTWB(String name, int amount, float saturation, boolean isWolfFood, PotionEffect... effects)
    {
        super(amount, saturation, isWolfFood);
        setItemName(this, name);
        this.setCreativeTab(TheWardedBlock.thewardedblock);
        this.effects = effects;

        ModItems.ITEMS.add(this);
    }

    public void registerModels()
    {
        TheWardedBlock.proxy.registerItemRender(this, 0, "inventory");
    }

    public static void setItemName(Item item, String itemName)
    {
        item.setRegistryName(Reference.MOD_ID, itemName);
        item.setUnlocalizedName(item.getRegistryName().toString());
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
    {
        super.addInformation(stack, world, tooltip, flag);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        super.onFoodEaten(stack, worldIn, player);

        for (PotionEffect effect : effects)
        {
            if (!worldIn.isRemote && effect != null)
            {
                player.addPotionEffect(effect);
            }
        }
    }
}
