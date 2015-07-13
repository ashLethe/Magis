package com.github.leomagis.magis.entity.tile.client;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;

import java.util.Arrays;

public class TileFusionStationClient extends TileEntity implements IUpdatePlayerListBox {

    private int recipeTicksRemaining = 0;
    public int itemSpinTicks = 0;

    private ItemStack currentRecipeResult;

    private ItemStack[] inventoryContents = new ItemStack[9];

    public ItemStack getRecipeResult() {
        return currentRecipeResult;
    }

    public ItemStack getStackInSlot(int index) {
        if(index >= 0 && index < inventoryContents.length) {
            return inventoryContents[index];
        }
        return null;
    }

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

        ++itemSpinTicks;
    }

    @Override
    public void onDataPacket(NetworkManager networkManager, S35PacketUpdateTileEntity packet) {
        NBTTagCompound tagCompound = packet.getNbtCompound();

        recipeTicksRemaining = tagCompound.getInteger("recipeTicksRemaining");

        NBTTagCompound recipeResult = tagCompound.getCompoundTag("currentRecipeResult");
        currentRecipeResult = ItemStack.loadItemStackFromNBT(recipeResult);

        Arrays.fill(inventoryContents, null);

        // see NBTBase.NBT_TYPES
        NBTTagList itemsList = tagCompound.getTagList("items", 10);

        int numTags = itemsList.tagCount();
        for(int i=0;i<numTags;++i) {
            NBTTagCompound itemCompound = itemsList.getCompoundTagAt(i);

            int slot = itemCompound.getInteger("slot");
            if(slot < 0 || slot >= inventoryContents.length) {continue;}

            inventoryContents[slot] = ItemStack.loadItemStackFromNBT(itemCompound);
        }
    }

}
