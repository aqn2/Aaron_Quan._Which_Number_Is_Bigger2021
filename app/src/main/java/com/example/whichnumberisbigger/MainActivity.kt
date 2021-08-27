package com.example.whichnumberisbigger

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //make instance variables for each widget with the lateinit modifier

    lateinit var leftClick : Button
    var leftValue = 0
    lateinit var rightClick : Button
    var rightValue = 0
    var score = 0
    var clicks = 0

    lateinit var healthBar : ProgressBar
    lateinit var healthDisplay : TextView
    //lateinit var  scoreText : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leftClick = findViewById(R.id.button_main_left)
        leftValue += (Math.random()*101).toInt()
        rightClick = findViewById(R.id.button_main_right)
        rightValue += (Math.random()*101).toInt()

        while(leftValue == rightValue){
            leftValue = (Math.random()*101).toInt()
            rightValue = (Math.random()*101).toInt()
        }

        leftClick.text = leftValue.toString()
        rightClick.text = rightValue.toString()

        //scoreText = findViewById(R.id.text_main_score)
        //scoreText.text = score.toString()

        healthBar = findViewById(R.id.psyduck_health)
        healthBar.setProgress(0)
        healthBar.display
        healthDisplay = findViewById(R.id.progress_main_display)
        healthDisplay.text = ("0/50")

        healthBar.setBackgroundColor(
            Color.argb((Math.random()*255).toInt(),
                (Math.random()*255).toInt(),
                (Math.random()*255).toInt(),
                (Math.random()*255).toInt()))


        leftClick.setOnClickListener{
            clicks ++
            var power = (Math.random()*5 + 1).toInt()
            if(leftValue > rightValue){
                score +=power

            }
            if(rightValue > leftValue){
                score -=power
            }
            if(score < 0){
                score = 0
            }

            if(score == 50){
                Toast.makeText(this@MainActivity,"Psyduck Fainted!... You Win!", Toast.LENGTH_SHORT).show()

            }


            //scoreText.text = score.toString()
            healthBar.setProgress(score)
            healthDisplay.text = ("SCORE:" + healthBar.progress.toString() + "/50")

            if(clicks % 5 == 0){
                Toast.makeText(this@MainActivity,"Psyduck used Water Gun!", Toast.LENGTH_SHORT).show()
                Thread.sleep(1000)
                var damage = (Math.random()*10).toInt()
                if(damage >= 7){
                    Toast.makeText(this@MainActivity,"A critical hit!", Toast.LENGTH_SHORT).show()
                    Thread.sleep(1000)
                }
                if(damage <= 3){
                    Toast.makeText(this@MainActivity,"It was not very effective...", Toast.LENGTH_SHORT).show()
                    Thread.sleep(1000)
                }
                score -= damage
                healthBar.setProgress(score)
                healthDisplay.text = ("SCORE:" + healthBar.progress.toString() + "/50")
            }


            leftValue = (Math.random()*101).toInt()
            rightValue = (Math.random()*101).toInt()
            while(leftValue == rightValue){
                leftValue = (Math.random()*101).toInt()
                rightValue = (Math.random()*101).toInt()
            }

            leftClick.text = leftValue.toString()
            rightClick.text = rightValue.toString()




        }

        rightClick.setOnClickListener{
            clicks++
            var power = (Math.random()*5 + 1).toInt()
            if(leftValue < rightValue){
                score +=power
            }
            if(rightValue < leftValue){
                score -=power
            }
            if(score < 0){
                score = 0
            }

            if(score == 50){
                Toast.makeText(this@MainActivity,"Psyduck Fainted!... You Win!", Toast.LENGTH_SHORT).show()

            }


            //scoreText.text = score.toString()
            healthBar.setProgress(score)
            healthDisplay.text = ("SCORE:" + healthBar.progress.toString() + "/50")


            if(clicks % 5 == 0){
                Toast.makeText(this@MainActivity,"Psyduck used Water Gun!", Toast.LENGTH_SHORT).show()
                Thread.sleep(1000)
                var damage = (Math.random()*10).toInt()
                if(damage >= 7){
                    Toast.makeText(this@MainActivity,"A critical hit!", Toast.LENGTH_SHORT).show()
                    Thread.sleep(1000)
                }
                if(damage <= 3){
                    Toast.makeText(this@MainActivity,"It was not very effective...", Toast.LENGTH_SHORT).show()
                    Thread.sleep(1000)
                }
                score -= damage
                healthBar.setProgress(score)
                healthDisplay.text = ("SCORE:" + healthBar.progress.toString() + "/50")
            }

            leftValue = (Math.random()*101).toInt()
            rightValue = (Math.random()*101).toInt()
            while(leftValue == rightValue){
                leftValue = (Math.random()*101).toInt()
                rightValue = (Math.random()*101).toInt()
            }
            leftClick.text = leftValue.toString()
            rightClick.text = rightValue.toString()

        }

        //wire widgets
        //when setting the button text, it needs to be a string
        //if you set the text to be a number it gonna crash
        //buttonLeft.text = 10.toString()

        //1-10 damage every 10 for random but progress

    }
}