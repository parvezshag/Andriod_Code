package com.example.jetpacksintroduction

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HelloWorld(name:String){
    TextComponent(
        value = "Hello $name",
        size = 18.sp,
        colorValue = Color.Magenta)
}

@Preview(showBackground = true)
@Composable
fun HelloWorldPreviewForComponent(nameValue: String ="Parvez"){
    HelloWorld(name = nameValue)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HelloWorldPreviewInMobileScreen(nameValue: String = "Zevrap") {
    HelloWorld(name = nameValue)
}

@Composable
fun TextComponent(value: String, size : TextUnit, colorValue: Color,
                  fontWeightValue: FontWeight = FontWeight.ExtraBold,
                  fontStyleValue: FontStyle = FontStyle.Normal,
                  maxLinesValue: Int? = null,
                  backgroundColorValue: Color = Color.Black){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clip( shape = RoundedCornerShape(10.dp))
            .background(backgroundColorValue)
            .border(width = 10.dp, color = Color.Magenta)
            .padding(50.dp),
        text = value,
        fontSize = size,
        color = colorValue,
        fontWeight = fontWeightValue,
        fontStyle = fontStyleValue,
        maxLines = maxLinesValue?: Int.MAX_VALUE,
        overflow = TextOverflow.Ellipsis
    )
}
