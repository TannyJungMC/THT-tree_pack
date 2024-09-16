package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraft.world.level.LevelAccessor;

public class RandomTreeDetectExistProcedure {
	public static void execute(LevelAccessor world) {
		ThtModVariables.MapVariables.get(world).detect_exist = true;
		ThtModVariables.MapVariables.get(world).syncData(world);
	}
}
