package TrafficControlSystem;

import java.util.List;

public class FixedTimeTrafficControlStrategy implements TrafficControlStrategy {
    @Override
    public Phase getNextPhase(Intersection intersection) {
        List<Phase> phases = intersection.getPhases();
        int nextPhaseIndex = (intersection.getCurrentPhaseIndex() + 1) % phases.size();
        return phases.get(nextPhaseIndex);
    }
}