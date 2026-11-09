package Game.controller

import Game.model.Enemy

class EnemyController{
    fun moveEnemy(enemy: Enemy, spped: Float): Enemy {
        return enemy.copy(y = enemy.y + spped)
    }
}