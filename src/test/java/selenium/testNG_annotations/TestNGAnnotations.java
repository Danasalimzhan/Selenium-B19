package selenium.testNG_annotations;

import org.testng.annotations.BeforeSuite;

public class TestNGAnnotations {
    // Test Next Generation
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite Annotation");
    }
}
