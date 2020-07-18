package am.guide.mydiffutil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MyAdapter
    private var mBoolean = false
    private var productList1 = ArrayList<Product>()
    private var productList2 = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        update.setOnClickListener {
            onUpdateClick()
        }

        productList1.add(Product(1, "Name1", 100))
        productList1.add(Product(2, "Name2", 200))
        //productList1.add(Product(3, "Name3", 300))
        productList1.add(Product(4, "Name4", 400))
        productList1.add(Product(5, "Name5", 501))

        productList2.add(Product(2, "Name2", 200))
        productList2.add(Product(3, "Name3", 300))
        productList2.add(Product(4, "Name4", 400))
        productList2.add(Product(6, "Name6", 600))
        productList2.add(Product(7, "Name7", 600))

        adapter = MyAdapter(this, productList1)
        //adapter.setData(productList1)
        recycler_view.adapter = adapter
    }

    private fun onUpdateClick() {
        adapter.update(if (mBoolean) productList1 else productList2)
        mBoolean = !mBoolean
    }
}
