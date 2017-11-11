package Watermark;
import java.awt.*;
import java.awt.event.*;

public class Colour extends Frame implements AdjustmentListener,ActionListener
{
	WaterMark w=new WaterMark();
	Scrollbar sb1,sb2,sb3;
	Label l1,l2,l3,l4;
	TextField tf1;
	public Color c1,c2;
	Button b;
	Colour()
	{
		setTitle("Colour");
		setLayout(new GridLayout(4,2));
		tf1=new TextField();
		tf1.setBackground(Color.BLACK);
		l1=new Label("Red");
		l2=new Label("Green");
		l3=new Label("Blue");
	//	l4=new Label("Colour");
		b=new Button("Add Color");
		sb1=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);
		sb2=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);
		sb3=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);
		sb1.addAdjustmentListener(this);
		sb2.addAdjustmentListener(this);
		sb3.addAdjustmentListener(this);
		b.addActionListener(this);
		add(b);add(tf1);add(l1);add(sb1);add(l2);add(sb2);add(l3);add(sb3);
		setSize(300,300);
		setVisible(true);
		setResizable(false);
	/*	addWindowListener(new WindowAdapter() 
    	{
      		public void windowClosing(WindowEvent e) 
      		{
        		System.exit(0);
      		}
    	});
    */
	}
	public void actionPerformed(ActionEvent  ae)
	{
		Button b1=(Button)ae.getSource();
		if(b==b1)
		{
			c2=new Color(255,0,0);
			w.t.setBackground(c2);	
		}	
	}
	public static void main(String args[])
	{
		new Colour();
	}
    	
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		c1=new Color(sb1.getValue(),sb2.getValue(),sb3.getValue());
	//	c1=new Color(255,0,0);
		tf1.setBackground(c1);
	}		
}


