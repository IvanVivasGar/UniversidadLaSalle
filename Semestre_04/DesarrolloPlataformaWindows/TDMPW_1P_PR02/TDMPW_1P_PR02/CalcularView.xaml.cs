namespace MauiApp1;

public partial class CalcularView : ContentPage
{
	double pulgadas;
	public CalcularView()
	{
		InitializeComponent();
	}
	private void ClickedPulgadas(object sender, EventArgs s){
		pulgadas = (double.Parse(this.entradaCm.Text) / 2.54);
		this.lblResultadosPulgadas.Text = "La medida en pulgadas es de: " + this.pulgadas.ToString() + " pulgadas";
	}
}