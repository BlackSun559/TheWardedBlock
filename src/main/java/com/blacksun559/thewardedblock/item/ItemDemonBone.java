package com.blacksun559.thewardedblock.item;

import com.blacksun559.thewardedblock.creativeTab.CreativeTab;
import com.blacksun559.thewardedblock.reference.Names;
import com.blacksun559.thewardedblock.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

public class ItemDemonBone extends ItemTWB
{
    private IIcon[] icons;
    public ItemDemonBone()
    {
        super();
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTab.TWB_TAB);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s.%s", Textures.RESOURCE_PREFIX, Names.Items.DEMON_BONE, Names.Items.DEMON_BONE_SUBTYPES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, Names.Items.DEMON_BONE_SUBTYPES.length - 1)]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTab, List list)
    {
        for (int meta = 0; meta < Names.Items.DEMON_BONE_SUBTYPES.length; ++meta)
        {
            list.add(new ItemStack(this, 1, meta));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        return icons[MathHelper.clamp_int(meta, 0, Names.Items.DEMON_BONE_SUBTYPES.length - 1)];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[Names.Items.DEMON_BONE_SUBTYPES.length];

        for (int i = 0; i < Names.Items.DEMON_BONE_SUBTYPES.length; i++)
        {
            icons[i] = iconRegister.registerIcon(Textures.RESOURCE_PREFIX + Names.Items.DEMON_BONE + "." + Names.Items.DEMON_BONE_SUBTYPES[i]);
        }
    }
}
