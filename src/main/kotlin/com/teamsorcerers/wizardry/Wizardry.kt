package com.teamsorcerers.wizardry

import com.teamsorcerers.wizardry.common.init.ModBlocks
import com.teamsorcerers.wizardry.common.init.ModCapabilities
import com.teamsorcerers.wizardry.common.init.ModFluids
import com.teamsorcerers.wizardry.common.init.ModItems
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.damage.DamageType
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.World
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Wizardry {
	companion object {
		private const val MOD_ID = "wizardry"
		val logger: Logger = LoggerFactory.getLogger(MOD_ID)

		fun getID(path: String): Identifier {
			return Identifier.of(MOD_ID, path)
		}

		fun getDamageSource(world: World, key: RegistryKey<DamageType>): DamageSource {
			return DamageSource(world.registryManager.get(RegistryKeys.DAMAGE_TYPE).entryOf(key))
		}
	}

	object CommonInitializer : ModInitializer {
		override fun onInitialize() {
			logger.info("IT'S LEVI-OH-SA, NOT LEVIOSAA")

			// Inicializadores de classes
			ModBlocks.init()
			ModItems.init()
			ModFluids.init()

			/*

			ModInventoryTabs.init()*/
		}
	}

	object ClientInitializer : ClientModInitializer {
		override fun onInitializeClient() {
			//TODO("Not yet implemented")
		}

	}
}