package com.example.netflixclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier= Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
                    ){
                TopAppSection()
                NetflixContentChooser()
                FeaturedMovieSection()
                addMovieList(movieType = "Watch It Again")
                addMovieList(movieType = "Drama Movies")
                addMovieList(movieType = "Action Movies")
                addMovieList(movieType = "Action Movies")
                addMovieList(movieType = "New Release")
                addMovieList(movieType = "Watch It Again")
                addMovieList(movieType = "Drama Movies")
                addMovieList(movieType = "Action Movies")
                addMovieList(movieType = "Action Movies")
                addMovieList(movieType = "New Release")
            }

        }
    }

    @Composable

    fun TopAppSection()
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(painter = painterResource(id = R.drawable.netfix3),
                contentDescription ="icon" ,
            modifier=Modifier.size(60.dp))

            Row()
            {
                Image(painter = painterResource(id = R.drawable.search), contentDescription ="search",
                modifier= Modifier
                    .padding(end = 15.dp)
                    .size(32.dp)

                )
                Image(painter = painterResource(id = R.drawable.profile),
                    contentDescription ="profile",
                    modifier= Modifier
                        .padding(end = 12.dp)
                        .size(32.dp))

            }

        }
    }

    @Composable

    fun NetflixContentChooser()
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 10.dp, vertical = 12.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(text = "TV Shows", color = Color.LightGray, fontSize = 22.sp)
            Text(text = "Movies", color = Color.LightGray,fontSize = 22.sp)

            Row()
            {
                Text(text = "Categories",color= Color.LightGray,fontSize = 22.sp)
                Image(painter = painterResource(id = R.drawable.drop), contentDescription ="drop" )
            }
        }
    }
    @Composable

    fun FeaturedMovieSection()
    {
        Column(
            modifier= Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(painter = painterResource(id = R.drawable.ironman), contentDescription = "ironManMovie",Modifier.size(300.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 60.dp, end = 60.dp)
                    .background(Color.Black),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Adventure",color=Color.White)
                Text(text = "Thriller",color=Color.White)
                Text(text = "Drama",color=Color.White)
                Text(text = "Indian",color=Color.White)

            }

            Row(
                modifier= Modifier
                    .padding(top = 20.dp, start = 80.dp, end = 80.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(painter = painterResource(id = R.drawable.add), contentDescription ="add" )
                    Text(text = "My List",color=Color.LightGray, fontSize = 10.sp)
                }
                
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Play",color=Color.Black, fontSize = 18.sp)
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(painter = painterResource(id = R.drawable.info), contentDescription ="add" )
                    Text(text = "Info",color=Color.LightGray, fontSize = 10.sp)
                }
            }

        }
    }

    @Composable
    fun addMovieList(movieType:String)
    {

        Column(
            modifier= Modifier
                .fillMaxWidth()
                .background(Color.Black)

        ) {
            Text(text = movieType,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
                color = Color.LightGray,
            modifier=Modifier.padding(top=20.dp, start = 12.dp)
            )
            LazyRow(
                modifier=Modifier.padding(top=4.dp)
            )
            {

                itemsIndexed(getRandomMovie()) { index ,item ->
                    MovieItemUiModel(imageRes = item.image)
                }
            }
        }
    }
    @Composable
    fun MovieItemUiModel(
        imageRes:Int
    )
    {
        Image(painter = painterResource(id = imageRes),
            contentDescription ="" ,
            modifier = Modifier
                .height(180.dp)
                .width(132.dp)
        )
    }

    fun getRandomMovie():List<MovieItemModel>
    {
        val listOfMovies= mutableListOf<MovieItemModel>()

        listOfMovies.add(MovieItemModel(R.drawable.hacked))
        listOfMovies.add(MovieItemModel(R.drawable.jawan))
        listOfMovies.add(MovieItemModel(R.drawable.rrr))
        listOfMovies.add(MovieItemModel(R.drawable.genius))
        listOfMovies.add(MovieItemModel(R.drawable.gadar2))
        listOfMovies.add(MovieItemModel(R.drawable.kashmir))
        listOfMovies.add(MovieItemModel(R.drawable.kgf))
        listOfMovies.add(MovieItemModel(R.drawable.gadar2))
        listOfMovies.add(MovieItemModel(R.drawable.kgf))

        listOfMovies.add(MovieItemModel(R.drawable.hollywood))
        listOfMovies.add(MovieItemModel(R.drawable.kerala))
        listOfMovies.add(MovieItemModel(R.drawable.marvel))

        listOfMovies.shuffle()
        return listOfMovies
    }
}
data class MovieItemModel(
val image:Int
)