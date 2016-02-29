package com.blacksun559.thewardedblock.client.renderer.tileentity;

import com.blacksun559.thewardedblock.client.renderer.model.ModelWardBench;
import com.blacksun559.thewardedblock.reference.Textures;
import com.blacksun559.thewardedblock.tileentity.TileEntityWardBench;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererWardBench extends TileEntitySpecialRenderer
{
    private final ModelWardBench modelWardBench = new ModelWardBench();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double Z, float tick)
    {
        if(tileEntity instanceof TileEntityWardBench)
        {
            TileEntityWardBench tileEntityWardBench = (TileEntityWardBench)tileEntity;
            ForgeDirection direction = tileEntityWardBench.getOrientation();

            GL11.glPushMatrix();

//            scaleTranslateRotate(x, y, z, direction);

            this.bindTexture(Textures.Model.WARD_BENCH);

//            modelWardBench.render(tileEntity, x, y, z, tick);
            
            GL11.glPopMatrix();
        }
    }
}
