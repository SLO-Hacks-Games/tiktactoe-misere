import javax.swing.*;
import java.awt.*;

public class JPanelExt extends JPanel {
    int[][] marks;

    public JPanelExt() {
        super();
        setSize(300,300);
        repaint();
        marks = new int[3][3];
    }

    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        super.setBackground( Color.darkGray );
        int lines = marks.length;
        int size = getWidth()-20;
        g.setColor( Color.lightGray );
        for (int i=1; i<lines; i++) {
            g.drawLine(10,size/lines*i+10,size+10,size/lines*i+10);
            g.drawLine(size/lines*i+10,10,size/lines*i+10,size+10);
        }
        g.setColor( Color.red );
        for (int i=0; i<marks.length; i++) {
            for (int j=0; j<marks.length; j++) {
                if (marks[i][j] == 1) {
                    g.drawLine(size/lines*i+20,size/lines*j+20,size/lines*(i+1),size/lines*(j+1));
                    g.drawLine(size/lines*i+20,size/lines*(j+1),size/lines*(i+1),size/lines*j+20);
                }
            }
        }

    }

    public void setBoard( int[][] board ) {
        marks = board;
        int size = marks.length*100;
        setSize( size, size );
    }
}
