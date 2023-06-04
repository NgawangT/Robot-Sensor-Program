package uk.ac.brunel.cs1702.DetectObject;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import uk.ac.brunel.cs1702.IntegrationMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetectGUI {
	static Finch myfinch = IntegrationMain.finch;

	static JFrame frame;
	static JPanel panelhome, panelmode, panelcurious, panelscaredy, panelany, panelendpage, panellog; 
	static JButton Startbutton, Exitbutton, Restartbutton, logbutton, Curiousbutton, Scaredybutton,
			Anybutton;
	static JLabel label1, label2, label3, label4, label5, label6, label7, labelnotlevel, labelp;
	static JTextArea Log;

	 
	public static void main(String[] args) { //runs the code 

		
		welcomepage(); //calls the method for WelcomePage
		DetectObjectMain.detectobject(myfinch); //calls the DetectObject method from the DetecObjectMain class. 

	}
	//public = an access modifier, static makes sure the method variables can be used elsewhere.
	public static void welcomepage() { //runs the welcome page code
		// Void is a return type, mode page is the name of the function.
		//creates a Jframe
		frame = new JFrame();
		frame.setVisible(true); //shows the frame if visible set true, set false to not show
		frame.setTitle("Detect Object task 5"); //set the title of the frame to the string within the quotation marks"
		frame.setSize(1000, 700); // set frame size (int width, int height) takes the two parameters. 
		frame.setLocation(50, 5); // takes two parameters x and y , x is for the position along the x axis and y for the y axis. (top left corner of your screen is (0,0)
		frame.setResizable(false); // frame can no longer resize via the graphical interface only via changing the parameters entered for width and height.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //it exits the application and releases memory
        //setdefaultcloseoperation(int)  allows you to set the operation for when the user clicks on the cross. If 0 given (cannot close it even when pressed cross)
		//creates a Jpanel 
		panelhome = new JPanel();
		panelhome.setLayout(null); // no layout manager used so components can be assigned to specific x and y coordinates
		panelhome.setVisible(true); //panel can be seen with true vice versa with false
		panelhome.setBackground(Color.red); //the background colour chosen is red
        //creates a Jbutton and it's name Start.
		Startbutton = new JButton("Start");
		Startbutton.setBounds(15, 580, 100, 50); //(int x, int y, int width, int height) sets the position of the button sand the size of the button. 
		Startbutton.setToolTipText("Click here to start"); //this method register the component as tool tip so when displayed  gives the tool tip the specified text. But if null turns off the tool tip.
		//creates a Jlabel 
		label1 = new JLabel("Welcome to Detect Object :)"); //label displays the specified string.
		label1.setFont(new Font("Calibri", Font.BOLD, 50)); //sets the font type, bold  and size.
		label1.setForeground(Color.white); //text colour of the label set to white.
		label1.setBounds(270, 25, 5000, 100); //(int x, int y, int width, int height) sets the position of the button sand the size of the button.
		labelp = new JLabel("Place Finch on floor before starting");
		labelp.setFont(new Font("Calibri", Font.BOLD, 50));
		labelp.setForeground(Color.white);
		labelp.setBounds(200, 225, 5000, 200);

		Exitbutton = new JButton("Exit");
		Exitbutton.setBounds(870, 580, 100, 50);
		Exitbutton.setToolTipText("Click here to Exit");
		//adding components to the panels.
		panelhome.add(Startbutton); //adding start button onto the panel home.
		panelhome.add(Exitbutton); //adding exit button onto the panel home.
		panelhome.add(label1); //adding label1 onto the panel home.
		panelhome.add(labelp); //adding label p  onto the panel home.
        // adding the panel home to the frame.
		frame.add(panelhome);

		//defines what should be done when the user performs certain operation (In this instance is clicking the start button.
		Startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //called just after the user performs an action
				panelhome.setVisible(false); //home panel is no longer shown
				modepage(); //calls the mode page method

			}

		});

		Exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.exit(0); //exit the program (0) the 0 parameter means exit when everything is fine.
				frame.setVisible(false);
				frame.dispose();

				IntegrationMain.main(null);
			}

		});
	}


	public static void modepage() { //method for the page displaying all the modes

		panelmode = new JPanel(); //creates the Jpanel for mode
		panelmode.setLayout(null);
		panelmode.setVisible(true);
		panelmode.setBackground(Color.red);

		Curiousbutton = new JButton("Curious Mode");
		Curiousbutton.setBounds(15, 400, 200, 150);
		Curiousbutton.setToolTipText("Click here to begin curious mode");
		Scaredybutton = new JButton("Scaredy Mode");
		Scaredybutton.setBounds(300, 400, 200, 150);
		Scaredybutton.setToolTipText("Click here to begin scaredy mode");
		Anybutton = new JButton("Any Mode");
		Anybutton.setBounds(550, 400, 200, 150);
		Anybutton.setToolTipText("Click here to begin any mode");

		label2 = new JLabel("Pick a mode");
		label2.setFont(new Font("Calibri", Font.BOLD, 50));
		label2.setForeground(Color.white);
		label2.setBounds(370, 25, 400, 100);

		panelmode.add(Curiousbutton);
		panelmode.add(Scaredybutton);
		panelmode.add(Anybutton);
		panelmode.add(label2);

		frame.add(panelmode);

		Curiousbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Curious mode is running"); //prints
				panelmode.setVisible(false); //Hides this Panel
				curiousmode(); //curious mode runs
			}
		});
		Scaredybutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Scaredy mode is running"); //prints
				panelmode.setVisible(false); //Hides this Panel
				scaredymode(); //scaredy mode runs
			}
		});

		Anybutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Any mode is running"); //prints
				panelmode.setVisible(false); //Hides this Panel
				anymode(); //any mode runs
			}
		});

	}

	public static void curiousmode() {
//calling the curious mode
		DetectObjectMain.curious();
	}

	public static void scaredymode() {

//calling the ScaredyMode

		DetectObjectMain.Scaredy();
	}

	public static void anymode() {

//adding the any mode
		DetectObjectMain.Any();
	}

	public static void Endpage() {

		panelendpage = new JPanel();
		panelendpage.setLayout(null);
		panelendpage.setVisible(true);
		panelendpage.setBackground(Color.red);

		label6 = new JLabel("End Page");
		label6.setFont(new Font("Calibri", Font.BOLD, 50));
		label6.setForeground(Color.white);
		label6.setBounds(270, 25, 5000, 100);

		Restartbutton = new JButton("Restart");
		Restartbutton.setBounds(870, 380, 100, 50);
		Restartbutton.setToolTipText("Restart the Program");

		Exitbutton = new JButton("Exit");
		Exitbutton.setBounds(870, 580, 100, 50);
		Exitbutton.setToolTipText("Click here to Exit");

		logbutton = new JButton("View Log");
		logbutton.setBounds(870, 180, 100, 50);
		logbutton.setToolTipText("Click here to view log");

		//adding to the panel
				panelendpage.add(label6);
				panelendpage.add(Restartbutton);
				panelendpage.add(Exitbutton);
				panelendpage.add(logbutton);
				frame.add(panelendpage);

		Restartbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelhome.setVisible(true);
				panelendpage.setVisible(false);

			}
		});

		Exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();

				IntegrationMain.main(null);
			}
		});

		logbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelendpage.setVisible(false);
				log();
			}
		});

	}

	public static void log() {

		DetectObjectMain.log();
		panellog = new JPanel();
		panellog.setLayout(null);
		panellog.setVisible(true);
		panellog.setBackground(Color.red);

		Exitbutton = new JButton("Exit");
		Exitbutton.setBounds(870, 580, 100, 50);
		Exitbutton.setToolTipText("Click here to Exit");

		Restartbutton = new JButton("Restart");
		Restartbutton.setBounds(870, 380, 100, 50);
		Restartbutton.setToolTipText("Restart the Program");

		label7 = new JLabel("Log Execution");
		label7.setFont(new Font("Calibri", Font.BOLD, 50));
		label7.setForeground(Color.white);
		label7.setBounds(270, 25, 5000, 100);

		long duration = DetectObjectMain.duration;
		String moderan = DetectObjectMain.moderan; //previously amode
		int counter = DetectObjectMain.counter;

		JTextArea Log = new JTextArea(5, 20);
		String Logtext = "The duration is: "+duration+"\n\nThe mode played was: "+moderan+"\n\nNo of times object encountered: "+counter+"";
		Log.setText(Logtext);
		Log.setBounds(10, 100, 670, 450);
		Log.setLineWrap(true);
		Log.setWrapStyleWord(true);
		Log.setBackground(Color.RED);
		Log.setForeground(Color.white);
		Log.setFont(new Font("Calibri", Font.BOLD, 50));
		Log.setEditable(false);
		
		panellog.add(label7);
		panellog.add(Exitbutton);
		panellog.add(Restartbutton);
		panellog.add(Log);

		frame.add(panellog);
		//DetectObjectMain.log();


		Exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
				frame.setVisible(false);
				frame.dispose();

				IntegrationMain.main(null);
			}
		});
		
		Restartbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelhome.setVisible(true);
				panellog.setVisible(false);

			}
		});
		
	}
}







	




