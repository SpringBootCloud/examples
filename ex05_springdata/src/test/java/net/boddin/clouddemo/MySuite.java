package net.boddin.clouddemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContactRepositoryIntegrationTests.class,
        ContactServiceUnitTests.class
})
public class MySuite {
}
