import java.awt.*;
import java.util.Random;

public class Food
{
    private int foodXPos, foodYPos, width, height;
    Random random = new Random();

    Food(int xPos, int yPos, int tileSize)
    {
        foodXPos = xPos;
        foodYPos = yPos;
        width = tileSize;
        height = tileSize;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(foodXPos * width, foodYPos * height, width, height);
    }

    public int getFoodXPos()
    {
        return foodXPos;
    }

    public int getFoodYPos()
    {
        return foodYPos;
    }
}
