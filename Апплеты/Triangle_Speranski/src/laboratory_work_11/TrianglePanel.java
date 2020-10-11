package laboratory_work_11;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;

class TrianglePanel extends JPanel {

    int level = 2;
    int width;
    int height;
    Timer timer;
    BufferedImage canvas;
    JLabel label;

    public static void main(String[] agrs) {
        TrianglePanel panel = new TrianglePanel();
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.add(panel);
        frame.pack();

        frame.setVisible(true);

    }

    public TrianglePanel() {
        final int width = 400;
        final int height = 400;
        canvas = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        label = new JLabel(new ImageIcon(canvas));
        add( label );
        final Graphics2D g = canvas.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.RED);

        final ArrayList<Line> queue = new ArrayList<Line>();

        queue.add(new Line(new Point(width / 2, 0), new Point(0, height)));
        queue.add(new Line(new Point(0, height), new Point(width, height)));
        queue.add(new Line(new Point(width, height), new Point(width / 2, 0)));

        drawLine(queue.get(0),g);
        drawLine(queue.get(1),g);
        drawLine(queue.get(2),g);

        ActionListener al = new ActionListener() {
            int counter = 0;

            public void actionPerformed(ActionEvent ae) {
                if (level > 6) {
                    timer.stop();
                    return;
                }

                Line[] toDraw = queue.get(0).getTriangleToDraw(level, width, height);

                Point[] toDrawPoints = toDraw[0].getPoints();

                if (Math.sqrt(((Math.pow(toDrawPoints[1].x - toDrawPoints[0].x, 2)) + (Math.pow(toDrawPoints[1].y - toDrawPoints[0].y, 2)))) <= 4) {
                    System.out.println("breakyo");
                    return;
                }

                drawLine(toDraw[0],g);
                drawLine(toDraw[1],g);
                drawLine(toDraw[2],g);

                queue.remove(0);

                queue.add(toDraw[0]);
                queue.add(toDraw[1]);
                queue.add(toDraw[2]);

                counter++;


                if (counter - Math.pow(3, level - 1) == 0) {
                    counter = 0;
                    level++;
                }
                label.repaint();
            }
        };
        timer = new Timer(200,al);
        timer.start();
    }

    private void drawLine(Line line, Graphics g) {
        g.drawLine(line.getPoints()[0].x, line.getPoints()[0].y, line.getPoints()[1].x, line.getPoints()[1].y);
    }
}

class Line {

    private Point endpoint1;
    private Point endpoint2;
    private Point midpoint;
    private double slope;

    public Line(Point endpoint1, Point endpoint2) {
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;

        midpoint = new Point((endpoint1.x + endpoint2.x) / 2, (endpoint1.y + endpoint2.y) / 2);
        slope = (double) (endpoint2.y - endpoint1.y) / (double) (endpoint2.x - endpoint1.x);

    }

    public Point[] getPoints() {
        return new Point[] { endpoint1, endpoint2 };
    }

    public Line[] getTriangleToDraw(int level, int width, int height) {

        Line[] lines = new Line[3];

        if (slope > 0) {
            Point left = new Point(midpoint.x - (width / (int)(Math.pow(2, level - 1))), midpoint.y);
            Point middle = new Point(midpoint.x - (width / (int)(Math.pow(2, level))), midpoint.y + (height / (int)(Math.pow(2, level - 1))));

            lines[0] = new Line(midpoint, left);
            lines[1] = new Line(midpoint, middle);
            lines[2] = new Line(middle, left);
        }

        else if (slope < 0) {
            Point right = new Point(midpoint.x + (width / (int)(Math.pow(2, level - 1))), midpoint.y);
            Point middle = new Point(midpoint.x + (width / (int)(Math.pow(2, level))), midpoint.y + (height / (int)(Math.pow(2, level - 1))));

            lines[0] = new Line(midpoint, right);
            lines[1] = new Line(midpoint, middle);
            lines[2] = new Line(middle, right);
        }

        else {
            Point left = new Point(midpoint.x - (width / (int)(Math.pow(2, level))), midpoint.y - (height / (int)(Math.pow(2, level - 1))));
            Point right = new Point(midpoint.x + (width / (int)(Math.pow(2, level))), midpoint.y - (height / (int)(Math.pow(2, level - 1))));

            lines[0] = new Line(midpoint, left);
            lines[1] = new Line(midpoint, right);
            lines[2] = new Line(left, right);
        }

        return lines;
    }
}