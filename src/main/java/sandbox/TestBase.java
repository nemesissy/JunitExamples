package sandbox;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TestBase {

    private String name = "";

    public void setUp() {
        System.out.println("Steup Called.");
    }

    public void tearDown() {
        System.out.println("Teardown Called.");
    }

    public int countTestCases() {
        return 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
