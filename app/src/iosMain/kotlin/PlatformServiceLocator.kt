import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.ios.Ios

@ThreadLocal
actual object PlatformServiceLocator {

    actual val httpClientEngine: HttpClientEngine by lazy {
        Ios.create()
    }
}