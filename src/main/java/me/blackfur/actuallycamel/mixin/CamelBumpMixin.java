package me.blackfur.actuallycamel.mixin;

import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.render.entity.model.CamelEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CamelEntityModel.class)
public class CamelBumpMixin {
    @Redirect(method = "getTexturedModelData", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/ModelPartBuilder;cuboid(FFFFFF)Lnet/minecraft/client/model/ModelPartBuilder;", ordinal = 1))
    private static ModelPartBuilder redirect_addChildHump(ModelPartBuilder instance, float offsetX, float offsetY, float offsetZ, float sizeX, float sizeY, float sizeZ) {
        instance.cuboid(offsetX, offsetY, offsetZ + 8.5F, sizeX, sizeY, sizeZ - 3.0F);
        instance.cuboid(offsetX, offsetY, offsetZ - 5.5F, sizeX, sizeY, sizeZ - 3.0F);
        return instance;
    }
}
