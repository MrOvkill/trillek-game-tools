package shipeditor;

import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;
import java.io.*;

public class ShipEditor extends BasicGame
{
	public ShipEditor(String title) {
		super(title);
	}

	private ImageHandler handler;
	public static String sep;
	private Cursor cursor;
	private int[] images;
	private ArrayList<Vector2f> positions;	
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		sep = System.getProperty("file.separator");
		handler = new ImageHandler();
		handler.add("resources" + sep + "textures" + sep + "Chat.png");
		handler.add("resources" + sep + "textures" + sep + "Cursor.png");
		handler.add("resources" + sep + "textures" + sep + "Panel.png");
		cursor = new Cursor();
		cursor.init(handler.get(1));
		
		positions = new ArrayList<Vector2f>();
		for(int x = 0; x < 7; x++)
		{
			for(int y = 0; y < 7; y++)
			{
				positions.add(new Vector2f(((x * 96) + 63), ((y * 96) + 63)));
			}
		}
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException
	{
		if (gc.getInput().isKeyDown(Keyboard.KEY_ESCAPE))
		{
			gc.exit();
			Sound.kill();
			System.exit(0);
		}
		if(gc.getInput().isKeyPressed(Keyboard.KEY_W))
		{
			cursor.moveUp(1);
		}
		if(gc.getInput().isKeyPressed(Keyboard.KEY_A))
		{
			cursor.moveLeft(1);
		}
		if(gc.getInput().isKeyPressed(Keyboard.KEY_S))
		{
			cursor.moveDown(1);
		}
		if(gc.getInput().isKeyPressed(Keyboard.KEY_D))
		{
			cursor.moveRight(1);
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.clear();
		handler.get(0).draw(15, 15);
		for(int i = 0; i < positions.size(); i++)
		{
			handler.get(2).draw(positions.get(i).x, positions.get(i).y);
		}
		cursor.draw(g);
		g.drawString("Ship Editor", 349, 45);
	}
}