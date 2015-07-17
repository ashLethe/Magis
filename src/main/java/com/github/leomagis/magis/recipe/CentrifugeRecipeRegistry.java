package com.github.leomagis.magis.recipe;

import com.github.leomagis.magis.Magis;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CentrifugeRecipeRegistry {

	private static final List<Tuple> recipes = new ArrayList<Tuple>();

	private static final Comparator<ItemStack> comparator = new ComparatorItemStack();

	private static ItemStack[] resultItems = new ItemStack[8];

	public void registerRecipe (ItemStack ingredient, Tuple... results) {
		for (Tuple result : results) {

			resultItems = new ItemStack[]{
					(ItemStack) results[0].getFirst(),
					(ItemStack) results[1].getFirst(),
					(ItemStack) results[2].getFirst(),
					(ItemStack) results[3].getFirst(),
					(ItemStack)results[4].getFirst(),
					(ItemStack)results[5].getFirst(),
					(ItemStack)results[6].getFirst(),
					(ItemStack)results[7].getFirst()};

		}
		if(ingredient == null || !isValidComponents((resultItems))) {return;}

		Arrays.sort(resultItems, comparator);
		recipes.add(new Tuple(ingredient, results));

	}

	public static Tuple[] getRecipeResult (ItemStack ingredient) {
		if (ingredient == null) {return null;}

		for (Tuple recipe : recipes) {
			if (ingredient != recipe.getFirst()) {continue;}
			return (Tuple[]) recipe.getSecond();
		}
		return null;
	}

	private static boolean isValidComponents (ItemStack[] results) {
		if (results == null || results.length < 1) {return false;}
		for (ItemStack itemStack : results) {
			if (!itemStack.getItem().equals(Magis.elementalCompound)) {return false;}
		}
		return true;
	}
}
