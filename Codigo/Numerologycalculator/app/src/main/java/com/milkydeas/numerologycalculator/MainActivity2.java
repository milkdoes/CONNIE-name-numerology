package com.milkydeas.numerologycalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        Button switchButton = (Button) findViewById(R.id.button_Regresar);

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity1.class);
                startActivity(intent);
            }
        });

        // Boton de Valor
        Button NumerologiaButton = (Button) findViewById(R.id.button_Valor);

        NumerologiaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener texto del nombre
                EditText Nombre = (EditText)findViewById(R.id.editText_Nombre);
                String texto = Nombre.getText().toString();

                // Definir texto del numero del nombre
                TextView NumeroNombre = (TextView)findViewById(R.id.textView_NumeroNombre);
                NumeroNombre.setText("Numero del nombre: " + Integer.toString(NumerologyValue(texto)));

                // Definir la descripcion del nombre
                EditText DescripcionNombre = (EditText)findViewById(R.id.editText_Descripcion);
                DescripcionNombre.setText(Description(NumerologyValue(texto)));
            }
        });

        Button BorrarButton = (Button) findViewById(R.id.button_Borrar);

        BorrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Declarar variables para controlar los componentes
                EditText Nombre = (EditText)findViewById(R.id.editText_Nombre);
                TextView NumeroNombre = (TextView)findViewById(R.id.textView_NumeroNombre);
                EditText DescripcionNombre = (EditText)findViewById(R.id.editText_Descripcion);

                // Borrar los valores en las ediciones de texto
                Nombre.setText("");
                NumeroNombre.setText("Numero del nombre: ");
                DescripcionNombre.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Numerologia
    public int NumerologyValue(String NameString)
    {
        // Auxiliary variable declaration
        int NameValue = 0;
        int[] Dig = new int[4];
        char[] ListN; // char array of all letters (including spaces)

        // Clean last name value
        NameValue = 0;

        // Convert substrings to char elements
        ListN = new char[NameString.length()];
        for (int i = 0; i < NameString.length(); i++)
        {
            ListN[i] = NameString.toUpperCase().charAt(i);
        }

        // Calculate the value of the whole string
        for (int i = 0; i < NameString.length(); i++)
        {
            NameValue += LetterValue(ListN[i]);
        }

        // Determine the NameValue if it is not 11 or 22
        switch (NameValue)
        {
            case 22:
                return NameValue;

            case 11:
                return NameValue;

            default:
                // Cycle if NameValue has 2 or more digits
                while (NameValue >= 10 && NameValue != 11
                        && NameValue != 22)
                {
                    // Put digits in Dig array to sum them up
                    for(int i = 0; i < Dig.length; i++)
                    {
                        Dig[i] = NameValue % 10;
                        NameValue = (NameValue - Dig[i]) / 10;
                    }

                    // Clear old name value
                    NameValue = 0;

                    // New name value
                    for (int c = 0; c < Dig.length; c++)
                    {
                        NameValue += Dig[c];
                        Dig[c] = 0; // Clear digit value
                    }
                }

                // Return NameValue
                return NameValue;
        }
    }

    // Subprogram that determines the value of each letter
    public static int LetterValue(char Letter)
    {
        switch (Letter)
        {
            case 'A': case 'a':
            return 1;

            case 'B': case 'b':
            return 2;

            case 'C': case 'c':
            return 3;

            case 'D': case 'd':
            return 4;

            case 'E': case 'e':
            return 5;

            case 'F': case 'f':
            return 6;

            case 'G': case 'g':
            return 7;

            case 'H': case 'h':
            return 8;

            case 'I': case 'i':
            return 9;

            case 'J': case 'j':
            return 1;

            case 'K': case 'k':
            return 2;

            case 'L': case 'l':
            return 3;

            case 'M': case 'm':
            return 4;

            case 'N': case 'n':
            return 5;

            case 'O': case 'o':
            return 6;

            case 'P': case 'p':
            return 7;

            case 'Q': case 'q':
            return 8;

            case 'R': case 'r':
            return 9;

            case 'S': case 's':
            return 1;

            case 'T': case 't':
            return 2;

            case 'U': case 'u':
            return 3;

            case 'V': case 'v':
            return 4;

            case 'W': case 'w':
            return 5;

            case 'X': case 'x':
            return 6;

            case 'Y': case 'y':
            return 7;

            case 'Z': case 'z':
            return 8;

            case ' ':
                return 0;

            case '\0':
                return 0;

            default:
                return 0;
        }
    }

    // Subprogram that prints personal description based on the name sum
    public static String Description(int NameNumber)
    {
        switch (NameNumber)
        {
            case 1:
                return "Accion iniciativa, pionero, lider, independiente, alcanzador, individual.";

            case 2:
                return "Cooperador, adaptable, considera a los demas, meditador.";

            case 3:
                return "Expresivo, social, artistico, la alegria de vivir.";

            case 4:
                return "Una fundacion, el orden, el servicio, la lucha contra los limites, un crecimiento constante.";

            case 5:
                return "Expansividad, visionario, la aventura, el uso constructivo de la libertad.";

            case 6:
                return "La responsabilidad, la proteccion, la crianza, la comunidad, el equilibrio, la simpatia.";

            case 7:
                return "Analisis, comprension, conocimiento, conciencia, estudioso, meditador.";

            case 8:
                return "Esfuerzos practicos, orientados al estatus, busqueda del poder, objetivos materiales altos.";

            case 9:
                return "Humanitario, naturaleza donadora, la abnegacion, obligaciones, la expresion creativa.";

            case 11:
                return "Plano espiritual superior, intuitivo, iluminacion, idealista, un visionario.";

            case 22:
                return "El Maestro Constructor, grandes esfuerzos, fuerza poderosa, liderazgo.";

            // In case of error
            default:
                return ":)";
        }
    }
}
