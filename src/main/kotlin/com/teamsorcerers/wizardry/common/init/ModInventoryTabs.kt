package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.text.Text

object ModInventoryTabs {
    private val general  = FabricItemGroup
        .builder()
        .displayName(Text.translatable(Wizardry.getID("itemgroup.general")
            .toString()))

    fun init(){

    }

}