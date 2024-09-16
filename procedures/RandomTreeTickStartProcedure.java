package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;

public class RandomTreeTickStartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		if (true) {
			entity.getPersistentData().putString("tree_id", entity.getUUID().toString());
			entity.getPersistentData().putString("type", "taproot");
			if ((entity.getPersistentData().getString("name")).equals("")) {
				entity.getPersistentData().putString("name", "unnamed");
			}
			if (true) {
				if (true) {
					entity.getPersistentData().putDouble("taproot_length_min", Math.ceil(entity.getPersistentData().getDouble("taproot_length_min") * ThtModVariables.MapVariables.get(world).rt_roots * 0.01));
					entity.getPersistentData().putDouble("taproot_length_max", Math.ceil(entity.getPersistentData().getDouble("taproot_length_max") * ThtModVariables.MapVariables.get(world).rt_roots * 0.01));
					entity.getPersistentData().putDouble("secondary_root_length_min", Math.ceil(entity.getPersistentData().getDouble("secondary_root_length_min") * ThtModVariables.MapVariables.get(world).rt_roots * 0.01));
					entity.getPersistentData().putDouble("secondary_root_length_max", Math.ceil(entity.getPersistentData().getDouble("secondary_root_length_max") * ThtModVariables.MapVariables.get(world).rt_roots * 0.01));
					entity.getPersistentData().putDouble("tertiary_root_length_min", Math.ceil(entity.getPersistentData().getDouble("tertiary_root_length_min") * ThtModVariables.MapVariables.get(world).rt_roots * 0.01));
					entity.getPersistentData().putDouble("tertiary_root_length_max", Math.ceil(entity.getPersistentData().getDouble("tertiary_root_length_max") * ThtModVariables.MapVariables.get(world).rt_roots * 0.01));
					entity.getPersistentData().putDouble("fine_root_length_min", Math.ceil(entity.getPersistentData().getDouble("fine_root_length_min") * ThtModVariables.MapVariables.get(world).rt_roots * 0.01));
					entity.getPersistentData().putDouble("fine_root_length_max", Math.ceil(entity.getPersistentData().getDouble("fine_root_length_max") * ThtModVariables.MapVariables.get(world).rt_roots * 0.01));
				}
				if (true) {
					if (true) {
						entity.getPersistentData().putDouble("taproot_thickness_min", (entity.getPersistentData().getDouble("taproot_thickness_min") - 1));
						entity.getPersistentData().putDouble("taproot_thickness_max", (entity.getPersistentData().getDouble("taproot_thickness_max") - 1));
						entity.getPersistentData().putDouble("secondary_root_thickness_min", (entity.getPersistentData().getDouble("secondary_root_thickness_min") - 1));
						entity.getPersistentData().putDouble("secondary_root_thickness_max", (entity.getPersistentData().getDouble("secondary_root_thickness_max") - 1));
						entity.getPersistentData().putDouble("tertiary_root_thickness_min", (entity.getPersistentData().getDouble("tertiary_root_thickness_min") - 1));
						entity.getPersistentData().putDouble("tertiary_root_thickness_max", (entity.getPersistentData().getDouble("tertiary_root_thickness_max") - 1));
						entity.getPersistentData().putDouble("fine_root_thickness_min", (entity.getPersistentData().getDouble("fine_root_thickness_min") - 1));
						entity.getPersistentData().putDouble("fine_root_thickness_max", (entity.getPersistentData().getDouble("fine_root_thickness_max") - 1));
					}
					if (true) {
						entity.getPersistentData().putDouble("trunk_thickness_min", (entity.getPersistentData().getDouble("trunk_thickness_min") - 1));
						entity.getPersistentData().putDouble("trunk_thickness_max", (entity.getPersistentData().getDouble("trunk_thickness_max") - 1));
						entity.getPersistentData().putDouble("branch_thickness_min", (entity.getPersistentData().getDouble("branch_thickness_min") - 1));
						entity.getPersistentData().putDouble("branch_thickness_max", (entity.getPersistentData().getDouble("branch_thickness_max") - 1));
						entity.getPersistentData().putDouble("twig_thickness_min", (entity.getPersistentData().getDouble("twig_thickness_min") - 1));
						entity.getPersistentData().putDouble("twig_thickness_max", (entity.getPersistentData().getDouble("twig_thickness_max") - 1));
						entity.getPersistentData().putDouble("leaves_twig_thickness_min", (entity.getPersistentData().getDouble("leaves_twig_thickness_min") - 1));
						entity.getPersistentData().putDouble("leaves_twig_thickness_max", (entity.getPersistentData().getDouble("leaves_twig_thickness_max") - 1));
					}
				}
			}
			if (entity.getPersistentData().getBoolean("no_roots") == true) {
				entity.getPersistentData().putDouble("taproot_count", 0);
			} else {
				entity.getPersistentData().putDouble("taproot_count", (Mth.nextInt(RandomSource.create(), (int) entity.getPersistentData().getDouble("taproot_count_min"), (int) entity.getPersistentData().getDouble("taproot_count_max"))));
			}
			entity.getPersistentData().putDouble("trunk_count", (Mth.nextInt(RandomSource.create(), (int) entity.getPersistentData().getDouble("trunk_count_min"), (int) entity.getPersistentData().getDouble("trunk_count_max"))));
			if (entity.getPersistentData().getDouble("taproot_count") > 0) {
				entity.getPersistentData().putString("step", "summon");
			} else {
				entity.getPersistentData().putString("step", "previous");
				RandomTreeTickStepPreviousProcedure.execute(world, x, y, z, entity);
			}
			if (entity.getPersistentData().getBoolean("debug_mode") == true) {
				if (true) {
					if (true) {
						entity.getPersistentData().putString("taproot_outer", "red_stained_glass");
						entity.getPersistentData().putString("taproot_inner", "red_stained_glass");
						entity.getPersistentData().putString("taproot_core", "red_stained_glass");
					}
					if (true) {
						entity.getPersistentData().putString("secondary_root_outer", "orange_stained_glass");
						entity.getPersistentData().putString("secondary_root_inner", "orange_stained_glass");
						entity.getPersistentData().putString("secondary_root_core", "orange_stained_glass");
					}
					if (true) {
						entity.getPersistentData().putString("tertiary_root_outer", "yellow_stained_glass");
						entity.getPersistentData().putString("tertiary_root_inner", "yellow_stained_glass");
						entity.getPersistentData().putString("tertiary_root_core", "yellow_stained_glass");
					}
					if (true) {
						entity.getPersistentData().putString("fine_root_outer", "green_stained_glass");
						entity.getPersistentData().putString("fine_root_inner", "green_stained_glass");
						entity.getPersistentData().putString("fine_root_core", "green_stained_glass");
					}
					if (true) {
						entity.getPersistentData().putString("trunk_outer", "red_concrete");
						entity.getPersistentData().putString("trunk_inner", "red_concrete");
						entity.getPersistentData().putString("trunk_core", "red_concrete");
					}
					if (true) {
						entity.getPersistentData().putString("branch_outer", "orange_concrete");
						entity.getPersistentData().putString("branch_inner", "orange_concrete");
						entity.getPersistentData().putString("branch_core", "orange_concrete");
					}
					if (true) {
						entity.getPersistentData().putString("twig_outer", "yellow_concrete");
						entity.getPersistentData().putString("twig_inner", "yellow_concrete");
						entity.getPersistentData().putString("twig_core", "yellow_concrete");
					}
					if (true) {
						entity.getPersistentData().putString("leaves_twig_outer", "green_concrete");
						entity.getPersistentData().putString("leaves_twig_inner", "green_concrete");
						entity.getPersistentData().putString("leaves_twig_core", "green_concrete");
					}
					if (true) {
						entity.getPersistentData().putString("leaves", "green_stained_glass");
						entity.getPersistentData().putString("leaves2", "lime_stained_glass");
					}
				}
			}
		}
		if (true) {
			entity.getPersistentData().putDouble("status_step_min",
					Math.floor(entity.getPersistentData().getDouble("taproot_count_min") * entity.getPersistentData().getDouble("secondary_root_count_min") * entity.getPersistentData().getDouble("tertiary_root_count_min")
							* entity.getPersistentData().getDouble("fine_root_count_min")
							+ entity.getPersistentData().getDouble("trunk_count_min") * entity.getPersistentData().getDouble("branch_count_min") * entity.getPersistentData().getDouble("twig_count_min")
									* entity.getPersistentData().getDouble("leaves_count_min")));
			entity.getPersistentData().putDouble("status_step_max",
					Math.floor(entity.getPersistentData().getDouble("taproot_count_max") * entity.getPersistentData().getDouble("secondary_root_count_max") * entity.getPersistentData().getDouble("tertiary_root_count_max")
							* entity.getPersistentData().getDouble("fine_root_count_max")
							+ entity.getPersistentData().getDouble("trunk_count_max") * entity.getPersistentData().getDouble("branch_count_max") * entity.getPersistentData().getDouble("twig_count_max")
									* entity.getPersistentData().getDouble("leaves_count_max")));
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands()
							.performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level.getServer(), _ent),
									"summon armor_stand ~ ~ ~ {Tags:[\"THT\",\"THT-random_tree\",\"THT-tree_status\"],NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,CustomNameVisible:1b,CustomName:'{\"text\":\"\"}'}");
				}
			}
		}
		if (ThtModVariables.MapVariables.get(world).auto_gen == true) {
			AutoGenWhenTreeStartProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("start_function_chance") > Math.random()) {
			if (ThtModVariables.MapVariables.get(world).auto_gen == false) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), (entity.getPersistentData().getString("start_function")));
					}
				}
			} else {
				file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/generated"), File.separator + (entity.getPersistentData().getString("file_name")));
				try {
					FileWriter filewriter = new FileWriter(file);
					BufferedWriter filebw = new BufferedWriter(filewriter);
					{
						filebw.write("+fs");
						filebw.newLine();
					}
					filebw.close();
					filewriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
