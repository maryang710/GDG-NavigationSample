package com.rfrost.navigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.game_fragment.*

class GameFragment : Fragment() {

    companion object {
        fun newInstance() = GameFragment()
    }

    private lateinit var mViewModel: StartViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.game_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)

        txt_name.text = arguments?.getString("userName")

        arguments?.let {
            val arguments = GameFragmentArgs.fromBundle(it)
            txt_screen_name.text = arguments.screenName
            txt_name.text = arguments.userName
        }

        btnResult.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
        }
    }
}
