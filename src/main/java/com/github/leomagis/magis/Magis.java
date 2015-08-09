package com.github.leomagis.magis;

import com.github.leomagis.magis.block.BlockElementalCentrifuge;
import com.github.leomagis.magis.block.BlockEvercrystal;
import com.github.leomagis.magis.block.BlockFusionStation;
import com.github.leomagis.magis.entity.tile.TileFusionStation;
import com.github.leomagis.magis.enums.EnumCompoundType;
import com.github.leomagis.magis.item.ItemCrystalShard;
import com.github.leomagis.magis.item.ItemElementalCompound;
import com.github.leomagis.magis.proxy.CommonProxy;
import com.github.leomagis.magis.recipe.CentrifugeRecipeRegistry;
import com.github.leomagis.magis.recipe.FusionRecipeRegistry;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Magis.MODID, name = Magis.NAME, version = Magis.VERSION)
@SuppressWarnings("unused")
public class Magis {

    public static final String MODID = "magis";
    public static final String NAME = "Magis";
    public static final String VERSION = "0.4.2";

    public static SimpleNetworkWrapper networkWrapper;

    //block declaration
    public static BlockEvercrystal evercrystal;
    public static BlockFusionStation fusionStation;
	public static BlockElementalCentrifuge elementalCentrifuge;

    //Item declaration
    public static ItemCrystalShard crystalShard;

    public static ItemElementalCompound elementalCompound;

    @Mod.Instance(value = Magis.MODID)
    public static Magis instance;

    @SidedProxy(clientSide="com.github.leomagis.magis.proxy.client.ClientProxy",
            serverSide="com.github.leomagis.magis.proxy.CommonProxy")
    public static CommonProxy proxy;

    //Creative tab declaration
    public static final CreativeTabs tabMagis = new CreativeTabs("tabMagis") {
        @Override
        public Item getTabIconItem() {return crystalShard;}
    };

    @SuppressWarnings("unused")
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //block Initialization
        evercrystal = new BlockEvercrystal();
        fusionStation = new BlockFusionStation();
		elementalCentrifuge = new BlockElementalCentrifuge();

        //block registration
        GameRegistry.registerBlock(evercrystal, "blockEvercrystal");
        GameRegistry.registerBlock(fusionStation, "blockFusionStation");
		GameRegistry.registerBlock(elementalCentrifuge, "blockElementalCentrifuge");

        //Tile Entity registration
        GameRegistry.registerTileEntity(TileFusionStation.class, "tileFusionStation");

        //Item Initialization
        crystalShard = new ItemCrystalShard();
        elementalCompound = new ItemElementalCompound();

        //Item registration
        GameRegistry.registerItem(crystalShard, "itemCrystalShard");
        GameRegistry.registerItem(elementalCompound, "itemCompound");

        //Damage-based Item model registration
        ModelBakery.addVariantName(elementalCompound,
				"magis:itemCompoundAura",
				"magis:itemCompoundAquis",
				"magis:itemCompoundEliquis",
				"magis:itemCompoundFiirus",
				"magis:itemCompoundEartha",
				"magis:itemCompoundYin",
				"magis:itemCompoundYan",
				"magis:itemCompoundChronus",
				"magis:itemCompoundPsycos",
				"magis:itemCompoundAuraRune",
				"magis:itemCompoundAquisRune",
				"magis:itemCompoundEliquisRune",
				"magis:itemCompoundFiirusRune",
				"magis:itemCompoundEarthaRune",
				"magis:itemCompoundYinRune",
				"magis:itemCompoundYanRune",
				"magis:itemCompoundChronusRune",
				"magis:itemCompoundPsycosRune");

        //Recipe registration
        ItemStack stackShard = new ItemStack(crystalShard);
        GameRegistry.addShapedRecipe(new ItemStack(evercrystal),
				"SSS",
				"SSS",
				"SSS",
				'S', stackShard);

        //Fusion recipe registration
		ItemStack stackAura = new ItemStack(elementalCompound, 1, EnumCompoundType.AURA.ordinal());
		ItemStack stackAiry = new ItemStack(elementalCompound, 1, EnumCompoundType.AIRY.ordinal());
		ItemStack stackProximity = new ItemStack(elementalCompound, 1, EnumCompoundType.PROXIMITY.ordinal());
		ItemStack stackAuraRune = new ItemStack(elementalCompound, 1, EnumCompoundType.AURA_RUNE.ordinal());

		ItemStack stackAquis = new ItemStack(elementalCompound, 1, EnumCompoundType.AQUIS.ordinal());
		ItemStack stackFluidic = new ItemStack(elementalCompound, 1, EnumCompoundType.FLUIDIC.ordinal());
		ItemStack stackWatery = new ItemStack(elementalCompound, 1, EnumCompoundType.WATERY.ordinal());
		ItemStack stackAquisRune = new ItemStack(elementalCompound, 1, EnumCompoundType.AQUIS_RUNE.ordinal());

		ItemStack stackChronus = new ItemStack(elementalCompound, 1, EnumCompoundType.CHRONUS.ordinal());
		ItemStack stackChronusRune = new ItemStack(elementalCompound, 1, EnumCompoundType.CHRONUS_RUNE.ordinal());

		ItemStack stackEartha = new ItemStack(elementalCompound, 1, EnumCompoundType.EARTHA.ordinal());
		ItemStack stackEarthy = new ItemStack(elementalCompound, 1, EnumCompoundType.EARTHY.ordinal());
		ItemStack stackMetallic = new ItemStack(elementalCompound, 1, EnumCompoundType.METALLIC.ordinal());
		ItemStack stackSolid = new ItemStack(elementalCompound, 1, EnumCompoundType.SOLID.ordinal());
		ItemStack stackEarthaRune = new ItemStack(elementalCompound, 1, EnumCompoundType.EARTHA_RUNE.ordinal());

		ItemStack stackEliquis = new ItemStack(elementalCompound, 1, EnumCompoundType.ELIQUIS.ordinal());
		ItemStack stackElectric = new ItemStack(elementalCompound, 1, EnumCompoundType.ELECTRIC.ordinal());
		ItemStack stackLight = new ItemStack(elementalCompound, 1, EnumCompoundType.LIGHT.ordinal());
		ItemStack stackMagnetic = new ItemStack(elementalCompound, 1, EnumCompoundType.MAGNETIC.ordinal());
		ItemStack stackEliquisRune = new ItemStack(elementalCompound, 1, EnumCompoundType.ELIQUIS_RUNE.ordinal());

		ItemStack stackFiirus = new ItemStack(elementalCompound, 1, EnumCompoundType.FIIRUS.ordinal());
		ItemStack stackHeat = new ItemStack(elementalCompound, 1, EnumCompoundType.HEAT.ordinal());
		ItemStack stackKinetic = new ItemStack(elementalCompound, 1, EnumCompoundType.KINETIC.ordinal());
		ItemStack stackPlasma = new ItemStack(elementalCompound, 1, EnumCompoundType.PLASMA.ordinal());
		ItemStack stackFiirusRune = new ItemStack(elementalCompound, 1, EnumCompoundType.FIIRUS_RUNE.ordinal());

		ItemStack stackPsycos = new ItemStack(elementalCompound, 1, EnumCompoundType.PSYCOS.ordinal());
		ItemStack stackPsycosRune = new ItemStack(elementalCompound, 1, EnumCompoundType.PSYCOS_RUNE.ordinal());

		ItemStack stackYan = new ItemStack(elementalCompound, 1, EnumCompoundType.YAN.ordinal());
		ItemStack stackLife = new ItemStack(elementalCompound, 1, EnumCompoundType.LIFE.ordinal());
		ItemStack stackOrder = new ItemStack(elementalCompound, 1, EnumCompoundType.ORDER.ordinal());
		ItemStack stackPositive = new ItemStack(elementalCompound, 1, EnumCompoundType.POSITIVE.ordinal());
		ItemStack stackYanRune = new ItemStack(elementalCompound, 1, EnumCompoundType.YAN_RUNE.ordinal());

		ItemStack stackYin = new ItemStack(elementalCompound, 1, EnumCompoundType.YIN.ordinal());
		ItemStack stackChaotic = new ItemStack(elementalCompound, 1, EnumCompoundType.CHAOTIC.ordinal());
		ItemStack stackDeath = new ItemStack(elementalCompound, 1, EnumCompoundType.DEATH.ordinal());
		ItemStack stackNegative	= new ItemStack(elementalCompound, 1, EnumCompoundType.NEGATIVE.ordinal());
		ItemStack stackYinRune = new ItemStack(elementalCompound, 1, EnumCompoundType.YIN_RUNE.ordinal());

		ItemStack stackCobble = new ItemStack(Blocks.cobblestone);
		ItemStack stackIron = new ItemStack(Items.iron_ingot);
		ItemStack stackGold = new ItemStack(Items.gold_ingot);


        FusionRecipeRegistry.registerRecipe(
                stackShard,
                	stackYan,
						stackAura,
						stackAquis,
               			stackEliquis,
                		stackFiirus,
                		stackEartha,
                		stackYin,
                		stackChronus,
                		stackPsycos
		);
		FusionRecipeRegistry.registerRecipe(
				stackAura,
					null,
						stackAiry,
						stackProximity
		);
		FusionRecipeRegistry.registerRecipe(
				stackAquis,
					null,
						stackWatery,
						stackFluidic
		);
		FusionRecipeRegistry.registerRecipe(
				stackEartha,
					null,
						stackEarthy,
						stackMetallic,
						stackSolid);
		FusionRecipeRegistry.registerRecipe(
				stackEliquis,
					null,
						stackElectric,
						stackLight,
						stackMagnetic
		);
		FusionRecipeRegistry.registerRecipe(
				stackFiirus,
					null,
						stackPlasma,
						stackHeat,
						stackKinetic
		);
		FusionRecipeRegistry.registerRecipe(
				stackYan,
					null,
						stackPositive,
						stackLife,
						stackOrder
		);
		FusionRecipeRegistry.registerRecipe(
				stackYin,
					null,
						stackNegative,
						stackChaotic,
						stackDeath
		);
		FusionRecipeRegistry.registerRecipe(
				new ItemStack(elementalCompound, 3, EnumCompoundType.AURA_RUNE.ordinal()),
					stackCobble,
						stackAura,
						stackAura,
						stackAura
		);
		FusionRecipeRegistry.registerRecipe(
				new ItemStack(elementalCompound, 3, EnumCompoundType.AQUIS_RUNE.ordinal()),
					stackCobble,
						stackAquis,
						stackAquis,
						stackAquis
		);
		FusionRecipeRegistry.registerRecipe(
				new ItemStack(elementalCompound, 3, EnumCompoundType.CHRONUS_RUNE.ordinal()),
					stackIron,
						stackChronus,
						stackChronus,
						stackChronus
		);
		FusionRecipeRegistry.registerRecipe(
				new ItemStack(elementalCompound, 3, EnumCompoundType.EARTHA_RUNE.ordinal()),
					stackCobble,
						stackEartha,
						stackEartha,
						stackEartha

		);
		FusionRecipeRegistry.registerRecipe(
				new ItemStack(elementalCompound, 3, EnumCompoundType.ELIQUIS_RUNE.ordinal()),
					stackCobble,
						stackEliquis,
						stackEliquis,
						stackEliquis
		);
		FusionRecipeRegistry.registerRecipe(
				new ItemStack(elementalCompound, 3, EnumCompoundType.FIIRUS_RUNE.ordinal()),
					stackIron,
						stackFiirus,
						stackFiirus,
						stackFiirus
		);
		FusionRecipeRegistry.registerRecipe(
				new ItemStack(elementalCompound, 3, EnumCompoundType.PSYCOS_RUNE.ordinal()),
					stackGold,
						stackPsycos,
						stackPsycos,
						stackPsycos
		);

		//Centrifuge Recipe Registration
		CentrifugeRecipeRegistry.registerRecipe(new ItemStack(Blocks.redstone_ore), new Object[] {stackEarthy, 0.01, stackElectric, 0.07, stackMagnetic, 0.06});
	}


    @SuppressWarnings("unused")
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenderers();
		MinecraftForge.EVENT_BUS.register(this);
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
    }
	@SubscribeEvent
	public void onLivingDropsEvent(LivingDropsEvent event) {
		EntityItem item = new EntityItem(event.entity.getEntityWorld(), event.entity.posX, event.entity.posY, event.entity.posZ);
		ItemStack stack = new ItemStack(elementalCompound);
		Double chance = 0.0;

		if (event.entity instanceof EntityCreeper) {
			stack.setItemDamage(EnumCompoundType.KINETIC.ordinal());
			chance = 0.05;

		} else if (event.entity instanceof EntitySkeleton) {
			if(((EntitySkeleton)event.entity).getSkeletonType() != 1) {
				stack.setItemDamage(EnumCompoundType.DEATH.ordinal());
				chance = 0.05;
			} else {stack.setItemDamage(EnumCompoundType.CHAOTIC.ordinal());
					chance = 0.5;
			}

		} else if (event.entity instanceof EntityMagmaCube) {
			stack.setItemDamage(EnumCompoundType.HEAT.ordinal());
			chance = 0.11;

		} else if (event.entity instanceof EntitySlime) {
			stack.setItemDamage(EnumCompoundType.FLUIDIC.ordinal());
			chance = 0.11;

		} else if (event.entity instanceof EntityZombie) {
			stack.setItemDamage(EnumCompoundType.DEATH.ordinal());
			chance = 0.05;

		} else if (event.entity instanceof EntityGhast) {
			stack.setItemDamage(EnumCompoundType.AIRY.ordinal());
			chance = 0.5;

		} else if (event.entity instanceof EntityBlaze) {
			stack.setItemDamage(EnumCompoundType.PLASMA.ordinal());
			chance = 0.1;

		} else if (event.entity instanceof EntityBat) {
			stack.setItemDamage(EnumCompoundType.AIRY.ordinal());
			chance = 0.03;

		} else if (event.entity instanceof EntityWitch) {
			stack.setItemDamage(EnumCompoundType.PROXIMITY.ordinal());
			chance = 0.2;

		} else if (event.entity instanceof EntityEndermite) {
			stack.setItemDamage(EnumCompoundType.NEGATIVE.ordinal());
			chance = 0.6;

		} else if (event.entity instanceof EntityGuardian) {
			stack.setItemDamage(EnumCompoundType.LIGHT.ordinal());
			chance = 0.1;

		} else if (event.entity instanceof EntitySquid) {
			stack.setItemDamage(EnumCompoundType.WATERY.ordinal());
			chance = 0.05;

		} else if (event.entity instanceof EntityVillager) {
			stack.setItemDamage(EnumCompoundType.ORDER.ordinal());
			chance = 0.3;

		} else if (event.entity instanceof EntityWither) {
			stack.setItemDamage(EnumCompoundType.KINETIC.ordinal());
			chance = 0.7;

		} else if (event.entity instanceof EntityIronGolem) {
			stack.setItemDamage(EnumCompoundType.METALLIC.ordinal());
			chance = 0.05;

		}
		if (Math.random() >= chance) {return;}
			item.setEntityItemStack(stack);
			event.drops.add(item);
		}
	}
