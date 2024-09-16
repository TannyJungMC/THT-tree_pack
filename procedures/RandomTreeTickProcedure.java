package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;
import tannyjung.tht.ThtMod;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;

public class RandomTreeTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double variable_number = 0;
		double variable_number2 = 0;
		File file = new File("");
		String variable_text2 = "";
		String variable_text = "";
		String type_next = "";
		String type_pre = "";
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "particle composter ~ ~ ~ 0 0 0 0 1 force");
			}
		}
		if (!((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.COMMAND_BLOCK || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.STRUCTURE_BLOCK)) {
			if (entity.getPersistentData().getBoolean("start_tp") == false) {
				entity.getPersistentData().putBoolean("start_tp", true);
				if (entity.getPersistentData().getBoolean("can_disable_roots") == true && (world.getBlockState(new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ()))).getBlock() == Blocks.SCAFFOLDING) {
					entity.getPersistentData().putBoolean("no_roots", true);
				}
				if (ThtModVariables.MapVariables.get(world).auto_gen == false) {
					variable_number = x + Mth.nextInt(RandomSource.create(), 0, 15);
					variable_number2 = z + Mth.nextInt(RandomSource.create(), 0, 15);
					if (ThtModVariables.MapVariables.get(world).grid_fix == true && entity.getPersistentData().getBoolean("grid_fix") == true
							&& !(world.getBlockState(new BlockPos(variable_number, y, variable_number2))).is(BlockTags.create(new ResourceLocation("tht:air_blocks")))
							&& !(world.getBlockState(new BlockPos(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("tht:air_blocks")))) {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
												_ent.level.getServer(), _ent),
										("clone" + (" " + (new java.text.DecimalFormat("##.##").format(Math.floor(variable_number))).replace(".0", "") + " ~ "
												+ (new java.text.DecimalFormat("##.##").format(Math.floor(variable_number2))).replace(".0", ""))
												+ (" " + (new java.text.DecimalFormat("##.##").format(Math.floor(variable_number))).replace(".0", "") + " ~ "
														+ (new java.text.DecimalFormat("##.##").format(Math.floor(variable_number2))).replace(".0", ""))
												+ " ~ ~ ~ masked move"));
							}
						}
					} else {
						variable_number = x;
						variable_number2 = z;
					}
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("tp " + variable_number + " ~" + entity.getPersistentData().getDouble("start_height") + " " + variable_number2));
						}
					}
				}
			}
			if (entity.getPersistentData().getDouble("time_used_tick") < 20) {
				entity.getPersistentData().putDouble("time_used_tick", (entity.getPersistentData().getDouble("time_used_tick") + 1));
			} else {
				entity.getPersistentData().putDouble("time_used_tick", 1);
				entity.getPersistentData().putDouble("time_used", (entity.getPersistentData().getDouble("time_used") + 1));
			}
			if (true) {
				if (ThtModVariables.MapVariables.get(world).global_generate_speed == true && entity.getPersistentData().getBoolean("global_generate_speed") == true) {
					entity.getPersistentData().putDouble("generate_speed", ThtModVariables.MapVariables.get(world).global_generate_speed_speed);
					entity.getPersistentData().putDouble("generate_speed_repeat", ThtModVariables.MapVariables.get(world).global_generate_speed_repeat);
				}
				if (entity.getPersistentData().getDouble("generate_speed_repeat") > 0) {
					entity.getPersistentData().putDouble("repeat", (entity.getPersistentData().getDouble("generate_speed_repeat")));
				} else {
					entity.getPersistentData().putDouble("repeat", 1);
				}
				if (entity.getPersistentData().getDouble("generate_speed_test") > 0) {
					entity.getPersistentData().putDouble("generate_speed_test", (entity.getPersistentData().getDouble("generate_speed_test") - 1));
				} else {
					entity.getPersistentData().putDouble("generate_speed_test", (entity.getPersistentData().getDouble("generate_speed")));
				}
			}
			if (entity.getPersistentData().getDouble("generate_speed_test") == 0) {
				if (entity.getPersistentData().getBoolean("start") == false) {
					entity.getPersistentData().putBoolean("start", true);
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "kill @e[tag=THT-tree_countdown,distance=..1,limit=1,sort=nearest]");
						}
					}
					RandomTreeTickStartProcedure.execute(world, x, y, z, entity);
				}
				while (entity.getPersistentData().getBoolean("complete") == false) {
					entity.getPersistentData().putDouble("tp_limit", ThtModVariables.MapVariables.get(world).tp_limit);
					for (int index1 = 0; index1 < (int) entity.getPersistentData().getDouble("repeat"); index1++) {
						if (entity.getPersistentData().getBoolean("complete") == false) {
							if (entity.getPersistentData().getBoolean("debug_mode") == true && !(entity.getPersistentData().getString("step")).equals("part_create")
									&& ((entity.getPersistentData().getString("debug_mode_output")).equals("all") || (entity.getPersistentData().getString("debug_mode_output")).equals(entity.getPersistentData().getString("type")))) {
								if (true) {
									if (true) {
										ThtMod.LOGGER.info("--------------------------------------------------");
										ThtMod.LOGGER.info("Type : " + entity.getPersistentData().getString("type") + " > " + entity.getPersistentData().getString("up-down") + " > " + entity.getPersistentData().getString("step"));
										ThtMod.LOGGER.info("Count : " + entity.getPersistentData().getDouble((entity.getPersistentData().getString("type") + "_count")) + " / "
												+ entity.getPersistentData().getDouble((entity.getPersistentData().getString("type") + "_count_save")));
										ThtMod.LOGGER.info("Length : " + entity.getPersistentData().getDouble((entity.getPersistentData().getString("type") + "_length")) + " / "
												+ entity.getPersistentData().getDouble((entity.getPersistentData().getString("type") + "_length_save")));
										ThtMod.LOGGER.info("Thickness : " + entity.getPersistentData().getDouble((entity.getPersistentData().getString("type") + "_thickness")));
									}
									if (false) {
										if (!("").equals("pre-next")) {
											type_pre = "";
											type_next = "";
											if (true) {
												if ((entity.getPersistentData().getString("type")).equals("secondary_root")) {
													type_pre = "taproot";
												} else if ((entity.getPersistentData().getString("type")).equals("tertiary_root")) {
													type_pre = "secondary_root";
												} else if ((entity.getPersistentData().getString("type")).equals("fine_root")) {
													type_pre = "tertiary_root";
												}
												if ((entity.getPersistentData().getString("type")).equals("taproot")) {
													type_next = "secondary_root";
												} else if ((entity.getPersistentData().getString("type")).equals("secondary_root")) {
													type_next = "tertiary_root";
												} else if ((entity.getPersistentData().getString("type")).equals("tertiary_root")) {
													type_next = "fine_root";
												}
											}
											if (true) {
												if ((entity.getPersistentData().getString("type")).equals("branch")) {
													type_pre = "trunk";
												} else if ((entity.getPersistentData().getString("type")).equals("twig")) {
													type_pre = "branch";
												} else if ((entity.getPersistentData().getString("type")).equals("leaves_twig")) {
													type_pre = "twig";
												} else if ((entity.getPersistentData().getString("type")).equals("leaves")) {
													type_pre = "leaves_twig";
												}
												if ((entity.getPersistentData().getString("type")).equals("trunk")) {
													type_next = "branch";
												} else if ((entity.getPersistentData().getString("type")).equals("branch")) {
													type_next = "twig";
												} else if ((entity.getPersistentData().getString("type")).equals("twig")) {
													type_next = "leaves_twig";
												} else if ((entity.getPersistentData().getString("type")).equals("leaves_twig")) {
													type_next = "leaves";
												}
											}
										}
										if (entity.getPersistentData().getDouble((type_pre + "_count_save")) > 0) {
											ThtMod.LOGGER.info("");
											ThtMod.LOGGER.info("Pre Count : " + entity.getPersistentData().getDouble((type_pre + "_count")) + " / " + entity.getPersistentData().getDouble((type_pre + "_count_save")));
											ThtMod.LOGGER.info("Pre Length : " + entity.getPersistentData().getDouble((type_pre + "_length")) + " / " + entity.getPersistentData().getDouble((type_pre + "_length_save")));
											ThtMod.LOGGER.info("Pre Thickness : " + entity.getPersistentData().getDouble((type_pre + "_thickness")));
										}
										if ((entity.getPersistentData().getString("type")).equals("leaves")) {
											ThtMod.LOGGER.info("");
											ThtMod.LOGGER.info("Leaves Size : " + entity.getPersistentData().getDouble("leaves_size"));
										} else {
											if (entity.getPersistentData().getDouble((type_next + "_count_save")) > 0) {
												ThtMod.LOGGER.info("");
												ThtMod.LOGGER.info("Next Count : " + entity.getPersistentData().getDouble((type_next + "_count")) + " / " + entity.getPersistentData().getDouble((type_next + "_count_save")));
												ThtMod.LOGGER.info("Next Length : " + entity.getPersistentData().getDouble((type_next + "_length")) + " / " + entity.getPersistentData().getDouble((type_next + "_length_save")));
												ThtMod.LOGGER.info("Next Thickness : " + entity.getPersistentData().getDouble((type_next + "_thickness")));
											}
										}
									}
								}
							}
							if ((entity.getPersistentData().getString("step")).equals("summon")) {
								RandomTreeTickSummonProcedure.execute(world, x, y, z, entity);
								if (true) {
									entity.getPersistentData().putDouble("status_step", (entity.getPersistentData().getDouble("status_step") + 1));
									{
										Entity _ent = entity;
										if (!_ent.level.isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level.getServer(), _ent),
													("execute as @e[tag=THT-tree_status,distance=..1,limit=1,sort=nearest] at @s run data merge entity @s {CustomName:'{\"text\":\"" + ""
															+ ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("status_step_min"))).replace(".0", "") + "-"
																	+ (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("status_step_max"))).replace(".0", "") + " / "
																	+ (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("status_step"))).replace(".0", ""))
															+ "\",\"color\":\"red\"}'}"));
										}
									}
								}
							}
							if ((entity.getPersistentData().getString("step")).equals("create")) {
								RandomTreeTickCreateProcedure.execute(world, x, y, z, entity);
							}
							if ((entity.getPersistentData().getString("step")).equals("part_create")) {
								RandomTreeTickPartCreateProcedure.execute(world, x, y, z, entity);
							}
							if ((entity.getPersistentData().getString("step")).equals("end")) {
								entity.getPersistentData().putBoolean("complete", true);
								if (ThtModVariables.MapVariables.get(world).auto_gen == true) {
									entity.getPersistentData().putDouble("finish_cooldown", 220);
								} else {
									entity.getPersistentData().putDouble("finish_cooldown", 20);
								}
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null,
												4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "kill @e[tag=THT-tree_status,distance=..1,limit=1,sort=nearest]");
									}
								}
								break;
							}
							if (entity.getPersistentData().getDouble("tp_limit") < 1 && ThtModVariables.MapVariables.get(world).tp_limit != 0) {
								break;
							}
						}
					}
					if (entity.getPersistentData().getDouble("generate_speed_repeat") > 0) {
						break;
					}
				}
			}
		}
		if (entity.getPersistentData().getBoolean("complete") == true) {
			if (entity.getPersistentData().getDouble("finish_cooldown") > 0) {
				entity.getPersistentData().putDouble("finish_cooldown", (entity.getPersistentData().getDouble("finish_cooldown") - 1));
			} else {
				if (entity.getPersistentData().getDouble("end_function_chance") > Math.random()) {
					if (ThtModVariables.MapVariables.get(world).auto_gen == false) {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), (entity.getPersistentData().getString("end_function")));
							}
						}
					} else {
						file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/generated"), File.separator + (entity.getPersistentData().getString("file_name")));
						try {
							FileWriter filewriter = new FileWriter(file);
							BufferedWriter filebw = new BufferedWriter(filewriter);
							{
								filebw.write("+fe");
								filebw.newLine();
							}
							filebw.close();
							filewriter.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}
				}
				if (ThtModVariables.MapVariables.get(world).auto_gen == true) {
					AutoGenWhenTreeFinishProcedure.execute(world, x, y, z, entity);
				}
				if (ThtModVariables.MapVariables.get(world).fireworks == true) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute if entity @p[distance=..200] run summon firework_rocket ~20 ~10 ~20 {LifeTime:40,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:4,Flicker:1,Trail:1,Colors:[I;3887386,4312372],FadeColors:[I;3887386,4312372]}]}}}}");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute if entity @p[distance=..200] run summon firework_rocket ~20 ~10 ~-20 {LifeTime:40,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:4,Flicker:1,Trail:1,Colors:[I;3887386,4312372],FadeColors:[I;3887386,4312372]}]}}}}");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute if entity @p[distance=..200] run summon firework_rocket ~-20 ~10 ~20 {LifeTime:40,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:4,Flicker:1,Trail:1,Colors:[I;3887386,4312372],FadeColors:[I;3887386,4312372]}]}}}}");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute if entity @p[distance=..200] run summon firework_rocket ~-20 ~10 ~-20 {LifeTime:40,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:4,Flicker:1,Trail:1,Colors:[I;3887386,4312372],FadeColors:[I;3887386,4312372]}]}}}}");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("kill @e[tag=THT-tree_" + entity.getPersistentData().getString("tree_id") + "]"));
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
}
