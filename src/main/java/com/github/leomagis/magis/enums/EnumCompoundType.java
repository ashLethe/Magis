package com.github.leomagis.magis.enums;

import net.minecraft.item.ItemStack;

public enum EnumCompoundType {
    AURA      ("Aura"),
    AQUIS     ("Aquis"),
    ELIQUIS   ("Eliquis"),
    FIIRUS    ("Fiirus"),
    EARTHA    ("Eartha"),
    YIN       ("Yin"),
    YAN       ("Yan"),
    CHRONUS   ("Chronus"),
    PSYCOS    ("Psycos"),

    AURA_RUNE    ("AuraRune"),
    AQUIS_RUNE   ("AquisRune"),
    ELIQUIS_RUNE ("EliquisRune"),
    FIIRUS_RUNE  ("FiirusRune"),
    EARTTHA_RUNE ("EarthaRune"),
    YIN_RUNE     ("YinRune"),
    YAN_RUNE     ("YanRune"),

    AIRY      ("AuraAir"),
    PROXIMITY ("AuraProximity"),

    WATERY    ("AquisWater"),
    FLUIDIC   ("AquisFluid"),

    ELECTRIC  ("EliquisElectric"),
    MAGNETIC  ("EliquisMagnetic"),
    LIGHT     ("EliquisLight"),

    HEAT      ("FiirusHeat"),
    PLASMA    ("FiirusPlasma"),
    KINETIC   ("FiirusKinetic"),

    EARTHY    ("EarthaEarth"),
    METALLIC  ("EarthaMetal"),
    SOLID     ("EarthaSolid"),

    LIFE      ("YinLife"),
    POSITIVE  ("YinPositive"),
    ORDER     ("YinOrder"),

    DEATH     ("YanDeath"),
    NEGATIVE  ("YanNegative"),
    CHAOTIC   ("YanChaos");

    public static EnumCompoundType getFromStack(ItemStack itemStack) {
        EnumCompoundType[] types = values();

        int damageValue = itemStack.getItemDamage();
        if(damageValue < 0 || damageValue > types.length) {
            damageValue = 0;
        }

        return types[itemStack.getItemDamage()];
    }

    private final String name;

    EnumCompoundType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
