package tannyjung.tht.procedures;

import tannyjung.tht.ConfigRepairPlacement;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class ConfigRepairProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		boolean category_true = false;
		String default_value = "";
		String name = "";
		String set = "";
		String description = "";
		String category = "";
		String old_version = "";
		String finding_text = "";
		double loop = 0;
		double loop_next = 0;
		double finding_text_position = 0;
		double finding_text_position2 = 0;
		ConfigRepair2Procedure.execute(world, x, y, z);
		try {
			ConfigRepairPlacement.main(world, x, y, z);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (true) {
			FileWriter filewriter;
			BufferedWriter filebw;
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT"), File.separator + "config.txt");
			if (file.exists() == false) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute if entity @e[type=player,distance=..0.01] run tellraw @a [{\"text\":\"THT : Repaired \",\"color\":\"yellow\"},{\"text\":\"" + "config.txt" + "\",\"color\":\"white\"}]"));
			}
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String stringiterator = "";
				while ((stringiterator = fileReader.readLine()) != null) {
					old_version = old_version + "$" + stringiterator;
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (true) {
				try {
					filewriter = new FileWriter(file, false);
					filebw = new BufferedWriter(filewriter);
					if (true) {
						{
							filebw.write("- Apply the changes by run this command [ /THT config apply ] or restart the world");
							filebw.newLine();
						}
						{
							filebw.write("- Repair missing values by run this command [ /THT config repair ] or restart the world");
							filebw.newLine();
						}
						{
							filebw.write("");
							filebw.newLine();
						}
					}
					filebw.close();
					filewriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			loop = 1;
			for (int index0 = 0; index0 < 100; index0++) {
				loop_next = 1;
				category_true = false;
				if (true) {
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "TannyJung's Tree Pack";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "auto_check_update";
									default_value = "" + true;
									description = "// Check for the new update from GitHub every time the world starts";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "auto_update";
									default_value = "" + false;
									description = "// Auto update the pack every time the world starts, if there's a new update from GitHub. To use this feature, the \"auto_check_update\" config must be enable.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "wip_version";
									default_value = "" + false;
									description = "// Use WIP version instead of release version. It's development version before full version, may contain new trees that still work in progress. Warning that not recommended for game play.";
								}
								loop_next = loop_next + 1;
							}
						}
					}
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "World Gen";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "tree_placer_auto_speed";
									default_value = "" + true;
									description = "// Enable auto speed for the tree placer. Turn this ON will use specific speed value, not from config value. The speed will automatic change based from game delay per second. Slower when high delay, Faster when low delay.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "tree_placer_tick";
									default_value = "" + 2;
									description = "// How fast place a tree in tick. Set to 0 to temporary pause the tick.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "tree_placer_process_limit";
									default_value = "" + 200;
									description = "// Repeat process in a tick, slow down the tree placing instead of place them in one process. Can reduce lag spike, but also slower the speed. Set to 0 for one time process.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "tree_placer_count_limit";
									default_value = "" + 1;
									description = "// Count limit of tree placer in a time. Set to 0 for no limit.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "tree_placer_distance_limit";
									default_value = "" + 500;
									description = "// Max distance from players the tree placer will placing trees. Set to 0 for no limit.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "global_rarity";
									default_value = "" + 100;
									description = "// Change percent of all trees rarity in one config. By default, set to 100 means set the chance to every chunks. Set to 0 will disable them from all chunks. This option may not affect to the trees with high \"min_distance\" value.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "safe_zone_spawn";
									default_value = "" + 100;
									description = "// Cancel trees from spawning when it's near the world spawn";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "safe_zone_village";
									default_value = "" + 50;
									description = "// Cancel trees from spawning when it's near the villages. This use villagers as a marker and some entities such as pillagers, so trees may still spawn if can't detect villagers nearby (this caused by unloaded chunks).";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "tree_location";
									default_value = "" + true;
									description = "// This is for store some tree data and for some features. Disable this will remove tree location from world gen. Can reduce entity lag, but you will don't know what is the file name of that tree, also some features will not work such as safe zones, tree distancing and RT dynamic.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "world_gen_roots";
									default_value = "" + true;
									description = "// Enable tree roots in world gen. Note that disable this feature will not affect to some trees and nature stuffs because roots is important part for them.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "surface_smoothness_detection_size";
									default_value = "" + 5;
									description = "// Set size of the detector, for all detectors at 8 directions. Set to 0 to disable this feature.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "surface_smoothness_detection_height";
									default_value = "" + 5;
									description = "// Set height of the detector, this value for each up and down. If the detector detects that the surface is rough than this height, it will cancel the tree.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "world_hight_limit";
									default_value = "" + 320;
									description = "// Set highest Y limit, to prevent trees from placing if they higher than world hight to protect them from head cut-off. Set to 0 to disable this feature.";
								}
								loop_next = loop_next + 1;
							}
						}
					}
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "RT Dynamic";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "rt_dynamic";
									default_value = "" + true;
									description = "// Enable some special features such as leaves regrow, drop leaves if their twig is missing and deciduous leaves (drop leaves before winter).";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "rt_dynamic_tick";
									default_value = "" + 5;
									description = "// How fast of RT dynamic system per tick. Set to 0 to temporary pause the tick.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "rt_dynamic_process_limit";
									default_value = "" + 100;
									description = "// How many process for trees to run RT dynamic system. Set to 0 for one time process.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "rt_dynamic_simulation";
									default_value = "" + 50;
									description = "// Simulate fake tree to slowdown tree process. For example, when I set tree speed for 100 trees. But it's only 1 tree in the area, it will drop and regrow leaves very fast because that's the speed for 100 trees. Set this config will simulate fake tree locations and make that 1 tree slowdown it process like it's 99 trees around it.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "season_detector";
									default_value = "" + true;
									description = "// Use an area from world spawn to detect current season from Serene Seasons mod";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "leaves_litter";
									default_value = "" + true;
									description = "// Create leaves block on the ground. Disable leaves drop animation to make this instantly create leaves little instead of create when leaves drop animation touch the ground, also disable that will use full chance to be leaves litter.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "leaves_litter_remover_chance";
									default_value = "" + 0.001;
									description = "// Chance of leaves block on ground to disappear per process. Set to 0 to disable this feature.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "leaves_litter_remover_count_limit";
									default_value = "" + 10;
									description = "// Count limit of the leaves litter remover";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "pre_leaves_litter_chance";
									default_value = "" + 0.25;
									description = "// Create leaves litter for normal leaves on the ground and water while on worldgen";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "pre_leaves_litter_coniferous_chance";
									default_value = "" + 0.05;
									description = "// Create leaves litter for coniferous leaves on the ground and water while on worldgen";
								}
								loop_next = loop_next + 1;
							}
						}
					}
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "RT Dynamic : Leaves Drop and Regrow";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "leaves_drop_animation_chance";
									default_value = "" + 0.1;
									description = "// Chance of animation that will appear at leaves drop block on the tree";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "leaves_drop_animation_count_limit";
									default_value = "" + 50;
									description = "// Count limit of leaves drop animation";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (true) {
									if (loop == loop_next) {
										name = "leaves_regrow_spring_chance";
										default_value = "" + 0.01;
										description = "// Chance of deciduous leaves to regrow in spring";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										name = "leaves_regrow_summer_chance";
										default_value = "" + 0.05;
										description = "// Chance of deciduous leaves to regrow in summer. Also use in normal leaves for all season.";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										name = "leaves_regrow_autumn_chance";
										default_value = "" + 0;
										description = "// Chance of deciduous leaves to regrow in autumn";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										name = "leaves_regrow_winter_chance";
										default_value = "" + 0;
										description = "// Chance of deciduous leaves to regrow in winter";
									}
									loop_next = loop_next + 1;
								}
							}
							if (true) {
								if (true) {
									if (loop == loop_next) {
										name = "leaves_drop_spring_chance";
										default_value = "" + 0;
										description = "// Chance of deciduous leaves to drop in spring";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										name = "leaves_drop_summer_chance";
										default_value = "" + 0.01;
										description = "// Chance of deciduous leaves to drop in summer. Also use in normal leaves for all season.";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										name = "leaves_drop_autumn_chance";
										default_value = "" + 0.05;
										description = "// Chance of deciduous leaves to drop in autumn";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										name = "leaves_drop_winter_chance";
										default_value = "" + 0.1;
										description = "// Chance of deciduous leaves to drop in winter";
									}
									loop_next = loop_next + 1;
								}
							}
							if (true) {
								if (true) {
									if (loop == loop_next) {
										name = "leaves_regrow_chance_coniferous";
										default_value = "" + 0.005;
										description = "// Chance of coniferous leaves to regrow in all season";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										name = "leaves_drop_chance_coniferous";
										default_value = "" + 0.001;
										description = "// Chance of coniferous leaves to drop in summer";
									}
									loop_next = loop_next + 1;
								}
							}
						}
					}
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "Realtime Generation : Performance";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "count_max";
									default_value = "" + 1;
									description = "// How many trees will generate in the same time. Set to 0 for no limit.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "distance_max";
									default_value = "" + 0;
									description = "// How far the trees will process. Set to 0 for no limit.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "tp_limit";
									default_value = "" + 100;
									description = "// This option change how many block the parts generator will teleport in a time. Increase this can cause lag because it teleports too fast. Set to 0 for no limit.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "global_speed_enable";
									default_value = "" + true;
									description = "// When true, it will change generator speed of all trees to the same.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "global_speed";
									default_value = "" + 1;
									description = "// How fast of generator speed in tick. Increase this will make it slower. Set to 0 for temporary pause all trees.";
									loop_next = loop_next + 1;
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "global_speed_repeat";
									default_value = "" + 100;
									description = "// This make generator repeats it process in one time of it speed. Increase this will make it generate faster but also cause lag. Set to 0 for one time generation that can freeze the game.";
									loop_next = loop_next + 1;
								}
								loop_next = loop_next + 1;
							}
						}
					}
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "Realtime Generation : Quality";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "square_parts";
									default_value = "" + false;
									description = "// Make all trees wood become cube, or that I called \"Low Detail Mode\". Make the generation more faster, but become unrealistic.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "square_leaves";
									default_value = "" + false;
									description = "// Make all trees leaves become cube, or that I called \"Low Detail Mode\". Make the generation more faster, but become unrealistic.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "rt_roots";
									default_value = "" + 100;
									description = "// Change percent of roots length for all random trees. Set to 0 will disable roots from generation.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "grid_fix";
									default_value = "" + true;
									description = "// For RT that generate using structure generation. Fix trees generate in grid.";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "no_core";
									default_value = "" + false;
									description = "// Disable core and inner from generation. Can increase speed of tree generation.";
								}
								loop_next = loop_next + 1;
							}
						}
					}
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "Misc";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "developer_mode";
									default_value = "" + false;
									description = "// Enable some features for debugging";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "fireworks";
									default_value = "" + true;
									description = "// Summon fireworks when tree from sapling finishes generating";
								}
								loop_next = loop_next + 1;
							}
						}
					}
				}
				if (loop != loop_next) {
					loop = loop + 1;
					if (true) {
						try {
							filewriter = new FileWriter(file, true);
							filebw = new BufferedWriter(filewriter);
							if (true) {
								if (category_true == true) {
									{
										filebw.write("----------------------------------------------------------------------------------------------------");
										filebw.newLine();
									}
									{
										filebw.write(category);
										filebw.newLine();
									}
									{
										filebw.write("----------------------------------------------------------------------------------------------------");
										filebw.newLine();
									}
									{
										filebw.write("");
										filebw.newLine();
									}
								} else {
									if (!old_version.contains(name + " : ")) {
										set = name + " : " + default_value;
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													("execute if entity @e[type=player,distance=..0.01] run tellraw @a [\"\",{\"text\":\"THT : Repaired \",\"color\":\"yellow\"},{\"text\":\"" + "" + ("config.txt" + " > " + name)
															+ "\",\"color\":\"white\"}]"));
									} else {
										set = "";
										finding_text_position = 0;
										finding_text_position2 = 0;
										for (int index1 = 0; index1 < (int) (old_version).length(); index1++) {
											finding_text_position2 = finding_text_position2 + 1;
											if ((old_version.substring((int) finding_text_position, (int) finding_text_position2)).contains("$")) {
												if ((old_version.substring((int) finding_text_position, (int) finding_text_position2)).contains(name + " : ")) {
													set = old_version.substring((int) finding_text_position, (int) (finding_text_position2 - 1));
													break;
												} else {
													finding_text_position = finding_text_position2;
												}
											}
										}
									}
									{
										filebw.write(set);
										filebw.newLine();
									}
									{
										filebw.write(description);
										filebw.newLine();
									}
									{
										filebw.write(("// Default is " + default_value));
										filebw.newLine();
									}
									{
										filebw.write("");
										filebw.newLine();
									}
								}
							}
							filebw.close();
							filewriter.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}
				} else {
					if (true) {
						try {
							filewriter = new FileWriter(file, true);
							filebw = new BufferedWriter(filewriter);
							if (true) {
								{
									filebw.write("----------------------------------------------------------------------------------------------------");
									filebw.newLine();
								}
							}
							filebw.close();
							filewriter.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}
					break;
				}
			}
		}
	}
}
