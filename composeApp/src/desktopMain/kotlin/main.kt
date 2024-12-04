import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import net.propertyApp.koinCommon
import net.propertyApp.ui.App
import net.propertyApp.ui.common.koinInstance
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(koinCommon)
    }.let {
        koinInstance = it.koin
    }
    application {
        Window(onCloseRequest = ::exitApplication, title = "Aviv property App") {
            App()
        }
    }
}