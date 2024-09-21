namespace TDMPW_2P_PR04;

public partial class DolarPage : ContentPage
{
	public DolarPage()
	{
		InitializeComponent();
	}

	public void ClickedConvertirDolar(object sender, EventArgs e)
	{
		double resultadoConversion = double.Parse(this.entryDolar.Text) * 0.061;
		this.lblResultadoDolar.Text = this.entryDolar.Text + " pesos equivalen a: " + resultadoConversion + " dolares.";
	}
}