package tech.tamilanapps.devhuntr.database.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import tech.tamilanapps.devhuntr.database.dao.FrameWorkDao
import tech.tamilanapps.devhuntr.database.entity.FrameWorkEntity
import javax.inject.Inject

@HiltViewModel
class FrameworkViewModel @Inject constructor(
    var frameWorkDao: FrameWorkDao
) :ViewModel() {

    val framework:MutableState<String> = mutableStateOf("")
    val frameworkEndpoint:MutableState<String> = mutableStateOf("")

    fun getFramework() = viewModelScope.launch {

        val frameWorkEntity = frameWorkDao.getFramework()

            framework.value = frameWorkEntity.framework
            frameworkEndpoint.value = frameWorkEntity.frameworkEndpoint

    }


}