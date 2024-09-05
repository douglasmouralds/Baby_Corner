package com.example.babycorner.MenuApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.babycorner.R

data class Story(val id: Int, val title: String, val imageResId: Int)

@Composable
fun StoriesList(navController: NavHostController) {
    val stories = listOf(
        Story(1, "Chapeuzinho Vermelho", R.drawable.chapeuzinho1),
        Story(2, "Os Três Porquinhos", R.drawable.pig1),
        Story(3, "O Patinho Feio", R.drawable.patinho1)
    )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(45.dp)
                        .clickable { navController.popBackStack() }
                        .padding(start = 16.dp, top = 15.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }


            items(stories) { story ->
                StoryItem(
                    title = story.title,
                    imageResId = story.imageResId,
                    onClick = { navController.navigate("storyPage/${story.id}") }
                )
            }
        }
    }

@Composable
fun StoryItem(
    title: String,

    imageResId: Int,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp)
    ) {

        StoryImage(imageResId = imageResId)
        Spacer(
            modifier = Modifier
                .width(5.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun StoryImage(imageResId: Int) {
    val painter: Painter = painterResource(id = imageResId)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(90.dp)
            .padding(8.dp)
            .clip(CircleShape)
    )
}
