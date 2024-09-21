using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.ConstrainedExecution;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Xml;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;

namespace ProyectoFinal
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        //COMPROBAR LUGAR DE ERROR
        //MessageBox.Show("No hay error");

        //CONTADORES DE PARTIDAS GANADAS, PERDIDAS Y EMPATADAS
        int ganadasJugador1 = 0;
        int empatadasJugador1 = 0;
        int perdidasJugador1 = 0;

        int ganadasJugador2 = 0;
        int empatadasJugador2 = 0;
        int perdidasJugador2 = 0;

        //CREAMOS EL OBJETO CONEXION CON BASE DE DATOS
        SqlConnection conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["ProyectoFinal.Properties.Settings.JuegoGatoConnectionString"].ConnectionString);

        //URL FIRE AND BLOOD SIGIL
        string fireAndBloodURL = "C:\\Users\\Ivan\\Documents\\OneDrive - Universidad La Salle Bajío\\Semestre Dos\\Programacion Orientada a Entornos Visuales\\EntornosVisuales\\ProyectoFinal\\ProyectoFinal\\FireAndBlood.png";
        //URL LANNISTER SIGIL
        string lannisterURL = "C:\\Users\\Ivan\\Documents\\OneDrive - Universidad La Salle Bajío\\Semestre Dos\\Programacion Orientada a Entornos Visuales\\EntornosVisuales\\ProyectoFinal\\ProyectoFinal\\LannisterSigil.jpg";
        //URL BLACKSTONE 
        string blackstoneURL = "C:\\Users\\Ivan\\Documents\\OneDrive - Universidad La Salle Bajío\\Semestre Dos\\Programacion Orientada a Entornos Visuales\\EntornosVisuales\\ProyectoFinal\\ProyectoFinal\\BlackStone.jpg";

        //EL FOREGROUND WHITE PERTENECE AL TURNO FALSE Y FALSE PERTENECE A CASA LANNISTER
        //EL FOREGROUND BLACK PERTENEEC AL TURNO TRUE Y TRUE PERTENECE A CASA TARGARYEN

        //DECLARACION DE VARIABLE QUE REVISA SI HAY GANADOR
        bool ganador = false;

        //DECLARACION DE VARIABLE DE CANTIDAD DE MOVIMIENTOS
        int cantMovimientos = 0;

        //DECLARACION DE VARIABLES DE ACCION DE BOTONES
        bool btn0x0Action = false;
        bool btn0x1Action = false;
        bool btn0x2Action = false;
        bool btn1x0Action = false;
        bool btn1x1Action = false;
        bool btn1x2Action = false;
        bool btn2x0Action = false;
        bool btn2x1Action = false;
        bool btn2x2Action = false;

        //DECLARACION VARIABLE DE CASA ELEGIDA POR JUGADOR
        string jugador1;
        string jugador2;

        //DECLARACION DE VARIABLE DE TURNO
        bool turno;

        public MainWindow()
        {
            InitializeComponent();
            randomTurn();
            mostrarUsuarios();
        }

        private void mostrarUsuarios() 
        {
            try
            {
                //LINEAS DE CODIGO QUE LLENAN EL COMBOBOX DE ELECCION DE USUARIO CON LOS USUARIOS EN LA BASE DE DATOS
                string consulta = "SELECT nombre FROM Perfil";
                SqlCommand comando = new SqlCommand(consulta, conexion);
                conexion.Open();
                SqlDataReader lector = comando.ExecuteReader();
                List<string> valores = new List<string>();
                while (lector.Read())
                {
                    string valor = lector.GetString(0);
                    valores.Add(valor);
                }
                valores.Add("Crear Jugador");
                cmbJugador1.ItemsSource = valores;
                cmbJugador2.ItemsSource = valores;

                conexion.Close();

                //LINEAS DE CODIGO QUE LLENARAN LAS TABLAS DE ESTADISTICAS CON LOS VALORES DE LA BASE DE DATOS
                string consultaDos = "SELECT * FROM Perfil";
                SqlDataAdapter adaptadorSQL = new SqlDataAdapter(consultaDos, conexion);

                using (adaptadorSQL)
                {
                    DataTable tablaUsuarios = new DataTable();
                    adaptadorSQL.Fill(tablaUsuarios);
                    listBoxUsuarios.DisplayMemberPath = "nombre";
                    listBoxUsuarios.SelectedValuePath = "id_Usuario";
                    listBoxUsuarios.ItemsSource = tablaUsuarios.DefaultView;

                    DataTable tablaGanados = new DataTable();
                    adaptadorSQL.Fill(tablaGanados);
                    listBoxGanados.DisplayMemberPath = "ganadas";
                    listBoxGanados.SelectedValuePath = "id_Usuario";
                    listBoxGanados.ItemsSource = tablaGanados.DefaultView;

                    DataTable tablaEmpatados = new DataTable();
                    adaptadorSQL.Fill(tablaEmpatados);
                    listBoxEmpatados.DisplayMemberPath = "empatadas";
                    listBoxEmpatados.SelectedValuePath = "id_Usuario";
                    listBoxEmpatados.ItemsSource = tablaEmpatados.DefaultView;

                    DataTable tablaPerdidos = new DataTable();
                    adaptadorSQL.Fill(tablaPerdidos);
                    listBoxPerdidos.DisplayMemberPath = "perdidas";
                    listBoxPerdidos.SelectedValuePath = "id_Usuario";
                    listBoxPerdidos.ItemsSource = tablaPerdidos.DefaultView;
                }
            }
            catch(Exception ex) 
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void randomTurn()
        {
            Random random = new Random();
            int numeroAleatorio = random.Next(0, 10);

            if (numeroAleatorio <= 5)
            {
                turno = false;
            }
            else
            {
                turno = true;
            }
        }

        private void ButtonInicio_Click(object sender, RoutedEventArgs e)
        {
            objsComenzar.Visibility = Visibility.Collapsed;
            objsElegirJugador.Visibility = Visibility.Visible;
        }

        private void btn0x0_Click(object sender, RoutedEventArgs e)
        {
            if (btn0x0Action == false && ganador == false) {
                btnChangeBackground(btn0x0);
                btn0x0Action = true;
                checkerGame();
            }
        }

        private void btn0x1_Click(object sender, RoutedEventArgs e)
        {
            if (btn0x1Action == false && ganador == false)
            {
                btnChangeBackground(btn0x1);
                btn0x1Action = true;
                checkerGame();
            }
        }

        private void btn0x2_Click(object sender, RoutedEventArgs e)
        {
            if (btn0x2Action == false && ganador == false) {
                btnChangeBackground(btn0x2);
                btn0x2Action = true;
                checkerGame();
            }
        }

        private void btn1x0_Click(object sender, RoutedEventArgs e)
        {
            if (btn1x0Action == false && ganador == false) {
                btnChangeBackground(btn1x0);
                btn1x0Action = true;
                checkerGame();
            }
        }

        private void btn1x1_Click(object sender, RoutedEventArgs e)
        {
            if (btn1x1Action == false && ganador == false)
            {
                btnChangeBackground(btn1x1);
                btn1x1Action = true;
                checkerGame();
            }
        }

        private void btn1x2_Click(object sender, RoutedEventArgs e)
        {
            if (btn1x2Action == false && ganador == false)
            {
                btnChangeBackground(btn1x2);
                btn1x2Action = true;
                checkerGame();
            }
        }

        private void btn2x0_Click(object sender, RoutedEventArgs e)
        {
            if (btn2x0Action == false && ganador == false)
            {
                btnChangeBackground(btn2x0);
                btn2x0Action = true;
                checkerGame();
            }
        }

        private void btn2x1_Click(object sender, RoutedEventArgs e)
        {
            if (btn2x1Action == false && ganador == false)
            {
                btnChangeBackground(btn2x1);
                btn2x1Action = true;
                checkerGame();
            }
        }

        private void btn2x2_Click(object sender, RoutedEventArgs e)
        {
            if (btn2x2Action == false && ganador == false)
            {
                btnChangeBackground(btn2x2);
                btn2x2Action = true;
                checkerGame();
            }
        }

        private void btnChangeBackground(Button nombreBtn)
        {
            if (turno == false)
            {
                ((ImageBrush)nombreBtn.Background).ImageSource = new BitmapImage(new Uri(lannisterURL));
                nombreBtn.Foreground = new SolidColorBrush(Colors.White);
                if (turnoJugador1.Visibility == Visibility.Visible)
                {
                    turnoJugador2.Visibility = Visibility.Visible;
                    turnoJugador1.Visibility = Visibility.Collapsed;
                }
                else 
                {
                    turnoJugador1.Visibility = Visibility.Visible;
                    turnoJugador2.Visibility = Visibility.Collapsed;
                }
                turno = true;
            }
            else if (turno == true)
            {
                ((ImageBrush)nombreBtn.Background).ImageSource = new BitmapImage(new Uri(fireAndBloodURL));
                nombreBtn.Foreground = new SolidColorBrush(Colors.Black);
                if (turnoJugador1.Visibility == Visibility.Visible)
                {
                    turnoJugador2.Visibility = Visibility.Visible;
                    turnoJugador1.Visibility = Visibility.Collapsed;
                }
                else
                {
                    turnoJugador1.Visibility = Visibility.Visible;
                    turnoJugador2.Visibility = Visibility.Collapsed;
                }
                turno = false;
            }
            cantMovimientos++;
        }

        private void checkerGame()
        {
            if (cantMovimientos > 4)
            {
                if (btn0x0.Foreground.ToString() == btn0x1.Foreground.ToString() && btn0x1.Foreground.ToString() == btn0x2.Foreground.ToString() ||
                    btn1x0.Foreground.ToString() == btn1x1.Foreground.ToString() && btn1x1.Foreground.ToString() == btn1x2.Foreground.ToString() ||
                    btn2x0.Foreground.ToString() == btn2x1.Foreground.ToString() && btn2x1.Foreground.ToString() == btn2x2.Foreground.ToString() ||
                    
                    btn0x0.Foreground.ToString() == btn1x0.Foreground.ToString() && btn1x0.Foreground.ToString() == btn2x0.Foreground.ToString() ||
                    btn0x1.Foreground.ToString() == btn1x1.Foreground.ToString() && btn1x1.Foreground.ToString() == btn2x1.Foreground.ToString() ||
                    btn0x2.Foreground.ToString() == btn1x2.Foreground.ToString() && btn1x2.Foreground.ToString() == btn2x2.Foreground.ToString() ||
                    
                    btn0x0.Foreground.ToString() == btn1x1.Foreground.ToString() && btn1x1.Foreground.ToString() == btn2x2.Foreground.ToString() ||
                    btn2x0.Foreground.ToString() == btn1x1.Foreground.ToString() && btn1x1.Foreground.ToString() == btn0x2.Foreground.ToString())
                {
                    ganador = true;
                    objsJuego.Visibility = Visibility.Collapsed;
                    objsGanador.Visibility = Visibility.Visible;

                    if (turnoJugador1.Visibility == Visibility.Visible)
                    {
                        lblNombreGanador.Content = cmbJugador2.SelectedItem.ToString();
                        ganadasJugador2++;
                        perdidasJugador1++;
                    }
                    else 
                    {
                        lblNombreGanador.Content = cmbJugador1.SelectedItem.ToString();
                        ganadasJugador1++;
                        perdidasJugador2++;
                    }
                }else if(cantMovimientos == 9)
                {
                    objsJuego.Visibility = Visibility.Collapsed;
                    objsEmpate.Visibility = Visibility.Visible;
                    empatadasJugador1++;
                    empatadasJugador2++;
                }
            }
            else
            {
                return;
            }
        }

        private void salirJuego()
        {
            Window window = Window.GetWindow(this);
            window.Close();
            actualizarBaseDatos(cmbJugador1, ganadasJugador1, empatadasJugador1, perdidasJugador1);
            actualizarBaseDatos(cmbJugador2, ganadasJugador2, empatadasJugador2, perdidasJugador2);
        }

        private void reiniciarJuego()
        {
            btn0x0.Foreground = Brushes.Aquamarine;
            btn0x1.Foreground = Brushes.Red;
            btn0x2.Foreground = Brushes.Green;
            btn1x0.Foreground = Brushes.GreenYellow;
            btn1x1.Foreground = Brushes.Tan;
            btn1x2.Foreground = Brushes.Snow;
            btn2x0.Foreground = Brushes.RosyBrown;
            btn2x1.Foreground = Brushes.AliceBlue;
            btn2x2.Foreground = Brushes.DarkBlue;

            if (ganador == true)
            {
                objsGanador.Visibility = Visibility.Collapsed;
            }
            else
            {
                objsEmpate.Visibility = Visibility.Collapsed;
            }

            objsJuego.Visibility = Visibility.Visible;

            ganador = false;

            cantMovimientos = 0;

            btn0x0Action = false;
            btn0x1Action = false;
            btn0x2Action = false;
            btn1x0Action = false;
            btn1x1Action = false;
            btn1x2Action = false;
            btn2x0Action = false;
            btn2x1Action = false;
            btn2x2Action = false;

            turno = false;

            ((ImageBrush)btn0x0.Background).ImageSource = new BitmapImage(new Uri(blackstoneURL));
            ((ImageBrush)btn0x1.Background).ImageSource = new BitmapImage(new Uri(blackstoneURL));
            ((ImageBrush)btn0x2.Background).ImageSource = new BitmapImage(new Uri(blackstoneURL));
            ((ImageBrush)btn1x0.Background).ImageSource = new BitmapImage(new Uri(blackstoneURL));
            ((ImageBrush)btn1x1.Background).ImageSource = new BitmapImage(new Uri(blackstoneURL));
            ((ImageBrush)btn1x2.Background).ImageSource = new BitmapImage(new Uri(blackstoneURL));
            ((ImageBrush)btn2x0.Background).ImageSource = new BitmapImage(new Uri(blackstoneURL));
            ((ImageBrush)btn2x1.Background).ImageSource = new BitmapImage(new Uri(blackstoneURL));
            ((ImageBrush)btn2x2.Background).ImageSource = new BitmapImage(new Uri(blackstoneURL));

            randomTurn();

            if (turno == false)
            {
                if (jugador1.Equals("Lannister"))
                {
                    turnoJugador1.Visibility = Visibility.Visible;
                    turnoJugador2.Visibility = Visibility.Collapsed;
                }
                else 
                {
                    turnoJugador2.Visibility = Visibility.Visible;
                    turnoJugador1.Visibility = Visibility.Collapsed;
                }
            }
            else if (turno == true)
            {
                if (jugador1.Equals("Targaryen"))
                {
                    turnoJugador1.Visibility = Visibility.Visible;
                    turnoJugador2.Visibility = Visibility.Collapsed;
                }
                else
                {
                    turnoJugador2.Visibility = Visibility.Visible;
                    turnoJugador1.Visibility = Visibility.Collapsed;
                }
            }
        }

        private void cmbJugador1_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if(cmbJugador1.SelectedItem.ToString() == "Crear Jugador")
            {
                lblNombreUsuarioJugador1.Visibility = Visibility.Visible;
                txbJugador1.Visibility = Visibility.Visible;
                btnCrearJugador1.Visibility = Visibility.Visible;

                lblEligeCasaJugador1.Visibility = Visibility.Collapsed;
                btnEligeCasaTargaryenJugador1.Visibility = Visibility.Collapsed;
                btnEligeCasaLannisterJugador1.Visibility = Visibility.Collapsed;
            }
            else if(cmbJugador1.SelectedItem != null && cmbJugador1.SelectedItem.ToString() != "Crear Jugador")
            {
                lblEligeCasaJugador1.Visibility = Visibility.Visible;
                btnEligeCasaTargaryenJugador1.Visibility = Visibility.Visible;
                btnEligeCasaLannisterJugador1.Visibility = Visibility.Visible;

                lblNombreUsuarioJugador1.Visibility = Visibility.Collapsed;
                txbJugador1.Visibility = Visibility.Collapsed;
                btnCrearJugador1.Visibility = Visibility.Collapsed;

                lblNombreJugador1.Content = cmbJugador1.SelectedItem.ToString();
            }
        }

        private void cmbJugador2_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (cmbJugador2.SelectedItem.ToString() == "Crear Jugador")
            {
                lblNombreUsuarioJugador2.Visibility = Visibility.Visible;
                txbJugador2.Visibility = Visibility.Visible;
                btnCrearJugador2.Visibility = Visibility.Visible;

                lblEligeCasaJugador2.Visibility = Visibility.Collapsed;
                btnEligeCasaTargaryenJugador2.Visibility = Visibility.Collapsed;
                btnEligeCasaLannisterJugador2.Visibility = Visibility.Collapsed;
            }
            else if(cmbJugador2.SelectedItem != null && cmbJugador2.SelectedItem.ToString() != "Crear Jugador")
            {
                lblEligeCasaJugador2.Visibility = Visibility.Visible;

                lblNombreUsuarioJugador2.Visibility = Visibility.Collapsed;
                txbJugador2.Visibility = Visibility.Collapsed;
                btnCrearJugador2.Visibility = Visibility.Collapsed;

                if (btnEligeCasaTargaryenJugador1.Visibility == Visibility.Visible)
                {
                    ((ImageBrush)jugador1Sigil.Background).ImageSource = new BitmapImage(new Uri(fireAndBloodURL));
                    ((ImageBrush)jugador2Sigil.Background).ImageSource = new BitmapImage(new Uri(lannisterURL));
                    btnEligeCasaLannisterJugador2.Visibility = Visibility.Visible;

                    jugador2 = "Lannister";
                }
                else if (btnEligeCasaLannisterJugador1.Visibility == Visibility.Visible)
                {
                    ((ImageBrush)jugador1Sigil.Background).ImageSource = new BitmapImage(new Uri(lannisterURL));
                    ((ImageBrush)jugador2Sigil.Background).ImageSource = new BitmapImage(new Uri(fireAndBloodURL));
                    btnEligeCasaTargaryenJugador2.Visibility = Visibility.Visible;

                    jugador2 = "Targaryen";
                }

                lblNombreJugador2.Content = cmbJugador2.SelectedItem.ToString();
            }
        }

        private void btnEligeCasaTargaryenJugador1_Click(object sender, RoutedEventArgs e)
        {
            btnEligeCasaTargaryenJugador2.Visibility = Visibility.Collapsed;
            btnEligeCasaLannisterJugador1.Visibility = Visibility.Collapsed;

            lblEleccionJugador2.Visibility = Visibility.Visible;
            cmbJugador2.Visibility = Visibility.Visible;

            jugador1 = "Targaryen";
        }

        private void btnEligeCasaLannisterJugador1_Click(object sender, RoutedEventArgs e)
        {
            btnEligeCasaTargaryenJugador1.Visibility = Visibility.Collapsed;
            btnEligeCasaLannisterJugador2.Visibility = Visibility.Collapsed;

            lblEleccionJugador2.Visibility = Visibility.Visible;
            cmbJugador2.Visibility = Visibility.Visible;

            jugador1 = "Lannister;";
        }

        private void btnEligeCasaTargaryenJugador2_Click(object sender, RoutedEventArgs e)
        {
            btnComenzarJuego.Visibility = Visibility.Visible;
        }

        private void btnEligeCasaLannisterJugador2_Click(object sender, RoutedEventArgs e)
        {
            btnComenzarJuego.Visibility = Visibility.Visible;
        }

        private void btnComenzarJuego_Click(object sender, RoutedEventArgs e)
        {
            if (cmbJugador1.SelectedItem.ToString() == cmbJugador2.SelectedItem.ToString())
            {
                MessageBox.Show("Por favor, elige jugdores diferentes");
            }
            else 
            {
                objsElegirJugador.Visibility = Visibility.Collapsed;
                objsJuego.Visibility = Visibility.Visible;

                if (turno == false)
                {
                    if (jugador1.Equals("Lannister"))
                    {
                        turnoJugador1.Visibility = Visibility.Visible;
                        turnoJugador2.Visibility = Visibility.Collapsed;
                    }
                    else
                    {
                        turnoJugador2.Visibility = Visibility.Visible;
                        turnoJugador1.Visibility = Visibility.Collapsed;
                    }
                }
                else if (turno == true)
                {
                    if (jugador1.Equals("Targaryen"))
                    {
                        turnoJugador1.Visibility = Visibility.Visible;
                        turnoJugador2.Visibility = Visibility.Collapsed;
                    }
                    else
                    {
                        turnoJugador2.Visibility = Visibility.Visible;
                        turnoJugador1.Visibility = Visibility.Collapsed;
                    }
                }
            }
        }

        private void btnSalirGanador_Click(object sender, RoutedEventArgs e)
        {
            salirJuego();
        }

        private void btnReiniciarGanador_Click(object sender, RoutedEventArgs e)
        {
            reiniciarJuego();
        }

        private void btnSalirEmpate_Click(object sender, RoutedEventArgs e)
        {
            salirJuego();
        }

        private void btnReiniciarEmpate_Click(object sender, RoutedEventArgs e)
        {
            reiniciarJuego();
        }

        private void btnCrearJugador1_Click(object sender, RoutedEventArgs e)
        {
            crearJugador(txbJugador1);
            MessageBox.Show("El jugador se agrego correctamente");
            mostrarUsuarios();
        }

        private void btnCrearJugador2_Click(object sender, RoutedEventArgs e)
        {
            crearJugador(txbJugador2);
            MessageBox.Show("El jugador se agrego correctamente");
            mostrarUsuarios();
        }

        private void crearJugador(TextBox txb) {
            string consulta = "INSERT INTO Perfil (nombre, ganadas, empatadas, perdidas) VALUES (@nombre, @ganadas, @empatadas, @perdidas)";
            conexion.Open();
            SqlCommand myCommand = new SqlCommand(consulta, conexion);
            myCommand.Parameters.AddWithValue("@nombre", txb.Text);
            myCommand.Parameters.AddWithValue("@ganadas", 0);
            myCommand.Parameters.AddWithValue("@empatadas", 0);
            myCommand.Parameters.AddWithValue("@perdidas", 0);
            myCommand.ExecuteNonQuery();
            conexion.Close();

            lblNombreUsuarioJugador1.Visibility = Visibility.Collapsed;
            txbJugador1.Visibility = Visibility.Collapsed;
            btnCrearJugador1.Visibility = Visibility.Collapsed;

            lblNombreUsuarioJugador2.Visibility = Visibility.Collapsed;
            txbJugador2.Visibility = Visibility.Collapsed;
            btnCrearJugador2.Visibility = Visibility.Collapsed;
        }

        private void btnEstadisticas_Click(object sender, RoutedEventArgs e)
        {
            objsElegirJugador.Visibility = Visibility.Collapsed;
            objsEstadisticas.Visibility = Visibility.Visible;
        }

        private void btnModificar_Click(object sender, RoutedEventArgs e)
        {
            if (listBoxUsuarios.SelectedItem != null)
            {
                lblNuevoNombre.Visibility = Visibility.Visible;
                txbNuevoNombre.Visibility = Visibility.Visible;
                btnActualizarNombre.Visibility = Visibility.Visible;
            }
            else 
            {
                MessageBox.Show("Por favor, selecciona algun usuario para modificar.");
            }
        }

        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            if (listBoxUsuarios.SelectedItem != null)
            {
                string consulta = "DELETE FROM Perfil WHERE id_Usuario = @selected_Id";
                SqlCommand command = new SqlCommand(consulta, conexion);
                conexion.Open();
                command.Parameters.AddWithValue("@selected_Id", listBoxUsuarios.SelectedValue);
                command.ExecuteNonQuery();
                conexion.Close();
                mostrarUsuarios();
            }
            else 
            {
                MessageBox.Show("Por favor, selecciona algun usuario para eliminar");
            }
        }

        private void btnActualizarNombre_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                string consulta = "UPDATE Perfil SET nombre = @nombre WHERE id_Usuario = @selected_Id";
                SqlCommand command = new SqlCommand(consulta, conexion);
                conexion.Open();
                command.Parameters.AddWithValue("@nombre", txbNuevoNombre.Text);
                command.Parameters.AddWithValue("@selected_Id", listBoxUsuarios.SelectedValue);
                command.ExecuteNonQuery();
                conexion.Close();
                mostrarUsuarios();

                txbNuevoNombre.Text = "";
                txbNuevoNombre.Visibility = Visibility.Collapsed;
                lblNuevoNombre.Visibility = Visibility.Collapsed;
                btnActualizarNombre.Visibility = Visibility.Collapsed;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnRegresar_Click(object sender, RoutedEventArgs e)
        {
            objsElegirJugador.Visibility = Visibility.Visible;
            objsEstadisticas.Visibility = Visibility.Collapsed;
        }

        private void actualizarBaseDatos(ComboBox cmb, int partidasGanadas, int partidasEmpatadas, int partidasPerdidas) 
        {
            try
            {
                string consulta = "UPDATE Perfil SET ganadas = ganadas + @partidasGanadas, empatadas = empatadas + @partidasEmpatadas, perdidas = perdidas + @partidasPerdidas WHERE nombre = @selected_nombre";
                SqlCommand command = new SqlCommand(consulta, conexion);
                conexion.Open();
                command.Parameters.AddWithValue("@partidasGanadas", partidasGanadas);
                command.Parameters.AddWithValue("@partidasEmpatadas", partidasEmpatadas);
                command.Parameters.AddWithValue("@partidasPerdidas", partidasPerdidas);
                command.Parameters.AddWithValue("@selected_nombre", cmb.SelectedItem.ToString());
                command.ExecuteNonQuery();
                conexion.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
    }
}