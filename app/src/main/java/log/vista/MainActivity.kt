package log.vista

import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.event_pulse.EventLogix
import log.vista.ui.theme.LogVistaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogVistaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        val uuid = "023e3840c25911eda879027e1f50607e"
        EventLogix().simpleToast(this, "Hello from EventLogix!")

//        Handler().postDelayed({
//            EventLogix().callEvent(this, "App Started", uuid)
//        }, 4000)
//        Handler().postDelayed({
//            EventLogix().callEvent(this, "Today Visited", uuid)
//        }, 6000)
//        Handler().postDelayed({
//            EventLogix().callEvent(this, "Mind Visited", uuid)
//        }, 8000)
//        Handler().postDelayed({
//            EventLogix().callEvent(this, "Meditation Details", uuid)
//        }, 10000)
//        Handler().postDelayed({
//            EventLogix().callEvent(this, "Meditation Started", uuid)
//        }, 12000)
//        Handler().postDelayed({
//            EventLogix().callEvent(this, "Meditation Feedback", uuid)
//        }, 14000)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LogVistaTheme {
        Greeting("Android")
    }
}