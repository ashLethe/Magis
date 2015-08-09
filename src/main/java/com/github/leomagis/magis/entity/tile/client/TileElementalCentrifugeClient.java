package com.github.leomagis.magis.entity.tile.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;


public class TileElementalCentrifugeClient extends TileEntity implements ISidedInventory,IUpdatePlayerListBox {

	private int fuelBar = 0;
	private int progressBar = 0;

	private ItemStack[] currentRecipeResult;
	private ItemStack[] inventoryContents = new ItemStack[10];

	private static void addStackToNBT(ItemStack stack, NBTTagCompound tagCompound, String key) {
		if(stack == null) {return;}

		NBTTagCompound stackCompound = new NBTTagCompound();
		stack.writeToNBT(stackCompound);
		tagCompound.setTag(key, stackCompound);
	}

	private static ItemStack getStackFromNBT(NBTTagCompound tagCompound, String key) {
		NBTTagCompound itemCompound = tagCompound.getCompoundTag(key);
		return ItemStack.loadItemStackFromNBT(itemCompound);
	}

	private void writeSharedNBT(NBTTagCompound tagCompound) {
		addStackToNBT(inventoryContents[0], tagCompound, "result1");
		addStackToNBT(inventoryContents[1], tagCompound, "result2");
		addStackToNBT(inventoryContents[2], tagCompound, "result3");
		addStackToNBT(inventoryContents[3], tagCompound, "result4");
		addStackToNBT(inventoryContents[4], tagCompound, "result5");
		addStackToNBT(inventoryContents[5], tagCompound, "result6");
		addStackToNBT(inventoryContents[6], tagCompound, "result7");
		addStackToNBT(inventoryContents[7], tagCompound, "result8");
		addStackToNBT(inventoryContents[8], tagCompound, "ingredient");
		addStackToNBT(inventoryContents[9], tagCompound, "fuelStack");

	}

	@Override
	public Packet getDescriptionPacket () {
		NBTTagCompound tagCompound = new NBTTagCompound();

		writeSharedNBT(tagCompound);

		return new S35PacketUpdateTileEntity(pos, 0, tagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		writeSharedNBT(tagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager networkManager, S35PacketUpdateTileEntity packet) {
		NBTTagCompound tagCompound = packet.getNbtCompound();

		progressBar = tagCompound.getInteger("progress");
		fuelBar = tagCompound.getInteger("fuel");
		inventoryContents = new ItemStack[]{
				getStackFromNBT(tagCompound, "result1"),
				getStackFromNBT(tagCompound, "result2"),
				getStackFromNBT(tagCompound, "result3"),
				getStackFromNBT(tagCompound, "result4"),
				getStackFromNBT(tagCompound, "result5"),
				getStackFromNBT(tagCompound, "result6"),
				getStackFromNBT(tagCompound, "result7"),
				getStackFromNBT(tagCompound, "result8"),
				getStackFromNBT(tagCompound, "ingredient"),
				getStackFromNBT(tagCompound, "fuelStack")};

	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		progressBar = tagCompound.getInteger("progress");
		fuelBar = tagCompound.getInteger("fuel");
		inventoryContents = new ItemStack[]{
				getStackFromNBT(tagCompound, "result1"),
				getStackFromNBT(tagCompound, "result2"),
				getStackFromNBT(tagCompound, "result3"),
				getStackFromNBT(tagCompound, "result4"),
				getStackFromNBT(tagCompound, "result5"),
				getStackFromNBT(tagCompound, "result6"),
				getStackFromNBT(tagCompound, "result7"),
				getStackFromNBT(tagCompound, "result8"),
				getStackFromNBT(tagCompound, "ingredient"),
				getStackFromNBT(tagCompound, "fuelStack")};
	}

	@Override
	public int[] getSlotsForFace (EnumFacing side) {
		if (side == EnumFacing.UP) {return new int[]{8};}
		if (side == EnumFacing.DOWN) {return new int[]{0, 1, 2, 3, 4, 5, 6, 7};}
		return new int[]{9};
	}

	@Override
	public boolean canInsertItem (int index, ItemStack itemStackIn, EnumFacing direction) {
		return index == 8 || index == 9;
	}

	@Override
	public boolean canExtractItem (int index, ItemStack stack, EnumFacing direction) {
		return true;
	}

	@Override
	public int getSizeInventory () {
		return 10;
	}

	@Override
	public ItemStack getStackInSlot (int index) {
		if(index >= 0 && index < inventoryContents.length) {
			return inventoryContents[index];
		}
		return null;
	}

	@Override
	public ItemStack decrStackSize (int index, int count) {
		ItemStack stackInSlot = getStackInSlot(index);
		if(stackInSlot == null) {return null;}

		if(stackInSlot.stackSize <= count) {
			setInventorySlotContents(index, null);
			return stackInSlot;
		}

		stackInSlot.stackSize -= count;
		markDirty();

		return new ItemStack(stackInSlot.getItem(), count, stackInSlot.getItemDamage());
	}

	@Override
	public ItemStack getStackInSlotOnClosing (int index) {
		ItemStack stackInSlot = getStackInSlot(index);
		if(stackInSlot == null) {return null;}

		setInventorySlotContents(index, null);
		return stackInSlot;
	}

	@Override
	public void setInventorySlotContents (int index, ItemStack stack) {
		if(index < 0 || index >= inventoryContents.length) {return;}

		int stackLimit = getInventoryStackLimit();
		if(stack != null && stack.stackSize > stackLimit) {stack.stackSize = stackLimit;}

		inventoryContents[index] = stack;
		markDirty();

		worldObj.markBlockForUpdate(pos);
	}


	@Override
	public int getInventoryStackLimit () {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer (EntityPlayer playerIn) {
		return true;
	}

	@Override
	public void openInventory (EntityPlayer playerIn) {

	}

	@Override
	public void closeInventory (EntityPlayer playerIn) {

	}

	@Override
	public boolean isItemValidForSlot (int index, ItemStack stack) {
		if (index >= 0 && index <= inventoryContents.length && index != 8) {
			return true;
		}
		return index == 8;
	}

	@Override
	public int getField (int id) {
		return 0;
	}

	@Override
	public void setField (int id, int value) {

	}

	@Override
	public int getFieldCount () {
		return 0;
	}

	@Override
	public void clear () {

	}

	@Override
	public void update () {

	}

	@Override
	public String getName () {
		return null;
	}

	@Override
	public boolean hasCustomName () {
		return false;
	}

	@Override
	public IChatComponent getDisplayName () {
		return null;
	}
}
