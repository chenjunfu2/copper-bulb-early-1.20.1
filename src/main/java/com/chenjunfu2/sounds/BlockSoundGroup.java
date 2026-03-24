package com.chenjunfu2.sounds;

import com.chenjunfu2.blocks.SoundEvents;

public class BlockSoundGroup
{
	public static final net.minecraft.sound.BlockSoundGroup COPPER_BULB = new net.minecraft.sound.BlockSoundGroup(
		1.0F,
		1.0F,
		SoundEvents.BLOCK_COPPER_BULB_BREAK,
		SoundEvents.BLOCK_COPPER_BULB_STEP,
		SoundEvents.BLOCK_COPPER_BULB_PLACE,
		SoundEvents.BLOCK_COPPER_BULB_HIT,
		SoundEvents.BLOCK_COPPER_BULB_FALL
	);
	
	public static void registerBlockSoundGroup() {}
}
