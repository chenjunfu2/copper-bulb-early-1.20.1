package com.chenjunfu2.sounds;

import net.minecraft.sound.BlockSoundGroup;

public class ModBlockSoundGroup
{
	public static final BlockSoundGroup COPPER_BULB = new BlockSoundGroup(
		1.0F,
		1.0F,
		ModSoundEvents.BLOCK_COPPER_BULB_BREAK,
		ModSoundEvents.BLOCK_COPPER_BULB_STEP,
		ModSoundEvents.BLOCK_COPPER_BULB_PLACE,
		ModSoundEvents.BLOCK_COPPER_BULB_HIT,
		ModSoundEvents.BLOCK_COPPER_BULB_FALL
	);
	
	public static void registerBlockSoundGroup() {}
}
