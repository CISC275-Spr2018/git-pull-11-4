import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Controller {

	private Model model;
	private View view;
	
	private JFrame frame;
	private Timer t;
	private Action drawAction;
	
	public Controller(){
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		view.makeFrame();
		frame = view.getFrame();
		frame.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent event) {
				model.move(event);
			}

			@Override
			public void keyReleased(KeyEvent event) {
				model.release(event);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("KEYTYPED");
			}
			
		});
		
	}
	
    //run the simulation
	@SuppressWarnings("serial")
	public void start(){
		drawAction = new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.getRunning()){
					if(!model.getFiring()){
						model.updateLocation();
					}
				}
					
				
				view.update(model.getX(), model.getY(), model.getDirect(), model.getJumping(), model.getFiring(), model.getRunning());

			}
    	 };
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				Timer t = new Timer(view.getDrawDelay(),drawAction);
				t.start();
			}	
		}); //Let's try something else.....
	}
}
