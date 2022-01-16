package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen()


            }
        }
    }
}

@Composable
fun BlurImage() {
    Box(
        Modifier
            // Blur content allowing the result to extend beyond the bounds of the original content
            .padding(20.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .fillMaxHeight(),
        contentAlignment = Alignment.Center

    ) {

        Column() {
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "Image of my account",
                Modifier
                    .blur(
                        4.dp,
                        edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(16.dp))
                    ),
                contentScale = ContentScale.Fit,

                )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Background image",
                    Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )

                Card(
                    modifier = Modifier
                        .blur(
                            15.dp,
                            edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(16.dp))
                        )
                        .size(150.dp),
                    backgroundColor = Color(0.0f, 0.0f, 0.0f, 0.341f),
                    border = BorderStroke(width = 0.dp, color = Color.Transparent),
                    elevation = 4.dp
                ) {
                }
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Blurs are beautiful",
                    color = Color.White,
                    fontWeight = FontWeight(weight = 300)
                )
            }
        }
    }
}


@Preview()
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        //Image layer with blur
        Image(
            painter = painterResource(id = R.drawable.backg),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize()
                .blur(
                    20.dp
                ),
            contentScale = ContentScale.Crop,
        )

        //Ghost surface
        Surface(
            modifier = Modifier
                .alpha(0.6f)
                .fillMaxSize()
        ) {
        }

        //App grid
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .width(380.dp)
                    .height(390.dp),
                backgroundColor = Color(0.0f, 0.0f, 0.0f, 0.322f),
//                backgroundColor = Color(0.0f, 0.0f, 0.0f, 0.0f),
                elevation = 0.dp,
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
//                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Design",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp),
                        style = MaterialTheme.typography.h5,
                        color = Color.White,
                        fontWeight = FontWeight(500),
//                        textAlign = TextAlign.Center
                    )
//                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 2.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        AppIcon(R.drawable.adobe_photoshop, "Photoshop")
                        AppIcon(R.drawable.adobe_aero, "Aero")
                        AppIcon(R.drawable.adobe_indesign, "Indesign")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 2.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        AppIcon(R.drawable.adobe_premiere, "Premiere")
                        AppIcon(R.drawable.adobe_lightroom, "Lightroom")
                        AppIcon(R.drawable.adobe_animate, "Animate")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 2.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        AppIcon(R.drawable.adobe_xd, "XD")
                        AppIcon()
                        AppIcon(R.drawable.adobe_illustrator, "Illustrator")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AppIcon(painter: Int = R.drawable.adobe_after_effects, appName: String = "After Effects") {
    Column(
        modifier = Modifier.width(72.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = painter),
            contentDescription = "Photoshop",
            modifier = Modifier.size(64.dp)
        )
        Text(
            text = appName,
            fontSize = 14.sp,
            color = Color.White,
            maxLines = 1,
            softWrap = true,
            overflow = TextOverflow.Ellipsis
        )
    }
}
