package com.blacksun559.thewardedblock.client.renderer.item;

import com.blacksun559.thewardedblock.client.renderer.model.ModelWardBench;
import com.blacksun559.thewardedblock.reference.Textures;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRendererWardBench implements IItemRenderer
{
    private final ModelWardBench modelWardBench;

    public ItemRendererWardBench()
    {
        modelWardBench = new ModelWardBench();
    }

    @Override
    public boolean handleRenderType(ItemStack itemStack, ItemRenderType itemRenderType)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRendererHelper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType itemRenderType, ItemStack itemStack, Object... data)
    {
        switch (itemRenderType)
        {
            case ENTITY:
            {
                renderWardBench(0.0f, -1.0f, 0.0f);
                return;
            }
            case EQUIPPED:
            {
                renderWardBench(1.0f, 0.0f, 1.0f);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                renderWardBench(1.0f, 0.0f, 1.0f);
                return;
        }
            case INVENTORY:
            {
                renderWardBench(0.0f, -1.0f, 0.0f);
                return;
            }
            default:
            {
            }
        }
    }

    private void renderWardBench(float x, float y, float z)
    {
        GL11.glPushMatrix();

        // Scale, Translate, Rotate
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        GL11.glTranslatef(x, y, z);

        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.WARD_BENCH);

        // Render
        modelWardBench.render();

        GL11.glPopMatrix();
    }
}
