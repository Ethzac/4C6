package ca.qc.cstj.s05localdatasource.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.s05localdatasource.R
import ca.qc.cstj.s05localdatasource.databinding.ItemContactBinding
import ca.qc.cstj.s05localdatasource.domain.models.Contact

class AsyncContactRecyclerViewAdapter(private val onContactItemClick: (Contact) -> Unit)
    : RecyclerView.Adapter<AsyncContactRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsyncContactRecyclerViewAdapter.ViewHolder {
        return ViewHolder(
            ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AsyncContactRecyclerViewAdapter.ViewHolder, position: Int) {
        val contact = differ.currentList[position]
        holder.bind(contact)

        holder.itemView.setOnClickListener {
            onContactItemClick(contact)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    private val differCallback = object  : DiffUtil.ItemCallback<Contact>() {

        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.idContact == newItem.idContact
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class ViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(contact: Contact) {
            binding.txvName.text = contact.fullName

            if(contact.isOnline) {
                binding.imvStatus.setImageResource(R.drawable.online)
            } else {

                binding.imvStatus.setImageResource(R.drawable.offline)
            }

        }
    }
}