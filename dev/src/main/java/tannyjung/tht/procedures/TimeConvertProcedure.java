package tannyjung.tht.procedures;

import net.minecraft.world.entity.Entity;

public class TimeConvertProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String second = "";
		String minute = "";
		String hour = "";
		double save = 0;
		double time_convert = 0;
		save = entity.getPersistentData().getDouble("time_convert");
		if (true) {
			if (true) {
				time_convert = save;
				time_convert = (time_convert / 60 - Math.floor(time_convert / 60)) * 60;
				if (time_convert < 10) {
					second = "0" + new java.text.DecimalFormat("##").format(time_convert);
				} else {
					second = "" + new java.text.DecimalFormat("##").format(time_convert);
				}
			}
			if (true) {
				time_convert = save;
				time_convert = time_convert / 60;
				if (time_convert < 10) {
					minute = "0" + new java.text.DecimalFormat("##").format(time_convert);
				} else {
					minute = "" + new java.text.DecimalFormat("##").format(time_convert);
				}
			}
			if (true) {
				time_convert = save;
				time_convert = time_convert / 3600;
				if (time_convert < 10) {
					hour = "0" + new java.text.DecimalFormat("##").format(time_convert);
				} else {
					hour = "" + new java.text.DecimalFormat("##").format(time_convert);
				}
			}
		}
		return (hour + "h " + minute + "m " + second + "s").replace(".0", "");
	}
}
