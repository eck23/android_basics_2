package com.example.sampleapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : Fragment() {
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

        val view= inflater.inflate(R.layout.fragment_sign_in, container, false)
        val signUpSwapTextButton= view.findViewById<TextView>(R.id.sign_up_swap)
        val signInButton=view.findViewById<Button>(R.id.sigin_button)

        signUpSwapTextButton.setOnClickListener(){

            val fragment = SignUpFragment.newInstance()
            loadFragment(fragment)

        }

        signInButton.setOnClickListener(){

            val fragment= HomeFragment.newInstance()
            loadFragment(fragment)

        }



        // Inflate the layout for this fragment
        return view
    }


    fun loadFragment(fragment: Fragment){

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
        transaction?.replace(R.id.container,fragment)
            ?.commit()

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}