package com.blacksun559.thewardedblock.item;

import com.blacksun559.thewardedblock.creativeTab.CreativeTab;
import com.blacksun559.thewardedblock.reference.Material;
import com.blacksun559.thewardedblock.reference.Names;
import com.blacksun559.thewardedblock.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemWardSword extends ItemSword
{
    public ItemWardSword()
    {
        super(Material.Tools.WARD_SWORD);
        this.setCreativeTab(CreativeTab.TWB_TAB);
        this.maxStackSize = 1;
        this.setUnlocalizedName(Names.Weapons.WARD_SWORD);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public boolean getShareTag()
    {
        return true;
    }
}
