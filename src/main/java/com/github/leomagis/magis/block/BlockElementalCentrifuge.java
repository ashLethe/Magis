package com.github.leomagis.magis.block;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.entity.tile.TileElementalCentrifuge;
import com.github.leomagis.magis.entity.tile.client
        .TileElementalCentrifugeClient;
import com.github.leomagis.magis.gui.GUIElementalCentrifuge;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
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
			return new TileElementalCentrifugeClient();
		}
		return new TileElementalCentrifuge();
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player,
									EnumFacing side, float hitX, float hitY, float hitZ) {
		if(super.onBlockActivated(worldIn, pos, state, player, side, hitX, hitY, hitZ)) {return true;}

		player.openGui(Magis.instance, GUIElementalCentrifuge.GUIID, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
