package tech.tamilanapps.devhuntr.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import tech.tamilanapps.devhuntr.R
import tech.tamilanapps.devhuntr.others.SERVER_ERROR_DESC
import tech.tamilanapps.devhuntr.others.SERVER_ERROR_TITLE

@Composable
fun ErrorScreen() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.server),
            contentDescription = SERVER_ERROR_TITLE )

        Text(
            text = SERVER_ERROR_TITLE,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = SERVER_ERROR_DESC
        )
    }
}

@Preview(showBackground = true,showSystemUi = true,device = Devices.PIXEL_4_XL)
@Composable
fun ErrorScreenPreview() {
    ErrorScreen()
}

