import jason.asSyntax.*;
import jason.environment.*;
import jason.environment.grid.Location;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.util.logging.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends Environment {

    private Logger logger = Logger.getLogger("finalproject."+World.class.getName());
    
    private static final Literal wait = Literal.parseLiteral("wait");
    private static final Literal detect = Literal.parseLiteral("detect");
    private static final Literal parietal_signal_detected = Literal.parseLiteral("parietal_signal_detected");
    private static final Literal frontal_signal_detected = Literal.parseLiteral("frontal_signal_detected");
    private static final Literal occipital_signal_detected = Literal.parseLiteral("occipital_signal_detected");
    private static final Literal temporal_signal_detected = Literal.parseLiteral("temporal_signal_detected");
    private static final Literal nothing_detected = Literal.parseLiteral("nothing_detected");
    
    Model model;
    
    JPanel panelImg;
    JFrame frame;
    
    boolean frontal = false;
    boolean occipital = false;
    boolean parietal = false;
    boolean temporal = false;
    

    /** Called before the MAS execution with the args informed in .mas2j */
    
    @Override
    public void init(String[] args) {
        super.init(args);
        model = new Model();
        View view = new View(model);
        model.setView(view);
        
        frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelImg = new JPanel() {
			private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g) {
        			Image img = new ImageIcon("brain.jpg").getImage();
        			Dimension size = new Dimension(700, 700);
        			setPreferredSize(size);
        			setMinimumSize(size);
        			setMaximumSize(size);
        			setSize(size);
        			setLayout(null);
        			g.drawImage(img, 0, 0, 700, 500, this);
        			if (parietal) {
        				g.setColor(Color.BLACK);
        				g.fillOval(250, 125, 100, 100);
        			}
        			if (frontal) {
        				g.setColor(Color.BLACK);
        				g.fillOval(450, 125, 100, 100);
        			}
        			if (occipital) {
        				g.setColor(Color.BLACK);
        				g.fillOval(150, 225, 100, 100);
        			}
        			if (temporal) {
        				g.setColor(Color.BLACK);
        				g.fillOval(300, 225, 100, 100);
        			}
            }
        };
        panelImg.setSize(700, 700);
        frame.add(panelImg);
        frame. setSize(700, 500);
        frame.setVisible(true);
        
        
        
        try { Thread.sleep(500); } catch (InterruptedException x) { }
        updatePercepts();
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        
    	boolean result = false;
    	
        int agentId = 0;
	    if (agName.equals("parietal_agent1"))
    			agentId=1;
	    else if (agName.equals("parietal_agent2"))
			agentId=2;
	    else if (agName.equals("frontal_agent1"))
			agentId=3;
	    else if (agName.equals("frontal_agent2"))
			agentId=4;
	    else if (agName.equals("occipital_agent1"))
			agentId=5;
	    else if (agName.equals("occipital_agent2"))
			agentId=6;
	    else if (agName.equals("temporal_agent1"))
			agentId=7;
	    else if (agName.equals("temporal_agent2"))
			agentId=8;
    	
        
	    	if (action.equals(wait))
	    		result = model.wait(agentId);
	    	else if (action.equals(detect))
	    		result = model.detect(agentId);
	    	else if(action.equals(parietal_signal_detected)) {
	    		parietal = true;
	    		drawStuff();
	    		result = true;
	    	}
	    	else if(action.equals(frontal_signal_detected)) {
	    		frontal = true;
	    		drawStuff();
	    		result = true;
	    	}
	    	else if(action.equals(occipital_signal_detected)) {
	    		occipital = true;
	    		drawStuff();
	    		result = true;
	    	}
	    	else if(action.equals(temporal_signal_detected)) {
	    		temporal = true;
	    		drawStuff();
	    		
	    		result = true;
	    	}
	    	else if(action.equals(nothing_detected)) {
	    		frontal = false;
	    		occipital = false;
	    		parietal = false;
	    		temporal = false;
	    		drawStuff();
	    		result = true;
	    	}
	    	else
	    		logger.info("executing: "+action+", but not implemented!");
	    	
	    	if (result) {
	    		updatePercepts();
	    		try { Thread.sleep(500); } catch (InterruptedException x) { }
	    	}
	    	
	    	return result;
    }
    
    public void drawStuff() {
		panelImg.removeAll();
		panelImg.revalidate();
		panelImg.repaint();
    }
	
	public void stop() {
        super.stop();
    }
	
	private void updatePercepts() {
		clearAllPercepts();
		int signalThreshold = 1;
		
		List<Location> signals1 = model.getParietalAgent1Signals();
		if(signals1.size() >= signalThreshold) {
			addPercept("parietal_agent1", Literal.parseLiteral("activity"));
		}
		
		List<Location> signals2 = model.getParietalAgent2Signals();
		if(signals2.size() >= signalThreshold) {
			addPercept("parietal_agent2", Literal.parseLiteral("activity"));
		}
		
		List<Location> signals3 = model.getFrontalAgent1Signals();
		if(signals3.size() >= signalThreshold) {
			addPercept("frontal_agent1", Literal.parseLiteral("activity"));
		}
		
		List<Location> signals4 = model.getFrontalAgent2Signals();
		if(signals4.size() >= signalThreshold) {
			addPercept("frontal_agent2", Literal.parseLiteral("activity"));
		}
		
		List<Location> signals5 = model.getOccipitalAgent1Signals();
		if(signals5.size() >= signalThreshold) {
			addPercept("occipital_agent1", Literal.parseLiteral("activity"));
		}
		
		List<Location> signals6 = model.getOccipitalAgent2Signals();
		if(signals6.size() >= signalThreshold) {
			addPercept("occipital_agent2", Literal.parseLiteral("activity"));
		}
		
		List<Location> signals7 = model.getTemporalAgent1Signals();
		if(signals7.size() >= signalThreshold) {
			addPercept("temporal_agent1", Literal.parseLiteral("activity"));
		}
		
		List<Location> signals8 = model.getTemporalAgent2Signals();
		if(signals8.size() >= signalThreshold) {
			addPercept("temporal_agent2", Literal.parseLiteral("activity"));
		}
	}
}