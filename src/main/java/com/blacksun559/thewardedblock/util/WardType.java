package com.blacksun559.thewardedblock.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;

import java.util.ArrayList;

public class WardType
{
    public static boolean isValidTarget(Entity entity, ArrayList<Integer> wardIDs)
    {
        boolean valid = false;

        for(Integer wardID : wardIDs)
        {
            switch(wardID)
            {
                case 0:
                    valid = entity instanceof EntityPlayer;
                    break;

                case 1:
                    valid =  entity instanceof EntityArrow;
                    break;

                case 2:
                    valid =  entity instanceof EntityZombie;
                    break;

                case 3:
                    valid =  entity instanceof EntitySkeleton;
                    break;

                case 4:
                    valid =  entity instanceof EntityCreeper;
                    break;
            }

            if(valid)
            {
                return valid;
            }
        }

        return valid;
    }

    public enum WardNames
    {
        player,
        arrow,
        zombie,
        skeleton,
        creeper
    }
}
