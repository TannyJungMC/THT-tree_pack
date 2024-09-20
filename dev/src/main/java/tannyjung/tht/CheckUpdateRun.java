package tannyjung.tht;

import net.minecraftforge.fml.loading.FMLPaths;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import tannyjung.tht.network.ThtModVariables;

public class CheckUpdateRun {

    public static void main(LevelAccessor world, double x, double y, double z) throws IOException {
    
        

        // ----------------------------------------------------------------------------------------------------
        // Custom
        // ----------------------------------------------------------------------------------------------------



		String url = "";
        String version_directory = FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/THT-tree_pack-main/version.txt";

		if (ThtModVariables.MapVariables.get(world).tanny_pack_wip == false) {
			
        	url = "https://raw.githubusercontent.com/TannyJungMC/THT-tree_pack/" + ThtModVariables.MapVariables.get(world).tanny_pack_version + "/version.txt";

		} else {

			url = "https://raw.githubusercontent.com/TannyJungMC/THT-tree_pack/wip/version.txt";
			
		}
		


        // ----------------------------------------------------------------------------------------------------
        // Variables
        // ----------------------------------------------------------------------------------------------------



        URL url_convert;
        File file = new File(version_directory);
        
        BufferedReader reader;

        String read_all = "";
        String pack_version = "";
        String url_pack_version = "";



        // ----------------------------------------------------------------------------------------------------
        // Reading Version
        // ----------------------------------------------------------------------------------------------------

        

        if (file.exists() == true) {

            reader = new BufferedReader(new FileReader(file));

            while ((read_all = reader.readLine()) != null) {
	
	            if (read_all.contains("pack_version : ")) {
	
					pack_version = read_all.replace("pack_version : ", "");
	
				}
	
	        } reader.close();



            // ----------------------------------------------------------------------------------------------------
	        // Reading URL
	        // ----------------------------------------------------------------------------------------------------
	
	
	
	        try {
	
	            url_convert = new URI(url).toURL();
	            reader = new BufferedReader(new InputStreamReader(url_convert.openStream()));
	
	            while ((read_all = reader.readLine()) != null) {

					if (read_all.contains("pack_version : ")) {

						url_pack_version = read_all.replace("pack_version : ", "");

					}

	            } reader.close();



				if (pack_version.equals(url_pack_version) == true) {
		
	                if (world instanceof ServerLevel _level) {
		            	_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("execute if entity @e[type=player,distance=..0.01] run tellraw @a [{\"text\":\"THT : TannyJung's Tree Pack is already up to date\",\"color\":\"green\"}]"));
					}
	
	            } else if (pack_version.equals(url_pack_version) == false) {

	            	System.out.println("Pack Version : " + url_pack_version);
					System.out.println("Your Pack Version : " + pack_version);
	
					if (ThtModVariables.MapVariables.get(world).auto_check_update == true && ThtModVariables.MapVariables.get(world).auto_update == true) {
	
						if (world instanceof ServerLevel _level) {
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("tellraw @a [{\"text\":\"THT : Detected new version for TannyJung's Tree Pack. Starting auto update...\",\"color\":\"gold\"}]"));
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("execute at @p run THT tanny_pack update"));
						}

					} else {

						if (world instanceof ServerLevel _level) {
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("tellraw @a [{\"text\":\"THT : Detected new version for TannyJung's Tree Pack. You can manual update by follow the guide in \",\"color\":\"gold\"},{\"text\":\"GitHub\",\"color\":\"white\",\"underlined\":\"true\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/TannyJungMC/THT-tree_pack\"},\"hoverEvent\":{\"action\":\"show_item\",\"contents\":{\"id\":\"minecraft:air\",\"count\":1,\"tag\":\"{display:{Name:'\\\"https://github.com/TannyJungMC/THT-tree_pack\\\"'}}\"}}},{\"text\":\" or click \",\"color\":\"gold\"},{\"text\":\"[here]\",\"color\":\"white\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/THT tanny_pack update\"}},{\"text\":\" to let the mod do it.\",\"color\":\"gold\"}]"));
						}

					}
	                
	            }
	            
	        } catch (Exception e) {
	            
	            if (world instanceof ServerLevel _level) {
	            	_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("execute if entity @e[type=player,distance=..0.01] run tellraw @a [{\"text\":\"THT : No internet connection!\",\"color\":\"red\"}]"));
				}
	
	        }

        } else {

			if (world instanceof ServerLevel _level) {
            	_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("tellraw @a [{\"text\":\"THT : Not detected TannyJung's Tree Pack in the config folder. You can manual download and install by follow the guide in \",\"color\":\"gold\"},{\"text\":\"GitHub\",\"color\":\"white\",\"underlined\":\"true\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/TannyJungMC/THT-tree_pack\"},\"hoverEvent\":{\"action\":\"show_item\",\"contents\":{\"id\":\"minecraft:air\",\"count\":1,\"tag\":\"{display:{Name:'\\\"https://github.com/TannyJungMC/THT-tree_pack\\\"'}}\"}}},{\"text\":\" or click \",\"color\":\"gold\"},{\"text\":\"[here]\",\"color\":\"white\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/THT tanny_pack update\"}},{\"text\":\" to let the mod do it.\",\"color\":\"gold\"}]"));
			}

        }

    }

}