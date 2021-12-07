package com.example.carrace

import kotlin.random.Random

class Cars (var name:String, var speed: Int, var maxSpeed:Int, val accelerate:Int, val stability:Int, var Image:Int, var Distance: Int) {



    fun accelerate(){

        if(speed >= maxSpeed){
            speed = maxSpeed
        }else {
            speed += accelerate
        }
    }

    fun move(){
        Distance += speed

    }

    fun overturn(){
        var random = Random.nextInt(0, 11)
        if (random == stability){
            Distance = 0
            speed = 0
        }
    }

    fun boost(){

        var random = Random.nextInt(0, 11)
        if (random == 5){
            speed += 10
        }
    }
}

