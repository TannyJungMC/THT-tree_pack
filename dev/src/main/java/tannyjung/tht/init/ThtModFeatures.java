
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.tht.init;

import tannyjung.tht.world.features.WorldGenFeature;
import tannyjung.tht.ThtMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

@Mod.EventBusSubscriber
public class ThtModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, ThtMod.MODID);
	public static final RegistryObject<Feature<?>> WORLD_GEN = REGISTRY.register("world_gen", WorldGenFeature::new);
}
