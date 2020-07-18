package am.guide.mydiffutil

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_products.view.*

class MyAdapter(private val mContext: Context, private var mList: ArrayList<Product>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_products, null, false))
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = mList[position]
        val mViwe = (holder as ViewHolder).itemView
        mViwe.name.text = model.name
        mViwe.price.text = model.price.toString()

        mViwe.setOnClickListener {
            Toast.makeText(mContext, "clicked$position", Toast.LENGTH_SHORT).show()
        }
    }

    fun update(productList: ArrayList<Product>) {
        val productDiffUtilCallback = ProductDiffUtilCallback(mList, productList)
        val productDiffResult = DiffUtil.calculateDiff(productDiffUtilCallback)
        mList = productList
        productDiffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

}