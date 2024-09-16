package tannyjung.tht.procedures;

import tannyjung.tht.ThtMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.HashMap;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class PresetFixerGUIbuttonConvertProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		File file = new File("");
		double pos = 0;
		double pos2 = 0;
		String all = "";
		String fix = "";
		String name = "";
		boolean start = false;
		all = guistate.containsKey("textin:preset") ? (String) guistate.get("textin:preset") : "";
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/THT-tree_pack-main/dev"), File.separator + "preset_template.txt");
		if (file.exists()) {
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String stringiterator = "";
				while ((stringiterator = fileReader.readLine()) != null) {
					if (!(stringiterator.startsWith(",") && stringiterator.contains(":")) || (stringiterator).equals("")) {
						fix = fix + "" + stringiterator + "+";
					} else {
						pos2 = 0;
						for (int index0 = 0; index0 < (int) (stringiterator).length(); index0++) {
							if (!(stringiterator.substring(0, (int) pos2)).contains(":")) {
								pos2 = pos2 + 1;
							} else {
								name = stringiterator.substring(0, (int) pos2);
								break;
							}
						}
						if (!all.contains(name)) {
							fix = fix + "" + stringiterator + "+";
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level.getServer(), _ent),
											("execute if entity @e[type=player,distance=..0.01] run tellraw @a [\"\",{\"text\":\"THT : Repaired \",\"color\":\"yellow\"},{\"text\":\"" + "" + name.substring(1, (int) ((name).length() - 1))
													+ "\",\"color\":\"white\"}]"));
								}
							}
						} else {
							pos = 0;
							pos2 = 0;
							for (int index1 = 0; index1 < (int) (all).length(); index1++) {
								if (!(all.substring((int) pos, (int) pos2)).contains(name)) {
									pos2 = pos2 + 1;
								} else {
									pos = pos2 - (name).length();
									break;
								}
							}
							for (int index2 = 0; index2 < (int) (all).length(); index2++) {
								if (!((all.substring((int) pos, (int) pos2)).endsWith(",") || (all.substring((int) pos, (int) pos2)).endsWith("}"))) {
									pos2 = pos2 + 1;
								} else {
									break;
								}
							}
							fix = fix + "" + all.substring((int) pos, (int) (pos2 - 1)) + "+";
						}
					}
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (entity instanceof ServerPlayer _player && !world.isClientSide())
			ThtMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> _player), new ThtMod.TextboxSetMessage("preset", fix));
	}
}
