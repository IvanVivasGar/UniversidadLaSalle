namespace TDMPW_1P_PR01;

public partial class MainPage : ContentPage
{
	double celsius;
	double farenheit;

	public MainPage()
	{
		InitializeComponent();
	}

	private void ClickedACelsius(object sender, EventArgs s)
	{
		celsius = (double.Parse(this.entradaDatosCelsius.Text) - 32) * 5 / 9;
		this.lblResultadoCelsius.Text = "Los grados en Celsius son de: " + this.celsius.ToString();
		this.lblResultadoKelvin.Text = "Los grados en Kelvin son de: " + (this.celsius + 273.15).ToString();
	}
}

