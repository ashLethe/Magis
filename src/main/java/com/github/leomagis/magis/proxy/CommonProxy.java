package com.github.leomagis.magis.proxy;

import com.github.leomagis.magis.entity.tile.TileFusionStation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void registerRenderers() {}

    public void registerTileEntities (){
        GameRegistry.registerTileEntity(TileFusionStation.class, TileFusionStation.publicName);
    }
}
