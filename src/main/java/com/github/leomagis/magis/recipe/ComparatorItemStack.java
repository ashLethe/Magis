package com.github.leomagis.magis.recipe;

import net.minecraft.item.ItemStack;

import java.util.Comparator;

public class ComparatorItemStack implements Comparator<ItemStack> {

    @Override
    public int compare(ItemStack stack1, ItemStack stack2) {
        return (stack1.getItem().hashCode() + stack1.getItemDamage()) -
               (stack2.getItem().hashCode() + stack2.getItemDamage());
    }

}
