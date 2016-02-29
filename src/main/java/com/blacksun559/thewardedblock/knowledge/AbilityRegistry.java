package com.blacksun559.thewardedblock.knowledge;

import com.google.gson.*;

import java.lang.reflect.Type;

public class AbilityRegistry implements JsonSerializer<AbilityRegistry>, JsonDeserializer<AbilityRegistry>
{
    private static AbilityRegistry abilityRegistry = null;

    private AbilityRegistry()
    {

    }

    public static AbilityRegistry getInstance()
    {
        if(abilityRegistry == null)
        {
            abilityRegistry = new AbilityRegistry();
            abilityRegistry.init();
        }

        return abilityRegistry;
    }

    private void init()
    {
        // TODO set abilities
    }

    public void save()
    {
        // TODO set save
    }

    @Override
    public AbilityRegistry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        AbilityRegistry abilityRegistry1 = null;

        return abilityRegistry1;
    }

    @Override
    public JsonElement serialize(AbilityRegistry src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
