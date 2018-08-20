

// Flag starter kit

/*
 * Michael Carlstrom
 * Tong Miao
 * OTHER PARTNER'S NAME (if group of three)
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JApplet;

public class Flag extends JApplet {
	private final int STRIPES = 13;

	// SCALE FACTORS (A through L)
	//
	// Note: Constants in Java should always be ALL_CAPS, even
	// if we are using single letters to represent them
	//
	// NOTE 2: Do not delete or change the names of any of the
	// variables given here

	// Set the constants to exactly what is specified in the documentation
	private final double A = 1.0;  // Hoist (width) of flag
	private final double B = 1.9;  // Fly (length) of flag
	private final double C = 7.0/13;  // Hoist of Union
	private final double D = 0.76;  // Fly of Union
	private final double E = 0.054;  // See flag specification
	private final double F = 0.054;  // See flag specification
	private final double G = 0.063;  // See flag specification
	private final double H = 0.063;  // See flag specification
	private final double K = 0.0616;  // Diameter of star
	private final double R = K/2;  // Radius of star
	private final double L = 1.0/13;  // Width of stripe
	private double FlagWidth, FlagHeight;


	// You will need to set values for these in paint()
	private double flag_width;      // width of flag in pixels
	private double flag_height;     // height of flag in pixels
	private double stripe_height;   // height of an individual stripe in pixels

	// init() will automatically be called when an applet is run
	public void init() {
		// Choice of width = 1.9 * height to start off
		// 760 : 400 is ratio of FLY : HOIST
		setSize(760, 400);
		repaint();
	}

	// paint() will be called every time a resizing of an applet occurs
	public void paint(Graphics g) {
		calcRatio();
		drawBackground(g);
		drawStripes(g);
		drawField(g);
		oddDrawStars(g);
		evenDrawStars(g);
	}

	private void drawBackground(Graphics g) {
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(Color.red);
		g.fillRect(0, 0, (int)FlagWidth, (int)FlagHeight);
	}

	public void drawStripes(Graphics g) {
		g.setColor(Color.white);
		for(double i =L*FlagHeight; i<FlagHeight;i = i+L*FlagHeight+L*FlagHeight) {
			int counter =0;
			g.fillRect(0,  (int) i, (int) FlagWidth, (int)( L* FlagHeight));
			counter=counter +1;
		}
	}

	public void drawField(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, (int) (D*FlagWidth/B), (int)(C*FlagHeight)); 
	}



//	public void evenDrawStars(Graphics g) {
//		//g.fillPolygon();
//		for(int counterRight = 0;counterRight<=6;counterRight++) {
//			for(int counterDown = 0; counterDown <=5; counterDown++) {
//				g.drawRect(0, 0, (int) K,(int) K);
//			}
//		}
//	}
	
	public void oddDrawStars(Graphics g) {
		g.setColor(Color.WHITE);
		int row_count = 0;
		for(row_count = 0; row_count<5;row_count++) {
			Point coord = new Point((int) (G*FlagWidth/ B), (int)(E*FlagHeight));
			int col_count = 0;
			for(col_count = 0; col_count<6; col_count++) {
				if (true) {
					drawOneStar(g,(int)(coord.x+(FlagWidth*H*col_count)),(int)(coord.y+ (row_count*2*FlagHeight*F)));
				}
			
			}
	
		}
	}
	
	public void evenDrawStars(Graphics g) {
		g.setColor(Color.WHITE);
		int row_count = 0;
		for(row_count = 0; row_count<4;row_count++) {
			Point coord = new Point((int) (G*FlagWidth/ B*2), (int)(E*FlagHeight*2));
			int col_count = 0;
			for(col_count = 0; col_count<5; col_count++) {
				if (true) {
					drawOneStar(g,(int)(coord.x+(FlagWidth*H*col_count)),(int)(coord.y+ (row_count*2*FlagHeight*F)));
				}
			
			}
	
		}
	}
	
	
	public void drawOneStar(Graphics g, int x, int y) {
		g.setColor(Color.white);
//		System.out.println("1");
actuallDrawStar(g,x,y);
		//int [] z = {1,20,34,44};
		//int [] c = {14,25,63,74};
		
		//g.fillPolygon(z, c, 4);
		//g.fillRect(x,y,(int) (K*FlagHeight/2), (int)(K*FlagHeight/2));
	}
	
	public void actuallDrawStar(Graphics g, int x, int y) {
		double h = Math.sin(Math.toRadians(18))*R;
		double r = h/Math.sin(Math.toRadians(54));
		double j = Math.sin(Math.toRadians(198))*r;
		double k = Math.sin(Math.toRadians(234))*R;
		Point p1 = new Point((int)(Math.sqrt((R*R)-(h*h))), (int)(h));
		Point p2 = new Point((int)(Math.sqrt(r*r-(h*h))), (int)(h));
		Point p3 = new Point(0, (int)R);
		Point p4 = new Point((int)(-(Math.sqrt(r*r-(h*h)))), (int)(h));
		Point p5 = new Point((int)-((Math.sqrt((R*R)-(h*h)))), (int)(h));
		Point p6 = new Point ((int) -((Math.sqrt((r*r)-(j*j)))), (int) j);
		Point p7 = new Point ((int) -(Math.sqrt(((R*R)-k*k))),(int) k);
		Point p8 = new Point (0,(int)-r);
		Point p9 = new Point ((int) -(Math.sqrt(((R*R)-k*k))),(int) k);
		Point p10 = new Point ((int) ((Math.sqrt((r*r)-(j*j)))), (int) j);
		
		int[] xPoints = {p1.x,p2.x,p3.x,p4.x,p5.x,p6.x,p7.x,p8.x,p9.x,p10.x};
		int[] yPoints = {p1.y,p2.y,p3.y,p4.y,p5.y,p6.y,p7.y,p8.y,p9.y,p10.y};
		g.setColor(Color.WHITE);
		g.fillPolygon(xPoints, yPoints, 10);
		
	
	}
	
	
	public void calcRatio() {
		if(getWidth()*1.9 > getHeight()) {
			FlagHeight = getHeight();
			FlagWidth = FlagHeight*1.9;
		}

		if(getWidth()/1.9 < getHeight()) {
			FlagWidth = getWidth();
			FlagHeight = FlagWidth/1.9;

		}

	}
}



