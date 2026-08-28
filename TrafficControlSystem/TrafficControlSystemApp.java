package TrafficControlSystem;

import java.util.List;
import java.util.Set;

public class TrafficControlSystemApp {
    public static void main(String[] args) {
    List<TrafficLight> trafficLights = List.of(
        new TrafficLight(101, Direction.NORTH),
        new TrafficLight(102, Direction.SOUTH),
        new TrafficLight(103, Direction.EAST),
        new TrafficLight(104, Direction.WEST));

    List<Phase> phases = List.of(
        new Phase("NORTH_SOUTH", Set.of(Direction.NORTH, Direction.SOUTH), 30, 5),
        new Phase("EAST_WEST", Set.of(Direction.EAST, Direction.WEST), 30, 5));

        Intersection intersection = new Intersection(
                1,
        trafficLights,
        phases,
        new FixedTimeTrafficControlStrategy());

        TrafficControlManager trafficControlManager = new TrafficControlManager(List.of(intersection));

        System.out.println(trafficControlManager.getIntersectionStatus(1));

    trafficControlManager.tick();
        System.out.println(trafficControlManager.getIntersectionStatus(1));

    trafficControlManager.startManualOverride(1, "NORTH_SOUTH");
        System.out.println(trafficControlManager.getIntersectionStatus(1));

        trafficControlManager.stopManualOverride(1);
        System.out.println(trafficControlManager.getIntersectionStatus(1));
    }
}