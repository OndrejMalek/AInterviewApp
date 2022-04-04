package eu.malek.alliants.interview.feat.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.malek.alliants.interview.R

class VendorListFragment : Fragment() {

    companion object {
        fun newInstance() = VendorListFragment()
    }

    private lateinit var viewModel: VendorListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.vendor_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VendorListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}