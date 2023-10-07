package log.vista

import android.os.Bundle
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

//{
//    "user_id": "8c36cdcf-5239-11ee-bb62-0ad32c43ca74",
//    "from_where": "Today",
//    "sub_section": "Trending",
//    "activity_type": "Meditation",
//    "purpose": "Start",
//    "activity_id": 2,
//    "activity_name":"Victorious Breath",
//    "did": "8cdecab992ac3c8a",
//    "activity_url": "https://v3.cdn.level.game/meditations/1692705443212_Andrei+Ujjayi+Breathing_03+%281%29.mp3"
//}

        val uuid = "8c36cdcf-5239-11ee-bb62-0ad32c43ca74"
        EventLogix().simpleToast(this, "Hello from EventLogix!")

//        EventLogix().callEvent(
//            this,
//            uuid,
//            "Today",
//            "Trending",
//            "Meditation",
//            "Start",
//            2,
//            "Victorious Breath",
//            "8cdecab992ac3c8a",
//            "https://v3.cdn.level.game/meditations/1692705443212_Andrei+Ujjayi+Breathing_03+%281%29.mp3"
//        )

//        Handler().postDelayed({
//            EventLogix().callEvent(
//                this,
//                uuid,
//                "Today",
//                "Trending",
//                "Meditation",
//                "Start",
//                2,
//                "Victorious Breath",
//                "8cdecab992ac3c8a",
//                "https://v3.cdn.level.game/meditations/1692705443212_Andrei+Ujjayi+Breathing_03+%281%29.mp3"
//            )
//        }, 10000)
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