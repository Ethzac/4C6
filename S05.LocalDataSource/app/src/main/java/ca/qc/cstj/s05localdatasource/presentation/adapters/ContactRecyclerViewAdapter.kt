package ca.qc.cstj.s05localdatasource.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.s05localdatasource.R
import ca.qc.cstj.s05localdatasource.core.loadFromResource
import ca.qc.cstj.s05localdatasource.domain.models.Contact
import ca.qc.cstj.s05localdatasource.databinding.ItemContactBinding

class ContactRecyclerViewAdapter(var contacts: List<Contact>)
    : RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemContactBinding.bind(view)

        fun bind(contact: Contact) {
            binding.txvName.text = contact.firstName + " " + contact.lastName

            if(contact.status) {
                binding.imvStatus.setImageResource(R.drawable.online)
            } else {

                binding.imvStatus.setImageResource(R.drawable.offline)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]

        holder.bind(contact)
    }

    override fun getItemCount(): Int = contacts.size

}