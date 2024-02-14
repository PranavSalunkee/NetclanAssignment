package com.example.netclanassignment.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netclanassignment.domain.model.TabModel

@Composable
fun TabView(
    modifier: Modifier = Modifier,
    tabModels: List<TabModel>,
    onTabSelected: (selectedIndex: Int) -> Unit,

    ) {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    TabRow(
        selectedTabIndex = selectedIndex,

        contentColor = Color.White,
        containerColor = Color(0xff16529a),
        modifier = modifier
    ) {

        tabModels.forEachIndexed { index, item ->
            Tab(
                selected = selectedIndex == index, onClick = {
                    selectedIndex = index
                    onTabSelected(index)
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color(0xFFa2abc0),
                modifier = Modifier.height(50.dp)
            ) {
                Text(text = item.text)
            }
        }

    }

}

@Composable
@Preview
fun MyCard(
    userName: String = "",
    initials: String = "",
    distance: String = "",
    occupation: String = "",
    modifier: Modifier = Modifier,

    ) {
    Card(
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {


                Column(Modifier.fillMaxWidth()) {

                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        TextButton(
                            onClick = { /* Handle invite button click */ },
                            modifier = Modifier
                        ) {
                            Text(text = "+ INVITE", color = Color(0xff16529a), fontSize = 18.sp)
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.LightGray)

                        ) {
                            Text(
                                text = initials,
                                fontSize = 35.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(10.dp),
                                color = Color(0xff16529a)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        // User Info (Column)
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = userName, fontWeight = FontWeight.Bold, fontSize = 18.sp,
                                color = Color(0xff16529a))
                            Text(text = "Mumbai | ${occupation}", fontSize = 18.sp,
                                color = Color(0xff16529a))
                            Text(text = distance, fontWeight = FontWeight.Bold, fontSize = 18.sp,
                                color = Color(0xff16529a))
                            Spacer(modifier = Modifier.height(8.dp))
                            LinearProgressIndicator(
                                progress = 0.3f,
                                color = Color.Black,
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(10.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                trackColor = Color.LightGray
                            )
                        }

                    }


                }


            }
            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(
                    text = "Coffee | Business | Friendship",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff16529a)
                )


            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Hi community! I am open to new connections 😊", fontSize = 18.sp,
                color = Color(0xff16529a))
        }


    }

}

