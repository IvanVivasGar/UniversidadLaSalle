using MauiApp1;
namespace TDMPW_1P_PR02;

public partial class MainPage : ContentPage
{
	public MainPage()
	{
		InitializeComponent();
	}

	private async void onLongitudClicked(object sender, EventArgs e)
	{
		await Navigation.PushAsync(new CalcularView());
	}
	private async void onVolumenClicked(object sender, EventArgs e)
	{
		await Navigation.PushAsync(new CalcularViewVol());
	}
}

