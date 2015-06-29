package com.github.leomagis.magis.entity.renderer;

import com.github.leomagis.magis.model.ModelFusionStation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderFusionStation extends TileEntitySpecialRenderer{
    private static final ModelFusionStation model = new ModelFusionStation();
    @Override
    public void renderTileEntityAt(TileEntity p_180535_1_, double p_180535_2_, double p_180535_4_, double p_180535_6_, float p_180535_8_, int p_180535_9_) {
        model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    }
}
