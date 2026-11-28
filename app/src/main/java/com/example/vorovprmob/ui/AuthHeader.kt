package com.example.vorovprmob.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vorovprmob.R

@Composable
fun AuthHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier.weight(1f).height(1.dp)) {
            drawLine(
                color = Color.LightGray,
                start = Offset(0f, center.y),
                end = Offset(size.width, center.y),
                strokeWidth = 2f
            )
        }

        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(64.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(48.dp)
            )
        }

        Canvas(modifier = Modifier.weight(1f).height(1.dp)) {
            drawLine(
                color = Color.LightGray,
                start = Offset(0f, center.y),
                end = Offset(size.width, center.y),
                strokeWidth = 2f
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, widthDp = 350)
@Composable
fun AuthHeaderPreview() {
    AuthHeader()
}