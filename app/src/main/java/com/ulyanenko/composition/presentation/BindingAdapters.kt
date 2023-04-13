package com.ulyanenko.composition.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.ulyanenko.composition.R
import com.ulyanenko.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequireAnswers(textView: TextView, int: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        int
    )
}

@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textView: TextView, int: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        int
    )
}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, int: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        int
    )
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult) {
    textView.text = String.format(
       textView.context.getString(R.string.score_percentage),
       getPercentOfRightAnswers(gameResult)
    )
}

private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
}

@BindingAdapter("resultEmoji")
fun bindResultEmoji(imageView:ImageView, winner:Boolean){
imageView.setImageResource(getSmileResId(winner))
}

private fun getSmileResId(winner: Boolean): Int {
    return if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
}