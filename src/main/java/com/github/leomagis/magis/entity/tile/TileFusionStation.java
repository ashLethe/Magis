package com.github.leomagis.magis.entity.tile;

import com.github.leomagis.magis.Magis;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;

public class TileFusionStation extends TileEntity implements IInventory {

    private ItemStack[] inventoryContents = new ItemStack[9];

    public void ejectItem(int index) {
        ItemStack stackInSlot = getStackInSlotOnClosing(index);
        if(stackInSlot == null) {return;}

        worldObj.spawnEntityInWorld(new EntityItem(worldObj,
                        pos.getX(), pos.getY(), pos.getZ(), stackInSlot));
    }

    public ItemStack setSocketContents(int index, ItemStack itemStack) {
        // items cannot be inserted into the 4th slot
        if(index == 4) {
            ejectItem(4);
            return itemStack;
        }

        if(!isItemValidForSlot(index, itemStack)) {return itemStack;}

        if(getStackInSlot(index) != null) {ejectItem(index);}

        int originalSize = itemStack.stackSize;
        setInventorySlotContents(index, itemStack);

        int stackLimit = getInventoryStackLimit();
        if(originalSize <= stackLimit) {return null;}

        return new ItemStack(itemStack.getItem(), originalSize-stackLimit, itemStack.getItemDamage());
    }

    @Override
    public int getSizeInventory() {
        return 9;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        if(index >= 0 && index < inventoryContents.length) {
            return inventoryContents[index];
        }
        return null;
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        ItemStack stackInSlot = getStackInSlot(index);
        if(stackInSlot == null) {return null;}

        if(stackInSlot.stackSize <= count) {
            setInventorySlotContents(index, null);
            return stackInSlot;
        }

        stackInSlot.stackSize -= count;
        return new ItemStack(stackInSlot.getItem(), count, stackInSlot.getItemDamage());
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        ItemStack stackInSlot = getStackInSlot(index);
        if(stackInSlot != null) {
            setInventorySlotContents(index, null);
            return stackInSlot;
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        if(index < 0 || index >= inventoryContents.length) {return;}

        int stackLimit = getInventoryStackLimit();
        if(stack != null && stack.stackSize > stackLimit) {stack.stackSize = stackLimit;}

        inventoryContents[index] = stack;
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
    public void openInventory(EntityPlayer playerIn) {}

    @Override
    public void closeInventory(EntityPlayer playerIn) {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return stack == null || stack.getItem() == Magis.elementalCompound;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {}

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for(int i=0;i<inventoryContents.length;++i) {
            inventoryContents[i] = null;
        }
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
