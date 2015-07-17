package com.github.leomagis.magis.entity.tile;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.enums.EnumCompoundType;
import com.github.leomagis.magis.recipe.CentrifugeRecipeRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Tuple;

public class TileElementalCentrifuge extends TileEntity implements IUpdatePlayerListBox {

	private int currentFuel = 0;
	private int recipeTickRemaining = 0;
	
	private ItemStack[] inventoryContents= new ItemStack[10];

	private Tuple[] currentRecipeResult = new Tuple[8];

	private ItemStack ingredient;

	private ItemStack fuel;

	public void doRecipe () {
		ingredient = inventoryContents[9] != null ? inventoryContents[9] : null;
		fuel = inventoryContents[10];
		recipeTickRemaining = 40;
		currentRecipeResult = CentrifugeRecipeRegistry.getRecipeResult(ingredient);

	}
	
	@Override
	public void update () {
		if (currentFuel == 0 && fuel.getItem() == Magis.elementalCompound && fuel.getItemDamage() == EnumCompoundType.KINETIC.ordinal()) {
			currentFuel = 2000;
			fuel = new ItemStack(Magis.elementalCompound, fuel.stackSize - 1, EnumCompoundType.KINETIC.ordinal());
		}
		if (currentFuel > 2000) {
			currentFuel = 2000;
		}
	}
}
