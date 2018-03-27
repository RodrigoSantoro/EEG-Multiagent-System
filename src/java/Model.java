import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;
import java.util.ArrayList;
import java.util.List;

public class Model extends GridWorldModel
{
	public static final int SIGNAL = 8;
	private static final int GRID_WIDTH = 20;
	private static final int GRID_HEIGHT = 20;
	
	List<Location> signals = new ArrayList<Location>();
	
	List<Location> parietalAgent1Signals = new ArrayList<Location>();
	List<Location> parietalAgent2Signals = new ArrayList<Location>();
	
	List<Location> frontalAgent1Signals = new ArrayList<Location>();
	List<Location> frontalAgent2Signals = new ArrayList<Location>();
	
	List<Location> occipitalAgent1Signals = new ArrayList<Location>();
	List<Location> occipitalAgent2Signals = new ArrayList<Location>();
	
	List<Location> temporalAgent1Signals = new ArrayList<Location>();
	List<Location> temporalAgent2Signals = new ArrayList<Location>();
	
	
	public Model()
	{
		super(GRID_WIDTH, GRID_HEIGHT, 9);
		
		drawBrainAsGrid();
		
		setAgPos(1, 5, 4);
		setAgPos(2, 8, 4);
		setAgPos(3, 14, 4);
		setAgPos(4, 17, 4);
		setAgPos(5, 2, 13);
		setAgPos(6, 2, 16);
		setAgPos(7, 10, 14);
		setAgPos(8, 14, 14);
	}
	
	void drawBrainAsGrid() {
		addWall(0, 0, 2, 8);
		addWall(0, 9, 19, 9);
		addWall(11, 0, 11, 9);
		addWall(5, 10, 5, 19);
		addWall(19, 10, 19, 19);
	}
	
	boolean detect(int agentId) {
		lookAround(agentId);
		return true;
	}
	
	void lookAround(int agentId) {
		List<Location> tmpSignals = getAgentList(agentId);
		Location l = getAgPos(agentId);
		Location tmp1 = new Location(l.x,l.y);
		tmp1.x = l.x-1;
		tmp1.y = l.y-1;
		if(signalExists(tmp1)) {
			if(!isInAgentList(agentId, tmp1, tmpSignals)) {
				tmpSignals.add(tmp1);
			}
		}
		Location tmp2 = new Location(l.x,l.y);
		tmp2.x = l.x;
		tmp2.y = l.y-1;
		if(signalExists(tmp2)) {
			if(!isInAgentList(agentId, tmp2, tmpSignals)) {
				tmpSignals.add(tmp2);
			}
		}
		Location tmp3 = new Location(l.x,l.y);
		tmp3.x = l.x+1;
		tmp3.y = l.y-1;
		if(signalExists(tmp3)) {
			if(!isInAgentList(agentId, tmp3, tmpSignals)) {
				tmpSignals.add(tmp3);
			}
		}
		Location tmp4 = new Location(l.x,l.y);
		tmp4.x = l.x-1;
		tmp4.y = l.y;
		if(signalExists(tmp4)) {
			if(!isInAgentList(agentId, tmp4, tmpSignals)) {
				tmpSignals.add(tmp4);
			}
		}
		Location tmp5 = new Location(l.x,l.y);
		tmp5.x = l.x+1;
		tmp5.y = l.y;
		if(signalExists(tmp5)) {
			if(!isInAgentList(agentId, tmp5, tmpSignals)) {
				tmpSignals.add(tmp5);
			}
		}
		Location tmp6 = new Location(l.x,l.y);
		tmp6.x = l.x-1;
		tmp6.y = l.y+1;
		if(signalExists(tmp6)) {
			if(!isInAgentList(agentId, tmp6, tmpSignals)) {
				tmpSignals.add(tmp6);
			}
		}
		Location tmp7 = new Location(l.x,l.y);
		tmp7.x = l.x;
		tmp7.y = l.y+1;
		if(signalExists(tmp7)) {
			if(!isInAgentList(agentId, tmp7, tmpSignals)) {
				tmpSignals.add(tmp7);
			}
		}
		Location tmp8 = new Location(l.x,l.y);
		tmp8.x = l.x+1;
		tmp8.y = l.y+1;
		if(signalExists(tmp8)) {
			if(!isInAgentList(agentId, tmp8, tmpSignals)) {
				tmpSignals.add(tmp8);
			}
		}
	}
	
	List<Location> getAgentList(int agentId) {
		if(agentId == 1) {
			return parietalAgent1Signals; 
		}
		else if (agentId == 2) {
			return parietalAgent2Signals;
		}
		else if (agentId == 3) {
			return frontalAgent1Signals;
		}
		else if (agentId == 4) {
			return frontalAgent2Signals;
		}
		else if (agentId == 5) {
			return occipitalAgent1Signals;
		}
		else if (agentId == 6) {
			return occipitalAgent2Signals;
		}
		else if (agentId == 7) {
			return temporalAgent1Signals;
		}
		else if (agentId == 8) {
			return temporalAgent2Signals;
		}
		return null;
	}
	
	boolean signalExists(Location loc)
	{
		for (int i=0; i<signals.size(); i++)
		{
			if (loc.x == signals.get(i).x && loc.y == signals.get(i).y)
				return true;
		}
		return false;
	}
	
	boolean isInAgentList(int agentId, Location l, List<Location> tmpSignals) {
		for (int i=0; i<tmpSignals.size(); i++)
		{
			if (l.x == tmpSignals.get(i).x && l.y == tmpSignals.get(i).y)
			{
				return true;
			}
		}
		return false;
	}
	
	boolean wait (int agentId)
	{
		return true;
	}
	
	public List<Location> getParietalAgent1Signals()
	{
		return parietalAgent1Signals;
	}
	
	public List<Location> getParietalAgent2Signals()
	{
		return parietalAgent2Signals;
	}
	
	public List<Location> getFrontalAgent1Signals()
	{
		return frontalAgent1Signals;
	}
	
	public List<Location> getFrontalAgent2Signals()
	{
		return frontalAgent2Signals;
	}
	
	public List<Location> getOccipitalAgent1Signals()
	{
		return occipitalAgent1Signals;
	}
	
	public List<Location> getOccipitalAgent2Signals()
	{
		return occipitalAgent2Signals;
	}
	
	public List<Location> getTemporalAgent1Signals()
	{
		return temporalAgent1Signals;
	}
	
	public List<Location> getTemporalAgent2Signals()
	{
		return temporalAgent2Signals;
	}
}