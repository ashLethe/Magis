package com.github.leomagis.magis.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FusionRecipeRegistry {

    /*
     * The first item in each Tuple is an ItemStack that is the recipe result
     * The second item is another Tuple:
     *   The first item in Tuple #2 is the center item in the fusion
     *   The second item is an array with 1-8 other items used in the fusion
     */
    private static final List<Tuple> recipes = new ArrayList<Tuple>();

    private static final Comparator<ItemStack> comparator = new ComparatorItemStack();

    public static void registerRecipe(ItemStack result, ItemStack centerItem, ItemStack... otherItems) {
        if(result == null || !isValidComponents(otherItems)) {return;}

        Arrays.sort(otherItems, comparator);
        recipes.add(new Tuple(result, new Tuple(centerItem, otherItems)));
    }

    public static ItemStack getRecipeResult(ItemStack centerItem, ItemStack[] otherItems) {
        if(!isValidComponents(otherItems)) {return null;}

        nextRecipe: for(Tuple recipe : recipes) {
            Tuple recipeComponents = (Tuple) recipe.getSecond();

            ItemStack recipeCenter = (ItemStack) recipeComponents.getFirst();
            if(recipeCenter == null) {
                if(centerItem != null) {continue;}
            } else if(!recipeCenter.isItemEqual(centerItem)) {
                continue;
            }

            ItemStack[] recipeOthers = (ItemStack[]) recipeComponents.getSecond();
            if(recipeOthers.length != otherItems.length) {continue;}

            Arrays.sort(otherItems, comparator);
            for(int i=0;i<recipeOthers.length;++i) {
                ItemStack recipeOther = recipeOthers[i];
                ItemStack itemOther = otherItems[i];

                if(!recipeOther.isItemEqual(itemOther)) {continue nextRecipe;}
            }

            return (ItemStack) recipe.getFirst();
        }

        return null;
    }

    private static boolean isValidComponents(ItemStack[] otherItems) {
        if(otherItems == null || otherItems.length < 1) {return false;}

        for(ItemStack itemStack : otherItems) {
            if(itemStack == null) {return false;}
        }

        return true;
    }

}
