package com.github.leomagis.magis.item;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.enums.EnumCompoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemElementalCompound extends Item {

    public ItemElementalCompound() {
        setHasSubtypes(true);
        setMaxDamage(0);
        setCreativeTab(Magis.tabMagis);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return "item.itemCompound" +
               EnumCompoundType.getFromStack(itemStack).getName();
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List subItems) {
        int numItems = EnumCompoundType.values().length;

        for(int i=0;i<numItems;++i) {
            subItems.add(new ItemStack(item, 1, i));
        }
    }

}
