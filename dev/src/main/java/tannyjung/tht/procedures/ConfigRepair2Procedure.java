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
import java.io.FileReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class ConfigRepair2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		boolean spacing = false;
		String set = "";
		String old_version = "";
		String name = "";
		String default_value = "";
		double loop = 0;
		double finding_text_position = 0;
		double finding_text_position2 = 0;
		double loop_next = 0;
		FileWriter filewriter;
		BufferedWriter filebw;
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
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute if entity @e[type=player,distance=..0.01] run tellraw @a [{\"text\":\"THT : Repaired \",\"color\":\"yellow\"},{\"text\":\"" + "auto_gen.txt" + "\",\"color\":\"white\"}]"));
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
							filebw.write("- Set the \"generate_speed_repeat\" higher than 100 is not recommended, since it can causes floating parts when gnerate in worldgen as a dead tree.");
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
				spacing = false;
				if (true) {
					if (true) {
						if (loop == loop_next) {
							name = "file_name";
							default_value = "unnamed";
						}
						loop_next = loop_next + 1;
					}
					if (true) {
						if (loop == loop_next) {
							name = "directory";
							default_value = "config/THT/custom/tree_packs/THT-tree_pack-main/presets/unnamed";
						}
						loop_next = loop_next + 1;
					}
					if (true) {
						if (loop == loop_next) {
							spacing = true;
						}
						loop_next = loop_next + 1;
					}
					if (true) {
						if (loop == loop_next) {
							name = "generate_speed";
							default_value = "" + 1;
						}
						loop_next = loop_next + 1;
					}
					if (true) {
						if (loop == loop_next) {
							name = "generate_speed_repeat";
							default_value = "" + 100;
						}
						loop_next = loop_next + 1;
					}
					if (true) {
						if (loop == loop_next) {
							spacing = true;
						}
						loop_next = loop_next + 1;
					}
					if (true) {
						if (loop == loop_next) {
							name = "posY";
							default_value = "" + 150;
						}
						loop_next = loop_next + 1;
					}
					if (true) {
						if (loop == loop_next) {
							name = "chat_message";
							default_value = "" + true;
						}
						loop_next = loop_next + 1;
					}
				}
				if (loop != loop_next) {
					loop = loop + 1;
					if (true) {
						try {
							filewriter = new FileWriter(file, true);
							filebw = new BufferedWriter(filewriter);
							if (spacing == false) {
								if (!old_version.contains(name + " : ")) {
									set = name + " : " + default_value;
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("execute if entity @e[type=player,distance=..0.01] run tellraw @a [\"\",{\"text\":\"THT : Repaired \",\"color\":\"yellow\"},{\"text\":\"" + "" + ("auto_gen.txt" + " > " + name)
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
							} else {
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
				} else {
					if (true) {
						try {
							filewriter = new FileWriter(file, true);
							filebw = new BufferedWriter(filewriter);
							if (true) {
								{
									filebw.write("");
									filebw.newLine();
								}
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
