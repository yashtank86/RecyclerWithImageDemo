package com.example.recyclerwithimagedemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    public ArrayList<String> imagearray;
    public Context context;
    View pubView;

    public RecyclerAdapter(ArrayList<String> imagearray, Context context) {
        this.imagearray = imagearray;
        this.context = context;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aulbum_layout, viewGroup, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view, context);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder viewHolder, final int i) {
        viewHolder.aulbum_title.setText("Photos : " + (i + 1));
        viewHolder.downloadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadImageFromurls(viewHolder).execute(imagearray.get(i));

            }
        });

        Glide.with(context).load(imagearray.get(i)).placeholder(R.drawable.ic_launcher_foreground).into(viewHolder.aulbum);
    }

    @Override
    public int getItemCount() {
        return imagearray.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView aulbum;
        TextView aulbum_title;
        Button downloadimage;
        ProgressBar progressBar;
        Context context;

        public ImageViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            aulbum = itemView.findViewById(R.id.aulbum);
            aulbum_title = itemView.findViewById(R.id.aulbum_title);
            downloadimage = itemView.findViewById(R.id.button1);
            progressBar = itemView.findViewById(R.id.progressBar1);
            this.context = context;
            pubView=itemView;

        }

    }

    public class DownloadImageFromurls extends AsyncTask<String, String, String> {

        ImageViewHolder imageViewHolder;

        public DownloadImageFromurls(ImageViewHolder viewHolder){
            imageViewHolder=viewHolder;

        }

        @Override
        protected void onPreExecute() {
            imageViewHolder.progressBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            imageViewHolder.progressBar.setProgress(Integer.parseInt(values[0]));
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            imageViewHolder.progressBar.setVisibility(View.GONE);
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            int count;
            String fileName;
            try {

                URL url = new URL(strings[0]);
                URLConnection connection = url.openConnection();
                connection.connect();

                int lenthImage = connection.getContentLength();
                fileName = strings[0].substring(strings[0].lastIndexOf("/") + 1);

                String folder = "/sdcard/OUR_WALLPAPERS/";
                File file = new File(folder);
                if (!file.exists()) {
                    file.mkdir();
                }
                InputStream inputStream = new BufferedInputStream(url.openStream(), 10000);
                OutputStream outputStream = new FileOutputStream("/sdcard/OUR_WALLPAPERS/" + fileName);

                byte data[] = new byte[1024];
                int total = 0;
                while ((count = inputStream.read(data)) != -1) {
                    total += count;

                    publishProgress("" + (int) ((total * 100) / lenthImage));
                    outputStream.write(data, 0, count);

                }

                outputStream.flush();
                outputStream.close();
                inputStream.close();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

    }
}
