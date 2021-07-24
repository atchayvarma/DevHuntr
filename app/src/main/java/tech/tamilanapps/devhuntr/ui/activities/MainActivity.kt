package tech.tamilanapps.devhuntr.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.tamilanapps.devhuntr.database.dao.FrameWorkDao
import tech.tamilanapps.devhuntr.database.entity.FrameWorkEntity
import tech.tamilanapps.devhuntr.database.viewmodels.FrameworkViewModel
import tech.tamilanapps.devhuntr.ui.screens.ErrorScreen
import tech.tamilanapps.devhuntr.ui.theme.DevHuntrTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var frameWorkDao: FrameWorkDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        CoroutineScope(Dispatchers.IO).launch {

            frameWorkDao.insertFramework(FrameWorkEntity(framework = "android",frameworkEndpoint = "android"))
        }



        setContent {
            val frameworkViewModel:FrameworkViewModel = viewModel()
            frameworkViewModel.getFramework()
            Log.d("FW", "${frameworkViewModel.framework}")
            Log.d("FW", "${frameworkViewModel.frameworkEndpoint}")




            DevHuntrTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevHuntrTheme {
        ErrorScreen()
    }
}