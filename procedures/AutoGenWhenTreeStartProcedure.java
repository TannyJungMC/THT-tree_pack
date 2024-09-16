package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Calendar;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;

public class AutoGenWhenTreeStartProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		double loop = 0;
		double loop_next = 0;
		String keep = "";
		String type = "";
		String type_short = "";
		entity.getPersistentData().putString("file_name",
				((entity.getPersistentData().getString("name")).toLowerCase().replace(" ", "_") + "-" + new java.text.SimpleDateFormat("yyyyMMdd-HHmm-ss").format(Calendar.getInstance().getTime()) + " (generating).txt"));
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/generated"), File.separator + (entity.getPersistentData().getString("file_name")));
		if (!file.exists()) {
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
					filebw.write(("Started Generate : " + (new java.text.SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()) + " at " + new java.text.SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()))));
					filebw.newLine();
				}
				{
					filebw.write("");
					filebw.newLine();
				}
				if (true) {
					{
						filebw.write(("tree_type : " + entity.getPersistentData().getString("tree_type")));
						filebw.newLine();
					}
					{
						filebw.write(("start_height : " + ("" + entity.getPersistentData().getDouble("start_height")).replace(".0", "")));
						filebw.newLine();
					}
					{
						filebw.write(("rt_dynamic : " + entity.getPersistentData().getBoolean("rt_dynamic")));
						filebw.newLine();
					}
					{
						filebw.write(("can_disable_roots : " + entity.getPersistentData().getBoolean("can_disable_roots")));
						filebw.newLine();
					}
				}
				{
					filebw.write("");
					filebw.newLine();
				}
				if (true) {
					loop = 1;
					for (int index0 = 0; index0 < 100; index0++) {
						loop_next = 1;
						if (true) {
							if (true) {
								if (true) {
									if (loop == loop_next) {
										type = "taproot";
										type_short = "ta";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										type = "secondary_root";
										type_short = "se";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										type = "tertiary_root";
										type_short = "te";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										type = "fine_root";
										type_short = "fi";
									}
									loop_next = loop_next + 1;
								}
							}
							if (true) {
								if (true) {
									if (loop == loop_next) {
										type = "trunk";
										type_short = "tr";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										type = "branch";
										type_short = "br";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										type = "twig";
										type_short = "tw";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										type = "leaves_twig";
										type_short = "lt";
									}
									loop_next = loop_next + 1;
								}
								if (true) {
									if (loop == loop_next) {
										type = "leaves";
										type_short = "le";
									}
									loop_next = loop_next + 1;
								}
							}
						}
						if (loop != loop_next) {
							loop = loop + 1;
							if (!(type).equals("leaves")) {
								if (true) {
									if (!(entity.getPersistentData().getString("leaves")).equals("") && entity.getPersistentData().getBoolean((type + "_replace")) == true) {
										keep = "";
									} else {
										keep = " replace #tht:passable_blocks";
									}
									{
										filebw.write((("@" + type_short + "o = ") + "" + entity.getPersistentData().getString((type + "_outer")) + keep));
										filebw.newLine();
									}
									{
										filebw.write((("@" + type_short + "i = ") + "" + entity.getPersistentData().getString((type + "_inner")) + keep));
										filebw.newLine();
									}
									{
										filebw.write((("@" + type_short + "c = ") + "" + entity.getPersistentData().getString((type + "_core")) + keep));
										filebw.newLine();
									}
									entity.getPersistentData().putString((type + "_outer_short"), ("@" + type_short + "o"));
									entity.getPersistentData().putString((type + "_inner_short"), ("@" + type_short + "i"));
									entity.getPersistentData().putString((type + "_core_short"), ("@" + type_short + "c"));
								}
							} else {
								if (true) {
									if (!(entity.getPersistentData().getString("leaves")).equals("") && entity.getPersistentData().getBoolean((type + "_replace")) == true) {
										keep = "";
									} else {
										keep = " keep";
									}
									{
										filebw.write((("@" + type_short + "1 = ") + "" + entity.getPersistentData().getString("leaves") + keep));
										filebw.newLine();
									}
									{
										filebw.write((("@" + type_short + "2 = ") + "" + entity.getPersistentData().getString("leaves2") + keep));
										filebw.newLine();
									}
									entity.getPersistentData().putString("leaves_short", ("@" + type_short + "1"));
									entity.getPersistentData().putString("leaves2_short", ("@" + type_short + "2"));
								}
							}
						} else {
							break;
						}
					}
				}
				{
					filebw.write("");
					filebw.newLine();
				}
				if (true) {
					{
						filebw.write(("+fs" + " = " + entity.getPersistentData().getString("start_function")));
						filebw.newLine();
					}
					{
						filebw.write(("+fe" + " = " + entity.getPersistentData().getString("end_function")));
						filebw.newLine();
					}
					{
						filebw.write(("+fw1" + " = " + entity.getPersistentData().getString("way1_function")));
						filebw.newLine();
					}
					{
						filebw.write(("+fw2" + " = " + entity.getPersistentData().getString("way2_function")));
						filebw.newLine();
					}
					{
						filebw.write(("+fw3" + " = " + entity.getPersistentData().getString("way3_function")));
						filebw.newLine();
					}
				}
				{
					filebw.write("");
					filebw.newLine();
				}
				{
					filebw.write("--------------------------------------------------");
					filebw.newLine();
				}
				{
					filebw.write("");
					filebw.newLine();
				}
				{
					filebw.write("+s^0^0^0@tro");
					filebw.newLine();
				}
				filebw.close();
				filewriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			if (ThtModVariables.MapVariables.get(world).auto_gen_chat_messages == true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @a [\"\",{\"text\":\"THT : Generating \",\"color\":\"aqua\"},{\"text\":\"" + "" + (entity.getPersistentData().getString("file_name")).replace(" (generating)", "") + "\",\"color\":\"white\"}]"));
			}
		}
	}
}
