package com.github.leomagis.magis.block;

import com.github.leomagis.magis.Magis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEvercrystal extends Block {

    public BlockEvercrystal() {
        super(Material.glass);

        setCreativeTab(Magis.tabMagis);
        setUnlocalizedName("blockEvercrystal");
        setHarvestLevel("pickaxe", 3);
        setHardness(13.0F);
        setResistance(18000000.0F);
        setStepSound(soundTypeGlass);
    }

}
