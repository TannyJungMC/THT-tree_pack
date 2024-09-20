package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Random;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class RandomTreeWorldGenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		String biome = "";
		String chosen = "";
		String tree_location_text = "";
		String biome_test = "";
		String ground_block_test = "";
		double min_distance = 0;
		double rotation = 0;
		double text_test_pos = 0;
		double text_test_pos2 = 0;
		boolean test_rarity = false;
		boolean test_ground_block = false;
		boolean test_biome = false;
		boolean test_biome2 = false;
		boolean test_ground_block2 = false;
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT"), File.separator + "config_placement.txt");
		if (file.exists() == true) {
			if ((entity.getPersistentData().getString("pre_select")).equals("")) {
				try {
					BufferedReader fileReader = new BufferedReader(new FileReader(file));
					String stringiterator = "";
					while ((stringiterator = fileReader.readLine()) != null) {
						if (!(stringiterator).equals("")) {
							if (stringiterator.contains("biome : ")) {
								if (true) {
									text_test_pos = 0;
									text_test_pos2 = 0;
									for (int index0 = 0; index0 < 1000; index0++) {
										if ((stringiterator.substring(0, (int) text_test_pos2)).contains("biome : ")) {
											text_test_pos = text_test_pos2;
											tree_location_text = stringiterator.substring(0, (int) (text_test_pos2 - ("biome : ").length()));
											entity.getPersistentData().putString("tree_name", ("THT-" + (((tree_location_text.replace(" ", "*")).replace("********|********", "")).replace("**/**", "-")).replace("**>**", "-")));
											break;
										} else {
											text_test_pos2 = text_test_pos2 + 1;
										}
									}
									if (text_test_pos2 < (stringiterator).length()) {
										test_biome = false;
										test_biome2 = false;
										biome = world.getBiome(BlockPos.containing(x, y, z)).toString().replace("Reference{ResourceKey[minecraft:worldgen/biome / ", "");
										for (int index1 = 0; index1 < 1000; index1++) {
											if (text_test_pos2 < (stringiterator).length() && !(stringiterator.substring((int) text_test_pos, (int) text_test_pos2)).endsWith(", ")) {
												text_test_pos2 = text_test_pos2 + 1;
											} else {
												biome_test = (stringiterator.substring((int) text_test_pos, (int) text_test_pos2)).replace(", ", "");
												text_test_pos = text_test_pos2;
												if (true) {
													if (biome_test.contains("@all")) {
														test_biome2 = true;
													} else if (biome_test.contains("@vanilla")) {
														if (biome.startsWith("minecraft:")) {
															test_biome2 = true;
														}
													} else if (biome_test.contains("#")) {
														if (world.getBiome(BlockPos.containing(x, y, z))
																.is(TagKey.create(Registries.BIOME, new ResourceLocation(((((biome_test.replace("#", "")).replace("!", "")).replace("&", ""))).toLowerCase(java.util.Locale.ENGLISH))))) {
															test_biome2 = true;
														} else {
															test_biome2 = false;
														}
													} else {
														if (biome.startsWith(((biome_test.replace("&", "")).replace("!", "")).replace("#", "")) && !biome.startsWith(((biome_test.replace("&", "")).replace("!", "")).replace("#", "") + "_")) {
															test_biome2 = true;
														} else {
															test_biome2 = false;
														}
													}
													if (biome_test.contains("!")) {
														test_biome2 = !test_biome2;
													}
													if (test_biome2 == true) {
														test_biome = true;
													} else {
														if (biome_test.contains("&")) {
															test_biome = false;
															break;
														}
													}
												}
												if (text_test_pos2 >= (stringiterator).length()) {
													break;
												}
											}
										}
									}
								}
							} else if (stringiterator.contains("ground_block : ")) {
								if (test_biome == true) {
									text_test_pos = (tree_location_text).length() + ("ground_block : ").length();
									text_test_pos2 = text_test_pos;
									if (text_test_pos2 < (stringiterator).length()) {
										test_ground_block = false;
										test_ground_block2 = false;
										for (int index2 = 0; index2 < 1000; index2++) {
											if (text_test_pos2 < (stringiterator).length() && !(stringiterator.substring((int) text_test_pos, (int) text_test_pos2)).endsWith(", ")) {
												text_test_pos2 = text_test_pos2 + 1;
											} else {
												ground_block_test = (stringiterator.substring((int) text_test_pos, (int) text_test_pos2)).replace(", ", "");
												text_test_pos = text_test_pos2;
												if (true) {
													if (ground_block_test.contains("@all")) {
														test_ground_block2 = true;
													} else if (ground_block_test.contains("#")) {
														if ((world.getBlockState(BlockPos.containing(x, y - 1, z)))
																.is(BlockTags.create(new ResourceLocation(((((ground_block_test.replace("#", "")).replace("!", "")).replace("&", ""))).toLowerCase(java.util.Locale.ENGLISH))))) {
															test_ground_block2 = true;
														} else {
															test_ground_block2 = false;
														}
													} else {
														if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString())
																.equals(((ground_block_test.replace("#", "")).replace("!", "")).replace("&", ""))
																&& !(ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString())
																		.equals(((ground_block_test.replace("#", "")).replace("!", "")).replace("&", "") + "_")) {
															test_ground_block2 = true;
														} else {
															test_ground_block2 = false;
														}
													}
													if (ground_block_test.contains("!")) {
														test_ground_block2 = !test_ground_block2;
													}
													if (test_ground_block2 == true) {
														test_ground_block = true;
													} else {
														if (ground_block_test.contains("&")) {
															test_ground_block = false;
															break;
														}
													}
												}
												if (text_test_pos2 >= (stringiterator).length()) {
													break;
												}
											}
										}
									}
								}
							} else if (stringiterator.contains("rarity : ")) {
								if (test_ground_block == true) {
									if (new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace(tree_location_text + "rarity : ", "")) * 0.01 > Math.random()) {
										test_rarity = true;
									} else {
										test_rarity = false;
									}
								}
							} else if (stringiterator.contains("min_distance : ")) {
								if (test_rarity == true) {
									if (true) {
										min_distance = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace(tree_location_text + "min_distance : ", ""));
										entity.getPersistentData().putBoolean("test_min_distance", true);
										if (min_distance > 0) {
											{
												Entity _ent = entity;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																	_ent.getDisplayName(), _ent.level().getServer(), _ent),
															("execute " + ("if entity @e[nbt={ForgeData:{tree_name:\"" + "" + entity.getPersistentData().getString("tree_name") + "\"}},distance=0.01.." + min_distance)
																	+ "] run data merge entity @s {ForgeData:{test_min_distance:0b}}"));
												}
											}
										}
									}
								}
							} else if (stringiterator.contains("group_chance : ")) {
								if (entity.getPersistentData().getBoolean("test_min_distance") == true) {
									entity.getPersistentData().putBoolean("test_group_chance", true);
									if (test_rarity == false && new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace(tree_location_text + "group_chance : ", "")) > Math.random()) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("execute " + ("unless entity @e[nbt={ForgeData:{tree_name:\"" + "" + entity.getPersistentData().getString("tree_name") + "\"}},distance=" + (min_distance + 0.01) + ".." + (min_distance + 24))
																+ "] run data merge entity @s {ForgeData:{test_group_chance:0b}}"));
											}
										}
										if (entity.getPersistentData().getBoolean("test_group_chance") == true) {
											test_rarity = true;
										}
									}
								}
							} else if (test_rarity == true && test_biome == true && test_ground_block == true && entity.getPersistentData().getBoolean("test_min_distance") == true
									&& entity.getPersistentData().getBoolean("test_group_chance") == true) {
								if (stringiterator.contains("dead_tree_chance : ")) {
									if (new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace(tree_location_text + "dead_tree_chance : ", "")) > Math.random()) {
										entity.getPersistentData().putBoolean("dead_tree", true);
									}
								} else if (stringiterator.contains("dead_tree_level_min : ")) {
									if (entity.getPersistentData().getBoolean("dead_tree") == true) {
										entity.getPersistentData().putDouble("dead_tree_level_min : ", new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace(tree_location_text + "dead_tree_level_min : ", "")));
									}
								} else if (stringiterator.contains("rotation : ")) {
									rotation = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace(tree_location_text + "rotation : ", ""));
								} else if (stringiterator.contains("mirrored : ")) {
									entity.getPersistentData().putDouble("mirrored", new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace(tree_location_text + "mirrored : ", "")));
								} else {
									entity.getPersistentData().putBoolean("world_gen_chosen", true);
									break;
								}
							}
						}
					}
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (entity.getPersistentData().getBoolean("world_gen_chosen") == true) {
					entity.getPersistentData().putString("directory",
							(FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/" + (((tree_location_text.replace(" ", "*")).replace("********|********", "")).replace("**/**", "/world_gen/")).replace("**>**", "/") + ".txt"));
					if (true) {
						if (ThtModVariables.MapVariables.get(world).safe_zone_spawn > 0) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute " + ("positioned " + (world.getLevelData().getXSpawn() + " " + world.getLevelData().getYSpawn() + " " + world.getLevelData().getZSpawn()) + " if entity @s[distance=.."
													+ ThtModVariables.MapVariables.get(world).safe_zone_spawn) + "] run kill @s"));
								}
							}
						}
						if (ThtModVariables.MapVariables.get(world).safe_zone_village > 0) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute " + ("if entity @e[type=#tht:safezone_village,tag=!THT,distance=.." + ThtModVariables.MapVariables.get(world).safe_zone_village) + "] run kill @s"));
								}
							}
						}
						if (ThtModVariables.MapVariables.get(world).surface_detector_size > 0) {
							if (true) {
								if (true) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("summon armor_stand " + ("~" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~")
															+ " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("summon armor_stand " + ("~-" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~-")
															+ " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("summon armor_stand " + ("~ ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~" + ThtModVariables.MapVariables.get(world).surface_detector_size)
															+ " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("summon armor_stand " + ("~ ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~-" + ThtModVariables.MapVariables.get(world).surface_detector_size)
															+ " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
										}
									}
								}
								if (true) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("summon armor_stand " + ("~" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~"
															+ ThtModVariables.MapVariables.get(world).surface_detector_size) + " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("summon armor_stand " + ("~" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~-"
															+ ThtModVariables.MapVariables.get(world).surface_detector_size) + " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("summon armor_stand " + ("~-" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~"
															+ ThtModVariables.MapVariables.get(world).surface_detector_size) + " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("summon armor_stand " + ("~-" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~-"
															+ ThtModVariables.MapVariables.get(world).surface_detector_size) + " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
										}
									}
								}
							}
							for (int index3 = 0; index3 < (int) (ThtModVariables.MapVariables.get(world).surface_detector_height * 2 + 2); index3++) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"execute as @e[name=THT-surface_detector] at @s if block ~ ~ ~ #tht:passable_blocks if block ~ ~-1 ~ #tht:passable_blocks run tp ~ ~-1 ~");
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute at @e[name=THT-surface_detector] unless block ~ ~ ~ #tht:passable_blocks run kill @s");
								}
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute at @e[name=THT-surface_detector] if block ~ ~-1 ~ #tht:passable_blocks run kill @s");
								}
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"kill @e[name=THT-surface_detector]");
						}
					}
					file = new File(entity.getPersistentData().getString("directory"));
					if (file.exists() == true) {
						try {
							BufferedReader fileReader = new BufferedReader(new FileReader(file));
							String stringiterator = "";
							while ((stringiterator = fileReader.readLine()) != null) {
								if (stringiterator.startsWith("storage_directory : ")) {
									entity.getPersistentData().putString("directory", (stringiterator.replace("storage_directory : ", "")));
									break;
								}
							}
							fileReader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				entity.getPersistentData().putBoolean("world_gen_chosen", true);
				if ((entity.getPersistentData().getString("pre_select")).contains(".txt")) {
					file = new File(entity.getPersistentData().getString("pre_select"));
					if (file.exists() == true) {
						try {
							BufferedReader fileReader = new BufferedReader(new FileReader(file));
							String stringiterator = "";
							while ((stringiterator = fileReader.readLine()) != null) {
								if (stringiterator.startsWith("storage_directory : ")) {
									entity.getPersistentData().putString("directory", (stringiterator.replace("storage_directory : ", "")));
								} else if (stringiterator.startsWith(tree_location_text + "rotation : ")) {
									rotation = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace(tree_location_text + "rotation : ", ""));
								} else if (stringiterator.startsWith(tree_location_text + "mirrored : ")) {
									entity.getPersistentData().putDouble("mirrored", new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace(tree_location_text + "mirrored : ", "")));
								}
							}
							fileReader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else {
					entity.getPersistentData().putString("directory", (entity.getPersistentData().getString("pre_select")));
					if (true) {
						if (entity.getPersistentData().getDouble("rotation") != 360) {
							rotation = entity.getPersistentData().getDouble("rotation");
						}
						if (entity.getPersistentData().getDouble("mirrored") == 0) {
							entity.getPersistentData().putDouble("mirrored", (Mth.nextInt(RandomSource.create(), 1, 2)));
						}
					}
				}
			}
			if (entity.getPersistentData().getBoolean("world_gen_chosen") == true) {
				if (rotation == 360) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tp @s ~ ~ ~ " + 90 * Mth.nextInt(RandomSource.create(), 0, 3) + " 0"));
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tp @s ~ ~ ~ " + rotation + " 0"));
						}
					}
				}
				if (true) {
					File directory = new File(FMLPaths.GAMEDIR.get().toString() + "/" + entity.getPersistentData().getString("directory"));
					File[] list = directory.listFiles();
					File[] filter = (directory.listFiles());
					Random random = new Random();
					int n = 0;
					if (list != null) {
						for (int i = 0; i < list.length; i++) {
							if (list[i].isFile() && list[i].getName().endsWith(".txt")) {
								filter[n] = list[i];
								n = n + 1;
							}
						}
					}
					chosen = filter[random.nextInt(n)].getName();
				}
				entity.getPersistentData().putString("file_name", chosen);
			}
		}
		if (entity.getPersistentData().getBoolean("world_gen_chosen") == false) {
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
