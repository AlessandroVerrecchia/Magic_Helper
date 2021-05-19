package com.alessandro.magichelper.scoreBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.alessandro.magichelper.R
import kotlinx.android.synthetic.main.fragment_multi_player.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MultiPlayerFragment : Fragment() {

    private val multiPlayerViewModel by viewModel<MultiPlayerViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_multi_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resetLifeTotals()
        observeLifeTotals()
        setupViewClickListeners()
    }

    private fun resetLifeTotals() {
        multiPlayerViewModel.resetLifeTotals()
    }

    private fun observeLifeTotals() {
        multiPlayerViewModel.life1LiveData.observe(viewLifecycleOwner, Observer { life ->
            lifeTotalTextView1.text = life.toString()
        })
        multiPlayerViewModel.life2LiveData.observe(viewLifecycleOwner, Observer { life ->
            lifeTotalTextView2.text = life.toString()
        })
        multiPlayerViewModel.life3LiveData.observe(viewLifecycleOwner, Observer { life ->
            lifeTotalTextView3.text = life.toString()
        })
        multiPlayerViewModel.life4LiveData.observe(viewLifecycleOwner, Observer { life ->
            lifeTotalTextView4.text = life.toString()
        })
    }

    private fun setupViewClickListeners() {
        resetLifeTotalsImageView.setOnClickListener {
            multiPlayerViewModel.resetLifeTotals()
        }
        player1AddLifeView.setOnClickListener {
            multiPlayerViewModel.addLifeTotal(1)
        }
        player2AddLifeView.setOnClickListener {
            multiPlayerViewModel.addLifeTotal(2)
        }
        player3AddLifeView.setOnClickListener {
            multiPlayerViewModel.addLifeTotal(3)
        }
        player4AddLifeView.setOnClickListener {
            multiPlayerViewModel.addLifeTotal(4)
        }
        player1MinusLifeView.setOnClickListener {
            multiPlayerViewModel.removeLifeTotal(1)
        }
        player2MinusLifeView.setOnClickListener {
            multiPlayerViewModel.removeLifeTotal(2)
        }
        player3MinusLifeView.setOnClickListener {
            multiPlayerViewModel.removeLifeTotal(3)
        }
        player4MinusLifeView.setOnClickListener {
            multiPlayerViewModel.removeLifeTotal(4)
        }
    }

}