package com.example.daysjetpack

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.daysjetpack.model.DayRepo
import com.example.daysjetpack.model.Days
import com.example.daysjetpack.ui.theme.DaysJetpackTheme


@Composable
fun DayCardItem(day: Days,index: Int,modifier: Modifier = Modifier) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.primaryContainer else
        MaterialTheme.colorScheme.secondaryContainer
    )
    Card(
        modifier = modifier
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ){
        Column (
            Modifier
                .background(color = color)
                .animateContentSize(
                    animationSpec = spring(
                        stiffness = Spring.StiffnessMediumLow,
                        dampingRatio = Spring.DampingRatioLowBouncy
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                DayImage(
                    visible = !expanded, imageRes = day.imageRes, modifier = Modifier
                        .size(64.dp)
                        .clip(MaterialTheme.shapes.small)
                )
                DayInfo(
                    titleRes = day.titleRes,
                    dayNo = String.format("Day%d :", index + 1),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .weight(1f)
                )
                DayExpandButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            if (expanded)
                DayDescription(day = day, modifier = Modifier.padding(16.dp))

        }
    }
}

@Composable
fun DayImage(visible:Boolean, @DrawableRes imageRes: Int, modifier: Modifier = Modifier) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + expandHorizontally(),
        exit = fadeOut() + shrinkHorizontally()
    ){
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DayInfo(@StringRes titleRes: Int, dayNo: String, modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        Text(
            text = dayNo,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = stringResource(id = titleRes),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

@Composable
fun DayExpandButton(expanded: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(id = R.string.expand_button)
        )
    }
}

@Composable
fun DayDescription(day: Days, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = day.imageRes),
            contentDescription = null,
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .clip(MaterialTheme.shapes.large)
        )
        Text(
            text = stringResource(id = day.descRes),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun DayScreenList(days: List<Days>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(days.subList(0,20)) { index, day ->
            DayCardItem(day = day, index = index)
        }
        item {
            Text(
                text = "Project",
                style = MaterialTheme.typography.titleMedium,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
        }
        itemsIndexed(days.subList(20, days.size)) { index, day ->
            DayCardItem(day = day, index = index)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    DaysJetpackTheme {
        DayScreenList(days = DayRepo.days)
    }
}
