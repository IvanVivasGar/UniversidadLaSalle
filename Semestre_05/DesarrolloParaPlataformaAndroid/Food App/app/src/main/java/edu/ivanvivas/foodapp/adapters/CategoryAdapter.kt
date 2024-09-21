package edu.ivanvivas.foodapp.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import edu.ivanvivas.foodapp.R
import edu.ivanvivas.foodapp.models.Category
import android.view.View
import com.squareup.picasso.Picasso

class CategoryAdapter (val categoryList : List<Category>) : RecyclerView.Adapter<CategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.count()
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.categoryNameTV.text = category.name
        Picasso.get().load(category.image).into(holder.categoryImage)
    }
}

class CategoryViewHolder(view : View) : ViewHolder(view){
    val categoryNameTV : TextView = view.findViewById(R.id.category_name)
    val categoryImage : ImageView = view.findViewById(R.id.category_image)
}