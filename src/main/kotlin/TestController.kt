import spark.Request
import spark.Response
import spark.kotlin.get

class TestController {
    init {
        get("/test") { testMethod(request, response) }
    }

    fun testMethod(request: Request, response: Response): String {
        return "This works!"
    }
}

fun main(args: Array<String>) {
    TestController()
}