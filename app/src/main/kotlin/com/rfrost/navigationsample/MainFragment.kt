package com.rfrost.navigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var mViewModel: StartViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)

        btnDetail.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_mainFragment_to_detailActivity)
        }

        btnGame.setOnClickListener { view ->
            view.findNavController().navigate(R.id.gameFragment)
        }

        btnGame.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_mainFragment_to_gameFragment)
        }

        btnGame.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_gameFragment))

        btnGame.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_mainFragment_to_gameFragment, bundleOf(
                    "userName" to "rfrost"))
        }

        btnGame.setOnClickListener { view ->
            val directions = MainFragmentDirections.actionMainFragmentToGameFragment("GameFragment")
            directions.setUserName("rfrost")
            view.findNavController().navigate(directions)
        }

        val deepLinkBuilder = NavDeepLinkBuilder(context!!)
                .setGraph(R.navigation.nav_graph_main)
                .setDestination(R.id.gameFragment)
                .setArguments(MainFragmentDirections.actionMainFragmentToGameFragment("GameFragment").arguments)
        val pendingIntent = deepLinkBuilder.createPendingIntent()
        // Use Pending Intent for explicit deep link
    }
}
