import javax.swing.*;
import java.awt.*;

public class MarchingSquares extends JPanel{

    float degree = (float) 0.5;
    int spacing = 10;
    int cols,rows;

    Graphics myG;

    public void setDegree(float degree) {
        this.degree = degree;
    }

    float [][] points;

    public MarchingSquares(int height, int width) {
        super();


        cols = width/spacing;
        rows = height/spacing;

        System.out.println(cols + rows);

        points = new float[cols][rows];

        for(int i = 0 ; i <cols;i++)
        {
            for(int j = 0; j < rows; j++)
            {
                points[i][j] = (float) Math.random();

            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        myG = g;
        draw(g);
        drawSquars(g);
    }

    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;
        for(int i = 0 ; i <cols;i++)
        {
            for(int j = 0; j < rows; j++)
            {
                int pointGrayScaleColor =  Math.round(points[i][j]*255) ;
                g2d.setColor(new Color(pointGrayScaleColor,pointGrayScaleColor,pointGrayScaleColor));
                g2d.fillOval(i*spacing,j*spacing,3,3);

            }
        }
    }

    public void drawSquars(Graphics g)
    {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.RED);
        for(int i = 0 ; i <cols - 1;i++)
        {
            for(int j = 0; j < rows - 1; j++)
            {
                int x = i * spacing;
                int y = j * spacing;

                Point a = new Point(x+spacing/2,y);
                Point b = new Point(x+spacing,y+spacing/2);
                Point c = new Point(x+spacing/2,y+spacing);
                Point d = new Point(x ,y+spacing/2);

                int weightCase = getSquareCase(points[i][j],points[i+1][j],points[i+1][j+1],points[i][j+1]);

                switch (weightCase){
                    case 0 :
                        break;
                    case 1 :
                        drawLine(c,d,graphics2D);
                        break;
                    case 2:
                        drawLine(b,c,graphics2D);
                        break;
                    case 3 :
                        drawLine(b,d,graphics2D);
                        break;
                    case 4 :
                        drawLine(a,b,graphics2D);
                        break;
                    case 5 :
                        drawLine(a,d,graphics2D);
                        drawLine(c,b,graphics2D);
                        break;
                    case 6 :
                        drawLine(a,c,graphics2D);
                        break;
                    case 7 :
                        drawLine(a,d,graphics2D);
                        break;
                    case 8 :
                        drawLine(a,d,graphics2D);
                        break;
                    case 9 :
                        drawLine(a,c,graphics2D);
                        break;
                    case 10 :
                        drawLine(a,b,graphics2D);
                        drawLine(c,d,graphics2D);
                        break;
                    case  11 :
                        drawLine(a,b,graphics2D);
                        break;
                    case 12 :
                        drawLine(d,b,graphics2D);
                        break;
                    case  13 :
                        drawLine(c,b,graphics2D);
                        break;
                    case 14 :
                        drawLine(d,c,graphics2D);
                        break;
                }




            }
        }

    }

    private void drawLine(Point p1,Point p2 ,Graphics2D g)
    {
        g.drawLine(p1.x,p1.y,p2.x,p2.y);
    }

    private int getSquareCase(float v, float v1, float v2, float v3) {
        int intCase = 0;

        if (v  > degree) { intCase += 8; }
        if (v1 > degree) { intCase += 4; }
        if (v2 > degree) { intCase += 2; }
        if (v3 > degree) { intCase += 1; }

        return intCase;
    }
}
