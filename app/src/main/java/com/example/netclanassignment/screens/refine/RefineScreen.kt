package com.example.netclanassignment.screens.refine

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RefineScreen( onButtonClick:()->Unit = {} ) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(text = "Refine") }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff003b77),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick =  onButtonClick ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description",

                            tint = Color.White
                        )
                    }
                }
            )
        }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it).background(color = Color.White)
        ) {
            RefineScreenContent(onButtonClick = onButtonClick)
        }

    }
}


@Composable
fun RefineScreenContent(modifier: Modifier = Modifier,onButtonClick:()->Unit = {}) {
    var mSelectedText by remember { mutableStateOf("") }
    Column(Modifier.padding(16.dp)) {
        Text(
            text = "Select Your Availability", modifier = Modifier.padding(vertical = 8.dp),
            color = Color(0xff003b77),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        MyDropDown()
        Text(
            text = "Add Your Status", modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            color = Color(0xff003b77),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        TextField(value = mSelectedText,
            onValueChange = { mSelectedText = it },
            singleLine = false,

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                cursorColor = Color.Black, // Set cursor color
                focusedIndicatorColor = Color.Transparent, // Hide focused border
                unfocusedIndicatorColor = Color.Transparent, // Hide unfocused border
                disabledIndicatorColor = Color.Transparent, // Hide disabled border
                errorIndicatorColor = Color.Transparent, // Hide error border
                focusedLabelColor = Color.Black, // Set focused label color
                unfocusedLabelColor = Color.Black,
                unfocusedTextColor = Color(0xff003b77),
                focusedTextColor = Color(0xff003b77)// Set unfocused label color
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text(
                    text = "Hi community! I am open to new connections \uD83D\uDE0A",
                    color = Color(0xff003b77)
                )
            }
        )
        var selectedDistance by remember { mutableStateOf(49) }
        val interactionSource = remember { MutableInteractionSource() }

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Select Hyper local Distance",
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = Color(0xff003b77),
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Slider(
                value = selectedDistance.toFloat(),
                onValueChange = { newValue ->
                    selectedDistance = newValue.toInt()
                },
                valueRange = 1f..100f,
                steps = 99,
                modifier = Modifier.fillMaxWidth(),
                interactionSource = interactionSource,
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xff003b77),
                    activeTickColor = Color(0xff003b77), inactiveTickColor = Color.White,
                    activeTrackColor = Color(0xff003b77)
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "1 Km", color = Color(0xff003b77))
                Text(text = "100 Km", color = Color(0xff003b77))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .wrapContentSize()
                    .background(color = Color(0xff003b77)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$selectedDistance Km",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White
                )
            }
            Text(
                text = "Select Purpose",
                modifier = Modifier.padding(bottom = 16.dp, top = 8.dp),
                color = Color(0xff003b77),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OptionButton(label = "Coffee", color = Color(0xff003b77), tColor = Color.White)
                OptionButton(label = "Business", color = Color(0xff003b77), tColor = Color.White)
                OptionButton(label = "Hobbies")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OptionButton(label = "Friendship", color = Color(0xff003b77), tColor = Color.White)
                OptionButton(label = "Movies")
                OptionButton(label = "Dining") // Corrected spelling
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OptionButton(label = "Dating")

            }

            Spacer(modifier = Modifier.height(32.dp))


            Button(
                onClick = onButtonClick ,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff003b77),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Save & Explore")
            }
        }
    }
}

@Composable
fun MyDropDown() {


    var mExpanded by remember { mutableStateOf(false) }


    val msgs = listOf(
        "Available | Hey Let Us Connect",
        "Away | Stay Discrete And Watch",
        "Busy | Do not Disturb | Will Catch Up Later"
    )


    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }


    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column() {


        TextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .onGloballyPositioned { coordinates ->

                    mTextFieldSize = coordinates.size.toSize()
                }
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                cursorColor = Color.Black, // Set cursor color
                focusedIndicatorColor = Color.Transparent, // Hide focused border
                unfocusedIndicatorColor = Color.Transparent, // Hide unfocused border
                disabledIndicatorColor = Color.Transparent, // Hide disabled border
                errorIndicatorColor = Color.Transparent, // Hide error border
                focusedLabelColor = Color.Black, // Set focused label color
                unfocusedLabelColor = Color.Black,
                unfocusedTextColor = Color(0xff003b77),
                focusedTextColor = Color(0xff003b77)// Set unfocused label color
            ),
            placeholder = {
                Text(
                    text = "Available | Hey Let Us Connect",
                    color = Color(0xff003b77)
                )
            },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )


        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
        ) {
            msgs.forEach { label ->
                DropdownMenuItem(onClick = {
                    mSelectedText = label
                    mExpanded = false
                }, text = {
                    Text(text = label)
                })
            }
        }


    }
}

@Composable
fun OptionButton(label: String, color: Color = Color.White, tColor: Color = Color(0xff003b77),onClicked:()->Unit = {}) {
    var isClicked by remember { mutableStateOf(false) }

    Button(
        onClick = {isClicked = !isClicked},
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color, contentColor = tColor),
        border = BorderStroke(1.dp, Color.Black), // Add this line to set the border color
        modifier = Modifier.padding(end = 8.dp)
    ) {
        Text(text = label)
    }
}

