package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

/**
 * Created by Matias on 8/3/2018.
 */

public class Adaptador2 extends ArrayAdapter<Fila2> {


    private LayoutInflater layoutInflater;

    public Adaptador2(Context ctx, List<Fila2> listaDeFilas) {
        super(ctx, 0, listaDeFilas);
        layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View filaNueva = convertView;
        if (filaNueva == null)
            filaNueva = layoutInflater.inflate(R.layout.fila_horario2, parent, false);

        TextView tvHora = (TextView) filaNueva.findViewById(R.id.textHora2);
        TextView tvDom = (TextView) filaNueva.findViewById(R.id.textDomingo);
        TextView tvLun = (TextView) filaNueva.findViewById(R.id.textLunes);
        TextView tvMar = (TextView) filaNueva.findViewById(R.id.textMartes);
        TextView tvMie = (TextView) filaNueva.findViewById(R.id.textMiercoles);
        TextView tvJue = (TextView) filaNueva.findViewById(R.id.textJueves);
        TextView tvVie = (TextView) filaNueva.findViewById(R.id.textViernes);
        TextView tvSab = (TextView) filaNueva.findViewById(R.id.textSabado);

        Fila2 fila = getItem(position);

        tvHora.setText(fila.getHora());
        tvDom.setText(String.valueOf(fila.getDomingo()));
        tvLun.setText(String.valueOf(fila.getLunes()));
        tvMar.setText(String.valueOf(fila.getMartes()));
        tvMie.setText(String.valueOf(fila.getMiercoles()));
        tvJue.setText(String.valueOf(fila.getJueves()));
        tvVie.setText(String.valueOf(fila.getViernes()));
        tvSab.setText(String.valueOf(fila.getSabado()));




        return filaNueva;
    }


}
