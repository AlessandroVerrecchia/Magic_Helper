package com.alessandro.magichelper.scoreBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
    }


}