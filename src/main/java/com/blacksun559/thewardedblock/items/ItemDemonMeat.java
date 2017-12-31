package com.blacksun559.thewardedblock.items;

import com.blacksun559.thewardedblock.capabilties.eaten.CapabilityEaten;
import com.blacksun559.thewardedblock.capabilties.eaten.IEaten;
import com.blacksun559.thewardedblock.items.Base.ItemFoodTWB;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

public class ItemDemonMeat extends ItemFoodTWB
{
    public ItemDemonMeat(String name)
    {
        super(name, 2, 0.1f, false);
        this.setMaxStackSize(64);
//        this.setAlwaysEdible();
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
    {
        tooltip.add("Looks terrible and smells even worse.");
        super.addInformation(stack, world, tooltip, flag);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if(!player.world.isRemote)
        {
            final IEaten eaten = CapabilityEaten.getEaten(player);

            if(eaten != null)
            {
                eaten.incrementEaten();

                int numEaten = eaten.getEaten();

                if(numEaten <= 3)
                {
                    player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 100, 2, false, false));
                    player.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200, 2, false, false));
                }
                else if(numEaten <= 6)
                {
                    player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 80, 1, false, false));
                    player.addPotionEffect(new PotionEffect(MobEffects.WITHER, 100, 1, false, false));
                }
                else
                {
                    player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 2, false, false));
                    player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 2, false, false));
                    player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200, 2, false, false));
                    player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 2, false, false));
                }
            }
            else
            {
                player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 100, 2, false, false));
                player.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200, 2, false, false));
            }
        }

        super.onFoodEaten(stack, worldIn, player);
    }
}