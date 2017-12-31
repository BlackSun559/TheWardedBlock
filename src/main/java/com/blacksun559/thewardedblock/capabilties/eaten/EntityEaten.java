package com.blacksun559.thewardedblock.capabilties.eaten;

import com.blacksun559.thewardedblock.network.PacketEntityEaten;
import com.blacksun559.thewardedblock.network.TWBPacketHandler;
import jline.internal.Nullable;
import net.minecraft.entity.EntityLivingBase;

public class EntityEaten implements IEaten
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
        if(this.entity != null && !this.entity.getEntityWorld().isRemote)
        {
            IEaten iEaten = CapabilityEaten.getEaten(this.entity);
            PacketEntityEaten entityEaten = new PacketEntityEaten(iEaten.getEaten());
            TWBPacketHandler.sendToServer(entityEaten);
        }
    }

    public EntityEaten(@Nullable final EntityLivingBase entity)
    {
        this.entity = entity;
    }
}
