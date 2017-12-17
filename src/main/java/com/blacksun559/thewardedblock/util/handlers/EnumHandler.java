package com.blacksun559.thewardedblock.util.handlers;

import com.blacksun559.thewardedblock.util.interfaces.IVariant;
import net.minecraft.item.ItemStack;

import java.util.Comparator;
import java.util.stream.Stream;

public class EnumHandler
{
    public enum EnumType implements IVariant
    {
        CRYSTAL(0, "crystal"),
        SILVER(1, "silver");

        private static final EnumType[] META_LOOKUP = Stream.of(values()).sorted(Comparator.comparing(EnumType::getMeta)).toArray(EnumType[]::new);
        private final int meta;
        private final String name;

        EnumType(int meta, String name)
        {
            this.meta = meta;
            this.name = name;
        }

        @Override
        public int getMeta()
        {
            return meta;
        }

        @Override
        public String getName()
        {
            return name;
        }



        public static EnumType byMetaData(int meta)
        {
            if(meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }
    }
}
