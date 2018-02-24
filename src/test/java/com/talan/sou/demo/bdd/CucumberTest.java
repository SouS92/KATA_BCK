package com.talan.sou.demo.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature",
                 plugin ={"pretty","html:src/test/java/com/talan/sou/demo/bdd/htmlReports"})
public class CucumberTest {
}
