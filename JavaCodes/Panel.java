/*
    CO225 - Project_1 : Fractals
    Author : Damsy De Silva
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected static JFrame frame;	
    protected static String title;

    Panel(String title){
        Panel.title = title;
        setPreferredSize(new Dimension(800, 800));	
    }

    private static void printPoint(Graphics2D frame, Color c, Point p) {
        frame.setColor(c);
        frame.draw(new Line2D.Double(p.getX(), p.getY(), p.getX(), p.getY()));
    }
    
    protected Color colorCal(int k) {
    	if (k == 0) {
    		return Color.BLACK;
    	}else {
    		return Color.getHSBColor(k/1000f, 1f, k/(k + 5f));
    	}
        
    }


    public void paintComponent(Graphics g){
    	
    	//System.out.println("Executing Paint Component");
        super.paintComponent(g);
        
        for(int x = 0; x < 800; x++){
            for(int y = 0; y < 800; y++){
            	
                Point p = new Point(x, y);
                int k = Fract.getCanvasPoint(x, y);
                printPoint((Graphics2D) g, colorCal(k), p);
               
            }
        }
    }

    public void drawCanvas(){
    	
        JFrame frame = new JFrame(Panel.title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        System.out.println("Canvas Generated....");
        
        
    }

}
