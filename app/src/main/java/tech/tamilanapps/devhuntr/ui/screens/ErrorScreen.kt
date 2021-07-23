package tech.tamilanapps.devhuntr.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import tech.tamilanapps.devhuntr.R
import tech.tamilanapps.devhuntr.others.SERVER_ERROR_DESC
import tech.tamilanapps.devhuntr.others.SERVER_ERROR_TITLE

@Composable
fun ErrorScreen() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.server),
            contentDescription = SERVER_ERROR_TITLE )

        Text(text = SERVER_ERROR_TITLE)
        Text(text = SERVER_ERROR_DESC)
    }
}

@Preview
@Composable
fun ErrorScreenPreview() {
    ErrorScreen()
}

