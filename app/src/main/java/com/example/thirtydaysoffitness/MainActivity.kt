package com.example.thirtydaysoffitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydaysoffitness.ui.theme.ThirtyDaysOfFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirtyDaysOfFitnessTheme {
                Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    FitnessApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessApp() {
    var doneRaw by rememberSaveable { mutableStateOf("") }
    val doneDays = doneRaw.split(",").filter { it.isNotBlank() }.map { it.toInt() }.toSet()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = { Text("30 Days Of Fitness", style = MaterialTheme.typography.displayLarge) },
                    scrollBehavior = scrollBehavior
                )
                LinearProgressIndicator(
                    progress = { doneDays.size / 30f },
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                )
                Text(
                    "${doneDays.size} of 30 days completed",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp, bottom = 4.dp)
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp, end = 16.dp,
                top = padding.calculateTopPadding() + 8.dp,
                bottom = padding.calculateBottomPadding() + 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(days, key = { it.number }) { day ->
                DayCard(
                    day = day,
                    done = day.number in doneDays,
                    onToggleDone = {
                        val updated = if (day.number in doneDays) doneDays - day.number else doneDays + day.number
                        doneRaw = updated.joinToString(",")
                    }
                )
            }
        }
    }
}

@Composable
fun DayCard(day: Day, done: Boolean, onToggleDone: () -> Unit, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = modifier.clickable { expanded = !expanded },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = if (done) MaterialTheme.colorScheme.tertiaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            Modifier.padding(16.dp).animateContentSize(
                spring(Spring.DampingRatioLowBouncy, Spring.StiffnessMediumLow)
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text(
                        "DAY ${day.number}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(day.title, style = MaterialTheme.typography.headlineSmall)
                }
                IconButton(onClick = onToggleDone) {
                    Icon(
                        imageVector = if (done) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                        contentDescription = if (done) "Mark day as not done" else "Mark day as done",
                        tint = if (done) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.secondary
                    )
                }
            }

            Spacer(Modifier.height(12.dp))
            DayImage(day)

            Row(Modifier.fillMaxWidth().padding(top = 4.dp), horizontalArrangement = Arrangement.End) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = if (expanded) "Hide details" else "Show details",
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
            if (expanded) {
                Text(day.description, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(top = 4.dp))
            }
        }
    }
}

@Composable
fun DayImage(day: Day) {
    val shape = RoundedCornerShape(16.dp)
    val context = LocalContext.current
    val drawableRes = day.imageRes ?: context.resources.getIdentifier(
        "day_%02d".format(day.number),
        "drawable",
        context.packageName
    ).takeIf { it != 0 }
    if (drawableRes != null) {
        Image(
            painter = painterResource(drawableRes),
            contentDescription = day.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().aspectRatio(16f / 9f).clip(shape)
        )
    } else {
        val hue = (day.number * 12f) % 60f + 5f
        val c1 = Color.hsv(hue, 0.85f, 0.95f)
        val c2 = Color.hsv(hue + 15f, 0.9f, 0.5f)
        Box(
            modifier = Modifier
                .fillMaxWidth().aspectRatio(16f / 9f).clip(shape)
                .background(Brush.linearGradient(listOf(c1, c2))),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "%02d".format(day.number),
                fontSize = 120.sp, fontWeight = FontWeight.Black,
                color = Color.White.copy(alpha = 0.22f)
            )
            Text(day.emoji, fontSize = 64.sp)
        }
    }
}
