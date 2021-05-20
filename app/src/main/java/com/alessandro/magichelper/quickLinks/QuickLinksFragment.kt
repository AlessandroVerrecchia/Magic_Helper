package com.alessandro.magichelper.quickLinks

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alessandro.magichelper.R
import kotlinx.android.synthetic.main.fragment_quick_links.*


class QuickLinksFragment : Fragment() {

    companion object {
        private const val GOLD_FISH_META_GAME = "https://www.mtggoldfish.com/metagame/modern#paper"
        private const val STAR_CITY_GAMES = "https://starcitygames.com/"
        private const val CHANNEL_FIREBALL = "https://shop.channelfireball.com/"
        private const val FACE_TO_FACE_GAMES = "https://www.facetofacegames.com/"
        private const val TOP_DECK_HERO = "http://www.topdeckhero.com/"
        private const val JEUX_3_DRAGON = "https://www.jeux3dragons.com/"
        private const val MTG_TOP_8 = "https://mtgtop8.com/"
        private const val TCG_PLAYER = "https://www.tcgplayer.com/"
        private const val EDHREC = "https://edhrec.com/"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quick_links, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewClickListeners()
    }

    private fun setupViewClickListeners() {
        cfbTextView.setOnClickListener {
            openUrl(CHANNEL_FIREBALL)
        }
        scgTextView.setOnClickListener {
            openUrl(STAR_CITY_GAMES)
        }
        tcgpTextView.setOnClickListener {
            openUrl(TCG_PLAYER)
        }
        j3dTextView.setOnClickListener {
            openUrl(JEUX_3_DRAGON)
        }
        tdhTextView.setOnClickListener {
            openUrl(TOP_DECK_HERO)
        }
        goldfishTextView.setOnClickListener {
            openUrl(GOLD_FISH_META_GAME)
        }
        mtgt8TextView.setOnClickListener {
            openUrl(MTG_TOP_8)
        }
        ftfTextView.setOnClickListener {
            openUrl(FACE_TO_FACE_GAMES)
        }
        edhRecTextView.setOnClickListener {
            openUrl(EDHREC)
        }
    }

    private fun openUrl(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

}