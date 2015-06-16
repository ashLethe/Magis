package com.github.leomagis.magis;

import com.github.leomagis.magis.block.BlockEvercrystal;
import com.github.leomagis.magis.item.ItemCrystalShard;
import com.github.leomagis.magis.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod(modid = Magis.MODID, name = Magis.NAME, version = Magis.VERSION)
@SuppressWarnings("unused")
public class Magis {
    public static final String MODID = "magis";
    public static final String NAME = "Magis";
    public static final String VERSION = "0.0.0";

    public static SimpleNetworkWrapper networkWrapper;

    //block declaration
    public static BlockEvercrystal evercrystal;

    //Item declaration
    public static ItemCrystalShard crystalShard;

    @Mod.Instance(value = Magis.MODID)
    public static Magis instance;

    @SidedProxy(clientSide="com.github.leomagis.magis.proxy.client.ClientProxy",
            serverSide="com.github.leomagis.magis.proxy.CommonProxy")
    public static CommonProxy proxy;

    //Creative tab declaration
    public static final CreativeTabs tabMagis = new CreativeTabs("tabMagis") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(evercrystal);
        }
    };
    @SuppressWarnings("unused")
        @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //block Initialization
        evercrystal = new BlockEvercrystal();

        //block registration
        GameRegistry.registerBlock(evercrystal, "blockEvercrystal");

        //Recipe registration
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(evercrystal),
                            "SSS",
                            "SSS",
                            "SSS",
                            'S', "crystalShard"
                )
        );

        //Item Initialization
        crystalShard = new ItemCrystalShard();

        //Item registration
        GameRegistry.registerItem(crystalShard, "itemCrystalShard");
    }

    @SuppressWarnings("unused")
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenderers();
    }
}
