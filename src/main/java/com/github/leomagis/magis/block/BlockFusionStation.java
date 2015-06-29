package com.github.leomagis.magis.block;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.entity.tile.TileFusionStation;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockFusionStation extends Block implements ITileEntityProvider {
    public BlockFusionStation() {
        super(Material.iron);

        setCreativeTab(Magis.tabMagis);
        setUnlocalizedName("blockFusionStation");
        setHarvestLevel("pickaxe", 1);
        setHardness(5.0F);
        setResistance(30.0F);
        setStepSound(soundTypeMetal);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isVisuallyOpaque() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileFusionStation();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(side != EnumFacing.UP) {return false;}
        if(worldIn.isRemote) {return true;}

        TileFusionStation fusionStation = (TileFusionStation) worldIn.getTileEntity(pos);
        if(hitX <= 0.33) {
            if(hitZ <= 0.33) {
                fusionStation.setSocketContents(0, playerIn);
            } else if(hitZ <= 0.66) {
                fusionStation.setSocketContents(1, playerIn);
            } else {
                fusionStation.setSocketContents(2, playerIn);
            }
        } else if(hitX <= 0.66) {
            if(hitZ <= 0.33) {
                fusionStation.setSocketContents(3, playerIn);
            } else if(hitZ <= 0.66) {
                fusionStation.setSocketContents(4, playerIn);
            } else {
                fusionStation.setSocketContents(5, playerIn);
            }
        } else {
            if(hitZ <= 0.33) {
                fusionStation.setSocketContents(6, playerIn);
            } else if(hitZ <= 0.66) {
                fusionStation.setSocketContents(7, playerIn);
            } else {
                fusionStation.setSocketContents(8, playerIn);
            }
        }

        return true;
    }
}