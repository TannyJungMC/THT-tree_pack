package tannyjung.tht;

import net.minecraftforge.fml.loading.FMLPaths;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import tannyjung.tht.network.ThtModVariables;

public class UpdateRun {
    
    @SuppressWarnings("resource")

    public static void main(LevelAccessor world, double x, double y, double z) throws IOException, InterruptedException {
		
			

		// ----------------------------------------------------------------------------------------------------
		// Custom
		// ----------------------------------------------------------------------------------------------------

		

		String delete_directory = FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/THT-tree_pack-main";

		String my_zip = FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/THT-tree_pack-main.zip";
		String download_to = FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/THT-tree_pack-main.zip";
		String unzip = FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/THT-tree_pack-main.zip";
		String unzip_to = FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs";

		File rename_from = new File(FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/THT-tree_pack-" + ThtModVariables.MapVariables.get(world).tanny_pack_version); 
		File rename_from2 = new File(FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/THT-tree_pack-wip");
		File rename_to = new File(FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/THT-tree_pack-main");
		
		String download_url = "";

		if (ThtModVariables.MapVariables.get(world).tanny_pack_wip == false) {
			
			download_url = "https://github.com/TannyJungMC/THT-tree_pack/archive/refs/heads/" + ThtModVariables.MapVariables.get(world).tanny_pack_version + ".zip";
			
		} else {
			
			download_url = "https://github.com/TannyJungMC/THT-tree_pack/archive/refs/heads/wip.zip";
			
		}



		// ----------------------------------------------------------------------------------------------------
		// Variables
		// ----------------------------------------------------------------------------------------------------

		


		Path delete;
		byte[] buffer;
		FileOutputStream fos;

		ZipInputStream zis;
		ZipEntry zipEntry;
		ZipOutputStream out;

		File newFile;
		File parent;
		File unzip_to2 = new File(unzip_to);
		File zip;

		int len;
		@SuppressWarnings("unused")
		boolean flag;





	

		// ----------------------------------------------------------------------------------------------------
		// Checking Mod version
		// ----------------------------------------------------------------------------------------------------
	
	
		String url = "";
		String version_directory = FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs/THT-tree_pack-main/version.txt";

		if (ThtModVariables.MapVariables.get(world).tanny_pack_wip == false) {
			url = "https://raw.githubusercontent.com/TannyJungMC/THT-tree_pack/" + ThtModVariables.MapVariables.get(world).tanny_pack_version + "/version.txt";
		} else {
			url = "https://raw.githubusercontent.com/TannyJungMC/THT-tree_pack/wip/version.txt";		
		}
	
		URL url_convert;
		File file = new File(version_directory);
		BufferedReader reader;
		BufferedReader fileReader;
		String mod_version = ThtModVariables.MapVariables.get(world).mod_version;
		String url_mod_version = "";
		String check_mod_version_read_all = "";



		try {
	
			url_convert = new URI(url).toURL();
			reader = new BufferedReader(new InputStreamReader(url_convert.openStream()));
	
			while ((check_mod_version_read_all = reader.readLine()) != null) {
				
				if (check_mod_version_read_all.contains("mod_version : ")) {
					
					url_mod_version = check_mod_version_read_all.replace("mod_version : ", "");
					
				}
	
			} reader.close();

		} catch (Exception e) {
		
			System.out.println("THT : Error To Checking Mod Version");
		
		}

		if (mod_version.equals(url_mod_version) == false) {
	
			if (world instanceof ServerLevel _level) {
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("tellraw @a [{\"text\":\"THT : You're currently using mod version that does not support to latest tree pack, please update the mod.\",\"color\":\"red\"}]"));
			}
			
		} else {

			if (world instanceof ServerLevel _level) {
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("tellraw @a [{\"text\":\" \"}]"));
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("tellraw @a [{\"text\":\"THT : Started auto download and install, it may take a while.\",\"color\":\"gray\"}]"));
			}

	
			
			// ----------------------------------------------------------------------------------------------------
			// Delete Old "THT-tree_pack-main" Folder
			// ----------------------------------------------------------------------------------------------------
	
			
	
			delete = Paths.get(delete_directory);
		
			if (new File(delete_directory).exists() == true) {
	
				Files.walk(delete).sorted(Comparator.reverseOrder()).forEach(path -> {
	
					try {
	
						Files.delete(path);
	
					} catch (IOException e) {

						if (world instanceof ServerLevel _level) {
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("tellraw @a [{\"text\":\"THT : Error to deleting old folder\",\"color\":\"red\"}]"));
						}

					}
					
				});
	
				System.out.println("THT : Deleted Old Folder");
				
			}
	
	
	
			// ----------------------------------------------------------------------------------------------------
			// Creating ZIP
			// ----------------------------------------------------------------------------------------------------
	
	
	
			zip = new File(my_zip);
			out = new ZipOutputStream(new FileOutputStream(zip));
			out.close();
	
	
	
			// ----------------------------------------------------------------------------------------------------
			// Download & Status
			// ----------------------------------------------------------------------------------------------------



			try {
			
				url_convert = new URI(download_url).toURL();
				BufferedInputStream read_all = new BufferedInputStream(url_convert.openStream());
				try (FileOutputStream fileOutputStream = new FileOutputStream(download_to)) {
		
					byte dataBuffer[] = new byte[1024];
					int bytesRead;
		
					while ((bytesRead = read_all.read(dataBuffer, 0, 1024)) != -1) {
		
						fileOutputStream.write(dataBuffer, 0, bytesRead);
		
					}
		
				}

			} catch (Exception e) {
		
				if (world instanceof ServerLevel _level) {
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("tellraw @a [{\"text\":\"THT : No internet connection!\",\"color\":\"red\"}]"));
				}
		
			}
	
	
	
			// ----------------------------------------------------------------------------------------------------
			// Unzipping
			// ----------------------------------------------------------------------------------------------------
	
	

			buffer = new byte[1024];
			zis = new ZipInputStream(new FileInputStream(unzip));
			zipEntry = zis.getNextEntry();
	
			if (new File(unzip).exists() == true) {
	
				while (zipEntry != null) {
				
					newFile = newFile(unzip_to2, zipEntry);
	
					if (zipEntry.isDirectory()) {
	
						if (!newFile.isDirectory() && !newFile.mkdirs()) {
	
							throw new IOException("THT : Failed to create directory " + newFile);
	
						}
	
					} else {
	
						// fix for Windows-created 
						
						parent = newFile.getParentFile();
	
						if (!parent.isDirectory() && !parent.mkdirs()) {
	
							throw new IOException("THT : Failed to create directory " + parent);
	
						}
	
						// write file content
	
						fos = new FileOutputStream(newFile);
	
						while ((len = zis.read(buffer)) > 0) {
	
							fos.write(buffer, 0, len);
	
						} fos.close();
	
					}
					
					zipEntry = zis.getNextEntry();
	
				} zis.closeEntry(); zis.close();
	
				System.out.println("THT : Unzipped");
	
			}
	
	
	
			// ----------------------------------------------------------------------------------------------------
			// Deleting ZIP
			// ----------------------------------------------------------------------------------------------------
	
	
	
			delete = Paths.get(delete_directory + ".zip");
	
			if (new File(delete_directory + ".zip").exists() == true) {
	
				Files.walk(delete).sorted(Comparator.reverseOrder()).forEach(path -> {
	
					try {
	
						Files.delete(path);
	
					} catch (IOException e) {
						
						System.out.println("THT : Error to deleting ZIP");
	
					}
					
				});
	
				System.out.println("THT : Deleted : " + delete_directory + ".zip");
				
			}
	
	
	
			// ----------------------------------------------------------------------------------------------------
			// Rename File
			// ----------------------------------------------------------------------------------------------------
	
	
	
			flag = rename_from.renameTo(rename_to);
			flag = rename_from2.renameTo(rename_to);
	
	
	
			// ----------------------------------------------------------------------------------------------------
			// End
			// ----------------------------------------------------------------------------------------------------
	
			
	
			if (world instanceof ServerLevel _level) {
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("THT config repair"));
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("THT config apply"));
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("tellraw @a [{\"text\":\"THT : Install Completed!\",\"color\":\"gray\"}]"));
			}

		}

	}

    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {



        // ----------------------------------------------------------------------------------------------------
        // Variables
        // ----------------------------------------------------------------------------------------------------



        File destFile;

        String destDirPath;
        String destFilePath;



        // ----------------------------------------------------------------------------------------------------
        // ???
        // ----------------------------------------------------------------------------------------------------



        destFile = new File(destinationDir, zipEntry.getName());
    
        destDirPath = destinationDir.getCanonicalPath();
        destFilePath = destFile.getCanonicalPath();
    
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            
            throw new IOException("Entry is outside of the target dir : " + zipEntry.getName());

        }
    
        return destFile;

    }

}