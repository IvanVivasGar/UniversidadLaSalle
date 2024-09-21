using Microsoft.Maui.Controls;

namespace TDMPW_2P_EX_77850;

public partial class MainPage : TabbedPage
{
	double precioActual = 0;
	double acumuladorPrecio = 0;
	public MainPage()
	{
		InitializeComponent();
	}

	public void ClickedAdd(object sender, EventArgs e)
	{
		acumuladorPrecio += precioActual;
		this.lblTotal.Text = "Total....................$  " + acumuladorPrecio + ".00    ";
	}

	public void ClickedMinus(object sender, EventArgs e)
	{
		if((acumuladorPrecio - precioActual) != 0){
			acumuladorPrecio -= precioActual;
			this.lblTotal.Text = "Total....................$  " + acumuladorPrecio + ".00    ";
		}
	}

	public void ClickedProd1(object sender, EventArgs e)
	{
		this.imgProdActual.Source = "menu2.jpeg";
		this.lblTitulo.Text = "Cheesecake Roulet";
		this.precioArticulo.Text = "- $ 40.00";
		this.lblInfo1.Text = "Grande (20oz - 200gr)";
		this.lblInfo2.Text = "50 calorias";
		this.lblInfo3.Text = "Con leche";
		precioActual = 40;
		acumuladorPrecio = 40;
		this.lblTotal.Text = "Total....................$  " + acumuladorPrecio + ".00    ";
	}

	public void ClickedProd2(object sender, EventArgs e)
	{
		this.imgProdActual.Source = "menu3.jpeg";
		this.lblTitulo.Text = "Caramel Macchiato";
		this.precioArticulo.Text = "- $ 45.00";
		this.lblInfo1.Text = "Mediamo (10oz - 200ml)";
		this.lblInfo2.Text = "5 calorias";
		this.lblInfo3.Text = "Con leche";
		precioActual = 45;
		acumuladorPrecio = 45;
		this.lblTotal.Text = "Total....................$  " + acumuladorPrecio + ".00    ";
	}

	public void ClickedProd3(object sender, EventArgs e)
	{
		this.imgProdActual.Source = "menu4.jpeg";
		this.lblTitulo.Text = "Croissant";
		this.precioArticulo.Text = "- $ 50.00";
		this.lblInfo1.Text = "Grande (20oz - 200gr)";
		this.lblInfo2.Text = "0 calorias";
		this.lblInfo3.Text = "Sin leche";
		precioActual = 50;
		acumuladorPrecio = 50;
		this.lblTotal.Text = "Total....................$  " + acumuladorPrecio + ".00    ";
	}
}