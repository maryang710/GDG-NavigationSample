package com.rfrost.navigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.result_fragment.*

class ResultFragment : Fragment() {

    companion object {
        fun newInstance() = ResultFragment()
    }

    private lateinit var mViewModel: StartViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.result_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)

        arguments?.let {
            val arguments = ResultFragmentArgs.fromBundle(it)
            txt_score.text = "Score: " + arguments.userName
        }
    }
}
