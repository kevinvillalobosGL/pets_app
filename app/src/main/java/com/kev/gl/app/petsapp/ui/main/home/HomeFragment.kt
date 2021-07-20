package com.kev.gl.app.petsapp.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionInflater
import com.kev.gl.app.petsapp.R
import com.kev.gl.app.petsapp.databinding.FragmentHomeBinding
import com.kev.gl.app.petsapp.ui.main.details.DetailsFragment

/**
 * @author Kevin Villalobos
 */
class HomeFragment : Fragment() {

    private val mViewModel = HomeViewModel()
    private lateinit var mNavController: NavController
    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var mAdapter: HomeItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set Element Transition
        sharedElementReturnTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Init the Nav Controller
        mNavController = findNavController()
        // Inflate the layout for this fragment
        mBinding = FragmentHomeBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fix Element Transition
        postponeEnterTransition()
        view.doOnLayout {
            synchronized(this) {
                startPostponedEnterTransition()
                it.requestFocus()
                it.clearFocus()
            }
        }

        // Setup Adapter
        mAdapter = HomeItemAdapter { item, viewTransition ->
            // Setup extras
            val extras = FragmentNavigatorExtras(
                viewTransition to viewTransition.transitionName
            )
            // Bundle
            val bundle = bundleOf(DetailsFragment.PET_ARG to item)
            // Navigate
            mNavController.navigate(R.id.action_go_to_details, bundle, null, extras)
        }

        // Init Recycler
        mBinding.rvHome.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }

        // Get Pets, Notice this could be done in a Background Thread
        val list = mViewModel.getPets()
        mAdapter.addItems(list)
    }
}