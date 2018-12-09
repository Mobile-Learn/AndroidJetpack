package nam.tran.android.helper.view.local

import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import com.android.example.github.ui.common.DataBoundListAdapter
import nam.tran.android.helper.R
import nam.tran.android.helper.databinding.AdapterComicItemBinding
import nam.tran.android.helper.model.ComicModel
import nam.tran.domain.executor.AppExecutors

class ComicAdapter(private val dataBindingComponent: DataBindingComponent, appExecutors: AppExecutors) :
    DataBoundListAdapter<ComicModel, AdapterComicItemBinding>(appExecutors=appExecutors,diffCallback = object : DiffUtil.ItemCallback<ComicModel>() {
        override fun areItemsTheSame(oldItem: ComicModel, newItem: ComicModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ComicModel, newItem: ComicModel): Boolean {
            return oldItem.title == newItem.title
        }
    }) {

    override fun createBinding(parent: ViewGroup): AdapterComicItemBinding {
        val binding : AdapterComicItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_comic_item,
            parent,
            false,
            dataBindingComponent
        )
        binding.root.setOnClickListener {
            val bundle = bundleOf("comic" to binding.comic,"isLocal" to true)
            it.findNavController().navigate(R.id.action_localComicFragment_to_detailComicFragment, bundle)
        }
        return binding
    }

    override fun bind(binding: AdapterComicItemBinding, item: ComicModel) {
        binding.comic = item
        binding.ckbLike.visibility = View.GONE
    }
}