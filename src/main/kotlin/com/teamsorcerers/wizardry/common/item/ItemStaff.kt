package com.teamsorcerers.wizardry.common.item

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class ItemStaff (settings:Settings?):Item(settings){
    override fun use(world: World, user:PlayerEntity , hand: Hand):TypedActionResult<ItemStack>{
        user.playSound(SoundEvents.BLOCK_WOOD_HIT,  1.0f, 1.0f)
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}