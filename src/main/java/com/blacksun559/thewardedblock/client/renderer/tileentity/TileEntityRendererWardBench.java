package com.blacksun559.thewardedblock.client.renderer.tileentity;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.block.BlockWardBench;
import com.blacksun559.thewardedblock.client.renderer.model.ModelWardBench;
import com.blacksun559.thewardedblock.reference.Textures;
import com.blacksun559.thewardedblock.tileentity.TileEntityWardBench;
import com.blacksun559.thewardedblock.util.ResourceLocationHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererWardBench extends TileEntitySpecialRenderer
{
    private final ModelWardBench modelWardBench = new ModelWardBench();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    {
        if(tileEntity instanceof TileEntityWardBench)
        {
            TileEntityWardBench tileEntityWardBench = (TileEntityWardBench)tileEntity;
            ForgeDirection direction = tileEntityWardBench.getOrientation();

            GL11.glPushMatrix();

            scaleTranslateRotate(x, y, z, direction);

            this.bindTexture(Textures.Model.WARD_BENCH);

            modelWardBench.render();
            
            GL11.glPopMatrix();
        }
    }

    private void scaleTranslateRotate(double x, double y, double z, ForgeDirection orientation)
    {
        if (orientation == ForgeDirection.NORTH)
        {
            GL11.glTranslated(x + 0.5f, y, z + 0.5f);
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
        }
        else if (orientation == ForgeDirection.EAST)
        {
            GL11.glTranslated(x + 0.5f, y, z + 0.5f);
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
        }
        else if (orientation == ForgeDirection.SOUTH)
        {
            GL11.glTranslated(x + 0.5f, y, z + 0.5f);
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
        }
        else if (orientation == ForgeDirection.WEST)
        {
            GL11.glTranslated(x + 0.5f, y, z + 0.5f);
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
        }
    }
}
