import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class PelotaComponentes extends JPanel{
	
	private ArrayList<Pelota> Pelotas = new ArrayList<Pelota>();
	private ArrayList<Barra> Barra = new ArrayList<Barra>();
	
	public void addPelota(Pelota p){
		Pelotas.add(p);
	}
	public void addBarra(Barra b){
		Barra.add(b);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Pelota p : Pelotas){
			g2.fill(p.getShape());
		}
		
		for(Barra b : Barra){
			g2.fill(b.getShape());
		}
	}

}
