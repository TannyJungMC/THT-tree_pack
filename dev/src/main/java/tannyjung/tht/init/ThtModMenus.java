
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.tht.init;

import tannyjung.tht.world.inventory.PresetFixerGUIMenu;
import tannyjung.tht.ThtMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class ThtModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ThtMod.MODID);
	public static final RegistryObject<MenuType<PresetFixerGUIMenu>> PRESET_FIXER_GUI = REGISTRY.register("preset_fixer_gui", () -> IForgeMenuType.create(PresetFixerGUIMenu::new));
}
