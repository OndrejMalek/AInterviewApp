package eu.malek.alliants.interview.feat.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.DefaultLifecycleObserver
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import eu.malek.alliants.interview.App
import eu.malek.alliants.interview.R
import eu.malek.alliants.interview.databinding.VendorListFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class VendorListFragment : Fragment() {

    companion object {
        fun newInstance() = VendorListFragment()
    }

    private lateinit var binding: VendorListFragmentBinding
    private lateinit var viewModel: VendorListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = VendorListFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(VendorListViewModel::class.java)
        val cmsApiRepo = (activity.application as App).cmsApiRepo

        val itemAdapter = ItemAdapter<com.mikepenz.fastadapter.ui.items.TwoLineItem>()
        val fastAdapter = FastAdapter.with(itemAdapter)
        binding.recyclerView.setAdapter(fastAdapter)


        viewModel.vendors

        itemAdapter.add(listOf())


        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this).get(VendorListViewModel::class.java)
//
//
//        lifecycle.addObserver(object : DefaultLifecycleObserver{
//
//        })
//    }

}