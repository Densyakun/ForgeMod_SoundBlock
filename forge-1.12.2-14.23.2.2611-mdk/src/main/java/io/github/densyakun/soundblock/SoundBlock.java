package io.github.densyakun.soundblock;

import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = SoundBlock.MODID)
public class SoundBlock {

	public static final String MODID = "soundblock";

	private static Logger logger;

	public static Block soundBlock;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();

		soundBlock = new BlockSound().setUnlocalizedName("sound_block")
				.setRegistryName(new ResourceLocation(MODID, "sound_block"));

		ForgeRegistries.BLOCKS.register(soundBlock);
		ForgeRegistries.ITEMS.register(new ItemBlock(soundBlock).setRegistryName(soundBlock.getRegistryName()));

		if (event.getSide().isClient())
			registerModels();
	}

	@SideOnly(Side.CLIENT)
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(soundBlock), 0,
				new ModelResourceLocation(MODID + ":sound_block_item_model",
						"inventory"));
	}
}
