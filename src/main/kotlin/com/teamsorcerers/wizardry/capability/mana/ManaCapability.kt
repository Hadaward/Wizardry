package com.teamsorcerers.wizardry.capability.mana

import com.teamsorcerers.librarianlib.scribe.Save
import com.teamsorcerers.wizardry.configs.ServerConfigs
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.RegistryWrapper

class ManaCapability(@Save override var mana: Double = 0.0, @Save override var maxMana: Double = ServerConfigs.crudeHaloMaxMana): IManaCapability {
    override fun readFromNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
    }

    override fun writeToNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
    }
}
