package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

//class SleepNightAdapter : RecyclerView.Adapter<SleepNightAdapter.SleepNightViewHolder>() {
class SleepNightAdapter :
    ListAdapter<SleepNight, SleepNightAdapter.SleepNightViewHolder>(SleepNightDiffCallback()) {

    //    class SleepNightViewHolder private constructor(private val view: View) :
//        RecyclerView.ViewHolder(view) {
    class SleepNightViewHolder private constructor(val binding: ListItemSleepNightBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): SleepNightViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
//                val view = layoutInflater.inflate(R.layout.list_item_sleep_night, parent, false)
                val binding =
                    ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
//                return SleepNightViewHolder(view)
                return SleepNightViewHolder(binding)
            }
        }

        fun bind(item: SleepNight) {
//            val res = itemView.context.resources
//            binding.sleepLength.text =
//                convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
//            binding.qualityString.text = convertNumericQualityToString(item.sleepQuality, res)
//            binding.qualityImage.setImageResource(
//                when (item.sleepQuality) {
//                    0 -> R.drawable.ic_sleep_0
//                    1 -> R.drawable.ic_sleep_1
//                    2 -> R.drawable.ic_sleep_2
//                    3 -> R.drawable.ic_sleep_3
//                    4 -> R.drawable.ic_sleep_4
//                    5 -> R.drawable.ic_sleep_5
//                    else -> R.drawable.ic_sleep_active
//                }
//            )
            binding.sleep = item
            binding.executePendingBindings()
        }
    }

//    var data = listOf<SleepNight>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
////            notifyItemChanged(value[])
//        }

//    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SleepNightViewHolder, position: Int) {
//        val item = data[position]
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepNightViewHolder {
        return SleepNightViewHolder.from(parent)
    }

}


class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {
    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId == newItem.nightId
    }

    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem == newItem
    }
}
