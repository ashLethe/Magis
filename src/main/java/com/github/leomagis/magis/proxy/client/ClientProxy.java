package com.github.leomagis.magis.proxy.client;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() {
        ItemModelMesher modelRegistry = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        modelRegistry.register(Item.getItemFromBlock(Magis.evercrystal), 0,
                new ModelResourceLocation("magis:blockEvercrystal", "inventory"));

        modelRegistry.register(Magis.crystalShard, 0,
                new ModelResourceLocation("magis:itemCrystalShard", "inventory"));
    }
}
