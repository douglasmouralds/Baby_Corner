package com.example.babycorner.MenuApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.babycorner.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.fillMaxSize

@Composable
fun PrincipalPage(navController: NavHostController) {
    val backgroundColor = Color(0xFFE0F8E0)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(1.dp))

                Text(
                    text = stringResource(R.string.title_name),
                    style = TextStyle(
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                        fontSize = 55.sp,
                        letterSpacing = 0.13.sp,
                        color = Color.Black,
                        shadow = Shadow(
                            color = Color.Gray,
                            offset = Offset(2f, 2f),
                            blurRadius = 3f
                        )
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(19.dp)
                )

                Menu(navController = navController)
            }
        }
    }

@Composable
fun Menu(navController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(6) { index ->
            when (index) {
                0 -> CustomButton(
                    text = stringResource(R.string.box_1),
                    iconRes = R.drawable.ic_book,
                    onClick = { navController.navigate("storiesList") },
                    backgroundColor = Color(0xFFFFD700)
                )
                1 -> CustomButton(
                    text = stringResource(R.string.box_2),
                    iconRes = R.drawable.ic_music,
                    onClick = { },
                    backgroundColor = Color(0xFFFFB6C1)
                )
                2 -> CustomButton(
                    text = stringResource(R.string.box_3),
                    iconRes = R.drawable.ic_agenda,
                    onClick = { navController.navigate("event_list") },
                    backgroundColor = Color(0xFF87CEFA)
                )
                3 -> CustomButton(
                    text = stringResource(R.string.box_4),
                    iconRes = R.drawable.ic_game,
                    onClick = { /* Ação do botão 4 */ },
                    backgroundColor = Color(0xFFFF69B4)
                )
                4 -> CustomButton(
                    text = stringResource(R.string.box_5),
                    iconRes = R.drawable.ic_book,
                    onClick = { /* Ação do botão 5 */ },
                    backgroundColor = Color(0xFF98FB98)
                )
                5 -> CustomButton(
                    text = stringResource(R.string.box_6),
                    iconRes = R.drawable.ic_food,
                    onClick = { /* Ação do botão 6 */ },
                    backgroundColor = Color(0xFFADD8E6)
                )
            }
        }
    }
}

@Composable
fun CustomButton(
    text: String,
    iconRes: Int,
    onClick: () -> Unit,
    backgroundColor: Color
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .aspectRatio(1f)
            .shadow(8.dp, RoundedCornerShape(30.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(30.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = text,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 20.sp,
                    shadow = Shadow(
                        color = Color.DarkGray,
                        offset = Offset(5f, 7f),
                        blurRadius = 3f
                    )
                ),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrincipalPagePreview() {
    PrincipalPage(navController = rememberNavController())
}

