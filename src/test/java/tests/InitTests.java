package tests;

import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.constants.AppInfo;

public class InitTests {

    protected SoftAssertions softAssertions;

    @BeforeAll
    static void setup() throws JSONException {
        RestAssured.baseURI = AppInfo.GENERAL_ENVIRONMENT_DATA.getProperty("HOST");
        RestAssured.basePath = AppInfo.BASE_PATH;
    }

    @BeforeEach
    void setUp() {
        softAssertions = new SoftAssertions();
    }

    @AfterEach
    void tearDown() {
        softAssertions.assertAll();
    }

}
