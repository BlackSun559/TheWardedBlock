package com.blacksun559.thewardedblock.capabilties.eaten;

import jline.internal.Nullable;
import net.minecraft.entity.EntityLivingBase;

public class Eaten implements IEaten
{
    private int eaten;
    private final EntityLivingBase entity;

    @Override
    public int getEaten()
    {
        return this.eaten;
    }

    @Override
    public void incrementEaten()
    {
        this.eaten++;
    }

    @Override
    public void setEaten(int eaten)
    {
        this.eaten = eaten;
    }

    @Override
    public void sync()
    {
        // NOOP
    }

    public Eaten(@Nullable final EntityLivingBase entity)
    {
        this.entity = entity;
    }
}
