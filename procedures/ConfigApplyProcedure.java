package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class ConfigApplyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute if entity @e[type=player,distance=..0.01] run tellraw @a [{\"text\":\"THT : Applied the config\",\"color\":\"light_purple\"}]");
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT"), File.separator + "config.txt");
		if (file.exists() == true) {
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String stringiterator = "";
				while ((stringiterator = fileReader.readLine()) != null) {
					if (true) {
						if (!("").equals("TannyJung's Tree Pack")) {
							if (true) {
								if (stringiterator.contains("auto_check_update : ")) {
									ThtModVariables.MapVariables.get(world).auto_check_update = (stringiterator.replace("auto_check_update : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("auto_update : ")) {
									ThtModVariables.MapVariables.get(world).auto_update = (stringiterator.replace("auto_update : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("wip_version : ")) {
									ThtModVariables.MapVariables.get(world).tanny_pack_wip = (stringiterator.replace("wip_version : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
							}
						}
						if (!("").equals("World Gen")) {
							if (true) {
								if (stringiterator.contains("tree_placer_auto_speed : ")) {
									ThtModVariables.MapVariables.get(world).tree_placer_auto_speed = (stringiterator.replace("tree_placer_auto_speed : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("tree_placer_tick : ")) {
									ThtModVariables.MapVariables.get(world).tree_placer_tick_set = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("tree_placer_tick : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("tree_placer_process_limit : ")) {
									ThtModVariables.MapVariables.get(world).tree_placer_process_limit = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("tree_placer_process_limit : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("tree_placer_count_limit : ")) {
									ThtModVariables.MapVariables.get(world).tree_placer_count_limit = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("tree_placer_count_limit : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("tree_placer_distance_limit : ")) {
									ThtModVariables.MapVariables.get(world).tree_placer_distance_limit = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("tree_placer_distance_limit : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("global_rarity : ")) {
									ThtModVariables.MapVariables.get(world).global_rarity = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("global_rarity : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("safe_zone_spawn : ")) {
									ThtModVariables.MapVariables.get(world).safe_zone_spawn = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("safe_zone_spawn : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("safe_zone_village : ")) {
									ThtModVariables.MapVariables.get(world).safe_zone_village = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("safe_zone_village : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("tree_location : ")) {
									ThtModVariables.MapVariables.get(world).tree_location = (stringiterator.replace("tree_location : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("world_gen_roots : ")) {
									ThtModVariables.MapVariables.get(world).world_gen_roots = (stringiterator.replace("world_gen_roots : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("surface_smoothness_detection_size : ")) {
									ThtModVariables.MapVariables.get(world).surface_detector_size = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("surface_smoothness_detection_size : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("surface_smoothness_detection_height : ")) {
									ThtModVariables.MapVariables.get(world).surface_detector_height = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("surface_smoothness_detection_height : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("world_hight_limit : ")) {
									ThtModVariables.MapVariables.get(world).world_hight_limit = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("world_hight_limit : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
							}
						}
						if (!("").equals("RT Dynamic")) {
							if (true) {
								if (stringiterator.contains("rt_dynamic : ")) {
									ThtModVariables.MapVariables.get(world).rt_dynamic = (stringiterator.replace("rt_dynamic : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("rt_dynamic_tick : ")) {
									ThtModVariables.MapVariables.get(world).rt_dynamic_tick_set = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("rt_dynamic_tick : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("rt_dynamic_process_limit : ")) {
									ThtModVariables.MapVariables.get(world).rt_dynamic_process_limit = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("rt_dynamic_process_limit : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("rt_dynamic_simulation : ")) {
									ThtModVariables.MapVariables.get(world).rt_dynamic_simulation = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("rt_dynamic_simulation : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("season_detector : ")) {
									ThtModVariables.MapVariables.get(world).season_detector = (stringiterator.replace("season_detector : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("leaves_litter : ")) {
									ThtModVariables.MapVariables.get(world).leaves_litter = (stringiterator.replace("leaves_litter : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("pre_leaves_litter_chance : ")) {
									ThtModVariables.MapVariables.get(world).pre_leaves_litter_chance = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("pre_leaves_litter_chance : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("pre_leaves_litter_coniferous_chance : ")) {
									ThtModVariables.MapVariables.get(world).pre_leaves_litter_coniferous_chance = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("pre_leaves_litter_coniferous_chance : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("leaves_litter_remover_chance : ")) {
									ThtModVariables.MapVariables.get(world).leaves_litter_remover_chance = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("leaves_litter_remover_chance : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("leaves_litter_remover_count_limit : ")) {
									ThtModVariables.MapVariables.get(world).leaves_litter_remover_count_limit = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("leaves_litter_remover_count_limit : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
							}
						}
						if (!("").equals("RT Dynamic : Leaves Drop and Regrow")) {
							if (true) {
								if (stringiterator.contains("leaves_drop_animation_chance : ")) {
									ThtModVariables.MapVariables.get(world).leaves_drop_animation_chance = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("leaves_drop_animation_chance : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("leaves_drop_animation_count_limit : ")) {
									ThtModVariables.MapVariables.get(world).leaves_drop_animation_count_limit = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("leaves_drop_animation_count_limit : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (true) {
									if (stringiterator.contains("leaves_regrow_spring_chance : ")) {
										ThtModVariables.MapVariables.get(world).leaves_regrow_spring_chance = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace("leaves_regrow_spring_chance : ", ""));
										ThtModVariables.MapVariables.get(world).syncData(world);
									}
									if (stringiterator.contains("leaves_regrow_summer_chance : ")) {
										ThtModVariables.MapVariables.get(world).leaves_regrow_summer_chance = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace("leaves_regrow_summer_chance : ", ""));
										ThtModVariables.MapVariables.get(world).syncData(world);
									}
									if (stringiterator.contains("leaves_regrow_autumn_chance : ")) {
										ThtModVariables.MapVariables.get(world).leaves_regrow_autumn_chance = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace("leaves_regrow_autumn_chance : ", ""));
										ThtModVariables.MapVariables.get(world).syncData(world);
									}
									if (stringiterator.contains("leaves_regrow_winter_chance : ")) {
										ThtModVariables.MapVariables.get(world).leaves_regrow_winter_chance = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace("leaves_regrow_winter_chance : ", ""));
										ThtModVariables.MapVariables.get(world).syncData(world);
									}
								}
								if (true) {
									if (stringiterator.contains("leaves_drop_spring_chance : ")) {
										ThtModVariables.MapVariables.get(world).leaves_drop_spring_chance = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace("leaves_drop_spring_chance : ", ""));
										ThtModVariables.MapVariables.get(world).syncData(world);
									}
									if (stringiterator.contains("leaves_drop_summer_chance : ")) {
										ThtModVariables.MapVariables.get(world).leaves_drop_summer_chance = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace("leaves_drop_summer_chance : ", ""));
										ThtModVariables.MapVariables.get(world).syncData(world);
									}
									if (stringiterator.contains("leaves_drop_autumn_chance : ")) {
										ThtModVariables.MapVariables.get(world).leaves_drop_autumn_chance = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace("leaves_drop_autumn_chance : ", ""));
										ThtModVariables.MapVariables.get(world).syncData(world);
									}
									if (stringiterator.contains("leaves_drop_winter_chance : ")) {
										ThtModVariables.MapVariables.get(world).leaves_drop_winter_chance = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace("leaves_drop_winter_chance : ", ""));
										ThtModVariables.MapVariables.get(world).syncData(world);
									}
								}
								if (true) {
									if (stringiterator.contains("leaves_regrow_chance_coniferous : ")) {
										ThtModVariables.MapVariables.get(world).leaves_regrow_chance_coniferous = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace("leaves_regrow_chance_coniferous : ", ""));
										ThtModVariables.MapVariables.get(world).syncData(world);
									}
									if (stringiterator.contains("leaves_drop_chance_coniferous : ")) {
										ThtModVariables.MapVariables.get(world).leaves_drop_chance_coniferous = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.replace("leaves_drop_chance_coniferous : ", ""));
										ThtModVariables.MapVariables.get(world).syncData(world);
									}
								}
							}
						}
						if (!("").equals("Realtime Generation : Performance")) {
							if (true) {
								if (stringiterator.contains("count_max : ")) {
									ThtModVariables.MapVariables.get(world).generation_count_max = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("count_max : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("distance_max : ")) {
									ThtModVariables.MapVariables.get(world).generation_distance_max = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("distance_max : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("tp_limit : ")) {
									ThtModVariables.MapVariables.get(world).tp_limit = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("tp_limit : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("global_speed_enable : ")) {
									ThtModVariables.MapVariables.get(world).global_generate_speed = (stringiterator.replace("global_speed_enable : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("global_speed : ")) {
									ThtModVariables.MapVariables.get(world).global_generate_speed_speed = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("global_speed : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("global_speed_repeat : ")) {
									ThtModVariables.MapVariables.get(world).global_generate_speed_repeat = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("global_speed_repeat : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
							}
						}
						if (!("").equals("Realtime Generation : Quality")) {
							if (true) {
								if (stringiterator.contains("square_parts : ")) {
									ThtModVariables.MapVariables.get(world).square_parts = (stringiterator.replace("square_parts : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("square_leaves : ")) {
									ThtModVariables.MapVariables.get(world).square_leaves = (stringiterator.replace("square_leaves : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("rt_roots : ")) {
									ThtModVariables.MapVariables.get(world).rt_roots = new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(stringiterator.replace("rt_roots : ", ""));
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("grid_fix : ")) {
									ThtModVariables.MapVariables.get(world).grid_fix = (stringiterator.replace("grid_fix : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("no_core : ")) {
									ThtModVariables.MapVariables.get(world).no_core = (stringiterator.replace("no_core : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
							}
						}
						if (!("").equals("Misc")) {
							if (true) {
								if (stringiterator.contains("developer_mode : ")) {
									ThtModVariables.MapVariables.get(world).developer_mode = (stringiterator.replace("developer_mode : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
								if (stringiterator.contains("fireworks : ")) {
									ThtModVariables.MapVariables.get(world).fireworks = (stringiterator.replace("fireworks : ", "")).equals("true");
									ThtModVariables.MapVariables.get(world).syncData(world);
								}
							}
						}
					}
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
