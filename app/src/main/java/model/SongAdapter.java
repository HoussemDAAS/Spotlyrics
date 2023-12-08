package model;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spotlyrics.R;
import com.example.spotlyrics.Song;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongAdapter extends BaseAdapter {

    private Context context;
    private List<Song> songs;

    public SongAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageSong);
            holder.textView = convertView.findViewById(R.id.textSongTitle);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Song song = songs.get(position);

        Resources resources = context.getResources();
        int columnWidth = (int) resources.getDimension(R.dimen.grid_column_width);
        holder.imageView.getLayoutParams().width = columnWidth;
        holder.imageView.getLayoutParams().height = columnWidth; // Keeps images as squares

        holder.textView.setText(song.getTitle()); // Set the song title
        Picasso.get().load(song.getImageUrl()).into(holder.imageView); // Load the image

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}