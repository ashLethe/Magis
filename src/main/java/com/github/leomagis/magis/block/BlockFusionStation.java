package com.github.leomagis.magis.block;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.entity.tile.TileFusionStation;
import com.github.leomagis.magis.entity.tile.client.TileFusionStationClient;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
        return true;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        if(worldIn.isRemote) {
            return new TileFusionStationClient();
        }
        return new TileFusionStation();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(side != EnumFacing.UP) {return false;}
        if(worldIn.isRemote) {return true;}

        ItemStack heldItem = playerIn.getHeldItem();
        TileFusionStation fusionStation = (TileFusionStation) worldIn.getTileEntity(pos);
        if(hitX <= 0.33) {
            if(hitZ <= 0.33) {
                heldItem = fusionStation.setSocketContents(0, heldItem);
            } else if(hitZ <= 0.66) {
                heldItem = fusionStation.setSocketContents(1, heldItem);
            } else {
                heldItem = fusionStation.setSocketContents(2, heldItem);
            }
        } else if(hitX <= 0.66) {
            if(hitZ <= 0.33) {
                heldItem = fusionStation.setSocketContents(3, heldItem);
            } else if(hitZ <= 0.66) {
                heldItem = fusionStation.setSocketContents(4, heldItem);
            } else {
                heldItem = fusionStation.setSocketContents(5, heldItem);
            }
        } else {
            if(hitZ <= 0.33) {
                heldItem = fusionStation.setSocketContents(6, heldItem);
            } else if(hitZ <= 0.66) {
                heldItem = fusionStation.setSocketContents(7, heldItem);
            } else {
                heldItem = fusionStation.setSocketContents(8, heldItem);
            }
        }

        playerIn.setCurrentItemOrArmor(0, heldItem);
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileFusionStation tileEntity = (TileFusionStation) worldIn.getTileEntity(pos);

        int inventorySize = tileEntity.getSizeInventory();
        for(int i=0;i<inventorySize;++i) {
            ItemStack itemStack = tileEntity.getStackInSlotOnClosing(i);
            if(itemStack == null) {continue;}

            worldIn.spawnEntityInWorld(new EntityItem(worldIn,
                            pos.getX(), pos.getY(), pos.getZ(), itemStack));
        }
    }

    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
        ((TileFusionStation) worldIn.getTileEntity(pos)).performRecipe();
    }

}
