package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;
import tannyjung.tht.ThtMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.ModList;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import java.util.Calendar;

public class LoopTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double world_spawn_posX = 0;
		double world_spawn_posY = 0;
		double world_spawn_posZ = 0;
		String variable_text2 = "";
		String variable_text = "";
		ThtMod.queueServerWork(1, () -> {
			if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) > 0) {
				LoopTickProcedure.execute(world, x, y, z);
			}
		});
		if (ThtModVariables.MapVariables.get(world).loop_second < 20) {
			ThtModVariables.MapVariables.get(world).loop_second = ThtModVariables.MapVariables.get(world).loop_second + 1;
			ThtModVariables.MapVariables.get(world).syncData(world);
		} else {
			ThtModVariables.MapVariables.get(world).loop_second = 1;
			ThtModVariables.MapVariables.get(world).syncData(world);
			if (ThtModVariables.MapVariables.get(world).auto_gen == true) {
				AutoGenLoopTickProcedure.execute(world, x, y, z);
			}
			if (!("").equals("Developer Mode")) {
				if (ThtModVariables.MapVariables.get(world).developer_mode == true) {
					if (!("").equals("Tree Location Count")) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"scoreboard players set tree_location THT 0");
						if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute at @e[tag=THT-tree_location] run scoreboard players add tree_location THT 1");
						} else {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute at @e[tag=THT-tree_location] if loaded ~ ~ ~ run scoreboard players add tree_location THT 1");
						}
					}
					if (!("").equals("World Gen Count")) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"scoreboard players set world_gen THT 0");
						if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute at @e[name=THT-world_gen,nbt=!{ForgeData:{world_gen_chosen:true}}] run scoreboard players add world_gen THT 1");
						} else {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute at @e[name=THT-world_gen,nbt=!{ForgeData:{world_gen_chosen:true}}] if loaded ~ ~ ~ run scoreboard players add world_gen THT 1");
						}
					}
					if (!("").equals("World Gen Set Count")) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"scoreboard players set world_gen_set THT 0");
						if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute at @e[name=THT-world_gen,nbt={ForgeData:{world_gen_chosen:true}}] run scoreboard players add world_gen_set THT 1");
						} else {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute at @e[name=THT-world_gen,nbt={ForgeData:{world_gen_chosen:true}}] if loaded ~ ~ ~ run scoreboard players add world_gen_set THT 1");
						}
					}
				}
			}
			if (!("").equals("RT Dynamic")) {
				if (ThtModVariables.MapVariables.get(world).rt_dynamic == true) {
					if (ThtModVariables.MapVariables.get(world).season_detector == true && ModList.get().isLoaded("sereneseasons")) {
						if (ThtModVariables.MapVariables.get(world).season_detector_tick >= 20) {
							ThtModVariables.MapVariables.get(world).season_detector_tick = 0;
							ThtModVariables.MapVariables.get(world).syncData(world);
						} else {
							if (true) {
								world_spawn_posX = world.getLevelData().getXSpawn();
								world_spawn_posY = -64;
								world_spawn_posZ = world.getLevelData().getZSpawn();
								if (ThtModVariables.MapVariables.get(world).season_detector_tick == 4 || ThtModVariables.MapVariables.get(world).season_detector_tick == 9 || ThtModVariables.MapVariables.get(world).season_detector_tick == 14
										|| ThtModVariables.MapVariables.get(world).season_detector_tick == 19) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(world_spawn_posX, world_spawn_posY, world_spawn_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												"fill ~ ~1 ~ ~ ~1 ~ air");
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(world_spawn_posX, world_spawn_posY, world_spawn_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												"fill ~ ~ ~ ~ ~ ~ air");
								}
								if (ThtModVariables.MapVariables.get(world).season_detector_tick == 0) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(world_spawn_posX, world_spawn_posY, world_spawn_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												("setblock ~ ~ ~ command_block[facing=up]{Command:\"THT command season set " + "spring" + "\"}"));
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(world_spawn_posX, world_spawn_posY, world_spawn_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												("setblock ~ ~1 ~ sereneseasons:season_sensor[season=" + "0" + "]"));
								}
								if (ThtModVariables.MapVariables.get(world).season_detector_tick == 5) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(world_spawn_posX, world_spawn_posY, world_spawn_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												("setblock ~ ~ ~ command_block[facing=up]{Command:\"THT command season set " + "summer" + "\"}"));
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(world_spawn_posX, world_spawn_posY, world_spawn_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												("setblock ~ ~1 ~ sereneseasons:season_sensor[season=" + "1" + "]"));
								}
								if (ThtModVariables.MapVariables.get(world).season_detector_tick == 10) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(world_spawn_posX, world_spawn_posY, world_spawn_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												("setblock ~ ~ ~ command_block[facing=up]{Command:\"THT command season set " + "autumn" + "\"}"));
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(world_spawn_posX, world_spawn_posY, world_spawn_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												("setblock ~ ~1 ~ sereneseasons:season_sensor[season=" + "2" + "]"));
								}
								if (ThtModVariables.MapVariables.get(world).season_detector_tick == 15) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(world_spawn_posX, world_spawn_posY, world_spawn_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												("setblock ~ ~ ~ command_block[facing=up]{Command:\"THT command season set " + "winter" + "\"}"));
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(world_spawn_posX, world_spawn_posY, world_spawn_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												("setblock ~ ~1 ~ sereneseasons:season_sensor[season=" + "3" + "]"));
								}
								ThtModVariables.MapVariables.get(world).season_detector_tick = ThtModVariables.MapVariables.get(world).season_detector_tick + 1;
								ThtModVariables.MapVariables.get(world).syncData(world);
							}
						}
					}
					if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-leaves_drop] at @s unless block ~ ~1.3 ~ #tht:passable_blocks run THT dev rt_dynamic leaves_drop");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-leaves_drop] at @s if block ~ ~1.5 ~ water run THT dev rt_dynamic leaves_drop");
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-leaves_drop] at @s if loaded ~ ~ ~ unless block ~ ~1.3 ~ #tht:passable_blocks run THT dev rt_dynamic leaves_drop");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-leaves_drop] at @s if loaded ~ ~ ~ if block ~ ~1.5 ~ water run THT dev rt_dynamic leaves_drop");
					}
					if (true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute at @e[name=THT-leaves_litter_remover] unless block ~ ~-1 ~ #tht:passable_blocks if block ~ ~ ~ #tht:leaves_blocks run setblock ~ ~ ~ air");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-leaves_litter_remover] at @s unless block ~ ~ ~ #tht:passable_blocks run kill @s");
					}
					if (true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute at @e[name=THT-leaves_litter_remover] if block ~ ~ ~ #tht:leaves_blocks[waterlogged=true] run setblock ~ ~ ~ water");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-leaves_litter_remover] at @s if block ~ ~ ~ #tht:leaves_blocks[waterlogged=true] run kill @s");
					}
				}
			}
			if (!("").equals("Tree Placer")) {
				if (ThtModVariables.MapVariables.get(world).tree_placer_auto_speed == true) {
					ThtModVariables.MapVariables.get(world).tree_placer_auto_speed_test = Math.abs(((new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new java.text.SimpleDateFormat("ss").format(Calendar.getInstance().getTime())) * 1000 + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new java.text.SimpleDateFormat("SSS").format(Calendar.getInstance().getTime()))) - ThtModVariables.MapVariables.get(world).tree_placer_auto_speed_test) - 1000);
					ThtModVariables.MapVariables.get(world).syncData(world);
					if (ThtModVariables.MapVariables.get(world).tree_placer_auto_speed_test > 20) {
						ThtModVariables.MapVariables.get(world).tree_placer_process_limit = ThtModVariables.MapVariables.get(world).tree_placer_process_limit - 20;
						ThtModVariables.MapVariables.get(world).syncData(world);
						if (ThtModVariables.MapVariables.get(world).tree_placer_process_limit < 20) {
							ThtModVariables.MapVariables.get(world).tree_placer_process_limit = 20;
							ThtModVariables.MapVariables.get(world).syncData(world);
						}
					} else {
						ThtModVariables.MapVariables.get(world).tree_placer_process_limit = ThtModVariables.MapVariables.get(world).tree_placer_process_limit + 20;
						ThtModVariables.MapVariables.get(world).syncData(world);
						if (ThtModVariables.MapVariables.get(world).tree_placer_process_limit > 200) {
							ThtModVariables.MapVariables.get(world).tree_placer_process_limit = 200;
							ThtModVariables.MapVariables.get(world).syncData(world);
						}
					}
					if (ThtModVariables.MapVariables.get(world).tree_placer_process_limit == 200) {
						ThtModVariables.MapVariables.get(world).tree_placer_tick_set = 1;
						ThtModVariables.MapVariables.get(world).syncData(world);
					} else {
						ThtModVariables.MapVariables.get(world).tree_placer_tick_set = 2;
						ThtModVariables.MapVariables.get(world).syncData(world);
					}
					ThtModVariables.MapVariables.get(world).tree_placer_count_limit = Math.ceil(ThtModVariables.MapVariables.get(world).tree_placer_process_limit / 20);
					ThtModVariables.MapVariables.get(world).syncData(world);
					if (ThtModVariables.MapVariables.get(world).developer_mode == true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("title @a actionbar [{\"text\":\"Tree Placer Speed = \",\"color\":\"white\"},{\"text\":\"" + ""
											+ (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).tree_placer_process_limit)).replace(".0", "") + " ("
											+ (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).tree_placer_auto_speed_test)).replace(".0", "") + " Delay)\",\"color\":\"gold\"}]"));
					}
					ThtModVariables.MapVariables.get(world).tree_placer_auto_speed_test = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new java.text.SimpleDateFormat("ss").format(Calendar.getInstance().getTime())) * 1000 + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new java.text.SimpleDateFormat("SSS").format(Calendar.getInstance().getTime()));
					ThtModVariables.MapVariables.get(world).syncData(world);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute at @e[name=THT-tree_placer_forceload] run forceload remove ~ ~ ~ ~");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"kill @e[name=THT-tree_placer_forceload]");
			}
		}
		if (!("").equals("Tree Placer")) {
			if (ThtModVariables.MapVariables.get(world).tree_placer_tick_set > 0) {
				if (ThtModVariables.MapVariables.get(world).tree_placer_tick < ThtModVariables.MapVariables.get(world).tree_placer_tick_set) {
					ThtModVariables.MapVariables.get(world).tree_placer_tick = ThtModVariables.MapVariables.get(world).tree_placer_tick + 1;
					ThtModVariables.MapVariables.get(world).syncData(world);
				} else {
					ThtModVariables.MapVariables.get(world).tree_placer_tick = 1;
					ThtModVariables.MapVariables.get(world).syncData(world);
					if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute at @p as @e[name=THT-world_gen,limit=1,sort=nearest,nbt=!{ForgeData:{world_gen_chosen:true}}] at @s run THT dev rt_world_gen");
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute at @p as @e[name=THT-world_gen,limit=1,sort=nearest,nbt=!{ForgeData:{world_gen_chosen:true}}] at @s if loaded ~ ~ ~ run THT dev rt_world_gen");
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tag @e[name=THT-world_gen] remove THT-tree_placer");
					if (true) {
						variable_text = "execute at @a as @e[name=THT-world_gen,nbt={ForgeData:{world_gen_chosen:true}}";
						if (ThtModVariables.MapVariables.get(world).tree_placer_count_limit > 0) {
							variable_text = variable_text + ",limit=" + (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).tree_placer_count_limit)).replace(".0", "") + ",sort=nearest";
						}
						if (ThtModVariables.MapVariables.get(world).tree_placer_distance_limit > 0) {
							variable_text = variable_text + ",distance=.." + ThtModVariables.MapVariables.get(world).tree_placer_distance_limit;
						}
						variable_text = variable_text + "] at @s run tag @s add THT-tree_placer";
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								variable_text);
					if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-world_gen,tag=THT-tree_placer] at @s run THT dev tree_placer");
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-world_gen,tag=THT-tree_placer] at @s if loaded ~ ~ ~ run THT dev tree_placer");
					}
				}
			}
		}
		if (!("").equals("RT Dynamic")) {
			if (ThtModVariables.MapVariables.get(world).rt_dynamic == true) {
				if (ThtModVariables.MapVariables.get(world).rt_dynamic_tick_set > 0) {
					if (ThtModVariables.MapVariables.get(world).rt_dynamic_tick < ThtModVariables.MapVariables.get(world).rt_dynamic_tick_set) {
						ThtModVariables.MapVariables.get(world).rt_dynamic_tick = ThtModVariables.MapVariables.get(world).rt_dynamic_tick + 1;
						ThtModVariables.MapVariables.get(world).syncData(world);
					} else {
						ThtModVariables.MapVariables.get(world).rt_dynamic_tick = 1;
						ThtModVariables.MapVariables.get(world).syncData(world);
						if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute at @p as @e[tag=THT-tree_location,limit=1,sort=random,nbt={ForgeData:{rt_dynamic:true}}] at @s run THT dev rt_dynamic tick");
						} else {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute at @p as @e[tag=THT-tree_location,limit=1,sort=random,nbt={ForgeData:{rt_dynamic:true}}] at @s if loaded ~ ~ ~ run THT dev rt_dynamic tick");
						}
					}
				}
				if (!("").equals("Leaves Drop")) {
					if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-leaves_drop] at @s if block ~ ~1.3 ~ #tht:passable_blocks unless block ~ ~1.5 ~ water unless block ~ ~1.5 ~ #tht:leaves_blocks[waterlogged=true] run tp @s ~ ~-0.1 ~");
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-leaves_drop] at @s if loaded ~ ~ ~ if block ~ ~1.3 ~ #tht:passable_blocks unless block ~ ~1.5 ~ water unless block ~ ~1.5 ~ #tht:leaves_blocks[waterlogged=true] run tp @s ~ ~-0.1 ~");
					}
				}
				if (!("").equals("Leaves Litter")) {
					if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-leaves_litter_remover] at @s if block ~ ~ ~ #tht:passable_blocks unless block ~ ~ ~ #tht:leaves_blocks[waterlogged=true] run tp @s ~ ~-1 ~");
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as @e[name=THT-leaves_litter_remover] at @s if loaded ~ ~ ~ if block ~ ~ ~ #tht:passable_blocks unless block ~ ~ ~ #tht:leaves_blocks[waterlogged=true] run tp @s ~ ~-1 ~");
					}
				}
			}
		}
		if (!("").equals("Auto Gen")) {
			if (ThtModVariables.MapVariables.get(world).auto_gen == true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute in tht:dimension positioned 0 0 0 as @e[name=THT-random_tree,limit=1,distance=..500] at @s run THT dev rt_run");
			}
		}
		if (!("").equals("Sapling")) {
			if (ThtModVariables.MapVariables.get(world).auto_gen == false) {
				if (ThtModVariables.MapVariables.get(world).global_generate_speed_speed != 0) {
					if (ThtModVariables.MapVariables.get(world).generation_count_max != 0) {
						variable_text = ",sort=nearest,limit=" + (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).generation_count_max)).replace(".0", "");
					}
					if (ThtModVariables.MapVariables.get(world).generation_distance_max != 0) {
						variable_text2 = ",distance=.." + (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).generation_distance_max)).replace(".0", "");
					}
				}
				if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @p as @e[name=THT-random_tree" + variable_text + variable_text2 + "] at @s run THT dev rt_run"));
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @p as @e[name=THT-random_tree" + variable_text + variable_text2 + "] at @s unless dimension tht:dimension run THT dev rt_run"));
				}
			}
		}
	}
}
