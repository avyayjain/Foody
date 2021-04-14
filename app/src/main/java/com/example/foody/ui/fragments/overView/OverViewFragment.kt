package com.example.foody.ui.fragments.overView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import coil.load
import com.example.foody.R
import com.example.foody.models.Result
import com.example.foody.util.Constants.Companion.RECIPE_RESULT_KEY
import kotlinx.android.synthetic.main.fragment_over_view.view.*
import org.jsoup.Jsoup

class OverViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_over_view, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        view.main_imageView.load(myBundle?.image)
        view.title_textView.text = myBundle?.title
        view.like_textView.text = myBundle?.aggregateLikes.toString()
        view.time_textView.text = myBundle?.readyInMinutes.toString()
        view.summary_textView.text = myBundle?.summary
        myBundle?.summary.let {
            val summary = Jsoup.parse(it).text()
            view.summary_textView.text = summary
        }

        if (myBundle?.vegetarian == true){
            view.vegetarian_imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            view.vegetarian_textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }

        if (myBundle?.vegan == true){
            view.vegan_imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            view.vegan_textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }

        if (myBundle?.dairyFree == true){
            view.dairy_free_imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            view.dairy_free_textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }

        if (myBundle?.veryHealthy == true){
            view.healthy_imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            view.healthy_textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }

        if (myBundle?.cheap == true){
            view.cheap_imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            view.cheap_textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }

        if (myBundle?.glutenFree == true){
            view.gluten_free_imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            view.gluten_free_textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }

        return view
    }


}