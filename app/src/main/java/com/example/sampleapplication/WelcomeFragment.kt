package com.example.sampleapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val topAnimation= AnimationUtils.loadAnimation(this.context, R.anim.welcome_animation_top)
        val bottomAnimation= AnimationUtils.loadAnimation(this.context, R.anim.welcome_animation_bottom)
        topAnimation.duration=1000
        bottomAnimation.duration=1000


        val welcomeImage = view.findViewById<ImageView>(R.id.welcomeImage)
        val welcomeTextSection1 = view.findViewById<TextView>(R.id.welcome_section1)
        val welcomeTextSection2 = view.findViewById<TextView>(R.id.welcome_section2)
        val welcomeTextSection3 = view.findViewById<TextView>(R.id.welcome_section3)
        val welcomeButton = view.findViewById<Button>(R.id.welcome_button)


        welcomeImage.animation=topAnimation
        welcomeTextSection1.animation=bottomAnimation
        welcomeTextSection2.animation=bottomAnimation
        welcomeTextSection3.animation=bottomAnimation
        welcomeButton.animation=bottomAnimation


        welcomeButton.setOnClickListener(){

            val fragment = SignInFragment.newInstance()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
            transaction?.replace(R.id.container,fragment)
                ?.commit()
        }


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            WelcomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}