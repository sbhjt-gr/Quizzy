package com.gorai.PhysicsWallah

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gorai.PhysicsWallah.ui.theme.PhysicsWallahTheme

val GreenTint = Color(0xFFF0FAF0)
val GreenAccent = Color(0xFF4CAF50)
val GreenBorder = Color(0xFFB8E6B8)
val OrangeTint = Color(0xFFFFFAF5)
val OrangeAccent = Color(0xFFFF9800)
val OrangeBorder = Color(0xFFFFDDB8)
val PinkTint = Color(0xFFFFF5F8)
val PinkAccent = Color(0xFFE91E63)
val PinkBorder = Color(0xFFFFC0D0)
val PurpleTint = Color(0xFFF8F5FC)
val PurpleAccent = Color(0xFF9575CD)
val PurpleBorder = Color(0xFFE0D6F0)
val BackgroundColor = Color(0xFFF5F5F5)
val CardWhite = Color(0xFFFFFFFF)
val TextPrimary = Color(0xFF212121)
val TextSecondary = Color(0xFF757575)

@Composable
fun DashboardScreen(
    userName: String = "Gaurav",
    userClass: String = "10th Class"
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .statusBarsPadding()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(8.dp)) }
        
        item { GreetingHeader(userName, userClass) }
        
        item { StatusCardsRow() }
        
        item { TodaySummaryHeader() }
        
        item { TodaySummaryCard() }
        
        item { WeeklyOverviewHeader() }
        
        item { WeeklyOverviewCard() }
        
        item { Spacer(modifier = Modifier.height(16.dp)) }
    }
}

@Composable
private fun GreetingHeader(name: String, classInfo: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Hello $name!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = classInfo,
            fontSize = 14.sp,
            color = TextSecondary
        )
    }
}

@Composable
private fun StatusCardsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        StatusCard(
            modifier = Modifier.weight(1f),
            backgroundColor = GreenTint,
            borderColor = GreenBorder,
            iconTint = GreenAccent,
            icon = null,
            iconRes = R.drawable.ic_availability,
            title = "Availability",
            value = "Present"
        )
        StatusCard(
            modifier = Modifier.weight(1f),
            backgroundColor = OrangeTint,
            borderColor = OrangeBorder,
            iconTint = OrangeAccent,
            icon = null,
            iconRes = R.drawable.ic_quiz,
            title = "Quiz",
            value = "3 Attempt"
        )
        StatusCard(
            modifier = Modifier.weight(1f),
            backgroundColor = PinkTint,
            borderColor = PinkBorder,
            iconTint = PinkAccent,
            icon = null,
            iconRes = R.drawable.ic_target,
            title = "Accuracy",
            value = "72%"
        )
    }
}

@Composable
private fun StatusCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    borderColor: Color,
    iconTint: Color,
    icon: ImageVector? = null,
    iconRes: Int? = null,
    title: String,
    value: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, borderColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = iconTint,
                    modifier = Modifier.size(28.dp)
                )
            } else if (iconRes != null) {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = title,
                    tint = iconTint,
                    modifier = Modifier.size(28.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = title,
                fontSize = 13.sp,
                color = TextSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = iconTint
            )
        }
    }
}

@Composable
private fun TodaySummaryHeader() {
    Text(
        text = "Today's Summary",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = TextPrimary
    )
}

@Composable
private fun TodaySummaryCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = PurpleTint),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, PurpleBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_search_focus),
                contentDescription = "Focus",
                tint = Color.Unspecified,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Focused",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = PurpleAccent
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "\"Struggles with Apply-level Math today.\"",
                fontSize = 13.sp,
                color = TextSecondary
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = TextPrimary),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(vertical = 14.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Watch: Apply Pythagoras Theorem",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun WeeklyOverviewHeader() {
    Text(
        text = "Weekly Overview",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = TextPrimary
    )
}

val DividerColor = Color(0xFFEEEEEE)
val RedProgress = Color(0xFFEF5350)

@Composable
private fun WeeklyOverviewCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, DividerColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            QuizStreakSection()
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(DividerColor)
            )
            Spacer(modifier = Modifier.height(20.dp))
            AccuracySection()
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(DividerColor)
            )
            Spacer(modifier = Modifier.height(20.dp))
            PerformanceSection()
        }
    }
}

@Composable
private fun FlashcardIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val cardW = w * 0.5f
        val cardH = h * 0.75f
        val cornerR = w * 0.04f
        val stroke = w * 0.02f
        
        rotate(-12f, pivot = Offset(w * 0.35f, h * 0.5f)) {
            drawRoundRect(
                color = Color(0xFFFBC02D),
                topLeft = Offset(w * 0.08f, h * 0.08f),
                size = Size(cardW, cardH),
                cornerRadius = CornerRadius(cornerR),
                style = Fill
            )
            drawRoundRect(
                color = Color(0xFF1B2124),
                topLeft = Offset(w * 0.08f, h * 0.08f),
                size = Size(cardW, cardH),
                cornerRadius = CornerRadius(cornerR),
                style = Stroke(width = stroke)
            )
        }
        
        rotate(12f, pivot = Offset(w * 0.65f, h * 0.5f)) {
            drawRoundRect(
                color = Color(0xFF64B5F6),
                topLeft = Offset(w * 0.42f, h * 0.05f),
                size = Size(cardW, cardH),
                cornerRadius = CornerRadius(cornerR),
                style = Fill
            )
            drawRoundRect(
                color = Color(0xFF1B2124),
                topLeft = Offset(w * 0.42f, h * 0.05f),
                size = Size(cardW, cardH),
                cornerRadius = CornerRadius(cornerR),
                style = Stroke(width = stroke)
            )
        }
        
        drawRoundRect(
            color = Color(0xFFF5F5F5),
            topLeft = Offset(w * 0.22f, h * 0.2f),
            size = Size(cardW * 1.1f, cardH * 0.95f),
            cornerRadius = CornerRadius(cornerR),
            style = Fill
        )
        drawRoundRect(
            color = Color(0xFF1B2124),
            topLeft = Offset(w * 0.22f, h * 0.2f),
            size = Size(cardW * 1.1f, cardH * 0.95f),
            cornerRadius = CornerRadius(cornerR),
            style = Stroke(width = stroke)
        )
        
        val qX = w * 0.5f
        val qY = h * 0.58f
        val qSize = w * 0.18f
        drawCircle(
            color = Color(0xFF757575),
            radius = qSize * 0.08f,
            center = Offset(qX, qY + qSize * 0.5f)
        )
        val path = Path().apply {
            moveTo(qX - qSize * 0.15f, qY - qSize * 0.4f)
            cubicTo(
                qX - qSize * 0.15f, qY - qSize * 0.7f,
                qX + qSize * 0.15f, qY - qSize * 0.7f,
                qX + qSize * 0.15f, qY - qSize * 0.35f
            )
            cubicTo(
                qX + qSize * 0.15f, qY - qSize * 0.1f,
                qX, qY,
                qX, qY + qSize * 0.2f
            )
        }
        drawPath(
            path = path,
            color = Color(0xFF757575),
            style = Stroke(width = stroke * 1.5f)
        )
    }
}

@Composable
private fun QuizStreakSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Quiz Streak",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            FlashcardIcon(modifier = Modifier.size(44.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-4).dp)
                .height(1.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color.White, Color(0xFF1B2124))
                    )
                )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val days = listOf("M", "T", "W", "T", "F", "S", "S")
            days.forEachIndexed { index, day ->
                when {
                    index < 4 -> StreakIndicator(state = StreakState.COMPLETED)
                    index == 4 -> StreakIndicator(state = StreakState.CURRENT)
                    else -> StreakIndicator(state = StreakState.PENDING, label = day)
                }
            }
        }
    }
}

enum class StreakState { COMPLETED, CURRENT, PENDING }

@Composable
private fun StreakIndicator(state: StreakState, label: String = "") {
    Box(
        modifier = Modifier
            .size(36.dp)
            .then(
                when (state) {
                    StreakState.COMPLETED -> Modifier
                        .clip(CircleShape)
                        .background(GreenAccent)
                    StreakState.CURRENT -> Modifier
                        .clip(CircleShape)
                        .background(GreenAccent)
                        .then(
                            Modifier.padding(2.dp)
                        )
                    StreakState.PENDING -> Modifier
                        .clip(CircleShape)
                        .background(Color.Transparent)
                        .then(
                            Modifier.drawDashedBorder()
                        )
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            StreakState.COMPLETED, StreakState.CURRENT -> {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Completed",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
            StreakState.PENDING -> {
                Text(
                    text = label,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextSecondary
                )
            }
        }
    }
}

private fun Modifier.drawDashedBorder(): Modifier = this.then(
    Modifier.drawBehind {
        val strokeWidth = 1.5.dp.toPx()
        val radius = size.minDimension / 2
        drawCircle(
            color = Color(0xFFBDBDBD),
            radius = radius - strokeWidth / 2,
            style = androidx.compose.ui.graphics.drawscope.Stroke(
                width = strokeWidth,
                pathEffect = androidx.compose.ui.graphics.PathEffect.dashPathEffect(
                    floatArrayOf(8f, 6f), 0f
                )
            )
        )
    }
)

@Composable
private fun AccuracySection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Accuracy",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "68% correct",
                    fontSize = 14.sp,
                    color = TextSecondary
                )
            }
            AccuracyIcon(modifier = Modifier.size(40.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0xFFFFE0E0))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.68f)
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(RedProgress)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .offset(y = (-4).dp)
                .background(Brush.horizontalGradient(listOf(Color.White, Color(0xFF1B2124))))
        )
    }
}

@Composable
private fun AccuracyIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val outerRadius = size.minDimension / 2 * 0.9f
        val red = Color(0xFFED1D31)
        val white = Color(0xFFF1F2F2)
        val stroke = Color(0xFF1B2124)
        val strokeWidth = 1.dp.toPx()
        drawCircle(color = red, radius = outerRadius, center = Offset(centerX, centerY))
        drawCircle(color = stroke, radius = outerRadius, center = Offset(centerX, centerY), style = Stroke(width = strokeWidth))
        val ring1 = outerRadius * 0.78f
        drawCircle(color = white, radius = ring1, center = Offset(centerX, centerY))
        val ring2 = outerRadius * 0.52f
        drawCircle(color = red, radius = ring2, center = Offset(centerX, centerY))
        val centerDot = outerRadius * 0.26f
        drawCircle(color = white, radius = centerDot, center = Offset(centerX, centerY))
    }
}

@Composable
private fun PerformanceSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Performance by Topic",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_chart),
            contentDescription = "Chart",
            tint = Color.Unspecified,
            modifier = Modifier.size(40.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview() {
    PhysicsWallahTheme {
        DashboardScreen()
    }
}
