package com.gorai.PhysicsWallah

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gorai.PhysicsWallah.ui.theme.*

class WaveButtonShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val waveDepth = 40f
            val bottomRadius = 50f

            moveTo(0f, waveDepth)

            quadraticBezierTo(
                size.width * 0.5f, -waveDepth,
                size.width, waveDepth
            )

            lineTo(size.width, size.height - bottomRadius)

            quadraticBezierTo(
                size.width, size.height,
                size.width - bottomRadius, size.height
            )

            lineTo(bottomRadius, size.height)

            quadraticBezierTo(
                0f, size.height,
                0f, size.height - bottomRadius
            )

            close()
        }
        return Outline.Generic(path)
    }
}

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(QuizzyBlack)
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .offset(x = (-30).dp, y = 150.dp)
                .clip(CircleShape)
                .background(QuizzyPink.copy(alpha = 0.3f))
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .offset(x = 50.dp, y = 350.dp)
                .clip(CircleShape)
                .background(QuizzyWhite.copy(alpha = 0.1f))
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(150.dp)
                .offset(x = 50.dp, y = 100.dp)
                .clip(CircleShape)
                .background(QuizzyMint.copy(alpha = 0.2f))
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .size(80.dp)
                .offset(x = (-20).dp, y = 20.dp)
                .clip(CircleShape)
                .background(QuizzyYellow.copy(alpha = 0.2f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(QuizzyPink)
                )

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(QuizzyLightBlue)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(QuizzyMint)
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Welcome to\nQuizzy!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = QuizzyWhite,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PhysicsWallahTheme {
        LoginScreen()
    }
}