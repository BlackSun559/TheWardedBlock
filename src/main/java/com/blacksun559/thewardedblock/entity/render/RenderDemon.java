package com.blacksun559.thewardedblock.entity.render;

import com.blacksun559.thewardedblock.entity.model.ModelDemon;
import com.blacksun559.thewardedblock.reference.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDemon extends RenderLiving
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/demon.png");

    public RenderDemon(RenderManager rendermanager)
    {
        super(rendermanager, new ModelDemon(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityLivingBase entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
