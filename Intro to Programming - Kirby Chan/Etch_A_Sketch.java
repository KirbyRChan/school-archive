import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Etch_A_Sketch implements MouseListener, MouseMotionListener  // NOTE multiple interfaces
{
	JFrame window;
	Container contentPane;
	int mouseX,mouseY,oldX,oldY;
	Color currDrawingColor = Color.BLACK;
	Color[] colorList = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.BLACK};
	int index = 0;

	 // ADD A BUTTON THAT WHEN CLICKED, CHANGES THE CURR COLOR

	public Etch_A_Sketch()
	{
		JFrame window = new JFrame("Classic Etch a Sketch");
		contentPane = window.getContentPane();
		contentPane.setLayout( new FlowLayout() );

		JButton colorButton = new JButton("Click Me to change my color");
		colorButton.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 60));
		ActionListener listener = new MyListener();
		colorButton.addActionListener(listener);
		contentPane.add(colorButton);
		
		contentPane.addMouseListener(this);        // "this" is the class that implements that listener
		contentPane.addMouseMotionListener(this);  // "this" is the class that implements that listener
		window.setSize(640,480);
		window.setVisible(true);
	}
	// ..............................................................
	// IMPLEMENTING MOUSELISTENER REQUIRES YOU TO WRITE (OVER-RIDE) THESE METHODS 

	//when you press & release with NO MOVEMENT while pressed
	public void mouseClicked( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		
	}
	
	// when you press 
	public void mousePressed( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		//repaint();
	}

	//when you let release after dragging
	public void mouseReleased( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		//repaint();
	}

	// the mouse just moved off of the JFrame
	public void mouseExited( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		//repaint();
	}
	
	// the mouse just moved onto the JFrame
	public void mouseEntered( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		//repaint();
	}
	// ...............................................................
	// IMPLEMENTING MOUSEMOTIONLISTENER REQUIRES YOU WRITE (OVER-RIDE) THESE METHODS 

	// mouse is moving while pressed
	public void mouseDragged( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

		if (oldX ==0 )
		{
			oldX=mouseX;
			oldY=mouseY;
			return;
		}
		
		// draw  dot (actually small line segment) between old (x,y) and current (x,y)
		
		Graphics g = contentPane.getGraphics(); // use g to draw onto the pane
		g.setColor( currDrawingColor );
		g.drawLine( oldX,oldY, mouseX, mouseY );
		oldX = mouseX;
		oldY = mouseY;
		//repaint();
	}
	
	// moved mouse but not pressed
	public void mouseMoved( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		//repaint();
	}

	// ..............................................................

	public static void main( String[] args)
	{
		new Etch_A_Sketch();
	}

	class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			Component buttonClicked = (Component) e.getSource();
			
			currDrawingColor = colorList[index];
			buttonClicked.setForeground(colorList[index]);

			index = (index + 1) % colorList.length;
		}
	}
}//EOF