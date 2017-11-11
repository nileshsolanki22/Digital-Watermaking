package Watermark;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class WaterMark extends JFrame implements ActionListener,ItemListener
{
	JLabel l,image;
	public JTextField t;
    JFileChooser fc1,fc2;
    int returnVal;
    JTextField tf;
    JMenu mb1,mb2,mb3;
    JMenuBar mb;
    JComboBox box;
    JButton b; 
    JMenuItem mi1,mi2,mi3,mi4,mi5,mi6;
    
    Font f1;
    File file;
    ImageIcon icon;
	String[] description = { "Choose Font","Arial", "Times New Roman", "Courier"};
	WaterMark()
	{
		setLayout(new FlowLayout());
		
		setTitle("Watermark");
		
		b=new JButton("Watermark");
		t=new JTextField();
		image =new JLabel();
		box =new JComboBox();
		mb=new JMenuBar();
		mb1=new JMenu("File");
		mb2=new JMenu("Insert");
		mb3=new JMenu("View");
		mb.add(mb1);
		mb.add(mb2);
		mb.add(mb3);
	
		tf=new JTextField("                                                                 ");
		fc1 = new JFileChooser();
		fc2 = new JFileChooser();
		
		//Adding Buttons and Menu Bar Items
		add(b);
		add(tf);
		
		
		this.setJMenuBar(mb);
		mi1=new JMenuItem("Import");
     	mi2=new JMenuItem("Export");
     	mi3=new JMenuItem("Quit");
		mi4=new JMenuItem("Font");
		mi5=new JMenuItem("Color");
		mi6=new JMenuItem("Preview");
		
		mi1.addActionListener(this);
     	mi2.addActionListener(this);
     	mi3.addActionListener(this);
     	mi4.addActionListener(this);
     	mi5.addActionListener(this);
     	mi6.addActionListener(this);
     	b.addActionListener(this);
     	box.addItemListener(this);
     	
     	
		
		mb1.add(mi1);
		mb1.add(mi2);
		mb1.addSeparator();
		mb1.add(mi3);
		mb2.add(mi4);
		mb2.add(mi5);
		mb3.add(mi6);
		add(box);	
		add(image);
		add(t);
		//Adding Image to label
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(500,500);
		setVisible(true);
	//	Colour c=new Colour();
	//	t.setBackground(c.c1);
	}
	
	public void actionPerformed(ActionEvent  ae)
	{
		
		JMenuItem mi=(JMenuItem)ae.getSource();
		if(mi==mi1)
		{
			returnVal= fc1.showOpenDialog(mi1);
			System.out.print(returnVal);
			file = fc1.getSelectedFile();
            try
            {
            icon = new ImageIcon(ImageIO.read(file));	
          	image.setIcon(icon);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}		
		}
		else if(mi==mi2)
		{
			returnVal= fc2.showSaveDialog(mi1);	
		}
		else if(mi==mi3)
		{
			System.exit(0);	
		}
		else if(mi==mi5)
		{
			Colour c=new Colour();
			
			//	System.out.print(s);
		}
		else if(mi==mi6)
		{
			new ImageDemo("foo.jpg");
		}
		
	}
/*
	private void JButtonactionPerformed(ActionEvent ae)
		{
		JButton b1=(JButton)ae.getSource();	
		if(b==b1)
		{
			// create BufferedImage object of same width and height as of original image
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth()/2,icon.getIconHeight()/2
        , BufferedImage.TYPE_INT_RGB);
 
            // create graphics object and add original image to it
            Graphics graphics = bufferedImage.getGraphics();
            graphics.drawImage(icon.getImage(), 0, 0, null);
 
            // set font for the watermark text
            graphics.setFont(new Font("Arial", Font.BOLD, 30));
 
            //unicode characters for (c) is \u00a9
            String watermark = "\u00a9 NIIT University";
 
            // add the watermark text
            graphics.drawString(watermark, 0,icon.getIconHeight()/2 );
         
            graphics.dispose();
 
            File newFile = new File("C:/Users/Nilesh/Desktop/WatermarkedImage.jpg ");
            try {
                  ImageIO.write(bufferedImage, "jpg", newFile);
            } catch (IOException e) {
                  e.printStackTrace();
            }
		}
		
				
	}*/
	
	public void itemStateChanged(ItemEvent ie)
		{
			if(ie.getStateChange()==ie.SELECTED)
			{	
			//	String s=
				tf.setText(description[box.getSelectedIndex()]);
				f1=new Font("description[box.getSelectedIndex()]",Font.PLAIN,18);
				System.out.println(description[box.getSelectedIndex()]);
				tf.setFont(f1);
			}
		}
	
	
    	
	public static void main(String[] args) throws IOException
 	{
 		new WaterMark();
	}
			
}

/*class WatermarkImage 
{
	public static void main(String[] args)
 	{
 		new WaterMark();
        File origFile = new File("D:/OrignalImage.jpg");
        ImageIcon icon = new ImageIcon(origFile.getPath());
 
        // create BufferedImage object of same width and height as of original image
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(),
                        icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
 
            // create graphics object and add original image to it
            Graphics graphics = bufferedImage.getGraphics();
            graphics.drawImage(icon.getImage(), 0, 0, null);
 
            // set font for the watermark text
            graphics.setFont(new Font("Arial", Font.BOLD, 30));
 
            //unicode characters for (c) is \u00a9
            String watermark = "\u00a9 NIIT University";
 
            // add the watermark text
            graphics.drawString(watermark, 0,icon.getIconHeight()/2 );
         
            graphics.dispose();
 
            File newFile = new File("C:/Users/Nilesh/Desktop/WatermarkedImage.jpg ");
            try {
                  ImageIO.write(bufferedImage, "jpg", newFile);
            } catch (IOException e) {
                  e.printStackTrace();
            }
 
            System.out.println(newFile.getPath() + " created successfully!");
 
      }
 
}
*/

class ImageDemo
{
  ImageDemo(final String filename) 
  //throws Exception
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        JFrame editorFrame = new JFrame("Image Preview");
       // editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        BufferedImage image = null;
        try
        {
          image = ImageIO.read(new File(filename));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

        editorFrame.pack();
        editorFrame.setLocationRelativeTo(null);
        editorFrame.setVisible(true);
      }
    });
   }
}


/*
class Colour extends Frame implements AdjustmentListener  
{
	Scrollbar sb1,sb2,sb3;
	Label l1,l2,l3,l4;
	TextField tf1;
	Color c1;
	Colour()
	{
	
		setTitle("Colour");
		setLayout(new GridLayout(4,2));
		tf1=new TextField();
		tf1.setBackground(Color.BLACK);
		l1=new Label("Red");
		l2=new Label("Green");
		l3=new Label("Blue");
		l4=new Label("Colour");
		sb1=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);
		sb2=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);
		sb3=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);
		sb1.addAdjustmentListener(this);
		sb2.addAdjustmentListener(this);
		sb3.addAdjustmentListener(this);
		add(l4);add(tf1);add(l1);add(sb1);add(l2);add(sb2);add(l3);add(sb3);
		setSize(300,300);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String args[])
	{
		new Colour();
	}
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		c1=new Color(sb1.getValue(),sb2.getValue(),sb3.getValue());
		tf1.setBackground(c1);
	}		
}*/