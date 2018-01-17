package com.redsponge.dodge.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.redsponge.dodge.Handler;

public class AssetsHandler {
	
	public static BufferedImage getImage(Handler handler, String path) {
		try {
			return ImageIO.read(AssetsHandler.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
