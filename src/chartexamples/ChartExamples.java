package chartexamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class ChartExamples extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel myPanel = new JPanel();
	JButton lineButton = new JButton();
	JButton spiralButton = new JButton();
	JButton barButton = new JButton();
	JButton pieButton = new JButton();
	static JTextField xmin = new JTextField();
	static JTextField xmax = new JTextField();
	JTextField ymin = new JTextField();
	JTextField ymax = new JTextField();
	JTextField aField = new JTextField();
	JTextField bField = new JTextField();
	JTextField cField = new JTextField();
	JTextField dField = new JTextField();
	JButton update = new JButton();
	// running
	Random myRandom = new Random();
	double[] x = new double[200];
	double[] y = new double[200];
	double[] yd = new double[200];
	
	Color[] plotColor = new Color[10];
	
	double a = 1.0, b = 0.0, c = 0.0, d= 0.0;
	static int xminNumber = -100;
	
	Color myRed = new Color(255, 0, 0);
	Color lightRed = new Color(255, 194, 179);
	Color skyBlue = new Color(102, 179, 255);
	Color limeGreen = new Color(102, 255, 51);
	Color pinkishPurple = new Color(230, 0, 230);
	Color superLightRed = new Color(255, 230, 255);
	Color lightHotPink = new Color(255, 179, 255);
	
	Color babyPurple = new Color(204, 204, 255);
	Color hotPink = new Color(255, 0, 102);
	Color forestGreen = new Color(0, 77, 0);
	Color lightYellow = new Color(255, 255, 153);
	Color babyBlue = new Color(153, 204, 255);
	Color navyBlue = new Color(0, 0, 102);
	Color aquamarine = new Color(0, 255, 255);
	Color myOrange = new Color(255, 153, 51);
	Color myMaroon = new Color(128, 0, 0);
	Color myPurple = new Color(153, 0, 204);
	Color darkGreen = new Color(0, 51, 0);
	
	Font myButtonFont = new Font("TimesRoman", Font.BOLD, 17);
	Font myButtonFont2 = new Font("Courier", Font.PLAIN, 15);
	
	public ChartExamples() {
		setTitle("Chart Examples by Heather");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c;
		getContentPane().setBackground(lightHotPink);
		
		myPanel.setPreferredSize(new Dimension(400, 300));
		myPanel.setBorder(BorderFactory.createLineBorder(myRed, 10));
		myPanel.setBackground(Color.WHITE);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(myPanel, c);
		
		lineButton.setText("Line");
		lineButton.setPreferredSize(new Dimension(100, 25));
		lineButton.setBorder(BorderFactory.createLineBorder(lightRed, 3));
		lineButton.setBackground(pinkishPurple);
		lineButton.setFont(myButtonFont);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(lineButton, c);
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineButtonActionPerformed(e);
			}
		});
		
		
		spiralButton.setText("Polar");
		spiralButton.setPreferredSize(new Dimension(100, 25));
		spiralButton.setBorder(BorderFactory.createLineBorder(skyBlue, 3));
		spiralButton.setBackground(lightRed);
		spiralButton.setFont(myButtonFont2);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(spiralButton, c);
		spiralButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineButtonActionPerformed(e);
			}
		});
		
		
		barButton.setText("Bar");
		barButton.setPreferredSize(new Dimension(100, 25));
		barButton.setBorder(BorderFactory.createLineBorder(limeGreen, 3));
		barButton.setBackground(skyBlue);
		barButton.setFont(myButtonFont);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(barButton, c);
		barButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barButtonActionPerformed(e);
			}
		});
		
		
		pieButton.setText("Pie");
		pieButton.setPreferredSize(new Dimension(100, 25));
		pieButton.setBorder(BorderFactory.createLineBorder(pinkishPurple, 3));
		pieButton.setBackground(limeGreen);
		pieButton.setFont(myButtonFont2);
		c = new GridBagConstraints();
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(pieButton, c);
		pieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pieButtonActionPerformed(e);
			}
		});
		
		xmin.setText("xMin");
		xmin.setPreferredSize(new Dimension(100, 25));
		xmin.setEditable(true);
		//ymin.setColumns(10);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5,5,5,5);
		getContentPane().add(xmin, c);
		xmin.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				xmin.setText("");
			}

			public void focusLost(FocusEvent e) {
				
			}

		});
		
		xmax.setText("xMax");
		xmax.setPreferredSize(new Dimension(100,25));
		xmax.setEditable(true);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(5,5,5,5);
		getContentPane().add(xmax, c);
		xmax.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				xmax.setText("");
			}
			
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		ymin.setText("yMin");
		ymin.setPreferredSize(new Dimension(100, 25));
		ymin.setEditable(true);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 2;
		c.insets = new Insets(5,5,5,5);
		getContentPane().add(ymin, c);
		ymin.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				ymin.setText("");
			}
			
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		ymax.setText("yMax");
		ymax.setPreferredSize(new Dimension(100, 25));
		ymax.setEditable(true);
		c = new GridBagConstraints();
		c.gridx = 3;
		c.gridy = 2;
		c.insets = new Insets(5,5,5,5);
		getContentPane().add(ymax, c);
		
		aField.setText("a");
		aField.setPreferredSize(new Dimension(100, 25));
		aField.setEditable(true);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(5,5,5,5);
		getContentPane().add(aField, c);
		aField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				aField.setText("");
			}
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		bField.setText("b");
		bField.setPreferredSize(new Dimension(100, 25));
		bField.setEditable(true);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(5,5,5,5);
		getContentPane().add(bField, c);
		bField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				bField.setText("");
			}
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		cField.setText("c");
		cField.setPreferredSize(new Dimension(100, 25));
		cField.setEditable(true);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 3;
		c.insets = new Insets(5,5,5,5);
		getContentPane().add(cField, c);
		cField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				cField.setText("");
			}
			public void  focusLost(FocusEvent e) {
				
			}
		});
		
		dField.setText("d");
		dField.setPreferredSize(new Dimension(100, 25));
		dField.setEditable(true);
		c = new GridBagConstraints();
		c.gridx = 3;
		c.gridy = 3;
		c.insets = new Insets(5,5,5,5);
		getContentPane().add(dField, c);
		dField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				dField.setText("");
			}
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		/*update.setText("Update");
		update.setPreferredSize(new Dimension(205, 25));
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		c.insets = new Insets(5,5,5,5);
		getContentPane().add(update, c);
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateButtonClicked();
			}
		});*/
		
		pack();
		//setLocationRelativeTo(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - getWidth())),
				(int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
		plotColor[0] = babyPurple;
		plotColor[1] = hotPink;
		plotColor[2] = forestGreen;
		plotColor[3] = darkGreen;
		plotColor[4] = babyBlue;
		plotColor[5] = navyBlue;
		plotColor[6] = aquamarine;
		plotColor[7] = myOrange;
		plotColor[8] = myMaroon;
		plotColor[9] = myPurple;
		
	}

	
	private void pieButtonActionPerformed(ActionEvent e) {
		// Generate 3 to 10 slices at random with values from 1 to 5
	    int numberSlices = myRandom.nextInt(8) + 3;
	    for (int i = 0; i < numberSlices; i++)
	    {
	      y[i] = myRandom.nextDouble() * 5 + 1;
	    }
	    Rectangle2D.Double borderRectangle = new Rectangle2D.Double(70, 20, 260, 260);
	    PieChartPanel myPieChart = new PieChartPanel(borderRectangle, numberSlices, y, plotColor);
	    myPieChart.setPreferredSize(new Dimension(400, 300));
	    myPieChart.setBackground(Color.WHITE);
	    myPanel.removeAll();
	    myPanel.add(myPieChart);
	    this.pack();
	}
	
	private void barButtonActionPerformed(ActionEvent e) {
		// generate 5-10 bars with values from -10 to 10 and draw bar chart
	    int numberBars = myRandom.nextInt(7) + 10;
	    for (int i = 0; i < numberBars; i++)
	    {
	      y[i] = myRandom.nextDouble() * 20 - 10;
	    }
	    // Draw chart
	    Rectangle2D.Double borderRectangle = new Rectangle2D.Double(20, 20, 360, 260);
	    BarChartPanel myBarChart = new BarChartPanel(borderRectangle, numberBars, y, 0.0, plotColor[myRandom.nextInt(10)]);
	    myBarChart.setPreferredSize(new Dimension(400, 300));
	    myBarChart.setBackground(Color.WHITE);
	    myPanel.removeAll();
	    myPanel.add(myBarChart);
	    this.pack();
	}
	
	private void lineButtonActionPerformed(ActionEvent e) {
		
		// Draw line and spiral charts
		// Create a sinusoids with 200 points
		double alpha = 0.1 - myRandom.nextDouble() * 0.2;
		double beta = myRandom.nextDouble() * 10 + 5;
		for (int i = 0; i < 200; i++) {
			// just like math class, plot y as a function of x
			// y = f(x)
			// for example, y = mx + b is a straight line
			// y = ax^2 + bx + c is a quadratic, plots as a parabola
			// to square a number, multiply it by itself or use the Math class
			// Math.pow(double a, double b) which
			// returns the value of -a- raised to the power of -b-
			x[i] = i - 100; // shifts to the left about 1/2 total
			//double a = 1.0, b = 2.0, c = 0.0, d= 4.0;
			double m = 0.5, b2 = -40; 
			// but this is usually the better way, for any exponent ---
			//y[i] = a * Math.pow(x[i], 2.0) + b * x[i] + c;
			//y[i] = m*x[i] + b2;
			if (aField.getText().equals("a") || aField.getText().equals("")) {
				a = 1.0;
			} else {
				a = Double.parseDouble(aField.getText());
				//System.out.println(a);
			}
			
			if (bField.getText().equals("b") || bField.getText().equals("")) {
				b = 0.0;
			} else {
				b = Double.parseDouble(bField.getText());
			}
			
			if (cField.getText().equals("c") || cField.getText().equals("")) {
				c = 0.0;
			} else {
				c = Double.parseDouble(cField.getText());
			}
			
			if (dField.getText().equals("d") || dField.getText().equals("")) {
				d = 0.0;
			} else {
				d = Double.parseDouble(dField.getText());
			}
			
			y[i] = a*Math.pow(x[i], 3.0) + b*Math.pow(x[i], 2.0) + c*x[i] + d;
			//y[i] = a*Math.pow(x[i], 3.0) + b*Math.pow(x[i], 2.0) + c*x[i] + d;
			
			//y[i] = 100.0;
			
			//yd[i] = Math.exp(-alpha * i) * (Math.PI * Math.cos(Math.PI * i/beta)/ beta - alpha * Math.sin(Math.PI * i/beta));
			// one way to square a number ---
			//y[i] = a*x[i] * x[i] + b*x[i] + c;
			//y[i] = Math.exp(-alpha * i) * Math.sin(Math.PI * i /beta);
			//y[i] = Math.exp(-alpha * i) * Math.sin(Math.PI * i / beta);
			//yd[i] = Math.exp(-alpha * i) * (Math.PI * Math.cos(Math.PI * i / beta) / beta - alpha);
			 /*for (int c1 = 0; c1 < 200; c1++)
			    {
			      x[c1] = c1;
			      y[c1] = Math.exp(-alpha * c1) * Math.sin(Math.PI * c1 / beta);
			      yd[c1] = Math.exp(-alpha * c1) * (Math.PI * Math.cos(Math.PI * c1 / beta) / beta - alpha * Math.sin(Math.PI * c1 / beta));
			    }*/
			//System.out.println(LineChartPanel.xMin);
			
		}
		// Draw plots
		Rectangle2D.Double borderRectangle = new Rectangle2D.Double(20, 20, 360, 260);
		LineChartPanel myLineChart = new LineChartPanel();
		if (e.getActionCommand().equals(lineButton.getText())) {
			myLineChart = new LineChartPanel(borderRectangle, 200, x, y, plotColor[myRandom.nextInt(10)]);
		} else {
			myLineChart = new LineChartPanel(borderRectangle, 200, y, yd, plotColor[myRandom.nextInt(10)]);
		}
		myLineChart.setPreferredSize(new Dimension(400, 300));
		myLineChart.setBackground(Color.WHITE);
		//myLineChart.setBorder(BorderFactory.createLineBorder(myRed, 10));
		myPanel.removeAll();
		myPanel.setBorder(BorderFactory.createLineBorder(myRed, 4));
		myPanel.add(myLineChart);
		this.pack();
		
	}
	
	static double updateButtonClicked() {
		
		
		int xmaxNumber = 0;
		if (xmin.getText().equals("xMin") || xmin.getText().equals("")) {
			xminNumber = -100;
		} else {
			xminNumber = Integer.parseInt(xmin.getText());
			
		}
		
		if (xmax.getText().equals("xMax") || xmax.getText().equals("")) {
			return 100;
		} else {
			xmaxNumber = Integer.parseInt(xmax.getText());
		
		}
		
		return xminNumber;
		
		
	}
	
	private void exitForm(WindowEvent evt) {
		
		System.exit(0);
		
	}
	
}
