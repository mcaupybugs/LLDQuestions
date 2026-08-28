package TrafficControlSystem;

public interface TrafficControlStrategy {
    Phase getNextPhase(Intersection intersection);
}