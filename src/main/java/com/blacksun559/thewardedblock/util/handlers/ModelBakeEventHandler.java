package com.blacksun559.thewardedblock.util.handlers;

import com.blacksun559.thewardedblock.blocks.model.WardBakedModel;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModelBakeEventHandler
{
    public static final ModelBakeEventHandler instance = new ModelBakeEventHandler();

    private ModelBakeEventHandler()
    {
    }

    @SubscribeEvent
    public void onModelBakeEvent(ModelBakeEvent event)
    {
        Object object = event.getModelRegistry().getObject(WardBakedModel.variantTag);
        if(object instanceof IBakedModel)
        {
            IBakedModel source = (IBakedModel) object;
            WardBakedModel customModel = new WardBakedModel(source);
            event.getModelRegistry().putObject(WardBakedModel.variantTag, customModel);
        }
    }
}
