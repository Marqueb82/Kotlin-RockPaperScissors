package com.example.kotlinrps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener {

    private val gameArray = arrayOf(R.drawable.rock, R.drawable.paper, R.drawable.scissors)
    private var gameNumber : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "CPU - top, Human - bottom", Toast.LENGTH_LONG).show()

        val rock : Button = findViewById(R.id.rockButton)
        val paper : Button = findViewById(R.id.paperButton)
        val scissors : Button = findViewById(R.id.scissorsButton)

        // each button will use onClick function
        rock.setOnClickListener(this)
        paper.setOnClickListener(this)
        scissors.setOnClickListener(this)

    }

    override fun onClick(v : View){
        val id = v.id

        when(id){   //checking for button id selected
            R.id.rockButton -> {
                gameNumber = 1 //value for rock
                bottomImage.setImageResource(R.drawable.rock) //sets buttom image as user
                computerPlay() //function provides random cpu image
            }
            R.id.paperButton -> {
                gameNumber = 2
                bottomImage.setImageResource(R.drawable.paper)
                computerPlay()
            }
            R.id.scissorsButton -> {
                gameNumber = 3
                bottomImage.setImageResource(R.drawable.scissors)
                computerPlay()
            }
        }
    }

    private fun computerPlay() {
        val imageId = (0..(gameArray.size - 1)).random()
        topImage.setImageResource(gameArray[imageId])
        checkWinner(imageId)
    }

    private fun checkWinner(imageId : Int) {
        // game logic - gets user image by value and checks against cpu image
        if(gameNumber == 1 && imageId == 0) {
            showWinner(2)
        } else if(gameNumber == 1 && imageId == 1){
            showWinner(1)
        } else if(gameNumber == 1 && imageId == 2){
            showWinner(0)
        } else if(gameNumber == 2 && imageId == 0){
            showWinner(0)
        } else if(gameNumber == 2 && imageId == 1){
            showWinner(2)
        } else if(gameNumber == 2 && imageId == 2){
            showWinner(1)
        } else if(gameNumber == 3 && imageId == 0){
            showWinner(1)
        } else if(gameNumber == 3 && imageId == 1){
            showWinner(0)
        } else if(gameNumber == 3 && imageId == 2){
            showWinner(2)
        }
    }

    private fun showWinner(result: Int) {
        //winning logic
        when (result) {
            0 -> Toast.makeText(applicationContext, "You Won!!!", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(applicationContext, "Oh No, You Lost!!!", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(applicationContext, "Tie Game!!!", Toast.LENGTH_SHORT).show()
        }
    }


}
