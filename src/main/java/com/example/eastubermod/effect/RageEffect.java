package com.example.eastubermod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.StyleSpriteSource;
import net.minecraft.util.math.Vec3d;


public class RageEffect extends StatusEffect {

    public RageEffect(StatusEffectCategory category, int color) {
        super(StatusEffectCategory.BENEFICIAL, 0xe9b8b3);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
//        if(entity instanceof PlayerEntity ){
//            if(PlayerEntity.MAX_HEALTH == 15){
//                entity.addStatusEffect() EntityAttributes.ATTACK_DAMAGE, 5f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL;
//                return true;
//            }
//        }
        if(entity.horizontalCollision) {
            Vec3d initialVec = entity.getVelocity();
            Vec3d climbVec = new Vec3d(initialVec.x, 0.2D, initialVec.z);
            entity.setVelocity(climbVec.multiply(0.96D));
            return true;
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
//        return super.canApplyUpdateEffect(duration, amplifier);
        return true;

    }



}
