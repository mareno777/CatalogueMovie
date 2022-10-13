package id.mareno.cataloguemovie.adapter

import androidx.recyclerview.widget.DiffUtil
import id.mareno.cataloguemovie.data.remote.dtos.PosterResult

class DifferentUtil : DiffUtil.ItemCallback<PosterResult>() {
    override fun areItemsTheSame(oldItem: PosterResult, newItem: PosterResult): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PosterResult, newItem: PosterResult): Boolean {
        return oldItem == newItem
    }
}