package eu.malek.alliants.interview.feat.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.ui.items.TwoLineItem
import eu.malek.alliants.interview.databinding.VendorListFragmentBinding
import eu.malek.alliants.interview.net.data.IsOpen
import eu.malek.alliants.interview.net.data.Vendor

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

        val itemAdapter = ItemAdapter<TwoLineItem>()
        val fastAdapter = FastAdapter.with(itemAdapter)
        binding.recyclerView.setAdapter(fastAdapter)


        viewModel.vendors.observe(this.viewLifecycleOwner, Observer { res ->
            if( res.isSuccessful){
                binding.recyclerView.visibility = View.VISIBLE
                binding.loadingMessage.visibility = View.GONE
                res.body()?.map { vendor ->
                    TwoLineItem()
                        .withName(vendor.description)
                        .withDescription(isVendorOpenNow(vendor))
                }
            } else {
                binding.recyclerView.visibility = View.GONE
                binding.loadingMessage.visibility = View.VISIBLE
            }
        })

        return binding.root
    }

    private fun isVendorOpenNow(vendor: Vendor): String {

        return when(eu.malek.alliants.interview.net.data.isVendorOpenNow(vendor)){
            IsOpen.UNKNOWN -> "n/a"
            IsOpen.OPEN -> "Opened"
            IsOpen.CLOSE -> "Closed"
        }
    }

}