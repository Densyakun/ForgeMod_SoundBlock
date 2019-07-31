package io.github.densyakun.soundblock;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SoundBlock.MODID, name = SoundBlock.NAME, version = SoundBlock.VERSION)
public class SoundBlock {
	public static final String MODID = "soundblock";
	public static final String NAME = "SoundBlock";
	public static final String VERSION = "1.0";

	private static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}
}
