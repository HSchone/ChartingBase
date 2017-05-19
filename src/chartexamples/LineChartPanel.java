package chartexamples;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.color.*;

public class LineChartPanel extends JPanel{
	private Rectangle2D.Double borderRectangle;
	private int n;
	private double[] x;
	private double[] y;
	private Color c;

	//static double xMin = -100;
	//static double xMax = 100;
	Color myRed = new Color(255, 0, 0);

	public LineChartPanel() {
		//default constructor for initialization
	}
	
	public LineChartPanel(Rectangle2D.Double border, int nPoints,
			double[] xValues, double[] yValues, Color colorValue) {
		
		this.borderRectangle = border;
		this.n = nPoints;
		this.x = xValues;
		this.y = yValues;
		this.c = colorValue;
		
	}
	
	public void paintComponent(Graphics g) {
		// Draw a line chart - pairs of (x, y) coordinates
		//borderRectangle - rectangle region to draw plot
		// n - number of points to plot
		// x - array of x points (lower index is 0, upper index is n-1)
		// y - array of y points (lower index is 0, upper index is n-1)
		// c - color of line
		// Need at least 2 points to plot
		if (n < 2) {
			return;
		}
		double xMin = x[0];
		//this.xMin = x[0];
		double xMax = x[0];
		double yMin = y[0];
		double yMax = y[0];
		// find minimums and maximums
		for (int i = 1; i < n; i++) {
			xMin = Math.min(xMin, x[i]);
			xMax = Math.max(xMax, x[i]);
			yMin = Math.min(yMin, y[i]);
			yMax = Math.max(yMax, y[i]);
		}
		// Extend y values a bit so lines are not right on borders
		//yMin = (1 - 0.05 * Double.compare(yMin, 0)) * yMin;
		//yMax = (1 + 0.05 * Double.compare(yMax, 0)) * yMax;
		yMin = -100;
		yMax = 100;
		//xMin = -100;
		xMin = -100;
		xMax = 100;
		
		if (ChartExamples.xmin.getText().equals("xMin") || ChartExamples.xmin.getText().equals("")) {
			xMin = -100;
		} else {
			xMin = -1*Integer.parseInt(ChartExamples.xmin.getText())-100;
			//System.out.println(xMin);
			
		}
		
		if (ChartExamples.xmax.getText().equals("xMax") || ChartExamples.xmax.getText().equals("")) {
			xMax = 100;
		} else {
			xMax = -1*Integer.parseInt(ChartExamples.xmax.getText())-100;
		
		}
		
		Graphics2D g2D = (Graphics2D) g;
		super.paintComponent(g2D);
		Line2D.Double myLine;
		Line2D.Double myLine02;
		Line2D.Double XaxisLine; //added for experiment
		Line2D.Double YaxisLine;
		g2D.setPaint(c);
		/*for (int i = 0; i < n - 1; i++) {
			// plot in user coordinates
			myLine = new Line2D.Double(xPhysicalToxUser(borderRectangle, x[i], xMin, xMax),
					yPhysicalToyUser(borderRectangle, y[i], yMin, yMax),
					xPhysicalToxUser(borderRectangle, x[i + 1], xMin, xMax),
					yPhysicalToyUser(borderRectangle, y[i + 1], yMin, yMax));
			

			g2D.draw(myLine);
			
			
		}*/
		myLine02 = new Line2D.Double(xMin+100, yMin+100, xMax+100, yMax+100);
		g2D.draw(myLine02);

		g2D.setPaint(Color.BLACK);
		XaxisLine = new Line2D.Double(380 ,150, 20, 150);
		g2D.draw(XaxisLine);
		YaxisLine = new Line2D.Double(200, 280, 200, 20);
		g2D.draw(YaxisLine);
		g2D.setPaint(Color.BLACK);
		g2D.draw(borderRectangle);
		g2D.dispose();
	}

	
	private double xPhysicalToxUser (Rectangle2D.Double r, double xPhysical, double xMin,
			double xMax) {
		double xTemp = (r.x + (xPhysical - xMin) * (r.width - 1) / (xMax - xMin));
		//double xTemp = xMin + 100;
		return xTemp;
	}
	private double yPhysicalToyUser(Rectangle2D.Double r, double yPhysical, double yMin, double yMax) {
		//return (r.y + (yMax - yPhysical) * (r.height-1)/(yMax - yMin));
		return (r.y + (yPhysical - yMax) * (r.height - 1)/(yMin - yMax));
		//System.out.println(yTemp);


	}
}
