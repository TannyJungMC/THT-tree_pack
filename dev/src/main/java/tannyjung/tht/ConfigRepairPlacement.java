package tannyjung.tht;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import oshi.util.platform.mac.SysctlUtil;

public class ConfigRepairPlacement {

    

    // ----------------------------------------------------------------------------------------------------
    // Custom
    // ----------------------------------------------------------------------------------------------------

    

    static String file_directory = (FMLPaths.GAMEDIR.get().toString() + "/config/THT/config_placement.txt");      //      Set directory of txt and it name
    static String folder_scan = (FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom/tree_packs");      //      Set directory of folder to scanning



    // ----------------------------------------------------------------------------------------------------
    // Variables
    // ----------------------------------------------------------------------------------------------------

    

    static File directory;
    static File[] list_pack;
    static File[] list_theme;
    static File[] list_tree;

    static FileWriter filewriter;
    static BufferedWriter filebw;
    static BufferedReader fileReader;
    
    static String read_all = "";
    static String old_version = "";

    static int n = 0;
    static int pos = 0;
    static int pos2 = 0;
    static int step = 1;
    static String detect_text = "###";
    static String replace = "";
    static boolean repair = false;
    static String pack_name = "";
    static String theme_name = "";
    static String tree_name = "";
    static boolean lock = false;



    // ----------------------------------------------------------------------------------------------------
    // System Running
    // ----------------------------------------------------------------------------------------------------



    public static void main (LevelAccessor world, double x, double y, double z) throws Exception {



        file_create(world, x, y, z);
        old_version();
        clear(world, x, y, z);
        write(world, x, y, z);



    }

    

    // ----------------------------------------------------------------------------------------------------
    // Creating The File
    // ----------------------------------------------------------------------------------------------------



    private static void file_create (LevelAccessor world, double x, double y, double z) throws Exception {

        directory = new File(file_directory);

        if (directory.exists() == false) {

        	filewriter = new FileWriter(directory, false);
            filebw = new BufferedWriter(filewriter);

            filebw.close();
            filewriter.close();

            if (world instanceof ServerLevel _level) {
            	_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("execute if entity @e[type=player,distance=..0.01] run tellraw @a [{\"text\":\"THT : Repaired \",\"color\":\"yellow\"},{\"text\":\"config_placement.txt\",\"color\":\"white\"}]"));
			}
        
        }

    }
       


    // ----------------------------------------------------------------------------------------------------
    // Writing "old_version"
    // ----------------------------------------------------------------------------------------------------



    private static void old_version () throws Exception {

		old_version = "";

        directory = new File(file_directory);
        fileReader = new BufferedReader(new FileReader(directory));

        while ((read_all = fileReader.readLine()) != null) {

            old_version = (old_version + "$" + read_all);

        } fileReader.close();

    }

    

    // ----------------------------------------------------------------------------------------------------
    // Clear All
    // ----------------------------------------------------------------------------------------------------



    private static void clear (LevelAccessor world, double x, double y, double z) throws Exception {



        directory = new File(file_directory);
        filewriter = new FileWriter(directory, false);
		filebw = new BufferedWriter(filewriter);

            filebw.write("- This config auto apply the changes, so no need to stop the world.");
            filebw.newLine();
            filebw.write("- Repair missing values by run this command [ /THT config repair ] or restart the world");
            filebw.newLine();
            filebw.write("- If you change something in this config, you need to turn lock option to true to prevent it from replaced by new version.");
            filebw.newLine();
            filebw.write("- [biome] is biome that tree can spawn in. Supported multiple biome IDs and biome tags. For advance, [@all] for all biomes, [@vanilla] for vanilla biomes, add [!] for if-not, add [&] for compulsion (if it's not then cancel all).");
            filebw.newLine();
            filebw.write("- [ground_block] is block that tree can spawn on. Supported multiple block IDs and block tags. For advance, [@all] for all blocks, add [!] for if-not, add [&] for compulsion (if it's not then cancel all).");
            filebw.newLine();
            filebw.write("- [rarity] is the main option for set how common of trees. Only supported number between 0 to 100 Higher make it more common. Set to 0 to disable it.");
            filebw.newLine();
            filebw.write("- [min_distance] is the min distance in blocks between trees in the same species. Higher number make it more rare. Only work when the chunks around the other one is loading.");
            filebw.newLine();
            filebw.write("- [group_chance] is a chance for trees to spawn nearby other in the same species, work good with the trees that have low rarity. Only supported number between 0 to 1");
            filebw.newLine();
            filebw.write("- [dead_tree_chance] is a chance for trees to spawn as dead tree, no leaves and sometimes no twig or even become hollowed tree. Only supported number between 0 to 1");
            filebw.newLine();
            filebw.write("- [dead_tree_level_min] is max level of dead tree. Useful for some trees such as coconut tree that use branch part as leaves. Only supported number between 1 to 5");
            filebw.newLine();
            filebw.write("- [rotation] is where the trees randomly facing to. Set to number between 0 to 359 for manual rotation (mostly use in spikes). Set to 360 for random NWES rotation.");
            filebw.newLine();
            filebw.write("- [mirrored] is option to swap side of trees from left to right (mirror). Set to 1 or 2 for manual mirrored. Set to 0 for random mirrored.");
            filebw.newLine();
            filebw.newLine();
            filebw.write("----------------------------------------------------------------------------------------------------");
            filebw.newLine();

            
        filebw.close();
        filewriter.close();

    }



    // ----------------------------------------------------------------------------------------------------
    // Write Pack
    // ----------------------------------------------------------------------------------------------------



    private static void write (LevelAccessor world, double x, double y, double z) throws Exception {



        directory = new File(folder_scan);
        list_pack = directory.listFiles();

        if (list_pack != null) {for (int i_pack = 0; i_pack < list_pack.length;) {

            if (list_pack[i_pack].isDirectory()) {

                pack_name = list_pack[i_pack].getName();

                directory = new File(file_directory);
                filewriter = new FileWriter(directory, true);
                filebw = new BufferedWriter(filewriter);

                    filebw.newLine();
                    filebw.write(pack_name);
                    filebw.newLine();
                    filebw.newLine();
                    filebw.write("----------------------------------------------------------------------------------------------------");
                    filebw.newLine();

                filebw.close();
                filewriter.close();

                write_theme(world, x, y, z);

            }
        
            n = n+1;
            i_pack = i_pack+1;

        }}
    
    }



    // ----------------------------------------------------------------------------------------------------
    // Write theme Name
    // ----------------------------------------------------------------------------------------------------



    private static void write_theme (LevelAccessor world, double x, double y, double z) throws Exception {

        directory = new File(folder_scan + "/" + pack_name + "/world_gen");
        list_theme = directory.listFiles();

        if (list_theme != null) {for (int i_theme = 0; i_theme < list_theme.length;) {

            if (list_theme[i_theme].isDirectory()) {

                theme_name = list_theme[i_theme].getName();

                write_tree(world, x, y, z);

            }

            i_theme = i_theme+1;

        }}

    }



    // ----------------------------------------------------------------------------------------------------
    // Write Tree
    // ----------------------------------------------------------------------------------------------------



    private static void write_tree (LevelAccessor world, double x, double y, double z) throws Exception {

        directory = new File(folder_scan + "/" + pack_name + "/world_gen/" + theme_name);
        list_tree = directory.listFiles();

        if (list_tree != null) {for (int i_tree = 0; i_tree < list_tree.length;) {

            if (list_tree[i_tree].isFile() == true) {

                tree_name = list_tree[i_tree].getName().replace(".txt","");

                write_value(world, x, y, z);

            }

            i_tree = i_tree+1;

        }}

    }



    // ----------------------------------------------------------------------------------------------------
    // Text Detect Creating
    // ----------------------------------------------------------------------------------------------------



    private static void write_value (LevelAccessor world, double x, double y, double z) throws Exception {

        step = 1;
        detect_text = "###";
        repair = false;

        for (int loop = 0; loop < 15; loop++) {

            if (step == 1) {

                detect_text = pack_name + "  /  " + theme_name + "  >  " + tree_name + "        |        biome : ";
            
            } else if (step == 2) {

                detect_text = pack_name + "  /  " + theme_name + "  >  " + tree_name + "        |        ground_block : ";

            } else if (step == 3) {

                detect_text = pack_name + "  /  " + theme_name + "  >  " + tree_name + "        |        rarity : ";

            } else if (step == 4) {

                detect_text = pack_name + "  /  " + theme_name + "  >  " + tree_name + "        |        min_distance : ";

            } else if (step == 5) {

                detect_text = pack_name + "  /  " + theme_name + "  >  " + tree_name + "        |        group_chance : ";

            } else if (step == 6) {

                detect_text = pack_name + "  /  " + theme_name + "  >  " + tree_name + "        |        dead_tree_chance : ";

            } else if (step == 7) {

                detect_text = pack_name + "  /  " + theme_name + "  >  " + tree_name + "        |        dead_tree_level_min : ";

            } else if (step == 8) {

                detect_text = pack_name + "  /  " + theme_name + "  >  " + tree_name + "        |        rotation : ";

            } else if (step == 9) {

                detect_text = pack_name + "  /  " + theme_name + "  >  " + tree_name + "        |        mirrored : ";

            } else {

                if (repair == true) {

                    if (world instanceof ServerLevel _level) {
                    	_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",Component.literal(""), _level.getServer(), null).withSuppressedOutput(),("execute if entity @e[type=player,distance=..0.01] run tellraw @a [{\"text\":\"THT : Repaired \",\"color\":\"yellow\"},{\"text\":\"" + tree_name + " \",\"color\":\"white\"},{\"text\":\"[?]\",\"color\":\"dark_gray\",\"hoverEvent\":{\"action\":\"show_item\",\"contents\":{\"id\":\"minecraft:air\",\"count\":1,\"tag\":\"{display:{Name:'" + "\\" + "\"" + pack_name + " > " + theme_name + "\\" + "\"'}}\"}}}]"));
                    }
                    
                }

                directory = new File(file_directory);
                filewriter = new FileWriter(directory, true);
                filebw = new BufferedWriter(filewriter);

                    filebw.write("----------------------------------------------------------------------------------------------------");
                    filebw.newLine();
                    
                
                filebw.close();
                filewriter.close();

                break;

            }

            if (old_version.contains(detect_text) == true) {

                write_old_value(world, x, y, z);

            } else {

                write_default_value(world, x, y, z);

            }

            step = step + 1;

        }

    }



    // ----------------------------------------------------------------------------------------------------
    // Write Old Values
    // ----------------------------------------------------------------------------------------------------



    private static void write_old_value (LevelAccessor world, double x, double y, double z) throws Exception {

        pos = 0;
        pos2 = 0;

        for (int loop2 = 0; loop2 < old_version.length(); loop2++) {

            pos2 = pos2 + 1;

            if (old_version.substring(pos, pos2).contains("$") == true) {

                if (
                    old_version.substring(pos, pos2).contains("lock : ") == true &&
                    old_version.substring(pos, pos2).contains("block : ") == false
                    ) {

                    if (old_version.substring(pos, pos2).contains("lock : true") == true) {

                        lock = true;

                    } else {

						lock = false;

                	}

                } else if (old_version.substring(pos, pos2).contains(detect_text) == true) {

                    if (lock == true) {
                
                        directory = new File(file_directory);
                        filewriter = new FileWriter(directory, true);
                        filebw = new BufferedWriter(filewriter);

                            if (step == 1) {

                                filebw.write("lock : true");
                                filebw.newLine();
                                filebw.newLine();
            
                            }

                            filebw.write(old_version.substring(pos, pos2 - 1));
                            filebw.newLine();

                        filebw.close();
                        filewriter.close();

                    } else {

                        write_default_value(world, x, y, z);

                        repair = false;

                    }

                    break;

                }

                pos = pos2;

            }

        }

    }



    // ----------------------------------------------------------------------------------------------------
    // Writing Default Values
    // ----------------------------------------------------------------------------------------------------



    private static void write_default_value (LevelAccessor world, double x, double y, double z) throws Exception {

        directory = new File(folder_scan + "/" + pack_name + "/world_gen/" + theme_name + "/" + tree_name + ".txt");

        if (directory.exists() == true) {

            fileReader = new BufferedReader(new FileReader(directory));

            while ((read_all = fileReader.readLine()) != null) {

                replace = pack_name + "  /  " + theme_name + "  >  " + tree_name + "        |        ";

                if (read_all.contains(detect_text.replace(replace,""))) {

                    directory = new File(file_directory);
                    filewriter = new FileWriter(directory, true);
                    filebw = new BufferedWriter(filewriter);

                    	if (step == 1) {

                            filebw.write("lock : false");
                            filebw.newLine();
                            filebw.newLine();
        
                        }

                        filebw.write(replace + read_all);
                        filebw.newLine();
                        
                    filebw.close();
                    filewriter.close();

                    repair = true;

                    break;
                    
                }

            } fileReader.close();

        }

    }

}