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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
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
		boolean test_rarity = false;
		boolean test_ground_block = false;
		boolean test_biome = false;
		String biome = "";
		String chosen = "";
		String folder_directory = "";
		String temp_text = "";
		double biome_test = 0;
		double biome_test_random = 0;
		double temp_number = 0;
		double min_distance = 0;
		double rotation = 0;
		double group_chance = 0;
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT"), File.separator + "config_placement.txt");
		if (file.exists() == true) {
			if ((entity.getPersistentData().getString("pre_select")).equals("")) {
				if (true) {
					if (true) {
						biome = ("" + world.getBiome(new BlockPos(x, y, z))).replace("Reference{ResourceKey[minecraft:worldgen/biome / ", "");
						temp_number = 0;
						while (true) {
							if (!(biome.substring((int) temp_number, (int) (temp_number + 1))).equals("]")) {
								temp_number = temp_number + 1;
							} else {
								biome = biome.substring(0, (int) temp_number);
								break;
							}
						}
					}
					try {
						BufferedReader fileReader = new BufferedReader(new FileReader(file));
						String stringiterator = "";
						while ((stringiterator = fileReader.readLine()) != null) {
							if (stringiterator.contains(biome) && !stringiterator.contains(biome + "_")) {
								biome_test = biome_test + 1;
							}
						}
						fileReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					if (biome_test > 0) {
						biome_test_random = Mth.nextInt(RandomSource.create(), 1, (int) biome_test);
						biome_test = 1;
						temp_text = "";
						try {
							BufferedReader fileReader = new BufferedReader(new FileReader(file));
							String stringiterator = "";
							while ((stringiterator = fileReader.readLine()) != null) {
								if (stringiterator.contains(biome) && !stringiterator.contains(biome + "_")) {
									if ((temp_text).equals("")) {
										if (biome_test >= biome_test_random) {
											temp_text = (stringiterator.replace("|", "$")).replace(" ", "*");
											temp_number = 0;
											while (true) {
												if (!(temp_text.substring((int) temp_number, (int) (temp_number + 1))).equals("$")) {
													temp_number = temp_number + 1;
												} else {
													temp_text = temp_text.substring(0, (int) temp_number);
													break;
												}
											}
											folder_directory = FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/" + ((temp_text.replace("**/**", "/world_gen/")).replace("**>**", "/")).replace("*", "");
											temp_text = (temp_text + "|********").replace("*", " ");
										} else {
											biome_test = biome_test + 1;
										}
									}
								}
							}
							fileReader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							BufferedReader fileReader = new BufferedReader(new FileReader(file));
							String stringiterator = "";
							while ((stringiterator = fileReader.readLine()) != null) {
								if (stringiterator.startsWith(temp_text)) {
									if (true) {
										if (stringiterator.startsWith(temp_text + "biome : ")) {
											if (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation(biome))) {
												test_biome = true;
											}
										}
										if (stringiterator.startsWith(temp_text + "ground_block : ")) {
											if (stringiterator.contains(ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock()).toString())
													&& !stringiterator.contains(ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock()).toString() + "_")) {
												test_ground_block = true;
											}
										}
									}
									if (true) {
										if (stringiterator.startsWith(temp_text + "rarity : ")) {
											if (new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert(stringiterator.replace(temp_text + "rarity : ", "")) * 0.01 > Math.random()) {
												test_rarity = true;
											}
										}
										if (stringiterator.startsWith(temp_text + "min_distance : ")) {
											min_distance = new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert(stringiterator.replace(temp_text + "min_distance : ", ""));
										}
										if (stringiterator.startsWith(temp_text + "group_chance : ")) {
											group_chance = new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert(stringiterator.replace(temp_text + "group_chance : ", ""));
										}
									}
									if (true) {
										if (stringiterator.startsWith(temp_text + "dead_tree_chance : ")) {
											if (new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert(stringiterator.replace(temp_text + "dead_tree_chance : ", "")) > Math.random()) {
												entity.getPersistentData().putBoolean("dead_tree", true);
											}
										}
										if (stringiterator.startsWith(temp_text + "dead_tree_level_min : ")) {
											entity.getPersistentData().putDouble("dead_tree_level_min : ", new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert(stringiterator.replace(temp_text + "dead_tree_level_min : ", "")));
										}
									}
									if (true) {
										if (stringiterator.startsWith(temp_text + "rotation : ")) {
											rotation = new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert(stringiterator.replace(temp_text + "rotation : ", ""));
										}
										if (stringiterator.startsWith(temp_text + "mirrored : ")) {
											entity.getPersistentData().putDouble("mirrored", new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert(stringiterator.replace(temp_text + "mirrored : ", "")));
										}
									}
								}
							}
							fileReader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						entity.getPersistentData().putString("tree_name", (((folder_directory.replace(FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/", "")).replace("/world_gen/", "-")).replace("/", "-")));
					}
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "execute unless block ~ ~ ~ #tht:passable_blocks run kill @s");
						}
					}
					if (test_rarity == false && group_chance > Math.random()) {
						test_rarity = true;
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
												_ent.level.getServer(), _ent),
										("execute " + ("unless entity @e[type=armor_stand,nbt={ForgeData:{tree_name:\"" + "" + entity.getPersistentData().getString("tree_name") + "\"}},distance=" + min_distance + ".." + (min_distance + 24))
												+ "] run kill @s"));
							}
						}
					}
					if (test_rarity == true && test_biome == true && test_ground_block == true) {
						entity.getPersistentData().putBoolean("world_gen_chosen", true);
						if (rotation == 360) {
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
											_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("tp @s ~ ~ ~ " + 90 * Mth.nextInt(RandomSource.create(), 0, 3) + " 0"));
								}
							}
						} else {
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
											_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("tp @s ~ ~ ~ " + rotation + " 0"));
								}
							}
						}
						if (true) {
							if (ThtModVariables.MapVariables.get(world).safe_zone_spawn > 0) {
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level.getServer(), _ent),
												("execute " + ("positioned " + (world.getLevelData().getXSpawn() + " " + world.getLevelData().getYSpawn() + " " + world.getLevelData().getZSpawn()) + " if entity @s[distance=.."
														+ ThtModVariables.MapVariables.get(world).safe_zone_spawn) + "] run kill @s"));
									}
								}
							}
							if (ThtModVariables.MapVariables.get(world).safe_zone_village > 0) {
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level.getServer(), _ent),
												("execute " + ("if entity @e[type=#tht:safezone_village,tag=!THT,distance=.." + ThtModVariables.MapVariables.get(world).safe_zone_village) + "] run kill @s"));
									}
								}
							}
							if (min_distance > 0) {
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level.getServer(), _ent),
												("execute " + ("if entity @e[type=armor_stand,nbt={ForgeData:{tree_name:\"" + "" + entity.getPersistentData().getString("tree_name") + "\"}},distance=0.01.." + min_distance) + "] run kill @s"));
									}
								}
							}
							if (ThtModVariables.MapVariables.get(world).surface_detector_size > 0) {
								if (true) {
									if (true) {
										{
											Entity _ent = entity;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level.getServer(), _ent),
														("summon armor_stand " + ("~" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~")
																+ " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level.getServer(), _ent),
														("summon armor_stand " + ("~-" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~-")
																+ " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level.getServer(), _ent),
														("summon armor_stand " + ("~ ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~" + ThtModVariables.MapVariables.get(world).surface_detector_size)
																+ " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level.getServer(), _ent),
														("summon armor_stand " + ("~ ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~-" + ThtModVariables.MapVariables.get(world).surface_detector_size)
																+ " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
											}
										}
									}
									if (true) {
										{
											Entity _ent = entity;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level.getServer(), _ent),
														("summon armor_stand " + ("~" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~"
																+ ThtModVariables.MapVariables.get(world).surface_detector_size) + " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level.getServer(), _ent),
														("summon armor_stand " + ("~" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~-"
																+ ThtModVariables.MapVariables.get(world).surface_detector_size) + " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level.getServer(), _ent),
														("summon armor_stand " + ("~-" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~"
																+ ThtModVariables.MapVariables.get(world).surface_detector_size) + " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level.getServer(), _ent),
														("summon armor_stand " + ("~-" + ThtModVariables.MapVariables.get(world).surface_detector_size + " ~" + (ThtModVariables.MapVariables.get(world).surface_detector_height + 1) + " ~-"
																+ ThtModVariables.MapVariables.get(world).surface_detector_size) + " {CustomName:'{\"text\":\"THT-surface_detector\"}',Invisible:1b,Marker:1b}"));
											}
										}
									}
								}
								for (int index2 = 0; index2 < (int) (ThtModVariables.MapVariables.get(world).surface_detector_height * 2 + 2); index2++) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"execute as @e[name=THT-surface_detector] at @s if block ~ ~ ~ #tht:passable_blocks if block ~ ~-1 ~ #tht:passable_blocks run tp ~ ~-1 ~");
								}
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null,
												4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "execute at @e[name=THT-surface_detector] unless block ~ ~ ~ #tht:passable_blocks run kill @s");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null,
												4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "execute at @e[name=THT-surface_detector] if block ~ ~-1 ~ #tht:passable_blocks run kill @s");
									}
								}
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "kill @e[name=THT-surface_detector]");
							}
						}
						if (entity.getPersistentData().getBoolean("world_gen_chosen") == true) {
							file = new File(folder_directory + ".txt");
							try {
								BufferedReader fileReader = new BufferedReader(new FileReader(file));
								String stringiterator = "";
								while ((stringiterator = fileReader.readLine()) != null) {
									if (stringiterator.startsWith("storage_directory : ")) {
										folder_directory = FMLPaths.GAMEDIR.get().toString() + "/" + stringiterator.replace("storage_directory : ", "");
										entity.getPersistentData().putString("directory", (folder_directory.replace(FMLPaths.GAMEDIR.get().toString() + "/", "")));
									}
								}
								fileReader.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							if (true) {
								File directory = new File(folder_directory);
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
				}
			} else {
				if (true) {
					entity.getPersistentData().putBoolean("world_gen_chosen", true);
					folder_directory = FMLPaths.GAMEDIR.get().toString() + "/" + entity.getPersistentData().getString("pre_select");
					if ((entity.getPersistentData().getString("pre_select")).contains(".txt")) {
						file = new File(folder_directory);
						try {
							BufferedReader fileReader = new BufferedReader(new FileReader(file));
							String stringiterator = "";
							while ((stringiterator = fileReader.readLine()) != null) {
								if (true) {
									if (stringiterator.startsWith("storage_directory : ")) {
										folder_directory = FMLPaths.GAMEDIR.get().toString() + "/" + stringiterator.replace("storage_directory : ", "");
									}
									if (stringiterator.startsWith(temp_text + "rotation : ")) {
										rotation = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace(temp_text + "rotation : ", ""));
									}
									if (stringiterator.startsWith(temp_text + "mirrored : ")) {
										entity.getPersistentData().putDouble("mirrored", new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace(temp_text + "mirrored : ", "")));
									}
								}
							}
							fileReader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (rotation == 360) {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("tp @s ~ ~ ~ " + 90 * Mth.nextInt(RandomSource.create(), 0, 3) + " 0"));
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("tp @s ~ ~ ~ " + rotation + " 0"));
							}
						}
					}
					if (true) {
						File directory = new File(folder_directory);
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
					entity.getPersistentData().putString("directory", (folder_directory.replace(FMLPaths.GAMEDIR.get().toString() + "/", "")));
					entity.getPersistentData().putString("tree_name", ((((entity.getPersistentData().getString("pre_select")).replace("config/THT/custom/tree_packs/", "")).replace("world_gen/", "")).replace("/", "-")));
				}
			}
		}
		if (entity.getPersistentData().getBoolean("world_gen_chosen") == false) {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "kill @s");
				}
			}
		}
	}
}
