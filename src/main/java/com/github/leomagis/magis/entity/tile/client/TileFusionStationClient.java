package com.github.leomagis.magis.entity.tile.client;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;

public class TileFusionStationClient extends TileEntity implements IUpdatePlayerListBox {

    private int recipeTicksRemaining = 0;

    @Override
    public void update() {
        if(recipeTicksRemaining > 0) {
            worldObj.spawnParticle(EnumParticleTypes.SPELL,
                    pos.getX()+Math.random(),
                    pos.getY()+1.0,
                    pos.getZ()+Math.random(),
                    0.0, 0.0, 0.0, null);
            --recipeTicksRemaining;
        }
    }

    @Override
    public void onDataPacket(NetworkManager networkManager, S35PacketUpdateTileEntity packet) {
        NBTTagCompound tagCompound = packet.getNbtCompound();

        recipeTicksRemaining = tagCompound.getInteger("recipeTicksRemaining");
    }

}
