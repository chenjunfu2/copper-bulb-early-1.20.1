package com.chenjunfu2.mixin;

import com.chenjunfu2.block.CopperBulbBlocks;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.Oxidizable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;

import java.util.function.Supplier;

@Mixin(Oxidizable.class)
interface OxidizableMixin
{
//	@Redirect(
//		method = "method_34740",
//		at = @At(
//			value = "INVOKE",
//			target = "Lcom/google/common/collect/ImmutableBiMap$Builder;build()Lcom/google/common/collect/ImmutableBiMap;"
//		),
//		remap = false
//	)
//	private static ImmutableBiMap<Block, Block> OXIDATION_LEVEL_INCREASES_Modify(ImmutableBiMap.Builder<Block, Block> builder)
//	{
//		builder
//			.put(CopperBulbBlocks.COPPER_BULB, CopperBulbBlocks.EXPOSED_COPPER_BULB)
//			.put(CopperBulbBlocks.EXPOSED_COPPER_BULB, CopperBulbBlocks.WEATHERED_COPPER_BULB)
//			.put(CopperBulbBlocks.WEATHERED_COPPER_BULB, CopperBulbBlocks.OXIDIZED_COPPER_BULB);
//
//		return builder.build();
//	}
	
	
	@Unique
	public Supplier<BiMap<Block, Block>> NEW_OXIDATION_LEVEL_INCREASES = Suppliers.memoize(
		() -> ImmutableBiMap.<Block, Block>builder()
			.put(CopperBulbBlocks.COPPER_BULB, CopperBulbBlocks.EXPOSED_COPPER_BULB)
			.put(CopperBulbBlocks.EXPOSED_COPPER_BULB, CopperBulbBlocks.WEATHERED_COPPER_BULB)
			.put(CopperBulbBlocks.WEATHERED_COPPER_BULB, CopperBulbBlocks.OXIDIZED_COPPER_BULB)
			.build()
		);
	
	
	@Unique
	public Supplier<BiMap<Block, Block>> NEW_OXIDATION_LEVEL_DECREASES = Suppliers.memoize(
		() -> (NEW_OXIDATION_LEVEL_INCREASES.get().inverse())
	);
	
	
	
	@WrapOperation(
		method = "getDecreasedOxidationBlock",
		at = @At(value = "INVOKE", target = "Lcom/google/common/collect/BiMap;get(Ljava/lang/Object;)Ljava/lang/Object;"),
		remap = false
	)
	private static Object getDecreasedOxidationBlockWrapOperation(BiMap instance, Object o, Operation<Object> original)
	{
		Block b = (Block)original.call(instance, o);
		if(b != null)
		{
			return b;
		}
		
		return NEW_OXIDATION_LEVEL_DECREASES.get().get(o);
	}
	
	@WrapOperation(
		method = "getIncreasedOxidationBlock",
		at = @At(value = "INVOKE", target = "Lcom/google/common/collect/BiMap;get(Ljava/lang/Object;)Ljava/lang/Object;"),
		remap = false
	)
	private static Object getIncreasedOxidationBlockWrapOperation(BiMap instance, Object o, Operation<Object> original)
	{
		Block b = (Block)original.call(instance, o);
		if(b != null)
		{
			return b;
		}
		
		return NEW_OXIDATION_LEVEL_DECREASES.get().get(o);
	}
	
	
	@WrapOperation(
		method = "getUnaffectedOxidationBlock",
		at = @At(value = "INVOKE", target = "Lcom/google/common/collect/BiMap;get(Ljava/lang/Object;)Ljava/lang/Object;"),
		remap = false
	)
	private static Object getUnaffectedOxidationBlockWrapOperation(BiMap instance, Object o, Operation<Object> original)
	{
		Block b = (Block)original.call(instance, o);
		if(b != null)
		{
			return b;
		}
		
		return NEW_OXIDATION_LEVEL_DECREASES.get().get(o);
	}
}