package com.github.leomagis.magis.entity.tile;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.recipe.FusionRecipeRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;

import java.util.ArrayList;
import java.util.List;

public class TileFusionStation extends TileEntity implements IInventory, IUpdatePlayerListBox {

    private int recipeTicksRemaining = 0;

    private ItemStack currentRecipeResult;

    private ItemStack[] inventoryContents = new ItemStack[9];

    public void ejectItem(int index) {
        ItemStack stackInSlot = getStackInSlotOnClosing(index);
        if(stackInSlot == null) {return;}
        cancelCurrentRecipe();

        worldObj.spawnEntityInWorld(new EntityItem(worldObj,
                        pos.getX()+0.5, pos.getY()+1.0, pos.getZ()+0.5,
                        stackInSlot));
    }

    public ItemStack setSocketContents(int index, ItemStack itemStack) {
        if(!isItemValidForSlot(index, itemStack)) {return itemStack;}
        cancelCurrentRecipe();
        if(getStackInSlot(index) != null) {ejectItem(index);}

        ItemStack returnStack = null;
        if(itemStack != null) {
            int originalSize = itemStack.stackSize;
            setInventorySlotContents(index, itemStack);

            int stackLimit = getInventoryStackLimit();
            if(originalSize > stackLimit) {
                returnStack = new ItemStack(
                        itemStack.getItem(),
                        originalSize - stackLimit,
                        itemStack.getItemDamage());
            }
        }

        if(index == 4) {performRecipe();}

        return returnStack;
    }

    private void performRecipe() {
        ItemStack centerStack = inventoryContents[4];

        List<ItemStack> otherStacksList = new ArrayList<ItemStack>(8);
        for(int i=0;i<inventoryContents.length;++i) {
            if(i == 4) {continue;}

            ItemStack itemStack = inventoryContents[i];
            if(itemStack == null) {continue;}

            otherStacksList.add(itemStack);
        }
        ItemStack[] otherStacks = new ItemStack[otherStacksList.size()];
        otherStacksList.toArray(otherStacks);

        currentRecipeResult = FusionRecipeRegistry.getRecipeResult(centerStack, otherStacks);
        if(currentRecipeResult == null) {return;}

        recipeTicksRemaining = 100;
        worldObj.markBlockForUpdate(pos);
    }

    private void cancelCurrentRecipe() {
        recipeTicksRemaining = 0;
        currentRecipeResult = null;
        worldObj.markBlockForUpdate(pos);
    }

    @Override
    public void update() {
        if(recipeTicksRemaining > 0) {
            --recipeTicksRemaining;

            if(recipeTicksRemaining == 0) {
                worldObj.spawnEntityInWorld(new EntityItem(worldObj,
                                pos.getX()+0.5, pos.getY()+1.0, pos.getZ()+0.5,
                                ItemStack.copyItemStack(currentRecipeResult)));
                currentRecipeResult = null;
                clear();
            }
        }
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
        cancelCurrentRecipe();

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
        if(stackInSlot == null) {return null;}

        setInventorySlotContents(index, null);
        return stackInSlot;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        if(index < 0 || index >= inventoryContents.length) {return;}
        cancelCurrentRecipe();

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
        return stack == null || stack.getItem() == Magis.elementalCompound; //TODO make list of reagents for validation
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
        cancelCurrentRecipe();
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

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setInteger("recipeTicksRemaining", recipeTicksRemaining);

        return new S35PacketUpdateTileEntity(pos, 0, tagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setInteger("recipeTicksRemaining", recipeTicksRemaining);

        if(currentRecipeResult != null) {
            NBTTagCompound recipeResult = new NBTTagCompound();
            currentRecipeResult.writeToNBT(recipeResult);
            tagCompound.setTag("currentRecipeResult", recipeResult);
        }

        NBTTagList itemsList = new NBTTagList();
        for(int i=0;i<inventoryContents.length;++i) {
            ItemStack itemStack = inventoryContents[i];
            if(itemStack == null) {continue;}

            NBTTagCompound itemCompound = new NBTTagCompound();
            itemStack.writeToNBT(itemCompound);
            itemCompound.setInteger("slot", i);
            itemsList.appendTag(itemCompound);
        }
        tagCompound.setTag("items", itemsList);
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        recipeTicksRemaining = tagCompound.getInteger("recipeTicksRemaining");

        NBTTagCompound recipeResult = tagCompound.getCompoundTag("currentRecipeResult");
        if(!recipeResult.hasNoTags()) {
            currentRecipeResult = ItemStack.loadItemStackFromNBT(recipeResult);
        }

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
