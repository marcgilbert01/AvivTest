import androidx.compose.ui.window.ComposeUIViewController
import net.propertyApp.koinCommon
import net.propertyApp.ui.App
import net.propertyApp.ui.common.koinInstance
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    startKoin {
        modules(koinCommon)
    }.let {
        koinInstance = it.koin
    }
    return ComposeUIViewController {
        App()
    }
}