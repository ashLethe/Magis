package com.github.leomagis.magis.block;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.entity.tile.TileElementalCentrifuge;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockElementalCentrifuge extends Block implements ITileEntityProvider {

	public BlockElementalCentrifuge () {
		super (Material.iron);

		setCreativeTab(Magis.tabMagis);
		setUnlocalizedName("blockElementalCentrifuge");
		setHarvestLevel("pickaxe", 1);
		setHardness(5.0F);
		setResistance(30.0F);
		setStepSound(soundTypeMetal);
	}
	@Override
	public TileEntity createNewTileEntity (World worldIn, int meta) {
		if(worldIn.isRemote) {
			return new TileElementalCentrifuge();
		}
		return new TileElementalCentrifuge();
	}
}
