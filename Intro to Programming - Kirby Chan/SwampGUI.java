import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class SwampGUI
{
	JFrame window;
	Container content;

	JPanel leftPanel;
	JPanel filePanel;
	JPanel gridPanel;

	JTextField file;
	JButton load;
	JTextArea result;

	JButton[][] swampButtons;
	int[] dropInPt = new int[2];
	int n;
	
	public SwampGUI()
	{
		window = new JFrame("Swamp GUI");
		content = window.getContentPane();
		content.setLayout(new GridLayout(1,2));
		ButtonListener listener = new ButtonListener();

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2,1));
		
		filePanel = new JPanel();
		filePanel.setLayout(new GridLayout(2,1));

		file = new JTextField("FILE NAME HERE");
		file.setFont(new Font("verdana", Font.BOLD, 16));
		file.setHorizontalAlignment(JTextField.CENTER);
		
		load = new JButton("LOAD");
		load.setFont(new Font("verdana", Font.BOLD, 16 ));
		load.addActionListener( listener ); 
		
		result = new JTextArea();
		result.setFont(new Font("verdana", Font.BOLD, 16));
		result.setText("");
		
		filePanel.add(file);
		filePanel.add(load);

		leftPanel.add(filePanel);
		leftPanel.add(result);

		gridPanel = new JPanel();

		content.add( leftPanel );
		content.add( gridPanel );

		window.setSize(840,480);
		window.setVisible(true);
	}

	private int[][] loadSwamp(String infileName) throws Exception
	{
		result.setText("");
		content.remove( gridPanel );

		Scanner swampInput = new Scanner( new File(infileName) );
		
		String[] s = swampInput.nextLine().split("\\s+");
		
		n = Integer.parseInt(s[0]);
		
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(n,n));

		dropInPt[0] = Integer.parseInt(s[1]);
		dropInPt[1] = Integer.parseInt(s[2]);

		swampButtons = new JButton[n][n];
		int[][] swamp = new int[n][n];
		for (int r = 0; r < swamp.length; r++)
        {
        	s = swampInput.nextLine().split("\\s+");
        	
        	for (int c = 0; c < s.length; c++)
            {
            	swamp[r][c] = Integer.parseInt(s[c]);
            	swampButtons[r][c] = new JButton(s[c]);
            	gridPanel.add(swampButtons[r][c]);

            	if (s[c].equals("1"))
            		swampButtons[r][c].setForeground(Color.GREEN);
            	else
            		swampButtons[r][c].setForeground(Color.RED);
            }
         }

         content.add( gridPanel );
         swampInput.close();
         return swamp;
    }

	private void depthFirstSearch( int[][] swamp, int r, int c, String path )
	{
		path = path + "["+r+","+c+"]";
		if (r == 0 || c == 0 || r == swamp.length-1 || c == swamp[r].length-1)
		{
			swampButtons[r][c].setForeground(Color.BLUE);
			result.append(path + "\n");
			return;
		}
		
		if (swamp[r-1][c] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r-1, c, path);
			swamp[r][c] = 1;
		}
		if (swamp[r-1][c+1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r-1, c+1, path);
			swamp[r][c] = 1;
		}
		if (swamp[r][c+1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r, c+1, path);
			swamp[r][c] = 1;
		}
		if (swamp[r+1][c+1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r+1, c+1, path);
			swamp[r][c] = 1;
		}
		if (swamp[r+1][c] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r+1, c, path);
			swamp[r][c] = 1;
		}
		if (swamp[r+1][c-1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r+1, c-1, path);
			swamp[r][c] = 1;
		}
		if (swamp[r][c-1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r, c-1, path);
			swamp[r][c] = 1;
		}
		if (swamp[r-1][c-1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r-1, c-1, path);
			swamp[r][c] = 1;
		}
		return;
	}

	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Component whichButton = (Component) e.getSource();
			try
			{
				if (whichButton==load)
				{
					int[][] swamp = loadSwamp( file.getText() );
					depthFirstSearch(swamp, dropInPt[0], dropInPt[1], "");
				}
			}
			catch (Exception ex)
			{
    			file.setText("INVALID FILE NAME");
    			content.add( gridPanel );
			}
		}
	}
	public static void main(String [] args)
	{
		new SwampGUI();
	}
}