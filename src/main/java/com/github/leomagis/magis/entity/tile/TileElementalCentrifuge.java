package com.github.leomagis.magis.entity.tile;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.enums.EnumCompoundType;
import com.github.leomagis.magis.recipe.CentrifugeRecipeRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class TileElementalCentrifuge extends TileEntity implements IUpdatePlayerListBox {

	private int currentFuel = 0;
	private int recipeTicksRemaining = 0;

    private ItemStack[] currentRecipeResult;
	private ItemStack[] inventoryContents = new ItemStack[10];

	public void doRecipe () {
		currentRecipeResult = CentrifugeRecipeRegistry.getRecipeResults(inventoryContents[8]);
        if(currentRecipeResult == null) {
            cancelCurrentRecipe();
            return;
        }

        recipeTicksRemaining = 40;
        worldObj.markBlockForUpdate(pos);
	}

    private void cancelCurrentRecipe() {
        currentRecipeResult = null;
        recipeTicksRemaining = 0;
        worldObj.markBlockForUpdate(pos);
    }

	@Override
	public void update () {
        ItemStack fuelStack = inventoryContents[9];
		if (currentFuel == 0 && fuelStack.getItem() == Magis.elementalCompound &&
            fuelStack.getItemDamage() == EnumCompoundType.KINETIC.ordinal()) {

            currentFuel = 2000;
			--fuelStack.stackSize;
		}
    }
}
