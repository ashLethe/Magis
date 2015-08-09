package com.github.leomagis.magis.gui;

import com.github.leomagis.magis.container.ContainerElementalCentrifuge;
import com.github.leomagis.magis.entity.tile.client.TileElementalCentrifugeClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GUIElementalCentrifuge extends GuiContainer {
	public static final int GUIID = 1;

	private static final ResourceLocation guiTextureLoc = new
			ResourceLocation("magis:textures/gui/GUIElementalCentrifuge.png");

	public GUIElementalCentrifuge (TileElementalCentrifugeClient tileEntity, EntityPlayer player) {
		super(new ContainerElementalCentrifuge(player, tileEntity));

		xSize = 256;
		ySize = 347;
	}


	@Override
	protected void drawGuiContainerBackgroundLayer (float partialTicks, int mouseX, int mouseY) {
		Minecraft.getMinecraft().renderEngine.bindTexture(guiTextureLoc);
		GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		worldRenderer.startDrawingQuads();
		worldRenderer.addVertexWithUV(guiLeft, guiTop, zLevel, 0.0, 0.0);
		worldRenderer.addVertexWithUV(guiLeft, guiTop+347, zLevel, 0.0, 0.677734375);
		worldRenderer.addVertexWithUV(guiLeft+256, guiTop+347, zLevel, 0.5, 0.677734375);
		worldRenderer.addVertexWithUV(guiLeft + 256, guiTop, zLevel, 0.5, 0.0);
		tessellator.draw();

	}
}
