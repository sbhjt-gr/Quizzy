package com.gorai.PhysicsWallah

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
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
                size.width * 0.25f, size.height,
                size.width * 0.25f, 0f,
                size.width * 0.5f, 0f
            )
            
            cubicTo(
                size.width * 0.75f, 0f,
                size.width * 0.75f, size.height,
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

        Image(
            painter = painterResource(id = R.drawable.ic_pw),
            contentDescription = "Quizzy Icon",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 16.dp, y = 40.dp)
                .size(48.dp)
                .rotate(110f)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Welcome to\nQuizzy!",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = QuizzyWhite,
                textAlign = TextAlign.Center,
                lineHeight = 58.sp
            )
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .offset(y = 20.dp),
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
                            fontSize = 16.sp,
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
                        .width(220.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Sign in",
                            fontSize = 16.sp,
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
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val borderColor = if (isFocused) QuizzyBlack else QuizzyBlack.copy(alpha = 0.15f)
    val borderWidth = if (isFocused) 1.dp else 1.dp

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        interactionSource = interactionSource,
        textStyle = LocalTextStyle.current.copy(color = QuizzyBlack),
        modifier = Modifier.fillMaxWidth(),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(QuizzyInputBg, RoundedCornerShape(20.dp))
                    .border(borderWidth, borderColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                if (value.isEmpty()) {
                    Text(text = label, color = QuizzyBlack.copy(alpha = 0.4f))
                }
                innerTextField()
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PhysicsWallahTheme {
        LoginScreen()
    }
}