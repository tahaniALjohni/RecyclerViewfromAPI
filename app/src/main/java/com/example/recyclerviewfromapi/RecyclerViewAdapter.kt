package com.example.recyclerviewfromapi

    import android.view.LayoutInflater
    import android.view.ViewGroup
    import androidx.recyclerview.widget.RecyclerView
    import com.example.recyclerviewfromapi.databinding.ItemRowBinding

    class RecyclerViewAdapter(private val nameList: ArrayList<String>): RecyclerView.Adapter<RecyclerViewAdapter.HOLDER>() {
        class HOLDER(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HOLDER {
            return HOLDER(ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        override fun onBindViewHolder(holder: HOLDER, position: Int) {
            val name = nameList[position]

            holder.binding.apply {
                tvName.text = name
            }
        }

        override fun getItemCount() = nameList.size
    }