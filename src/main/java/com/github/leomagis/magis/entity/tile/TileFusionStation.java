package com.github.leomagis.magis.entity.tile;

import com.github.leomagis.magis.Magis;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;

public class TileFusionStation extends TileEntity implements IInventory {

    public TileFusionStation() {
        super();
    }

    private ItemStack[] inventoryContents = new ItemStack[9];
    public static final String publicName = "tileFusionStation";

    public void ejectItem (int index) {
        if (getStackInSlot(index) != null) {
            ItemStack ejectedItem = new ItemStack(getStackInSlot(index).getItem());
            worldObj.spawnEntityInWorld(new EntityItem(worldObj,
                    pos.getX(), pos.getY(), pos.getZ(), ejectedItem));
            setInventorySlotContents(index, null);
        }
    }

    public ItemStack setSocketContents(int index, EntityPlayer playerIn) {
        if (index != 4) {
            ItemStack heldItem = playerIn.getHeldItem();
                if (getStackInSlot(index) == null) {
                    if (isItemValidForSlot(index, heldItem)) {
                        setInventorySlotContents(index, heldItem);
                        --heldItem.stackSize;
                    }
                    return null;
                } else {
                    ejectItem(index);
                    if (isItemValidForSlot(index, heldItem)) {
                        setInventorySlotContents(index, heldItem);
                        --heldItem.stackSize;
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
        if (index >= 0 && index < inventoryContents.length) {
            return inventoryContents[index];
        } else { return null;}
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        if (inventoryContents[index] != null)
        {
            ItemStack itemstack = inventoryContents[index];
            inventoryContents[index] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        inventoryContents[index] = stack;


        if (inventoryContents[index] != null && inventoryContents[index].stackSize > getInventoryStackLimit())
        {
            inventoryContents[index].stackSize = getInventoryStackLimit();
        }

        markDirty();
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
        if (stack != null) {
            return stack.getItem() == Magis.elementalCompound;
        }  return false;
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