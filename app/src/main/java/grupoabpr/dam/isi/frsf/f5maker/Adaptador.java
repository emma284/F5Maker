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

public class Adaptador extends ArrayAdapter<Fila> {


    private LayoutInflater layoutInflater;

    public Adaptador(Context ctx, List<Fila> listaDeFilas) {
        super(ctx, 0, listaDeFilas);
        layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View filaNueva = convertView;
        if (filaNueva == null)
            filaNueva = layoutInflater.inflate(R.layout.fila_horario, parent, false);

        TextView tvHora = (TextView) filaNueva.findViewById(R.id.textHora);
        CheckBox cbDom = (CheckBox) filaNueva.findViewById(R.id.cbDomingo);
        CheckBox cbLun = (CheckBox) filaNueva.findViewById(R.id.cbLunes);
        CheckBox cbMar = (CheckBox) filaNueva.findViewById(R.id.cbMartes);
        CheckBox cbMie = (CheckBox) filaNueva.findViewById(R.id.cbMiercoles);
        CheckBox cbJue = (CheckBox) filaNueva.findViewById(R.id.cbJueves);
        CheckBox cbVie = (CheckBox) filaNueva.findViewById(R.id.cbViernes);
        CheckBox cbSab = (CheckBox) filaNueva.findViewById(R.id.cbSabado);

        Fila fila = getItem(position);

        tvHora.setText(fila.getHora());
        cbDom.setChecked(fila.getDomingo());
        cbLun.setChecked(fila.getLunes());
        cbMar.setChecked(fila.getMartes());
        cbMie.setChecked(fila.getMiercoles());
        cbJue.setChecked(fila.getJueves());
        cbVie.setChecked(fila.getViernes());
        cbSab.setChecked(fila.getSabado());




        return filaNueva;
    }


}
