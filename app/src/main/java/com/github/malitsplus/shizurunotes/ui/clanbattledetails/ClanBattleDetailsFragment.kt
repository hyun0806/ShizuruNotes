package com.github.malitsplus.shizurunotes.ui.clanbattledetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.malitsplus.shizurunotes.R
import com.github.malitsplus.shizurunotes.data.ClanBattlePhase
import com.github.malitsplus.shizurunotes.databinding.FragmentClanBattleDetailsBinding
import com.github.malitsplus.shizurunotes.ui.SharedViewModelClanBattle
import com.github.malitsplus.shizurunotes.ui.clanbattledetails.adapters.ClanBattlePhaseAdapter

class ClanBattleDetailsFragment(
    val phase: ClanBattlePhase
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val sharedClanBattleVM = ViewModelProvider(activity!!).get(SharedViewModelClanBattle::class.java)

        val binding = DataBindingUtil.inflate<FragmentClanBattleDetailsBinding>(
            inflater, R.layout.fragment_clan_battle_details, container, false
        ).apply {
            lifecycleOwner = viewLifecycleOwner

            clanBattleBossRecycler.layoutManager = LinearLayoutManager(context)
            clanBattleBossRecycler.adapter = ClanBattlePhaseAdapter(
                phase.bossList
            ).apply {
                setSharedClanBattleVM(sharedClanBattleVM)
            }
        }

        return binding.root
    }

}
