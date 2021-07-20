package com.kev.gl.app.petsapp.ui.main.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.kev.gl.app.petsapp.data.model.Pet
import com.kev.gl.app.petsapp.databinding.FragmentDetailsBinding

/**
 * @author Kevin Villalobos
 */
class DetailsFragment : Fragment() {

    private lateinit var mBinding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set Element Transition
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentDetailsBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        val pet = arguments?.getParcelable<Pet>(PET_ARG)
        mBinding.pet = pet
        mBinding.executePendingBindings()
        mBinding.imvPet.post {
            startPostponedEnterTransition()
        }
    }

    companion object {

        const val PET_ARG = "pet"

    }
}