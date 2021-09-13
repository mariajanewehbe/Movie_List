package org.mariajane.final_csc498;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedImagesAdapter extends RecyclerView.Adapter <CaptionedImagesAdapter.ViewHolder> {

    MovieListener movieListener;
    private Context context;

    private String[] captions;
    private int[] imageIds;

    public CaptionedImagesAdapter(Context context, String[] captions, int[] imageIds) {
        this.context = context;
        this.captions = captions;
        this.imageIds = imageIds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_captioned_image, viewGroup, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        CardView cardView = viewHolder.cardView;

        ImageView imageView = cardView.findViewById(R.id.info_image_view);
        imageView.setImageResource(imageIds[position]);
        imageView.setContentDescription(captions[position]);

        TextView textView = cardView.findViewById(R.id.info_text_view);
        textView.setText(captions[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (movieListener != null) {
                    movieListener.itemClicked(position);
                }
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.ITEM_NUMBER, position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cv)
        {
            super(cv);
            cardView = cv;
        }
    }

    public interface MovieListener { void itemClicked(long id); }

}
