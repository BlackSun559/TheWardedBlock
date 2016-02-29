package com.blacksun559.thewardedblock.reference;

import com.blacksun559.thewardedblock.util.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public final class Textures
{
    public static final String RESOURCE_PREFIX = Reference.MOD_ID + ":";

    public static final class Model
    {
        private static final String MODEL_TEXTURE_LOCATION = "textures/models/";
        public static final ResourceLocation WARD_BENCH = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "wardBench.png");
    }
}
