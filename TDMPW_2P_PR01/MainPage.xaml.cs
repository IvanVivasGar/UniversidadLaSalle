namespace TDMPW_2P_PR01;

public partial class MainPage : ContentPage
{
	private void ClickedCalcular(object sender, EventArgs e){
		double iva = (double.Parse(this.entryTasa.Text) * double.Parse(this.entryMonto.Text)) * 100;
		this.lblResultado.Text = "El IVA es de: " + iva;
	}
}