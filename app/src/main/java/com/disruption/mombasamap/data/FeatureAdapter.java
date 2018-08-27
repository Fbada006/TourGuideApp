package com.disruption.mombasamap.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.disruption.mombasamap.R;

import java.util.ArrayList;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.MyViewHolder> {

    /*The ArrayList that contains the list of features*/
    private ArrayList<Feature> mFeatures;

    /*Context of the application*/
    private Context mContext;

    /*Declare a resource ID for the background color of a particular layout*/
    private int mBackgroundColorResourceId;

    /*Variable for the click listener*/
    final private RecyclerViewClickListener mRecyclerViewClickListener;

    /**
     * This is the constructor to be used
     *
     * @param features                  is the ArrayList of {@link Feature} objects
     * @param backgroundColorResourceId is the background of that screen
     */
    public FeatureAdapter(ArrayList<Feature> features, int backgroundColorResourceId, RecyclerViewClickListener recyclerViewClickListener) {
        this.mFeatures = features;
        this.mRecyclerViewClickListener = recyclerViewClickListener;
        this.mBackgroundColorResourceId = backgroundColorResourceId;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        //Inflate the item and return a new ViewHolder
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.feature_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Get the current feature
        Feature currentFeature = mFeatures.get(position);

        //Set the appropriate attributes of the feature to the corresponding views
        holder.featureName.setText(currentFeature.getFeatureName());
        holder.featureAddress.setText(currentFeature.getFeatureAddress());
        holder.featureYear.setText(currentFeature.getFeatureCompletionYear());
        holder.featureImage.setImageResource(currentFeature.getImageResourceId());

        //Find the color that is represented by the current resource ID
        int color = ContextCompat.getColor(mContext, mBackgroundColorResourceId);
        holder.itemView.findViewById(R.id.feature_description_text_container).setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return mFeatures.size();
    }

    /**
     * The ViewHolder class containing an item
     */
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //TextViews and ImageView in the item row
        TextView featureName;
        TextView featureAddress;
        TextView featureYear;
        ImageView featureImage;

        MyViewHolder(View itemView) {
            super(itemView);
            featureName = itemView.findViewById(R.id.feature_name_text_view);
            featureAddress = itemView.findViewById(R.id.feature_address_text_view);
            featureYear = itemView.findViewById(R.id.feature_year_text_view);
            featureImage = itemView.findViewById(R.id.feature_image);

            //Call setOnClick Listener on the itemView above
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mRecyclerViewClickListener.onRecyclerViewItemClicked(v, this.getAdapterPosition());
        }

    }

    /**
     * This interface will be responsible for listening to clicks
     */
    public interface RecyclerViewClickListener {
        /**
         * @param view     is the view clicked on
         * @param position is the index of the view
         */
        void onRecyclerViewItemClicked(View view, int position);
    }
}
