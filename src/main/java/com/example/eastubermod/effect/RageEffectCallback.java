package com.example.eastubermod.effect;


import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface RageEffectCallback {
    Event<RageEffectCallback> EVENT = EventFactory.createArrayBacked(RageEffectCallback.class,
            (listeners) -> (player) -> {
                for (RageEffectCallback listener : listeners){
                    ActionResult result = listener.interact(player);

                    if (result != ActionResult.PASS){
                        return result;
                    }
                }
                return ActionResult.PASS;
            });
    ActionResult interact(PlayerEntity player);
}
