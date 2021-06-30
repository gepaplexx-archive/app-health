package at.gepaplexx;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Readiness
@ApplicationScoped

public class ControlledLiveness implements HealthCheck {
    @Inject
    State state;

    @Override
    public HealthCheckResponse call() {
        if (state.liveness) {
            return HealthCheckResponse.up("alive");
        }
        return HealthCheckResponse.down("dead");
    }
}
