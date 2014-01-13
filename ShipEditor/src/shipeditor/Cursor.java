package shipeditor;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Cursor
{
	public float x, y;
	private Image texture;
	public Cursor()
	{
		x = 63;
		y = 63;
	}
	
	public void init(Image icon)
	{
		texture = icon;
	}
	public void moveLeft(int amt)
	{
		if(x > 63)
		{
			x -= (amt * 96);
		}
	}
	public void moveRight(float amt)
	{
		if(x < (96 * 6))
		{
			x += (amt * 96);
		}
	}
	public void moveUp(float amt)
	{
		if(y > (63))
		{
			y -= (amt * 96);
		}
	}
	public void moveDown(float amt)
	{
		if(y < (96 * 6))
		{
			y += (amt * 96);
		}
	}
	public void draw(Graphics g)
	{
		texture.draw(x, y, 1.f);
	}
}