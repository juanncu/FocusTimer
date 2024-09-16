package com.example.focustimer.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustimer.presentation.theme.FocusTimerTheme

@Composable
fun AutoRezisedText(
  modifier: Modifier = Modifier,
  text: String,
  textStyle: TextStyle = MaterialTheme.typography.bodyLarge
) {
  var timeTextStyle by remember { mutableStateOf(textStyle) }
  Text(
    text,
    modifier = modifier.fillMaxWidth(),
    softWrap = false,
    style = timeTextStyle,
    onTextLayout = { result ->
      if (result.didOverflowWidth) {
        timeTextStyle = timeTextStyle.copy(
          fontSize = timeTextStyle.fontSize * 0.95
        )
      }
    }
  )
}

@Preview(name = "AutoRezisedTextPreview", showBackground = true)
@Composable
fun AutoRezisedText_Preview() {
  FocusTimerTheme {
    AutoRezisedText(
      text = "Focus Timer"
    )
  }
}
