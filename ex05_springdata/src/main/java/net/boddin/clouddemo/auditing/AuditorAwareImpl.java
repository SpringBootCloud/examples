package net.boddin.clouddemo.auditing;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "Mike Boddin";
    }
}
