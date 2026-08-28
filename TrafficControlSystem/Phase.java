package TrafficControlSystem;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Phase {
    private final String phaseName;
    private final Set<Direction> allowedDirections;
    private final int greenDurationInSeconds;
    private final int yellowDurationInSeconds;

    public Phase(
            String phaseName,
            Set<Direction> allowedDirections,
            int greenDurationInSeconds,
            int yellowDurationInSeconds) {
        if (allowedDirections == null || allowedDirections.isEmpty()) {
            throw new IllegalArgumentException("Phase must allow at least one direction.");
        }

        this.phaseName = phaseName;
        this.allowedDirections = new HashSet<>(allowedDirections);
        this.greenDurationInSeconds = greenDurationInSeconds;
        this.yellowDurationInSeconds = yellowDurationInSeconds;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public Set<Direction> getAllowedDirections() {
        return Collections.unmodifiableSet(allowedDirections);
    }

    public int getGreenDurationInSeconds() {
        return greenDurationInSeconds;
    }

    public int getYellowDurationInSeconds() {
        return yellowDurationInSeconds;
    }
}