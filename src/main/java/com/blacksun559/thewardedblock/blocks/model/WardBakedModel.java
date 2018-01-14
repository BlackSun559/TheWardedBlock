package com.blacksun559.thewardedblock.blocks.model;

import com.blacksun559.thewardedblock.blocks.ward.BlockWard;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.property.IExtendedBlockState;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import java.util.List;

public class WardBakedModel implements IBakedModel
{
    private IBakedModel base_model;
    public static final ModelResourceLocation blockStatesFileName = new ModelResourceLocation("thewardedblock:block_ward");
    public static final ModelResourceLocation variantTag = new ModelResourceLocation("thewardedblock:block_ward", "normal");

    public WardBakedModel(IBakedModel base_model)
    {
        this.base_model = base_model;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing facing, long rand)
    {
        List<BakedQuad> quads = null;

        quads = handleBlockState(state).getQuads(state, facing, rand);
        return handleBlockState(state).getQuads(state, facing, rand);
    }

    @Override
    public boolean isAmbientOcclusion()
    {
        return base_model.isAmbientOcclusion();
    }

    @Override
    public boolean isGui3d()
    {
        return base_model.isGui3d();
    }

    @Override
    public boolean isBuiltInRenderer()
    {
        return base_model.isBuiltInRenderer();
    }

    @Override
    public TextureAtlasSprite getParticleTexture()
    {
        return base_model.getParticleTexture();
    }

    @Override
    public ItemOverrideList getOverrides()
    {
        return base_model.getOverrides();
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms()
    {
        return base_model.getItemCameraTransforms();
    }

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType)
    {
        Matrix4f matrix4f = base_model.handlePerspective(cameraTransformType).getRight();
        return Pair.of(this, matrix4f);
    }

    private IBakedModel handleBlockState(IBlockState state)
    {
        IBakedModel value = base_model;
        IBlockState BASE_BLOCK = Blocks.AIR.getDefaultState();

        if(state instanceof IExtendedBlockState)
        {
            IExtendedBlockState extendedState = (IExtendedBlockState) state;
            IBlockState source = extendedState.getValue(BlockWard.SOURCE_BLOCK);

            if(source != BASE_BLOCK)
            {
                Minecraft minecraft = Minecraft.getMinecraft();
                BlockRendererDispatcher blockRendererDispatcher = minecraft.getBlockRendererDispatcher();
                BlockModelShapes blockModelShapes = blockRendererDispatcher.getBlockModelShapes();
                IBakedModel source_model = blockModelShapes.getModelForState(source);
                value = source_model;
            }
        }

        return value;
    }
}
