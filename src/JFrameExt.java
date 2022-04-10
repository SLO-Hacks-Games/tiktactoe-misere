import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;
import java.text.DecimalFormat;

public class JFrameExt extends JFrame implements MouseListener {

    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel jpBar;
    private final JTextArea jtfText;
    private final JPanelExt jpeBoard;
    private Timer t;
    public int[] player1Time = new int[2];
    public int[] player2Time = new int[2];
    public int second = 0;
    public int minute = 3;
    public int turn = 1;
    DecimalFormat dFormat = new DecimalFormat("00");
    public String ddSecond, ddMinute;
    private String name1, name2;

    public JFrameExt( String name1, String name2 ) {
        super();
        setTitle( "TikTacToe Misère" );
        setSize(310,400);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.name1 = name1;
        this.name2 = name2;

        FlowLayout fl = new FlowLayout();
        JPanel jpMain = new JPanel();
        jpMain.setBackground( Color.lightGray );
        jpMain.setLayout( fl );
        setContentPane(jpMain);
        jpBar = new JPanel();
        jpBar.setPreferredSize( new Dimension(300,55));
        jpBar.setBackground( Color.darkGray );
        jpMain.add( jpBar );
        jpeBoard = new JPanelExt();
        jpeBoard.setPreferredSize( new Dimension(300,300));
        jpMain.add( jpeBoard );
        jtfText = new JTextArea();
        jtfText.setBackground( Color.darkGray );
        jtfText.setForeground( Color.WHITE );
        jtfText.setPreferredSize( new Dimension(290,45));
        jtfText.setEditable( false );
//        pack();
        jpBar.add( jtfText );
        Board board = new Board();
        player1Time[0] = minute;
        player1Time[1] = second;
        player2Time[0] = minute;
        player2Time[1] = second;
//        Player p1 = new Player( name1 );
//        Player p2 = new Player( name2 );
//        Player currentPlayer = P1

       /* jpeBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int x = (int) e.getX() * board.getWidth() / jpeBoard.getWidth();
                int y = (int) e.getY() * board.getWidth() / jpeBoard.getWidth();
                if (board.checkforzero( x, y )) {
                    board.checkMore( x, y );
                    jpeBoard.setBoard( board.getBoard() );
                    jpeBoard.repaint();
                }
//                togglePlayer();
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
        });*/
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                second--;

                if (second == -1) {
                    second = 59;
                    minute--;
                }
                if (second == 0 && minute == 0) {
                    t.stop();

                }
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                if (turn%2 != 0) {
                    System.out.println(ddMinute + " : " + ddSecond);
                    jtfText.setText(name1 + "\n" + ddMinute + " : " + ddSecond);
                } else {
                    System.out.println(ddMinute + " : " + ddSecond);
                    jtfText.setText(name2 + "\n" + ddMinute + " : " + ddSecond);
                }
                jpeBoard.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        int x = (int) e.getX() * board.getWidth() / jpeBoard.getWidth();
                        int y = (int) e.getY() * board.getWidth() / jpeBoard.getWidth();
                        if (board.checkforzero( x, y )) {
                            board.checkMore(x, y);
                            jpeBoard.setBoard(board.getBoard());
                            jpeBoard.repaint();
                        }
                        if (turn % 2 != 0){
                            player1Time[0] = minute;
                            player1Time[1] = second;
                            //System.out.println(player1Time[0] + ":" + player1Time[1]);
                            minute = player2Time[0];
                            second = player2Time[1];

                        } else{
                            player2Time[0] = minute;
                            player2Time[1] = second;
                            //System.out.println(player2Time[0] + ":" + player2Time[1]);
                            minute = player1Time[0];
                            second = player1Time[1];
                        }
                        turn += 1;
                    }
                });
            }
        });
        t.start();
    }

    public void expandFrame( int size ) {
        size *= 100;
        setSize( new Dimension( size,size+70));
        jpBar.setPreferredSize( new Dimension(size,60));
        jtfText.setPreferredSize( new Dimension(size-10,50));
        jpeBoard.setPreferredSize( new Dimension(size, size));
//        jpeBoard.setBoard(Board.getMatrix());
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
