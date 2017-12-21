package com.blacksun559.thewardedblock.util.handlers;

import com.blacksun559.thewardedblock.util.interfaces.IVariant;

import java.util.Comparator;
import java.util.stream.Stream;

public class EnumHandler
{
    public enum OreEnumType implements IVariant
    {
        CRYSTAL(0, "crystal"),
        SILVER(1, "silver");

        private static final OreEnumType[] META_LOOKUP = Stream.of(values()).sorted(Comparator.comparing(OreEnumType::getType)).toArray(OreEnumType[]::new);
        private final int meta;
        private final String name;

        OreEnumType(int meta, String name)
        {
            this.meta = meta;
            this.name = name;
        }

        @Override
        public int getType()
        {
            return meta;
        }

        @Override
        public String getName()
        {
            return name;
        }

        public static OreEnumType byMetaData(int meta)
        {
            if(meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }
    }
}
