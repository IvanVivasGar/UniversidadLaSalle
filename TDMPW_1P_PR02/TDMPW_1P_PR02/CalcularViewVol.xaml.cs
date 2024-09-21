namespace MauiApp1;

public partial class CalcularViewVol : ContentPage
{
	double galon;
	public CalcularViewVol()
	{
		InitializeComponent();
	}
	private void ClickedGalones(object sender, EventArgs s){
		galon = (double.Parse(this.entradaVolumen.Text) / 3.785);
		this.lblResultadosGalones.Text = "La medida en galones es de: " + this.galon.ToString() + " galones";
	}
}