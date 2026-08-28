package TrafficControlSystem;

import java.util.List;

public class TrafficControlManager {
    private final List<Intersection> intersections;

    public TrafficControlManager(List<Intersection> intersections) {
        this.intersections = intersections;
    }

    public void tick() {
        for (Intersection intersection : intersections) {
            intersection.advance();
        }
    }

    public void startManualOverride(int intersectionId, String phaseName) {
        findIntersection(intersectionId).startManualOverride(phaseName);
    }

    public void stopManualOverride(int intersectionId) {
        findIntersection(intersectionId).stopManualOverride();
    }

    public String getIntersectionStatus(int intersectionId) {
        return findIntersection(intersectionId).getStatus();
    }

    private Intersection findIntersection(int intersectionId) {
        return intersections.stream()
                .filter(intersection -> intersection.getIntersectionId() == intersectionId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Intersection not found."));
    }
}