package com.github.leomagis.magis.entity.tile;

import com.github.leomagis.magis.Magis;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;

public class TileFusionStation extends TileEntity implements IInventory {

    public TileFusionStation() {
        super();
    }

    private ItemStack[] inventoryContents;

    public ItemStack setSocketContents(int index, EntityPlayer playerIn) {
        if (index != 4) {
            ItemStack heldItem = playerIn.getHeldItem();
            if (this.isItemValidForSlot(index, heldItem)) {
                if (this.getStackInSlot(index) == null) {
                    this.setInventorySlotContents(index, heldItem);
                    return null;
                } else {
                    getStackInSlotOnClosing(index);
                    this.setInventorySlotContents(index, heldItem);
                }
            }

        } else {
            getStackInSlotOnClosing(index);
        } return null;
    }

    @Override
    public int getSizeInventory() {
        return 9;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        if (index >= 0 && index < this.inventoryContents.length) {
            return this.inventoryContents[index];
        } else { return null;}
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        if (this.inventoryContents[index] != null)
        {
            ItemStack itemstack = this.inventoryContents[index];
            this.inventoryContents[index] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.inventoryContents[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer playerIn) {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer playerIn) {

    }

    @Override
    public void closeInventory(EntityPlayer playerIn) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return stack.getItem() == Magis.elementalCompound;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public IChatComponent getDisplayName() {
        return null;
    }
}