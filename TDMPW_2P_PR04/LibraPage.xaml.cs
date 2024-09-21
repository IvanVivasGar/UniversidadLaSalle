namespace TDMPW_2P_PR04;

public partial class LibraPage : ContentPage
{
	public LibraPage()
	{
		InitializeComponent();
	}

	public void ClickedConvertirLibra(object sender, EventArgs e)
	{
		double resultadoConversion = double.Parse(this.entryLibra.Text) * 0.048;
		this.lblResultadoLibra.Text = this.entryLibra.Text + " pesos equivalen a: " + resultadoConversion + " libras.";
	}
}