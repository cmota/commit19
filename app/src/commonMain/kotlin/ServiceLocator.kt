import data.CommitAPI
import domain.GetSpeakers
import io.ktor.client.engine.HttpClientEngine
import presentation.SpeakersListPresenter
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object ServiceLocator {

    private val commitApi by lazy { CommitAPI(PlatformServiceLocator.httpClientEngine) }

    private val getSpeakers: GetSpeakers
        get() = GetSpeakers(commitApi)

    val getSpeakersListPresenter: SpeakersListPresenter
        get() = SpeakersListPresenter(getSpeakers)
}

expect object PlatformServiceLocator {

    val httpClientEngine: HttpClientEngine
}