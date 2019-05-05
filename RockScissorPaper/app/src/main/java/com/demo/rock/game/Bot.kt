package com.demo.rock.game

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper

/** This class instance will work as separate computer player */
class Bot : IBot {
    override fun clear() {
        mHandlerThread.quitSafely()
    }

    companion object {
        fun getInstance(): IBot {
            return Bot()
        }
    }

    val mHandlerThread = HandlerThread("Bot")
    val mWorkerHandler: Handler
    val mMainHandler = Handler(Looper.getMainLooper())

    init {
        mHandlerThread.start()
        mWorkerHandler = Handler(mHandlerThread.looper)
    }


    override fun getAction(callback: IBot.Callback) {
        mWorkerHandler.postDelayed({
            val action = getAction(getRandomIndex())
            mMainHandler.post { callback.onAction(action) }
        }, 3000)

    }

    fun getRandomIndex(): Int {
        return (Math.random() * 3).toInt()
    }

    fun getAction(i: Int): Action {
        var action: Action
        if (i == 0) {
            action = Action.ROCK
        } else if (i == 1) {
            action = Action.PAPER
        } else {
            action = Action.SCISSOR
        }
        return action
    }

}