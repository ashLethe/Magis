package com.github.leomagis.magis.proxy.client;

import com.github.leomagis.magis.Magis;
import com.github.leomagis.magis.entity.renderer.RenderFusionStation;
import com.github.leomagis.magis.entity.tile.client.TileFusionStationClient;
import com.github.leomagis.magis.enums.EnumCompoundType;
import com.github.leomagis.magis.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() {
        ItemModelMesher modelRegistry = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        modelRegistry.register(Item.getItemFromBlock(Magis.evercrystal), 0,
                new ModelResourceLocation("magis:blockEvercrystal", "inventory"));
        modelRegistry.register(Item.getItemFromBlock(Magis.fusionStation), 0,
                new ModelResourceLocation("magis:blockFusionStation", "inventory"));
        modelRegistry.register(Item.getItemFromBlock(Magis.elementalCentrifuge), 0,
				new ModelResourceLocation("magis:blockElementalCentrifuge", "inventory"));

        modelRegistry.register(Magis.crystalShard, 0,
                new ModelResourceLocation("magis:itemCrystalShard", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.AURA.ordinal(),
                new ModelResourceLocation("magis:itemCompoundAura", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.AQUIS.ordinal(),
                new ModelResourceLocation("magis:itemCompoundAquis", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.ELIQUIS.ordinal(),
                new ModelResourceLocation("magis:itemCompoundEliquis", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.FIIRUS.ordinal(),
                new ModelResourceLocation("magis:itemCompoundFiirus", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.EARTHA.ordinal(),
                new ModelResourceLocation("magis:itemCompoundEartha", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.YIN.ordinal(),
                new ModelResourceLocation("magis:itemCompoundYin", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.YAN.ordinal(),
                new ModelResourceLocation("magis:itemCompoundYan", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.CHRONUS.ordinal(),
                new ModelResourceLocation("magis:itemCompoundChronus", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.PSYCOS.ordinal(),
                new ModelResourceLocation("magis:itemCompoundPsycos", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.AURA_RUNE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundAuraRune", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.AQUIS_RUNE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundAquisRune", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.ELIQUIS_RUNE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundEliquisRune", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.FIIRUS_RUNE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundFiirusRune", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.EARTHA_RUNE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundEarthaRune", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.YIN_RUNE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundYinRune", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.YAN_RUNE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundYanRune", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.CHRONUS_RUNE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundChronusRune", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.PSYCOS_RUNE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundPsycosRune", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.AIRY.ordinal(),
                new ModelResourceLocation("magis:itemCompoundAura", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.PROXIMITY.ordinal(),
                new ModelResourceLocation("magis:itemCompoundAura", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.WATERY.ordinal(),
                new ModelResourceLocation("magis:itemCompoundAquis", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.FLUIDIC.ordinal(),
                new ModelResourceLocation("magis:itemCompoundAquis", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.ELECTRIC.ordinal(),
                new ModelResourceLocation("magis:itemCompoundEliquis", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.MAGNETIC.ordinal(),
                new ModelResourceLocation("magis:itemCompoundEliquis", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.LIGHT.ordinal(),
                new ModelResourceLocation("magis:itemCompoundEliquis", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.HEAT.ordinal(),
                new ModelResourceLocation("magis:itemCompoundFiirus", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.PLASMA.ordinal(),
                new ModelResourceLocation("magis:itemCompoundFiirus", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.KINETIC.ordinal(),
                new ModelResourceLocation("magis:itemCompoundFiirus", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.EARTHY.ordinal(),
                new ModelResourceLocation("magis:itemCompoundEartha", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.METALLIC.ordinal(),
                new ModelResourceLocation("magis:itemCompoundEartha", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.SOLID.ordinal(),
                new ModelResourceLocation("magis:itemCompoundEartha", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.DEATH.ordinal(),
                new ModelResourceLocation("magis:itemCompoundYin", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.NEGATIVE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundYin", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.CHAOTIC.ordinal(),
                new ModelResourceLocation("magis:itemCompoundYin", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.LIFE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundYan", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.POSITIVE.ordinal(),
                new ModelResourceLocation("magis:itemCompoundYan", "inventory"));
        modelRegistry.register(Magis.elementalCompound,
                EnumCompoundType.ORDER.ordinal(),
                new ModelResourceLocation("magis:itemCompoundYan", "inventory"));

        ClientRegistry.bindTileEntitySpecialRenderer(TileFusionStationClient.class, new RenderFusionStation());
    }
}
