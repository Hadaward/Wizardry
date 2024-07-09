package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import com.teamsorcerers.wizardry.capability.mana.ManaCapability
import com.teamsorcerers.wizardry.capability.spell.SpellCapability
import com.teamsorcerers.wizardry.common.block.IManaNode
import com.teamsorcerers.wizardry.common.block.entity.craftingplate.BlockCraftingPlateEntity
import com.teamsorcerers.wizardry.common.block.entity.manabattery.BlockManaBatteryEntity
import org.ladysnake.cca.api.v3.block.BlockComponentFactoryRegistry
import org.ladysnake.cca.api.v3.block.BlockComponentInitializer
import org.ladysnake.cca.api.v3.component.ComponentKey
import org.ladysnake.cca.api.v3.component.ComponentRegistryV3
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy
import org.ladysnake.cca.api.v3.item.ItemComponentInitializer
import net.minecraft.fluid.Fluid
import org.ladysnake.cca.api.v3.item.ItemComponentMigrationRegistry

object ModCapabilities : EntityComponentInitializer, BlockComponentInitializer, ItemComponentInitializer {
    val MANA: ComponentKey<ManaCapability> = ComponentRegistryV3.INSTANCE.getOrCreate(Wizardry.getID("mana"), ManaCapability::class.java)
    val SPELL: ComponentKey<SpellCapability> = ComponentRegistryV3.INSTANCE.getOrCreate(Wizardry.getID("spell"), SpellCapability::class.java)

    override fun registerEntityComponentFactories(registry: EntityComponentFactoryRegistry) {
        registry.registerForPlayers(MANA, { ManaCapability() }, RespawnCopyStrategy.ALWAYS_COPY)
    }

    override fun registerBlockComponentFactories(registry: BlockComponentFactoryRegistry) {
        registry.registerFor(BlockManaBatteryEntity::class.java, MANA) {ManaCapability()}
        registry.registerFor(BlockCraftingPlateEntity::class.java, MANA) {ManaCapability()}
    }

    override fun registerItemComponentMigrations(registry: ItemComponentMigrationRegistry) {
        TODO("Not yet implemented")
    }
}