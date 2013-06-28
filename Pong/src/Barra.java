import java.awt.geom.Rectangle2D;


public class Barra {
	
	private static final int XSIZE = 30;
	private static final int YSIZE = 90;
	private double x = 0;
	private double y = 0;
	private double dy = 1;
	
	public void move(Rectangle2D bounds){
		y += dy;
		
		
		if(y < bounds.getMinY()){
			y = bounds.getMinY();
			dy = -dy;
		}
		if(y + YSIZE >= bounds.getMaxY()){
			y = bounds.getMaxY() - YSIZE;
			dy = -dy;
		}
	}
	
	public Rectangle2D getShape(){
		return new Rectangle2D.Double(x,y,XSIZE,YSIZE);
	}

}
