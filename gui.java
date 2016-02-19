import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class gui extends JFrame implements ActionListener{
	private JLabel band1;
	private JLabel band2;
	private JLabel band3;
	private JLabel band4;
	private JLabel resis;
	private JLabel getresistance;
	private JLabel getbands;
	private JLabel linebreaks;
	private JTextField resistance;
	private JButton calculate;
	private JButton calcbands;
	private JLabel padding;
	public static String[] colors = {"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Gray", "White"};
	public static String[] tolcolors={"Red (2%)", "Gold(5%)", "Silver(10%)", "None(20%)"};
	private JComboBox color1= new JComboBox(colors);
	private JComboBox color2= new JComboBox(colors);
	private JComboBox color3= new JComboBox(colors); 
	private JComboBox color4= new JComboBox(tolcolors);
	public static String resistanceinput;
	public static Character letter = new Character('\u2126');
	
	//create constructor
	public gui(){
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JOptionPane.showMessageDialog(null, "Welcome! \nThis calculator will calculate the resistance given four bands and also can find the bands given the resistance\nEnjoy!","Welcome", JOptionPane.INFORMATION_MESSAGE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int n = JOptionPane.showConfirmDialog(null,
					    "Are you sure you want to exit?",
					    "Exit",
					    JOptionPane.YES_NO_OPTION);
				if(n==0){
					JOptionPane.showMessageDialog(null, "Thanks for using the calculator, \nCreated by Murtuza, Afnan and Raj");
					System.exit(0);
				}
				
			}
		});
		setSize(145,420);
		setTitle("Calc");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		final int width1=screenSize.width;
		final int height1=screenSize.height;
		setLocation(width1/4, height1/4);
		getContentPane().setBackground(Color.black);
		setLayout(new FlowLayout());
		band1 = new JLabel("Band 1:",null,JLabel.CENTER);
		band1.setVerticalTextPosition(JLabel.BOTTOM);
		band2 = new JLabel("Band 2:");
		band3 = new JLabel("Multiplier:    ");
		band4 = new JLabel("Tolerance:");
		resis = new JLabel("Enter Resistance in " + letter + ":");
		calculate= new JButton("CALCULATE");
		calcbands= new JButton("GET BANDS");
		getresistance= new JLabel("Calculate Resistance:");
		getresistance.setFont(new Font("Arial", Font.BOLD, 13));
		getresistance.setForeground(Color.red);
		getbands= new JLabel("Find Bands:");
		getbands.setFont(new Font("Arial", Font.BOLD, 14));
		getbands.setForeground(Color.red);
		getbands.setHorizontalTextPosition(JLabel.LEFT);
		resistance=new JTextField(10);
		resistance.setToolTipText("Enter the resistance in ohms");
		band1.setForeground(Color.white);
		band2.setForeground(Color.white);
		band3.setForeground(Color.white);
		band4.setForeground(Color.white);
		resis.setForeground(Color.white);
		resis.setToolTipText("Enter the resistance in ohms");
		padding = new JLabel("<html><div style='margin-left:20px'></div></html>");
		JLabel padding2 = new JLabel("<html><div style='margin-right:20px'></div></html>");
		linebreaks=new JLabel("<html><br><br><br></html>");
		add(getresistance);
		add(band1);
		add(color1);
		add(linebreaks);
		add(band2);
		add(color2);
		add(linebreaks);
		add(band3);
		add(color3);
		add(band4);
		add(color4);
		add(linebreaks);
		add(calculate);
		add(linebreaks);
		add(getbands);
		add(resis);
		add(resistance);
		add(padding);
		add(padding2);
		add(calcbands);
		JLabel copyright= new JLabel("<html><style>div{text-align:center;color:yellow;}</style><div><marquee direction='right'>Copyright:<br>Afnan, Murtuza, Raj</marquee></div></html>");
		//copyright.setText();
		add(copyright);
		
		
		
		add(copyright);
		setVisible(true);
		calculate.addActionListener(this);
		calcbands.addActionListener(this);
		
		
			
	}
	//DO STUFF HERE!!!!
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==calculate){
			//gets the band index of each  
			//you can use getSelectedItem() to get the name instead
			//the index uses to the array colors
		String one= Integer.toString(color1.getSelectedIndex());
		String two = Integer.toString(color2.getSelectedIndex());
		String finalone= one+two;
		int firstwo= Integer.parseInt(finalone);
		int multi=0;
		switch(color3.getSelectedIndex()){
		case 0:multi=1;break;
		case 1:multi=10;break;
		case 2:multi=100;break;
		case 3:multi=1000;break;
		case 4:multi=10000;break;
		case 5:multi=100000;break;
		case 6:multi=1000000;break;
		case 7:multi=10000000;break;
		case 8:multi=100000000;break;
		case 9:multi=1000000000;break;
		case 10:multi=1000000000;break;
		}
		
		final long first=firstwo;
		final long finalresistance= first*multi;
		double tolerance=0.02;
		switch (color4.getSelectedIndex()){
		case 0:tolerance=0.02;break;
		case 1:tolerance=0.05;break;
		case 2:tolerance=0.1;break;
		case 3:tolerance=0.2;break;
		}
		double up=finalresistance*tolerance;
		double possibleup=finalresistance+ up;
		double possibledown=(finalresistance-up);
	
		JOptionPane.showMessageDialog(null,"Resistance is " + finalresistance + letter + "\nTolerance of " + color4.getSelectedItem() + " allows" + "\n" + "In between " + (Math.round(possibledown)*100)/100 + letter + " and "  + (Math.round(possibleup)*100)/100 + letter, "Resistance", JOptionPane.INFORMATION_MESSAGE);
		
		}
		if(a.getSource()==calcbands){
			//this will get resistance from the textfield
			if(resistance.getText().isEmpty()||!resistance.getText().matches("^[1-9]\\d*$")||resistance.getText().length()>11){
				JOptionPane.showMessageDialog(null,"Invalid Input\nEnter a valid positive number (less than 12 digits long)","ERROR", JOptionPane.ERROR_MESSAGE);
			}
		
			else{
			resistanceinput= resistance.getText();
			sum.run(resistanceinput);
			}
			
		}
	}
	
public static void main(String[] args){
	new gui();
	
	
	
	
}
}

