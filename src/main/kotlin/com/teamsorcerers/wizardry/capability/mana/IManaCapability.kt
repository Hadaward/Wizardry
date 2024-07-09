package com.teamsorcerers.wizardry.capability.mana

import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent

interface IManaCapability : AutoSyncedComponent {
    var mana: Double
    var maxMana: Double
}