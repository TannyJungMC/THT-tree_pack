
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.tht.init;

import tannyjung.tht.block.entity.YokaiBlockEntity;
import tannyjung.tht.block.entity.WhiteFairyBlockEntity;
import tannyjung.tht.block.entity.WendyBlockEntity;
import tannyjung.tht.block.entity.TheAspirantBlockEntity;
import tannyjung.tht.block.entity.SnowlandBlockEntity;
import tannyjung.tht.block.entity.SnowWhiteBlockEntity;
import tannyjung.tht.block.entity.SkyIslandChainBlockEntity;
import tannyjung.tht.block.entity.RustBlockEntity;
import tannyjung.tht.block.entity.RandomTreeBlockBlockEntity;
import tannyjung.tht.block.entity.PumpkinBlockEntity;
import tannyjung.tht.block.entity.OldWitchBlockEntity;
import tannyjung.tht.block.entity.MalusDomesticaBlockEntity;
import tannyjung.tht.block.entity.LegionBlockEntity;
import tannyjung.tht.block.entity.HalcyonBlockEntity;
import tannyjung.tht.block.entity.FalconBlockEntity;
import tannyjung.tht.block.entity.ChristmasTreeBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTwigOuterBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTwigInnerBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTwigCoreBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTrunkOuterBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTrunkInnerBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTrunkCoreBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTertiaryRootOuterBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTertiaryRootInnerBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTertiaryRootCoreBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTaprootOuterBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTaprootInnerBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerTaprootCoreBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerSecondaryRootOuterBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerSecondaryRootInnerBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerSecondaryRootCoreBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerLeavesTwigOuterBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerLeavesTwigInnerBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerLeavesTwigCoreBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerLeavesBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerLeaves2BlockEntity;
import tannyjung.tht.block.entity.BlockPlacerFineRootOuterBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerFineRootInnerBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerFineRootCoreBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerBranchOuterBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerBranchInnerBlockEntity;
import tannyjung.tht.block.entity.BlockPlacerBranchCoreBlockEntity;
import tannyjung.tht.block.entity.BeekeeperBlockEntity;
import tannyjung.tht.block.entity.BeanstalkBlockEntity;
import tannyjung.tht.block.entity.ArtOfVinesBlockEntity;
import tannyjung.tht.ThtMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class ThtModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ThtMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> RANDOM_TREE_BLOCK = register("random_tree_block", ThtModBlocks.RANDOM_TREE_BLOCK, RandomTreeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> YOKAI = register("yokai", ThtModBlocks.YOKAI, YokaiBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FALCON = register("falcon", ThtModBlocks.FALCON, FalconBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WENDY = register("wendy", ThtModBlocks.WENDY, WendyBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SNOWLAND = register("snowland", ThtModBlocks.SNOWLAND, SnowlandBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ART_OF_VINES = register("art_of_vines", ThtModBlocks.ART_OF_VINES, ArtOfVinesBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BEANSTALK = register("beanstalk", ThtModBlocks.BEANSTALK, BeanstalkBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BEEKEEPER = register("beekeeper", ThtModBlocks.BEEKEEPER, BeekeeperBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHRISTMAS_TREE = register("christmas_tree", ThtModBlocks.CHRISTMAS_TREE, ChristmasTreeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MALUS_DOMESTICA = register("malus_domestica", ThtModBlocks.MALUS_DOMESTICA, MalusDomesticaBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PUMPKIN = register("pumpkin", ThtModBlocks.PUMPKIN, PumpkinBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RUST = register("rust", ThtModBlocks.RUST, RustBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> THE_ASPIRANT = register("the_aspirant", ThtModBlocks.THE_ASPIRANT, TheAspirantBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LEGION = register("legion", ThtModBlocks.LEGION, LegionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> OLD_WITCH = register("old_witch", ThtModBlocks.OLD_WITCH, OldWitchBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SNOW_WHITE = register("snow_white", ThtModBlocks.SNOW_WHITE, SnowWhiteBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SKY_ISLAND_CHAIN = register("sky_island_chain", ThtModBlocks.SKY_ISLAND_CHAIN, SkyIslandChainBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HALCYON = register("halcyon", ThtModBlocks.HALCYON, HalcyonBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WHITE_FAIRY = register("white_fairy", ThtModBlocks.WHITE_FAIRY, WhiteFairyBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TAPROOT_OUTER = register("block_placer_taproot_outer", ThtModBlocks.BLOCK_PLACER_TAPROOT_OUTER, BlockPlacerTaprootOuterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TAPROOT_INNER = register("block_placer_taproot_inner", ThtModBlocks.BLOCK_PLACER_TAPROOT_INNER, BlockPlacerTaprootInnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TAPROOT_CORE = register("block_placer_taproot_core", ThtModBlocks.BLOCK_PLACER_TAPROOT_CORE, BlockPlacerTaprootCoreBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_SECONDARY_ROOT_CORE = register("block_placer_secondary_root_core", ThtModBlocks.BLOCK_PLACER_SECONDARY_ROOT_CORE, BlockPlacerSecondaryRootCoreBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_SECONDARY_ROOT_INNER = register("block_placer_secondary_root_inner", ThtModBlocks.BLOCK_PLACER_SECONDARY_ROOT_INNER, BlockPlacerSecondaryRootInnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_SECONDARY_ROOT_OUTER = register("block_placer_secondary_root_outer", ThtModBlocks.BLOCK_PLACER_SECONDARY_ROOT_OUTER, BlockPlacerSecondaryRootOuterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TERTIARY_ROOT_CORE = register("block_placer_tertiary_root_core", ThtModBlocks.BLOCK_PLACER_TERTIARY_ROOT_CORE, BlockPlacerTertiaryRootCoreBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TERTIARY_ROOT_INNER = register("block_placer_tertiary_root_inner", ThtModBlocks.BLOCK_PLACER_TERTIARY_ROOT_INNER, BlockPlacerTertiaryRootInnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TERTIARY_ROOT_OUTER = register("block_placer_tertiary_root_outer", ThtModBlocks.BLOCK_PLACER_TERTIARY_ROOT_OUTER, BlockPlacerTertiaryRootOuterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_FINE_ROOT_CORE = register("block_placer_fine_root_core", ThtModBlocks.BLOCK_PLACER_FINE_ROOT_CORE, BlockPlacerFineRootCoreBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_FINE_ROOT_INNER = register("block_placer_fine_root_inner", ThtModBlocks.BLOCK_PLACER_FINE_ROOT_INNER, BlockPlacerFineRootInnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_FINE_ROOT_OUTER = register("block_placer_fine_root_outer", ThtModBlocks.BLOCK_PLACER_FINE_ROOT_OUTER, BlockPlacerFineRootOuterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TRUNK_CORE = register("block_placer_trunk_core", ThtModBlocks.BLOCK_PLACER_TRUNK_CORE, BlockPlacerTrunkCoreBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TRUNK_INNER = register("block_placer_trunk_inner", ThtModBlocks.BLOCK_PLACER_TRUNK_INNER, BlockPlacerTrunkInnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TRUNK_OUTER = register("block_placer_trunk_outer", ThtModBlocks.BLOCK_PLACER_TRUNK_OUTER, BlockPlacerTrunkOuterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_BRANCH_CORE = register("block_placer_branch_core", ThtModBlocks.BLOCK_PLACER_BRANCH_CORE, BlockPlacerBranchCoreBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_BRANCH_INNER = register("block_placer_branch_inner", ThtModBlocks.BLOCK_PLACER_BRANCH_INNER, BlockPlacerBranchInnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_BRANCH_OUTER = register("block_placer_branch_outer", ThtModBlocks.BLOCK_PLACER_BRANCH_OUTER, BlockPlacerBranchOuterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TWIG_CORE = register("block_placer_twig_core", ThtModBlocks.BLOCK_PLACER_TWIG_CORE, BlockPlacerTwigCoreBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TWIG_INNER = register("block_placer_twig_inner", ThtModBlocks.BLOCK_PLACER_TWIG_INNER, BlockPlacerTwigInnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_TWIG_OUTER = register("block_placer_twig_outer", ThtModBlocks.BLOCK_PLACER_TWIG_OUTER, BlockPlacerTwigOuterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_LEAVES = register("block_placer_leaves", ThtModBlocks.BLOCK_PLACER_LEAVES, BlockPlacerLeavesBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_LEAVES_2 = register("block_placer_leaves_2", ThtModBlocks.BLOCK_PLACER_LEAVES_2, BlockPlacerLeaves2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_LEAVES_TWIG_CORE = register("block_placer_leaves_twig_core", ThtModBlocks.BLOCK_PLACER_LEAVES_TWIG_CORE, BlockPlacerLeavesTwigCoreBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_LEAVES_TWIG_INNER = register("block_placer_leaves_twig_inner", ThtModBlocks.BLOCK_PLACER_LEAVES_TWIG_INNER, BlockPlacerLeavesTwigInnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_PLACER_LEAVES_TWIG_OUTER = register("block_placer_leaves_twig_outer", ThtModBlocks.BLOCK_PLACER_LEAVES_TWIG_OUTER, BlockPlacerLeavesTwigOuterBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
