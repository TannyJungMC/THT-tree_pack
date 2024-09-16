package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class AutoGenStartCountProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		ThtModVariables.MapVariables.get(world).auto_gen_count = DoubleArgumentType.getDouble(arguments, "loop");
		ThtModVariables.MapVariables.get(world).syncData(world);
		AutoGenStartProcedure.execute(world, x, y, z);
	}
}
