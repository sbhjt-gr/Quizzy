package com.gorai.PhysicsWallah

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gorai.PhysicsWallah.ui.theme.PhysicsWallahTheme

private val NotifPeach = Color(0xFFFFF3E8)
private val NotifPeachAccent = Color(0xFFFF9800)
private val NotifPurple = Color(0xFFF3E8FF)
private val NotifPurpleAccent = Color(0xFF9C27B0)
private val NotifGreen = Color(0xFFE8F5E9)
private val NotifGreenAccent = Color(0xFF4CAF50)
private val SettingsWhite = Color(0xFFFFFFFF)
private val LogoutRed = Color(0xFFE53935)

@Composable
fun SettingsScreen(onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SettingsWhite)
            .statusBarsPadding()
    ) {
        SettingsTopBar(onBackClick)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { SectionTitle("Notifications") }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item {
                NotificationCard(
                    title = "Missed quiz in physics in yesterday",
                    subtitle = "2 hours ago",
                    bgColor = NotifPeach,
                    accentColor = NotifPeachAccent
                )
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item {
                NotificationCard(
                    title = "Badge earned",
                    subtitle = "8 hours ago",
                    bgColor = NotifPurple,
                    accentColor = NotifPurpleAccent
                )
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item {
                NotificationCard(
                    title = "Teacher Note",
                    subtitle = "1 day ago",
                    bgColor = NotifGreen,
                    accentColor = NotifGreenAccent
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item { SectionTitle("Settings") }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                SettingsRow(
                    icon = Icons.Filled.Person,
                    title = "Switch Child",
                    subtitle = "Change active child profile"
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                SettingsRowPainter(
                    iconRes = R.drawable.ic_globe,
                    title = "Language",
                    subtitle = "English"
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                SettingsRow(
                    icon = Icons.AutoMirrored.Filled.ExitToApp,
                    title = "Logout",
                    subtitle = "Sign out of your account",
                    iconTint = LogoutRed,
                    titleColor = LogoutRed
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Composable
private fun SettingsTopBar(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back",
                tint = TextPrimary,
                modifier = Modifier.size(28.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Notifications & Settings",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )
        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.size(48.dp))
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold,
        color = TextPrimary
    )
}

@Composable
private fun NotificationCard(
    title: String,
    subtitle: String,
    bgColor: Color,
    accentColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .width(6.dp)
                    .height(72.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
                    .background(accentColor)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    fontSize = 12.sp,
                    color = TextSecondary
                )
            }
        }
    }
}

@Composable
private fun SettingsRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    iconTint: Color = TextPrimary,
    titleColor: Color = TextPrimary
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = iconTint,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = titleColor
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = TextSecondary
            )
        }
    }
}

@Composable
private fun SettingsRowPainter(
    iconRes: Int,
    title: String,
    subtitle: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            tint = TextPrimary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = TextSecondary
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsScreenPreview() {
    PhysicsWallahTheme {
        SettingsScreen()
    }
}
