package nam.tran.android.helper.view.main.home

import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import nam.tran.android.helper.R
import nam.tran.android.helper.databinding.AdapterComicItemBinding
import nam.tran.android.helper.model.ComicModel
import tran.nam.common.DataBoundListAdapter

class ComicAdapter(private val dataBindingComponent: DataBindingComponent) :
    DataBoundListAdapter<ComicModel, AdapterComicItemBinding>() {

    override fun createBinding(parent: ViewGroup): AdapterComicItemBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_comic_item,
            parent,
            false,
            dataBindingComponent
        )
    }

    override fun bind(binding: AdapterComicItemBinding, item: ComicModel) {
        binding.comic = item
    }

    override fun areItemsTheSame(oldItem: ComicModel, newItem: ComicModel): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: ComicModel, newItem: ComicModel): Boolean {
        return true
    }

}