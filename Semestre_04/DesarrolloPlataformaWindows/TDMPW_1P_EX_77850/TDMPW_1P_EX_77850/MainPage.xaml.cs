namespace TDMPW_1P_EX_77850;

public partial class MainPage : ContentPage
{
	public MainPage()
	{
		InitializeComponent();
	}

	// Metodo que crea una nueva navegacion que lleva a la pagina de conversion de potencia de watts
	private async void WattsClicked(object sender, EventArgs e){
		await Navigation.PushAsync(new PotenciaWatts());
	}

	// Metodo que crea una nueva navegacion que lleva a la pagina de conversion de potencia industrial
	private async void WIndustrialClicked(object sender, EventArgs e){
		await Navigation.PushAsync(new PotenciaIndustrialWatts());
	}
}

