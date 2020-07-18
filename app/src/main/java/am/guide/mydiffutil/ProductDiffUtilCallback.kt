package am.guide.mydiffutil

import androidx.recyclerview.widget.DiffUtil

class ProductDiffUtilCallback(private var oldList: List<Product>?, private var newList: List<Product>?) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList!!.size
    }

    override fun getNewListSize(): Int {
        return newList!!.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldProduct = oldList!![oldItemPosition]
        val newProduct = newList!![newItemPosition]
        return oldProduct.id == newProduct.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldProduct = oldList!![oldItemPosition]
        val newProduct = newList!![newItemPosition]
        return (oldProduct.name.equals(newProduct.name)
                && oldProduct.price == newProduct.price)
    }
}