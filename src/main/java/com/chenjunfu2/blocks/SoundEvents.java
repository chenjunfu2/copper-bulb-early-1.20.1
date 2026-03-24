package com.chenjunfu2.blocks;

import com.chenjunfu2.CopperBulbEarly;
import com.chenjunfu2.sounds.BlockSoundGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundEvents
{
	public static final SoundEvent BLOCK_COPPER_BULB_BREAK = register("block.copper_bulb.break");
	public static final SoundEvent BLOCK_COPPER_BULB_STEP = register("block.copper_bulb.step");
	public static final SoundEvent BLOCK_COPPER_BULB_PLACE = register("block.copper_bulb.place");
	public static final SoundEvent BLOCK_COPPER_BULB_HIT = register("block.copper_bulb.hit");
	public static final SoundEvent BLOCK_COPPER_BULB_FALL = register("block.copper_bulb.fall");
	public static final SoundEvent BLOCK_COPPER_BULB_TURN_ON = register("block.copper_bulb.turn_on");
	public static final SoundEvent BLOCK_COPPER_BULB_TURN_OFF = register("block.copper_bulb.turn_off");

    private static SoundEvent register(String name)
	{
        final Identifier id = new Identifier(CopperBulbEarly.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSoundEvents()
	{
		BlockSoundGroup.registerBlockSoundGroup();
	}
}
