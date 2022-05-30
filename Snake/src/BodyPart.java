import java.awt.*;

class BodyPart
{
    private int bodyXPos, bodyYPos, height, width;

    BodyPart(int xPos, int yPos, int tileSize)
    {
        bodyXPos = xPos;
        bodyYPos = yPos;
        height = tileSize;
        width = tileSize;
    }

    void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(bodyXPos * width + 1, bodyYPos * height + 1, width + 1, height + 1);    // Outline
        g.setColor(Color.GREEN);
        g.fillRect(bodyXPos * width + 2, bodyYPos * height + 2, width - 2, height - 2);    // Snake.
    }

    int getBodyXPos()
    {
        return bodyXPos;
    }

    int getBodyYPos()
    {
        return bodyYPos;
    }
}
