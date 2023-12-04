package fr.iamacat.catmod.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import fr.iamacat.catmod.init.RegisterItems;

public class CatTabMisc extends CreativeTabs {

    public CatTabMisc(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return RegisterItems.catCoin;
    }

    @Override
    public String getTranslatedTabLabel() {
        return "Cat Misc"; // change this to the desired name of the creative tab // minecraft code colors :
                           // https://minecraft.fr/faq/code-couleur-minecraft/
    }
}
