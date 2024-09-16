package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class RandomTreeDynamicProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		boolean loop_finish = false;
		String folder = "";
		String file_name = "";
		String text_replace = "";
		String block = "";
		String pos = "";
		double loop = 0;
		double loop_next = 0;
		if (entity.getPersistentData().getBoolean("rt_dynamic") == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/" + entity.getPersistentData().getString("directory")), File.separator + (entity.getPersistentData().getString("file_name")));
			if (file.isFile() == true && file.exists() == true) {
				entity.getPersistentData().putDouble("process", 0);
				try {
					BufferedReader fileReader = new BufferedReader(new FileReader(file));
					String stringiterator = "";
					while ((stringiterator = fileReader.readLine()) != null) {
						if (ThtModVariables.MapVariables.get(world).rt_dynamic_process_limit == 0
								|| entity.getPersistentData().getDouble("process") < entity.getPersistentData().getDouble("line_count") && entity.getPersistentData().getDouble("process") >= entity.getPersistentData().getDouble("process_save")) {
							if (stringiterator.contains("@tr") || stringiterator.contains("@br") || stringiterator.contains("@tw") || stringiterator.contains("@lt") || stringiterator.contains("@le")) {
								if (true) {
									block = (entity.getPersistentData().getString((stringiterator.substring((int) ((stringiterator).length() - 3), (int) (stringiterator).length())))).replace(" keep", "");
									pos = ((stringiterator.substring(2, (int) ((stringiterator).length() - 4))).replace("^", " ^")).substring(1);
									if (entity.getPersistentData().getDouble("mirrored") == 2) {
										pos = "^-" + pos.substring(1);
										pos = pos.replace("^--", "^");
									}
								}
								if (!stringiterator.contains("@le")) {
									if (stringiterator.contains("+s^0^0^0@tro")) {
										{
											Entity _ent = entity;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
														("execute unless block ~ ~ ~ " + block + " run data merge entity @s {ForgeData:{dead_tree:true}}"));
											}
										}
									}
									entity.getPersistentData().putString("previous_block", (pos + " " + block));
								} else {
									if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
											.is(BlockTags.create(new ResourceLocation("tht:leaves_blocks"))) && block.contains("[persistent=true]")) {
										{
											Entity _ent = entity;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level.getServer(), _ent),
														("execute unless block " + entity.getPersistentData().getString("previous_block") + " if block " + (pos + " " + block) + " run setblock " + pos + " air destroy"));
											}
										}
										if (!("").equals("Leaves Regrow")) {
											if (entity.getPersistentData().getBoolean("dead_tree") == false && ((ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH)))
													.defaultBlockState().is(BlockTags.create(new ResourceLocation("tht:deciduous_leaves_blocks")))
													&& world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("tht:no_snow_biomes")))
													|| !(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
															.is(BlockTags.create(new ResourceLocation("tht:deciduous_leaves_blocks")))
															|| ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
																	.is(BlockTags.create(new ResourceLocation("tht:coniferous_leaves_blocks")))))
													&& ThtModVariables.MapVariables.get(world).leaves_regrow_summer_chance > Math.random()
													|| ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
															.is(BlockTags.create(new ResourceLocation("tht:coniferous_leaves_blocks"))) && ThtModVariables.MapVariables.get(world).leaves_regrow_chance_coniferous > Math.random()
													|| !world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("tht:no_snow_biomes")))
															&& ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
																	.is(BlockTags.create(new ResourceLocation("tht:deciduous_leaves_blocks")))
															&& ((ThtModVariables.MapVariables.get(world).season).equals("Spring") && ThtModVariables.MapVariables.get(world).leaves_regrow_spring_chance > Math.random()
																	|| (ThtModVariables.MapVariables.get(world).season).equals("Summer") && ThtModVariables.MapVariables.get(world).leaves_regrow_summer_chance > Math.random()
																	|| (ThtModVariables.MapVariables.get(world).season).equals("Autumn") && ThtModVariables.MapVariables.get(world).leaves_regrow_autumn_chance > Math.random()
																	|| (ThtModVariables.MapVariables.get(world).season).equals("Winter") && ThtModVariables.MapVariables.get(world).leaves_regrow_winter_chance > Math.random()))) {
												{
													Entity _ent = entity;
													if (!_ent.level.isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																		_ent.getDisplayName(), _ent.level.getServer(), _ent),
																("execute if block " + entity.getPersistentData().getString("previous_block") + " unless block " + (pos + " " + block) + " run setblock " + (pos + " " + block) + " keep"));
													}
												}
											}
										}
										if (!("").equals("Leaves Drop")) {
											if ((ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState().is(
													BlockTags.create(new ResourceLocation("tht:deciduous_leaves_blocks"))) && world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("tht:no_snow_biomes")))
													|| !(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
															.is(BlockTags.create(new ResourceLocation("tht:deciduous_leaves_blocks")))
															|| ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
																	.is(BlockTags.create(new ResourceLocation("tht:coniferous_leaves_blocks")))))
													&& ThtModVariables.MapVariables.get(world).leaves_drop_summer_chance > Math.random()
													|| ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
															.is(BlockTags.create(new ResourceLocation("tht:coniferous_leaves_blocks"))) && ThtModVariables.MapVariables.get(world).leaves_drop_chance_coniferous > Math.random()
															&& (ThtModVariables.MapVariables.get(world).season).equals("Summer")
													|| !world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("tht:no_snow_biomes")))
															&& ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((block.replace("[persistent=true]", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
																	.is(BlockTags.create(new ResourceLocation("tht:deciduous_leaves_blocks")))
															&& ((ThtModVariables.MapVariables.get(world).season).equals("Spring") && ThtModVariables.MapVariables.get(world).leaves_drop_spring_chance > Math.random()
																	|| (ThtModVariables.MapVariables.get(world).season).equals("Summer") && ThtModVariables.MapVariables.get(world).leaves_drop_summer_chance > Math.random()
																	|| (ThtModVariables.MapVariables.get(world).season).equals("Autumn") && ThtModVariables.MapVariables.get(world).leaves_drop_autumn_chance > Math.random()
																	|| (ThtModVariables.MapVariables.get(world).season).equals("Winter") && ThtModVariables.MapVariables.get(world).leaves_drop_winter_chance > Math.random())) {
												if (ThtModVariables.MapVariables.get(world).leaves_litter == true) {
													if (ThtModVariables.MapVariables.get(world).leaves_drop_animation_chance == 0) {
														if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
															{
																Entity _ent = entity;
																if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																			("execute positioned " + pos + " positioned over motion_blocking_no_leaves unless block ~ ~-1 ~ water run setblock ~ ~ ~ " + block + " keep"));
																}
															}
															{
																Entity _ent = entity;
																if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																			("execute positioned " + pos + " positioned over motion_blocking_no_leaves if block ~ ~-1 ~ water run setblock ~ ~-1 ~ "
																					+ block.replace("[persistent=true]", "[persistent=true,waterlogged=true]")));
																}
															}
														} else {
															{
																Entity _ent = entity;
																if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																			("execute positioned " + pos + " positioned over motion_blocking_no_leaves if loaded ~ ~ ~ unless block ~ ~-1 ~ water run setblock ~ ~ ~ " + block + " keep"));
																}
															}
															{
																Entity _ent = entity;
																if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																			("execute positioned " + pos + " positioned over motion_blocking_no_leaves if loaded ~ ~ ~ if block ~ ~-1 ~ water run setblock ~ ~-1 ~ "
																					+ block.replace("[persistent=true]", "[persistent=true,waterlogged=true]")));
																}
															}
														}
													} else if (ThtModVariables.MapVariables.get(world).leaves_drop_animation_chance > Math.random()) {
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	"scoreboard players set leaves_drop THT 0");
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	"execute at @e[name=THT-leaves_drop] run scoreboard players add leaves_drop THT 1");
														if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
															{
																Entity _ent = entity;
																if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																			(("execute positioned " + pos + " if score leaves_drop THT matches .."
																					+ (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).leaves_drop_animation_count_limit - 1)).replace(".0", "")
																					+ " unless block ~ ~-1 ~ #tht:leaves_blocks if block ~ ~ ~ " + block + " run ") + "scoreboard players add leaves_drop THT 1"));
																}
															}
															{
																Entity _ent = entity;
																if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																			(("execute positioned " + pos + " if score leaves_drop THT matches .."
																					+ (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).leaves_drop_animation_count_limit - 1)).replace(".0", "")
																					+ " unless block ~ ~-1 ~ #tht:leaves_blocks if block ~ ~ ~ " + block + " run ") + ""
																					+ "summon armor_stand ~ ~ ~ {CustomName:'{\"text\":\"THT-leaves_drop\"}',Invisible:1b,Marker:1b,ArmorItems:[{},{},{},{id:\"" + block.replace("[persistent=true]", "")
																					+ "\",Count:1b}],ForgeData:{block:\"" + block + "\"}}"));
																}
															}
														} else {
															{
																Entity _ent = entity;
																if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																			(("execute positioned " + pos + " if loaded ~ ~ ~ if score leaves_drop THT matches .."
																					+ (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).leaves_drop_animation_count_limit - 1)).replace(".0", "")
																					+ " unless block ~ ~-1 ~ #tht:leaves_blocks if block ~ ~ ~ " + block + " run ") + "scoreboard players add leaves_drop THT 1"));
																}
															}
															{
																Entity _ent = entity;
																if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																			(("execute positioned " + pos + " if loaded ~ ~ ~ if score leaves_drop THT matches .."
																					+ (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).leaves_drop_animation_count_limit - 1)).replace(".0", "")
																					+ " unless block ~ ~-1 ~ #tht:leaves_blocks if block ~ ~ ~ " + block + " run ") + ""
																					+ "summon armor_stand ~ ~ ~ {CustomName:'{\"text\":\"THT-leaves_drop\"}',Invisible:1b,Marker:1b,ArmorItems:[{},{},{},{id:\"" + block.replace("[persistent=true]", "")
																					+ "\",Count:1b}],ForgeData:{block:\"" + block + "\"}}"));
																}
															}
														}
													}
													{
														Entity _ent = entity;
														if (!_ent.level.isClientSide() && _ent.getServer() != null) {
															_ent.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																			_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																	("execute positioned " + pos + " if block ~ ~ ~ " + block + " unless block ~ ~-1 ~ #tht:leaves_blocks run setblock ~ ~ ~ air"));
														}
													}
												}
											}
										}
										if (!("").equals("Litter Remover")) {
											if (ThtModVariables.MapVariables.get(world).leaves_litter == true) {
												if (ThtModVariables.MapVariables.get(world).leaves_litter_remover_chance > Math.random()) {
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																"scoreboard players set leaves_litter_remover THT 0");
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																"execute at @e[name=THT-leaves_litter_remover] run scoreboard players add leaves_litter_remover THT 1");
													if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
														{
															Entity _ent = entity;
															if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																_ent.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																				_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																		(("execute positioned " + pos + " if score leaves_litter_remover THT matches .."
																				+ (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).leaves_litter_remover_count_limit - 1)).replace(".0", "") + " run ")
																				+ "scoreboard players add leaves_litter_remover THT 1"));
															}
														}
														{
															Entity _ent = entity;
															if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																_ent.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																				_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																		(("execute positioned " + pos + " if score leaves_litter_remover THT matches .."
																				+ (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).leaves_litter_remover_count_limit - 1)).replace(".0", "") + " run ") + ""
																				+ "summon armor_stand ~ ~ ~ {CustomName:'{\"text\":\"THT-leaves_litter_remover\"}',Invisible:1b,Marker:1b}"));
															}
														}
													} else {
														{
															Entity _ent = entity;
															if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																_ent.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																				_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																		(("execute positioned " + pos + " if loaded ~ ~ ~ if score leaves_litter_remover THT matches .."
																				+ (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).leaves_litter_remover_count_limit - 1)).replace(".0", "") + " run ")
																				+ "scoreboard players add leaves_litter_remover THT 1"));
															}
														}
														{
															Entity _ent = entity;
															if (!_ent.level.isClientSide() && _ent.getServer() != null) {
																_ent.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
																				_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
																		(("execute positioned " + pos + " if loaded ~ ~ ~ if score leaves_litter_remover THT matches .."
																				+ (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).leaves_litter_remover_count_limit - 1)).replace(".0", "") + " run ") + ""
																				+ "summon armor_stand ~ ~ ~ {CustomName:'{\"text\":\"THT-leaves_litter_remover\"}',Invisible:1b,Marker:1b}"));
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
						if (entity.getPersistentData().getDouble("process") > entity.getPersistentData().getDouble("process_save") + ThtModVariables.MapVariables.get(world).rt_dynamic_process_limit) {
							break;
						}
						entity.getPersistentData().putDouble("process", (entity.getPersistentData().getDouble("process") + 1));
					}
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (entity.getPersistentData().getDouble("process") < entity.getPersistentData().getDouble("line_count")) {
					entity.getPersistentData().putDouble("process_save", (entity.getPersistentData().getDouble("process")));
				} else {
					entity.getPersistentData().putDouble("process_save", 0);
				}
			} else {
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
