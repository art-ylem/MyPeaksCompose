package com.sidorov.mypeakscompose.screens.routes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sidorov.mypeakscompose.R
import com.sidorov.mypeakscompose.data.vo.RouteVO
import com.sidorov.mypeakscompose.screens.MainScreenViewModel

@Composable
fun RouteItem(
    route: RouteVO,
    mainScreenViewModel: MainScreenViewModel,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.mountain_placeholder),
                contentDescription = "route's image",
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp))
                    .height(180.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,

            )
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                Text(text = route.name)
                Text(text = route.location)
                Text(text = route.difficulty)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .padding(start = 12.dp, top = 8.dp)
                ) {
                    Button(
                        onClick = { mainScreenViewModel.showBottomNavBar() },
                        modifier = Modifier
                            .border(
                                1.dp,
                                Color(R.color.purple_700),
                                RoundedCornerShape(8.dp)
                            )
                            .clip(RoundedCornerShape(8.dp)),

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent
                        ),
                        elevation = ButtonDefaults.elevation(0.dp)

                    ) {
                        Icon(
                            modifier = Modifier.padding(end = 8.dp, start = 0.dp),
                            painter = painterResource(R.drawable.ic_go),
                            contentDescription = "climb the mountain"
                        )
                        Text(text = "Go")
                    }
                }

                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable { mainScreenViewModel.hideBottomNavBar() }
                        .padding(16.dp),
                    painter = painterResource(R.drawable.ic_download_24),
                    contentDescription = "climb the mountain",

                )
            }
        }
    }
}
