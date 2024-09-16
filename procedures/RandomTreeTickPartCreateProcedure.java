package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.File;

public class RandomTreeTickPartCreateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean square_true = false;
		double part_size = 0;
		double leaves_straighten = 0;
		double leaves_straighten_place = 0;
		File file = new File("");
		String block_keep = "";
		String block_data = "";
		if (entity.getPersistentData().getBoolean("part_create_true") == false) {
			entity.getPersistentData().putBoolean("part_create_true", true);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute at @e[name=THT-tree_" + entity.getPersistentData().getString("type") + "_" + entity.getPersistentData().getString("tree_id")
								+ "] run summon armor_stand ~ ~ ~ {Tags:[\"THT-random_tree\"],NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "\"}'}"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute as @e[name=THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "] at @s run tp @s ~ ~ ~ ~ 90"));
			if (true) {
				if ((entity.getPersistentData().getString("type")).equals("leaves")) {
					part_size = entity.getPersistentData().getDouble("leaves_size");
				} else {
					part_size = entity.getPersistentData().getDouble((entity.getPersistentData().getString("type") + "_thickness"));
				}
				entity.getPersistentData().putDouble("part_create", part_size);
				entity.getPersistentData().putDouble("part_create3", 0);
				entity.getPersistentData().putDouble("part_create4", 90);
				if (!(entity.getPersistentData().getString("type")).equals("leaves") && (ThtModVariables.MapVariables.get(world).no_core == true
						|| (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_inner"))).equals("") && (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_core"))).equals(""))) {
					entity.getPersistentData().putDouble("part_create2", (entity.getPersistentData().getDouble("part_create")));
				} else {
					entity.getPersistentData().putDouble("part_create2", 0);
				}
			}
		}
		while (entity.getPersistentData().getDouble("part_create2") <= entity.getPersistentData().getDouble("part_create")) {
			RandomTreeTickWayFunctionProcedure.execute(world, entity);
			if (entity.getPersistentData().getDouble("part_create3") < 360) {
				if (entity.getPersistentData().getDouble("part_create4") >= -90) {
					if ((entity.getPersistentData().getString("type")).equals("leaves")) {
						if (true) {
							if (entity.getPersistentData().getBoolean("leaves_replace") == true) {
								block_keep = "";
							} else {
								if (ThtModVariables.MapVariables.get(world).square_leaves == true || (entity.getPersistentData().getString("leaves_generator_type")).equals("square")) {
									block_keep = " replace #tht:passable_blocks";
								} else {
									block_keep = " if block ~ ~ ~ #tht:passable_blocks";
								}
							}
							if (ThtModVariables.MapVariables.get(world).square_leaves == true || (entity.getPersistentData().getString("leaves_generator_type")).equals("square")) {
								if (entity.getPersistentData().getDouble("leaves2_chance") > Math.random()) {
									entity.getPersistentData().putString("block", (entity.getPersistentData().getString("leaves2")));
									entity.getPersistentData().putString("type_short", (entity.getPersistentData().getString(("leaves2" + "_short"))));
									entity.getPersistentData().putString("block_placer", "leaves_2");
								} else {
									entity.getPersistentData().putString("block", (entity.getPersistentData().getString("leaves")));
									entity.getPersistentData().putString("type_short", (entity.getPersistentData().getString(("leaves" + "_short"))));
									entity.getPersistentData().putString("block_placer", "leaves");
								}
								square_true = true;
							} else {
								if ((entity.getPersistentData().getString("leaves_generator_type")).equals("sphere")) {
									if (Mth.nextDouble(RandomSource.create(), 1, 100) <= entity.getPersistentData().getDouble("leaves_density")) {
										leaves_straighten = 0;
										leaves_straighten_place = 0;
										if (Mth.nextInt(RandomSource.create(), 1, 100) <= entity.getPersistentData().getDouble("leaves_straighten_percent")) {
											leaves_straighten = Mth.nextInt(RandomSource.create(), (int) entity.getPersistentData().getDouble("leaves_straighten_min"), (int) entity.getPersistentData().getDouble("leaves_straighten_max"));
										}
										for (int index1 = 0; index1 < (int) (leaves_straighten + 1); index1++) {
											if (entity.getPersistentData().getDouble("leaves2_chance") > Math.random()) {
												entity.getPersistentData().putString("block", (entity.getPersistentData().getString("leaves2")));
												entity.getPersistentData().putString("type_short", (entity.getPersistentData().getString(("leaves2" + "_short"))));
												entity.getPersistentData().putString("block_placer", "leaves_2");
											} else {
												entity.getPersistentData().putString("block", (entity.getPersistentData().getString("leaves")));
												entity.getPersistentData().putString("type_short", (entity.getPersistentData().getString(("leaves" + "_short"))));
												entity.getPersistentData().putString("block_placer", "leaves");
											}
											if (ThtModVariables.MapVariables.get(world).auto_gen == true) {
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
															("execute at @e[name=THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "] positioned ^ ^ ^" + entity.getPersistentData().getDouble("part_create2")
																	+ " positioned ~ ~-" + leaves_straighten_place + " ~" + block_keep + " run setblock ~ ~ ~ tht:block_placer_"
																	+ (entity.getPersistentData().getString("block_placer") + "{ForgeData:{" + "file_name:\"" + entity.getPersistentData().getString("file_name") + "\""
																			+ (",RT_posX:" + entity.getX() + ",RT_posY:" + entity.getY() + ",RT_posZ:" + entity.getZ()) + ",type_short:\"" + entity.getPersistentData().getString("type_short")
																			+ "\",block:\"" + entity.getPersistentData().getString("block") + "\",set_function:\"" + entity.getPersistentData().getString("set_function") + "\"}}")));
											} else {
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
															("execute at @e[name=THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "] positioned ^ ^ ^" + entity.getPersistentData().getDouble("part_create2")
																	+ " positioned ~ ~-" + leaves_straighten_place + " ~" + block_keep + " run setblock ~ ~ ~ " + entity.getPersistentData().getString("block")));
												if (!(entity.getPersistentData().getString("set_function")).equals("")) {
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																("execute at @e[name=THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "] positioned ^ ^ ^" + entity.getPersistentData().getDouble("part_create2")
																		+ " positioned ~ ~-" + leaves_straighten_place + " ~ run " + entity.getPersistentData().getString("set_function")));
												}
											}
											leaves_straighten_place = leaves_straighten_place + 1;
										}
									}
									square_true = false;
								}
							}
						}
					} else {
						if (true) {
							if (entity.getPersistentData().getBoolean((entity.getPersistentData().getString("type") + "_replace")) == true) {
								block_keep = "";
							} else {
								if (ThtModVariables.MapVariables.get(world).square_parts == true || (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_generator_type"))).equals("square")) {
									block_keep = " replace #tht:passable_blocks";
								} else {
									block_keep = " if block ~ ~ ~ #tht:passable_blocks";
								}
							}
							if (ThtModVariables.MapVariables.get(world).square_parts == true || (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_generator_type"))).equals("square")) {
								entity.getPersistentData().putString("block", (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_outer"))));
								entity.getPersistentData().putString("type_short", (entity.getPersistentData().getString(((entity.getPersistentData().getString("type") + "_outer") + "_short"))));
								entity.getPersistentData().putString("block_placer", (entity.getPersistentData().getString("type") + "_outer"));
								square_true = true;
							} else {
								if ((entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_generator_type"))).equals("sphere")) {
									if (entity.getPersistentData().getDouble("part_create3") == 0 && entity.getPersistentData().getDouble("part_create4") == 90) {
										RandomTreeTickPartCreateCoreTestProcedure.execute(entity);
									}
									if (ThtModVariables.MapVariables.get(world).auto_gen == true) {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													("execute at @e[name=THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "] positioned ^ ^ ^" + entity.getPersistentData().getDouble("part_create2")
															+ (" unless block ~ ~ ~ " + ("tht:block_placer_" + entity.getPersistentData().getString("block_placer"))) + entity.getPersistentData().getString("setblock_unless") + block_keep
															+ " run setblock ~ ~ ~ "
															+ (("tht:block_placer_" + entity.getPersistentData().getString("block_placer")) + "{ForgeData:{" + "file_name:\"" + entity.getPersistentData().getString("file_name") + "\""
																	+ (",RT_posX:" + entity.getX() + ",RT_posY:" + entity.getY() + ",RT_posZ:" + entity.getZ()) + ",type_short:\"" + entity.getPersistentData().getString("type_short") + "\",block:\""
																	+ entity.getPersistentData().getString("block") + "\",set_function:\"" + entity.getPersistentData().getString("set_function") + "\"}}")));
									} else {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													("execute at @e[name=THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "] positioned ^ ^ ^" + entity.getPersistentData().getDouble("part_create2")
															+ (" unless block ~ ~ ~ " + entity.getPersistentData().getString("block")) + entity.getPersistentData().getString("setblock_unless") + block_keep + " run setblock ~ ~ ~ "
															+ entity.getPersistentData().getString("block")));
										if (!(entity.getPersistentData().getString("set_function")).equals("")) {
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														("execute at @e[name=THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "] positioned ^ ^ ^" + entity.getPersistentData().getDouble("part_create2") + " run "
																+ entity.getPersistentData().getString("set_function")));
										}
									}
								}
								square_true = false;
							}
						}
					}
					if (square_true == true) {
						if (ThtModVariables.MapVariables.get(world).auto_gen == true) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("execute at @e[name=THT-tree_" + (entity.getPersistentData().getString("type") + "_" + entity.getPersistentData().getString("tree_id")) + "] run fill "
												+ "~x ~x ~x ~-x ~-x ~-x".replace("x", "" + entity.getPersistentData().getDouble("part_create") * 0.5) + " tht:block_placer_"
												+ (entity.getPersistentData().getString("block_placer") + "{ForgeData:{" + "file_name:\"" + entity.getPersistentData().getString("file_name") + "\""
														+ (",RT_posX:" + entity.getX() + ",RT_posY:" + entity.getY() + ",RT_posZ:" + entity.getZ()) + ",type_short:\"" + entity.getPersistentData().getString("type_short") + "\",block:\""
														+ entity.getPersistentData().getString("block") + "\",set_function:\"" + entity.getPersistentData().getString("set_function") + "\"}}")
												+ block_keep));
						} else {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("execute at @e[name=THT-tree_" + (entity.getPersistentData().getString("type") + "_" + entity.getPersistentData().getString("tree_id")) + "] run fill "
												+ "~x ~x ~x ~-x ~-x ~-x".replace("x", "" + entity.getPersistentData().getDouble("part_create") * 0.5) + " " + entity.getPersistentData().getString("block") + block_keep));
						}
						entity.getPersistentData().putDouble("part_create2", (entity.getPersistentData().getDouble("part_create") + 1));
					}
					entity.getPersistentData().putDouble("part_create4", (entity.getPersistentData().getDouble("part_create4") - 360 / (2 * (22 / 7) * entity.getPersistentData().getDouble("part_create2"))));
				}
				if (entity.getPersistentData().getDouble("part_create4") <= -90) {
					entity.getPersistentData().putDouble("part_create4", 90);
					entity.getPersistentData().putDouble("part_create3", (entity.getPersistentData().getDouble("part_create3") + 360 / (2 * (22 / 7) * entity.getPersistentData().getDouble("part_create2"))));
				}
			}
			if (entity.getPersistentData().getDouble("part_create3") >= 360) {
				entity.getPersistentData().putDouble("part_create3", 0);
				entity.getPersistentData().putDouble("part_create4", 90);
				if (entity.getPersistentData().getDouble("part_create2") != entity.getPersistentData().getDouble("part_create")) {
					entity.getPersistentData().putDouble("part_create2", (entity.getPersistentData().getDouble("part_create2") + 0.5));
					if (entity.getPersistentData().getDouble("part_create2") > entity.getPersistentData().getDouble("part_create")) {
						entity.getPersistentData().putDouble("part_create2", (entity.getPersistentData().getDouble("part_create")));
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("kill @e[name=THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "]"));
					entity.getPersistentData().putBoolean("part_create_true", false);
					entity.getPersistentData().putString("step", "create");
					break;
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute as @e[name=THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "] at @s run tp @s ~ ~ ~ " + entity.getPersistentData().getDouble("part_create3") + " ~"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute as @e[name=THT-tree_part_create_" + entity.getPersistentData().getString("tree_id") + "] at @s run tp @s ~ ~ ~ ~ " + entity.getPersistentData().getDouble("part_create4")));
			break;
		}
	}
}
