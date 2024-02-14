package com.example.netclanassignment.screens.explore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column


import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netclanassignment.R
import com.example.netclanassignment.domain.model.TabModel
import com.example.netclanassignment.domain.model.User
import com.example.netclanassignment.screens.MyCard
import com.example.netclanassignment.screens.TabView
import com.example.netclanassignment.ui.theme.NetclanAssignmentTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreenContent(onButtonClick:()->Unit = {}) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val list = listOf<User>(
        User("Susmit Neogi", "SN", "Within 100 m", "Student"),
        User("Kunal Khemu", "KK", "Within 200-300 m", "Data Scientist"),
        User("Rohit Salunke", "RS", "Within 800-900 m", "Lawyer"),
        User("Akshay Deshmukh", "AD", "Within 1000 m", "Android Developer"),
        User("Pavan Bhagas", "PB", "Within 300-400 m", "Teacher")
    )
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { MyTopAppBar(onButtonClick=onButtonClick) },
        bottomBar = {
            BottomAppBar(containerColor = Color.White) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                            contentDescription = null,
                            tint = Color(0xff16529a)
                        )
                        Text(text = "Explore",
                            color = Color(0xff16529a))
                    }

                }


            }
        }
    ) {
        var selectedIndex: Int by remember {
            mutableIntStateOf(0)
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            TabView(tabModels = listOf(
                TabModel(text = "Personal"),
                TabModel(text = "Business"),
                TabModel(text = "Merchant"),

                ), modifier = Modifier
                .height(50.dp), onTabSelected = {
                selectedIndex = it
            })

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = "", onValueChange = {},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = containerColor,
                        unfocusedContainerColor = containerColor,
                        disabledContainerColor = containerColor,
                        cursorColor = Color.Black, // Set cursor color
                        focusedIndicatorColor = Color.Transparent, // Hide focused border
                        unfocusedIndicatorColor = Color.Transparent, // Hide unfocused border
                        disabledIndicatorColor = Color.Transparent, // Hide disabled border
                        errorIndicatorColor = Color.Transparent, // Hide error border
                        focusedLabelColor = Color.Black, // Set focused label color
                        unfocusedLabelColor = Color.Black, // Set unfocused label color
                    ),
                    placeholder = { Text(text = "Search", fontSize = 12.sp) },
                    modifier = Modifier
                        .height(45.dp)
                        .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(30.dp)),
                    shape = RoundedCornerShape(30.dp)
                )
                Spacer(modifier = Modifier.width(40.dp))
                Icon(
                    painter = painterResource(id = R.drawable.baseline_filter_list_24),
                    contentDescription = null
                )
            }
            LazyColumn() {
                items(items = list) {
                    MyCard(
                        it.userName,
                        it.initials,
                        it.distance,
                        it.occupation

                    )
                }
            }


        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun MyTopAppBar(onButtonClick:()->Unit = {}) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xff003b77),
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        title = {
            Column {
                Text("Howdy Pranav Salunke !!", fontSize = 18.sp)
                Row {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Text("Powai, Mumbai", fontSize = 15.sp)
                }

            }

        },
        navigationIcon = {
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description",

                    tint = Color.White
                )
            }
        },
        actions = {

            IconButton(onClick = onButtonClick) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_checklist_24),
                        contentDescription = "Localized description",
                        tint = Color.White
                    )
                    Text("Refine", fontSize = 10.sp, color = Color.White)
                }
            }


        },
        scrollBehavior = scrollBehavior
    )
}

@Preview
@Composable
fun DefaultPreview(){
    NetclanAssignmentTheme {
        ExploreScreenContent()
    }
}


