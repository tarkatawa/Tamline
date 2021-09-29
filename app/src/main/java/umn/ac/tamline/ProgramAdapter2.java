package umn.ac.tamline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter2 extends RecyclerView.Adapter<ProgramAdapter2.ViewHolder>{

    Context context;
    String[] programNameList;
    String[] programDescriptionList;
    int[] images;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowName;
        TextView rowDescription;
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.namabengkel);
            rowDescription = itemView.findViewById(R.id.alamatbengkel);
            rowImage = itemView.findViewById(R.id.imageView);
        }
    }

    public ProgramAdapter2(Context context, String[] programNameList, String[] programDescriptionList, int[] images){
        this.context = context;
        this.programNameList = programNameList;
        this.programDescriptionList = programDescriptionList;
        this.images = images;
    }

    @NonNull
    @Override
    public ProgramAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.chat_pilih_satuan, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter2.ViewHolder holder, int position) {
        holder.rowName.setText(programNameList[position]);
        holder.rowDescription.setText(programDescriptionList[position]);
        holder.rowImage.setImageResource(images[0]);
    }

    @Override
    public int getItemCount() {
        return programNameList.length;
    }
}
