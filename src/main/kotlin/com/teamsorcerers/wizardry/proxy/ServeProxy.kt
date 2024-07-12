package com.teamsorcerers.wizardry.proxy

import com.teamsorcerers.wizardry.common.PhysicsGlitterBox
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand

class ServeProxy:IProxy {
      override fun  clientSetup() {}
     override fun registerHandlers() {
        //NOOP
    }

    override fun  setItemStackHandHandler(hand: Hand?, stack: ItemStack?) {
        //NOOP
    }

   override fun spawnPhysicsGlitter(box: PhysicsGlitterBox) {

    }

    //    @Override
    //    public void spawnKeyedParticle(KeyFramedGlitterBox box) {
    //
    //    }
    override fun openWorktableGui() {}
}
