
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.tht.init;

import tannyjung.tht.block.YokaiBlock;
import tannyjung.tht.block.WhiteFairyBlock;
import tannyjung.tht.block.WendyBlock;
import tannyjung.tht.block.WaypointFlowerBlock;
import tannyjung.tht.block.TheAspirantBlock;
import tannyjung.tht.block.SnowlandBlock;
import tannyjung.tht.block.SnowWhiteBlock;
import tannyjung.tht.block.SkyIslandChainBlock;
import tannyjung.tht.block.RustBlock;
import tannyjung.tht.block.RandomTreeBlockBlock;
import tannyjung.tht.block.PumpkinBlock;
import tannyjung.tht.block.OldWitchBlock;
import tannyjung.tht.block.MalusDomesticaBlock;
import tannyjung.tht.block.LegionBlock;
import tannyjung.tht.block.HalcyonBlock;
import tannyjung.tht.block.FalconBlock;
import tannyjung.tht.block.ChristmasTreeBlock;
import tannyjung.tht.block.BlockPlacerTwigOuterBlock;
import tannyjung.tht.block.BlockPlacerTwigInnerBlock;
import tannyjung.tht.block.BlockPlacerTwigCoreBlock;
import tannyjung.tht.block.BlockPlacerTrunkOuterBlock;
import tannyjung.tht.block.BlockPlacerTrunkInnerBlock;
import tannyjung.tht.block.BlockPlacerTrunkCoreBlock;
import tannyjung.tht.block.BlockPlacerTertiaryRootOuterBlock;
import tannyjung.tht.block.BlockPlacerTertiaryRootInnerBlock;
import tannyjung.tht.block.BlockPlacerTertiaryRootCoreBlock;
import tannyjung.tht.block.BlockPlacerTaprootOuterBlock;
import tannyjung.tht.block.BlockPlacerTaprootInnerBlock;
import tannyjung.tht.block.BlockPlacerTaprootCoreBlock;
import tannyjung.tht.block.BlockPlacerSecondaryRootOuterBlock;
import tannyjung.tht.block.BlockPlacerSecondaryRootInnerBlock;
import tannyjung.tht.block.BlockPlacerSecondaryRootCoreBlock;
import tannyjung.tht.block.BlockPlacerLeavesTwigOuterBlock;
import tannyjung.tht.block.BlockPlacerLeavesTwigInnerBlock;
import tannyjung.tht.block.BlockPlacerLeavesTwigCoreBlock;
import tannyjung.tht.block.BlockPlacerLeavesBlock;
import tannyjung.tht.block.BlockPlacerLeaves2Block;
import tannyjung.tht.block.BlockPlacerFineRootOuterBlock;
import tannyjung.tht.block.BlockPlacerFineRootInnerBlock;
import tannyjung.tht.block.BlockPlacerFineRootCoreBlock;
import tannyjung.tht.block.BlockPlacerBranchOuterBlock;
import tannyjung.tht.block.BlockPlacerBranchInnerBlock;
import tannyjung.tht.block.BlockPlacerBranchCoreBlock;
import tannyjung.tht.block.BeekeeperBlock;
import tannyjung.tht.block.BeanstalkBlock;
import tannyjung.tht.block.ArtOfVinesBlock;
import tannyjung.tht.ThtMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class ThtModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ThtMod.MODID);
	public static final RegistryObject<Block> RANDOM_TREE_BLOCK = REGISTRY.register("random_tree_block", () -> new RandomTreeBlockBlock());
	public static final RegistryObject<Block> WAYPOINT_FLOWER = REGISTRY.register("waypoint_flower", () -> new WaypointFlowerBlock());
	public static final RegistryObject<Block> YOKAI = REGISTRY.register("yokai", () -> new YokaiBlock());
	public static final RegistryObject<Block> FALCON = REGISTRY.register("falcon", () -> new FalconBlock());
	public static final RegistryObject<Block> WENDY = REGISTRY.register("wendy", () -> new WendyBlock());
	public static final RegistryObject<Block> SNOWLAND = REGISTRY.register("snowland", () -> new SnowlandBlock());
	public static final RegistryObject<Block> ART_OF_VINES = REGISTRY.register("art_of_vines", () -> new ArtOfVinesBlock());
	public static final RegistryObject<Block> BEANSTALK = REGISTRY.register("beanstalk", () -> new BeanstalkBlock());
	public static final RegistryObject<Block> BEEKEEPER = REGISTRY.register("beekeeper", () -> new BeekeeperBlock());
	public static final RegistryObject<Block> CHRISTMAS_TREE = REGISTRY.register("christmas_tree", () -> new ChristmasTreeBlock());
	public static final RegistryObject<Block> MALUS_DOMESTICA = REGISTRY.register("malus_domestica", () -> new MalusDomesticaBlock());
	public static final RegistryObject<Block> PUMPKIN = REGISTRY.register("pumpkin", () -> new PumpkinBlock());
	public static final RegistryObject<Block> RUST = REGISTRY.register("rust", () -> new RustBlock());
	public static final RegistryObject<Block> THE_ASPIRANT = REGISTRY.register("the_aspirant", () -> new TheAspirantBlock());
	public static final RegistryObject<Block> LEGION = REGISTRY.register("legion", () -> new LegionBlock());
	public static final RegistryObject<Block> OLD_WITCH = REGISTRY.register("old_witch", () -> new OldWitchBlock());
	public static final RegistryObject<Block> SNOW_WHITE = REGISTRY.register("snow_white", () -> new SnowWhiteBlock());
	public static final RegistryObject<Block> SKY_ISLAND_CHAIN = REGISTRY.register("sky_island_chain", () -> new SkyIslandChainBlock());
	public static final RegistryObject<Block> HALCYON = REGISTRY.register("halcyon", () -> new HalcyonBlock());
	public static final RegistryObject<Block> WHITE_FAIRY = REGISTRY.register("white_fairy", () -> new WhiteFairyBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TAPROOT_OUTER = REGISTRY.register("block_placer_taproot_outer", () -> new BlockPlacerTaprootOuterBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TAPROOT_INNER = REGISTRY.register("block_placer_taproot_inner", () -> new BlockPlacerTaprootInnerBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TAPROOT_CORE = REGISTRY.register("block_placer_taproot_core", () -> new BlockPlacerTaprootCoreBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_SECONDARY_ROOT_CORE = REGISTRY.register("block_placer_secondary_root_core", () -> new BlockPlacerSecondaryRootCoreBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_SECONDARY_ROOT_INNER = REGISTRY.register("block_placer_secondary_root_inner", () -> new BlockPlacerSecondaryRootInnerBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_SECONDARY_ROOT_OUTER = REGISTRY.register("block_placer_secondary_root_outer", () -> new BlockPlacerSecondaryRootOuterBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TERTIARY_ROOT_CORE = REGISTRY.register("block_placer_tertiary_root_core", () -> new BlockPlacerTertiaryRootCoreBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TERTIARY_ROOT_INNER = REGISTRY.register("block_placer_tertiary_root_inner", () -> new BlockPlacerTertiaryRootInnerBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TERTIARY_ROOT_OUTER = REGISTRY.register("block_placer_tertiary_root_outer", () -> new BlockPlacerTertiaryRootOuterBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_FINE_ROOT_CORE = REGISTRY.register("block_placer_fine_root_core", () -> new BlockPlacerFineRootCoreBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_FINE_ROOT_INNER = REGISTRY.register("block_placer_fine_root_inner", () -> new BlockPlacerFineRootInnerBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_FINE_ROOT_OUTER = REGISTRY.register("block_placer_fine_root_outer", () -> new BlockPlacerFineRootOuterBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TRUNK_CORE = REGISTRY.register("block_placer_trunk_core", () -> new BlockPlacerTrunkCoreBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TRUNK_INNER = REGISTRY.register("block_placer_trunk_inner", () -> new BlockPlacerTrunkInnerBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TRUNK_OUTER = REGISTRY.register("block_placer_trunk_outer", () -> new BlockPlacerTrunkOuterBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_BRANCH_CORE = REGISTRY.register("block_placer_branch_core", () -> new BlockPlacerBranchCoreBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_BRANCH_INNER = REGISTRY.register("block_placer_branch_inner", () -> new BlockPlacerBranchInnerBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_BRANCH_OUTER = REGISTRY.register("block_placer_branch_outer", () -> new BlockPlacerBranchOuterBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TWIG_CORE = REGISTRY.register("block_placer_twig_core", () -> new BlockPlacerTwigCoreBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TWIG_INNER = REGISTRY.register("block_placer_twig_inner", () -> new BlockPlacerTwigInnerBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_TWIG_OUTER = REGISTRY.register("block_placer_twig_outer", () -> new BlockPlacerTwigOuterBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_LEAVES = REGISTRY.register("block_placer_leaves", () -> new BlockPlacerLeavesBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_LEAVES_2 = REGISTRY.register("block_placer_leaves_2", () -> new BlockPlacerLeaves2Block());
	public static final RegistryObject<Block> BLOCK_PLACER_LEAVES_TWIG_CORE = REGISTRY.register("block_placer_leaves_twig_core", () -> new BlockPlacerLeavesTwigCoreBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_LEAVES_TWIG_INNER = REGISTRY.register("block_placer_leaves_twig_inner", () -> new BlockPlacerLeavesTwigInnerBlock());
	public static final RegistryObject<Block> BLOCK_PLACER_LEAVES_TWIG_OUTER = REGISTRY.register("block_placer_leaves_twig_outer", () -> new BlockPlacerLeavesTwigOuterBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
