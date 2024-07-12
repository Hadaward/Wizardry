package com.teamsorcerers.wizardry.common.spell.shape

import com.teamsorcerers.wizardry.common.init.ModSounds
import com.teamsorcerers.wizardry.common.init.ModSounds.playSound
import com.teamsorcerers.wizardry.common.spell.component.Instance
import com.teamsorcerers.wizardry.common.spell.component.Interactor
import com.teamsorcerers.wizardry.common.spell.component.PatternShape
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.world.World

class ShapeSelf : PatternShape() {
    override fun run(world: World, instance: Instance, target: Interactor) {
        playSound(world, instance.caster, target, ModSounds.SUBTLE_MAGIC_BOOK_GLINT)
        super.run(world, instance, target)
    }

    @Environment(EnvType.CLIENT)
    override fun runClient(world: World, instance: Instance, target: Interactor) {

    }
}