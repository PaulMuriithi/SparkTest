import com.despegar.sparkjava.test.SparkServer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.ClassRule
import org.junit.Test
import spark.servlet.SparkApplication

class TestControllerTest {

    class TestContollerTestSparkApplication : SparkApplication {
       override fun init() {
            TestController()
        }
    }

    @Test
    @Throws(Exception::class)
    fun test() {
        /* The second parameter indicates whether redirects must be followed or not */
        val get = testServer.get("/test", false)
        get.addHeader("Test-Header", "test")
        val httpResponse = testServer.execute(get)
        assertEquals(200, httpResponse.code())
        assertEquals("This works!", String(httpResponse.body()))
        assertNotNull(testServer.application)
    }

    companion object {
        @ClassRule
        var testServer: SparkServer<TestContollerTestSparkApplication> = SparkServer(TestControllerTest.TestContollerTestSparkApplication::class.java, 4567)
    }
}