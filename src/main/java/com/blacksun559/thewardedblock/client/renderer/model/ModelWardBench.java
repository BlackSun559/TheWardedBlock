package com.blacksun559.thewardedblock.client.renderer.model;

import com.blacksun559.thewardedblock.reference.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class ModelWardBench
{
    private IModelCustom modelWardBench;

    public ModelWardBench()
    {
        System.out.println(Models.WARD_BENCH);
        modelWardBench = AdvancedModelLoader.loadModel(Models.WARD_BENCH);
    }

    public void render()
    {
        modelWardBench.renderAll();
    }
}
