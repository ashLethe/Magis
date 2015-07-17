package com.github.leomagis.magis.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;

import java.util.ArrayList;
import java.util.List;

public class CentrifugeRecipeRegistry {

    /*
     * 1. component to break down
     * 2. Tuple:
     *    1. ItemStack[]: result item(s)
     *    2. double[]: chances of obtaining items
     */
	private static final List<Tuple> recipes = new ArrayList<Tuple>();

    /*
     * results must be of length 2 to 16, inclusive. The contents of
     * results should be 'paired', with the first item in each pair an
     * ItemStack and the second a double value. The ItemStack in each pair
     * determines the potential result from processing the ingredient in a
     * centrifuge, whereas the double value is the percent chance that it will
     * be produced.
     */
	public void registerRecipe (ItemStack ingredient, Object[] results) {
        if (ingredient == null || !isValidResults(results)) {return;}

        int numResults = results.length / 2;
        ItemStack[] resultItems = new ItemStack[numResults];
        double[] resultChances = new double[numResults];

        for(int i=0;i<numResults;++i) {
            int pairIndex = i * 2;
            resultItems[i] = (ItemStack) results[pairIndex];
            resultChances[i] = (Double) results[pairIndex+1];
        }

        recipes.add(new Tuple(ingredient, new Tuple(resultItems, resultChances)));
	}

	public static ItemStack[] getRecipeResults (ItemStack ingredient) {
		if (ingredient == null) {return null;}

		for (Tuple recipe : recipes) {
			if (ingredient != recipe.getFirst()) {continue;}

            Tuple results = (Tuple) recipe.getSecond();
            ItemStack[] resultItems = (ItemStack[]) results.getFirst();
            double[] resultChances = (double[]) results.getSecond();

            List<ItemStack> weightedResults = new ArrayList<ItemStack>(resultItems.length);
            for(int i=0;i<resultItems.length;++i) {
                if(Math.random() < resultChances[i]) {
                    weightedResults.add(resultItems[i]);
                }
            }

            ItemStack[] finalResults = new ItemStack[weightedResults.size()];
            return weightedResults.toArray(finalResults);
        }
		return null;
	}

	private static boolean isValidResults (Object[] results) {
		if (results == null || results.length < 2 || results.length > 16 || (results.length & 1) != 0) {return false;}
		for (int i=0;i<results.length;i+=2) {
            if (!(results[i] instanceof ItemStack) ||
                !(results[i+1] instanceof Double)) {return false;}
        }
		return true;
	}
}
