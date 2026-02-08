package com.example.eastubermod.mixin;

import com.example.eastubermod.effect.RageEffect;
import com.example.eastubermod.effect.RageEffectCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RageEffect.class)
public class RageEffectMixin {
    private void onRage(final PlayerEntity player,final CallbackInfoReturnable<ActionResult> info){
        ActionResult result = RageEffectCallback.EVENT.invoker().interact(player);

        if (result == ActionResult.FAIL){
            info.setReturnValue(result);
        }
    }
}
