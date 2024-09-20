
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.tht.init;

import tannyjung.tht.ThtMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class ThtModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThtMod.MODID);
	public static final RegistryObject<CreativeModeTab> THT_TAB = REGISTRY.register("tht_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tht.tht_tab")).icon(() -> new ItemStack(ThtModBlocks.YOKAI.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ThtModBlocks.RANDOM_TREE_BLOCK.get().asItem());
				tabData.accept(ThtModBlocks.WAYPOINT_FLOWER.get().asItem());
				tabData.accept(ThtModBlocks.YOKAI.get().asItem());
				tabData.accept(ThtModBlocks.FALCON.get().asItem());
				tabData.accept(ThtModBlocks.WENDY.get().asItem());
				tabData.accept(ThtModBlocks.SNOWLAND.get().asItem());
				tabData.accept(ThtModBlocks.ART_OF_VINES.get().asItem());
				tabData.accept(ThtModBlocks.BEANSTALK.get().asItem());
				tabData.accept(ThtModBlocks.BEEKEEPER.get().asItem());
				tabData.accept(ThtModBlocks.CHRISTMAS_TREE.get().asItem());
				tabData.accept(ThtModBlocks.MALUS_DOMESTICA.get().asItem());
				tabData.accept(ThtModBlocks.PUMPKIN.get().asItem());
				tabData.accept(ThtModBlocks.RUST.get().asItem());
				tabData.accept(ThtModBlocks.THE_ASPIRANT.get().asItem());
				tabData.accept(ThtModBlocks.LEGION.get().asItem());
				tabData.accept(ThtModBlocks.OLD_WITCH.get().asItem());
				tabData.accept(ThtModBlocks.SNOW_WHITE.get().asItem());
				tabData.accept(ThtModBlocks.SKY_ISLAND_CHAIN.get().asItem());
				tabData.accept(ThtModBlocks.HALCYON.get().asItem());
				tabData.accept(ThtModBlocks.WHITE_FAIRY.get().asItem());
				tabData.accept(ThtModItems.PRESET_FIXER.get());
			})

					.build());
}
