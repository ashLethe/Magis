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
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileFusionStation();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileFusionStation fusionStation = (TileFusionStation) worldIn.getTileEntity(pos);
        if (side == EnumFacing.UP) {
            if ((hitX >= 0) && (hitX <= 0.33)) {
                if ((hitZ >= 0) && (hitZ <= 0.33)) {
                    int index = 0;
                    fusionStation.setSocketContents(index, playerIn);
                    return true;
                } else if ((hitZ > 0.33) && (hitZ <= 0.66)) {
                    int index = 1;
                    fusionStation.setSocketContents(index, playerIn);
                    return true;
                } else if ((hitZ > 0.66) && (hitZ <= 1)) {
                    int index = 2;
                    fusionStation.setSocketContents(index, playerIn);
                    return true;
                }
            } else if ((hitX > 0.33) && (hitX <= 0.66)) {
                if ((hitZ >= 0) && (hitZ <= 0.33)) {
                    int index = 3;
                    fusionStation.setSocketContents(index, playerIn);
                    return true;
                } else if ((hitZ > 0.33) && (hitZ <= 0.66)) {
                    int index = 4;
                    fusionStation.setSocketContents(index, playerIn);
                    return true;
                } else if ((hitZ > 0.66) && (hitZ <= 1)) {
                    int index = 5;
                    fusionStation.setSocketContents(index, playerIn);
                    return true;
                }
            } else if ((hitX > 0.66) && (hitX <= 1)) {
                if ((hitZ >= 0) && (hitZ <= 0.33)) {
                    int index = 6;
                    fusionStation.setSocketContents(index, playerIn);
                    return true;
                } else if ((hitZ > 0.33) && (hitZ <= 0.66)) {
                    int index = 7;
                    fusionStation.setSocketContents(index, playerIn);
                    return true;
                } else if ((hitZ > 0.66) && (hitZ <= 1)) {
                    int index = 8;
                    fusionStation.setSocketContents(index, playerIn);
                    return true;
                }
            }
        } return false;
    }
}
