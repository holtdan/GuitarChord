import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Dimension2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChordEntry extends JPanel {
	private GuitarChord mGuitarChord;
	public GuitarChord getGuitarChord() {
		return mGuitarChord;
	}
	public void setGuitarChord(GuitarChord val) {
		mGuitarChord = val;
		
		mNumStrings = mGuitarChord.getTuning().length();
	}
	
	private int mNumStrings;
	private int mCellWidth;
	private int mCellHeight;
	
	public ChordEntry () {
		setGuitarChord ( GuitarChordFactory.interpretChordData("\"EADGBe\",1,-1,0,2,2,2,0,\"A\"") );
		
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cx = this.getWidth();
        int cy = this.getHeight();
        mCellWidth = cx / (mNumStrings+1);
        mCellHeight = cy / (5+1+1);
        int halfWid = mCellWidth / 2;
        int quarterWid = mCellWidth / 4;
        
        Font f = new Font("SansSerif", Font.BOLD, mCellHeight / 3 * 2 );// 30); // Font
        FontMetrics fm = g.getFontMetrics(f);
        g.setFont(f);

        String fStr = Integer.toString(mGuitarChord.getFretNumber());
        int Fwid = fm.stringWidth(fStr);
        String cNam = mGuitarChord.getName();
        int Nwid = fm.stringWidth(cNam);
        
        g.drawString(fStr, halfWid - Fwid/2, mCellHeight * 2);
        g.drawString(cNam, (cx / 2) - Nwid / 2, cy - fm.getDescent());
        
        //g.drawRoundRect(0, 0, mCellWidth, mCellHeight, 2, 2);
        //g.drawRoundRect(0, mCellHeight, mCellWidth, mCellHeight * 5, 2, 2
                
        for ( int i = 1; i <= 6; ++i ){ // draw frets
        	int y = i * mCellHeight;
        	g.fillRect(mCellWidth + halfWid, y, mCellWidth * (mNumStrings - 1), 3);
        }
        
        int Xwid = fm.stringWidth("X");
        int Owid = fm.stringWidth("O");
        
        for ( int i = 0; i < mNumStrings; ++i ){
        	int x = mCellWidth * (i+1) + halfWid; // vertical center of string
        	g.setColor(Color.gray);        	
        	g.fillRect(x-1, 0, 3, mCellHeight * 6); // draw string
        	
        	int strFret = mGuitarChord.getStringFrets()[i];
        	g.setColor(Color.black);       	
        	if (strFret > 0 ){
        		//g.drawOval((i+1)*mCellWidth, (strFret)*mCellHeight, halfWid, halfWid);
        		g.fillOval(x - quarterWid, (strFret)*mCellHeight+quarterWid, halfWid, halfWid);
        	}
        	else{
        		String c = strFret < 0 ? "X" : "O";
        		int nudge = strFret < 0 ? Xwid / 2 : Owid / 2;
        		
        		g.drawString(c, x - nudge, mCellHeight - fm.getDescent() );
        	}
        }
        //rectangle originated at 10,10 and end at 240,240
        //g.drawRect(10, 10, 240, 240);
        //filled Rectangle with rounded corners.    
        //g.fillRoundRect(50, 50, 100, 100, 80, 80);
    }
}
