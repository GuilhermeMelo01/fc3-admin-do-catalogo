package io.github.guilhermemelo01.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void mainTest() {
        Assertions.assertNotNull(new Main());
        Main.main(new String[]{});

    }
}
