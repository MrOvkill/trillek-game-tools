package org.trillek.shipeditor;

import org.newdawn.slick.AppGameContainer;

import shipeditor.*;

public class Editor
{
	public static void main(String[] args)
	{
		try
		{	
			AppGameContainer appgc;
			appgc = new AppGameContainer(new ShipEditor("Trillek-ShipEditor"));
			appgc.setDisplayMode(800, 800, false);
			appgc.setShowFPS(false);
			appgc.setMaximumLogicUpdateInterval(60);
			appgc.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}