import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;

public class JFrameExt extends JFrame implements MouseListener {

    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel jpBar;
    private final JTextArea jtfText;
    private final JPanelExt jpeBoard = new JPanelExt();
    private Timer t;

    public JFrameExt() {
        super();
        setTitle( "TikTacToe Misère" );
        setSize(300,370);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        FlowLayout fl = new FlowLayout();
        JPanel jpMain = new JPanel();
        jpMain.setLayout( fl );
        jpMain.setBackground( Color.darkGray );
        setContentPane(jpMain);
        jpBar = new JPanel();
        jpBar.setPreferredSize( new Dimension(300,60));
        jpBar.setBackground( Color.darkGray );
        jpMain.add(jpBar);
        jtfText = new JTextArea();
        jtfText.setPreferredSize( new Dimension(290,50));
        jtfText.setBackground( Color.darkGray );
        jtfText.setEditable( false );
        jpBar.add(jtfText);
        jpeBoard.setPreferredSize( new Dimension(300,300));
        jpMain.add( jpeBoard );
//        Board board = new Board;
//        Player p1 = new Player( name );
//        Player p2 = new Player( name );
//        Player currentPlayer = P1

        jpeBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
//                int x = (int) e.getX() / board.getWidth();
//                int y = (int) e.getY() / board.getWidth();
//                board.trySet( x, y );
//                togglePlayer();
                jpeBoard.repaint();
//                final double[] timeRemaining = {180}; // timeRemaining = {currentPlayer.getTime()};
//                int tIncrement = 1000;
//                if (timeRemaining[0] < 60000) {
//                    tIncrement = 100;
//                }
//                int finalTIncrement = tIncrement;
//                t = new Timer( tIncrement, new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent a) {
//                        t.stop();
//                        timeRemaining[0] -= finalTIncrement /100;
//
//                    }
//                });
//                t.start();
            }
        });
    }

    public void expandFrame( int size ) {
        size *= 100;
        setSize( new Dimension( size,size+70));
        jpBar.setPreferredSize( new Dimension(size,60));
        jtfText.setPreferredSize( new Dimension(size-10,50));
        jpeBoard.setPreferredSize( new Dimension(size, size));
        jpeBoard.repaint();
    }

    @Override
    public void mouseClicked( MouseEvent e ) {}
    @Override
    public void mousePressed( MouseEvent e ) {}
    @Override
    public void mouseReleased( MouseEvent e ) {}
    @Override
    public void mouseEntered( MouseEvent e ) {}
    @Override
    public void mouseExited( MouseEvent e ) {}

}
