package com.blacksun559.thewardedblock.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class EntityUtils
{
    public static void pushEntity(Entity entity, EnumFacing facing, double force)
    {
        pushEntity(entity, entity.getPosition().offset(facing.getOpposite()), force);
    }

    public static void pushEntity(Entity entity, BlockPos pos, double force)
    {
        final double distanceX = (double) pos.getX() - entity.posX;
        final double distanceY = (double) pos.getY() - entity.posY;
        final double distanceZ = (double) pos.getZ() - entity.posZ;
        final double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);

        if(distance > 0 && (distanceX <= 1 && distanceX >= -1) && (distanceZ <= 1 && distanceZ >= -1))
        {
            entity.motionX = distanceX / distance * force;
            entity.motionY = distanceY / distance * force;
            entity.motionZ = distanceZ / distance * force;
        }
    }
}
