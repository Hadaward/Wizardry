package com.teamsorcerers.wizardry.capability.spell

import com.teamsorcerers.librarianlib.scribe.Save
import com.teamsorcerers.wizardry.common.init.ModCapabilities
import com.teamsorcerers.wizardry.common.spell.component.ShapeChain
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.RegistryWrapper

class SpellCapability(val stack: ItemStack, @Save override var spell: ShapeChain? = null): ISpellCapability {
    companion object {
        var ItemStack.spell: ShapeChain?
            get() = ModCapabilities.SPELL.maybeGet(this).orElse(null)?.spell
            set(value) {
                ModCapabilities.SPELL.maybeGet(this).orElse(null)?.let {it.spell = value}
            }
    }

    override fun readFromNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
        TODO("Not yet implemented")
    }

    override fun writeToNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
        TODO("Not yet implemented")
    }
}
