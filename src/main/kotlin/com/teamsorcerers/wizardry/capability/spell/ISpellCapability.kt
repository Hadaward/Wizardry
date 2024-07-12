package com.teamsorcerers.wizardry.capability.spell


import com.teamsorcerers.wizardry.common.init.ModCapabilities
import com.teamsorcerers.wizardry.common.spell.component.ShapeChain
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent
import net.minecraft.item.ItemStack

interface ISpellCapability : AutoSyncedComponent {
    var spell: ShapeChain?
}
