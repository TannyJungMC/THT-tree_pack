package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

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

public class AutoGenStartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		String file_name = "";
		if (ThtModVariables.MapVariables.get(world).version_1192 == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @a [\"\",{\"text\":\"THT : Auto gen is not available on 1.19.2\",\"color\":\"red\"}]");
		} else {
			if (true) {
				file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom"), File.separator + "auto_gen.txt");
				if (file.exists() == true) {
					try {
						BufferedReader fileReader = new BufferedReader(new FileReader(file));
						String stringiterator = "";
						while ((stringiterator = fileReader.readLine()) != null) {
							if (stringiterator.contains("file_name : ") == true) {
								file_name = stringiterator.replace("file_name : ", "");
							}
						}
						fileReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if ((file_name).equals("") || (file_name).equals("unnamed")) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @a [\"\",{\"text\":\"THT : Auto gen is developer tool to generate a tree file from preset, it's not related to gameplay. For how to use please read in auto_gen.txt in the config folder.\",\"color\":\"gray\"}]");
				ThtModVariables.MapVariables.get(world).auto_gen_count = 0;
				ThtModVariables.MapVariables.get(world).syncData(world);
			} else {
				if (ThtModVariables.MapVariables.get(world).auto_gen_count > 0) {
					if (ThtModVariables.MapVariables.get(world).auto_gen == false) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"tellraw @a [\"\",{\"text\":\"THT : Auto gen now turned ON\",\"color\":\"gray\"}]");
						ThtModVariables.MapVariables.get(world).auto_gen = true;
						ThtModVariables.MapVariables.get(world).syncData(world);
						ThtModVariables.MapVariables.get(world).auto_gen_cooldown = 10;
						ThtModVariables.MapVariables.get(world).syncData(world);
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @a [\"\",{\"text\":\"THT : Auto gen will be continue generating\",\"color\":\"gray\"}]");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @a [\"\",{\"text\":\"THT : Auto gen set loop to " + "" + (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).auto_gen_count)).replace(".0", "") + "\",\"color\":\"gray\"}]"));
			}
		}
	}
}
