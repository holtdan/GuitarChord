import javax.swing.JFrame;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class FrameWindow extends JFrame {
	public FrameWindow() {

        initUI();
    }

    private void initUI() {
        
        setTitle("Chord Entry");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new ChordEntry());

        setSize(300, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            	FrameWindow ps = new FrameWindow();
                ps.setVisible(true);
            }
        });
    }
}
