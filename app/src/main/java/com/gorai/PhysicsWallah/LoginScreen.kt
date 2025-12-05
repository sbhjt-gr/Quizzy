package com.gorai.PhysicsWallah

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
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
            moveTo(0f, size.height)
            
            cubicTo(
                size.width * 0.1f, size.height,
                size.width * 0.15f, size.height * 0.65f,
                size.width * 0.32f, size.height * 0.45f
            )
            
            cubicTo(
                size.width * 0.36f, size.height * 0.25f,
                size.width * 0.4f, 0f,
                size.width * 0.5f, 0f
            )
            
            cubicTo(
                size.width * 0.6f, 0f,
                size.width * 0.64f, size.height * 0.25f,
                size.width * 0.68f, size.height * 0.45f
            )
            
            cubicTo(
                size.width * 0.85f, size.height * 0.65f,
                size.width * 0.9f, size.height,
                size.width, size.height
            )
            
            close()
        }
        return Outline.Generic(path)
    }
}

@Composable
fun LoginScreen() {
    var schoolId by remember { mutableStateOf("") }
    var studentId by remember { mutableStateOf("") }

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
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    shape = RoundedCornerShape(36.dp),
                    colors = CardDefaults.cardColors(containerColor = QuizzyWhite)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Let's Get you Signed in",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = QuizzyBlack
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        LoginInputField(
                            value = schoolId,
                            onValueChange = { schoolId = it },
                            label = "School ID"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        LoginInputField(
                            value = studentId,
                            onValueChange = { studentId = it },
                            label = "Student ID"
                        )
                        Spacer(modifier = Modifier.height(72.dp))
                    }
                }

                Surface(
                    onClick = { },
                    shape = WaveButtonShape(),
                    color = QuizzyBlack,
                    contentColor = QuizzyWhite,
                    modifier = Modifier
                        .offset(y = 20.dp)
                        .width(280.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(72.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Sign in",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
private fun LoginInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = label, color = QuizzyBlack.copy(alpha = 0.4f)) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(48.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = QuizzyLightBlue,
            unfocusedBorderColor = QuizzyInputBg,
            focusedContainerColor = QuizzyInputBg,
            unfocusedContainerColor = QuizzyInputBg,
            focusedTextColor = QuizzyBlack,
            unfocusedTextColor = QuizzyBlack,
            cursorColor = QuizzyBlack
        )
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PhysicsWallahTheme {
        LoginScreen()
    }
}