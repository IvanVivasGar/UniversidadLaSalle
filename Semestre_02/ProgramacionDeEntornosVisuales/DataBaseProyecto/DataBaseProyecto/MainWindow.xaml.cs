using System;
using System.Collections.Generic;
using System.Linq;
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
using System.Configuration;
using System.Data.SqlClient;
using System.Data;

namespace DataBaseProyecto
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        SqlConnection laConneccionDB;
        public MainWindow()
        {
            InitializeComponent();

            string miconectBD = ConfigurationManager.ConnectionStrings["DataBaseProyecto.Properties.Settings.Simple_CRUDConnectionString"].ConnectionString;
            MessageBox.Show("Se conecto con la base de datos");
            laConneccionDB = new SqlConnection(miconectBD);
            MostrarUsr();
        }

        public void MostrarUsr()
        {
            try
            {
                string consulta = "SELECT * FROM Perfil";
                SqlDataAdapter adaptadorSQL = new SqlDataAdapter(consulta, laConneccionDB);

                using (adaptadorSQL)
                {
                    DataTable tablaUsuario = new DataTable();
                    adaptadorSQL.Fill(tablaUsuario);
                    losUsr.DisplayMemberPath = "Nombre";
                    losUsr.SelectedValuePath = "Id_Usuario";
                    losUsr.ItemsSource = tablaUsuario.DefaultView;

                    DataTable tablaContrasenas = new DataTable();
                    adaptadorSQL.Fill(tablaContrasenas);
                    lasContrasenas.DisplayMemberPath = "Contrasena";
                    lasContrasenas.SelectedValuePath = "Id_Usuario";
                    lasContrasenas.ItemsSource = tablaContrasenas.DefaultView;

                    DataTable tablaPuntos = new DataTable();
                    adaptadorSQL.Fill(tablaPuntos);
                    losPuntos.DisplayMemberPath = "Puntos";
                    losPuntos.SelectedValuePath = "Id_Usuario";
                    losPuntos.ItemsSource = tablaPuntos.DefaultView;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void Borrar(object sender, RoutedEventArgs e)
        {
            String consulta = "DELETE FROM perfil WHERE Id_Usuario=@elID";
            SqlCommand miComandoSQL = new SqlCommand(consulta, laConneccionDB);
            laConneccionDB.Open();
            miComandoSQL.Parameters.AddWithValue("@elID", losUsr.SelectedValue);
            miComandoSQL.ExecuteNonQuery();
            laConneccionDB.Close();
            MostrarUsr();
        }

        private void btnCrearPerfil_Click(object sender, RoutedEventArgs e)
        {
            String consulta = "INSERT INTO Perfil (Nombre, Contrasena, Puntos) VALUES (@nombre, @contrasena, @puntos)";
            SqlCommand miComandoI = new SqlCommand(consulta, laConneccionDB);
            laConneccionDB.Open();
            miComandoI.Parameters.AddWithValue("@nombre", txtUsuario.Text);
            miComandoI.Parameters.AddWithValue("@contrasena", txtContrasena.Text);
            miComandoI.Parameters.AddWithValue("@puntos", txtPuntos.Text);
            miComandoI.ExecuteNonQuery();
            laConneccionDB.Close();
            MostrarUsr();
            txtUsuario.Text = "";
            txtContrasena.Text = "";
            txtPuntos.Text = "";
        }

        private void Actualizar(object sender, RoutedEventArgs e)
        {
                actualizarA.Visibility = Visibility.Visible;
                usuarioA.Visibility = Visibility.Visible;
                contraA.Visibility = Visibility.Visible;
                txtContraA.Visibility = Visibility.Visible;
                txtUsuarioA.Visibility = Visibility.Visible;
                puntosA.Visibility = Visibility.Visible;
                txtPuntosA.Visibility = Visibility.Visible;
                Update.Visibility = Visibility.Visible;
        }

        private void Update_Click(object sender, RoutedEventArgs e)
        {
            string consulta = "UPDATE Perfil SET Nombre = @nombre, Contrasena = @contrasena, Puntos = @puntos WHERE Id_Usuario = @elID";
            SqlCommand miComandoI = new SqlCommand(consulta, laConneccionDB);
            laConneccionDB.Open();
            miComandoI.Parameters.AddWithValue("@nombre", txtUsuarioA.Text);
            miComandoI.Parameters.AddWithValue("@contrasena", txtContraA.Text);
            miComandoI.Parameters.AddWithValue("@puntos", txtPuntosA.Text);
            miComandoI.Parameters.AddWithValue("@elID", losUsr.SelectedValue);
            miComandoI.ExecuteNonQuery();
            laConneccionDB.Close();
            MostrarUsr();
            txtUsuarioA.Text = "";
            txtContraA.Text = "";
            txtPuntosA.Text = "";

            actualizarA.Visibility = Visibility.Hidden;
            usuarioA.Visibility = Visibility.Hidden;
            contraA.Visibility = Visibility.Hidden;
            txtContraA.Visibility = Visibility.Hidden;
            txtUsuarioA.Visibility = Visibility.Hidden;
            puntosA.Visibility = Visibility.Hidden;
            txtPuntosA.Visibility = Visibility.Hidden;
            Update.Visibility = Visibility.Hidden;
        }
    }
}