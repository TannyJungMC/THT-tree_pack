package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class RandomTreeTreePlacerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		String folder = "";
		String file_name = "";
		String taproot_outer = "";
		String taproot_inner = "";
		String taproot_core = "";
		String secondary_root_outer = "";
		String secondary_root_inner = "";
		String secondary_root_core = "";
		String tertiary_root_outer = "";
		String tertiary_root_inner = "";
		String tertiary_root_core = "";
		String fine_root_outer = "";
		String fine_root_inner = "";
		String fine_root_core = "";
		String trunk_outer = "";
		String trunk_inner = "";
		String trunk_core = "";
		String branch_outer = "";
		String branch_inner = "";
		String branch_core = "";
		String twig_outer = "";
		String twig_inner = "";
		String twig_core = "";
		String leaves_outer = "";
		String leaves_inner = "";
		String leaves_core = "";
		String leaves = "";
		String leaves2 = "";
		String keep = "";
		String type_short = "";
		String pos = "";
		String command = "";
		String end_text = "";
		double loop = 0;
		double loop_next = 0;
		double pre_leaves_litter_chance = 0;
		boolean loop_finish = false;
		boolean skip = false;
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/" + entity.getPersistentData().getString("directory")), File.separator + (entity.getPersistentData().getString("file_name")));
		if (file.isFile() == true && file.exists() == true) {
			if (entity.getPersistentData().getBoolean("skip") == false) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute unless block ~ ~ ~ #tht:passable_blocks run kill @s");
					}
				}
				try {
					BufferedReader fileReader = new BufferedReader(new FileReader(file));
					String stringiterator = "";
					while ((stringiterator = fileReader.readLine()) != null) {
						entity.getPersistentData().putDouble("line_count", (entity.getPersistentData().getDouble("line_count") + 1));
						if (ThtModVariables.MapVariables.get(world).world_height_limit != 0) {
							if (stringiterator.contains("+s") && stringiterator.contains("^")) {
								entity.getPersistentData().putDouble("highest_block_test1", ("+s^").length());
								entity.getPersistentData().putDouble("highest_block_test2", (entity.getPersistentData().getDouble("highest_block_test1")));
								while (true) {
									if ((stringiterator.substring((int) entity.getPersistentData().getDouble("highest_block_test1"), (int) entity.getPersistentData().getDouble("highest_block_test2"))).contains("^")) {
										if (entity.getPersistentData().getDouble("highest_block_test1") == ("+s^").length()) {
											entity.getPersistentData().putDouble("highest_block_test1", (entity.getPersistentData().getDouble("highest_block_test2")));
											entity.getPersistentData().putDouble("highest_block_test2", (entity.getPersistentData().getDouble("highest_block_test1")));
										} else {
											entity.getPersistentData().putDouble("highest_block_test", new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert(stringiterator.substring((int) entity.getPersistentData().getDouble("highest_block_test1"), (int) (entity.getPersistentData().getDouble("highest_block_test2") - 1))));
											if (entity.getPersistentData().getDouble("highest_block_test") > entity.getPersistentData().getDouble("highest_block")) {
												entity.getPersistentData().putDouble("highest_block", (entity.getPersistentData().getDouble("highest_block_test")));
											}
											break;
										}
									} else {
										entity.getPersistentData().putDouble("highest_block_test2", (entity.getPersistentData().getDouble("highest_block_test2") + 1));
									}
								}
							}
						}
						if (stringiterator.contains("@tr")) {
							entity.getPersistentData().putDouble("dead_tree_trunk", (entity.getPersistentData().getDouble("dead_tree_trunk") + 1));
						}
						if (entity.getPersistentData().getBoolean("skip") == false) {
							if ((stringiterator).equals("--------------------------------------------------")) {
								entity.getPersistentData().putBoolean("skip", true);
							} else {
								if (true) {
									if (stringiterator.startsWith("@")) {
										entity.getPersistentData().putString((stringiterator.substring(1, 4)), (stringiterator.substring(7, (int) (stringiterator).length())));
									}
									if (stringiterator.startsWith("+f")) {
										if (stringiterator.contains("+fs = ")) {
											entity.getPersistentData().putString("start_function", (stringiterator.replace("+fs = ", "")));
										} else if (stringiterator.contains("+fe = ")) {
											entity.getPersistentData().putString("end_function", (stringiterator.replace("+fe = ", "")));
										} else if (stringiterator.contains("+fw1 = ")) {
											entity.getPersistentData().putString("way1_function", (stringiterator.replace("+fw1 = ", "")));
										} else if (stringiterator.contains("+fw2 = ")) {
											entity.getPersistentData().putString("way2_function", (stringiterator.replace("+fw2 = ", "")));
										} else if (stringiterator.contains("+fw3 = ")) {
											entity.getPersistentData().putString("way3_function", (stringiterator.replace("+fw3 = ", "")));
										}
									}
									if (true) {
										if (stringiterator.startsWith("tree_type : ")) {
											if ((stringiterator.substring((int) ("tree_type : ").length())).equals("land")) {
												if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.WATER
														|| ("minecraft:kelp_plant" + "minecraft:seagrass" + "minecraft:tall_seagrass")
																.contains(ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock()).toString())
														|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp76
																&& (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getValue(_getbp76)) {
													entity.getPersistentData().putBoolean("dead_tree", true);
												}
											} else if ((stringiterator.substring((int) ("tree_type : ").length())).equals("water")) {
												if (!((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.WATER
														|| ("minecraft:kelp_plant" + "minecraft:seagrass" + "minecraft:tall_seagrass")
																.contains(ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock()).toString())
														|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp93
																&& (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getValue(_getbp93))) {
													entity.getPersistentData().putBoolean("dead_tree", true);
												}
											}
										} else if (stringiterator.startsWith("rt_dynamic : ")) {
											entity.getPersistentData().putBoolean("rt_dynamic", ((stringiterator.substring((int) ("rt_dynamic : ").length())).equals("true")));
										} else if (stringiterator.startsWith("can_disable_roots : ")) {
											entity.getPersistentData().putBoolean("can_disable_roots", ((stringiterator.substring((int) ("can_disable_roots : ").length())).equals("true")));
										}
									}
									if (stringiterator.startsWith("start_height : ")) {
										entity.getPersistentData().putDouble("start_height", new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.substring((int) ("start_height : ").length())));
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														("tp @s ~ ~" + entity.getPersistentData().getDouble("start_height") + " ~"));
											}
										}
										if (ThtModVariables.MapVariables.get(world).world_height_limit != 0) {
											if (ThtModVariables.MapVariables.get(world).world_height_limit != 1) {
												ThtModVariables.MapVariables.get(world).world_height_limit_get = ThtModVariables.MapVariables.get(world).world_height_limit;
												ThtModVariables.MapVariables.get(world).syncData(world);
											}
											if (entity.getY() + entity.getPersistentData().getDouble("highest_block") >= ThtModVariables.MapVariables.get(world).world_height_limit_get) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
													}
												}
												break;
											}
										}
									}
								}
							}
						}
					}
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (entity.getPersistentData().getBoolean("dead_tree") == true) {
					if (entity.getPersistentData().getDouble("dead_tree_level") == 0) {
						if (entity.getPersistentData().getDouble("dead_tree_level_min") == 0) {
							entity.getPersistentData().putDouble("dead_tree_level_min", 1);
						}
						entity.getPersistentData().putDouble("dead_tree_level", (Mth.nextInt(RandomSource.create(), (int) entity.getPersistentData().getDouble("dead_tree_level_min"), 5)));
					}
					entity.getPersistentData().putDouble("dead_tree_trunk", Math.ceil(entity.getPersistentData().getDouble("dead_tree_trunk") * Mth.nextDouble(RandomSource.create(), 0.1, 0.9)));
				}
			} else {
				entity.getPersistentData().putDouble("process", 0);
				try {
					BufferedReader fileReader = new BufferedReader(new FileReader(file));
					String stringiterator = "";
					while ((stringiterator = fileReader.readLine()) != null) {
						entity.getPersistentData().putDouble("process", (entity.getPersistentData().getDouble("process") + 1));
						if (entity.getPersistentData().getDouble("process") < entity.getPersistentData().getDouble("line_count")) {
							if (entity.getPersistentData().getBoolean("skip2") == false) {
								if ((stringiterator).equals("--------------------------------------------------")) {
									entity.getPersistentData().putBoolean("skip2", true);
								}
							} else {
								if (stringiterator.startsWith("+")) {
									if (entity.getPersistentData().getDouble("process") >= entity.getPersistentData().getDouble("process_save")
											&& (entity.getPersistentData().getDouble("process") < entity.getPersistentData().getDouble("process_save") + ThtModVariables.MapVariables.get(world).tree_placer_process_limit
													|| ThtModVariables.MapVariables.get(world).tree_placer_process_limit == 0)) {
										if (!(entity.getPersistentData().getBoolean("dead_tree") == true && (stringiterator.contains("@le") && entity.getPersistentData().getDouble("dead_tree_level") >= 1
												|| stringiterator.contains("@lt") && entity.getPersistentData().getDouble("dead_tree_level") >= 2 || stringiterator.contains("@tw") && entity.getPersistentData().getDouble("dead_tree_level") >= 3
												|| stringiterator.contains("@br") && entity.getPersistentData().getDouble("dead_tree_level") >= 4))) {
											if (stringiterator.contains("@tr") && entity.getPersistentData().getDouble("dead_tree_level") >= 4) {
												if (entity.getPersistentData().getDouble("dead_tree_trunk") > 0) {
													entity.getPersistentData().putDouble("dead_tree_trunk", (entity.getPersistentData().getDouble("dead_tree_trunk") - 1));
												} else {
													entity.getPersistentData().putDouble("process", (entity.getPersistentData().getDouble("line_count")));
													break;
												}
											}
											if (!((stringiterator.contains("@tri") || stringiterator.contains("@trc")) && entity.getPersistentData().getDouble("dead_tree_level") >= 5)) {
												if (!(stringiterator.contains("@ta") || stringiterator.contains("@se") || stringiterator.contains("@te") || stringiterator.contains("@fi"))
														|| ThtModVariables.MapVariables.get(world).world_gen_roots == true || entity.getPersistentData().getBoolean("can_disable_roots") == false) {
													if (true) {
														command = "";
														pos = "";
														end_text = "";
														if (stringiterator.startsWith("+s")) {
															command = "setblock ";
															pos = ((stringiterator.substring(2, (int) ((stringiterator).length() - 4))).replace("^", " ^")).substring(1);
														} else if (stringiterator.startsWith("+ep")) {
															command = "execute positioned ";
															if (stringiterator.contains("+fw")) {
																pos = ((stringiterator.substring(3, (int) ((stringiterator).length() - 4))).replace("^", " ^")).substring(1);
															} else {
																pos = ((stringiterator.substring(3, (int) ((stringiterator).length() - 3))).replace("^", " ^")).substring(1);
															}
														}
														if (true) {
															if (entity.getPersistentData().getDouble("mirrored") == 0) {
																entity.getPersistentData().putDouble("mirrored", (Mth.nextInt(RandomSource.create(), 1, 2)));
															}
															if (entity.getPersistentData().getDouble("mirrored") == 2) {
																if (pos.startsWith("^-")) {
																	pos = "^" + pos.substring(2);
																} else {
																	pos = "^-" + pos.substring(1);
																}
															}
														}
														if (stringiterator.contains("@")) {
															end_text = " " + entity.getPersistentData().getString((stringiterator.substring((int) ((stringiterator).length() - 3), (int) (stringiterator).length())));
															if (end_text.endsWith(" replace #tht:passable_blocks")) {
																command = "execute positioned ";
																end_text = " if block ~ ~ ~ #tht:passable_blocks run setblock ~ ~ ~ " + end_text.substring(1, (int) ((end_text).length() - (" replace #tht:passable_blocks").length()));
															}
														} else {
															if (stringiterator.endsWith("+fs")) {
																end_text = " run " + entity.getPersistentData().getString("start_function");
															} else if (stringiterator.endsWith("+fe")) {
																end_text = " run " + entity.getPersistentData().getString("end_function");
															} else if (stringiterator.endsWith("+fw1")) {
																end_text = " run " + entity.getPersistentData().getString("way1_function");
															} else if (stringiterator.endsWith("+fw2")) {
																end_text = " run " + entity.getPersistentData().getString("way2_function");
															} else if (stringiterator.endsWith("+fw3")) {
																end_text = " run " + entity.getPersistentData().getString("way3_function");
															}
														}
													}
													if (stringiterator.contains("@")) {
														if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
															{
																Entity _ent = entity;
																if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																			("execute positioned " + pos
																					+ " unless entity @e[name=THT-tree_placer_forceload,distance=..8] run summon armor_stand ~ ~ ~ {Tags:[\"THT\"],CustomName:'{\"text\":\"THT-tree_placer_forceload\"}',NoGravity:1b,Invisible:1b,Marker:1b}"));
																}
															}
															{
																Entity _ent = entity;
																if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																			("execute positioned " + pos + " unless entity @e[name=THT-tree_placer_forceload,distance=..8] run forceload add ~ ~ ~ ~"));
																}
															}
														} else {
															{
																Entity _ent = entity;
																if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																			("execute positioned " + pos
																					+ " unless loaded ~ ~ ~ run summon armor_stand ~ ~ ~ {Tags:[\"THT\"],CustomName:'{\"text\":\"THT-tree_placer_forceload\"}',NoGravity:1b,Invisible:1b,Marker:1b}"));
																}
															}
															{
																Entity _ent = entity;
																if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands()
																			.performPrefixedCommand(
																					new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																					("execute positioned " + pos + " unless loaded ~ ~ ~ run forceload add ~ ~ ~ ~"));
																}
															}
														}
													}
													{
														Entity _ent = entity;
														if (!_ent.level().isClientSide() && _ent.getServer() != null) {
															_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																	_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																	(command + "" + pos + end_text));
														}
													}
													{
														Entity _ent = entity;
														if (!_ent.level().isClientSide() && _ent.getServer() != null) {
															_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																	_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																	("execute positioned " + pos + " run kill @e[type=item,distance=..5]"));
														}
													}
													if (entity.getPersistentData().getBoolean("rt_dynamic") == true) {
														if (stringiterator.contains("@le") && end_text.contains("[persistent=true]")) {
															end_text = ((end_text.replace(" keep", "")).replace("[persistent=true]", "")).substring(1);
															if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation((end_text).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
																	.is(BlockTags.create(new ResourceLocation("tht:leaves_blocks")))) {
																if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation((end_text).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
																		.is(BlockTags.create(new ResourceLocation("tht:coniferous_leaves_blocks")))) {
																	pre_leaves_litter_chance = ThtModVariables.MapVariables.get(world).pre_leaves_litter_coniferous_chance;
																} else {
																	pre_leaves_litter_chance = ThtModVariables.MapVariables.get(world).pre_leaves_litter_chance;
																}
																if (Math.random() < pre_leaves_litter_chance) {
																	{
																		Entity _ent = entity;
																		if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																			_ent.getServer().getCommands().performPrefixedCommand(
																					new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																					("execute positioned " + pos + " positioned over motion_blocking_no_leaves unless block ~ ~-1 ~ water run setblock ~ ~ ~ " + (end_text + "[persistent=true] keep")));
																		}
																	}
																	{
																		Entity _ent = entity;
																		if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																			_ent.getServer().getCommands().performPrefixedCommand(
																					new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																					("execute positioned " + pos + " positioned over motion_blocking_no_leaves if block ~ ~-1 ~ water run setblock ~ ~-1 ~ "
																							+ (end_text + "[persistent=true,waterlogged=true]")));
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									} else if (entity.getPersistentData().getDouble("process") >= entity.getPersistentData().getDouble("process_save") + ThtModVariables.MapVariables.get(world).tree_placer_process_limit) {
										entity.getPersistentData().putDouble("process_save", (entity.getPersistentData().getDouble("process")));
										break;
									}
								}
							}
						} else {
							entity.getPersistentData().putDouble("process", 0);
							entity.getPersistentData().putDouble("process_save", 0);
							entity.getPersistentData().putBoolean("skip", false);
							entity.getPersistentData().putBoolean("skip2", false);
							if (ThtModVariables.MapVariables.get(world).tree_location == true) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												("data merge entity @s {CustomName:'{\"text\":\"" + "" + entity.getPersistentData().getString("tree_name") + "\"}',Tags:[\"THT\",\"THT-tree_location\"]}"));
									}
								}
							} else {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
									}
								}
							}
							break;
						}
					}
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
				}
			}
		}
	}
}
