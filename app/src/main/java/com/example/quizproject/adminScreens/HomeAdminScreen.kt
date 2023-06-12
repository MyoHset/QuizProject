package com.example.quizproject.adminScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BorderColor
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.quizproject.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeAdminScreen ( ) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.personexam1))

    var isPlaying by remember { mutableStateOf(true) }

    var isAddingBatch by remember {
        mutableStateOf(false)
    }

    var addBatchTextField = remember {
        mutableStateOf("")
    }

    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying
    )

    LaunchedEffect(key1 = progress){
        if( progress == 0f){
            isPlaying = true
        }
        if ( progress == 1f){
            isPlaying = false
        }
    }

    Scaffold (
        containerColor = MaterialTheme.colorScheme.secondary,
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
            ){
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(
                        modifier = Modifier.padding(8.dp)

                    ){
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                    Text(text = "Old Question", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ))
                }
            }
        },
        content = {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),

            ){
                Column(
                    modifier = Modifier.fillMaxHeight(1f),
                    verticalArrangement = Arrangement.Bottom,

                ){
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.85f),
                        shape = RoundedCornerShape( topStart = 60.dp, topEnd = 60.dp ),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)

                    ){
                        Column(

                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    //.background(Color.LightGray)
                                    //.padding(vertical = 20.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.4f),
                            ){
                                Box(
                                    modifier = Modifier
                                        //.background(Color.Yellow)
                                        .padding(horizontal = 10.dp, vertical = 30.dp)
                                        .fillMaxWidth(0.3f)
                                        .height(300.dp),
                                    contentAlignment = Alignment.BottomStart

                                ){
                                    Text(text = "Choose your Category", style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    ))
                                }
                                Box(
                                    modifier = Modifier.height(700.dp),
                                    contentAlignment = Alignment.BottomEnd

                                ){
                                    Box(
                                        contentAlignment = Alignment.BottomEnd
                                    ){
                                        LottieAnimation(
                                            modifier = Modifier
                                                .size(600.dp),
                                            iterations = 100,
                                            composition = composition
                                        )

                                    }

                                }
                            }

                            Column(
                                modifier = Modifier.padding(top = 40.dp),
                                horizontalAlignment = Alignment.CenterHorizontally

                            ){

                                Button(
                                    onClick = {
                                              isAddingBatch = !isAddingBatch
                                    },
                                    modifier = Modifier
                                        .padding(
                                            horizontal = 20.dp,
                                            vertical = 20.dp
                                        )
                                        .fillMaxWidth()
                                        .height(60.dp),
                                    border = BorderStroke(1.dp, Color.Black),
                                    elevation = ButtonDefaults.buttonElevation(5.dp),
                                ) {
                                    Icon(imageVector = Icons.Default.Add, contentDescription = "add")

                                }

                                if ( isAddingBatch ) {

                                    AlertDialog(
                                        onDismissRequest = { isAddingBatch = false },
                                        title = { Text(text = "Enter Batch name", style = TextStyle(
                                            color = Color.Black
                                        )
                                        ) },
                                        containerColor = MaterialTheme.colorScheme.secondary,
                                        icon = {
                                               Icon(imageVector = Icons.Default.BorderColor, contentDescription = "Heart", tint = MaterialTheme.colorScheme.primary )
                                        },
                                        text = {

                                            OutlinedTextField(
                                                value = addBatchTextField.value,
                                                onValueChange = { addBatchTextField.value = it },
                                                colors = OutlinedTextFieldDefaults.colors(
                                                    unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                                                    focusedContainerColor = MaterialTheme.colorScheme.secondary,
                                                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                                                    unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                                                    unfocusedTextColor = Color.Black,
                                                    focusedTextColor = Color.Black

                                                )

                                            )
                                        },
                                        confirmButton = {
                                            Button(onClick = { isAddingBatch = false

                                                /*if(textFieldValue.value.isNotEmpty()) {
                                                    itemList.add(textFieldValue.value)
                                                }*/

                                                addBatchTextField.value = ""

                                            }) {
                                                Text(text = "Submit")
                                            }
                                        }
                                    )
                                }
                                Button(
                                    onClick = {  },
                                    modifier = Modifier
                                        .padding(
                                            horizontal = 20.dp,
                                            vertical = 20.dp
                                        )
                                        .fillMaxWidth()
                                        .height(60.dp),
                                    border = BorderStroke(1.dp, Color.Black),
                                    elevation = ButtonDefaults.buttonElevation(5.dp),
                                    ) {
                                    Text(text = "ITPEC", style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    ))

                                }
                                //Spacer( modifier = Modifier.height(3.dp))
                                Button(
                                    onClick = {  },
                                    modifier = Modifier
                                        .padding(
                                            horizontal = 20.dp,
                                            vertical = 20.dp
                                        )
                                        .fillMaxWidth()
                                        .height(60.dp),
                                    border = BorderStroke(1.dp, Color.Black),
                                    elevation = ButtonDefaults.buttonElevation(5.dp),
                                ) {
                                    Text(text = "Japanese", style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    ))
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}