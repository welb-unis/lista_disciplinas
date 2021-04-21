package br.edu.unis.minhasdisciplinas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import br.edu.unis.minhasdisciplinas.R;
import br.edu.unis.minhasdisciplinas.adapter.ListaDisciplinasAdapter;
import br.edu.unis.minhasdisciplinas.dao.DisciplinaDAO;
import br.edu.unis.minhasdisciplinas.model.Disciplina;

public class ListaDisciplinasActivity extends AppCompatActivity {

    ListView listaDisciplinas;
    DisciplinaDAO dao = new DisciplinaDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_disciplinas);
        carregarWidgets();
        configurarListaDisciplinas();

    }

    private void carregarWidgets() {
        listaDisciplinas = findViewById(R.id.lista_disciplinas);
    }

    private void configurarListaDisciplinas() {
        ListaDisciplinasAdapter adapter = new ListaDisciplinasAdapter(this);
        adapter.addAll(dao.buscarTodos());
        listaDisciplinas.setAdapter(adapter);
    }
}