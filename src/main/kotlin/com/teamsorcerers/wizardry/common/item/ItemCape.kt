package com.teamsorcerers.wizardry.common.item

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class ItemCape(settings:Settings?) : Item(settings){
    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        return  TypedActionResult.success(user?.getStackInHand(hand));
    }
}