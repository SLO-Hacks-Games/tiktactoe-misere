import javax.swing.*;

public class Main {
    public static void main( String[] args ) {
        String name1 = JOptionPane.showInputDialog("Now Entering! Player One:","Bee");
        String name2 = JOptionPane.showInputDialog("Now Entering? Player Two:","Bo");
        JFrameExt f = new JFrameExt( name1, name2 );
        f.setVisible( true );
    }
}
