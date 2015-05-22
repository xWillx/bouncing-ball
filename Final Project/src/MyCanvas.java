import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MyCanvas extends Canvas implements ActionListener, KeyListener
	{
 
	private static final long	serialVersionUID	= 1L;
	private static boolean topSquare;
	private static boolean bottomSquare;
	private static boolean leftSquare;
	private static boolean rightSquare;
	static int yDir = 3;
	static int xDir = 10;
	static int xTrail = 19;
	static private int yTrail = 19;
	private static int y;
	private static int x;
	private static int steepness;
	private static String trail;
	private static int maxHeight = 800;
	private static int maxLength = 800;
	private static boolean endGame=false;
	private static boolean trailing;
	static int VK_DOWN;
	

    public static void main(String[] args) 
    		{
        MyCanvas canvas = new MyCanvas();
        JFrame frame = new JFrame();
        frame.setSize(maxLength, maxHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);       
    		}
	

public void paint(Graphics graphics) 
{
//graphics.setColor(Color.red);
//graphics.fillRect(300, 300, 200, 200);

aquireSteepness();
aquireTrail();




while(endGame==false)
{
	//if(VK_DOWN==true)

	x = x + (xDir);
	y = y + (yDir * steepness);
	if(x > 3 && x < maxHeight - 53)
		{
		graphics.setColor(Color.green);
		graphics.fillOval(x, y, 35,35);
		
		try 
			{
		    Thread.sleep(10);
			}
		catch(InterruptedException ex) 
			{
		    Thread.currentThread().interrupt();
			}
		graphics.setColor(Color.black);
		graphics.fillOval(x, y, 35,35);
		}
	else
		{	
		xDir = xDir * -1;
		xTrail = xTrail * -1;
		}
	
	
	y = y;
	if(y > 3 && y < maxHeight - 53)
		{
		graphics.setColor(Color.green);
		graphics.fillOval(x, y, 35,35);
		
		try 
			{
		    Thread.sleep(10);                
			} 
		catch(InterruptedException ex) 
			{
		    Thread.currentThread().interrupt();
			}
		graphics.setColor(Color.black);
		graphics.fillOval(x,  y, 35,35);
		//graphics.setColor(Color.white);
		//graphics.fillOval(x,  y, 5, 5);
		}
	else
		{	
		yDir = yDir * -1;
		yTrail = yTrail * -1;
		}
	
		if(trailing == true)
			{
			graphics.setColor(Color.white);
			graphics.fillOval(x - xTrail, y - yTrail, 7,7);
			}
		else
			{
			
			}

	if(x <= 500 + steepness && x >= 500 - steepness*2 && y <= 500 && y >= 300) // right wall
		{	
		xDir = xDir * -1;
		xTrail = xTrail * -1;
		}
	
	if(x >= 300 - steepness && x <= 300 + steepness*2 && y <= 500 && y >= 300) // left wall
		{
		xDir = xDir * -1;
		xTrail = xTrail * -1;	
		}
	
	if(y >= 500 - steepness && y <= 500 + steepness*2 && x <= 500 && x >= 300) // bottom wall
		{	
		yDir = yDir * -1;
		yTrail = yTrail * -1;
		//graphics.setColor(Color.blue);
		//graphics.fillOval(x, y, 800, 50);
		}
	
	if((y >= 300 - steepness*2 && y <= 300 + steepness) && x <= 500 && x >= 300) // top wall
		{	
		yDir = yDir * -1;
		yTrail = yTrail * -1;
		//graphics.setColor(Color.red);
		//graphics.fillOval(x, y, 800, 50);
		}
	
	graphics.setColor(Color.black);
	graphics.fillRect(300, 300, 200, 200);
	
	graphics.setColor(Color.yellow);
	graphics.fillRect(300, 300, 200, 200);
}

}


@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}


public static int aquireSteepness()
	{
	System.out.println("How steep do you want the bounce of the ball to be?");
	System.out.println("(1 - 17)");
	Scanner userInput1 = new Scanner(System.in);
	steepness = userInput1.nextInt() + 2;
	return steepness;
	}
public static boolean aquireTrail()
{
	System.out.println("Do you want your ball to leave a trail?");
	Scanner userInput2 = new Scanner(System.in);
	trail = userInput2.nextLine();
		if(trail.equals("no"))
			{
			trailing = false;
			}
		else if(trail.equals("yes"))
			{
			trailing = true;
			}
		else
			{
			System.out.println("That is not an option. There will be no trail by default.");
			trailing = false;
			}	
		return trailing;
}


}
	