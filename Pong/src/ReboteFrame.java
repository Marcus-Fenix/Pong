import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ReboteFrame extends JFrame implements KeyListener{
	
	private PelotaComponentes comp;
	
	public static final int DEFAULT_WIDTH = 1000;
	public static final int DEFAULT_HEIGHT = 700;
	
	public static final int PASOS = 10000;
	public static final int RETRASO = 7;
	
	public ReboteFrame(){
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setTitle("Rebote");
		comp = new PelotaComponentes();
		this.add(comp,BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		this.addKeyListener(this);
		this.addButton(buttonPanel, "iniciar", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addPelota();
				
			}
		});
		this.addButton(buttonPanel, "Cerrar", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		add(buttonPanel,BorderLayout.SOUTH);
		
	}
	
	public void addButton(Container c, String titulo, ActionListener listener){
		JButton bta = new JButton(titulo);
		c.add(bta);
		bta.addActionListener(listener);
	}
	
	public void addPelota(){
		Pelota p =new Pelota();
		Barra b = new Barra();
		comp.addPelota(p);
		comp.addBarra(b);
		
		for(int i = 1; i < PASOS; i++){
			try {
				p.move(comp.getBounds());
				b.move(comp.getBounds());
				comp.paintComponent(comp.getGraphics());
				Thread.sleep(RETRASO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource());
	}

}
