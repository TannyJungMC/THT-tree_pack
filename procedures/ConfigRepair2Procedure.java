package tannyjung.tht.procedures;

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
import java.io.File;
import java.io.BufferedWriter;

public class ConfigRepair2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		if (true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs"), File.separator + "");
			if (file.exists() == false) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		if (true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/generated"), File.separator + "");
			if (file.exists() == false) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		if (true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom"), File.separator + "auto_gen.txt");
			if (file.exists() == false) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				try {
					FileWriter filewriter = new FileWriter(file);
					BufferedWriter filebw = new BufferedWriter(filewriter);
					{
						filebw.write("- This is developer tool to generate a tree file from preset, it will use my void dimension to generate trees so it not affect to normal world.");
						filebw.newLine();
					}
					{
						filebw.write("- First you need file name and directory of it, putting it and then use command [ /THT auto_gen start <loop> ]");
						filebw.newLine();
					}
					{
						filebw.write("- Warning! this dimension highest Y is 400 so be careful about world height/lower cut the trees. You can change posY option for the position of tree.");
						filebw.newLine();
					}
					{
						filebw.write("- Also please don't close the world while generating trees, it may cause double trees generate at the same place, which can make the file go wrong.");
						filebw.newLine();
					}
					{
						filebw.write("");
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
					{
						filebw.write("file_name : unnamed");
						filebw.newLine();
					}
					{
						filebw.write("directory : config/THT/custom/tree_packs/THT-tree_pack-main/presets/unnamed");
						filebw.newLine();
					}
					{
						filebw.write("");
						filebw.newLine();
					}
					{
						filebw.write("generate_speed : 1");
						filebw.newLine();
					}
					{
						filebw.write("generate_speed_repeat : 1000");
						filebw.newLine();
					}
					{
						filebw.write("");
						filebw.newLine();
					}
					{
						filebw.write("posY : 150");
						filebw.newLine();
					}
					{
						filebw.write("chat_message : true");
						filebw.newLine();
					}
					filebw.close();
					filewriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute if entity @e[type=player,distance=..0.01] run tellraw @a [\"\",{\"text\":\"THT : Repaired \",\"color\":\"yellow\"},{\"text\":\"" + "auto_gen.txt" + "\",\"color\":\"white\"}]"));
			}
		}
	}
}
