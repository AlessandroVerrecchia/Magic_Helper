package com.alessandro.magichelper.scoreBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alessandro.magichelper.R
import kotlinx.android.synthetic.main.fragment_score_board.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ScoreBoardFragment : Fragment() {

    private val scoreBoardViewModel by viewModel<ScoreBoardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_score_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resetLifeTotals()
        observeLifeTotals()
        setupViewClickListeners()
    }

    private fun resetLifeTotals() {
        scoreBoardViewModel.resetLifeTotals()
    }

    private fun observeLifeTotals() {
        scoreBoardViewModel.lifeTotalLiveData.observe(viewLifecycleOwner, Observer { life ->
            lifeTotalTextView.text = life.toString()
        })
        scoreBoardViewModel.opponentLifeTotalLiveData.observe(viewLifecycleOwner, Observer { life ->
            opponentLifeTextView.text = life.toString()
        })
    }

    private fun setupViewClickListeners() {
        resetLifeTotalsImageView.setOnClickListener {
            scoreBoardViewModel.resetLifeTotals()
            yourDiceRollImageView.visibility = View.GONE
            opponentDieRollImageView.visibility = View.GONE
        }
        addLifeTotalImageView.setOnClickListener {
            scoreBoardViewModel.addLifeTotal()
        }
        removeLifeTotalImageView.setOnClickListener {
            scoreBoardViewModel.removeLifeTotal()
        }
        addOpponentLifeTotalImageView.setOnClickListener {
            scoreBoardViewModel.addOpponentLifeTotal()
        }
        removeOpponentLifeTotalImageView.setOnClickListener {
            scoreBoardViewModel.removeOpponentLifeTotal()
        }
        diceRollImageView.setOnClickListener {
            displayDiceRollResult(scoreBoardViewModel.diceRoll())
        }
        multiPlayerImageView.setOnClickListener {
            navigateToMultiPlayerFragment()
        }
    }

    private fun displayDiceRollResult(result: Pair<Int, Int>) {
        yourDiceRollImageView.visibility = View.VISIBLE
        opponentDieRollImageView.visibility = View.VISIBLE

        getImageResourceForResult(result.first)?.let {
            yourDiceRollImageView.setImageResource(it)
        }
        getImageResourceForResult(result.second)?.let {
            opponentDieRollImageView.setImageResource(it)
        }
    }

    private fun getImageResourceForResult(result: Int): Int? {
        return when (result) {
            1 -> R.drawable.die_1
            2 -> R.drawable.die_2
            3 -> R.drawable.die_3
            4 -> R.drawable.die_4
            5 -> R.drawable.die_5
            6 -> R.drawable.die_6
            else -> null
        }
    }

    private fun navigateToMultiPlayerFragment() {
        val action = ScoreBoardFragmentDirections.actionToMultiPlayerFragment()
        findNavController().navigate(action)
    }

}