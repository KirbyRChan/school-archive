// Demonstrates JPanel, GridLayout and a few additional useful graphical features.
// adapted from an example by john ramirez (cs prof univ pgh)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class SimpleCalc
{
	JFrame window;
	Container content ;
	JButton[] digits = new JButton[12]; 
	JButton[] ops = new JButton[4];
	JTextField expression;
	JButton equals;
	JTextField result;
	String[] opCodes = { "+", "-", "*", "/" };
	
	public SimpleCalc()
	{
		window = new JFrame( "Simple Calc");
		content = window.getContentPane();
		content.setLayout(new GridLayout(2,1));
		ButtonListener listener = new ButtonListener();

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,3));
		
		expression = new JTextField();
		expression.setFont(new Font("verdana", Font.BOLD, 16));
		expression.setText("");
		
		equals = new JButton("=");
		equals.setFont(new Font("verdana", Font.BOLD, 20 ));
		equals.addActionListener( listener ); 
		
		result = new JTextField();
		result.setFont(new Font("verdana", Font.BOLD, 16));
		result.setText("");
		
		topPanel.add(expression);
		topPanel.add(equals);
		topPanel.add(result);
						
		// bottom panel holds the digit buttons in the left sub panel and the operators in the right sub panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,2)); // 1 row, 2 col
	
		JPanel  digitsPanel = new JPanel();
		digitsPanel.setLayout(new GridLayout(4,3));	
		
		for (int i=0 ; i<10 ; i++ )
		{
			digits[i] = new JButton( ""+i );
			digitsPanel.add( digits[i] );
			digits[i].addActionListener( listener ); 
		}
		digits[10] = new JButton( "C" );
		digitsPanel.add( digits[10] );
		digits[10].addActionListener( listener ); 

		digits[11] = new JButton( "CE" );
		digitsPanel.add( digits[11] );
		digits[11].addActionListener( listener ); 		
	
		JPanel opsPanel = new JPanel();
		opsPanel.setLayout(new GridLayout(4,1));

		for (int i=0 ; i<4 ; i++ )
		{
			ops[i] = new JButton( opCodes[i] );
			opsPanel.add( ops[i] );
			ops[i].addActionListener( listener ); 
		}
		bottomPanel.add( digitsPanel );
		bottomPanel.add( opsPanel );
		
		content.add( topPanel );
		content.add( bottomPanel );
	
		window.setSize( 640,480);
		window.setVisible( true );
	}

	public String evaluate(String problem)
	{
		StringTokenizer st = new StringTokenizer( problem,"+-*/", true );

		ArrayList<String> operatorList = new ArrayList<String>();			
		ArrayList<Double> operandList = new ArrayList<Double>();

		boolean lastOp = false;
		boolean firstToken = true;

		while (st.hasMoreTokens())
		{
			String token = st.nextToken();
			if ("+-*/".contains(token))
			{
				if (lastOp == true || firstToken == true )
					return "INVALID EXPRESSION";
				operatorList.add(token);
				lastOp = true;
			}
			else
			{
				operandList.add( Double.parseDouble(token) );
				lastOp = false;
				firstToken = false;
	   		}
	   	}

	   	if(lastOp == true)
	   		return "INVALID EXPRESSION";
	   	else
	   	{
	   		int count=0;
	    	while ( operatorList.contains("*") || operatorList.contains("/") )
			{
				if ( operatorList.get(count).equals("*") )
				{
					operandList.set(count, operandList.get(count)*operandList.get(count+1) );
					operatorList.remove(count);
					operandList.remove(count+1);
					count=0;
				}
				else if ( operatorList.get(count).equals("/") )
				{
					operandList.set(count, operandList.get(count)/operandList.get(count+1) );
					operatorList.remove(count);
					operandList.remove(count+1);
					count=0;
				}
				else
					count++;
			}

			while ( operatorList.contains("+") || operatorList.contains("-") )
			{
				if ( operatorList.get(count).equals("+") )
				{
					operandList.set(count, operandList.get(count)+operandList.get(count+1) );
					operatorList.remove(count);
					operandList.remove(count+1);
					count=0;
				}
				else if ( operatorList.get(count).equals("-") )
				{
					operandList.set(count, operandList.get(count)-operandList.get(count+1) );
					operatorList.remove(count);
					operandList.remove(count+1);
					count=0;
				}
				else
					count++;
			}
			
			return "" + operandList.get(0);
	    }
	}

	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Component whichButton = (Component) e.getSource();

			if (whichButton==equals)
			{
				result.setText( evaluate( expression.getText() ) );
				return;
			}
			
			for (int i=0 ; i<12 ; i++ )
			{
				if (whichButton == digits[i] && i < 10)
				{
					expression.setText( expression.getText() + i );
					return;
				}
				else if (whichButton == digits[10])
				{
					expression.setText("");
					return;
				}
				else if (whichButton == digits[11])
				{
					if (expression.getText().length() > 0)
					{
						String exp = expression.getText();
						exp = exp.substring(0, exp.length()-1);
						expression.setText(exp);
					}
					return;
				}
			}

			for (int i=0 ; i<5 ; i++ )
			{
				if (whichButton == ops[i])
				{
					expression.setText( expression.getText() + opCodes[i] );
					return;
				}
			}
		}
	}
	public static void main(String [] args)
	{
		new SimpleCalc();
	}
}
