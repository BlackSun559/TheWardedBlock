package com.blacksun559.thewardedblock.item;

import com.blacksun559.thewardedblock.reference.Names;

public class ItemDemonMeat extends FoodItemTWB
{
    private int witherID = 20;
    private int witherTime = 6;
    private int witherAmp = 3;
    private float witherProb = 1.0f;
    private int hungerID = 17;
    private int hungerTime = 30;
    private int hungerAmp = 3;
    private float hungerProb = 0.50f;
    private int confusionID = 9;
    private int confusionTime = 15;
    private int confusionAmp = 3;
    private float confusionProb = 0.8f;

    public ItemDemonMeat()
    {
        super(1, 0.5f, false);
        this.setUnlocalizedName(Names.Items.DEMON_MEAT);
        this.setAlwaysEdible();
        this.setPotionEffect(witherID, witherTime, witherAmp, witherProb);
    }
}
