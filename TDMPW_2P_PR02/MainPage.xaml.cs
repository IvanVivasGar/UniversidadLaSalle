namespace TDMPW_2P_PR02;

public partial class MainPage : TabbedPage
{
	public MainPage()
	{
		InitializeComponent();
	}

	public void ClickedConvertirLibra(object sender, EventArgs e)
	{
		double resultadoConversion = double.Parse(this.entryLibra.Text) * 0.048;
		this.lblResultadoLibra.Text = this.entryLibra.Text + " pesos equivalen a: " + resultadoConversion + " libras.";
	}

	public void ClickedConvertirEuro(object sender, EventArgs e)
	{
		double resultadoConversion = double.Parse(this.entryEuro.Text) * 0.057;
		this.lblResultadoEuro.Text = this.entryEuro.Text + " pesos equivalen a: " + resultadoConversion + " euros.";
	}

	public void ClickedConvertirDolar(object sender, EventArgs e)
	{
		double resultadoConversion = double.Parse(this.entryDolar.Text) * 0.061;
		this.lblResultadoDolar.Text = this.entryDolar.Text + " pesos equivalen a: " + resultadoConversion + " dolares.";
	}
}

