package com.github.leomagis.magis.container;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.enums.EnumCompoundType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerElementalCentrifuge extends Container {

	private final IInventory inventory;

	public ContainerElementalCentrifuge(EntityPlayer player, IInventory inventory) {
		this(player.inventory, inventory);
	}


	protected ContainerElementalCentrifuge (InventoryPlayer playerInventory, IInventory inventory) {

		this.inventory = inventory;

		addSlotToContainer(new Slot(inventory, 0,120, 31) {

			public boolean isItemValid(ItemStack stack) {
				return stack.getItem() == Magis.elementalCompound;
			}

			public int getSlotStackLimit() {
				return 1;
			}

		});
		addSlotToContainer(new Slot(inventory, 1,183, 57) {

			public boolean isItemValid(ItemStack stack) {
				return stack.getItem() == Magis.elementalCompound;
			}

			public int getSlotStackLimit() {
				return 1;
			}

		});
		addSlotToContainer(new Slot(inventory, 2,209, 120) {

			public boolean isItemValid(ItemStack stack) {
				return stack.getItem() == Magis.elementalCompound;
			}

			public int getSlotStackLimit() {
				return 1;
			}

		});
		addSlotToContainer(new Slot(inventory, 3,183, 183) {

			public boolean isItemValid(ItemStack stack) {
				return stack.getItem() == Magis.elementalCompound;
			}

			public int getSlotStackLimit() {
				return 1;
			}

		});
		addSlotToContainer(new Slot(inventory, 4,120, 209) {

			public boolean isItemValid(ItemStack stack) {
				return stack.getItem() == Magis.elementalCompound;
			}

			public int getSlotStackLimit() {
				return 1;
			}

		});
		addSlotToContainer(new Slot(inventory, 5,57, 183) {

			public boolean isItemValid(ItemStack stack) {
				return stack.getItem() == Magis.elementalCompound;
			}

			public int getSlotStackLimit() {
				return 1;
			}

		});
		addSlotToContainer(new Slot(inventory, 6,31, 120) {

			public boolean isItemValid(ItemStack stack) {
				return stack.getItem() == Magis.elementalCompound;
			}

			public int getSlotStackLimit() {
				return 1;
			}

		});
		addSlotToContainer(new Slot(inventory, 7,57, 57) {

			public boolean isItemValid(ItemStack stack) {
				return stack.getItem() == Magis.elementalCompound;
			}

			public int getSlotStackLimit() {
				return 1;
			}

		});
		addSlotToContainer(new Slot(inventory, 8,120, 102) {

			public boolean isItemValid(ItemStack stack) {
				return true;
			}

			public int getSlotStackLimit() {
				return 64;
			}

		});
		addSlotToContainer(new Slot(inventory, 9,120, 138) {

			public boolean isItemValid(ItemStack stack) {
				return stack.getItem() == Magis.elementalCompound && stack.getItemDamage() == EnumCompoundType.KINETIC.ordinal();
			}

			public int getSlotStackLimit() {
				return 64;
			}

		});

		for(int i=0;i<3;++i) {
			for(int j=0;j<9;++j) {
				addSlotToContainer(new Slot(playerInventory, j+i*9+9, 48+j*18, i*18+265));
			}
		}

		for(int i=0;i<9;++i) {
			addSlotToContainer(new Slot(playerInventory, i, 48+i*18, 323));
		}
	}

	@Override
	public boolean canInteractWith (EntityPlayer playerIn) {return inventory.isUseableByPlayer(playerIn);}
}
