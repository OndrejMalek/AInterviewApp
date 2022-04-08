package eu.malek.alliants.interview.feat.vendor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.ui.items.TwoLineItem
import eu.malek.alliants.interview.databinding.VendorListFragmentBinding
import eu.malek.alliants.interview.net.data.vendor.IsOpen
import eu.malek.alliants.interview.net.data.vendor.Vendor
import eu.malek.alliants.interview.net.data.vendor.isVendorOpenNow

class VendorListFragment : Fragment() {

    companion object {
        fun newInstance() = VendorListFragment()

        fun vendorsToModelAdapters(vendors: List<Vendor>?) =
            vendors?.map { vendor ->
                TwoLineItem()
                    .withName(vendor.name)
                    .withDescription(isVendorOpenNowMessage(vendor))
                //TODO withAvatar load with Glide library
            }

        fun isVendorOpenNowMessage(vendor: Vendor): String {

            return when(isVendorOpenNow(vendor)){
                IsOpen.UNKNOWN -> "n/a"
                IsOpen.OPEN -> "Opened"
                IsOpen.CLOSE -> "Closed"
            }
        }

        fun toVisibility(visible: Boolean) = if (visible) {
            View.VISIBLE
        } else View.GONE
    }

    private lateinit var binding: VendorListFragmentBinding
    private lateinit var viewModel: VendorListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = VendorListFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(VendorListViewModel::class.java)

        setupVendors(binding, viewModel)

        return binding.root
    }

    private fun setupVendors(binding: VendorListFragmentBinding, viewModel: VendorListViewModel) {
        val itemAdapter = ItemAdapter<TwoLineItem>()
        val fastAdapter = FastAdapter.with(itemAdapter)
        binding.recyclerView.setAdapter(fastAdapter)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.vendors.observe(viewLifecycleOwner, Observer { vendorsState ->
            if (vendorsState.isLoading) {
                showMessage(binding, true, "Loading vendors...")
            } else if (vendorsState.response!!.isSuccessful) {
                val items = vendorsToModelAdapters(vendorsState.response.body())
                if (items != null) {
                    itemAdapter.set(items)
                    showMessage(binding, false, "")
                } else {
                    itemAdapter.clear() //TODO behavior?
                    showMessage(binding,true,"Unfortunately we do not have any vendors.")
                }
            } else {
                showMessage(binding, true,"We can't load vendors now.")
            }
        })
    }

    private fun showMessage(binding: VendorListFragmentBinding, showMessageNotList: Boolean, message: String = "") {
        binding.recyclerView.visibility = toVisibility(!showMessageNotList)
        binding.dataStateMessage.visibility = toVisibility(showMessageNotList)
        binding.dataStateMessage.text = message
    }




}