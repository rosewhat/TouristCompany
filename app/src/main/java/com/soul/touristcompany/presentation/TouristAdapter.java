package com.soul.touristcompany.presentation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soul.touristcompany.R;
import com.soul.touristcompany.domain.Info;
import com.soul.touristcompany.domain.Tourist;

import java.util.ArrayList;

public class TouristAdapter extends RecyclerView.Adapter<TouristAdapter.TouristViewHolder> {

    Context context;
    private ArrayList<Tourist> tourists;
    private onNoteClickListener listener;
  //  private ArrayList<Info> infos;

    public TouristAdapter(Context context, ArrayList<Tourist> tourists) {
        this.context = context;
        this.tourists = tourists;
    }

    public void setTourists(ArrayList<Tourist> tourists) {
        this.tourists = tourists;
        notifyDataSetChanged();
    }

    interface onNoteClickListener {
        void onNoteClick(int position);
    }

    public void setListener(onNoteClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public TouristViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new TouristViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull TouristAdapter.TouristViewHolder holder, int position) {

        Tourist tourist = tourists.get(position);
        holder.title.setText(tourist.getTitle());
        holder.imageView.setImageResource(tourist.getImages());
        holder.description.setText(tourist.getDescription());



    }

    @Override
    public int getItemCount() {
        return tourists.size();
    }

    class TouristViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private TextView title;
        private ImageView imageView;
        private TextView description;

        public TouristViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitleItem);
            imageView = itemView.findViewById(R.id.imageView_first);
            description = itemView.findViewById(R.id.textViewDescription);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
         //   Toast.makeText(context, "Position" + position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, InfoActivity.class);

            ArrayList<Info> infos = new ArrayList<>();
            infos.add(new Info("Alean Family Resort & Spa Doville", "Первый и единственный отель категории 5* на Пионерском проспекте в Анапе предлагает VIP-отдых для взрослых и детей по системе «Все Включено».",
                    "Адрес: г. Анапа, Пионерский проспект, 14", R.drawable.first_image));

            infos.add(new Info("LES Art Resort", "Подмосковный отель категории 4*, расположен в лесном массиве. Высокий уровень обслуживания и СПА-услуги привлекают гостей круглый год.", "Адрес: Московская обл., Рузский р-он, СП Дороховское", R.drawable.second_image));
            infos.add(new Info("Отель Прометей Клуб", "Современный, стильный отель на самом берегу моря - Прометей Клуб является идеальным местом для любителей клубного отдыха по системе «Все Включено».", "Адрес: г. Сочи, Лазаревское, ул. Речная, 2 «А»", R.drawable.third_image));
            infos.add(new Info("Bridge Resort", "Гостиничный комплекс предлагает не только высокий уровень обслуживания, но и большое количество услуг для пляжного и семейного отдыха.", "Адрес: г. Сочи, Имеретинская низменность, ул. Фигурная, 45", R.drawable.fourth_image));
            infos.add(new Info("Отель Таврида Мыс Лукулл", "Расположение на первой береговой линии, система обслуживания «Все Включено» – все это делает отель очень привлекательным.", "Адрес: Бахчисарайский р-он, пос. Угловое", R.drawable.fifth_image));


            intent.putExtra("title",infos.get(position).getTitle());
            intent.putExtra("description", infos.get(position).getDescription());
            intent.putExtra("street", infos.get(position).getStreet());
            intent.putExtra("image", infos.get(position).getImage());

            context.startActivity(intent);
        }
    }
}
