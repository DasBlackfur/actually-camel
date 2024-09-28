package me.blackfur.actuallycamel.mixin;

import net.minecraft.entity.passive.CamelEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CamelEntity.class)
public class CamelSeatPositionMixin {
    @ModifyArg(method = "getPassengerAttachmentPos",  at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;<init>(DDD)V"), index = 2)
    public double redirect_camelSeatPosition(double z) {
        if (z == 0.5F) {
            return 0.7F;
        } else if (z <= -0.6F) {
            return 0.0F;
        }
        return z;
    }
}
