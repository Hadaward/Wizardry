package com.teamsorcerers.wizardry.capability.spell

/*
import com.teamsorcerers.librarianlib.scribe.Save
import com.teamsorcerers.wizardry.common.init.ModCapabilities
import com.teamsorcerers.wizardry.common.spell.component.ShapeChain
import org.ladysnake.cca.api.v3.item.ItemComponent
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound

class SpellCapability(val stack: ItemStack, @Save override var spell: ShapeChain? = null): ISpellCapability, ItemComponent(stack, ModCapabilities.SPELL) {
    companion object {
        var ItemStack.spell: ShapeChain?
            get() = ModCapabilities.SPELL.maybeGet(this).orElse(null)?.spell
            set(value) {
                ModCapabilities.SPELL.maybeGet(this).orElse(null)?.let {it.spell = value}
            }
    }
}
*/
