package tannyjung.tht.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class TxtFunctionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		File file = new File("");
		boolean merge_true = false;
		boolean start = false;
		String merge_text = "";
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/" + (new Object() {
			public String getMessage() {
				try {
					return MessageArgument.getMessage(arguments, "folder").getString();
				} catch (CommandSyntaxException ignored) {
					return "";
				}
			}
		}).getMessage()), File.separator + (StringArgumentType.getString(arguments, "file") + ".txt"));
		if (file.exists()) {
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String stringiterator = "";
				while ((stringiterator = fileReader.readLine()) != null) {
					if (start == false) {
						if (stringiterator.contains("merge_all : true")) {
							merge_true = true;
						}
						if (stringiterator.contains("--------------------------------------------------")) {
							start = true;
						}
					} else {
						if (merge_true == true) {
							merge_text = merge_text + "" + stringiterator;
						} else {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										stringiterator);
						}
					}
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (merge_true == true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), merge_text);
			}
		}
	}
}
