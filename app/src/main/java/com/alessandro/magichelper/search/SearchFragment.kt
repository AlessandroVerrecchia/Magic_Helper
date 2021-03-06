package com.alessandro.magichelper.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.alessandro.magichelper.R
import com.alessandro.magichelper.ui.loadImage
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : Fragment() {

    private val searchViewModel by viewModel<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeSearchResult()
        observeError()
        setupSearchInputListener()
    }

    private fun setupSearchInputListener() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    clearResult()
                }
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                search()
                return false
            }

        })
    }

    private fun observeSearchResult() {
        searchViewModel.cardLiveData.observe(viewLifecycleOwner, Observer { card ->
            if (card?.id.isNullOrEmpty().not()) {
                updateCardArtwork(card?.imageDto?.normal)
            } else {
                displayNoResultFound()
            }
        })
    }

    private fun observeError() {
        searchViewModel.errorLiveData.observe(viewLifecycleOwner, Observer { error ->
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        })
    }

    private fun clearResult() {
        cardImageViewHolder.visibility = View.GONE
    }

    private fun updateCardArtwork(artworkUrl: String?) {
        cardImageViewHolder.visibility = View.VISIBLE
        loadImage(cardImageViewHolder, artworkUrl)
    }

    private fun displayNoResultFound() {
        Toast.makeText(context, "apren a ekrir", Toast.LENGTH_SHORT).show()
    }

    private fun search() {
        searchViewModel.searchCard(searchView.query.toString())
    }
}