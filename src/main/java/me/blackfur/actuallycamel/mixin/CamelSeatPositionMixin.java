package me.blackfur.actuallycamel.mixin;

import net.minecraft.entity.passive.CamelEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CamelEntity.class)
public class CamelSeatPositionMixin {
    @ModifyArg(method = "updatePassengerPosition",  at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;<init>(DDD)V"), index = 2)
    public double redirect_camelSeatPosition(double z) {
        if (z == 0.5) {
            return 0.7;
        } else if (z <= -0.6) {
            return 0.0;
        }
        return z;
    }
}
