package com.blacksun559.thewardedblock.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;

public class EntityDemon extends EntityZombie
{
    public EntityDemon(World worldIn)
    {
        super(worldIn);
        this.setSize(0.7f, 0.9f);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32.0d);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3d);
    }

    @Override
    public float getEyeHeight()
    {
        return 0.8f;
    }
}
