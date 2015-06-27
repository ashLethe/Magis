package com.github.leomagis.magis.block;

import com.github.leomagis.magis.Magis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInfusionStation extends Block {
    public BlockInfusionStation() {
        super(Material.iron);

        setCreativeTab(Magis.tabMagis);
        setUnlocalizedName("blockInfusionStation");
        setHarvestLevel("pickaxe", 1);
        setHardness(5.0F);
        setResistance(30.0F);
        setStepSound(soundTypeMetal);
    }
}
