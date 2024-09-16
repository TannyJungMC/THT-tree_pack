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

public class AutoGenWhenTreeFinishProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		String rename_file = "";
		String time_used = "";
		if (true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/generated"), File.separator + (entity.getPersistentData().getString("file_name")));
			if (file.exists()) {
				try {
					FileWriter filewriter = new FileWriter(file);
					BufferedWriter filebw = new BufferedWriter(filewriter);
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
						filebw.write(("Completed Generate : " + (new java.text.SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()) + " at " + new java.text.SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()))));
						filebw.newLine();
					}
					filebw.close();
					filewriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		if (true) {
			rename_file = FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/generated/" + entity.getPersistentData().getString("file_name");
			File first_file = new File(rename_file);
			rename_file = (FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/generated/" + entity.getPersistentData().getString("file_name")).replace(" (generating)", "");
			File rename = new File(rename_file);
			boolean flag = first_file.renameTo(rename);
		}
		if (ThtModVariables.MapVariables.get(world).auto_gen_chat_messages == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @a [\"\",{\"text\":\"THT : Completed! \",\"color\":\"green\"},{\"text\":\"" + "" + (entity.getPersistentData().getString("file_name")).replace(" (generating)", "") + "\",\"color\":\"white\"}]"));
			if (true) {
				if (ThtModVariables.MapVariables.get(world).auto_gen_count == 1) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @a [\"\",{\"text\":\"THT : Auto gen will be stop after finish this one\",\"color\":\"gray\"}]");
				} else if (ThtModVariables.MapVariables.get(world).auto_gen_count > 1) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("tellraw @a [\"\",{\"text\":\"THT : Auto gen has " + "" + (new java.text.DecimalFormat("##.##").format(ThtModVariables.MapVariables.get(world).auto_gen_count)).replace(".0", "")
										+ " loops left\",\"color\":\"gray\"}]"));
				}
			}
		}
	}
}
