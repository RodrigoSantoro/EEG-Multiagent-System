import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import jason.environment.grid.GridWorldView;
import jason.environment.grid.Location;

public class View extends GridWorldView
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Model model;
	
	public View(Model _model) {
		super(_model, "My View", 700);
		model = _model;
		setVisible(true);
		repaint();
		
		Canvas C  = getCanvas();
		
		C.addMouseListener(new  MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}
			
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {
				int x = e.getX() / cellSizeW;
				int y = e.getY() / cellSizeH;
				if(e.getButton() == MouseEvent.BUTTON3) {
					removeSignalFromAgent(model.parietalAgent1Signals, x, y);
					removeSignalFromAgent(model.parietalAgent2Signals, x, y);
					
					removeSignalFromAgent(model.frontalAgent1Signals, x, y);
					removeSignalFromAgent(model.frontalAgent2Signals, x, y);
					
					removeSignalFromAgent(model.occipitalAgent1Signals, x, y);
					removeSignalFromAgent(model.occipitalAgent2Signals, x, y);
					
					removeSignalFromAgent(model.temporalAgent1Signals, x, y);
					removeSignalFromAgent(model.temporalAgent2Signals, x, y);

					model.signals.remove(new Location(x, y));
					model.remove(Model.SIGNAL, new Location(x, y));
				}
				else {
					model.signals.add(new Location(x, y));
					model.set(Model.SIGNAL, x, y);
				}
			}
		});
	}
	
	private void removeSignalFromAgent(List<Location> agentSignals, int x, int y) {
		for(int i = 0; i < agentSignals.size(); i++) {
			if(agentSignals.get(i).x == x && agentSignals.get(i).y == y) {
				agentSignals.remove(i);
			}
		}
	}
	
	@Override
	public void draw(java.awt.Graphics g, int x, int y, int object)
	{
		if (object == Model.SIGNAL) 
		{
			g.setColor(Color.BLACK);
			drawString(g, x, y, defaultFont, "####");
		}
	}
	
	@Override
	public void drawAgent(java.awt.Graphics g, int x, int y, java.awt.Color c, int id)
	{
		if (id == 1)
		{
			super.drawAgent(g, x, y, Color.RED, id);
		}
		else if (id == 2)
		{
			super.drawAgent(g, x, y, Color.RED, id);
		}
		else if (id == 3)
		{
			super.drawAgent(g, x, y, Color.YELLOW, id);
		}
		else if (id == 4)
		{
			super.drawAgent(g, x, y, Color.YELLOW, id);
		}
		else if (id == 5)
		{
			super.drawAgent(g, x, y, Color.BLUE, id);
		}
		else if (id == 6)
		{
			super.drawAgent(g, x, y, Color.BLUE, id);
		}
		else if (id == 7)
		{
			super.drawAgent(g, x, y, Color.GREEN, id);
		}
		else if (id == 8)
		{
			super.drawAgent(g, x, y, Color.GREEN, id);
		}
	}
	
}
