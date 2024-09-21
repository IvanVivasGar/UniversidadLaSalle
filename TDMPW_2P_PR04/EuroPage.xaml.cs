namespace TDMPW_2P_PR04;

public partial class EuroPage : ContentPage
{
	public EuroPage()
	{
		InitializeComponent();
	}

	public void ClickedConvertirEuro(object sender, EventArgs e)
	{
		double resultadoConversion = double.Parse(this.entryEuro.Text) * 0.057;
		this.lblResultadoEuro.Text = this.entryEuro.Text + " pesos equivalen a: " + resultadoConversion + " euros.";
	}
}