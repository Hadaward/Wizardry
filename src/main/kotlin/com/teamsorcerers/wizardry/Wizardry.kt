package com.teamsorcerers.wizardry

import com.teamsorcerers.wizardry.common.init.*
import com.teamsorcerers.librarianlib.core.util.ModLogManager
import com.teamsorcerers.librarianlib.glitter.ParticleSystemManager
import com.teamsorcerers.wizardry.client.particle.ModParticles
import com.teamsorcerers.wizardry.common.init.*
import com.teamsorcerers.wizardry.proxy.ClientProxy
import com.teamsorcerers.wizardry.proxy.IProxy
import com.teamsorcerers.wizardry.proxy.ServerProxy
import com.teamsorcerers.wizardry.common.init.ModTags
import com.teamwizardry.wizardry.client.particle.ModParticles
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry
import net.fabricmc.fabric.api.resource.ResourceManagerHelper
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.damage.DamageType
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.resource.ResourceManager
import net.minecraft.resource.ResourceType
import net.minecraft.util.Identifier
import net.minecraft.world.World
import java.util.function.Consumer

class Wizardry {
    companion object {
        const val MODID = "wizardry"
        val logManager = ModLogManager(MODID, "Wizardry")

        var PROXY: IProxy = ServerProxy()
            private set

        fun getDamageSource(world: World, key: RegistryKey<DamageType>): DamageSource {
            return DamageSource(world.registryManager.get(RegistryKeys.DAMAGE_TYPE).entryOf(key))
        }

        fun getID(path: String): Identifier { return Identifier.of(MODID, path) }
    }

    object CommonInitializer: ModInitializer {
        override fun onInitialize() {
            ModTags.init()
            ModFluids.init()
            ModItems.init()
            ModBlocks.init()
            ModSounds.init()
            ModPatterns.init()

            ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(ModPatterns.ModuleReloadListener)
        }
    }

    object ClientInitializer: ClientModInitializer {
        override fun onInitializeClient() {
            PROXY = ClientProxy()
            ModFluids.initClient()
            ModBlocks.initClient()
            ModItems.initClient()

            ParticleSystemManager.add(ModParticles.physicsGlitter)
            ModelLoadingRegistry.INSTANCE.registerModelProvider(ClientInitializer::registerModels)
        }

        private fun registerModels(rm: ResourceManager, consumer: Consumer<Identifier>) {
            consumer.accept(getID("block/mana_battery"))
            consumer.accept(getID("block/mana_crystal"))
            consumer.accept(getID("block/mana_crystal_ring"))
            consumer.accept(getID("block/mana_crystal_ring_outer"))
        }
    }
}