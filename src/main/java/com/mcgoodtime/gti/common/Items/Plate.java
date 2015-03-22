package com.mcgoodtime.gti.common.Items;

import com.mcgoodtime.gti.common.core.CreativeTabGTI;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class Plate extends Item {

	public static Item DimPlate = new Item()
	.setUnlocalizedName("DiamondPlate")
	.setCreativeTab(CreativeTabGTI.tab)
	.setTextureName("gti:itemDiamondPlate");
	public static Item DenseDimPlate = new Item()
	.setUnlocalizedName("DenseDiamondPlate")
	.setCreativeTab(CreativeTabGTI.tab)
	.setTextureName("gti:itemDenseDiamondPlate");
	
	public static void preInit() {
		GameRegistry.registerItem(DimPlate, "DiamondPlate");
		GameRegistry.registerItem(DenseDimPlate, "DenseDiamondPlate");
	}	
	
}