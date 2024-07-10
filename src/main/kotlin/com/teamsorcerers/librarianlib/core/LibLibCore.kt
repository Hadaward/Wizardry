package com.teamsorcerers.librarianlib.core

import com.teamsorcerers.librarianlib.LibLibModule
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.DedicatedServerModInitializer
import net.fabricmc.api.ModInitializer

internal object LibLibCore : LibLibModule("liblib-core", "Core") {
    object CommonInitializer : ModInitializer {
        private val logger = LibLibCore.makeLogger<CommonInitializer>()

        override fun onInitialize() {
        }
    }

    object ClientInitializer : ClientModInitializer {
        private val logger = LibLibCore.makeLogger<ClientInitializer>()

        override fun onInitializeClient() {
        }
    }

    object ServerInitializer : DedicatedServerModInitializer {
        private val logger = LibLibCore.makeLogger<ServerInitializer>()

        override fun onInitializeServer() {
        }
    }
}